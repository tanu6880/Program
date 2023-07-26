#include<stdio.h>
#include<stdlib.h>
struct SCLL 
{
	int data;
	struct SCLL *Next;
};
struct SCLL *start = NULL;
void create_list()
{
	struct SCLL *temp ,*node;
	int size,i;
	printf("\nHow many node do you want to create : ");
	scanf("%d",&size);
	for(i=1;i<=size;i++)
	{
		node=(struct SCLL*)malloc(sizeof(struct SCLL));
		printf("\nEnter data : ");
		scanf("%d",&node->data);
		node->Next=start;
		if(start==NULL)
		{
			start = node;
			start->Next=start;
		}
		else
		{
			temp=start;
			while(temp->Next!=start)
			{
				temp=temp->Next;
			}
			temp->Next=node;
		}
	}
}
void display_from_start()
{
	struct SCLL *temp ,*node;
	temp=start;
	do
	{
		printf(" %d ",temp->data);
		temp=temp->Next;
	}
	while(temp!=start);
}
void display_from_last(struct SCLL *temp)
{
	if(temp->Next!=start)
	{
		display_from_last(temp->Next);
	}
	printf(" %d ",temp->data);
}
void insertion_at_start()
{
	struct SCLL *temp ,*node;
	node=(struct SCLL*)malloc(sizeof(struct SCLL));
	printf("\nEnter data : ");
	scanf("%d",&node->data);
	node->Next=start;	
	if(start==NULL)
	{
		start=node;
		start->Next=start;
	}
	else
	{
		temp=start;
		while(temp->Next!=start)
		{
			temp=temp->Next;
		}
		temp->Next=node;
		start=node;
	}
}
void insertion_at_last()
{
	struct SCLL *temp ,*node;
	node=(struct SCLL*)malloc(sizeof(struct SCLL));
	printf("\nEnter data : ");
	scanf("%d",&node->data);
	node->Next=start;	
	if(start==NULL)
	{
		start=node;
		start->Next=start;
	}
	else
	{
		temp=start;
		while(temp->Next!=start)
		{
			temp=temp->Next;
		}
		temp->Next=node;
		node->Next=start;
	}
}
void deletion_from_start()
{
	struct SCLL *temp ,*node;
	if(start==NULL)
	{
		printf("list is empty ");
	}
	else if(start->Next==start)
	{
		free(start);
		start=NULL;
	}
	else
	{
		temp=start;
		node=start;
		while(temp->Next!=start)
		{
			temp=temp->Next;
		}
		temp->Next=start->Next;
		start=start->Next;
		free(node);
	}
	
}
void deletion_from_last()
{
	struct SCLL *temp ,*node;
	if(start==NULL)
	{
		printf("list is empty ");
	}
	else if(start->Next==start)
	{
		free(start);
		start=NULL;
	}
	else
	{
		temp=start;
		while(temp->Next!=start)
		{
			node=temp;
			temp=temp->Next;
		}
		node->Next=temp->Next;
		free(temp);
	}
}
void insertion_at_middle()
{	int n,i;
	struct SCLL *temp ,*node,*q;
	printf("\nenter postion where do you want to add : ");
	scanf("%d",&n);
	if(n==1)
	{
		insertion_at_start();
	}
	else
	{	temp=start;
		i=0;
		do{
			i++;
			temp=temp->Next;
		}while(temp!=start);
		if(n>i)
			printf("\nposition does not exits\n");
		else
		{
			temp=start;
			while(--n)
			{
				temp=temp->Next;
			}
			node=(struct SCLL*)malloc(sizeof(struct SCLL));
			printf("\nEnter data : ");
			scanf("%d",&node->data);
			if(temp->Next==start)
			{
				temp->Next=node;
				node->Next=start;
			}
			else
			{
				node->Next=temp->Next;
				temp->Next=node;	
			}
		}
	}
		
}
void deletion_at_middle()
{
	int n,i=0;
	struct SCLL *temp ,*node,*q;
	printf("\nenter postion where do you want to delet : ");
	scanf("%d",&n);
	temp=start;
	if(n==1)
		deletion_from_start();	
	else
	{
		do
		{
			i++;
			temp=temp->Next;
		}while(temp!=start);
		if(n>i)
			printf("\nposition does not exits \n");
		else
		{
			temp=start;
			while(--n)
			{	node=temp;
				temp=temp->Next;
			}
			node->Next=temp->Next;
			free(temp);
			
		}
	}
}
void searching()
{
	struct SCLL *temp ,*node;
	temp=start;
	int i=1,data;
	printf("\nEnter the data : \n");
	scanf("%d",&data);
	do
	{
		if(data==temp->data)
		{
			break;
		}
		i++;
		temp=temp->Next;
	}while(temp->Next!=start);
	if(temp->data==data)
	{
		printf("%d Data found at location %d",data,i);
	}
	else
	{
		printf("\ndata not found\n");
	}
}
int main()
{
	struct SCLL *temp ,*node;
	int choice,c;
	do 
	{
		printf("\n1.Create node");
		printf("\n2.Display from begening");
		printf("\n3.Display from ending");
		printf("\n4.Intersion at begening ");
		printf("\n5.Intersion at last ");
		printf("\n6.Delesion from begining");
		printf("\n7.Delesion from ending");
		printf("\n8.Intersion at middle");
		printf("\n9.Intersion at delete");
		printf("\n10.searching");
		printf("\n11.sorting");
		printf("\n12.count");
		printf("\nEnter your choice : ");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				create_list();
				break;
			case 2:
				display_from_start();
				break;
			case 3:
				temp=start;
				display_from_last(temp);
				break;
			case 4:
				insertion_at_start();
				break;
			case 5:
				insertion_at_last();
				break;
			case 6:
				deletion_from_start();
				break;
			case 7:
				deletion_from_last();
				break;
			case 8:
				insertion_at_middle();
				break;
			case 9:
				deletion_at_middle();
				break;
			case 10:
				searching();
				break;
			case 11:
				break;
			case 12:
				break;
		}
		fflush(stdin);
		printf("\nEnter yes to continue..");
		scanf("%d",&c);
	}while(c==1);
	return 0;
}
