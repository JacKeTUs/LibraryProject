package libSource;
import  libSource.Attributes.*;

import java.util.Iterator;

public class Source extends  BaseSource
{
    public Source()
    {

    }

    public Source(AttributeList _attributeList)
    {
        Iterator<BaseAttribute> itr = _attributeList.getIterator();
        while (itr.hasNext())
            attributeList.add(itr.next());
    }

    @Override
    public String getName()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "Name");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }

    @Override
    public String getAccessType()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "AccessType");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }

    @Override
    public String getDescription()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "Description");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }

    @Override
    public String getLink()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "Link");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }

    @Override
    public String getTheme()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "Theme");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }

    @Override
    public String getType()
    {
        BaseAttribute attr = attributeSearcher.getAttribute(attributeList, "Type");
        if (attr != null)
            return attr.getAttributeValue();
        return "";
    }





    @Override
    public void setName(String name)
    {
        attributeSearcher.setAttributeValue(attributeList, "Name", name);
    }

    @Override
    public void setAccessType(String accessType)
    {
        attributeSearcher.setAttributeValue(attributeList, "AccessType", accessType);
    }

    @Override
    public void setDescription(String description)
    {
        attributeSearcher.setAttributeValue(attributeList, "Description", description);
    }

    @Override
    public void setLink(String link)
    {
        attributeSearcher.setAttributeValue(attributeList, "Link", link);
    }

    @Override
    public void setTheme(String theme)
    {
        attributeSearcher.setAttributeValue(attributeList, "Theme", theme);
    }

    @Override
    public void setType(String type)
    {
        attributeSearcher.setAttributeValue(attributeList, "Type", type);
    }
}
