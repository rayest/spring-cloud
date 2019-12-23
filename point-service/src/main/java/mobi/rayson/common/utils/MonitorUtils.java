package mobi.rayson.common.utils;

import io.prometheus.client.Gauge;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 1:39 PM
 *  Description:
 **/
@Service
public class MonitorUtils {
  private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

  /**
   * 线程池监控
   */
  public void monitorThread(String metricName, ThreadPoolExecutor executor) {
    Gauge gauge = Gauge.build().name(metricName).labelNames("size").help(metricName).register();
    executorService.scheduleAtFixedRate(() -> {
      gauge.labels("poolSize").set(executor.getPoolSize());
      gauge.labels("activeSize").set(executor.getActiveCount());
      gauge.labels("queueSize").set(executor.getQueue().size());
      gauge.labels("largestSize").set(executor.getLargestPoolSize());
    }, 1, 5, TimeUnit.SECONDS);
  }
}
