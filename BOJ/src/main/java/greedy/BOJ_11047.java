package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] price = new int[n];
        for(int i=0; i<n; i++)
            price[i] = Integer.parseInt(br.readLine());

        //역순으로 접근
        int count = 0;
        for(int i=n-1; i>=0; i--){
            if(k == 0) break;
            if(k/price[i] == 0) continue;

            count += k/price[i];
            k = k%price[i];
        }

        System.out.println(count);
    }
}
