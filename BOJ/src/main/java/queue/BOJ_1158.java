package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> yose = new LinkedList<>();
        for(int i=1; i<=n; i++)
            yose.add(i);
        int i = 0;
        System.out.print("<");
        while(yose.size()>1){
            i++;
            if(i%k==0)
                System.out.print(yose.poll()+", ");
            else
                yose.add(yose.poll());
        }
        System.out.print(yose.poll()+">");
        br.close();
    }
}
