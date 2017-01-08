package com.company.jaxb;

import com.company.jaxb.holder.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by Pgupta on 15-06-2016.
 */
public class JAXBMain {

    public Object unmarshal(Class<?> className, InputStream inputStream) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(className);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(inputStream);
    }

    public StringWriter marshal(Class<?> className, Object object) throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(className);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(object, stringWriter);
        return stringWriter;
    }

    public static void main(String args[]) throws JAXBException {
        JAXBMain jaxbMain = new JAXBMain();
        Data data = new Data();
        data.setType("BoradingPass");
        data.getDatum().add("Prince              ");
        String dummy = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><data><datum xml:space='preserve'>CP?1C01?01V?02PASSENGER?03NAME?04SPICE/E?05FROM?06DELHI?07TO?08MUMBAI?09SEAT NUMBER?10FLIGHT#?11BOARDING TIME?123F?13 161?141506?15DATE?16CONF#?1715JUN16?18G2YVGL?19DEPART?20ARRIVE?211506?221706?23SSR?24SEQ NUMBER?254?26GATE?27FROM/TO?28SEAT#?29DEL/BOM?30M1SPICE/E              G2YVGL DELBOMSG   161167   3F4     100?31?32?33@10?34SG?</datum></data>";
        //InputStream inputStream = new ByteArrayInputStream((jaxbMain.marshal(Data.class, data)).toString().getBytes());
        InputStream inputStream = new ByteArrayInputStream(dummy.getBytes());
        Data data1 = (Data)(jaxbMain.unmarshal(Data.class,inputStream)) ;

        String replace= "Prince Gupta";
        System.out.print(replace.replaceAll("\\s+",""));

    }
}
