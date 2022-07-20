package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
    static int a[];
    public static int search(int key, int start, int end){
        if(start>end)
            return 0;
        else{
            int mid = (start + end) / 2;
            if (a[mid] == key)
                return 1;
            if (key < a[mid])
                return search(key, start, mid - 1);
            else
                return search(key, mid + 1, end);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        int num;

        Arrays.sort(a);
        for(int i=0; i<m; i++) {
            num = sc.nextInt();
            System.out.println(search(num, 0,  n-1));
        }

        sc.close();
    }
}
