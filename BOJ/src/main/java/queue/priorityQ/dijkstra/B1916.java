package queue.priorityQ.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())+1;
        int m = Integer.parseInt(br.readLine());

        int fare[] = new int[n];
        ArrayList<ArrayList<Bus>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            fare[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());;
        while(m-->0){
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Bus(end, fee));
            st = new StringTokenizer(br.readLine(), " ");
        }
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        fare[from] = 0;
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(from, 0));
        while(!pq.isEmpty()){
            Bus cur = pq.poll();
            if(fare[cur.city] < cur.weight)
                continue;
            for(Bus nxt : graph.get(cur.city)){
                if(fare[nxt.city] > cur.weight + nxt.weight) {
                    fare[nxt.city] = cur.weight + nxt.weight;
                    pq.add(new Bus(nxt.city, fare[nxt.city]));
                }
            }
        }


        System.out.println(fare[to]);
        br.close();
    }
    static class Bus implements Comparable<Bus>{
        int city;
        int weight;
        Bus(int c, int w){
            city = c;
            weight = w;
        }

        @Override
        public int compareTo(Bus o) {
            return this.weight - o.weight;
        }
    }
}
