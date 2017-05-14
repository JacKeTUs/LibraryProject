package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeStatus extends BaseAttribute
{
    public AttributeStatus(String _value)
    {
        tableName = "status";
        name = "status_value";
        value = _value;
    }
}
