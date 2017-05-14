package libSource.Attributes;


public class AttributeLink extends BaseAttribute
{
    public AttributeLink(String _value)
    {
        tableName = "web_resources";
        name = "resource_link";
        value = _value;
    }
}
