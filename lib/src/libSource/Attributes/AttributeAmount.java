package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeAmount extends BaseAttribute
{
    public AttributeAmount(String _value)
    {
        tableName = "web_resources";
        name = "resourse_amount";
        value = _value;
    }
}
