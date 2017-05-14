package libSource.Attributes;


public class AttributeType extends BaseAttribute
{
    public AttributeType(String _value)
    {
        tableName = "type";
        name = "type_value";
        value = _value;
    }
}
