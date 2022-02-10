package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pw = st.nextToken();
            map.put(url, pw);
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            System.out.println(map.get(url));
            }
        }
    }
