package org.kc.judge;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kc.judge.codesendbox.CodeSendBox;
import org.kc.judge.model.ExecuteCodeRequest;
import org.kc.judge.model.ExecuteCodeResponse;


@Slf4j
@AllArgsConstructor
public class CodeSendBoxProxy implements CodeSendBox {
    private final CodeSendBox codeSendBox;
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {
        log.info("代码沙箱请求信息"+request.toString());
        ExecuteCodeResponse executeCodeResponse = codeSendBox.executeCode(request);
        log.info("代码沙箱响应信息"+executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
