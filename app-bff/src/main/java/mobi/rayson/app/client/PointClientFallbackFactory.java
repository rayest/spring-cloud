package mobi.rayson.app.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PointClientFallbackFactory implements FallbackFactory<PointClient> {

    @Override
    public PointClient create(Throwable cause) {
        log.info("服务请求异常 e: {}", cause.getMessage());
        return null;
    }
}
