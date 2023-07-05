package com.kc.onlineoj.compile;

/**
 * 每次编译+运行,称之为Task
 */
public class Task {
    // 存放临时文件的目录.
    private final String WORK_DIR = "./tmp/";
    // 编译代码的类名
    private final String CLASS = "Solution";
    // 编译代码的文件名
    private final String CODE = WORK_DIR + "Solution.java";
    private final String STDIN = WORK_DIR + "stdin.txt";
    private final String STDOUT = WORK_DIR + "stdout.txt";
    private final String STDERR = WORK_DIR + "stderr.txt";
    private final String COMPILE_ERROR = WORK_DIR + "compile_error.txt";

    public Answer compileAddRun(Question question){

    }

}
