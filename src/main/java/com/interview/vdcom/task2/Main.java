package com.interview.vdcom.task2;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SynchronizedFile synchronizedFile = new SynchronizedFile();
        synchronizedFile.readFromFileAndCount(synchronizedFile.getNumberIn());
    }

}