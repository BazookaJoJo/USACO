import java.io.*;
import java.util.*;

public class hayfeast {
	public static long getMinValue(long[] numbers){
		  long minValue = numbers[0];
		  for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
			  minValue = numbers[i];
			}
		  }
		  return minValue;
		}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("hayfeast.in"));
		PrintWriter pw = new PrintWriter(new File("hayfeast.out"));
		
		int n = sc.nextInt();
		long minFlavor = sc.nextLong();
		long[][] haybales = new long[n][2];
		for(int i = 0; i<n; i++) {
			haybales[i][0]=sc.nextLong();
			haybales[i][1]=sc.nextLong();
		}
		
		long maxSpice = 0;
		long[] spices = new long[n];
		long totalFlavor=0;
		int i = 0;
		for(int k = 0; k<n; k++) {
			spices[k]=0;
		}
		for(int start = 0; start<n; start++) {
			while(i<n && totalFlavor<minFlavor) {
				totalFlavor += haybales[i][0];
				if(haybales[i][1]>maxSpice) {
					maxSpice=haybales[i][1];
				}
				i++;
			}
			if(totalFlavor<minFlavor) {
				for(int j = start; j<n; j++) {
					spices[j]=1000000001;
				}
				break;
			}
			else {
			spices[start]=maxSpice;
			}
			totalFlavor-=haybales[start][0];
			if(haybales[start][1]==maxSpice) {
				maxSpice=0;
				for(int k = start+1; k<=i; k++) {
					if(haybales[k][1]>maxSpice) {
						maxSpice=haybales[k][1];
					}
				}
			}
		}
		pw.println(getMinValue(spices));
		pw.close();
		
	}

}
