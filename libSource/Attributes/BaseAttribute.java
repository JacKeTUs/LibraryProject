package libSource.Attributes;


public class BaseAttribute
{
    protected String tableName = "";
    protected String name = "";
    protected String value = "";

    public BaseAttribute()
    {
        tableName = "";
        name = "";
        value = "";
    }

    public BaseAttribute(String _tableName, String _name, String _value)
    {
        tableName = _tableName;
        name = _name;
        value = _value;
    }

    public BaseAttribute(BaseAttribute attr)
    {
        tableName = attr.tableName;
        name = attr.name;
        value = attr.value;
    }

    public String getAttributeTableName()
    {
        return tableName;
    }

    public String getAttributeName()
    {
        return name;
    }

    public String getAttributeValue()
    {
        return value;
    }


    public void setAttributeTableName(String _tableName)
    {
        tableName = _tableName;
    }

    public void setAttributeName(String _name)
    {
        name = _name;
    }

    public void setAttributeValue(String _value)
    {
        value = _value;
    }

}