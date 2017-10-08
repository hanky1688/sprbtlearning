package com.hanky.study.strategy;

import com.hanky.study.entity.TransInput;
import com.hanky.study.entity.TransOutput;
import com.hanky.study.context.TransStrategyContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public abstract class TransStrategy implements InitializingBean {

    @Autowired
    private TransStrategyContext context;


    public abstract TransStrategy register(TransStrategyContext context);

    @Override
    public void afterPropertiesSet() throws Exception {
        register(context);
    }

    public abstract   TransOutput process(TransInput input);

}
