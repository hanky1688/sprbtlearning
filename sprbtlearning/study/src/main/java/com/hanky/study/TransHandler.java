package com.hanky.study;

import com.hanky.study.context.TransStrategyContext;
import com.hanky.study.entity.TransInput;
import com.hanky.study.entity.TransOutput;

import com.hanky.study.strategy.TransStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransHandler {
    @Autowired
    protected TransStrategyContext context;

    public TransOutput doHandle(TransInput input){
        TransOutput output = new TransOutput();
        final String transType = input.getTransType();
        final TransStrategy transStrategy = context.resolve(transType);
        try {
            return transStrategy.process(input);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
