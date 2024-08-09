package io.github.andrejfox.advent_of_code.y2015;

import io.github.andrejfox.advent_of_code.Day;
import io.github.andrejfox.advent_of_code.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 implements Day {
    @Override
    public void part1() {
        run("00000");
    }

    @Override
    public void part2() {
        run("000000");
    }

    private static void run(String startsWith) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String input = Util.readInput().getFirst();
            int length = input.length();
            String output = "";
            int i = 1;

            while (!output.startsWith(startsWith)) {
                input = input.substring(0, length);
                input = input.concat(String.valueOf(i));
                md.update(input.getBytes());
                byte[] digest = md.digest();
                output = printHexBinary(digest);
                i++;
            }
            System.out.println(--i);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm not found: " + e.getMessage());
        }
    }

    private static String printHexBinary(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}