import java.util.LinkedList;
import java.util.Queue;

public class buffer
{
    private int sizee; // the buffer bound
    public int count;
    public int largest;
    public Queue<Object> queue=new LinkedList<>();
    semaphore spaces;
    semaphore elements;
    //////////////////////////////////////
    public buffer(int s)
    {
        sizee=s;
        spaces =new semaphore(sizee);
        elements=new semaphore(0);
        count=0;
        largest=0;
    }
    //////////////////////////////////////
    public void produce(Object value)
    {
            spaces.P();
            queue.add(value);
            elements.V();
            count = count + 1;
            largest = (int) value;
    }
    public Object consume()
    {
        Object value;
        elements.P();
        value=queue.remove();
        spaces.V();
        return value;
    }

}
