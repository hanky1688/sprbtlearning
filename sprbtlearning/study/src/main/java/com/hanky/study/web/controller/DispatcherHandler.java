package com.hanky.study.web.controller;

import com.hanky.study.TransHandler;
import com.hanky.study.constant.Const;
import com.hanky.study.entity.TransInput;
import com.hanky.study.entity.TransOutput;
import com.hanky.study.web.message.DispatcherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatcherHandler {

    @Autowired
    private TransHandler transHandler;

    @RequestMapping("/")
    public DispatcherResponse dispatch(){

//       final TransHandler transHandler = SpringUtil.getBean(TransHandler.class);

        TransInput input = TransInput.builder().
                transType(Const.TransType.WITHDRAW)
                .build();

        TransOutput output = transHandler.doHandle(input);

        DispatcherResponse response = new DispatcherResponse();
        populateRes(output,response);

        return response;
    }

    private void populateRes(TransOutput output, DispatcherResponse response) {
        response.setRetCode(output.getRetCode());
        response.setRetMsg(output.getRetMsg());
    }


}
