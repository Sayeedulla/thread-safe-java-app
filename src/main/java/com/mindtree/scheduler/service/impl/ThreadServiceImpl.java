package com.mindtree.scheduler.service.impl;

import com.mindtree.scheduler.entity.Temperature;
import com.mindtree.scheduler.service.ThreadService;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ThreadServiceImpl implements ThreadService {

    private static final ScheduledExecutorService SCHEDULED_THREAD_POOL_EXECUTOR = new ScheduledThreadPoolExecutor(10);
/*We use concurrentHashMap Here Because it is Thread safe and performs synchronization at the bucket
Level instead of the object level
                                                                                                      *  */
    private static final Map<Integer, Temperature> MAP = new ConcurrentHashMap<>();

    private static org.slf4j.Logger log=LoggerFactory.getLogger(ThreadServiceImpl.class);

    private synchronized void pushdataToMap(){
        Temperature temperature = new Temperature();
        temperature.setTemperature(new Random().nextInt(50) + "^C");
        MAP.put(new Random().nextInt(10000), temperature);
    }

    public Map<Integer, Temperature> writeDataToMap(int n)  {

        log.info("Current Time = " + new Date());
        for (int i = 0; i < n; i++) {
            SCHEDULED_THREAD_POOL_EXECUTOR.execute(() -> {

                   pushdataToMap();

            });
        }

        SCHEDULED_THREAD_POOL_EXECUTOR.shutdown();
        log.info("Finished all threads");

        return MAP;
    }
}
