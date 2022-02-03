package bruteForce;

import java.util.Scanner;

public class B9663 {
    static boolean[] column, diagonal, opp;
    static int n;
    static int count=0;

    static public void visit(int row) {
        if(row==n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(column[i] || diagonal[row+i] || opp[row-i+n-1])
                continue;
            column[i] = true;
            diagonal[row+i] = true;
            opp[row-i+n-1] = true;
            visit(row+1);
            column[i] = false;
            diagonal[row+i] = false;
            opp[row-i+n-1] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        column = new boolean[n];
        diagonal= new boolean[2*n-1];
        opp = new boolean[2*n-1];
        visit(0);
        System.out.println(count);
        sc.close();
    }
}
