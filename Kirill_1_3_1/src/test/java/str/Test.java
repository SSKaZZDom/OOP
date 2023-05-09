package str;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testWarAndPeace() throws IOException {
        List<Integer> expect = new ArrayList<>();
        expect.add(211729);
        int sym;
        StringBuilder sub = new StringBuilder();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("warSub.txt");
             Reader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             Reader reader = new BufferedReader(streamReader)) {
            sym = reader.read();
            while (sym != -1) {
                sub.append((char) sym);
                sym = reader.read();
            }
        }
        String n = "war_and_peace.txt";
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(n)) {
            RKAlg r = new RKAlg(stream);
            List<Integer> result = r.rabinKarp(sub.toString());
            Assertions.assertEquals(expect, result);
        }
    }
}
