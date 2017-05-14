package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeKind extends BaseAttribute
{
    public AttributeKind(String _value)
    {
        tableName = "kind";
        name = "kind_value";
        value = _value;
    }
}
