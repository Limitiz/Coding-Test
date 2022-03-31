package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1080 {
    static int[][] a, b;

    public static void main(String[] args) throws IOException {
        //크기 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //n이나 m이 3보다 작으면 변환 불가능
        if(n<3 || m<3){
            if(Arrays.deepEquals(a,b)) System.out.println(0);
            else System.out.println(-1);
            System.exit(0);
        }

        //배열 입력
        a = new int[n][m];
        b = new int[n][m];
        for(int i=0; i<n; i++)
            a[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<n; i++)
            b[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        //(0,0)부터 시작해서 가장자리를 공략해보자
        int count = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if(a[i][j] != b[i][j]) {
                    transform(i,j);
                    count++;
                }
                //status(a); System.out.println(); //확인용 코드
            }
        }

        //똑같은지 확인하는 함수
        if(Arrays.deepEquals(a,b)) System.out.println(count);
        else System.out.println(-1);
    }

    // 3x3행렬 비트반전 함수
    public static void transform(int x, int y){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                a[x+i][y+j] = Math.abs(a[x+i][y+j]-1); //비트반전
       }
    }

    //확인용 코드
    public static void status(int[][] arr){
        for(int[] i: arr){
            for(int j : i)
                System.out.print(j+" ");
            System.out.println();
        };
    }
}
