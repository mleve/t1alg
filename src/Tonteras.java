
public class Tonteras {

	public static void main(String[]args){
		
		//int[] asdf={-5,-3,-2,1,2,3,5,7,9,11,13,15,20,23,24,25,26,27,29,32,33,34,35,36};
		
		int[] asdf = new int[14];
		for(int i =0;i<asdf.length;i++){
			asdf[i]=(int)(Math.random()*100);
		}
	
		
		
		MedFinder finder = new MedFinder(asdf);
		int medValue = finder.musser(3, 1, 0, asdf.length-1);
		//int medValue = finder.quickSelect(0,asdf.length-1);
		//int medValue = finder.medOfMeds(7,0,asdf.length-1);
		System.out.println("valor de la mediana: "+medValue);
		//insertionSort(asdf);
		System.out.println("hola");
		
	}
	
	
	 private static void insertionSort(int[] vector){
		  for (int i=1; i < vector.length; i++){
		    int temp = vector[i];
		    int j;
		 
		    for (j=i-1;j >= 0 && vector[j] > temp;j--){
		      vector[j + 1] = vector[j];
		 
		    }
		 
		    vector[j+1] = temp;
		  }
		}
}
