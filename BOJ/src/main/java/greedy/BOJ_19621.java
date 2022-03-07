package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_19621 {
    static int n, max = 0;
    static int people[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n];
        for(int i=0; i<n; i++)
            people[i] = Integer.parseInt(br.readLine().split(" ")[2]);

        //최대 인원을 고려해야 하므로 완전탐색
        dfs(0, 0);
        dfs(1, 0);

        System.out.println(max);
    }

    public static void dfs(int i, int sum){
        if(i > n-1){
            max = Math.max(max, sum);
            return;
        }

        dfs(i+2, sum+people[i]);
        dfs(i+3, sum+people[i]);
    }
}
