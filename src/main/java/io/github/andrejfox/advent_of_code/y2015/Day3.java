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
    public void part2() {
        int w = 0;
        int z = 0;

        visited.add(new cord(0, 0));
        for (int i = 0; i < instructions.length; i++) {
            if (i % 2 == 0) {
                switch (instructions[i]) {
                    case '>' -> x++;
                    case '<' -> x--;
                    case '^' -> y++;
                    case 'v' -> y--;
                    default -> {
                        System.out.println("Invalid input!");
                        return;
                    }
                }
                if (!visited.contains(new cord(x, y))) {
                    visited.add(new cord(x, y));
                }
            } else {
                switch (instructions[i]) {
                    case '>' -> w++;
                    case '<' -> w--;
                    case '^' -> z++;
                    case 'v' -> z--;
                    default -> {
                        System.out.println("Invalid input!");
                        return;
                    }
                }
                if (!visited.contains(new cord(w, z))) {
                    visited.add(new cord(w, z));
                }
            }
        }
        System.out.println(visited.size());
    }
}