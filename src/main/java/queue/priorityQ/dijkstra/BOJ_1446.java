package queue.priorityQ.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dis = new int[d+1];
        ArrayList<Road> graph = new ArrayList<>();
        for(int i=0; i<d+1; i++)
            dis[i] = i;

        //그래프 만들기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(e > d) continue; //도착지점보다 멀면 저장X
            int w = Integer.parseInt(st.nextToken());
            if(w >= e-s) continue; //지름길이 더 길면 저장 X
            graph.add(new Road(s,e,w));
        }

        //다익스트라
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(0,0,0));
        while(!pq.isEmpty()){
            Road cur = pq.poll();
            for(Road r : graph) {
                if (r.start < cur.end) continue; //역주행 불가

                int tmp = r.start - cur.end;
                //일반 도로 > 지금까지 거리 + 지름길까지의 거리 + 지름길의 길이
                if(dis[r.end] > dis[cur.end]+tmp+r.weight){
                    dis[r.end] = dis[cur.end]+tmp+r.weight;
                    pq.add(new Road(cur.end,r.end, dis[r.end]));
                }
            }
            //도착지 거리 vs 지금까지의 거리 + 남은 거리
            dis[d] = Math.min(dis[d], dis[cur.end]+d-cur.end);
        }
        System.out.println(dis[d]);
    }

    static class Road implements Comparable<Road>{
        int start;
        int end;
        int weight;

        Road(int n, int e, int w){
            start = n;
            end = e;
            weight = w;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }
}