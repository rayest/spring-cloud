package mobi.rayson.configuration;

import mobi.rayson.filter.PreRequestLogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-21
 *  Time: 上午11:08
 *  Description:
 **/
@Configuration
public class ZuulFilterConfiguration {

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }
}
