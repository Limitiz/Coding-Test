package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tomato[][] = new int[m][n];
        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)
                    q.add(new Point(i,j));
                tomato[i][j] = tmp;
            }
        }

        int time = 0;
        Queue<Point> tmp = new LinkedList<>();
        while(true) {
            if(q.isEmpty()) break;
            while (!q.isEmpty()) {
                Point p = q.poll();
                if (p.x < m - 1 && tomato[p.x + 1][p.y] == 0) {
                    tomato[p.x + 1][p.y] = 1;
                    tmp.add(new Point(p.x + 1, p.y));
                }
                if (p.y < n - 1 && tomato[p.x][p.y + 1] == 0) {
                    tomato[p.x][p.y + 1] = 1;
                    tmp.add(new Point(p.x, p.y+1));
                }
                if (p.x > 0 && tomato[p.x - 1][p.y] == 0) {
                    tomato[p.x - 1][p.y] = 1;
                    tmp.add(new Point(p.x - 1, p.y));
                }
                if (p.y > 0 && tomato[p.x][p.y - 1] == 0) {
                    tomato[p.x][p.y - 1] = 1;
                    tmp.add(new Point(p.x, p.y-1));
                }
            }

            while (!tmp.isEmpty())
                q.add(tmp.poll());
            time++;

            /** //확인용 코드
            System.out.println(time);
            for(int[] i : tomato){
                for(int j : i)
                    System.out.print(j+" ");
                System.out.println();
            }
            System.out.println();
             **/
        }

        for(int[] i : tomato){
            for(int j : i){
                if(j == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(time-1);
    }
}
