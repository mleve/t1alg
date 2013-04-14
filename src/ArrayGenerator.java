import java.util.Scanner;


public class ArrayGenerator {

	/**
	 * @param args
	 */
	
	private static int [][] input100k;
	private static int [][] input1000k;
	
	private static int[][][] maxMem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//input100k=initArray(100000);
			input1000k =initArray(1000000);
			//maxMem = initMax();
			
			System.out.println("termine de generar inputs");
			Scanner console = new Scanner(System.in);
			System.out.print("You're next guess? ");
			String guess = console.next();
			/*
			double val = Math.random()*1000;
			int val1 =(int)val;
			System.out.println(val);
			System.out.println(Math.round(val));
			
			
			for(int i=0;i<100;i++){
				for(int k=0;k<10000;k++){
				System.out.println(input100k[i][k]);
				}
			}
			*/
			
			
	
	}
	
	private static int[][][] initMax() {
		// TODO Auto-generated method stub
		int[][][] maxmem = new int[7][100][100000];
		for(int k=0;k<7;k++){
			for(int j=0;j<100;j++){
				for(int i=0; i<100000;i++){
					maxmem[k][j][i]=(int) Math.round(Math.random()*1000);
				}
			}
		}
		
		return maxmem;
			
	}

	private static int[][] initArray(int length) {
		// TODO Auto-generated method stub
		int [][] aux = new int[10][length];		
		for(int i=0;i<10;i++){
			for(int k=0;k<length;k++){
				aux[i][k]=(int) Math.round(Math.random()*1000);
			}
		}
		return aux;
		
	}
	
	

}
