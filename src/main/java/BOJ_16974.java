import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16974 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        int patty = 0;

        StringBuilder sb = new StringBuilder("P");
        for(int i=0; i<n; i++){
            //sb.append("B").append(tmp).append("P").append(tmp).append("B");
            System.out.println(sb); //확인용 코드
        }

        //상도는 먹는중
        for(int i=0; i<x; i++)
            if(sb.charAt(i)=='P') patty++;

        System.out.println(patty);
    }
}