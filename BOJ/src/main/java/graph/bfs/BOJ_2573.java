package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int num, x, y;

    Point(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class BOJ_2573 { //bfs
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //열 x
        int m = Integer.parseInt(st.nextToken()); //행 y

        Queue<Point> q = new LinkedList<>();
        int ice[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                ice[i][j] = tmp;
                if(tmp != 0) q.add(new Point(tmp, i, j));
            }
        }

        Queue<Point> tmp = new LinkedList<>();
        int time = 0;

        while(!q.isEmpty()) {
            //빙산이 녹는다
            while(!q.isEmpty()){
                Point cur = q.poll();
                if(cur.num == 0) continue; //테두리 다 0

                if(ice[cur.x-1][cur.y] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x+1][cur.y] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x][cur.y-1] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x][cur.y+1] == 0 && cur.num > 0) cur.num--;

                tmp.add(cur);
                ice[cur.x][cur.y] = cur.num;
            }
            time++;

            /**
            //확인용 코드
            for(int[] i : ice){
                for(int j : i)
                    System.out.print(j+" ");
                System.out.println();
            }
            System.out.println();
             **/

            //빙산 개수 세기
            while(!tmp.isEmpty()) {
                Point cur = tmp.poll();
                if(ice[cur.x-1][cur.y] == 0 && ice[cur.x+1][cur.y] == 0
                        && ice[cur.x][cur.y-1] == 0 && ice[cur.x][cur.y+1] == 0){
                    System.out.println(time);
                    System.exit(0);
                }
                q.add(cur);
            }
        }

        System.out.println(0);
    }
}