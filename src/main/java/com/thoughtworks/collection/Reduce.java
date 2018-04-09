package com.thoughtworks.collection;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt((x) ->x).summaryStatistics();
        return stats.getMax();
    }

    public double getMinimum() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt((x) ->x).summaryStatistics();
        return stats.getMin();
    }

    public double getAverage() {
        IntSummaryStatistics stats = arrayList.stream().mapToInt((x) ->x).summaryStatistics();
        return stats.getAverage();
    }

    public double getOrderedMedian() {
        List<Integer> sortList = arrayList.stream().sorted().collect(Collectors.toList());
        double median;
        if (sortList.size() % 2 == 0) {
            median = (sortList.get(sortList.size() / 2 - 1) + sortList.get(sortList.size() / 2)) / 2.0;
        } else {
            median = sortList.get(sortList.size() / 2);
        }
        return median;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        Integer firstEven = arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
        return arrayList.indexOf(firstEven);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        double median;
        for (Integer integer : arrayList) {
            singleLink.addTailPointer(integer);
        }
        int size = singleLink.size();
        if (size % 2 == 0) {
            median = (singleLink.getNode(size / 2) + singleLink.getNode(size / 2 + 1)) / 2.0;
        } else {
            median = (singleLink.getNode(size / 2));
        }
        return median;
    }

    public int getLastOdd() {
        List<Integer> oddList =  arrayList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        return oddList.get(oddList.size()-1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddList =  arrayList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        return arrayList.lastIndexOf(oddList.get(oddList.size()-1));
    }

    public boolean isEqual(List<Integer> arrayList) {
        return arrayList == this.arrayList;
    }
}
