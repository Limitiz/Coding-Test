package binarySearch;

import java.util.Scanner;

public class B3079 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        int t[] = new int[n];
        for(int i=0; i<n; i++)
            t[i] = sc.nextInt();

        long start, end, mid, time, sum;
        start = 0; end = (long)1e18;
        time = 0;

        while(start<=end){
            mid = (start+end)/2;
            sum = 0;
            for(int i=0; i<n; i++){
                sum += (mid/t[i]);
                if(sum >= m)
                    break;
            }
            if(sum >= m){
                time = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        System.out.println(time);
        sc.close();
    }
}
