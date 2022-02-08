package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static boolean use[];
    static int seq[];
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        use = new boolean[n+1];
        seq = new int[m];
        sol(0);
        br.close();
    }

    public static void sol(int count){
        if(count ==m){
            for(int i=0;i<m; i++)
                System.out.print(seq[i]+" ");
            System.out.println();
        }
        else{

        }
    }
}
