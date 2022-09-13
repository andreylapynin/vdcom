package com.interview.vdcom.task1;

import java.util.Scanner;

public class SolutionThree {

    public static void main(String[] args) {
        SolutionThree solutionThree = new SolutionThree();
        solutionThree.printFooBar(1, solutionThree.getNumberIn());
    }

    private int getNumberIn() {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printFooBar(int currentNumber, int numberBreak) {
        if (currentNumber == numberBreak + 1) {
            return;
        }
        if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
            System.out.println("FooBar");
        } else if (currentNumber % 3 == 0) {
            System.out.println("Foo");
        } else if (currentNumber % 5 == 0) {
            System.out.println("Bar");
        } else {
            System.out.println(currentNumber);
        }
        printFooBar(++currentNumber, numberBreak);
    }

}