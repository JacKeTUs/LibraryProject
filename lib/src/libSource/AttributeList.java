package libSource;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AttributeList
{
    private List<BaseAttribute> list = new ArrayList<BaseAttribute>();



    public AttributeList()
    {

    }

    public AttributeList(AttributeList attrList)
    {
        Iterator<BaseAttribute> itr = attrList.getIterator();
        while (itr.hasNext())
        {
            list.add(itr.next());
        }
    }

    public Iterator<BaseAttribute> getIterator()
    {
        return list.iterator();
    }

    public int size()
    {
        return list.size();
    }

    public  BaseAttribute get(int index)
    {
        return list.get(index);
    }


    public void add(BaseAttribute attribute)
    {
        list.add(attribute);
    }

    public void remove (int index)
    {
        list.remove(index);
    }

    public void set(int index, BaseAttribute attribute)
    {
        list.set(index, attribute);
    }

    public void setAttributeValue (int index, String value)
    {
        BaseAttribute attr = list.get(index);
        attr.setAttributeValue(value);
        list.set(index, attr);
    }

    public void setAttributeValue (String name, String value)
    {
        Iterator<BaseAttribute> itr = list.iterator();
        BaseAttribute attr;
        while(itr.hasNext())
        {
            attr = itr.next();
            if (attr.getAttributeName().equals(name))
            {
                attr.setAttributeValue(value);
                return;
            }
        }
        return;
    }
}
