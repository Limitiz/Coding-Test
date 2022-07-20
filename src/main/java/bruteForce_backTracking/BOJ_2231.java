package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int generator = 0;
        for(int i=1;i<n; i++){
            generator = i+i%10;
            for(int j=i/10; j>0; j/=10)
                generator += j%10;
            if(generator == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        br.close();
    }
}
