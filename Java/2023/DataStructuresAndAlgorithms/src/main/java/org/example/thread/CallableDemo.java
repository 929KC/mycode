package org.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 10; i++) {
            //executorService.submit()会返回Future对象
            list.add(executorService.submit(new TaskWithResult(i) ));
        }
        for (Future<String> future : list) {
            try {
                System.out.println(future.get());
                System.out.println(future.isDone());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }finally {
                executorService.shutdown();
            }
        }
    }
}
