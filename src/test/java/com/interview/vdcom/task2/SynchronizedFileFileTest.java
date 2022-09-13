package com.interview.vdcom.task2;

import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertArrayEquals;

public class SynchronizedFileFileTest {

    @Before
    public void createTestFile() {
        try (FileWriter writer = new FileWriter("outTest.txt")) {
            writer.write("4");
        } catch (IOException e) {
            throw new UnsupportedOperationException("Not write");
        }
    }

    @Test
    public void readFromFileAndCountTest() throws ExecutionException, InterruptedException, IOException {
        SynchronizedFile synchronizedFile = new SynchronizedFile();
        synchronizedFile.readFromFileAndCount(4);
        byte[] out = Files.readAllBytes(Paths.get("out.txt"));
        byte[] outTest = Files.readAllBytes(Paths.get("outTest.txt"));
        assertArrayEquals(outTest, out);
    }

}