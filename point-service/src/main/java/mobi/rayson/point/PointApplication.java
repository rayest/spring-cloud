package mobi.rayson.point;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:45
 *  Description:
 **/
@EnableEurekaClient
@MapperScan(basePackages = "mobi.rayson")
@SpringBootApplication
public class PointApplication {
    public static void main(String[] args) {
        SpringApplication.run(PointApplication.class, args);
    }
}
