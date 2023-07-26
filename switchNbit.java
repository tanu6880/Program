class switchNbit
{
	public static void main(String []args)
	{
		int n = 31;
		int bp = 3;
		int onmask = 1<<bp-1;
		int offmask = ~onmask;
		System.out.println(n&offmask);
	}
}