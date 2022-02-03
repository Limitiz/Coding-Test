package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1206_List {
    static Vector<Integer> list[];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new Vector[n];
        for(int i=0; i<n; i++)
            list[i] = new Vector<Integer>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=0; i<n; i++)
            Collections.sort(list[i]);

        check = new boolean[n];
        dfs(v);
        System.out.println();
        check = new boolean[n];
        bfs(v);

        br.close();
    }

    public static void dfs(int v){
        check[v] = true;
        System.out.print(v+" ");
        for(int i : list[v]) {
            if(!check[i])
                dfs(i);
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v); check[v] = true;
        while(!q.isEmpty()){
            v = q.poll();
            System.out.print(v+" ");
            for(int i : list[v]){
                if(!check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
