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

public class StudentObject {
    private int rollno;
    private String name;
    private String address;

    public StudentObject(){
        rollno = -1;
        name = null;
        address = null;
    }
    public StudentObject(int rollno, String name, String address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    public void setRollno (int rollno) {
        this.rollno = rollno;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getRollno (){
        return rollno;
    }
    public String getName (){
        return name;
    }
    public String getAddress(){
        return address;
    }
    @Override
    public String toString() {
        return rollno + ", " + name + ", " + address;
    }
}
