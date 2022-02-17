package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int time;
    long num;

    Node(long num, int time){
        this.num = num;
        this.time = time;
    }
}
public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();

        Node n = null;
        q.add(new Node(a,1));
        while(!q.isEmpty()){
            n = q.poll();
            if(n.num*2 == b || n.num*10+1 == b) break;
            if(n.num*10+1 < b) q.add(new Node(n.num*10+1, n.time+1));
            if(n.num*2 < b) q.add(new Node(n.num*2, n.time+1));
        }
        if(n.num*2 == b || n.num*10+1 == b)
            System.out.println(n.time+1);
        else
            System.out.println(-1);
    }
}
