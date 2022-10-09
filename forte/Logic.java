package forte;

import java.util.Scanner;

public class Logic {
	
   public static void main(String[] args) {
	   forte oprate=new forte();
	Scanner input=new Scanner(System.in);
	System.out.println("Enter Answer");
	int target=input.nextInt();
	System.out.println("Enter a Four numbers");
	int numbers[]=new int[4];
	for(int i=0;i<4;i++) {
		numbers[i]=input.nextInt();
	}
	oprate.hackForte(numbers, target);
}
}
