import com.sap.gateway.ip.core.customdev.util.Message
def Message processData(Message message) {
    // Get the body of the message as a String
    def body = message.getBody(java.lang.String)
    // Get the message log for logging purposes
    def messageLog = messageLogFactory.getMessageLog(message)
    // Check if the message log is available
    if (messageLog != null) {
        // Set a string property for logging
        messageLog.setStringProperty("log1", "Printing Payload As Attachment")
        // Add the body as an attachment to the message log
        messageLog.addAttachmentAsString("log1", body, "text/plain")
    }
    // Return the original message
    return message
}