package _test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x;
        int y;
        Point(){}
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token=new StringTokenizer(in.readLine());
        int row = Integer.parseInt(token.nextToken());
        int col = Integer.parseInt(token.nextToken());

        int map[][]=new int[row][col];
        int visit[][]=new int[row][col];
        int ice=0, time=0; //얼음개수
        Point cur=new Point();
        boolean is_found=false;
        Queue<Point> q=new LinkedList<Point>();

        for(int i=0; i<row; i++){
            token=new StringTokenizer(in.readLine());
            for(int j=0; j<col; j++){
                map[i][j]=Integer.parseInt(token.nextToken());
                if(map[i][j]>0){ //얼음일 경우
                    ice++;
                    q.add(new Point(i, j));
                    if(is_found==false){ //??
                        is_found=true;
                        cur=new Point(i, j);
                    }

                }
            }
        }
        Stack<Point>st=new Stack<Point>();
        while(ice>0){ // 모든 빙하가 녹기 전까지
            Point next[]=new Point[1];
            next[0]=new Point(0, 0);

            //이어져 있는 빙산의 개수
            int cnt=dfs(st, map, visit, cur.x, cur.y, 0, next);
            cur=next[0];

            if(cnt!=ice){ //빙산이 하나가 아닐 경우
                System.out.println(time);
                return;
            }

            time++;
            ice-=st.size(); // 녹고 남은 빙하

            while(!st.isEmpty()){ // 녹은 빙하 업데이트
                Point tmp=st.pop();
                map[tmp.x][tmp.y]=0;
            }

        }

        System.out.println(0);
    }

    public static int dfs(Stack<Point> st, int[][] map, int visit[][],int cur_x, int cur_y, int cnt, Point[] next){

        visit[cur_x][cur_y]++;
        cnt++;

        int subtract=0;

        if(map[cur_x-1][cur_y]==0) subtract++;
        if(map[cur_x+1][cur_y]==0) subtract++;
        if(map[cur_x][cur_y-1]==0) subtract++;
        if(map[cur_x][cur_y+1]==0) subtract++;

        if(map[cur_x][cur_y]-subtract<=0) st.add(new Point(cur_x, cur_y)); //다 녹음
        else{ // 다 안녹음
            map[cur_x][cur_y]-=subtract;
            if(next[0].x==0 && next[0].y==0){
                next[0]=new Point(cur_x, cur_y);
            }
        }

        if(visit[cur_x-1][cur_y]<visit[cur_x][cur_y] && map[cur_x-1][cur_y]!=0)
            cnt=dfs(st, map, visit, cur_x-1, cur_y, cnt, next);
        if(visit[cur_x+1][cur_y]<visit[cur_x][cur_y] && map[cur_x+1][cur_y]!=0)
            cnt=dfs(st, map, visit, cur_x+1, cur_y, cnt, next);
        if(visit[cur_x][cur_y-1]<visit[cur_x][cur_y] && map[cur_x][cur_y-1]!=0)
            cnt=dfs(st, map, visit, cur_x, cur_y-1, cnt, next);
        if(visit[cur_x][cur_y+1]<visit[cur_x][cur_y] && map[cur_x][cur_y+1]!=0)
            cnt=dfs(st, map, visit, cur_x, cur_y+1, cnt, next);

        return cnt;
    }

}
