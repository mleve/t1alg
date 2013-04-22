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
		resultWriter = new PrintWriter(new FileWriter("CompsMedOfMed.csv"));
		resultWriter.println("#Resultados de comparaciones para medOfMed");
		
		for(int i=100000;i<=1000000;i=i+50000){
		runTest(i);
		resultWriter.println("######");
		resultWriter.flush();
		}
		resultWriter.close();
		System.out.println("Ejecucion terminada");
			
	
	}
	


	private static void runTest(int length) {
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
			//Prueba 2: Manejar 1 arreglo a la vez
			MedFinder1 finder = new MedFinder1(input[i]);
			//init=System.nanoTime();
			resultWriter.println(""+(i+1)+"; "+finder.medOfMeds(1,0,input[i].length-1));
			//finder.medOfMeds(1,0,input[i].length-1);
			//end=System.nanoTime();
			//resultWriter.println(""+(i+1)+"; "+(end-init));			
			finder=null;
			

		}

		System.out.println("Procesados arreglos de largo: "+length);		
	}
}
