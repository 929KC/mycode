package org.kc.judge.impl;

import org.kc.judge.codesendbox.CodeSendBox;
import org.kc.judge.model.ExecuteCodeRequest;
import org.kc.judge.model.ExecuteCodeResponse;

public class ExampleCodeSendBox implements CodeSendBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {
        System.out.println("示例代码沙箱");
        return null;
    }
}
