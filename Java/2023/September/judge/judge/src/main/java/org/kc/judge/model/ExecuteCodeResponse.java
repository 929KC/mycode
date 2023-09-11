package org.kc.judge.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExecuteCodeResponse {
    private List<String> outputList;
    private String  status;

    private String message;
    private JudgeInfo info;

}
