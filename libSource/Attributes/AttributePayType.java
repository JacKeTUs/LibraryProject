package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributePayType extends BaseAttribute
{
    public AttributePayType(String _value)
    {
        tableName = "pay_type";
        name = "pay_type_value";
        value = _value;
    }
}
