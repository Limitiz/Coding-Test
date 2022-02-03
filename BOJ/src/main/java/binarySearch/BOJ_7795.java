package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            //각 테스트 별 입력받기
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                b[i] = Integer.parseInt(st.nextToken());

            //이분탐색 전 정렬
            Arrays.sort(b);

            //a의 원소마다 이분탐색
            int count = 0;
            for(int i=0; i<n;i++)
                count += binarySearch(a[i], 0, m-1);
            System.out.println(count);
        }
        br.close();
    }
    public static int binarySearch(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (b[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}