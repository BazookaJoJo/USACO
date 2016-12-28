import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class ride {
	public static void main(String[] args) throws IOException{
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String comet = s.readLine();
		String group = s.readLine();
		char a = comet.charAt(0);
		int cometResult = 1;
		int groupResult = 1;
		
		for(int i = 0; i<comet.length(); i++){
			cometResult *= comet.charAt(i)-'A'+1;
		}

		for(int i = 0; i<group.length(); i++){
			groupResult *= group.charAt(i)-'A'+1;
		}
		if(groupResult%47 == cometResult%47){
			System.out.println("GO");
		}
		else{
			System.out.println("STAY");
		}
		
	}

}
