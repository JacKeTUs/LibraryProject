package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeArchivationDate extends BaseAttribute
{
    public AttributeArchivationDate(String _value)
    {
        tableName = "web_resources";
        name = "archivation_date";
        value = _value;
    }
}
