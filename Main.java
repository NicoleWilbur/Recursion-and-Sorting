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
                    while (!(rollno > 0 && rollno < Integer.MAX_VALUE)) {
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
                scnr.nextLine();
            }
        } while (true);
    }

    public static void main(String[] args) {
        ArrayList<StudentObject> unsortedStudentList = new ArrayList<>();
        ArrayList<StudentObject> studentListSorted = new ArrayList<>();
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
        scnr.close();                                                           
    }
}
