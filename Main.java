/***
 Name: Nicole Wilbur

 Project Name: CSC372-CTA06  -- Portfolio Milestone #2 Improvements

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

import java.util.*;

public class Main {

    public static void addStudent(Scanner scnr, ArrayList<StudentObject> studentList) {
        int rollno;
        String name;
        String address;
        boolean addAnother;
        do {
            try {
                do {
                    System.out.println("Please enter the student's roll number:");
                    rollno = scnr.nextInt();
                    while (!(rollno > 0 && rollno < Integer.MAX_VALUE)) {                                 //4-28-21 improvement: set to IntegerMaxValue instead of 1000000
                        System.out.println("Please enter a valid integer greater than zero: ");
                        rollno = scnr.nextInt();
                    }
                    scnr.nextLine();
                    System.out.println("Please enter the student's name: ");
                    name = scnr.nextLine();
                    while (name.length() < 1) {
                        System.out.println("Please enter a student's name: ");
                        name = scnr.nextLine();
                    }
                    System.out.println("Please enter a valid address. If the student does not have an address enter N/A: ");
                    address = scnr.nextLine();
                    while (address.length() < 1) {
                        System.out.println("Please enter a valid address. If the student does not have an address enter N/A: ");
                        address = scnr.nextLine();
                    }
                    StudentObject newStudent = new StudentObject(rollno, name, address);
                    studentList.add(newStudent);

                    do {
                        try {
                            System.out.println("Enter True to add another or False to exit.");
                            addAnother = scnr.nextBoolean();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter True or False.");
                        } finally {
                            scnr.nextLine();
                        }
                    } while (true);
                } while (addAnother);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Whoops, please enter valid data");
                scnr.nextLine();                                            //4-28-21 improvements: added scnr input to catch
            }                                                                  // statement and deleted finally statement.
        } while (true);                                                         // solved the double enter bug
    }

    public static void main(String[] args) {
        ArrayList<StudentObject> unsortedStudentList = new ArrayList<>();  //4-28-21 improvements: don't need to repeat the
        ArrayList<StudentObject> studentListSorted = new ArrayList<>();       //object in the new ArrayList<>() statements
        Scanner scnr = new Scanner(System.in);
        addStudent(scnr, unsortedStudentList);
        if (unsortedStudentList.size() <= 1){
            System.out.println(unsortedStudentList.toString());
        }
        else {
            Collections.sort(unsortedStudentList, new RollnoSort());
            System.out.println("Sorted by roll number:");
            for (int i = 0; i < unsortedStudentList.size(); ++i) {
                System.out.println(unsortedStudentList.get(i).toString());
            }
            NameMergeSort nameSort = new NameMergeSort(unsortedStudentList);
            studentListSorted = nameSort.sortInputStudentList();
            System.out.println();
            System.out.println("Sorted by name:");
            for (int i = 0; i < studentListSorted.size(); ++i) {
                System.out.println(studentListSorted.get(i).toString());
            }
        }
        System.out.println("Goodbye!");
        scnr.close();                                                           //4-27-21 improvement: close scanner
    }
}