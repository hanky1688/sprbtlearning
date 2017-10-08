package com.hanky.study.bss;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BillDetail {

    //7626,	20170813,	￥15.00	财付通 永和大王
    private String cardSuffix;
    private LocalDate transDate;
    private BigDecimal amount;
    private String paymentCompany;
    private String remark;
}
