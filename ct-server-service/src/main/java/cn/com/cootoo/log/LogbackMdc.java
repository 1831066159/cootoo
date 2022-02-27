package cn.com.cootoo.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 *
 * Created by system
 * Date 2020/4/3 5:30 下午
 * Description
 */
@Slf4j
public class LogbackMdc {

    // logback 的MDC ，可以自定义日志字段, 在logback.xml 中使用 %X{myFlag} 打印

    public static void main(String[] args) {
        log.info("自定义日志字段myFlag");
        MDC.put("myFlag","【FLAG_9】");

        MDC.clear();//清除


    }

}
