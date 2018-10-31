package com.mindtree.scheduler.service;

import com.mindtree.scheduler.entity.Temperature;
import com.mindtree.scheduler.service.impl.ThreadServiceImpl;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.JUnit4;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;


@RunWith(JUnit4.class)
public class ThreadServiceTest {

    @Test
    public void TestThreadWritingDataToMap() throws InterruptedException {
        ThreadService threadService = new ThreadServiceImpl();
        Map<Integer,Temperature> map= threadService.writeDataToMap(10);
        Thread.sleep(1000);
        Assert.assertEquals(10, map.size());
        System.out.println("Test Executed Successfully");
    }

}
