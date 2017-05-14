package libSource;
import  libSource.Attributes.*;

/**
 * Created by Антон on 06.04.2017.
 */
abstract public class BaseAttributeListWorker
{
    abstract public BaseAttribute getAttribute(AttributeList attributeList, String attributeName);

    abstract public void setAttributeValue(AttributeList attributeList, String attributeName, String attributeValue);
}
