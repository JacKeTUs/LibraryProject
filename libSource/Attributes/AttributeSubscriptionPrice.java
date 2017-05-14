package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeSubscriptionPrice extends BaseAttribute
{
    public AttributeSubscriptionPrice(String _value)
    {
        tableName = "web_resources";
        name = "subscription_price";
        value = _value;
    }
}
