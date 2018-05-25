package com.epam.lab.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataClass {
    @XmlElement
    private String login;
    @XmlElement
    private String password;
    @XmlElement
    private String lettersNumber;
    @XmlElement
    private String logingit;
    @XmlElement
    private String passwordgit;
    @XmlElement
    private String query1;
    @XmlElement
    private String query2;
    @XmlElement
    private String tag;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getLettersNumber() {
        return Integer.parseInt(lettersNumber);
    }

    public String getLogingit() {
        return logingit;
    }

    public String getPasswordgit() {
        return passwordgit;
    }

    public String getQuery1() {
        return query1;
    }

    public String getQuery2() {
        return query2;
    }

    public String getTag() {
        return tag;
    }
}
