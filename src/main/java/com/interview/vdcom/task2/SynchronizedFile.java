package com.interview.vdcom.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedFile {
    private static volatile int count;

    private void createFileWithZero() {
        try (FileWriter writer = new FileWriter("out.txt")) {
            writer.write("0");
        } catch (IOException e) {
            throw new UnsupportedOperationException("Not write");
        }
    }

    public int getNumberIn() {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void readFromFileAndCount(int number) throws InterruptedException, ExecutionException {
        createFileWithZero();
        if (number % 2 == 0) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Callable<Integer> taskThreadOne = new Counter();
            Callable<Integer> taskThreadTwo = new Counter();
            while (count < number) {
                count = executorService.submit(taskThreadOne).get();
                count = executorService.submit(taskThreadTwo).get();
            }
            executorService.shutdown();
        } else {
            System.out.println("The number must be a multiple of 2");
        }
    }

}