package com.interview.vdcom.task1;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTwo {

    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();
        int number = solutionTwo.getNumberIn();
        solutionTwo.printFooBar(number);
    }

    private int getNumberIn() {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printFooBar(int number) {
        List<Integer> numberList = IntStream.rangeClosed(1, number).boxed().collect(Collectors.toList());
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                System.out.println("FooBar");
            } else if (currentNumber % 3 == 0) {
                System.out.println("Foo");
            } else if (currentNumber % 5 == 0) {
                System.out.println("Bar");
            } else {
                System.out.println(currentNumber);
            }
        }
    }

}