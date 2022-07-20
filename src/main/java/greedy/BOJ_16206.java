package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16206 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int input[] = new int[n];
        int cake[] = new int[n];
        int count = 0;
        int k;
        int p = 0;
        int q = n - 1;
        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();
        Arrays.sort(input);
        for (int i = 0; i < n; i++) {
            if (input[i] % 10 == 0)
                cake[p++] = input[i];
            else
                cake[q--] = input[i];
        }
        for (int i = 0; i < p && m>0; i++) {
            k = cake[i] / 10;
            if(m<k-1){
                count += m; m=0; break;
            }
            else{
                m -= k - 1;
                count += k;
            }
        }
        for (int i = p; i < n && m > 0; i++) {
            k = cake[i] / 10;
            if(m<k) {
                count += m; break;
            } else{
                m -= k;
                count += k;
            }
        }
        System.out.println(count);
        sc.close();
    }
}