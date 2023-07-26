import java.util.*;
class DemoHashMap 
{
	public static void main(String[]args)
	{
		//HashMap allows us to store data in key-value pair
		//HashMap cannot have duplicate keys.	
		//Internally HashMap have Array of Nodes. Nodes have four fields
		//int hash, K Key, V Value, Node next
		HashMap<String,Integer> hm=new HashMap<String,Integer>();

		//add value into map
		hm.put("arun",40);
		hm.put("tarun",34);
		hm.put("swati",36);
		hm.put("tarun",33);

		System.out.println(hm);

		System.out.println(hm.containsKey("swati"));
		System.out.println(hm.containsValue(36));
		System.out.println(hm.containsValue(34));

		System.out.println(hm.get("aruna"));

		hm.remove("tarun");
		System.out.println(hm);

		System.out.println(hm.isEmpty());
		//Iterate over hasp map
		for(Map.Entry<String,Integer> x:hm.entrySet())
		{
			System.out.println(x.getKey()+"--->"+x.getValue());
		}

		System.out.println(hm.size());
		hm.clear();

		System.out.println(hm.isEmpty());
		System.out.println(hm.size());

	}	
}
//WAP to input values in array and count occurence of every element of the array using HashMap
//7
//10 10 20 30 35 20 40
//10 --> 2
//20 --> 2
// 30 --> 1
// 35 --> 1
// 40 --> 1