package com.realdolmen.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dummy {

    String something;

    public Dummy() {
    }

    public Dummy(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }
}
