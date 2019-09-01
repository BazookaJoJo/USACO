/*
ID: jshi
LANG: JAVA
TASK: mootube
 */
import java.io.*;
import java.util.*;
class node{
	public int index;
	public long[][] connections;
	public int c;
	
	public node(int index) {
		this.index = index;
		c=0;
		connections = new long[100][2];
	}
	
	public int getC() {
		return c;
	}
	
	public void incC() {
		c+=1;
	}
}

class mootube {
	
	public static int method(long rel, long vid, node[] nodes, long prevVid) {
		int result = 0 ;
		node n = nodes[(int) vid];
		for(int i = 0; i<n.getC(); i++) {
			if(n.connections[i][0]==prevVid) {
				continue;
			}
			if(n.connections[i][1]>=rel) {
				result=result+1+method(rel, n.connections[i][0], nodes, vid);
			}
			else {
				continue;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("mootube.in"));
		PrintWriter pw = new PrintWriter(new File("mootube.out"));
		
		int videos = sc.nextInt();
		long rules = sc.nextInt();
		node[] nodes = new node[videos];
		for(int i = 0; i<videos; i++) {
			nodes[i]=new node(i);
		}
		for(int i = 0; i<videos-1; i++) {
			int index1 = sc.nextInt()-1;
			int index2 = sc.nextInt()-1;
			long relevance = sc.nextInt();
			nodes[index1].connections[nodes[index1].getC()][0]=index2;
			nodes[index1].connections[nodes[index1].getC()][1]=relevance;
			nodes[index2].connections[nodes[index2].getC()][0]=index1;
			nodes[index2].connections[nodes[index2].getC()][1]=relevance;
			nodes[index1].incC();
			nodes[index2].incC();
		}
		
		for(int i = 0; i<rules; i++) {
			long rel = sc.nextInt();
			long vid = sc.nextInt();
			pw.print(method(rel, vid-1, nodes, -1));
			if(i!=rules-1) {
				pw.println();
			}
			
		}
		pw.close();

	}

}
