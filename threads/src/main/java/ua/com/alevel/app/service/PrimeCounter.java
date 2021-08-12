package ua.com.alevel.app.service;

import java.util.List;

public class PrimeCounter extends Thread {

    private int count = 0;
    private final List<Integer> numbers;

    public PrimeCounter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (Integer num : numbers) {
            if (isPrime(num))
                count = count + 1;
        }
    }

    private boolean isPrime(int number) {
        int tmp;
        boolean isPrime = true;

        for (int i = 2; i <= number / 2; i++) {
            tmp = number % i;
            if (tmp == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public int getCount() {
        return count;
    }
}
