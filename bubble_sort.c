#include<stdio.h>
int main()
{
	int arr[]={10,2,3,-1,11,90,45,0};
	int i,j;
	for(i=0;i<7;i++)
	{
		for(j=0;j<8-i-1;j++)
		{
			if(arr[j]>arr[j+1])
			{
				int c=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=c;
			}
		}
	}
	for(i=0;i<8;i++)
	{
		printf("%d ",arr[i]);
	}
	return 0;
}
