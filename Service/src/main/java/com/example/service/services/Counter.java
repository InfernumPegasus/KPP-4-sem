package com.example.service.services;

import com.example.service.logger.MyLogger;
import lombok.Getter;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Service;

@Service
public class Counter {

    @Getter private long count;

    public synchronized void increase() {
        count++;
        MyLogger.log(Level.INFO, "Solution Service requests amount is: " + count);
    }
}