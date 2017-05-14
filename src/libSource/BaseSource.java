package libSource;




abstract public class BaseSource
{
    protected AttributeList attributeList = new AttributeList();

    protected BaseAttributeListWorker attributeSearcher = new AttributeListWorker();


    abstract public String getName();

    abstract public String getAccessType();

    abstract public String getDescription();

    abstract public String getLink();

    abstract public String getTheme();

    abstract public String getType();



    abstract public void setName(String name);

    abstract public void setAccessType(String accessType);

    abstract public void setDescription(String description);

    abstract public void setLink(String link);

    abstract public void setTheme(String theme);

    abstract public void setType(String type);
}
