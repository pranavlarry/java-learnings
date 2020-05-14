package com.pranavlari.Collections;

public class Main {

    public static void main(String[] args) {
	    Thread aThread = new Thread(new AThread());

	    Thread anotherThread = new Thread(()->{
	        try {
                aThread.join(6000);
                System.out.println("A thread finished so iam executing");
            }
	        catch (InterruptedException e) {
                System.out.println("I can't wait!!");
            }
        });
	    anotherThread.start();
	    aThread.start();
	    //to interrupt sleeping threads
//	    aThread.interrupt();

    }
}

class AThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Hiii from a Thread");
        System.out.println("I am going to sleep");

        try {
            Thread.sleep(5000);
            System.out.println("I am a wake!!");
        }
        catch (InterruptedException e) {
            System.out.println("I was woken up!!");
            return;
        }
    }
}
