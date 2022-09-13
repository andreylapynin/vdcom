package com.interview.vdcom.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class Counter implements Callable<Integer> {
    private static File file = new File("out.txt");
    private int count;

    @Override
    public Integer call() {
        synchronized (file) {
            try (BufferedReader br = Files.newBufferedReader(Paths.get("out.txt"))) {
                count = Integer.parseInt(br.readLine());
                System.out.print("Fom file " + count + " ");
                System.out.print("Thread " + Thread.currentThread().getName() + " ");
                count++;
                System.out.println("New value " + count);
                FileWriter fw = new FileWriter("out.txt");
                fw.write(String.valueOf(count));
                fw.close();
                return count;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

}