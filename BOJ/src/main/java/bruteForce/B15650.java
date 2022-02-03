package bruteForce;

import java.util.Scanner;

public class B15650 {
    static int n,m;
    static int arr[];

    static void solve(int count, int pre){
        if(count == m){
            for(int i=0; i<m; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for(int i=pre; i<=n; i++){
            arr[count] = i;
            solve(count+1, i+1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        solve(0, 1);
        sc.close();
    }
}
