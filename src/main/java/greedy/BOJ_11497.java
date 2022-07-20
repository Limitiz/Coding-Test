package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int tall[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int loc[] = new int[n];

            Arrays.sort(tall);

            //정규분포 모양을 만들자
            int left = n-1;
            int right = 1;

            loc[0] = tall[0];
            for (int i = 1; i < n; i++) {
                if(i%2==1) loc[left--] = tall[i];
                else loc[right++] = tall[i];
            }

            //status(loc); //확인용 코드

            //레벨 최대값 구하기
            int level = Math.abs(loc[n-1]-loc[0]);
            for (int i = 1; i < n; i++)
                level = Math.max(level, Math.abs(loc[i]-loc[i-1]));
            sb.append(level+"\n");
        }
        System.out.println(sb);
    }

    public static void status(int[] list){
        for(int i : list)
            System.out.print(i+" ");
        System.out.println();
    }
}
