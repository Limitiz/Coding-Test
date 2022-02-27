package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int n, m;
    static int map[][];
    static int direc[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int shortest = 1000000;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] chk = new boolean[n][m];
        map = new int[n][m];
        for(int i=0; i<n; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        dfs(0,0,1, chk, 1);

        if(shortest < 1000000) System.out.println(shortest);
        else System.out.println(-1);
    }

    public static void dfs(int x, int y, int hit, boolean[][] chk, int count){
        if(chk[x][y]) {
            System.out.println("못했음");
            return;
        }

        chk[x][y] = true;
        System.out.println(y+","+x+"를 지난다. 현재 거리 "+count); //확인용 코드

        if(x == n-1 && y == m-1){ //도착했을때 경로
            status(chk);
            System.out.println("최단경로는 "+count); //확인용 코드
            shortest = Math.min(shortest, count); // 최단 거리 업데이트
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + direc[i][0];
            int ny = y + direc[i][1];

            if(nx<0 || nx == n || ny<0 || ny == m) continue; //IndexOutOfArray

            if (map[nx][ny] == 1) {
                if(hit == 1) {
                    System.out.println(ny + "," + nx + "의 벽을 부셨다."); //확인용 코드
                    System.out.println(y+","+x+"에서 "+ny+","+nx+"로 이동합니다.");
                    status(chk);
                    dfs(nx, ny, 0, chk, count + 1); //벽 부수기
                }
            }
            else {
                System.out.println(y+","+x+"에서 "+ny+","+nx+"로 이동합니다.");
                status(chk);
                dfs(nx, ny, hit, chk, count + 1); // 이동
            }

        }
    }

    public static void status(boolean[][] chk){
        for(boolean[] i :chk){
            for(boolean j : i) {
                if(j)
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }
    }
}
