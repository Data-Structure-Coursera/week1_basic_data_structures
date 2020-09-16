
import java.util.Scanner;
import java.io.*; 

import java.lang.*; 
import java.util.*; 
import java.lang.Object.*;
import java.util.stream.Collectors;

public class Assignment1_4 {

	void helper(String[] queries) {
		
		Stack<Integer>s_main=new Stack();
		Stack<Integer>s_auxilixy=new Stack();
		
		for(String query: queries) {
			String[] Commands=query.split(" ");
			if(Commands[0].equals("push")) {
				
				int val=Integer.valueOf(Commands[1]);
				s_main.add(val);
				if(s_auxilixy.isEmpty()) {
					
					s_auxilixy.add(val);
				} else {
					int max=s_auxilixy.peek();
				
					if(val>max) {
						max=val;
					}
					s_auxilixy.add(max);
				}
				
			} else if(Commands[0].equals("pop")) {
				
				s_auxilixy.pop();
				s_main.pop();
				
			} else if(Commands[0].equals("max")) {
				
				System.out.println(s_auxilixy.peek());
			}
		}
	}
	
	public static void main(String[] args) {
		// init
		Scanner s1=new Scanner(System.in);
		Assignment1_4 main=new Assignment1_4();
		// get value from stream
		int queries_num=s1.nextInt();
		s1.nextLine();
		String[] str1=new String[queries_num];
		for(int i=0;i<queries_num;i++) {
			str1[i]=s1.nextLine();
		}
		main.helper(str1);
	}
}
