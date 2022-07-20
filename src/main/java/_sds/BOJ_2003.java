package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int low = 0, high = 0;
        int sum = A[0]; int count = 0;

        while(true){
            if(sum == m) count++;

            if(sum >= m) sum -= A[low++];
            else if(high == n-1) break;
            else sum += A[++high];
        }

        System.out.println(count);
    }
}
