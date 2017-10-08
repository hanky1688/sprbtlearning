package com.hanky.study.web.message;

import lombok.Data;

@Data
public abstract class ControllerResponse {
    private String retCode;
    private String retMsg;
}
