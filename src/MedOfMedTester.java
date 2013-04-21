import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class MedOfMedTester {

	/**
	 * @param args
	 */

	private static PrintWriter resultWriter;	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		resultWriter = new PrintWriter(new FileWriter("/u/a/2011/mleveron/kMedOfMedTimes.csv"));
		resultWriter.println("Prueba de K mediana de medianas");
		int[][] elInput = new int[100][1000000];
		for(int i=0;i<elInput.length;i++){
			for(int k=0;k<elInput[0].length;k++){
				elInput[i][k]=(int) Math.round(Math.random()*1000000);
			}
			
		}
		long init,end;
		for(int k=1;k<20;k++){
			System.out.println("Inicio ordenacion para K="+k);
			resultWriter.println("Tiempo de ejecucion para K="+k);
			for(int i=0;i<100;i++){
				MedFinder finder = new MedFinder(elInput[i]);
				init=System.nanoTime();
				finder.medOfMeds(k,0,elInput[i].length-1);
				//resultWriter.println(finder.medOfMeds(k,0,elInput[i].length-1));
				end=System.nanoTime();
				resultWriter.println(end-init);
				finder=null;
				
			}
			resultWriter.println("######");
			resultWriter.flush();
		}
		resultWriter.close();
		System.out.println("Ejecucion terminada");
		
		
	}

}
