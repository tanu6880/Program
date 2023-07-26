#include<stdio.h>
#define size 5
void Queue(int queue[] ,int *rear,int *front)
{
	if(*rear==size-1)
	{
		printf("\nthe queue is overflow\n");
	}
	else
	{
		int data;
		printf("\nEnter the data :");
		scanf("%d",&data);
		if(*front==-1)
		{
			*front=*rear=0;
			queue[*rear]=data;
		}
		else
		{
			queue[++*rear]=data;
		}
		
	}
}
void deque(int queue[],int *front,int *rear)
{
	if(*front==-1)
	{
		printf("\nthe queue is Underflow\n");
	}
	else
	{
		
		if(*front>*rear)
		{
			*front=*rear=-1;
			printf("\nthe queue is empty\n");
		}
		else
		{
			queue[*front]=0;
			++*front;
		}
		
	}
}
void display(int queue[])
{
	int i=0;
	for(i=0;i<size;i++)
	{
		printf(" %d ",queue[i]);
	}
}

int main()
{
	int queue[size],choice,front=-1,rear=-1;
	do
	{
		printf("\n1.enque \n2.deque \n3.display\nEnter your choice num : ");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				Queue(queue,&rear,&front);
				break;
			case 2:
				deque(queue,&front,&rear);
				break;
			case 3:
				display(queue);
				break;
		}
		printf("\nif you want to continue : ");
		scanf("%d",&choice);
	}while(choice==1);
	return 0;
}
