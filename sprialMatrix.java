import java.util.Scanner;
class sprialMatrix
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("int row : ");
		int row = kb.nextInt();
		System.out.print("int col : ");
		int col = kb.nextInt();
		int mat[][] = new int[row][col];
		System.out.println("enter martix: ");
		input(row,col,mat);
		System.out.println("martix ");
		show(row,col,mat);
		System.out.println("martix ");
		sprial(row,col,mat);
	}
	public static void input(int row ,int col , int mat[][]) 
	{
		
		Scanner kb = new Scanner(System.in);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				mat[i][j]=kb.nextInt();
			}
		}
	}
	public static void show(int row,int col,int mat[][]) 
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void sprial(int row,int col,int mat[][]) 
	{
		int top=0;
		int bottom=row-1;
		int left=0;
		int right=col-1;

		while(top<=bottom && left<=right)
		{
			for(int i=left;i<=right;i++)
			{
				System.out.print(mat[top][i]+" ");
			}
			top++;
			for(int i=top;i<=bottom;i++)
			{
				System.out.print(mat[i][right]+" ");
			}
			right--;
			for(int i=right;i>=left;i--)
			{
				System.out.print(mat[bottom][i]+" ");
			}
			bottom--;
			for(int i=bottom;i>=top;i--)
			{
				System.out.print(mat[i][left]+" ");
			}
			left++;
		}
	}
}