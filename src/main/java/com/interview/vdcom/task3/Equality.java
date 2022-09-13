package com.interview.vdcom.task3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Equality {
    private Unit leftUnit;
    private Unit rightUnit;
    private Double leftValue;
    private Double rightValue;

    @Override
    public String toString() {
        return leftValue + " " + leftUnit.toString() + " "
                + "=" + " " + rightValue + " " + rightUnit.toString();
    }

}