package com.epam.lab.data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataReader {
    public DataClass readData(File xml) {
        DataClass data = new DataClass();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataClass.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            data = (DataClass) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return data;
    }
}
