package greedy;

import java.io.*;
import java.util.*;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            //입력받기
            int n = Integer.parseInt(br.readLine());

            int[] stock = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                stock[i] = Integer.parseInt(st.nextToken());

            int max = 0, sum = 0;
            for(int i=n-1; i>-1; i--){
                if(stock[i] > max) max = stock[i];
                else sum += max - stock[i];
            }

            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

}
