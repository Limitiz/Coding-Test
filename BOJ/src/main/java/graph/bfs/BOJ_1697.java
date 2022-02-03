package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static class Go{
        int time;
        int pos;
        public Go(int pos, int time){
            this.pos = pos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean check[] = new boolean[100002];

        Go cur;
        Queue<Go> list = new LinkedList<>();
        list.add(new Go(n,0));
        check[n] = true;
        while(!list.isEmpty()){
            cur = list.poll();
            if(cur.pos==k){
                System.out.println(cur.time);
                break;
            }

            int temp = cur.pos-1;
            if(temp>=0 && !check[temp]) {
                list.add(new Go(temp, cur.time + 1));
                check[temp] = true;
            }

            if(cur.pos<k) {
                temp = cur.pos + 1;
                if (!check[temp]) {
                    list.add(new Go(temp, cur.time + 1));
                    check[temp] = true;
                }

                temp = cur.pos * 2;
                if (temp <= 100000 && !check[temp]) {
                    list.add(new Go(temp, cur.time + 1));
                    check[temp] = true;
                }
            }
        }
        br.close();
    }
}
