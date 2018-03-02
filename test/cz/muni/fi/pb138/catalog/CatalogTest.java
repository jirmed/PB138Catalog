/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.catalog;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author jiri21
 */
public class CatalogTest {

    private Element catalogElement;
    
    public CatalogTest() {
    }
    
    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DOMParser domParser = new DOMParser("files/catalog.xml", false, false);
        Document document = domParser.getDocument();
        catalogElement = (Element)document.getElementsByTagName("katalog").item(0);
    }

    @Test
    public void testCreateCatalog() {
        Catalog catalog = new Catalog(catalogElement);
        assertThat(catalog, is(notNullValue()));
    }

    @Test
    public void testGetSubjects() {
        Catalog catalog = new Catalog(catalogElement);
        Subject[] subjects = catalog.getSubjects();
        assertThat(subjects.length, is(5));
    }
    
        @Test
    public void testGetSubjectById() {
        Catalog catalog = new Catalog(catalogElement);
        String ID = "PB138";
        Subject subject = catalog.getSubjectById(ID);
        assertThat(subject.getId(), is(ID));
    }

    
}
