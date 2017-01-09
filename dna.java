import java.util.Scanner;
public class dna {
	
	public static boolean child(String bull, String cow, String child){
		boolean bool = true;
		for(int i = 0; i<25; i++){
			if(child.charAt(i)!=bull.charAt(i) && child.charAt(i)!=cow.charAt(i)){
				bool=false;
				break;
			}
			
		}
		
		return bool;
	}
	
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String[] bulls = new String[s.nextInt()];
		String[] cows = new String[s.nextInt()];
		String empty = s.nextLine();
		for(int i = 0; i<bulls.length; i++){
			bulls[i]=s.nextLine();
		}
		for(int i = 0; i<cows.length; i++){
			cows[i]=s.nextLine();
		}
		int counter = 0;
		for(int i = 0; i<bulls.length; i++){
			for(int j = 0; j<cows.length; j++){
				counter = 0;
				for(int k = 0; k<bulls.length; k++){
					if(k!=i && child(bulls[i], cows[j], bulls[k])){
						counter++;
					}
				}
				for(int k = 0; k<cows.length; k++){
					if(k!=j && child(bulls[i], cows[j], cows[k])){
						counter++;
					}
				}
				if(j==0){
				System.out.print(counter);}
				else{
					System.out.print(" " + counter);
				}
				
			}
			System.out.println("");
		}
	}

}
