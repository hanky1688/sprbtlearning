package com.hanky.study.context;


import com.hanky.study.strategy.TransStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransStrategyContext {
    private Map<String,TransStrategy> strategyMap = new HashMap<>();

    public TransStrategy register(String key, TransStrategy strategy){
        return strategyMap.put(key, strategy);
    }

    public TransStrategy resolve(String key){
        return strategyMap.get(key);
    }
}
