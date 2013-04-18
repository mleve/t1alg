import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayGenerator {

	/**
	 * @param args
	 */
	
	private static PrintWriter resultWriter;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		resultWriter = new PrintWriter(new FileWriter("resultNanos.csv"));
		resultWriter.println("#Resultados para algoritmo: ASDFLOLQWERTY");
		
		for(int i=100000;i<=1000000;i=i+50000){
		initAndSort(i);
		resultWriter.println("######");
		}
		
		System.out.println("termine de generar inputs");
		resultWriter.close();

		/*
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
	


	private static void initAndSort(int length) {
		// TODO Auto-generated method stub
		int [][] input = new int[100][length];		
		for(int i=0;i<100;i++){
			for(int k=0;k<length;k++){
				input[i][k]=(int) Math.round(Math.random()*1000000);
			}
		}
		
		resultWriter.println("#Resultados para largo = "+length);
		resultWriter.println("#Arreglo n; tiempo");
		long init=0, end = 0;
		int lol=-1;
		//Una vez generados, hacer algo con ellos:
		for(int i=0;i<100;i++){
			init=System.nanoTime();
			//Llamada al algoritmo
			lol=quickSelect(input[i],(int)Math.floor(input[i].length/2),0,input[i].length-1);
			end=System.nanoTime();
			resultWriter.println(""+(i+1)+";"+(end-init));
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
	
	private static int quickSelect(int[] input, int posK, int initIndex, int endIndex){
		int pivotIndex = (int) Math.floor(Math.random()*(endIndex-initIndex)+initIndex);
		//int pivotIndex=2;
		//System.out.println("pivotIndex: "+pivotIndex);
		int pivotFinalPos = quickSortPartition(input,pivotIndex, initIndex,endIndex);
		if (posK == pivotFinalPos+1)
			return input[pivotFinalPos];
		else if (posK<=pivotFinalPos)
			return quickSelect(input, posK, initIndex, pivotFinalPos-1);
		else
			return quickSelect(input, posK, pivotFinalPos+1, endIndex);
	}



	private static int quickSortPartition(int[] input, int pivotIndex, int initIndex,
			int endIndex) {
		// TODO Auto-generated method stub
		int pivotValue = input[pivotIndex];
		swap(input,pivotIndex,endIndex);
		int pivotFinalPos=initIndex;
		for(int i=initIndex;i<endIndex;i++){
			if(input[i]<=pivotValue){
				swap(input,pivotFinalPos,i);
				pivotFinalPos++;
			}
		}
		swap(input,pivotFinalPos,endIndex);
		return pivotFinalPos;
	}



	private static void swap(int[] input, int ind1, int ind2) {
		// TODO Auto-generated method stub
		int aux=input[ind2];
		input[ind2]=input[ind1];
	}
	
	

}
