package io.github.andrejfox.advent_of_code.y2015;

import io.github.andrejfox.advent_of_code.Day;
import io.github.andrejfox.advent_of_code.Util;

import java.util.ArrayList;
import java.util.List;

public class Day3 implements Day {
    private record cord(int x, int y) {}

    final char[] instructions = Util.readInput().getFirst().toCharArray();
    List<cord> visited = new ArrayList<>();
    int x = 0;
    int y = 0;

    @Override
    public void part1() {
        for (char move : instructions) {
            if (!visited.contains(new cord(x, y))) {
                visited.add(new cord(x, y));
            }
            switch (move) {
                case '>' -> x++;
                case '<' -> x--;
                case '^' -> y++;
                case 'v' -> y--;
                default -> {
                    System.out.println("Invalid input!");
                    return;
                }
            }
        }
        System.out.println(visited.size());
    }

    @Override
    public void part2() {}
}