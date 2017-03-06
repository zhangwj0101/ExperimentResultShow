package cn.nlsde.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zwj on 2017/2/21.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("C:\\reshuiqi.txt"));
        Set<String> sets = new HashSet<>();
        strings.stream().forEach(line -> {
            sets.addAll(Arrays.stream(line.split(",")).collect(Collectors.toSet()));
        });
        for (String s : sets) {
            System.out.println(s);
        }
    }
}
