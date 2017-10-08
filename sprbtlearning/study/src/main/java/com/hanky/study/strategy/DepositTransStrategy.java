package com.hanky.study.strategy;

import com.hanky.study.constant.Const;
import com.hanky.study.entity.TransInput;
import com.hanky.study.entity.TransOutput;
import com.hanky.study.context.TransStrategyContext;
import org.springframework.stereotype.Component;

@Component
public class DepositTransStrategy extends TransStrategy{


    public TransStrategy register(TransStrategyContext context){
        return context.register(Const.TransType.DEPOSIT,this);
    }



    @Override
    public TransOutput process(TransInput input) {
        TransOutput output = new TransOutput();

        output.setRetCode("0001");
        output.setRetMsg("DepositTransStrategy");



        return output;
    }
}
