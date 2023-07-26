class selectionsort
{
	public static void main(String []args)
	{
		int arr[] = new int[]{1,-1,20,3,5,2,4,40,56,-30};
		for(int i=0 ; i<9 ; i++)
		{
			for(int j=i+1 ; j<10 ; j++)
			{
				if(arr[i]>arr[j])
				{
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				}
			}
		}
		for(int i=0 ; i<10 ; i++)
		{
			System.out.println(arr[i]+" "); 
		}
	}
}