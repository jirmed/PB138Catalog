package cz.muni.fi.pb138.catalog;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author brossi
 */
public class DOMParser {

    private final Document document;
    private static DocumentBuilderFactory dbf = null;

    /**
     *
     * @param filename
     * @param isNameSpaceAware
     * @param isValidating
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public DOMParser(String filename, boolean isNameSpaceAware, boolean isValidating)
            throws ParserConfigurationException, SAXException, IOException {

        dbf = getFactory();
        dbf.setNamespaceAware(isNameSpaceAware);
        dbf.setValidating(isValidating);
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File(filename));
    }

    /**
     * Lazy initialization for DocumentBuilderFactory
     * 
     * @return DocumentBuilderFactory
     */
    private DocumentBuilderFactory getFactory() {
        return (dbf == null) ? dbf = DocumentBuilderFactory.newInstance() : dbf;
    }
    
    /**
     * Get the org.w3c.dom.Document DOM representation
     * 
     * @return  org.w3c.dom.Document
     */
    public Document getDocument(){
        return document;
    }
    
    /**
     * Saving the DOM as XML
     *
     * @see https://docs.oracle.com/javase/tutorial/jaxp/xslt/writingDom.html
     *
     * @param filename
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public void saveDocumentToFile(String filename) 
            throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException {

        File file = new File(filename);
        TransformerFactory tFactory  = TransformerFactory.newInstance();
        Transformer transformer      = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

}
