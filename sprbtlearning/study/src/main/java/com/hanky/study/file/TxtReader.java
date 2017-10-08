package com.hanky.study.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
public class TxtReader {
    public static void main(String[] args) {
        //test();

//        writeFile();
        readFile();


    }

    private static void test() {
        String filePath = "D:\\testspace\\accountlist.txt";
        File file = new File(filePath);

        String newFilePath = "D:\\testspace\\file\\target.txt";

        int line = 1;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tmpString = null;
            while (null != (tmpString = reader.readLine()) && line < 3) {
                dealLine(tmpString);

                write(newFilePath, true, tmpString);

                line++;


            }


        } catch (FileNotFoundException e) {
            log.error("文件读取失败", e);
        } catch (IOException e) {
            log.error("文件内容读取失败", e);
        }
    }

    private static void dealLine(String tmpString) {

    }

    private static void readFile(){
        String filePath = "D:\\testspace\\accountlist.txt";
        readFile(filePath);
    }
    private static void readFile(String filePath){

        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("GB2312"));
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                sb.append(line).append("\r\n");

                if (count % 10 ==0){
                    writeFile(StandardCharsets.UTF_8,sb.toString(),count/10);
                    sb.delete(0,sb.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile( Charset charset, String content,int no) {
        String filePath = "D:\\testspace\\file\\test_"+no+".txt";
        writeFile(filePath,charset,content);
    }


    private static void writeFile(){
        String content = "this is write file test";
        String filePath = "D:\\testspace\\file\\test.txt";
       // writeFile(filePath,content);
    }

    private static void writeFile(String filePath,Charset charset,String content) {
        System.out.println("TxtReader.writeFile");
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
            osw.write(content);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(String filePath, boolean append, String content) {
        System.out.println("TxtReader.write");

        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            log.error("文件路径错误,创建文件异常 filePath={}", filePath, e);
            return;
        }

        PrintWriter printWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "GB2312"));
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.write(content);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
