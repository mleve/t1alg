import java.util.Arrays;


public class MedFinder {

	/*Clase que recibe un arreglo en su constructor y encuentra su mediana
	 * Por alguno de los metodos
	 * */
	private int[] input;

	
	public MedFinder(int[] input){
		this.input=input;
	}
	

	
	public int quickSelect(int posK, int initIndex, int endIndex){
		int pivotIndex = (int) Math.floor(Math.random()*(endIndex-initIndex)+initIndex);
		//int pivotIndex=2;
		//System.out.println("pivotIndex: "+pivotIndex);
		int pivotFinalPos = quickSortPartition(pivotIndex, initIndex,endIndex);
		if (posK == pivotFinalPos+1)
			return input[pivotFinalPos];
		else if (posK<=pivotFinalPos)
			return quickSelect(posK, initIndex, pivotFinalPos-1);
		else
			return quickSelect(posK, pivotFinalPos+1, endIndex);
	}



	private int quickSortPartition(int pivotIndex, int initIndex,
			int endIndex) {
		// TODO Auto-generated method stub
		int pivotValue = input[pivotIndex];
		swap(pivotIndex,endIndex);
		int pivotFinalPos=initIndex;
		for(int i=initIndex;i<endIndex;i++){
			if(input[i]<=pivotValue){
				swap(pivotFinalPos,i);
				pivotFinalPos++;
			}
		}
		swap(pivotFinalPos,endIndex);
		return pivotFinalPos;
	}



	private void swap(int ind1, int ind2){
		// TODO Auto-generated method stub
		int aux=input[ind2];
		input[ind2]=input[ind1];
		input[ind1]=aux;
	}
	
	private int medOfMeds(int []thyInput, int elParam){
		//Genero un subArreglo de medianas
		int newLength = Math.round(thyInput.length/(2*elParam+1));
		int[] newInput = new int[newLength];
		for(int i=0;i<newLength;i++){
			newInput[i]=getMedian(Arrays.copyOfRange(thyInput, i, (2*elParam+1)));
		}
		//
		
		return -1;
	}



	private int getMedian(int[] subArray) {
		// TODO Auto-generated method stub
		Arrays.sort(subArray);
		int medIndex =Math.round(subArray.length/2);
		return subArray[medIndex];
	}
	
}
