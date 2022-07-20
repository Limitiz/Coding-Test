package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*public class BOJ_13702 {
    public static void main(String[] args) throws IOException {
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] container = new int[n];
        for(int i=0; i<n; i++) container[i] = Integer.parseInt(br.readLine());

        //나눠줄 수 있는 용량
        int max = 0;
        for(int i : container) max += i;
        max /= k;

        Arrays.sort(container);
    }
}*/
import java.util.Scanner;

public class BOJ_13702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max;

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;

            for(int i = 0; i < N; i++) cnt += arr[i] / mid;
            if (cnt >= K) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(high);
    }
}