package graph.bfs;

import java.io.IOException;
import java.util.*;

public class pr {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        LinkedList<Integer> list[] = new LinkedList[n];
        ArrayList<Queue<Integer>> q = new ArrayList<>();
        boolean trust[] = new boolean[n];
        int time[] = new int[n];
        //Don't forget to initialize
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<Integer>();
            q.add(new LinkedList<Integer>());
            time[i] = -1;
        }

        for(int i=1; i<n; i++){
            int neigh = sc.nextInt();
            while(neigh != 0){
                list[i].add(neigh);
                neigh = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int t = 0;
        while(m-->0){
            int i = sc.nextInt();
            trust[i] = true;
            time[i] = 0;
            q.get(t).add(i);
        }

        Queue<Integer> candidate = new LinkedList<>();
        while(true) {
            if(q.get(t).isEmpty())
                break;
            while (!q.get(t).isEmpty()) {
                int temp = q.get(t).poll();
                for (int i : list[temp]) {
                    if (!trust[i]) {
                        int count = 0;
                        for (int j : list[i]) {
                            if (trust[j])
                                count++;
                        }
                        if (count >= (list[i].size() + 1) / 2) {
                            candidate.add(i);
                            time[i] = t + 1;
                            q.get(t + 1).add(i);
                        }
                    }
                }
            }
            while(!candidate.isEmpty())
                trust[candidate.poll()] = true;

            t++;
        }

        for(int k=1; k<n; k++)
            System.out.print(time[k]+" ");
    }
}