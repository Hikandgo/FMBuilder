package my.hikandgo.xmlbuilderapp.service;


import my.hikandgo.xmlbuilderapp.MainApp;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XsdValidator {

    private List<SAXParseException> listError = new ArrayList<>();

    private Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(MainApp.class.getResourceAsStream(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    public List<SAXParseException> isValid(String xsdPath, String xmlPath) throws IOException, SAXException {
        ValidatorErrorHandler xsdErrorHandler = new ValidatorErrorHandler();
        Validator validator = initValidator(xsdPath);
        validator.setErrorHandler(xsdErrorHandler);
        try {
            validator.validate(new StreamSource((xmlPath)));
        } catch (SAXException e) {

        }
        List<SAXParseException> listError = new ArrayList<>();
        xsdErrorHandler.getExceptions().forEach( e -> listError.add(e));
        return xsdErrorHandler.getExceptions();
    }

}
