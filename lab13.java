import java.util.ArrayList;

public class lab13 
{
	ArrayList<Integer> allInputs = new ArrayList<>();
	
	public void readData(String filename)
	{
		try
		{
			java.io.BufferedReader input = 
					new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while( (inn = input.readLine()) != null )
			{
					allInputs.add(Integer.valueOf(inn));
				
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount()
	{
		long totalCount = allInputs.stream().count();
		return totalCount;
	}
	
	public long getOddCount()
	{
		long oddCount = allInputs.stream().filter( x -> x % 2 != 0).count();
		return oddCount;
	}
	
	public long getEvenCount()
	{
		long evenCount = allInputs.stream().filter( x -> x % 2 == 0).count();
		return evenCount;
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		long distinctGreaterThanFive = allInputs.stream().distinct().filter( x -> x > 5).count();
		return distinctGreaterThanFive;
	}
	
	public Integer[] getResult1()
	{
		Integer[] a = allInputs.stream().filter(x -> (x % 2 == 0) && x > 5 && x < 50).sorted().toArray(Integer[]::new);
		return a;
	}
	
	public Integer[] getResult2()
	{
		Integer[] a = allInputs.stream().limit(50).map(x -> x*x*3).toArray(Integer[]::new);
		return a;
	}
	
	public Integer[] getResult3()
	{
		Integer[] a = allInputs.stream().filter( x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
		return a;
	}
}




