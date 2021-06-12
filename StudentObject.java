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
