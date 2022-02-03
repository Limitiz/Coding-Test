package queue.priorityQ.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int distance[] = new int[v+1]; //distance from k to index
        Arrays.fill(distance, Integer.MAX_VALUE); //initialize to inf
        ArrayList<Pair> graph[] = new ArrayList[v+1];
        for(int i=0; i<=v; i++)
            graph[i] = new ArrayList<Pair>();
        //save vertex
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair(s, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        distance[k] = 0; //start vertex's distance = 0
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(distance[cur.num] < cur.weight)
                continue;
            for(Pair nxt : graph[cur.num]){
                if(distance[nxt.num] > distance[cur.num]+nxt.weight) {
                    distance[nxt.num] = distance[cur.num] + nxt.weight;
                    //distance[endV] = dis, p.weight = num;
                    pq.add(new Pair(nxt.num, distance[nxt.num]));
                }
            }
        }

        for(int i=1; i<=v; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(distance[i] + "\n");
        }
        System.out.print(sb);
        br.close();
    }
    static class Pair implements Comparable<Pair>{
        int num;
        int weight;
        Pair(int s, int w){
            num = s;
            weight = w;
        }

        @Override
        public int compareTo(Pair o){
            return this.weight - o.weight;
        }
    }
}