class insertionsort
{
	public static void main(String args[])
	{
		int arr[] = new int[]{1,-1,20,3,5,2,4,40,56,-30};
		int j=0;
		for(int i=0;i<10;i++)
		{
			int temp=arr[i];
			for(j=i-1;j>=0;)
			{
				if(arr[j]>temp)
				{
					arr[j+1]=arr[j];
					j--;
				}
			}
			arr[j+1]=temp;
		}
		for(int i=0 ; i<10 ; i++)
		{
			System.out.println(arr[i]+" "); 
		}
	}
}