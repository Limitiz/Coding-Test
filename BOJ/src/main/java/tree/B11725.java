package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int parent[];

    static void dfs(int v){
        for(int i : graph.get(v)){
            if(parent[i] != 0)
                continue;
            parent[i] = v;
            System.out.println(i);
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) +1;
        StringTokenizer st;
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<Integer>());
        for(int i=1; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            System.out.println(i);
        }

        parent = new int[n];
        parent[1] = -1;
        dfs(1);

        for(int i=2; i<n; i++)
            System.out.println(parent[i]);
    }
}
