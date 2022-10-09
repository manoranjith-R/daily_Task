package forte;

public class forte {
	
	int opration(String oprator,int number1,int number2) {
		int result=0;
		switch(oprator) {
		case "+":
			result=number1+number2;
			break;
		case "-":
			result=number1-number2;
			break;
		case "/":
			result=number1/number2;
			break;
		case "*":
			result=number1*number2;
			break;
		case "join":
			result=Integer.parseInt(number1+""+number2);
			
		}
		return result;
	}
	
	String opratorPermute(int number[],int target) {
		
		String oprator[]= {"+","/","-","*"};
		outer:for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<4;k++) {
					int result=opration(oprator[i],opration(oprator[j],opration(oprator[k],number[0],number[1]),number[2]),number[3]);
					if(result==target) {
						String out=number[0]+""+oprator[k]+""+number[1]+""+oprator[j]+""+number[2]+""+oprator[i]+""+number[3];
						return out;
					}
				}
			}
		}
		return"";
	}
	void numberPermute(int number[],int target) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<4;k++) {
					for(int l=0;l<4;l++){
						   if(i != j && i != k && i != l && j != k && j!= l && k != l)
					{
						String result=opratorPermute(new int[] {number[i],number[j],number[k],number[l]},target);
						if(result!="") {
							System.out.println(result);
							return;
						}
					}
				}
			}
		}
	}
	}
	void join(int number[],int target) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<4;k++) {
					for(int l=0;l<4;l++){
					if(i!=j&&i!=k&&i!=l&&j!=k&&j!=l&&k!=l) 
					{
						try {
						numberPermute(new int[] {opration("join",number[i],number[j]),number[k],number[l],0},target);
						}catch(Exception e) {};
					}
				}
			}
		}
	}
	}
	void hackForte(int []numbers,int target) {
		 numberPermute(numbers,target);
		// join(numbers,target);
		 
	}

}
