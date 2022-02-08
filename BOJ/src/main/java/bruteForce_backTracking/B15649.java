package bruteForce_backTracking;

import java.util.Scanner;

public class B15649 {
    static int  n, m;
    static int[] seq;
    static boolean[] used;

    public static void sequence(int count){
        if(count == m){
            for(int i=0; i<m; i++)
                System.out.print(seq[i] + " ");
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!used[i]){
                used[i] = true;
                seq[count] = i+1;
                sequence(count+1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        seq = new int[m];
        used = new boolean[n];

        sequence(0);

        sc.close();
    }
}
