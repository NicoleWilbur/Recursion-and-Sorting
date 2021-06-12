/***
 Name: Nicole Wilbur

 Project Name: CSC372-CTA06

 Project Purpose: sort with a comparator class then with a merge sort

 Algorithm Used: recursion for the merge sort and a comparator interface

 Program Inputs: student list

 Program Outputs: student list sorted by roll number then by name

 Program Limitations: can't check for valid names and addresses

 Program Errors: requires two taps of enter after "false" to exit loops. Probably a scanner issue. Tried getting
 help from SmartThinking and got anything but.

 ==================
 ***/
package com.company;

import java.util.Comparator;

public class RollnoSort implements Comparator<StudentObject> {
    @Override
    public int compare(StudentObject s1, StudentObject s2) {
        return s1.getRollno() - s2.getRollno();
    }
}
