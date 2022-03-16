package map_set;

import java.util.*;
import java.io.*;

public class PG_42577 {
	
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book); //접두사를 찾는거 니까 앞의 숫자들이 겹치도록 정렬
		
		//hash set 구성
		HashSet<String> set = new HashSet();
		for(int i=0; i<phone_book.length; i++) set.add(phone_book[i]);
		
		//찾기
		for(String s : phone_book) {
		    for (int i = 0; i < s.length()-1; i++) {
               	 	String slice = s.substring(0, i + 1);
                        if (set.contains(slice)) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		//Test Set
		String[] t1 = {"119", "97674223", "1195524421"}; //false
		String[] t2 = {"123","456","789"}; //true
		String[] t3 = {"12","123","1235","567","88"}; //false
		String[] t4 = {"12", "234","456", "567", "5678"}; // false
		
		if(solution(t3)) System.out.println("test : true");
		else System.out.println("test : false");
	}
}
