package com.fmm.jk_lib.thread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 *类说明：演示CyclicBarrier用法,共4个子线程，他们全部完成工作后，交出自己结果，
 *再被统一释放去做自己的事情，而交出的结果被另外的线程拿来拼接字符串
 */
public class UseCyclicBarrier {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(6,new CollectThread());
    private static ConcurrentHashMap<String,Long> resultMap
            = new ConcurrentHashMap<>();//存放子线程工作结果的容器

    public static void main(String[] args) {
        for(int i=0;i<=4;i++){
            Thread thread = new Thread(new SubThread());
            thread.start();
        }
        try {
            cyclicBarrier.await();
            System.out.println("Thread_main ....do its business ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 汇总的任务
     */
    private static class CollectThread implements Runnable{

        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for(Map.Entry<String,Long> workResult:resultMap.entrySet()){
            	result.append("["+workResult.getValue()+"]");
            }
            System.out.println(" the result = "+ result);
            System.out.println("do other business........");
        }
    }

    /**
     * 相互等待的线程
     */
    private static class SubThread implements Runnable{

        @Override
        public void run() {
        	long id = Thread.currentThread().getId();
            resultMap.put(Thread.currentThread().getId()+"",id);
            Random r = new Random();
            try {
                	Thread.sleep(1000+id);
                	System.out.println("Thread_"+id+" ....do something ");
                cyclicBarrier.await();
            	Thread.sleep(1000+id);
                System.out.println("Thread_"+id+" ....do its business ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
