package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) { this.array = array; }

    public List<Integer> filterEven() {
        List<Integer> resultList = array.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> resultList = array.stream().filter(num -> num % 3 == 0).collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> resultList = array.stream().distinct().collect(Collectors.toList());
        return resultList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList = firstList.stream().filter(item -> secondList.contains(item)).collect(Collectors.toList());
        return resultList;
    }
}