
public class State implements Comparable {

    private int length;
    private String miu;

    public State(int length, String miu)
    {

	this.length = length;
	this.miu= miu;

    }

    public State(String miu)
    {

	length = 0;
	this.miu = miu;

    }

    public int getLength() {
	return length;
    }

    public String getMiu() {
	return miu;
    }


    public int compareTo(Object s) {

	State c = (State)s;

	if(c.getMiu() != miu && c.length <= length)
	{
	    return -1;
	}
	else
	{
	    if(c.getMiu() != miu && c.length > length)
	    {
		return 1;
	    }

	    else
	    {
		return 0;
	    }

	}

    }

}
