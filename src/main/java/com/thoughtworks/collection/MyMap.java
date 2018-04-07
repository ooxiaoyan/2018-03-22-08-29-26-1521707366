package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(n -> n*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> resultList = array.stream()
                .map(integer -> integer+96)
                .map(integer -> String.valueOf((char)integer.intValue()))
                .collect(Collectors.toList());
        return resultList;
    }

    public List<String> mapLetters() {
        List<String> resultList = new ArrayList<>();
        String singleDigit, tenDigit = "", letters;
        for (Integer integer : array) {
            if (integer <= 0) {
                return null;
            }
            int quotient = integer / 26;
            int remainder = integer % 26;
            if (quotient == 0) {
                singleDigit = numberToLetter(remainder);
            } else {
                if (remainder == 0) {
                    singleDigit = "z";
                    tenDigit = numberToLetter(--quotient);
                } else {
                    singleDigit = numberToLetter(remainder);
                    tenDigit = numberToLetter(quotient);
                }
            }
            letters = tenDigit.concat(singleDigit);
            resultList.add(letters);
        }
        return resultList;
    }

    public String numberToLetter(int number) {
        if (number == 0) {
            return "";
        } else {
            return String.valueOf((char)(number + 96));
        }
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
