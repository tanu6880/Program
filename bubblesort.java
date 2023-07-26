class bubblesort
{
	public static void main(String args[])
	{
		int arr[] = new int[]{1,-1,20,3,5,2,4,40,56,-30};
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<10-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int t = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;

				}
			}
		}
		for(int i=0 ; i<10 ; i++)
		{
			System.out.println(arr[i]+" "); 
		}
	}
}