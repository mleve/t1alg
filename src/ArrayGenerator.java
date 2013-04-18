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
		
		System.out.println("Ejecucion terminada");

		/*
		for(int i=10000;i<=100000;i=i+10000){
		initAndSort(i);
		resultWriter.println("######");
		}
		System.out.println("termine de generar inputs");
		resultWriter.close();

		*/
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
			/*
			init=System.nanoTime();
			//Llamada al algoritmo
			
			lol=quickSelect(input[i],(int)Math.floor(input[i].length/2),0,input[i].length-1);
			end=System.nanoTime();
			resultWriter.println(""+(i+1)+";"+(end-init));			
			*/
			//Prueba 2: Manejar 1 arreglo a la vez
			MedFinder finder = new MedFinder(input[i]);
			init=System.nanoTime();
			finder.quickSelect((int)Math.floor(input[i].length/2),0,input[i].length-1);
			end=System.nanoTime();
			resultWriter.println(""+(i+1)+";"+(end-init));			
			finder=null;

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
