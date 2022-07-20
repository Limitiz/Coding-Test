package _test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main5 {
    static class Node implements Comparable<Node>{
        int num;
        int weight;
        public Node(int num, int w){
            this.num = num;
            weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())+1;
        int r = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> tree = new ArrayList<>();
        for(int i=0; i<n; i++)
            tree.add(new ArrayList<Node>());

        for(int i=2; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.get(Integer.parseInt(st.nextToken()))
                    .add(new Node(Integer.parseInt(st.nextToken())
                            , Integer.parseInt(st.nextToken())));
        }

        int col = 0;
        int root = r;
        while(true){
            if(tree.get(root).size() > 1 || tree.get(root).isEmpty())
                break;
            col += tree.get(root).get(0).weight;
            root = tree.get(root).get(0).num;
        }

        int branch[] = new int[n];
        int max = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(root, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(Node nxt : tree.get(cur.num)){
                branch[nxt.num] = cur.weight + nxt.weight;
                pq.add(new Node(nxt.num, branch[nxt.num]));
                max = max > branch[nxt.num] ? max : branch[nxt.num];
            }
        }


        System.out.println(col+" "+max);
        br.close();
    }
}
