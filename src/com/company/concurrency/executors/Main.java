package com.company.concurrency.executors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by princegupta on 19/08/17.
 */
public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Set<Callable<String>> callables = new HashSet<>();

        callables.add(() -> "Task 1");
        callables.add(() -> "Task 2");
        callables.add(() -> "Task 3");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> results = executorService.invokeAll(callables);

        results.forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
