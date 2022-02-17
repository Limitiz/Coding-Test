package greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long A, B, answer=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(0,A);
        if(answer < 0) System.out.println(-1);
        else System.out.println(answer+1);
    }

    public static void dfs(int depth, long number) {
        if(B < number) { // 숫자가 B보다 커지면 종료
            return ;
        }else if(B == number) { // 숫자와 B가 같다면 depth 저장
            answer = depth;
            return;
        }
        dfs(depth+1, number*2); // 2를 곱하는 경우
        dfs(depth+1, number*10 +1); // 1을 수의 오른쪽에 추가하는 경우
    }
}