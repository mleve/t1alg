import java.util.Arrays;


public class MedFinder1 {

	/*Clase que recibe un arreglo en su constructor y encuentra su mediana
	 * Por alguno de los metodos
	 * */
	private int[] input;
	private int iters=0;

	
	public MedFinder1(int[] input){
		this.input=input;
	}
	

	
	public int quickSelect(int initIndex, int endIndex){
		int pivotIndex = (int) Math.floor(Math.random()*(endIndex-initIndex)+initIndex);
		int pivotFinalPos = quickSortPartition(pivotIndex, initIndex,endIndex);
		iters++;
		if (input.length/2 == pivotFinalPos)
			return iters;
		else if (input.length/2 <= pivotFinalPos)
			return quickSelect(initIndex, pivotFinalPos-1);
		else
			return quickSelect(pivotFinalPos+1, endIndex);
	}



	private int quickSortPartition(int pivotIndex, int initIndex,
			int endIndex) {
		// TODO Auto-generated method stub
		int pivotValue = input[pivotIndex];
		swap(pivotIndex,endIndex);
		int pivotFinalPos=initIndex;
		for(int i=initIndex;i<endIndex;i++){
			iters++;
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
	
	public int medOfMeds( int elParam, int startPos, int endPos){
		//Obtener la mediana de medianas
		int median=medPivotValue(Arrays.copyOfRange(input, startPos, endPos+1),elParam,0,endPos-startPos);
		//Particionar usando esta mediana
		int[] indices=medOfMedsPartition(median);
		//Si la mediana quedo en la posicion n/2 , retornamos (es efectivamente la mediana del arreglo input)
		//if(input.length%2==0){
		//	int aux= (input.length-1)/2;
		//	if((input[aux]+input[aux+1])/2==median)
		//		return median;
		//}
		iters=iters+3;
		if(input[(input.length)/2]==median)
			return iters;
		//hubo recursion hasta obtener un solo candidato: 
		if(startPos==endPos){
			int aux=(input.length-1)/2;
			return iters;
		}
			
		if((input.length/2)<indices[0])
			return medOfMeds(elParam,startPos,indices[0]-1);
		else
			return medOfMeds(elParam,indices[1],endPos);

	}

	private int[] medOfMedsPartition(int median) {
		int minIndex=0, equalIndex=0;
		int[] aux=input;
		for(int i=0;i<input.length;i++){
			iters=iters+2;
			if(aux[i]<median){
				if(minIndex==i)
					input[i]=aux[i];
				else{
					input[i]=aux[i];
					if(minIndex==equalIndex)
						swap(i,minIndex);
					else{
						swap(i,minIndex);
						swap(i,equalIndex);
					}
				}
				minIndex++;
				equalIndex++;
					
			}
			else if(aux[i]==median){
				input[i]=aux[i];
				if(equalIndex<i)
					swap(i,equalIndex);
				equalIndex++;
			}
			else{
				input[i]=aux[i];
			}
		}
		return new int[]{minIndex,equalIndex};
		
	}



	public int medPivotValue(int[] thyInput,int elParam, int startPos,int endPos){
		//Retorna el valor de la mediana de medianas, que sera usado como pivote
		iters++;
		//Condicion de termino, el arreglo es <= 2*elParam+1
		if((endPos-startPos+1)<=(2*elParam+1))
			return getMedian(Arrays.copyOfRange(thyInput, startPos, endPos+1));
		//Genero un subArreglo de medianas
		int subArraysLengths = 2*elParam+1;
		double asdf = (double)(endPos-startPos+1)/(2*elParam+1);
		int medArrayLength = (int)Math.ceil(asdf);
		int[] newInput = new int[medArrayLength];
		int k=0;
		for(int i=startPos;i<endPos+1;i=i+subArraysLengths){
			iters++;
			if((i+subArraysLengths)>(endPos+1))
				newInput[k]=getMedian(Arrays.copyOfRange(thyInput, i, endPos+1));
			else
				newInput[k]=getMedian(Arrays.copyOfRange(thyInput, i, i+subArraysLengths));
			k++;
		}
		return medPivotValue(newInput,elParam,0,newInput.length-1);
	}


	private int getMedian(int[] subArray) {
		// TODO Auto-generated method stub
		//Arrays.sort(subArray);
		insertionSort(subArray);
		int medIndex =subArray.length/2;
		//if(subArray.length%2==0)
		//	return ((subArray[medIndex-1]+subArray[medIndex])/2);
		//else
			return subArray[medIndex];
	}
	
	 private void insertionSort(int[] vector){
		  for (int i=1; i < vector.length; i++){
		    int temp = vector[i];
		    int j;
		 
		    for (j=i-1;j >= 0 && vector[j] > temp;j--){
		      iters++;
		      vector[j + 1] = vector[j];
		 
		    }
		 
		    vector[j+1] = temp;
		  }
		}
	
}
