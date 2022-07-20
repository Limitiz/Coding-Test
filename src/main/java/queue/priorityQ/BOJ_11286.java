package queue.priorityQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if(a==b)
                    return o1<o2 ? -1:1;
                return a - b;
            }
        });
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k==0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else
                pq.add(k);
        }

        br.close();
    }
}
