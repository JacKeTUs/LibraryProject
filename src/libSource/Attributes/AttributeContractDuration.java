package libSource.Attributes;

/**
 * Created by Антон on 12.05.2017.
 */
public class AttributeContractDuration extends BaseAttribute
{
    public AttributeContractDuration(String _value)
    {
        tableName = "web_resources";
        name = "contract_duration";
        value = _value;
    }
}
