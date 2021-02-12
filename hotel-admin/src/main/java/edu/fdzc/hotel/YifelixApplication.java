package edu.fdzc.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author yifelix
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class YifelixApplication {

    public static void main(String[] args) {
        SpringApplication.run(YifelixApplication.class, args);
    }

}
