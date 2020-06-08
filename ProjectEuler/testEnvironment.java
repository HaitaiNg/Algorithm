import java.util.*; 
import java.util.Collection; 
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;


public class testEnvironment {

    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        ByteArrayInputStream input = new ByteArrayInputStream(
            xml.getBytes("UTF-8"));
        Document document = builder.parse(input); 
        NodeList nodeList = document.getDocumentElement().getChildNodes(); 

        List<Integer> listOfIds = new ArrayList<Integer>(); 
        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i); 
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element elem = (Element) node; 
                String ID = node.getAttributes().getNamedItem("id").getNodeValue();
                String xmlMessage = elem.getElementsByTagName("message")
                .item(0).getChildNodes().item(0).getNodeValue();; 
                if(xmlMessage.contains(message))
                {
                    listOfIds.add(Integer.valueOf(ID)); 
                }
            }
        }
    
        return listOfIds;
    }
    
    public static void main(String[] args) throws Exception {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" + 
                "    <entry id=\"1\">\n" + 
                "        <message>Application started</message>\n" + 
                "    </entry>\n" + 
                "    <entry id=\"2\">\n" + 
                "        <message>Application ended</message>\n" + 
                "    </entry>\n" + 
                "</log>";
        
        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        // for(int id: ids)
        //     System.out.println(id); 
    }
    
}
