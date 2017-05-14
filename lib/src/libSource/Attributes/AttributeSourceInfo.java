package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeSourceInfo extends BaseAttribute
{
    public AttributeSourceInfo(String _value)
    {
        tableName = "web_resources";
        name = "source_info";
        value = _value;
    }
}
