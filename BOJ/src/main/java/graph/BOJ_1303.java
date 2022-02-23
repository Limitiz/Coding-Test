package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1303 {

    static boolean[][] chk;
    static char[][] army;
    static int n, m, count = 1;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        chk = new boolean[n][m];
        army = new char[n][m];

        for(int i=0; i<n; i++)
            army[i] = br.readLine().toCharArray();

        //따로 그래프 안만들고 탐색
        int b = 0, w = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(chk[i][j]) continue;

                chk[i][j] = true;
                if(army[i][j] == 'B'){
                    search('B', i, j);
                    b += count*count;
                    System.out.println("B "+count+"("+i+","+j+")");
                    count = 1; //count 초기화
                }
                else{
                    search('W', i, j);
                    w += count*count;
                    System.out.println("W "+count+"("+i+","+j+")");
                    count = 1; //count 초기화
                }
            }
        }
        System.out.println(w+" "+b);
    }

    public static void search(char color, int x, int y){
        chk[x][y] = true;

        if (x < n - 1 && !chk[x + 1][y] && army[x + 1][y] == color) {
            count++; search(color, x+1, y);
        }
        if (x >0 && !chk[x -1][y] && army[x -1][y] == color) {
            count++; search(color, x-1, y);
        }
        if (y < m - 1 && !chk[x][y+1] && army[x][y+1] == color) {
            count++; search(color, x, y+1);
        }
        if (y > 0 && !chk[x][y-1] && army[x][y-1] == color) {
            count++; search(color, x, y-1);
        }
    }
}
