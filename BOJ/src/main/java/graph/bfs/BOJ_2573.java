package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int num, x, y;

    Point(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class BOJ_2573 {


    static boolean[][] chk;
    static int[][] ice;

    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행 y
        int m = Integer.parseInt(st.nextToken()); //열 x

        ice = new int[n][m]; // 빙산 현황
        chk = new boolean[n][m];
        Queue<Point> q = new LinkedList<>(); //빙산 녹이기 할때 사용
        Queue<Point> tmp = new LinkedList<>(); //빙산 현황 업데이트 할때 사용
        Queue<Point> tmp2 = new LinkedList<>(); //빙산 개수 셀때 사용
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

            //checkStatus(ice); //확인용 코드

            //빙산 현황 업데이트
            while(!tmp.isEmpty()) {
                Point cur = tmp.poll();
                ice[cur.x][cur.y] = cur.num; //빙산현황 업데이트
                if(cur.num != 0) {
                    q.add(cur); tmp2.add(cur);
                }
            }

            //빙산 개수 세기
            //초기화
            for(int i=0; i<n; i++)
                Arrays.fill(chk[i], false);
            count = 0;

            while(!tmp2.isEmpty()){
                Point cur = tmp2.poll();
                if(chk[cur.x][cur.y]) continue;

                search(cur.x, cur.y);
                count++;
            }
            //System.out.println("count = "+count); //확인용 코드
            if(count >= 2){
                System.out.println(time);
                System.exit(0);
            }
        }
        System.out.println(0);
    }

    public static void search(int x, int y){
        chk[x][y] = true;
        if(!chk[x-1][y] && ice[x-1][y] != 0) search(x-1, y);
        if(!chk[x+1][y] && ice[x+1][y] != 0) search(x+1, y);
        if(!chk[x][y-1] && ice[x][y-1] != 0) search(x, y-1);
        if(!chk[x][y+1] && ice[x][y+1] != 0) search(x, y+1);
    }

    //확인용 코드
    public static void checkStatus(int[][] ice){
        for(int[] i : ice){
            for(int j : i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
}