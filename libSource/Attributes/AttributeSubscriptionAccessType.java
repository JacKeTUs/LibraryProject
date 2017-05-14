package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeSubscriptionAccessType extends BaseAttribute
{
    public AttributeSubscriptionAccessType(String _value)
    {
        tableName = "subscription_access_type";
        name = "subscription_access_type_value";
        value = _value;
    }
}
