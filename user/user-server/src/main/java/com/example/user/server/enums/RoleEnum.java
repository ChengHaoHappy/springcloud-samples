package com.example.user.server.enums;

import lombok.Getter;

/**
 * Created By ChengHao On 2020/2/10
 */
@Getter
public enum RoleEnum {
    BUYER(1,"买家"),
    SELLER(2,"卖家")
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
