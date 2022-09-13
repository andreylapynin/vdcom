package com.interview.vdcom.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Base {
    private final Map<String, Unit> units;

    private Base(Map<String, Unit> units) {
        this.units = units;
    }

    public static Base fromEqualityList(List<Equality> equalities) {
        List<Equality> knownEq = equalities.stream().filter(i -> i.getRightValue() != null
                        && !i.getLeftUnit().getName().equals(i.getRightUnit().getName()))
                .collect(Collectors.toList());
        Map<String, Unit> units = new HashMap<>();
        for (Equality equality : knownEq) {
            Unit leftUnit = equality.getLeftUnit();
            Unit rightUnit = equality.getRightUnit();
            if (units.containsKey(leftUnit.getName())) {
                leftUnit = units.get(leftUnit.getName());
            }
            if (units.containsKey(rightUnit.getName())) {
                rightUnit = units.get(rightUnit.getName());
            }
            Double ratioLeftUnitToRightUnit = equality.getLeftValue() / equality.getRightValue();
            Double ratioRightUnitToLeftUnit = equality.getRightValue() / equality.getLeftValue();
            leftUnit.createDependence(rightUnit, ratioRightUnitToLeftUnit);
            rightUnit.createDependence(leftUnit, ratioLeftUnitToRightUnit);
            units.put(leftUnit.getName(), leftUnit);
            units.put(rightUnit.getName(), rightUnit);
        }
        return new Base(units);
    }

    public Double findValue(Equality equality) {
        Unit knownUnit = units.get(equality.getLeftUnit().getName());
        Unit unknownUnit = units.get(equality.getRightUnit().getName());
        Double ratioUnknownToKnown = findRatio(knownUnit, unknownUnit, new ArrayList<>());
        if (ratioUnknownToKnown != null) {
            return ratioUnknownToKnown * equality.getLeftValue();
        }
        return 0.0;
    }

    private Double findRatio(Unit known, Unit unknown, List<Unit> units) {
        Double ratio = null;
        Set<Unit> relations = known.getPairs();
        if (relations.contains(unknown)) {
            ratio = known.getCoefficient(unknown);
        } else {
            Set<Unit> filter = relations.stream()
                    .filter(unit -> !units.contains(unit))
                    .collect(Collectors.toSet());
            if (filter.isEmpty()) {
                return 0.0;
            }
            for (Unit unit : filter) {
                units.add(unit);
                Double ratioUnknownToCurrent = findRatio(unit, unknown, units);
                if (ratioUnknownToCurrent != null) {
                    Double ratioCurrentToKnown = known.getCoefficient(unit);
                    return ratioCurrentToKnown * ratioUnknownToCurrent;
                }
            }
        }
        return ratio;
    }

}
