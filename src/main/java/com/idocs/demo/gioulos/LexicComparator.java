package com.idocs.demo.gioulos;

import java.util.Comparator;

public class LexicComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int res = String.valueOf(o1).toUpperCase().compareTo(String.valueOf(o2).toUpperCase());
        return res;
    }
}
