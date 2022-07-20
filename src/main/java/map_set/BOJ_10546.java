package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10546{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> runner = new HashMap<String, Integer>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(runner.containsKey(s))
                runner.replace(s,runner.get(s)+1);
            else
                runner.put(s,1);
        }

        for(int i=0; i<n-1; i++) {
            String s = br.readLine();
            runner.replace(s, runner.get(s)-1);
        }

        for(String key : runner.keySet()){
            if(runner.get(key) != 0){
                System.out.println(key);
                break;
            }
        }
    }
}