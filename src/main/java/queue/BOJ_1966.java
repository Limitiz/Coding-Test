package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            Queue<Integer> print = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            Integer priority[] = new Integer[n];
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++) {
                int k = Integer.parseInt(st.nextToken());
                print.add(k);
                priority[j] = k;
            }

            Arrays.sort(priority, Collections.reverseOrder());
            int max = priority[count];

            while(true) {
                if (print.peek() < max) {
                    print.add(print.poll());
                    if (m-- == 0)
                        m += print.size();
                } else {
                    print.remove();
                    if (m-- == 0) {
                        System.out.println(count+1);
                        break;
                    }
                    max = priority[++count];
                }
            }
        }
        br.close();
    }
}
