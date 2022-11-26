public class producer extends Thread
{
    int sizee;
    buffer buff;
    public producer(buffer buf,int size)
    {
        buff=buf;
        sizee=size;
    }
    //////////////////////////////////
    boolean isPrime(int n)
    {
        boolean prime=true;
        // Corner case
        if (n<=1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
            {
                prime=false;
                break;
            }
        return prime;
    }
    ////////////////////////////////////
    public void run()
    {
        for (int i =1; i<=sizee; i++)
        {
            if(isPrime(i))
            {
                buff.produce(i);
            }
        }
    }
}