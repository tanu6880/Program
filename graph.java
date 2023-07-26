package graph;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
class graph_implementation
{
	LinkedList<Integer> adlist[] ;
	public graph_implementation(int v)
	{
		adlist = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adlist[i] = new LinkedList<Integer>();
		}
	}
	public void insert(int s,int d)
	{
		adlist[s].add(d);
		adlist[d].add(s);
	}
}

public class graphi
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("enter vertics ");
		int v = kb.nextInt();
		System.out.println("enter edges ");
		int e = kb.nextInt();

		graph_implementation gf = new graph_implementation(v);

		for(int i=0;i<e;i++)
		{
			System.out.println("enter sorce for 1 "+(i+1));
			int s = kb.nextInt();
			System.out.println("enter destination for "+(i+1));
			int d = kb.nextInt();

			gf.insert(s,d);
		}
	}
}