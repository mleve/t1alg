
public class Tonteras {

	public static void main(String[]args){
		
		//int[] asdf={4,3,2,5,1,7,9,2,0,-3,-4,1,-1};
		int[] asdf = new int[1000000];
		for(int i =0;i<asdf.length;i++){
			asdf[i]=(int)(Math.random()*100000);
		}
		/*
		int medValue=quickSelect(asdf,(int)Math.floor(asdf.length/2),0,asdf.length-1);
		*/
		MedFinder finder = new MedFinder(asdf);
		int medValue = finder.quickSelect((int)Math.floor(asdf.length/2),0,asdf.length-1);
		System.out.println("valor de la mediana: "+medValue);
		
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
		input[ind1]=aux;
	}
}
