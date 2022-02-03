package twoPointer;

import java.util.Scanner;
import java.util.Vector;

public class B2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(twoPointer(n,m));
        sc.close();
    }

    public static int twoPointer(int n, int m){
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        int a, b, count = 0;
        long sum = 0;
        for(int i=0; i<n; i++){
            a = sc.nextInt();
            v.add(a);
        }
        a = 0; b = 0;
        while(true){
            if(sum >= m)
                sum -= v.get(a++);
            else if(b == n)
                break;
            else
                sum += v.get(b++);
            if(sum == m)
                count++;
        }
        sc.close();
        return count;
    }

    public static int preSum(int n, int m){
        Scanner sc = new Scanner(System.in);
        int pre[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            pre[i] = pre[i - 1] + a;
        }
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (pre[j] - pre[i - 1] < m)
                    break;
                else if (pre[j] - pre[i - 1] == m) {
                    count++;
                    break;
                }
            }
        }
        sc.close();
        return count;
    }

    public static int naive(int n, int m) {
        Scanner sc = new Scanner(System.in);
        int pre[] = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }
        int count = 0, sum;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += pre[j];
                if (sum > m)
                    break;
                else if (sum == m) {
                    count++;
                    break;
                }
            }
        }
        sc.close();
        return count;
    }
}
