package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_2002 {
    /**
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int fast = 0;

        for(int i=0; i<n; i++) //터널에 들어간 순서
            map.put(br.readLine(), i);

        for(int i=0; i<n; i++) { //터널에서 나온 순서
            String car = br.readLine();
            for(String key : map.keySet()) {
                if (map.get(key) < map.get(car)) {
                    fast++; break; //먼저 들어간 차량 있으면 추월차량
                }
            }
            map.remove(car);
        }
        System.out.println(fast);
    }
     **/

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> fCar = new HashMap<String,Integer>();

        for(int i=0;i<N;i++) //들어가는 차량
            fCar.put(br.readLine(), i);

        int cnt = 0;
        boolean flags[] = new boolean[N];

        int lastFlag = 0;
        for(int i=0;i<N;i++){
            int num = fCar.get(br.readLine()); //현재 차량이 들어온 순서
            flags[num] = true;

            for(int j=lastFlag;j<num;j++){
                if(!flags[j]){ //앞에 차량이 안나왔으므로 추월차량
                    cnt++;  break;
                }
                else lastFlag = j; //앞에 애들은 다 true이므로 다음부터는 j 앞은 안봐도 됌
            }
        }
        System.out.println(cnt);
    }
}
