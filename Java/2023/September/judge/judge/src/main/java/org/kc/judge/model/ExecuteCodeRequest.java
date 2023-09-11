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
public class ExecuteCodeRequest {
    private  String code;
    private  String language;
    private List<String> inputs;
}
