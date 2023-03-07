package my.hikandgo.xmlbuilderapp.constants;

public enum XsdPaths {
    SV_794_1("xsdSchemas/svetofor/BnkClientFileXML.xsd", "Светофор"),
    SV_794_2("xsdSchemas/svetofor/RiskFileXML.xsd", "Светофор-2");


    private final String xsdPath;
    private final String docName;


    XsdPaths(String xsdPath, String docName) {
        this.xsdPath = xsdPath;
        this.docName = docName;
    }

    public String getDocName() {
        return docName;
    }

    public String getXsdPath() {
        return xsdPath;
    }
}
