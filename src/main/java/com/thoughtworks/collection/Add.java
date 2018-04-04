package com.thoughtworks.collection;

import java.util.*;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start, end;
        if (leftBorder < rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        Set<Integer> evenSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                evenSet.add(i);
            }
        }
        int sum = 0;
        for (Integer integer : evenSet) {
            sum = sum + integer;
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start, end;
        if (leftBorder < rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        Set<Integer> oddSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                oddSet.add(i);
            }
        }
        int sum = 0;
        for (Integer integer : oddSet) {
            sum = sum + integer;
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum = sum + integer;
        }
        sum = sum * 3 + arrayList.size() * 2;
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                arrayList.set(i, arrayList.get(i) * 3 + 2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                sum = sum + arrayList.get(i) * 3 + 5;
            }
        }
        return sum;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            resultList.add(i, (arrayList.get(i) + arrayList.get(i+1)) * 3);
        }
        return resultList;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                evenList.add(arrayList.get(i));
            }
        }
        Collections.sort(evenList);
        double median;
        if (evenList.size() % 2 == 0) {
            median = (evenList.get(evenList.size() / 2 - 1) + evenList.get(evenList.size() / 2)) / 2;
        } else {
            median = evenList.get(evenList.size()/2);
        }
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        int sum = 0, count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                sum = sum + arrayList.get(i);
                count++;
            }
        }
        double average = sum / count;
        return average;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                evenList.add(arrayList.get(i));
            }
        }
        return evenList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                evenList.add(arrayList.get(i));
            }
        }
        //delete duplicate elements
        Set evenSet = new HashSet(evenList);
        evenList.clear();
        evenList.addAll(evenSet);
        return evenList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = new LinkedList<>(),
                oddList = new LinkedList<>(),
                resultList = new LinkedList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                evenList.add(arrayList.get(i));
            } else {
                oddList.add(arrayList.get(i));
            }
        }
        Collections.sort(evenList);
        Collections.sort(oddList, Collections.reverseOrder());//desc
        resultList.addAll(evenList);
        resultList.addAll(oddList);
        return resultList;

    }
}
