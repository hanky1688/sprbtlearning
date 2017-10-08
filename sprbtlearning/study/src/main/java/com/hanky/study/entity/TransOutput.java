package com.hanky.study.entity;

import com.hanky.base.errorcode.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransOutput extends HandlerOutput {

    public TransOutput(){}
    public TransOutput(ErrorCode errorCode){super(errorCode);}
}
