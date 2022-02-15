package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0, right = tree[n-1], mid;
        long tmp;

        while(left<=right){
            mid = (left+right)/2; tmp = 0;
            for(int i : tree) {
                if(i > mid)  tmp += (i - mid);
            }

            if(tmp == m) {
                right = mid;
                break;
            }
            else if(tmp < m) right = mid-1;
            else left = mid+1;
        }

        System.out.println(right);
    }
}