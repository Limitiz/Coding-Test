package binarySearch;

import java.util.Scanner;

public class B16401 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int cookie[] = new int[n];
        int start = 1, end = 0, mid, len=0, count;
        for(int i=0; i<n; i++) {
            cookie[i] = sc.nextInt();
            end = Math.max(end, cookie[i]);
        }

        while(start<=end){
            mid = (start+end)/2;
            count = 0;
            for(int i=0; i<n; i++)
                count += (cookie[i]/mid);
            if(count >= m){
                len = mid;
                start = mid+1;
            }
            else
                end = mid - 1;
        }

        System.out.println(len);
        sc.close();
    }
}
