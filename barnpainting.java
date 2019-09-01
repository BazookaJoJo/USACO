import java.io.*;
import java.util.*;

class Barn{
	public int index;
	public int color;
	public boolean one;
	public boolean two;
	public boolean three;
	public Barn(int index, int color) {
		this.index=index;
		this.color=color;
		this.one=true;
		this.two=true;
		this.three=true;
	}
	public int getIndex() {
		return index;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color=color;
	}
	public int calcNeighbors() {
		return 0;
	}
	public void setOne(boolean bool) {
		this.one = bool;
	}
	public void setTwo(boolean bool) {
		this.two = bool;
	}
	public void setThree(boolean bool) {
		this.three = bool;
	}
	public int getNeighbors() {
		int num = 0;
		if(this.one) num++;
		if(this.two) num++;
		if(this.three) num++;
		if(num == 2 || num == 3) {
			return 2;
		}
		else if(num==1){
			return 1;
		}
		else {
			return 0;
		}
	}
}

public class barnpainting {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("barnpainting.in"));
		PrintWriter pw = new PrintWriter(new File("barnpainting.out"));
		
		int num = sc.nextInt();
		int def = sc.nextInt();
		long result = 1;
		Barn[] barns = new Barn[num];
		int[][] connections = new int[num-1][2];
		for(int i = 0; i<num-1; i++) {
			connections[i][0]=sc.nextInt();
			connections[i][1]=sc.nextInt();
		}
		for(int i = 0; i<num; i++) {
			barns[i]=new Barn(i+1, 0);
		}
		
		for(int i = 0; i<def; i++) {
			int index = sc.nextInt();
			int color = sc.nextInt();
			barns[index-1].setColor(color);
			barns[index-1].setOne(false);
			barns[index-1].setTwo(false);
			barns[index-1].setThree(false);
			if(color==1) {
				barns[index-1].setOne(true);
			}
			else if(color==2) {
				barns[index-1].setTwo(true);
			}
			else if(color==3) {
				barns[index-1].setThree(true);
			}
		}
		
		if(def == 0) {
			result=(long) (3*Math.pow(2, num-1));
			pw.println(result);
			pw.close();
		}
		
		for(int i = 0; i<connections.length; i++) {
			int node1=connections[i][0]-1;
			int node2=connections[i][1]-1;
			int color1=barns[node1].getColor();
			int color2=barns[node2].getColor();
			if(color1!=0 && color2==0) {
				if(color1==1) {
					barns[node2].setOne(false);
				}
				if(color1==2) {
					barns[node2].setTwo(false);
				}
				if(color1==3) {
					barns[node2].setThree(false);
				}
			}
			if(color2!=0 && color1==0) {
				if(color2==1) {
					barns[node1].setOne(false);
				}
				if(color2==2) {
					barns[node1].setTwo(false);
				}
				if(color2==3) {
					barns[node1].setThree(false);
				}
			}
			
		}
		
		for(int i = 0; i<num; i++) {
			result*=barns[i].getNeighbors();
		}
		pw.println(result);
		pw.close();
	}

}
