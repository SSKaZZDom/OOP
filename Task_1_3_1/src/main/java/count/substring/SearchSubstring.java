package count.substring;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of substring search in a string.
 * In this code I use Knuth-Morris-Pratt algorithm.
 * KMP algorithm works in O(n) in worse case.
 */
public class SearchSubstring {
    public static List<Long> allEntries(InputStream stream, String subStr) throws IOException {
        List<Long> res = new ArrayList<>();
        int cnt = 0;
        long idx = 0;
        int subLen = subStr.length();
        int[] prefix = prefixFunc(subStr);
        Reader reader = new BufferedReader(new InputStreamReader(stream));
        int sym = reader.read();
        while (sym != -1) {
            if ((char) sym == subStr.charAt(cnt)) {
                sym = reader.read();
                idx++;
                cnt++;
            } else if (cnt == 0) {
                sym = reader.read();
                idx++;
            } else {
                cnt = prefix[cnt - 1];
            }
            if (cnt == subLen) {
                res.add(idx - subLen);
                cnt = prefix[cnt - 1];
            }
        }
        return res;
    }

    private static int[] prefixFunc(String subStr) {
        int len = subStr.length();
        int[] result = new int[len];
        int cnt;
        for (int i = 1; i < len; i++) {
            cnt = result[i - 1];
            while (cnt > 0 && subStr.charAt(i) != subStr.charAt(cnt)) {
                cnt = result[cnt - 1];
            }
            if (subStr.charAt(i) == subStr.charAt(cnt)) {
                cnt++;
            }
            result[i] = cnt;
        }
        return result;
    }
}
