package com.interview.vdcom.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static void main(String[] args) {
        List<Equality> equalities = Reader.readFile("convert.txt");
        Base unitBase = Base.fromEqualityList(equalities);
        List<Equality> notFilledEqualities = equalities.stream()
                .filter(equality -> equality.getRightValue() == null)
                .collect(Collectors.toList());
        for (Equality equality : notFilledEqualities) {
            Double rightValue = unitBase.findValue(equality);
            equality.setRightValue(rightValue);
        }
        writeResultFile(notFilledEqualities);
    }

    private static void writeResultFile(List<Equality> equalities) {
        File out = new File("result.txt");
        try (FileWriter fileWriter = new FileWriter(out)) {
            for (Equality equality : equalities) {
                if (equality.getRightValue() == 0.0) {
                    fileWriter.write("Conversion not possible");
                } else {
                    fileWriter.write(equality.toString());
                }
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}