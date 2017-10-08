package com.hanky.study.strategy;

import com.hanky.base.errorcode.ErrorCode;
import com.hanky.study.constant.Const;
import com.hanky.study.context.TransStrategyContext;
import com.hanky.study.entity.TransInput;
import com.hanky.study.entity.TransOutput;
import org.springframework.stereotype.Component;

@Component
public class WithdrawTransStrategy extends TransStrategy {


    @Override
    public TransStrategy register(TransStrategyContext context) {
        return context.register(Const.TransType.WITHDRAW, this);
    }

    @Override
    public TransOutput process(TransInput input) {

        return new TransOutput(new ErrorCode("0002","WithdrawTransStrategy"));
    }
}
