package com.interview.vdcom.task1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SolutionOne {

    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        int number = solutionOne.getNumberIn();
        solutionOne.printFooBar(number);
    }

    private int getNumberIn() {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printFooBar(int number) {
        IntStream.rangeClosed(1, number).mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FooBar" : "Foo") : (i % 5 == 0 ? "Bar" : i))
                .forEach(System.out::println);
    }

}