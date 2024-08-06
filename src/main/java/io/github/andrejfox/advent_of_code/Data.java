package io.github.andrejfox.advent_of_code;

import io.github.andrejfox.advent_of_code.y2015.*;

import java.util.Map;

public class Data {
     static final Map<Integer, Day[]> YEARS = java.util.Map.of(
            2015, new Day[]{
                     new Day1(),
                     new Day2()
            }
    );
}
