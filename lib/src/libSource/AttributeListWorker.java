package libSource;

import java.util.Iterator;

/**
 * Created by Антон on 06.04.2017.
 */
public class AttributeListWorker extends BaseAttributeListWorker
{
    @Override
    public BaseAttribute getAttribute(AttributeList attributeList, String attributeName)
    {
        Iterator<BaseAttribute> itr = attributeList.getIterator();
        BaseAttribute attr = null;
        while(itr.hasNext())
        {
            attr = itr.next();
            if (attr.getAttributeName().equals(attributeName))
                return attr;
        }
        return null;
    }

    @Override
    public void setAttributeValue(AttributeList attributeList, String attributeName, String attributeValue)
    {
        BaseAttribute attribute;
        for (int i = 0; i < attributeList.size(); i++)
        {
            attribute = attributeList.get(i);
            if (attribute.getAttributeName().equals(attributeName))
            {
                attributeList.setAttributeValue(i, attributeValue);
                return;
            }
        }
        return;
    }
}
