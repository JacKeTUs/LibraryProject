package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeSubscriptionType extends BaseAttribute
{
    public AttributeSubscriptionType(String _value)
    {
        tableName = "subscription_type";
        name = "subscription_type_value";
        value = _value;
    }
}
