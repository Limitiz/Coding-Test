package tree;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int s; int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int x = Math.abs(o1);
                int y = Math.abs(o2);
                if(x == y)
                    return o1 < o2 ? -1 : 1;
                return x - y;
            }
        });
        while(n-->0){
            s = Integer.parseInt(br.readLine());
            if(s == 0) {
                if(pq.isEmpty())
                    sb.append(0+"\n");
                else
                sb.append(pq.poll() + "\n");
            }
            else
                pq.add(s);
        }

        System.out.println(sb);
        br.close();
    }
}
