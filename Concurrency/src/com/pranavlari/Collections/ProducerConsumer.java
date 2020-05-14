package com.pranavlari.Collections;

import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}

class Message {
    private String msg;
    private boolean empty = true;

    public synchronized String read() throws InterruptedException {
        while (empty) {
            wait();
        }
        empty = true;
        notifyAll();
        return this.msg;


    }

    public synchronized void write(String msg) throws InterruptedException {
        while (!empty) {
            wait();
        }
        this.msg = msg;
        empty = false;
        notifyAll();
    }


}

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] meaages = {
                "hello there",
                "i am pranav lari",
                "whats up"
        };
        Random random = new Random();

        for(String msg : meaages) {
            try {
                message.write(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            message.write("finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            for(String msg = message.read(); !msg.equalsIgnoreCase("finished"); msg = message.read()) {
                System.out.println(msg);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
