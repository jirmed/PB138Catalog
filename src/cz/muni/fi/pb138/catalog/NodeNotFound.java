/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.catalog;

/**
 *
 * @author jiri21
 */
public class NodeNotFound extends Exception {

    /**
     * Creates a new instance of <code>NodeNotFound</code> without detail
     * message.
     */
    public NodeNotFound() {
    }

    public NodeNotFound(String msg) {
        super(msg);
    }
}
