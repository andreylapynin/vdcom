package com.interview.vdcom.task3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Unit {
    private String name;
    private Map<Unit, Double> relations = new HashMap<>();

    public Unit(String name) {
        this.name = name;
    }

    public void createDependence(Unit pair, Double coefficient) {
        if (!name.equals(pair.getName()) && coefficient != null) {
            relations.put(pair, coefficient);
        }
    }

    public Double getCoefficient(Unit pair) {
        return relations.get(pair);
    }

    public Set<Unit> getPairs() {
        return relations.keySet();
    }

    @Override
    public String toString() {
        return name;
    }

}