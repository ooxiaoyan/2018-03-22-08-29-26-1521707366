package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                resultList.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                if (i % 2 == 0) {
                    resultList.add(i);
                }
            }
        } else {
            for (int i = left; i >= right; i--) {
                if (i % 2 == 0) {
                    resultList.add(i);
                }
            }
        }
        return resultList;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        List<Integer> resultList = firstList.stream().filter(item -> secondList.contains(item)).collect(toList());
        return resultList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> differenceList = secondList.stream().filter(item -> !firstList.contains(item)).collect(toList());
        /*
        java.lang.UnsupportedOperationException
        常常使用Arrays.asLisvt()后调用add，remove这些method时出现java.lang.UnsupportedOperationException异常。这是由于：
        Arrays.asLisvt() 返回java.util.Arrays$ArrayList， 而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList，remove，add等 method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove(int)，add(int)等，所以throw UnsupportedOperationException。
        解决方法是使用Iterator，或者转换为ArrayList
        List list = Arrays.asList(a[]);
        List arrayList = new ArrayList(list);
         */
        List<Integer> newFirstList = new ArrayList<>(firstList);
        for (Integer integer : differenceList) {
            newFirstList.add(integer);
        }
        return newFirstList;
    }
}
