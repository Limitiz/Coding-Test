package _sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Picture> list = new ArrayList<>();
        Picture[] nominess = new Picture[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int j = Integer.parseInt(st.nextToken());
            //최초 호출
            if(nominess[j] == null)
                nominess[j] = new Picture(0,0,j,false);

            //이미 사진틀에 올라가 있음
            if(nominess[j].isExist)
                nominess[j].star++;
            //안올라가있음
            else{
                //가득참
                if(list.size() == n){
                    Collections.sort(list);
                    Picture pic = list.remove(0);
                    pic.isExist = false;
                }
                //여유있음
                    nominess[j].time = i;
                    nominess[j].star = 1;
                    nominess[j].isExist = true;
                    list.add(nominess[j]);
            }
        }

        //Collections.sort(list, Comparator.comparingInt(o -> o.no));
        Collections.sort(list, new Comparator<Picture>() {
            @Override
            public int compare(Picture o1, Picture o2) {
                return o1.no - o2.no;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Picture p : list)
            sb.append(p.no+" ");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}

class Picture implements Comparable<Picture>{
    int time;
    int star;
    int no;
    boolean isExist; //사진틀을 검색해볼 필요없음

    public Picture(int time, int star, int no, boolean isExist){
        this.time = time;
        this.star = star;
        this.no = no;
        this.isExist = isExist;
    }

    @Override
    public int compareTo(Picture o) {
        if(o.star == star){
            return time - o.time;
        }
        else return star - o.star;
    }
}
