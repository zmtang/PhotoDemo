package com.example.photodemo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 *
 */
public enum GradeEnum {

    PRIVATE(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高中");

    @EnumValue  // 标记数据库存的值是 code
    private Integer code;
    private String value;
    GradeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
