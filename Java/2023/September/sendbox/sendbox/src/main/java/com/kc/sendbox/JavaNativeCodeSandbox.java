package com.kc.sendbox;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import com.kc.sendbox.model.ExecuteCodeRequest;
import com.kc.sendbox.model.ExecuteCodeResponse;
import com.kc.sendbox.model.ExecuteMessage;
import com.kc.sendbox.model.JudgeInfo;
import com.kc.sendbox.utils.ProcessUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class JavaNativeCodeSandbox implements CodeSandbox {
    public static final String GLOBAL_CODE_DIR_NAME = "tmpcode";
    public static final String GLOBAL_JAVA_CLASS_NAME = "Main.java";
    public static final long TIME_OUT = 5000L;
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();
        //得到用户的工作目录
        String userDir = System.getProperty("user.dir");
        //得到存放代码的目录
        String globalCodePathName = userDir + File.separator + GLOBAL_CODE_DIR_NAME;
        //如果文件夹不存在,则创建
        if (!FileUtil.exist(globalCodePathName)) {
            FileUtil.mkdir(globalCodePathName);
        }
        //将用户的代码进行隔离
        String userCodeParentPath = globalCodePathName + File.separator + UUID.randomUUID();
        String userCodePath = userCodeParentPath + File.separator + GLOBAL_JAVA_CLASS_NAME;
        File userCodeFile = FileUtil.writeString(code, userCodePath, StandardCharsets.UTF_8);
        //编译代码
        String compileCmd = String.format("javac -encoding utf-8 %s", userCodeFile.getAbsolutePath());
        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd);
            ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(compileProcess, "编译");
            System.out.println(executeMessage);
        } catch (Exception e) {
            return getErrorResponse(e);
        }
        //执行代码,得到输出结果
        List<ExecuteMessage> executeMessageList = new ArrayList<ExecuteMessage>();
        for (String inputArgs : inputList) {
            try {
                String rumCmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s Main %s", userCodeParentPath, inputArgs);
                Process runExec = Runtime.getRuntime().exec(rumCmd);
                // 超时控制
                new Thread(() -> {
                    try {
                        Thread.sleep(TIME_OUT);
                        System.out.println("超时了，中断");
                        runExec.destroy();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(runExec, "运行");
                executeMessageList.add(executeMessage);
                System.out.println(executeMessage);
            } catch (IOException e) {
               return getErrorResponse(e);
            }
        }
        //整理输出
        long maxTime = 0;
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> outputList = new ArrayList<>();
        for (ExecuteMessage executeMessage : executeMessageList) {
            String errorMessage = executeMessage.getErrorMessage();
            if (StrUtil.isAllNotBlank(errorMessage)) {
                executeCodeResponse.setMessage(errorMessage);
                executeCodeResponse.setStatus(3);
                break;
            }
            outputList.add(executeMessage.getMessage());
            Long time = executeMessage.getTime();
            if (time != null) {
                maxTime = Math.max(maxTime, time);
            }
        }
        //正常运行
        if (outputList.size() == executeMessageList.size()) {
            executeCodeResponse.setStatus(1);
        }
        executeCodeResponse.setOutputList(outputList);
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setTime(maxTime);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        //文件清理
        if (userCodeFile.getParentFile()!=null) {
            boolean del = FileUtil.del(userCodeParentPath);
            System.out.println("删除:"+(del?"成功":"失败"));
        }
        return null;
    }

    public static void main(String[] args) {
        JavaNativeCodeSandbox javaNativeCodeSandbox = new JavaNativeCodeSandbox();
        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest();
        executeCodeRequest.setInputList(Arrays.asList("1 2", "1 3"));
        String code = ResourceUtil.readStr("testCode.simpleComputeArgs/Main.java", StandardCharsets.UTF_8);
        executeCodeRequest.setCode(code);
        executeCodeRequest.setLanguage("java");
        ExecuteCodeResponse executeCodeResponse = javaNativeCodeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);
    }

    /**
     * 获取错误响应
     * @param e
     * @return
     */
    private ExecuteCodeResponse getErrorResponse(Throwable e) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(new ArrayList<String>());
        executeCodeResponse.setMessage(e.getMessage());
        executeCodeResponse.setStatus(2);
        executeCodeResponse.setJudgeInfo(new JudgeInfo());
        return executeCodeResponse;
    }
}
