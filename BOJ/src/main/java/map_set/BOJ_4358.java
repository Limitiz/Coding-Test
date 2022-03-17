package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_4358 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //출력이 많으니까 StringBuilder 사용

        //key=이름, value=개수, 나중에 오름차순으로 출력해야하니까 TreeSet
        TreeMap<String, Integer> tree = new TreeMap();
        int n = 0; //입력 개수

        while(true){
            String name = br.readLine();
            if(name == null || name.length() == 0) break; //입력 없을때까지 받기
            
            if(tree.containsKey(name)) tree.replace(name, tree.get(name)+1);
            else tree.put(name, 1);
            n++;
        }

        //출력
        for(String key : tree.keySet())
            sb.append(key+" "+Math.round(tree.get(key)*10000/10000.0)+"\n");
        System.out.println(sb);
    }
}
