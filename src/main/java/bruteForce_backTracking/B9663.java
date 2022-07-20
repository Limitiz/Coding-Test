package bruteForce_backTracking;

import java.io.*;

public class B9663 {
    static boolean[] column, diagonal, opp;
    static int n, count=0;

    public static void visit(int row) {
        if(row==n) { count++; return;}
        
        for (int i = 0; i < n; i++) {
            if(column[i] || diagonal[row+i] || opp[row-i+n-1]) continue;
            
            column[i] = true; diagonal[row+i] = true; opp[row-i+n-1] = true;
            visit(row+1);
            column[i] = false; diagonal[row+i] = false; opp[row-i+n-1] = false;
        }
    }

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
        column = new boolean[n];
        diagonal= new boolean[2*n-1];
        opp = new boolean[2*n-1];
        visit(0);
        System.out.println(count);
    }
}
