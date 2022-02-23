 package graph.dfs;

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.Arrays;
 import java.util.LinkedList;
 import java.util.StringTokenizer;

 public class BOJ_9205 {

     static int n;
     static boolean[] chk;
     static LinkedList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            //입력받기 (배열사용)
            n = Integer.parseInt(br.readLine())+2;
            //graph 만들기 (1000m 이하만 연결)
            graph = new LinkedList[n];
            chk = new boolean[n];
            Arrays.fill(chk, false); //초기화

            int[][] pos = new int[n][3]; //num, x, y
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                pos[i][0] = i;
                pos[i][1] = Integer.parseInt(st.nextToken());
                pos[i][2] = Integer.parseInt(st.nextToken());
                graph[i] = new LinkedList<>(); //그래프 초기화
            }

            //graph 채우기
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++)
                    if(Math.abs(pos[j][1]-pos[i][1]) + Math.abs(pos[j][2]-pos[i][2]) <= 1000) {
                        graph[i].add(pos[j]);
                        graph[j].add(pos[i]);
                    }
            }

            /**
            //그래프 확인코드
            for(LinkedList<int[]> i : graph){
                for(int[] j : i)
                    System.out.print(j[0]+"("+j[1]+","+j[2]+")  ");
                System.out.println();
            }
             **/

            //dfs
            dfs(0);
            if(chk[n-1]) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static void dfs(int v){
        if(v == n-1) {
            chk[n-1] = true;
            return;
        }
        if(!chk[v]){
            chk[v] = true;
            for(int[] i : graph[v]) dfs(i[0]);
        }
    }
}