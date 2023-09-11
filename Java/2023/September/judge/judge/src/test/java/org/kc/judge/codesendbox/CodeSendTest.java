package org.kc.judge.codesendbox;



import org.junit.jupiter.api.Test;
import org.kc.judge.CodeSendFactory;
import org.kc.judge.model.ExecuteCodeRequest;
import org.kc.judge.model.ExecuteCodeResponse;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootTest(classes = Math.class )
public class CodeSendTest {

    @Test
    void testSendBox() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSendBox codeSendBox = CodeSendFactory.newInstance(type);
            String code = "int main() { }";
            String language = "Java";
            List<String> inputList= Arrays.asList("1 2","2 3");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().code(code).language(language).inputs(inputList).build();
            ExecuteCodeResponse executeCodeResponse = codeSendBox.executeCode(executeCodeRequest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSendBox codeSendBox = CodeSendFactory.newInstance(type);
            String code = "int main() { }";
            String language = "Java";
            List<String> inputList= Arrays.asList("1 2","2 3");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().code(code).language(language).inputs(inputList).build();
            ExecuteCodeResponse executeCodeResponse = codeSendBox.executeCode(executeCodeRequest);
        }
    }

    /**
     *参数配置文件化
     */
    @Test
    void testSendBoxByValue() {

    }
}
