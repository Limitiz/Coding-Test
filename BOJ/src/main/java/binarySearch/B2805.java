package binarySearch;

import java.util.Scanner;

public class B2805 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int tree[] = new int[n];
        int end=0; int start=0; int mid;
        for (int i=0; i<n; i++) {
            tree[i] = sc.nextInt();
            end = Math.max(end, tree[i]);
        }

        int height=0;
        long sum;

        while(start <= end){
            mid = (start+end)/2;
            sum=0;
            for(int i=0; i<n; i++) {
                if(tree[i]-mid > 0)
                    sum += (tree[i] - mid);
            }
            if(sum < m)
                end = mid - 1;
            else {
                height = mid;
                start = mid + 1;
            }
        }
        System.out.println(height);
        sc.close();
    }
}
