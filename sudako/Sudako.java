package sudako;

public class Sudako {
	public static void main(String[] args) {
		int [][] board=new int[][] {
			 {5,3,0,0,0,0,0,0,0}
			,{6,0,0,1,9,5,0,0,0}
			,{0,9,8,0,0,0,0,6,0}
			,{8,0,0,0,6,0,0,0,3}
		    ,{4,0,0,8,0,3,0,0,1}
			,{7,0,0,0,2,0,0,0,6}
			,{0,6,0,0,0,0,2,8,0}
			,{0,0,0,4,1,9,0,0,5}
			,{0,0,0,0,8,0,0,7,9}};
			if(cheakBoard(board)) {
				display(board);
			}
			else {
				System.out.println("Not solved");
			}
		
	}
	static boolean cheakBoard(int [][]board) {
		int row=-1;
		int col=-1;
		boolean cheak=true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==0) {
					row=i;
					col=j;
					cheak=false;
					break;
				}
			}
			if(cheak==false) {
				break;
			}
		}
		if(cheak==true) {
			return true;
		}
		for(int num=1;num<=9;num++) {
			if(isValid(board,row,col,num)) {
				board[row][col]=num;
				if(cheakBoard(board)) {
					//display(board);
					return true;
				}
				else {
					board[row][col]=0;
				}
			}
		}
		return false;
		
	}
private static void display(int[][] board) { 
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
static boolean isValid(int[][] board,int row,int col,int number) {
	for(int i=0;i<board.length;i++) {
		 if(board[row][i]==number) {
			 return false;
		 }
	}
	for(int i=0;i<board.length;i++) {
	if(board[row][col]==number) {
			return false;
		}
	}
	int squareRoot=(int) Math.sqrt(board.length);
	int firstRow=row-row%squareRoot;
	int firstcol=col-col%squareRoot;
	for(int i=firstRow;i<firstRow+squareRoot;i++) {
		for(int j=firstcol;j<firstcol+squareRoot;j++) {
			if(board[i][j]==number) {
				return false;
			}
		}
	}
	return true;
}
}
