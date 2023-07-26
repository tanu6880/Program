#include<stdio.h>
#include<stdlib.h>
struct DCLL
{
	int data;
	struct DCLL *prev;
	struct DCLL *Next;
};
struct DCLL *start = NULL, *tail = NULL;

void create_list()
{
	struct DCLL *temp , *node;
	int size,i;
	printf("\nEnter size of node do you want to create \n");
	scanf("%d",&size);
	for(i=0;i<size;i++)
	{
		node=(struct DCLL *)malloc(sizeof(struct DCLL ));
		printf("\nEnter data : ");
		scanf("%d",&node->data);
		node->prev = NULL;
		if(start==NULL)
		{
			start = tail = node;
			node->Next = tail;
			node->prev = start;
		}
		else
		{
			temp=start;
			while(temp->Next!=start)
			{
				temp=temp->Next;		
			}
			temp->Next=node;
			node->prev=temp;
			node->Next=start;
			start->prev=node;
			tail=node;
		}
	}
}
void display_from_start()
{
	struct DCLL *temp , *node;
	temp =start;
	do
	{
		printf("%d ",temp->data);
		temp=temp->Next;
	}
	while(temp!=start);
}
void display_from_last()
{
	struct DCLL *temp;
	temp=tail;
	do
	{
		printf("%d ",temp->data);
		temp=temp->prev;
	
	}
	while(temp!=tail);
}
void insertion_at_start()
{
	struct DCLL *temp ,*node;
	node = (struct DCLL*)malloc(sizeof(struct DCLL));
	printf("\nEnter data : ");
	scanf("%d",&node->data);	
	if(start==NULL)
	{
		start = tail = node;
		node->Next = tail;
		node->prev = start;
	}
	else
	{
		node->Next=start;
		start->prev=node;
		tail->Next=node;
		node->prev=tail;
		start=node;
	}
}
void insertion_at_last()
{
	struct DCLL *temp ,*node;
	node = (struct DCLL*)malloc(sizeof(struct DCLL));
	printf("\nEnter data : ");
	scanf("%d",&node->data);	
	if(start==NULL)
	{
		start = tail = node;
		node->Next = tail;
		node->prev = start;
	}
	else
	{
		node->Next=start;
		start->prev=node;
		tail->Next=node;
		node->prev=tail;
		tail=node;
	}
}
void deletion_from_start()
{
	struct DCLL *temp ,*node;
	if(start==NULL)
	{
		printf("\nlist empty\n");
	}
	else if(start==tail)
	{
		start=tail=NULL;
		free(start);
	}
	else
	{
		start->Next->prev=tail;
		tail->Next=start->Next;
		temp=start;
		start=start->Next;
		free(temp);
		
	}
}
void deletion_from_last()
{
	struct DCLL *temp ,*node;
	if(tail==NULL)
	{
		printf("\nlist empty\n");
	}
	else if(start==tail)
	{
		start=tail=NULL;
		free(start);
	}
	else
	{
		tail->prev->Next=start;
		start->prev=tail->prev;
		temp=tail;
		tail=tail->prev;
		free(temp);
		
	}
}
void insertion_at_middle()
{
	struct DCLL *temp ,*node,*q;
	int i;
	printf("Enter the position of where do you want to add :");
	scanf("%d",&i);
	if(i==1)
	{
		insertion_at_start();
	}
	else
	{
		node=(struct DCLL*)malloc(sizeof(struct DCLL));
		printf("\nEnter the Data :\n");
		scanf("%d",&node->data);
		if(start==NULL)
		{
			start = tail = node;
			node->Next = tail;
			node->prev = start;
		}
		else
		{
			temp=start;
			while(--i)
			{
				temp=temp->Next;
			}			
			node->Next=temp;
			node->prev=temp->prev;
			temp->prev->Next=node;
			temp->prev=node;
	
		}
	}
}
void deletion_at_middle()
{
	struct DCLL *temp ,*node,*q;
	int i;
	printf("Enter the position of where do you want to delete :");
	scanf("%d",&i);
	if(i==1)
	{
		deletion_from_start();
	}
	else
	{
		node=(struct DCLL*)malloc(sizeof(struct DCLL));
		if(start==NULL)
		{
			printf("\nempty list\n");
		}
		else
		{
			temp=start;
			while(--i)
			{
				temp=temp->Next;
			}			
			temp->prev->Next=temp->Next;
			temp->Next->prev=temp->prev;
			free(temp);
		}
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
				display_from_last();
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
//			case 10:
//				searching();
//				break;
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
