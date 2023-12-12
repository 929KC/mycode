package com.kc.hotel.model.dto;

import com.kc.hotel.model.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnCommentDTO {

    private ReturnUserDTO user;
    private Comment comment;


}
