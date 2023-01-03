package com.kc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/11/26 20:09
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author {
    private Long id;
    private String name;
    private String  intro;
    private Integer age;
    private List<Book> books;

}
