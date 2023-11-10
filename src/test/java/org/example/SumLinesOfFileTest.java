package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumLinesOfFileTest {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void setup() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void test() throws IOException {

        File file = new File("test_input.txt");
        PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8);
        writer.println("+1.0");
        writer.println("+2.0");
        writer.println("+3.0");
        writer.println("-2.0");
        writer.println("-3.0");
        writer.println("-1.0");
        writer.close();

        SumLinesOfFile.main(new String[]{file.getAbsolutePath()});
        String actual = output.toString();

        assertEquals(actual, "0.0");
    }
}