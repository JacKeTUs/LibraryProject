package libSource;

/**
 * Created by Антон on 06.04.2017.
 */
public class AttributeType extends BaseAttribute
{
    public AttributeType(String _value)
    {
        tableName = "type";
        name = "type_value";
        value = _value;
    }
}
