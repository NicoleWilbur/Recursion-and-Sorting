package com.company;

import java.util.Comparator;

public class RollnoSort implements Comparator<StudentObject> {
    @Override
    public int compare(StudentObject s1, StudentObject s2) {
        return s1.getRollno() - s2.getRollno();
    }
}
