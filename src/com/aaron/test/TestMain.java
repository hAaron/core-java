package com.aaron.test;

import java.text.ParseException;
import java.util.Collections;

public class TestMain {
    public static void main(String[] args) throws ParseException {
        Iterable iterable = Collections.emptyList();
        iterable.iterator().next();

        System.out.println(Integer.valueOf(null));
    }

}
