package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int tall[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LinkedList<Integer> location = new LinkedList<>();

            Arrays.sort(tall);

            //3까지는 어떻게 넣어도 결과 같음
            location.add(tall[0]);
            for(int i=1; i<3; i++) {
                location.add(tall[i]);
                //level = Math.max(level, tall[i]-tall[i-1]);
                status(location);
            }

            //최고값의 주변만 보기
            int last = 2;
            for(int i=3; i<n; i++){
                int left = last-1;
                int right = (last+1)%location.size();
                int lvl = tall[i] - location.get(left);
                int lvr = tall[i] - location.get(right);

                System.out.println("현재 위치는 "+last+": "+left+"번과 차이는 "+lvl+", "+right+"번과 차이는 "+lvr);
                if(lvl <= lvr) {
                    System.out.println("왼쪽에 추가");
                    location.add(left + 1, tall[i]);
                    last = left + 1;
                }
                else {
                    System.out.println("오른쪽에 추가");
                    if(right == 0) right = location.size();
                    location.add(right, tall[i]);
                    last = right;
                }
            }
            status(location);

            //레벨 최대값 구하기
            int level = Math.abs(location.get(n-1) - location.get(0));
            for(int i=1; i<n; i++)
                level = Math.max(level, Math.abs(location.get(i) - location.get(i-1)));
            sb.append(level+"\n");
        }
        System.out.println(sb);
    }

    public static void status(LinkedList<Integer> list){
        for(int i : list)
            System.out.print(i+" ");
        System.out.println();
    }
}
