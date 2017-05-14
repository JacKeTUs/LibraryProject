package libSource.Attributes;


public class AttributeContent extends BaseAttribute
{
    public AttributeContent(String _value)
    {
        tableName = "content";
        name = "content_value";
        value = _value;
    }
}
