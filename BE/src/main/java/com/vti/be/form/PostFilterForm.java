package com.vti.be.form;

import lombok.Data;

@Data
public class PostFilterForm {
    private Integer idUser;
    private int type = 0;  // Mặc định là 0 (all)
    private int grade = 0; // Mặc định là 0

    // Bạn cũng có thể thêm constructor không tham số nếu cần
    public PostFilterForm() {
        this.type = 0;  // Mặc định là 0
        this.grade = 0; // Mặc định là 0
    }
}
