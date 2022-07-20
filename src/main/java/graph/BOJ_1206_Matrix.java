package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1206_Matrix {
    static boolean dCheck[];
    static boolean bCheck[];
    static Queue<Integer> q = new LinkedList<>();
    static int matrix[][];
    static int n;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()); //시작 정점
        
        //graph 만들기
        matrix = new int[n][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
            matrix [b][a] = 1;
        }
        
        //dfs
        dCheck = new boolean[n];
        dfs(v);
        
        System.out.println();
        
        //bfs
        bCheck = new boolean[n];
        bfs(v);

        br.close();
    }

    public static void dfs(int v){
        System.out.print(v+" ");
        dCheck[v] = true;
        for(int i=0; i<n; i++) {
            if (matrix[v][i] == 1 && !dCheck[i])
                dfs(i);
        }
    }

    public static void bfs(int v){
        q.add(v);
        bCheck[v] = true;
        while(q.size()>0){
            v = q.poll();
            System.out.print(v+" ");
            for (int i = 0; i < n; i++) {
                if (matrix[v][i] == 1 && !bCheck[i]) {
                    q.add(i);
                    bCheck[i] = true;
                }
            }
        }
    }
}
