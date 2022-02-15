package dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
    static int candy[][];
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        candy = new int[n][m];
        for(int i=0; i<n; i++)
            candy[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(dfs(0,0, candy[0][0]));
    }

    public static int dfs(int r, int c, int sum){
        int x=0,y=0,z=0;
        if(r==n-1 && c==m-1) return sum;

        if(r<n-1)
            x = dfs(r + 1, c, sum + candy[r + 1][c]);
        if(c<m-1)
            y = dfs(r, c+1, sum+candy[r][c+1]);
        if(r<n-1 && c<m-1)
            z = dfs(r + 1, c + 1, sum + candy[r + 1][c + 1]);

        return Math.max(x,Math.max(y,z));
    }
}
