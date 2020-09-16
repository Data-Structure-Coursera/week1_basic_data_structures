
import java.util.Scanner;
import java.io.*; 

import java.lang.*; 
import java.util.*; 
import java.lang.Object.*;
import java.util.stream.Collectors;

public class Assignment1_1 {
	String helper(String str1) {
		// init
		Stack<Character> s1=new Stack();
		Stack<Integer> s_index=new Stack();
		Map<Character,Character>map1= new HashMap();
		map1.put('}', '{');map1.put(')', '(');map1.put(']', '[');
		 
		//loop
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)=='('||str1.charAt(i)=='['||str1.charAt(i)=='{') {
				// when it meet the requirement;
				s1.add(str1.charAt(i));
				s_index.add(i);
			}
			// when it is close bracket
			if(str1.charAt(i)==')'||str1.charAt(i)==']'||str1.charAt(i)=='}') {
				char c_get=str1.charAt(i);
				Character c1=map1.get(c_get);
				if(s1.isEmpty()|| !s1.peek().equals(c1)) {
					return String.valueOf(i+1);
				} else {
					s1.pop();
					s_index.pop();
				}
			}
		}
		if(s1.size()==0) {
			return "Success";
		} else {
			int val = s_index.get(0)+1;
			return String.valueOf(val);
		}
	}
	public static void main(String[] args) {
		if(args.length!=0) {
			
		}
		Scanner scan1=new Scanner(System.in);
		String str1=scan1.next();
		Assignment1_1 main=new Assignment1_1();
		String res=main.helper(str1);
		System.out.print(res);
	}
}
