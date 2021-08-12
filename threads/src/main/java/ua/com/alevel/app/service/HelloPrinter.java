package ua.com.alevel.app.service;

public class HelloPrinter extends Thread{

    private int number;

    @Override
    public void run() {
        try {
            Thread.sleep(number * 10L * Runtime.getRuntime().availableProcessors());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
