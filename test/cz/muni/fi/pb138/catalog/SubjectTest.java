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
public class SubjectTest {

    private Element subjectElement;

    public SubjectTest() {
    }

    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException {
        DOMParser domParser = new DOMParser("files/catalog.xml", false, false);
        Document document = domParser.getDocument();
        subjectElement = (Element) document.getElementsByTagName("predmet").item(0);

    }

    @Test
    public void testCreateSubject() {
        Subject subject = new Subject(subjectElement);
        assertThat(subject, is(notNullValue()));
    }

    /**
     * Test of getName method, of class Subject.
     */
    @Test
    public void testGetName() {
        Subject subject = new Subject(subjectElement);
        assertThat(subject.getName(), is("Advanced Functional Programming"));
    }

    @Test
    public void testGetId() {
        Subject subject = new Subject(subjectElement);
        String ID = subject.getId();
        assertThat(ID, is("IA014"));
    }

    @Test
    public void setName() {
        Subject subject = new Subject(subjectElement);
        String newName = "New Name";
        subject.setName(newName);
        assertThat(subject.getName(), is(newName));
    }
    
    

}
