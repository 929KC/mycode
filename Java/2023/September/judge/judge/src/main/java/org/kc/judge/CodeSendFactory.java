package org.kc.judge;


import org.kc.judge.codesendbox.CodeSendBox;
import org.kc.judge.impl.ExampleCodeSendBox;
import org.kc.judge.impl.RemoteExampleCodeSendBox;
import org.kc.judge.impl.ThirdPartyCodeSendBox;

/**
 * 代码沙箱工厂
 */
public class CodeSendFactory {
    /**
     * 静态
     * @param type
     * @return
     */
    public static CodeSendBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSendBox();
            case "remote":
                return new RemoteExampleCodeSendBox();
            case "thirdParty":
                return new ThirdPartyCodeSendBox();
            default:
                return new ExampleCodeSendBox();
        }
    }
}
