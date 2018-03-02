/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.catalog;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author jiri21
 */
public class Subject {

    private final Element element;

    Subject(Element subjectElement) {
        element = subjectElement;
    }

    public String getName() {
        String name = null;
        NodeList nl = element.getElementsByTagName("nazev");
        if (nl != null && nl.getLength() != 0) {
            name = nl.item(0).getTextContent();
        }
        return name;
    }

    public String getId() {
        String ID = element.getAttribute("ID");
        return ID;
    }

    void setName(String newName) {
        NodeList nl = element.getElementsByTagName("nazev");
        if (nl != null && nl.getLength() != 0) {
            nl.item(0).setTextContent(newName);
        }
    }

}
