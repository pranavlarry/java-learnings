package com.pranavlari.Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceStudy {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello from call 1";
            }
        };

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello from call 2";
            }
        };

        Callable<String> callable3 =new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new NullPointerException();
            }
        };

        Callable<String> callable4 =new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new NullPointerException();
            }
        };

        String invokeAnyFuture = executorService.invokeAny(Arrays.asList(callable2,callable3,callable4));

        System.out.println(invokeAnyFuture);

        List<? extends Callable<String>> callables = Arrays.asList(callable1 , callable2);

        List<Future<String>> futures = executorService.invokeAll(callables);

        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
