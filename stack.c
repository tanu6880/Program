#include<stdio.h>
#define size 5

void push(int stack[],int *top)
{
	if(*top>=size-1)
	{
		printf("\nthe satck is overflow\n");
		return;
	}
	else
	{
		++*top;
		int data;
		printf("\nThe the data in stack at postion %d: ",*top + 1);
		scanf("%d",&data);
		stack[*top]=data;
	}
}
void pop(int stack[],int *top)
{
	if(*top<=-1)
	{
		printf("\nthe satck is Underflow\n");
		return;
	}
	else
	{
		printf("\ndeleted the data at position %d: ",*top+1);
		stack[*top]=0;
		--*top;
	}
}
void display(int stack[],int top)
{
	int i=0;
	for(i=0;i<=top;i++)
	{
		printf("%d ",stack[i]);
	}
}
int main()
{
	int stack[5],choice,c,data, top=-1;
	do
	{
		printf("\n1.PUSH : \n2.POP : \n3.DISPLAY\n");
		printf("Enter the number which task do you want perform : ");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				push(stack,&top);
				break;
			case 2:
				pop(stack,&top);
				break;
			case 3:
				display(stack,top);
				break;	
		}
		printf("\nif you want to continue..press 5 : ");
		scanf("%d",&c);
		
		
	}while(c==5);
	return 0;
}
