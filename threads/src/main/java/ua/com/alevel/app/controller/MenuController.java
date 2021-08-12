package ua.com.alevel.app.controller;

import ua.com.alevel.app.service.PrimeCounter;
import ua.com.alevel.app.service.HelloPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    public void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Choose an action:\n" +
                    "1 -> print Hello from threads\n" +
                    "2 -> count prime numbers\n" +
                    "0 -> exit");
            try {
                switch (reader.readLine()) {
                    case "1":
                        printHello();
                        break;
                    case "2":
                        countPrimeNumbers();
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.err.println("Wrong input");
                }
            } catch (IOException e) {
                System.err.println("Something went wrong. Please, try again");
            }
        }
    }

    private void printHello() {
        for (int i = 0; i < 50; i++) {
            HelloPrinter printer = new HelloPrinter();
            printer.setNumber((50 - i));
            printer.start();
        }
    }

    private void countPrimeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            numbers.add(i);
        }

        List<Integer> numbers1 = numbers.subList(0, numbers.size() / 2);
        List<Integer> numbers2 = numbers.subList(numbers.size() / 2, numbers.size());

        PrimeCounter primeCounter1 = new PrimeCounter(numbers1);
        primeCounter1.start();

        PrimeCounter primeCounter2 = new PrimeCounter(numbers2);
        primeCounter2.start();

        try {
            primeCounter1.join();
            primeCounter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Amount of prime numbers = " + (primeCounter1.getCount() + primeCounter2.getCount()));
    }
}
