package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19538 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())+1;
        ArrayList<Integer> neigh[] = new ArrayList[n];
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        boolean trust[] = new boolean[n];
        int time[] = new int[n];

        for (int i = 0; i < n; i++) {
            neigh[i] = new ArrayList<Integer>();
            list.add(new LinkedList<Integer>());
            time[i] = -1;
        }

        for(int i=1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            while(c!=0){
                neigh[i].add(c);
                c = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int t = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(m-->0) {
            int i =Integer.parseInt(st.nextToken());
            list.get(t).add(i);
            trust[i] = true;
            time[i] = t;
        }

        Queue<Integer> candidate = new LinkedList<>();
        int count;
        while(true){
            if(list.get(t).isEmpty()) break;
            while(!list.get(t).isEmpty()) {
                int temp = list.get(t).poll();
                for (int e : neigh[temp]) {
                    if (!trust[e]) {
                        count = 0;
                        for (int ee : neigh[e]) {
                            if (trust[ee]) count++;
                        }
                        if (count >= (neigh[e].size() + 1) / 2) {
                            candidate.add(e);
                            time[e] = t + 1;
                            list.get(t + 1).add(e);
                        }
                    }
                }
            }

            while(!candidate.isEmpty())
                trust[candidate.poll()] = true;
            t++;
        }

        for(int i=1; i<n; i++)
            System.out.print(time[i]+" ");
        br.close();
    }
}