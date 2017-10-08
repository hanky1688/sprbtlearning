package com.hanky.study;


        import com.hanky.study.constant.Const;
        import com.hanky.study.entity.TransInput;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.core.annotation.Order;
        import org.springframework.stereotype.Component;

/**
 * 该类可以在springboot启动是, 进行操作
 * @Order: 启动时执行的顺序, 小的优先执行
 * @author wenbronk
 * @time 2017年4月6日  下午1:40:17  2017
 */

@Component
@Order(value=2)
public class MyStartupRunner implements CommandLineRunner {

    /**
     * 执行的方法,
     * args为执行时传入的参数,
     * 可用: SpringApplication.run(App.class, new String[]{"hello,","林峰"});
     * 或者: eclipse中给java应用传args参数的方法如下：
     1、先写好Java代码，比如文件名为IntArrqy.java；
     2、在工具栏或菜单上点run as下边有个Run Configuration；
     3、在弹出窗口点选第二个标签arguments；
     4、把你想输入的参数写在program argumenst就可以了，多个参数使用空格隔开。
     完成后点run即可通过运行结果看到参数使用情况了。
     */
    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("开机服务执行的操作....");
    }
}