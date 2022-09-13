package com.interview.vdcom.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class SynchronizedFileConsoleTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void readFromFileAndCountTest() throws ExecutionException, InterruptedException {
        SynchronizedFile synchronizedFile = new SynchronizedFile();
        synchronizedFile.readFromFileAndCount(4);
        assertEquals("Fom file 0 Thread pool-1-thread-1 New value 1\r\n" +
                "Fom file 1 Thread pool-1-thread-2 New value 2\r\n" +
                "Fom file 2 Thread pool-1-thread-1 New value 3\r\n" +
                "Fom file 3 Thread pool-1-thread-2 New value 4\r\n", output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}