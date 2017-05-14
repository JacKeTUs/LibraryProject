package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeLanguage extends BaseAttribute
{
    public AttributeLanguage(String _value)
    {
        tableName = "language";
        name = "language_value";
        value = _value;
    }
}
