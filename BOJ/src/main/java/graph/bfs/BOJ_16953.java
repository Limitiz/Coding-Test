package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    static class Node{
        long val;
        int level;
        public Node(long val, int level){
            this.val = val;
            this.level = level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Queue<Node> list = new LinkedList<>();
        Node n;
        list.add(new Node(a,1));
        while(!list.isEmpty()){
            n = list.poll();
            if(n.val == b) {
                System.out.println(n.level);
                return;
            }
            long c = n.val*10+1;
            if(c<=b)
                list.add(new Node(c,n.level+1));
            c = n.val*2;
            if(c<=b)
                list.add(new Node(c, n.level+1));
        }
        System.out.println(-1);
        br.close();
    }
}
