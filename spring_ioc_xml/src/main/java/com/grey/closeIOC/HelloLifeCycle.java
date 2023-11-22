package com.grey.closeIOC;

import org.springframework.context.Lifecycle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class HelloLifeCycle implements Lifecycle {
    private volatile boolean running = false;
    private volatile boolean businessRunning = true;

    private ExecutorService executors = Executors.newFixedThreadPool(1);

    public HelloLifeCycle() {
        executors.execute(() -> {
            while (businessRunning) {
                //启动后,做业务需要做的事情
            }
        });
    }


    @Override
    public void start() {
        System.out.println("lifycycle start");
        running = true;
    }

    @Override
    public void stop() {
        businessRunning=false;
        System.out.println("lifycycle stop ,and stop the execute");
        executors.shutdown();
        try {
            executors.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}