package com.hanky.study.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hanky.base.errorcode.ErrorCode;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

@Data
@Serialization
public abstract class HandlerOutput {
    public HandlerOutput(){}

    public HandlerOutput(ErrorCode errorCode){
        this.retCode = errorCode.code();
        this.retMsg = errorCode.message();
    }


    private String retCode;
    private String retMsg;

    public ErrorCode getErrorCode(){
        return new ErrorCode(this.retCode,this.retMsg);
    }
}
