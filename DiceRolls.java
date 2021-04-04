// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class DiceRolls {
	public static void main(String args[]){
		DiceRolls dr = new DiceRolls();
		int arInt[] = dr.solution(new int[] {3, 2, 4, 3}, 2, 4);
		//int arInt[] = dr.solution(new int[] {1, 5, 6}, 4, 3);
		//int arInt[] = dr.solution(new int[] {1, 2, 3, 4}, 4, 6);
		//int arInt[] = dr.solution(new int[] {3, 2, 4, 3, 6}, 1, 4);
		//int arInt[] = dr.solution(new int[] {6, 1}, 1, 4);
		for (int fill = 0; fill < arInt.length ;fill++){
			System.out.println(arInt[fill]);
        }
		
	}
    public int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8
        int sumOfMemorizedRolls = 0;
        for(int i = 0; i<A.length;i++){
            sumOfMemorizedRolls = sumOfMemorizedRolls + A[i];
        }
        int sumOfWipedRolls = 0;
        sumOfWipedRolls = (M * (A.length + F)) - sumOfMemorizedRolls;
        //System.out.println("Sum of Wiped Rolls : "+ sumOfWipedRolls);
        int resultArray[] =  new int[F];
        int MAX_ROLL_RESULT = 6; 
        if((F * MAX_ROLL_RESULT)< sumOfWipedRolls){
            //resultArray[0] = 0;
            return new int[]{0};
        }
        if(sumOfWipedRolls<=0){
            //resultArray[0] = 0;
            return new int[]{0};
        }
        if( F * MAX_ROLL_RESULT == sumOfWipedRolls ){
            for (int fill = 0; fill < resultArray.length ;fill++){
                resultArray[fill] = 6;
            }
            return resultArray;
        }
        int tempArray[] = new int [F];
        for (int fill = 0; fill < tempArray.length ;fill++){
            tempArray[fill] = 1;
        }
        if(sumOfWipedRolls < 6){
        	tempArray[0] = tempArray[0] + sumOfWipedRolls-1 ;
        }
        else if(4<sumOfWipedRolls){
        	int diff = sumOfWipedRolls - 4;
        	if (diff < 6){
        		tempArray[0] = tempArray[0] + diff ;
        	}
        	if(diff == 6){
        		tempArray[0] = tempArray[0] + diff-1 ;
        		tempArray[1] = tempArray[1] + 1;
        	}
        	if(diff>6){
        		int toAdd = diff;
        		for(int i=0;i<tempArray.length;i++){
        			if(toAdd >0 && toAdd >=5){
        				tempArray[i] = tempArray[i] + 5;
        				toAdd = toAdd - 5;
        			}
        			else{
        				tempArray[i] = tempArray[i] + toAdd;
        			}
        		}
        	}
        }
		return tempArray;
        
    }
}
