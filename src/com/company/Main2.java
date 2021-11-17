package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(i);
        }

       Integer result = list.stream().filter(val -> val % 2 != 0).reduce(Integer::sum).orElse(0);
        System.out.println(result);
    }
}
