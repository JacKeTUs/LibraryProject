import libSource.*;

import java.util.Iterator;


public class MainClass
{
    public static void main(String[] args)
    {
        //  Attributes test
        AttributeLink attributeLink = new AttributeLink("l");
        AttributeAccessType attributeAccessType = new AttributeAccessType("at");
        AttributeDescription attributeDescription = new AttributeDescription("d");
        AttributeName attributeName = new AttributeName("n");
        AttributeTheme attributeTheme = new AttributeTheme("th");
        AttributeType attributeType = new AttributeType("t");

        //  Attribute list test
        AttributeList attributeList = new AttributeList();
        attributeList.add(attributeAccessType);
        attributeList.add(attributeLink);
        attributeList.add(attributeDescription);
        attributeList.add(attributeName);
        attributeList.add(attributeTheme);
        attributeList.add(attributeType);

        Iterator<BaseAttribute> itr = attributeList.getIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next().getAttributeName());
        }

        attributeList.setAttributeValue(3, "1111");
        attributeList.setAttributeValue("Description", "dddddd");
        attributeList.set(0, attributeName);
        attributeList.set(0, attributeAccessType);
        attributeList.add(attributeName);
        attributeList.remove(attributeList.size() - 1);

        //  Source test
        System.out.println("\n");
        Source source = new Source(attributeList);
        System.out.println(source.getAccessType());
        System.out.println(source.getName());
        System.out.println(source.getType());
        System.out.println(source.getDescription());
        System.out.println(source.getLink());
        System.out.println(source.getTheme());

        //  SourceList test
        System.out.println("\n");
        SourceList sourceList = new SourceList();
        sourceList.add(source);
        sourceList.add(source);
        sourceList.add(source);
        sourceList.add(source);
        System.out.println("Index:\n");
        for (int i = 0; i < sourceList.size(); i++)
            System.out.println(sourceList.get(i).getName());
        System.out.println("Iterator:\n");
        Iterator<BaseSource> itr1 = sourceList.getIterator();

        for (int i = 0; i < sourceList.size(); i++)
            System.out.println(sourceList.get(i).getName());

        int a = 0;
        a++;
    }
}
