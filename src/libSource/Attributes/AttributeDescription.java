package libSource.Attributes;


public class AttributeDescription extends BaseAttribute
{
    public AttributeDescription(String _value)
    {
        tableName = "web_resources";
        name = "resource_description";
        value = _value;
    }
}
