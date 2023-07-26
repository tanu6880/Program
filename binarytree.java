import java.util.LinkedList;
import java.util.Queue;

class node
{
	int data;
	node left;
	node right;

	node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class tree
{
	public static void inorder(node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	public static void preorder(node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+" ");
			inorder(root.left);
			inorder(root.right);
		}
	}
	public static void postorder(node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			inorder(root.right);
			System.out.print(root.data+" ");
			
		}
	}
	public static int height(node root)
	{
		if(root==null)
		{
			return 0;
		}
		else 
		{
			int lh = height(root.left);
			int rh = height(root.right);
			return lh>rh?lh:rh +1;
		}
	}
	public static void printkdistance(node root,int k)
	{
		if(root!=null)
		{
			if(k==0)
				System.out.print(root.data+" ");
			else 
			{
				printkdistance(root.left,k-1);
				printkdistance(root.right,k-1);
			}
		}
		
	}
	public static void levelorder(node root)
	{
		if(root!=null)
		{
			Queue<node> q = new LinkedList<node>();
			q.add(root);
			while(q.size()>0)
			{
				node curr = q.poll();
				System.out.print(curr.data+" ");
				if(curr.left!=null)
					levelorder(curr.left);
				if(curr.right!=null)
					levelorder(curr.right);
			}
		}
		
	}
	public static int sizeoftree(node root)
	{
		if(root==null)
		{
			return 0;
		}
		else 
		{
			int lh = sizeoftree(root.left);
			int lr = sizeoftree(root.right);
			return lh+lr+1;
		}
		
	}
	public static int maxnode(node root)
	{
		if(root==null)
		{
			return -1;
		}
		else 
		{
			int lh = maxnode(root.left);
			int lr = maxnode(root.right);
			int max = lh;
			if(max<lr)
			{
				max = lr;
			}
			if(max<root.data)
			{
				max = root.data;
			}
			return max;
		}
		
	}
}
public class binarytree
{
	public static void main(String args[])
	{
		node root = null;
		root = new node(10);
		root.left= new node(5);
		root.right = new node(11);
		tree.inorder(root);
		System.out.println();
		tree.preorder(root);
		System.out.println();
		tree.postorder(root);
		System.out.println();
		int h = tree.height(root);
		System.out.println(h);
		tree.printkdistance(root,1);
		System.out.println();
		tree.levelorder(root);
		System.out.println();
		System.out.print(tree.sizeoftree(root));
		System.out.println();
		System.out.print("max node"+tree.maxnode(root));
	
	}
}