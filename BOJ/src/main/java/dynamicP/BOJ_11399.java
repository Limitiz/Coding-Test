package dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wait = new int[n];
        int time = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            wait[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(wait);
        for(int i=0; i<n; i++)
            time += wait[i]*(n-i);

        System.out.println(time);
    }
}
