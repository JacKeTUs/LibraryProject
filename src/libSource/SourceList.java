package libSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SourceList
{
    protected List<BaseSource> sourceList = new ArrayList<BaseSource>();

    public SourceList()
    {

    }

    public SourceList(List<BaseSource> lst)
    {
        sourceList.addAll(lst);
    }

    public void add(BaseSource source)
    {
        sourceList.add(source);
    }

    public void addAll(List<BaseSource> lst)
    {
        sourceList.addAll(lst);
    }

    public BaseSource get(int index)
    {
        return sourceList.get(index);
    }

    public int size()
    {
        return sourceList.size();
    }

    public void remove(int index)
    {
        sourceList.remove(index);
    }

    public void set(int index, BaseSource source)
    {
        sourceList.set(index, source);
    }

    public Iterator<BaseSource> getIterator()
    {
        return sourceList.iterator();
    }
}
