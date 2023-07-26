#include<stdio.h>

int main()
{
	int arr[]={10,2,3,-1,11,90,45,0};
	int i,j;
	for(i=0;i<8;i++)
	{
		for(j=i+1;j<8;j++)
		{
			if(arr[i]>arr[j])
			{
				int c=arr[i];
				arr[i]=arr[j];
				arr[j]=c;
			}
		}
	}
	for(i=0;i<8;i++)
	{
		printf("%d ",arr[i]);
	}
	return 0;
}
