package com.kunxia;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill){
        this.queue=queue;
        this.poisonPill=poisonPill;
    }

    @Override
    public void run() {
        try{
            while(true){
                Integer number = queue.take();
                if(number.equals(poisonPill)){
                    System.out.println(Thread.currentThread().getName()+" is killed by poison pill"+poisonPill);
                    return;
                }
                System.out.println(Thread.currentThread().getName()+" result: "+number);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();;
        }
    }
}
