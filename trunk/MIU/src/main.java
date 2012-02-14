import java.util.ArrayList;
import java.util.TreeSet;



public class main {

	private static final int ITERATIONS = 5;
	private static String input;





	public static void main(String[] args)
	{

		breadthSearch("MI", "MU");
		depthSearch("MI", "MU");
		depthlimitedSearch("MI", "MIIIIIU", ITERATIONS);
		deepeningSearch("MI", "MIIIIIU");



	}

	public static TreeSet<State> getOutputs(State s)
	{

		input = new String();
		input = s.getMiu();

		input.toUpperCase();
		TreeSet<State> outputs = new TreeSet<State>();


		if(input.substring(input.length()-1).equals("I"))

		{

			outputs.add(new State( s.getLength()+1, input + input+"U"));

		}

		outputs.add(new State( s.getLength()+1, input + input.substring(1)));


		for (int i = 1; i< input.length(); i++ )
		{


			if((i == (input.length()-3)) && input.substring(i, i+3).equals("III"))
			{

				outputs.add(new State(s.getLength()+1, input.substring(0, i) + "U"));

			}

			if ( i < input.length()-3 && input.substring(i, i+3).equals("III"))
			{

				outputs.add(new State(s.getLength()+1, input.substring(0, i)+ "U" +  input.substring(i+3)));

			}

			if ( i == input.length()-2 && input.substring(i, i+2).equals("UU"))
			{

				outputs.add(new State(s.getLength()+1,input.substring(0, i)));

			}

			if ( i < input.length()-2 && input.substring(i, i+2).equals("UU"))
			{

				outputs.add(new State(s.getLength()+1, input.substring(0, i)+ input.substring(i+2)));

			}


		}

		return outputs;
	}

	public static boolean depthSearch(String src, String dest){

		System.out.println("Searching for " + dest + " using depth first search...");

		ArrayList<State> agenda = new ArrayList<State>();
		TreeSet<String> closed = new TreeSet<String>();
		State current = new State(src);
		agenda.add(current);

		long time = System.nanoTime();
		while (agenda.size() != 0)
		{

			current = agenda.get(agenda.size()-1);
			agenda.remove(current);

			if(current.getMiu().equals(dest))
			{

				time = System.nanoTime() - time;
				System.out.println("Found it! " + current.getMiu() + " was found " + current.getLength() + " iteration(s) into the tree!");
				System.out.println("Took " + time + " nanoseconds to find using depth first search");
				return true;

			}
			else
			{
				if(!closed.contains(current.getMiu())) 
				{

					TreeSet<State> next = new TreeSet<State>();
					next = getOutputs(current);
					closed.add(current.getMiu());
					agenda.addAll(next);

				}
			}
		}

		time = System.nanoTime() - time;
		System.out.println(dest + " could not be found!");
		return false;

	}

	public static boolean breadthSearch(String src, String dest){

		System.out.println("Searching for " + dest + " using breadth first search...");
		
		ArrayList<State> agenda = new ArrayList<State>();
		TreeSet<String> closed = new TreeSet<String>();
		State current = new State(src);
		agenda.add(current);

		long time = System.nanoTime();
		while (agenda.size() != 0)
		{

			current = agenda.get(0);
			agenda.remove(0);

			if(current.getMiu().equals(dest))
			{

				time = System.nanoTime() - time;
				System.out.println("Found it! " + current.getMiu() + " was found " + current.getLength() + " iteration(s) into the tree!");
				System.out.println("Took " + time + " nanoseconds to find using breadth first search");
				return true;

			}
			else
			{
				if(!closed.contains(current.getMiu()))
				{

					TreeSet<State> next;
					next = getOutputs(current);
					closed.add(current.getMiu());
					agenda.addAll(next);

				}
			}
		}

		time = System.nanoTime() - time;
		System.out.println(dest + " could not be found!");
		return false;

	}

	public static boolean depthlimitedSearch(String src, String dest, int n){
		
		System.out.println("Searching for " + dest + " using depth limited search...");

		ArrayList<State> agenda = new ArrayList<State>();
		TreeSet<String> closed = new TreeSet<String>();
		State current = new State(src);
		agenda.add(current);

		long time = System.nanoTime();
		while (agenda.size() != 0)
		{

			current = agenda.get(agenda.size()-1);
			agenda.remove(current);

			if(current.getMiu().equals(dest))
			{

				time = System.nanoTime() - time;
				System.out.println("Found it! " + current.getMiu() + " was found " + current.getLength() + " iteration(s) into the tree!");
				System.out.println("Took " + time + " nanoseconds to find using depth limited search");
				return true;

			}
			else
			{
				if(!closed.contains(current.getMiu()) && current.getLength() < n) //to stop it from iterating too deep into the tree
				{

					TreeSet<State> next = new TreeSet<State>();
					next = getOutputs(current);
					closed.add(current.getMiu());
					agenda.addAll(next);

				}
			}
		}

		time = System.nanoTime() - time;
		System.out.println(dest + " could not be found!");
		System.out.println("Took " + time + " nanoseconds to unsuccessfully find the string within " + ITERATIONS + " iterations using depth first search");
		return false;

	}


	public static void deepeningSearch(String src, String dest){

		int n = 0;
		while(!depthlimitedSearch("MI", "MIIIIIU", n )){
			
			n++;
		}
	}
}


