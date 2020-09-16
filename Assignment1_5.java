
import java.util.Scanner;
import java.io.*; 

import java.lang.*; 
import java.util.*; 
import java.lang.Object.*;
import java.util.stream.Collectors;
import java.util.ArrayDeque;
public class Assignment1_5 {
	
	public void MaxmiumSlidingWindow() {
		
		// init
		Scanner s1 = new Scanner(System.in);
		int num = s1.nextInt();
		int[] array = new int[num];
		for(int i=0; i<num; i++) {
			array[i]=s1.nextInt();
		}
		int size = s1.nextInt();
		// record the index of maximum
		ArrayDeque<Integer>deque = new ArrayDeque<Integer>();
		
		// the beginning size element
		for(int i = 0; i < num; i++) {
			
			if(deque.isEmpty()) {
				deque.add(i);
			} else {
				if(i-deque.getFirst()==size) {
					deque.removeFirst();
				}
				
				while(!deque.isEmpty() && array[i] >= array[deque.getLast()]) {
					deque.removeLast();
				}
				deque.add(i);
			}
			if(i >= size-1) {
				System.out.print(array[deque.getFirst()]);
				System.out.print(" ");
			}
		}

	}
	public static void main(String[] args) {

		Assignment1_5 main = new Assignment1_5();
		main.MaxmiumSlidingWindow();
	} 
}
