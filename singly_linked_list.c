#include<stdio.h>
#include<stdlib.h>
struct SinglelinkedList
{
	int data;
	struct SinglelinkedList *Next;
};
struct SinglelinkedList *start = NULL;
void printreverse(struct SinglelinkedList *temp)
{
	if(temp->Next!=NULL)
		printreverse(temp->Next);
	printf(" %d ",temp->data);
}
int main()
{
	struct SinglelinkedList *node,*temp;
	int c;
	int choice,size;
	do{
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
				printf("\nhow many node do you want to create :");
				scanf("%d",&size);
				for(int i=1;i<=size;i++)
				{
					node = (struct SinglelinkedList *)malloc(sizeof(struct SinglelinkedList));
					printf("\nEnter the data : ");
					scanf("%d",&node->data);
					node->Next=NULL;
					if(start==NULL)
					{
						start=node;
					}
					else
					{
						temp=start;
						while(temp->Next!=NULL)
							temp = temp->Next;
						temp->Next=node;
					}
					
				}
				break;
			case 2:
				if(start==NULL)
				{
					printf("\nThe linked list is empty");
				}
				else
				{
					temp=start;
					while(temp!=NULL)
					{
						printf(" %d ",temp->data);
						temp=temp->Next;
					}
				}
				break;
				case 3:
					printreverse(start);
					break;
				case 4:
					node=(struct SinglelinkedList *)malloc (sizeof(struct SinglelinkedList));
					printf("Enter the data : ");
					scanf("%d",&node->data);
					node->Next=start;
					start=node;
					break;
				case 5:
					node=(struct SinglelinkedList *)malloc (sizeof(struct SinglelinkedList));
					printf("Enter the data : ");
					scanf("%d",&node->data);
					node->Next=NULL;
					if(start==NULL)
					{
						start=node;	
					}
					else
					{	temp=start;
						while(temp->Next!=NULL)
						{
							temp=temp->Next;
						}
						temp->Next=node;
					}
				case 6:
					if(start==NULL)
					{
						printf("\nlist is empty\n");
					}
					else
					{
						if(start->Next==NULL)
						{
							printf("data deleted %d",start->data);
							free(start);
							start=NULL;
						}
						else
						{
							temp=start;
							start=start->Next;
							printf("data deleted %d",temp->data);
							free(temp);
						}
						
					}
					break;
				case 7:
					if(start==NULL)
					{
						printf("\nlist is empty\n");
					}
					else
					{
						if(start->Next==NULL)
						{
							printf("data deleted %d",start->data);
							free(start);
							start=NULL;
						}
						else
						{
							temp=start;
							while(temp->Next!=NULL)
							{	node=temp;
								temp=temp->Next;
							}
							node->Next=NULL;
							printf("data deleted %d",temp->data);
							free(temp);
						}
					}
					break;
				case 8:
					printf("\nEnter position where you want to store\n");
					scanf("%d",&choice);
					node=(struct SinglelinkedList *)malloc (sizeof(struct SinglelinkedList));
					printf("Enter the data : ");
					scanf("%d",&node->data);
					node->Next=NULL;
					temp=start;
					if(choice==1)
					{
						node->Next=temp;
						start=node;
					}
					else
					{
						for(int i=1;i<choice-1;i++)
						{
							if(temp==NULL)
								break;
							temp=temp->Next;
						}
						if(temp==NULL)
							printf("\n %d position does not exist");
						else
						{
							if(temp->Next==NULL)
								temp->Next=node;
							else
							{
								node->Next=temp->Next;
								temp->Next=node;
							}
						}
					}
					break;
				case 9:
					printf("\nEnter position where you want to delete\n");
					scanf("%d",&choice);
					temp=start;
					if(choice==1)
					{
						start=start->Next;
						free(temp);
					}
					else
					{
						for(int i=1;i<choice;i++)
						{	node=temp;
							if(temp==NULL)
								break;
							temp=temp->Next;
						}
						if(temp==NULL)
							printf("\n %d position does not exist");
						else
						{
							if(temp->Next==NULL)
							{
								free(temp);
								node->Next=NULL;
							}
							else
							{
								node->Next=temp->Next;
								free(temp);
							}
						}
					}
					break;
				case 10:
					printf("\nEnter the element");
					scanf("%d",&choice);
					temp=start;
					while(temp!=NULL)
					{
						if(temp->data==choice)
						{
							printf("\ndata found\n");
							break;
						}
						temp=temp->Next;
					}
					temp=temp->Next;
					if(temp==NULL)
					 	printf("\ndata not found\n");
					break;
					
		}
		printf("if you want to continue ");
		scanf("%d",&c);	
	}while(c==1);
		
	return 0;
}
