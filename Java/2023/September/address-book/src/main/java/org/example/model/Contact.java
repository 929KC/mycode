package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder //链式new对象
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 8217186376136331419L;
    /**
     * 联系人编号
     */
    private int num;
    private String name;
    private String phoneNum;
    private String qq;
    private String email;

}
