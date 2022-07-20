package preSum;

import java.util.Scanner;

public class B11660 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int pre[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                int num = sc.nextInt();
                pre[i][j] = pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1] + num;
            }
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(pre[c][d]-pre[a-1][d]-pre[c][b-1]+pre[a-1][b-1]);
        }

        sc.close();
    }
}
