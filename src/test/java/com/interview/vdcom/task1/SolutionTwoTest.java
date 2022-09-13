package com.interview.vdcom.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SolutionTwoTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void printFooBarTest() {
        SolutionTwo solutionTwo = new SolutionTwo();
        solutionTwo.printFooBar(15);
        assertEquals("1\r\n" +
                "2\r\n" +
                "Foo\r\n" +
                "4\r\n" +
                "Bar\r\n" +
                "Foo\r\n" +
                "7\r\n" +
                "8\r\n" +
                "Foo\r\n" +
                "Bar\r\n" +
                "11\r\n" +
                "Foo\r\n" +
                "13\r\n" +
                "14\r\n" +
                "FooBar\r\n", output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}