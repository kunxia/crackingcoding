package com.kunxia;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {


    public static void main(String[] args) {
        int BOUND = 10;
        int N_PRODUCERS = 4;
        int N_CONSUMERS = 4;
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumberProducer(queue, poisonPill, poisonPillerProducer)).start();
        }
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        new Thread(new NumberProducer(queue, poisonPill, poisonPillerProducer + mod)).start();
    }

}
