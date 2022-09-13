package com.interview.vdcom.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class Reader {

    public static List<Equality> readFile(String fileName) {
        List<Equality> equalities = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Equality currentEquality = createEntityFromLine(line);
                equalities.add(currentEquality);
            }
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return equalities;
    }

    private static Equality createEntityFromLine(String str) {
        String[] numValues = str.split(" ");
        return Equality.builder()
                .leftValue(parseDouble(numValues[0]))
                .leftUnit(new Unit(numValues[1]))
                .rightValue(numValues[3].equals("?") ? null : parseDouble(numValues[3]))
                .rightUnit(new Unit(numValues[4]))
                .build();
    }

}