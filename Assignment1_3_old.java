package Coursera.Algorithm.course;
import java.util.Scanner;
import java.io.*; 

import java.lang.*; 
import java.util.*; 
import java.lang.Object.*;
import java.util.stream.Collectors;

public class Assignment1_3 {
	void helper() {
		
	}
	void swiftUp(LinkedList finish_time,int new_finish_time) {
		for(int i=finish_time.size()-1;i>=0;i--) {
			if(new_finish_time>finish_time.indexOf(i)) {
				finish_time.add(i+1, new_finish_time);;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s1=new Scanner(System.in);
		// init
		Assignment1_3 main12=new Assignment1_3();
		int buff_size=s1.nextInt(); 
		int pack_num=s1.nextInt();
		LinkedList<Integer> finish_time_l1=new LinkedList<>();
		Queue q1=finish_time_l1;
		ArrayList<Integer>res=new ArrayList();
		 // set the value of package infor
		for(int i=0;i<pack_num;i++) {
			int start_time=s1.nextInt();
			int proc_time=s1.nextInt();
			int finish_time=start_time+proc_time;
			
			if(q1.size()==0) {
				res.add(start_time);
				q1.add(finish_time);
				continue;
			}
			//
			int first_finish_time=(int) q1.peek();
			if(start_time>=first_finish_time) {
				res.add(start_time);
				q1.poll();
				main12.swiftUp(finish_time_l1,finish_time);
			} else if(q1.size()==buff_size) {
				res.add(-1);
			} else {
				res.add(start_time);
				main12.swiftUp(finish_time_l1,finish_time);
			}
		}
		
		// print the result
		for(int val: res) {
			System.out.println(val);
		}
		
	}
}
