import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlSlurper

Message processData(Message message) {
    def reader = message.getBody(java.io.Reader)
    def xml = new XmlSlurper().parse(reader)

    def targetRoute = ""
    if (xml.name() == "Products") {
        targetRoute = "publisher_solace_inbound_products_layer-2"
    } else if (xml.name() == "Suppliers") {
        targetRoute = "publisher_solace_inbound_suppliers_layer_2"
    } else {
        targetRoute = "publisher_solace_inbound_books_layer_2"
    }

    // Remove CR/LF for safe property usage in address
    targetRoute = targetRoute.replaceAll("[\\r\\n]", "").trim()
    message.setProperty("routeTo", targetRoute)
    return message
}
