package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int task_id;
    private String cus_name;
    private String cus_phone;
    private String task_name;
    private String task_no;
    private String task_status;
    //下单时间
    private LocalDateTime task_time;

}
