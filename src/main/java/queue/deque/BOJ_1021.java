package queue.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        Deque<Integer> element = new LinkedList<>();
        int pos[] = new int[m];
        for(int i=0; i<m; i++)
            pos[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++)
            element.add(i);
        int count = 0;

        for(int i=0; i<m; i++){
            if(element.peek()==pos[i]) {
                element.poll();
                continue;
            }
            Iterator<Integer> it = element.iterator();
            int index = 0;
            while(it.hasNext()){
                if(it.next()==pos[i]) break;
                index++;
            }
            if(index <= element.size()/2){
                for(int j=0; j<index; j++)
                    element.add(element.poll());
                count += index;
            }
            else{
                for(int j=element.size()-1; j>=index; j--)
                    element.addFirst(element.pollLast());
                count += element.size()-index;
            }
            element.poll();
        }

        System.out.println(count);
        br.close();
    }
}
