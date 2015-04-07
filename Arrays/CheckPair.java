import java.util.ArrayList;
import java.util.HashMap;

/* Given an array A[] of n numbers and another number x, 
 * Output whether or not there exist two elements in A whose sum is exactly x,
 * also their indices. Consider duplicates exist.
 * Eg- input array - 2 1 3 6 3 2 5 0 sum =5
 *  output yes and (0,2) (0,4) (2,5) (4,5) (6,7)
 */
public class CheckPair {
	public static void main(String args[])
	{
		int[] inputArray = {2,1,3,6,3,2,5,0};
		int sum =5;
		HashMap<Integer,ArrayList<Integer>> inputList = new HashMap<Integer,ArrayList<Integer>>();		//Store key as the array value and value as the list of indices
		//Add all the elements of the given array and their respective indices in the hashmap.
		for(int i=0;i<inputArray.length;i++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>(); 
			if(inputList.containsKey(inputArray[i]))
			{
				temp = inputList.get(inputArray[i]);
				temp.add(i);
				inputList.put(inputArray[i], temp);
			}
			else
			{
				temp.add(i);
				inputList.put(inputArray[i], temp);
			}
		}
		
		boolean flag=true;
		//Check for the pairs and print them. Avoid printing duplicate indices.
		for(int i=0;i<inputArray.length;i++)
		{
			int sumSubElement = sum - inputArray[i];
			if(inputList.containsKey(sumSubElement))
			{
				if(flag)
				{
					System.out.println("Yes pair exists");		//Print only once
					flag=false;
				}
				ArrayList<Integer> temp1 = inputList.get(inputArray[i]);
				ArrayList<Integer> temp2 = inputList.get(sumSubElement);
				for(int j=0;j<temp1.size();j++)
				{
					for(int k=0;k<temp2.size();k++)
					{
						if(temp1.get(j)!=temp2.get(k))
							System.out.println("("+Math.min(temp1.get(j), temp2.get(k))+","+ Math.max(temp1.get(j), temp2.get(k))+")");
					}
					inputList.remove(inputArray[i]);
					inputList.remove(sumSubElement);
				}
			}
		}
	}
}
