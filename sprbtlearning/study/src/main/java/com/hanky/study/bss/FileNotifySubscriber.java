package com.hanky.study.bss;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.lineIterator;

public class FileNotifySubscriber {

    public void doHandle() {

        String filePath = "D:\\testspace\\accountlist.txt";

        final File file = new File(filePath);
        try {
            final LineIterator iterator = lineIterator(file, "GBK");

            final int pageSize = 5000;

            int pageCount = 0;
            int cursor = 0;
            int totalLineCount = 0;

            List<String> accountList = new ArrayList<>();


            List<BillDetail> billList = new ArrayList<>();


            while (iterator.hasNext()) {
                accountList.add(iterator.nextLine());
                billList.add(createBillDetail(iterator.nextLine()));
                cursor++;

                if (cursor > pageSize) {
                    //一页入库
                    totalLineCount += batchInsertAccountList(accountList);
                    pageCount++;
                    cursor = 0;
                    accountList.clear();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        //文件解析

        //文件入库

    }

    private BillDetail createBillDetail(String line) {
        //7626,	20170813,	￥15.00	财付通 永和大王
        String[] arr = line.split(",");
        BillDetail billDetail = new BillDetail();
        billDetail.setCardSuffix(arr[0]);
        billDetail.setTransDate(LocalDate.parse(arr[1].trim(),DateTimeFormatter.ofPattern("yyyyMMdd")));

        String other = arr[2].trim();
        final int firstSpacePos = other.indexOf(" ");
        final String amtStr = other.substring(1, firstSpacePos).trim();

//        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        final DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        System.out.println(amtStr);
        final String amt = decimalFormat.format(amtStr);
        billDetail.setAmount(new BigDecimal(amt));

        other = other.substring(firstSpacePos).trim();
        final int secondSpacePos = other.indexOf(" ");
        final String paymentCompany = other.substring(0, secondSpacePos).trim();
        final String remark = other.substring(secondSpacePos).trim();

        billDetail.setPaymentCompany(paymentCompany);
        billDetail.setRemark(remark);

        return billDetail;
    }

    private int batchInsertAccountList(List<String> accountList) {
        return 0;
    }

    public static void main(String[] args) {

        final LocalDate transDate = LocalDate.parse("20170813", DateTimeFormatter.ofPattern("yyyyMMdd"));

        String line ="7626, 20170813, ￥15.00 财付通 永和大王";
        FileNotifySubscriber subscriber = new FileNotifySubscriber();
        BillDetail billDetail = subscriber.createBillDetail(line);

        Gson gson = new Gson();

        System.out.println(gson.toJson(billDetail));

    }
}
