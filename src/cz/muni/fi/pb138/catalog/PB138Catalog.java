/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.catalog;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author jiri21
 */
public class PB138Catalog {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DOMParser domParser = new DOMParser("files/catalog.xml", false, false);
        doMyXMLTransformations(domParser.getDocument());

        // ... TODO: if you need, you can add more methods here for transformations ...
        domParser.saveDocumentToFile("files/catalog_out.xml");
    }

    private static void doMyXMLTransformations(Document document) {
        Catalog catalog = new Catalog(document.getDocumentElement());

        // list subjects        
        for (Subject subject : catalog.getSubjects()) {
            System.out.println(subject.getName());
        }
        
        //rename subject
        Subject mySubject = catalog.getSubjectById("PB138");
        mySubject.setName("XML");
        System.out.println(mySubject.getName());
        
    }

}
