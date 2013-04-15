import java.util.Arrays;
import java.util.Scanner;


public class ArrayGenerator {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			for(int i=100000;i<=1000000;i=i+50000){
			initArray(i);
			}
			
			System.out.println("termine de generar inputs");
			Scanner console = new Scanner(System.in);
			System.out.print("You're next guess? ");
			String guess = console.next();
			/*
			double val = Math.random()*1000;
			int val1 =(int)val;
			System.out.println(val);
			System.out.println(Math.round(val));
			
			

			*/
			
			
	
	}
	


	private static void initArray(int length) {
		// TODO Auto-generated method stub
		int [][] input = new int[100][length];		
		for(int i=0;i<100;i++){
			for(int k=0;k<length;k++){
				input[i][k]=(int) Math.round(Math.random()*1000000);
			}
		}
		//Una vez generados, hacer algo con ellos:
		for(int i=0;i<100;i++){
			Arrays.sort(input[i]);
		}
		System.out.println("Ordenados arreglos de largo: "+length);
		/*
		for(int i=0;i<100;i++){
			for(int k=0;k<10000;k++){
			System.out.println(input[i][k]);
			}
		}
		*/		
		
		
	}
	
	

}
