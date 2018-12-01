package com.webcheckers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);


        System.out.println(numbers);

        numbers.stream().filter(integer -> integer < 3);

        numbers.removeIf(number -> number <2);
        System.out.println(numbers);


        System.out.println(PieceColorEnum.valueOf("player"));
    }
}
