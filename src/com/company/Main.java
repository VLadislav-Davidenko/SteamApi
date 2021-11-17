package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        List<String> testList = new ArrayList<>();
        testList.add("grgz dfg zdfg");
        testList.add("hts hsxft ghxfst hhtr");
        testList.add("gqwerty  trjf   rgsdjhxfg");
        testList.add("1");

        Predicate<String> predicate = s -> s.contains("qwerty");
        testList.forEach(item -> System.out.println(predicate.test(item)));


        List<String> testList2 = new ArrayList<>();
        testList2.add("qwerty");
        testList2.add("123456");
        testList2.add("xxxx");
        testList2.add("14");


        Map<String, Integer> collect =
                Stream.concat(testList.stream(), testList2.stream())
                        .map(str -> str.toUpperCase().replace(" ", ""))
                        .distinct()
                        .collect(Collectors.toMap(item -> item, item -> item.length()))
                        .entrySet()
                        .stream()
                        .peek(entry -> {
                            if (entry.getKey().matches("\\b\\d+\\b")) {
                                entry.setValue(0);
                            }
                        })
                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
        System.out.println();
    }
}
