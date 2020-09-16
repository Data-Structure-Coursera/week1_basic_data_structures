
import java.util.Scanner;
import java.io.*; 

import java.lang.*; 
import java.util.*; 
import java.lang.Object.*;
import java.util.stream.Collectors;

public class Assignment1_2 {
	class Node {
		List<Node>children;
		int val;
		Node(int val1) {
			children=new ArrayList();
			val=val1;
		}
		Node(){
			val=0;
			children=new ArrayList();
			
		}
	}
	class Pack {
		Node node;
		int height;
		Pack(Node n1, int h1) {
			node=n1;
			height=h1;
		}
	}
	int helper(int node_num, int[] priority_queue) {
		// init 
		int height; 
		Node root=null; 
		Node[] n_list=new Node[node_num]; 
		for(int i=0;i<node_num;i++) {
			n_list[i]=new Node(i);
		}
		
		// build the tree
		for(int i=0;i<priority_queue.length;i++) {
			int node_id=priority_queue[i];
			
			// root node
			if(node_id==-1) {
				root=n_list[i];
				continue;
			}
			// other node
			Node current_node=n_list[i];
			Node parent_node=n_list[node_id];
			parent_node.children.add(current_node);
		}
		// dont' care the specific case, or wrong case
		// BFS
		int max_height=0;
		Queue<Pack>q1=new LinkedList();
		Pack pack_root=new Pack(root, 1);
		q1.add(pack_root);
		// loop
		while(!q1.isEmpty()) {
			Pack p1=q1.poll();
			if(p1.height>max_height)
				max_height=p1.height;
			for(Node child : p1.node.children) {
				Pack pack_child=new Pack(child, p1.height+1);
				q1.add(pack_child);
				
			}
		}
		return max_height;
	}
	public static void main(String[] args) {
		Scanner c1=new Scanner(System.in);
		int node_num=c1.nextInt();
		int[] priority_queue=new int[node_num];
		for(int i=0;i<node_num;i++) {
			priority_queue[i]=c1.nextInt();
		}
		Assignment1_2 main=new Assignment1_2();

		int res=main.helper(node_num,priority_queue);
		System.out.print(res);
	}

}
