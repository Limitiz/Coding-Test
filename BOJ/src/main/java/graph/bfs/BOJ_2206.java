package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y,dist;
    boolean hit;

    Point(int x, int y, int dist, boolean hit){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.hit = hit;
    }
}

public class BOJ_2206 {

    static int n, m;
    static int map[][];
    static boolean[][][] chk;
    static int direc[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chk = new boolean[n][m][2]; //0 벽 안부시고 탐색, 1 벽 부시고 탐색
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0 ;j<m; j++)
                map[i][j] = str.charAt(j)- '0';
        }
        
        System.out.println(bfs(0,0, 1)); //최단거리 구하는거니까 bfs 적합
    }

    public static int bfs(int x, int y, int count) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, count, false));

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == n-1 && cur.y == m-1) return cur.dist; //도착

            for(int i=0; i<4; i++) {
                int nx = cur.x + direc[i][0];
                int ny = cur.y + direc[i][1];

                if (nx < 0 || nx == n || ny < 0 || ny == m) continue; //IndexOutOfArray

                if (map[nx][ny] == 0) { //벽이 아님
                    if (!chk[nx][ny][0] && !cur.hit) { //벽을 부신적이 없으면 chk[][][0] 방문
                        q.add(new Point(nx, ny, cur.dist + 1, false));
                        chk[nx][ny][0] = true;
                    } else if (!chk[nx][ny][1] && cur.hit) { //벽을 부신적이 있으면 chk[][][1] 방문
                        q.add(new Point(nx, ny, cur.dist + 1, true));
                        chk[nx][ny][1] = true;
                    }
                } else { //벽임
                    if (!cur.hit) {
                        q.add(new Point(nx, ny, cur.dist + 1, true));
                        chk[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
