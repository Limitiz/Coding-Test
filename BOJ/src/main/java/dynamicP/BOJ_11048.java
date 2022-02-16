package dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
    static int candy[][];
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken())+1;
        m = Integer.parseInt(st.nextToken())+1;

        candy = new int[n][m];
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<m; j++)
                candy[i][j] =  Integer.parseInt(st.nextToken())
                                +Math.max(candy[i][j-1], Math.max(candy[i-1][j], candy[i-1][j-1]));

        }
        System.out.println(candy[n-1][m-1]);
    }
}
