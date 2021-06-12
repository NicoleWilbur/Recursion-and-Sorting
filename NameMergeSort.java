package com.company;

import java.util.ArrayList;

public class NameMergeSort {
    private ArrayList<StudentObject> inputStudentList;

    public NameMergeSort(ArrayList<StudentObject> inputStudentList){
        this.inputStudentList = inputStudentList;
    }

    public ArrayList sortInputStudentList(){
        separateList(0, this.inputStudentList.size()-1);
        return inputStudentList;
    }

    public void separateList(int first, int last){
        if (first < last && (last - first) >= 1){
            int middle = (last + first) / 2;
            separateList(first, middle);
            separateList(middle + 1, last);

            mergeTogether(first,middle,last);
        }
    }

    public void mergeTogether(int first,int middle,int last){
        ArrayList<StudentObject> mergedSortedArray = new ArrayList<StudentObject>();
        int left = first;
        int right = middle + 1;

        while(left <= middle && right <= last){
            if(inputStudentList.get(left).getName().compareTo(inputStudentList.get(right).getName()) <= 0){
                mergedSortedArray.add(inputStudentList.get(left));
                ++left;
            }
            else{
                mergedSortedArray.add(inputStudentList.get(right));
                ++right;
            }
        }

        while(left<=middle){
            mergedSortedArray.add(inputStudentList.get(left));
            ++left;
        }
        while(right<=last){
            mergedSortedArray.add(inputStudentList.get(right));
            ++right;
        }

        int i = 0;
        int j = first;
        while(i<mergedSortedArray.size()){
            inputStudentList.set(j, mergedSortedArray.get(i++));
            ++j;
        }
    }
}
