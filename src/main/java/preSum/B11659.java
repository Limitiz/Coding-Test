package preSum;

import java.util.Scanner;

public class B11659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int pre[] = new int[n+1]; //presum : length n+1 is good;
        for(int i=1; i<=n; i++) {
            int num = sc.nextInt();
            pre[i] = pre[i - 1] + num;
        }

        for(int k=0; k<m; k++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(pre[j]-pre[i-1]);
        }
        sc.close();
    }
}
