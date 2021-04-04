package Practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Attendance {
	
	public static void main (String a[]){
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
	    int totalStudents = myObj1.nextInt();  // Read user input
	    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
	    String rollCalls = myObj2.nextLine();
	    String rollArrays[] = rollCalls.split(" ");
	    Set<String> set = new HashSet<>();
	    Collections.addAll(set, rollArrays); 
	    	    
	    boolean classStudents[] = new boolean [totalStudents];
	    for (String roll : set ){
	    	int temp = Integer.parseInt(roll);
	    	if(temp < 0){
	    		System.out.println(0);
	    		}
	    	if(temp > 0 && temp<=totalStudents){
	    		classStudents[temp-1] = true;}
	    }
	    String output = "";
	    for (int i=0 ; i<totalStudents;i++){
	    	if (!classStudents[i]){
	    		if(output.length()==0){
	    			output = i+1+"";
	    		}
	    		else{ output = output + " " + (i+1)+"";}
	    	}
	    }
	    System.out.println(output);
	    System.out.println(checkMethod());
	}

	private static int[] checkMethod() {
		// TODO Auto-generated method stub
		return new int[0];
	}
}
