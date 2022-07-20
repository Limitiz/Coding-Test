package _test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main6 {
    static int n;
    static class Hunt{
        int enter;
        int exp;
        int dis[];
        public Hunt(int enter, int exp){
            this.enter = enter;
            this.exp = exp;
            dis = new int[n];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken())+1;
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Hunt> g = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            g.add(new Hunt(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n; j++)
                g.get(i).dis[j] = Integer.parseInt(st.nextToken());
        }
    }
}
