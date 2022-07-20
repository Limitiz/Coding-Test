package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class B11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer num[] = new Integer[Integer.parseInt(reader.readLine())];
        for(int i=0; i<num.length; i++)
            num[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(num, Collections.reverseOrder());
        for(Integer i : num)
            writer.write(i+"\n");
        writer.flush();
    }
}
