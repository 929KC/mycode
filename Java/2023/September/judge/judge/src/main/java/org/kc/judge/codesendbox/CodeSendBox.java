package org.kc.judge.codesendbox;

import org.kc.judge.model.ExecuteCodeRequest;
import org.kc.judge.model.ExecuteCodeResponse;


/**
 * 代码沙箱接口
 */
public interface CodeSendBox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest request);

}
