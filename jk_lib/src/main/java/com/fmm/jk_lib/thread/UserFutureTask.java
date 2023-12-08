package com.fmm.jk_lib.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 是 Java 中用于表示可获取结果的任务的一种方式，通常用于异步执行任务并获取任务执行结果。
 */
public class UserFutureTask {

    public static void main(String[] args) {
        // 创建一个 Callable 对象，表示需要执行的任务
        Callable<Integer> callable = () -> {
            // 模拟一个耗时操作，比如网络请求或者复杂计算
            Thread.sleep(3000);
            return 42; // 返回一个结果
        };

        // 使用 Callable 对象创建 FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 使用 FutureTask 在新线程中执行任务
        new Thread(futureTask).start();

        // 可以在此处执行其他操作，不会阻塞主线程

        try {
            // 获取任务执行结果，如果任务还未完成会阻塞当前线程直到任务完成
            int result = futureTask.get();
            System.out.println("任务执行结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
