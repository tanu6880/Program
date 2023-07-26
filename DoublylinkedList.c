#include<stdio.h>
#include<stdlib.h>

struct DLL 
{
	struct DLL *prev;
	int data;
	struct DLL *Next;
};
struct DLL *start=NULL,*tail=NULL;

void create_list()
{
	struct DLL *temp ,*node,*q;
	int size,i;
	printf("\nHow many node do you want to create : ");
	scanf("%d",&size);
	for(i=1;i<=size;i++)
	{
		node=(struct DLL*)malloc(sizeof(struct DLL));
		printf("\nEnter data : ");
		scanf("%d",&node->data);
		node->prev=node->Next=NULL;
		if(start==NULL)
		{
			start=tail=node;
		}
		else
		{
			tail->Next=node;
			node->prev=tail;
			tail=node;
		}
	}
}
void display_from_start()
{	struct DLL *temp ;
	temp=start;
	while(temp!=NULL)
	{
		printf("%d ",temp->data);
		temp=temp->Next;
	}
}
void display_from_last()
{	struct DLL *temp ;
	if(tail==NULL)
		printf("\nThe list is empty\n");
	else
	{
		temp=tail;
		while(temp!=NULL)
		{
			printf("%d ",temp->data);
			temp=temp->prev;
		}
	}
}
void insertion_at_start()
{	
	struct DLL *temp ,*node,*q;
	node=(struct DLL*)malloc(sizeof(struct DLL));
	printf("\nEnter the Data :\n");
	scanf("%d",&node->data);
	node->prev=NULL;
	if(start==NULL)
	{
		node->Next=NULL;
		start=tail=node;
	}
	else
	{
		node->Next=start;
		start->prev=node;
		start=node;
	}
	
	
}
void insertion_at_last()
{	
	struct DLL *temp ,*node,*q;
	node=(struct DLL*)malloc(sizeof(struct DLL));
	printf("\nEnter the Data :\n");
	scanf("%d",&node->data);
	node->Next=NULL;
	if(start==NULL)
	{
		node->prev=NULL;
		start=tail=node;
	}
	else
	{
		node->prev=tail;
		tail->Next=node;
		tail=node;
	}
	
	
}
void deletion_from_start()
{
	struct DLL *temp ,*node,*q;
	if(start==NULL)
	{
		printf("\nEmpty deleted \n");
	}
	if(start==tail)
	{
		free(start);
		start=tail=NULL;
	}
	else
	{
		temp=start;
		start->Next->prev=NULL;
		free(temp);
		start=start->Next;
		
	}
}
void deletion_from_last()
{
	struct DLL *temp ,*node,*q;
	if(start==NULL)
	{
		printf("\nEmpty deleted \n");
	}
	if(start==tail)
	{
		free(start);
		start=tail=NULL;
	}
	else
	{
		temp=tail;
		tail->prev->Next=NULL;
		tail=tail->prev;
		free(temp);
	}
}
void insertion_at_middle()
{
	struct DLL *temp ,*node,*q;
	int i;
	printf("Enter the position of where do you want to add :");
	scanf("%d",&i);
	if(i==1)
	{
		insertion_at_start();
	}
	else
	{
		node=(struct DLL*)malloc(sizeof(struct DLL));
		printf("\nEnter the Data :\n");
		scanf("%d",&node->data);
		if(start==NULL)
		{
			node->Next=NULL;
			node->prev=NULL;
			start=tail=node;
		}
		else
		{
			temp=start;
			while(--i)
			{
				temp=temp->Next;
			}
			if(temp->Next==NULL)
			{
				temp->prev->Next=node;
				node->prev=temp->prev;
				node->Next=temp;
				temp->prev=node;
			}
 			else
			 {
 				temp->prev->Next=node;
				node->prev=temp->prev;
				node->Next=temp;
				temp->prev=node;	
			 }
		}
	}
}
void deletion_at_middle()
{
	struct DLL *temp ,*node,*q;
	int i;
	printf("Enter the position of where do you want to add :");
	scanf("%d",&i);
	if(i==1)
	{
		deletion_from_start();
	}
	else
	{
		temp=start;
		while(--i)
		{
			temp=temp->Next;
		}
		if(temp->Next==NULL)
			{
				temp->prev->Next=NULL;
				tail=temp->prev;
				free(temp);
			}
		else{
			temp->Next->prev=temp->prev;
		temp->prev->Next=temp->Next;
		free(temp);
		}
	}
}
void searching()
{
	struct DLL *temp;
	int data,i=1;
	printf("\nEnter data :");
	scanf("%d",&data);
	temp=start;
	do
	{
		if(temp->data==data)
		{
			break;
		}
		else
		{
			temp=temp->Next;
			i++;
		}
	}
	while(temp!=NULL);
	if(temp->data=data)
	{
		printf("\ndata found at location %d\n",i);
	}
	else
	{
		printf("\ndata not found at location \n");
	}
}
int main()
{	
	struct DLL *temp ,*node;
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
//			case 11:
//				break;
//			case 12:
//				break;
		}
		fflush(stdin);
		printf("\nEnter yes to continue..");
		scanf("%d",&c);
	}while(c==1);
	return 0;
}

