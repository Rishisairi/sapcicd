import com.sap.gateway.ip.core.customdev.util.Message;
import com.sap.it.api.ITApiFactory
import com.sap.it.api.mapping.ValueMappingApi
def Message processData(Message message) {
       def map = message.getProperties();
       InterfaceId = map.get("SAP_ApplicationID");
       def valueMapApi = ITApiFactory.getService(ValueMappingApi.class, null)
       def iFlowName = valueMapApi.getMappedValue('CPI', 'AppID', InterfaceId, 'IS', 'Iflow')
       message.setProperty("InterfaceName", iFlowName);
       return message;
}