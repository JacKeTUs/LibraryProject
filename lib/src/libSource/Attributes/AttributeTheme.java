package libSource.Attributes;

/**
 * Created by Антон on 06.04.2017.
 */
public class AttributeTheme extends BaseAttribute
{
    public AttributeTheme(String _value)
    {
        tableName = "theme";
        name = "theme_value";
        value = _value;
    }
}
