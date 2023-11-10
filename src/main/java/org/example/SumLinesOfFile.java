package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class SumLinesOfFile {

    private static final List<Double> values = new ArrayList<>();

    public String sumLines(File file) {
        readValues(file);
        return "" + sumValues();
    }

    private double sumValues() {
        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum;
    }

    private void readValues(File file) {
        try (var reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            do {
                double value = parseDouble(line);
                values.add(value);
            } while ((line = reader.readLine()) != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        System.out.print(new SumLinesOfFile().sumLines(path.toFile()));
    }
}