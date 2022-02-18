package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_2002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int fast = 0; boolean isFast;

        for(int i=0; i<n; i++) //터널에 들어간 순서
            map.put(br.readLine(), i);

        for(int i=0; i<n; i++) { //터널에서 나온 순서
            String car = br.readLine();
            isFast = false;
            for(String key : map.keySet()) {
                if (map.get(key) < map.get(car)) {
                    isFast = true; //추월차량임
                    map.replace(key, map.get(key) + 1); //i 앞의 차들은 순서가 하나씩 밀림
                }
            }
            map.remove(car);

            if(isFast) fast++;
        }
        System.out.println(fast);
    }
}
