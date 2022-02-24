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
public class BOJ_2573 {
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행 y
        int m = Integer.parseInt(st.nextToken()); //열 x

        int ice[][] = new int[n][m]; // 빙산 현황
        Queue<Point> q = new LinkedList<>();
        Queue<Point> tmp = new LinkedList<>();
        int time = 0, count; //시간, 빙산 개수


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                ice[i][j] = num;
                if(num != 0) q.add(new Point(num, i, j));
            }
        }

        //시작
        while(!q.isEmpty()) {
            //빙산이 녹는다
            while(!q.isEmpty()){
                Point cur = q.poll();
                //경계값 조건으로 안넣어 줘도됨 (경계는 어차피 num == 0이니까)
                if(ice[cur.x-1][cur.y] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x+1][cur.y] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x][cur.y-1] == 0 && cur.num > 0) cur.num--;
                if(ice[cur.x][cur.y+1] == 0 && cur.num > 0) cur.num--;

                tmp.add(cur);
            }
            time++;

            // /**
            //확인용 코드
            for(int[] i : ice){
                for(int j : i)
                    System.out.print(j+" ");
                System.out.println();
            }
            System.out.println();
             // **/

            //빙산 개수 세기
            count = 2;
            while(!tmp.isEmpty()) {
                Point cur = tmp.poll();
                if(ice[cur.x-1][cur.y] == 0 && ice[cur.x+1][cur.y] == 0
                        && ice[cur.x][cur.y-1] == 0 && ice[cur.x][cur.y+1] == 0)
                    count--;

                if(count == 0) { //빙산 2개 이상
                    System.out.println(time);
                    System.exit(0);
                }

                ice[cur.x][cur.y] = cur.num; //빙산현황 업데이트
                q.add(cur);
            }
        }
        System.out.println(0);
    }
}