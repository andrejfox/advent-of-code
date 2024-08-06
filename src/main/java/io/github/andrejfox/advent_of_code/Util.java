package io.github.andrejfox.advent_of_code;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Util {
    private Util() {
    }

    @Nullable
    public static Integer parseIntOrNull(String input) {
        return parseIntOrNull(input, 10);
    }

    @Nullable
    public static Integer parseIntOrNull(String input, int radix) {
        try {
            return Integer.valueOf(input, radix);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static List<String> readInput() {
        try {
            return Files.readAllLines(Path.of("./src/main/resources/input.txt"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}