package com.mindtree.scheduler.service;

import com.mindtree.scheduler.entity.Temperature;

import java.util.Map;

public interface ThreadService {
    public Map<Integer, Temperature> writeDataToMap(int n) throws InterruptedException;
}
