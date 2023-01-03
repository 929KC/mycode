package com.bit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-20 19:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private int bookID ;
    private String bookName;
    private int bookCounts;
    private String detail;
}
