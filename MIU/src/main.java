import java.util.ArrayList;



public class main {

    private static String input;
    private static char[] miu;




    public static void main(String[] args)
    {

	input = new String();
	input = "MIUU";

	input.toUpperCase();
	ArrayList<String> outputs = new ArrayList<String>();


	outputs.add(input + input.substring(1));

	if(input.substring(input.length()-1).equals("I"))

	{

	    outputs.add(input+"U");

	}


	for (int i = 1; i< input.length(); i++ )
	{


	    if ( i == input.length()-2 && input.substring(i, i+2).equals("UU"))
	    {

		System.out.println("uu 1");
		outputs.add(input.substring(0, i));

	    }

	    if ( i < input.length()-2 && input.substring(i, i+2).equals("UU"))
	    {

		outputs.add(input.substring(0, i)+ input.substring(i+2));

	    }

	    if((i == (input.length()-3)) && input.substring(i, i+3).equals("III"))
	    {

		outputs.add(input.substring(0, i) + "U");

	    }

	    if ( i < input.length()-3 && input.substring(i, i+3).equals("III"))
	    {

		outputs.add(input.substring(0, i)+ "U" +  input.substring(i+3));

	    }
	}

	System.out.println(outputs.toString());
    }
}


