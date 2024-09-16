package com.vti.be.form;

import lombok.Data;

@Data
public class PostFilterForm {
    private Integer idUser;
    private int type ; // 0 : all ; 1 câu hỏi hay ; 2 câu hỏi chă trả lời; 3 của bạn ; 4 : đã lưu
    private int grade ;
}
