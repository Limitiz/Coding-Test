package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_19583 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        HashSet<String> attendance = new HashSet<>();
        int count = 0; //참석인원

        String tmp;
        while(true){
            tmp = br.readLine();
            if(tmp == null || tmp.length() == 0) break; //입력 없을때 까지 받기

            st = new StringTokenizer(tmp);
            String time = st.nextToken();
            String name = st.nextToken();
            if(time.compareTo(s) <= 0) attendance.add(name); //출석
            else if(time.compareTo(e) >= 0 && time.compareTo(q) <= 0 && attendance.contains(name)) {
                attendance.remove(name); //중복 방지
                count++;
            }
        }
        System.out.println(count);
    }
}
