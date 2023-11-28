package com.fmm.jk_lib.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用 notify和wait 实现生产者和消费者模型
 */
public class ProducerConsumer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait(); // 等待消费者消费，缓冲区不足时等待
                }

                System.out.println("生产者生产: " + value);
                buffer.offer(value++);

                notify(); // 通知消费者可以消费了

                Thread.sleep(1000); // 模拟生产过程
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait(); // 等待生产者生产，缓冲区为空时等待
                }

                int val = buffer.poll();
                System.out.println("消费者消费: " + val);

                notify(); // 通知生产者可以生产了

                Thread.sleep(1000); // 模拟消费过程
            }
        }
    }


    public static void test() {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}


