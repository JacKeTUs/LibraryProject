package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributePublicationArchive extends BaseAttribute
{
    public AttributePublicationArchive(String _value)
    {
        tableName = "web_resources";
        name = "resourse_publication_archive";
        value = _value;
    }
}
