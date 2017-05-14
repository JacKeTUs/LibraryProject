package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeSubscriptionSource extends BaseAttribute
{
    public AttributeSubscriptionSource(String _value)
    {
        tableName = "subscription_source";
        name = "subscription_source_value";
        value = _value;
    }
}
