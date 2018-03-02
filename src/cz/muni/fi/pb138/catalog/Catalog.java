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
public class Catalog {

    private final Element element;

    Catalog(Element catalogElement) {
        element = catalogElement;
    }

    Subject[] getSubjects() {
        Subject[] result = null;
        NodeList nl = element.getElementsByTagName("predmet");
        if (nl != null) {
            result = new Subject[nl.getLength()];
            for (int i = 0; i < nl.getLength(); i++) {
                result[i] = new Subject((Element) nl.item(i));
            }
        }
        return result;
    }

    Subject getSubjectById(String ID) {
        Subject result = null;
        Subject[] subjects = getSubjects();
        for (Subject subject : subjects) {
            if (subject.getId().equals(ID)) {
                result = subject;
                break;
            }
        }
        return result;
    }

}
