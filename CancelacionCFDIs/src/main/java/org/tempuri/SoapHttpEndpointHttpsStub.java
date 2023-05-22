/**
 * SoapHttpEndpointHttpsStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SoapHttpEndpointHttpsStub extends org.apache.axis.client.Stub implements org.tempuri.IConexionRemota {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[36];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarCFDIs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerarCFDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cfdi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDIResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerarCFDI40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cfdi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante40R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerarTicket");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicketResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerarTicket40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante40R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnviarCFDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "titulo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "mensaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDIResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnviarCFDI40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "titulo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "mensaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerPDF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDFResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerPDF40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorReferencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferenciaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorReferencia40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorUUID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorUUID40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLyAddendaPorUUID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLyAddendaPorUUIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerNumerosCreditos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerNumerosCreditosResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerComprobantes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerComprobantes40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerAcuseEnvio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvioResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerAcuseEnvio40");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio40Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerAcuseCancelacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ValidarRFC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "rfc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaValidacionRFCCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ValidarRFCResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerTickets");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerTicketsPorEstatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "tamanoPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), java.lang.Short.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Estatus"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstatusTicket"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsPorEstatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarTicket");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicketResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarTickets");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicketsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ActivarPaquete");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NumCreditos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ActivarPaqueteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TraspasarPaquete");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NumCreditos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cuentaDestino"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "TraspasarPaqueteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarCFDIsConValidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDMotivoCancelacionCR"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDMotivoCancelacionCR"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsConValidacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarCFDIsV4");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDMotivoCancelacionCR"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDMotivoCancelacionCR"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsV4Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerSolicitudesPendientesCancelacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesPendientesCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesPendientesCancelacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProcesarSolicitudesCancelacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDProcesarRespuesta"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDProcesarRespuesta"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaProcesarSolicitudCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ProcesarSolicitudesCancelacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerSolicitudesCancelacionProcesadas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesProcesadasCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesCancelacionProcesadasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarCFDIs32");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs32Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerComprobantes32");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes32Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorUUID32");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID32Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerPDF32");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF32Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

    }

    public SoapHttpEndpointHttpsStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SoapHttpEndpointHttpsStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SoapHttpEndpointHttpsStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
        addBindings2();
        addBindings3();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AccionesOTitulosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AccionesOTitulosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ACuentaTerceros40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ACuentaTerceros40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AddendaCFD40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFD40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AddendaCFDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AddendaCFDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AerolineasR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AerolineasR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfActividadesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ActividadesR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCargoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CargoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CargoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercancia20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercancia20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercancia20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaPedimentos20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarro20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteMaritimoContenedor20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteTiposFigura20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFigura20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFigura20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFigura20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteTiposFiguraPartesTransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFiguraPartesTransporte20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFiguraPartesTransporte20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFiguraPartesTransporte20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCartaPorteUbicacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteUbicacion20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteUbicacion20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteUbicacion20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCentroCostosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCfdiRelacionado40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCfdiRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCfdiRelacionados40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionados40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionados40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionados40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfComercioExteriorDestinatario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatario11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatario11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfComercioExteriorDestinatarioDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatarioDomicilio11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatarioDomicilio11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatarioDomicilio11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfComercioExteriorMercancia11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfComercioExteriorPropietario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Concepto40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfConceptoConsumoDeCombustibles11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustibles11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustibles11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfConceptoConsumoDeCombustiblesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustiblesR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustiblesR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustiblesR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfConceptoValesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoValesR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoValesR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoValesR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfContabilidadR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContabilidadR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContabilidadR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfCuentaPredial40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDatosAdquirienteCopSCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDatosEnajenanteCopSCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteCopSCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteCopSCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDeduccionNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionNomina12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionNomina12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDescInmuebleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescInmuebleR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescInmuebleR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetalleCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleCancelacionCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleCancelacionCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleCancelacionCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetalleRetencionLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocal40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocal40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocal40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetalleRetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetallesConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConcepto40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConcepto40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConcepto40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetallesConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetalleTrasladoLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocal40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocal40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocal40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDetalleTrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDeterminado11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Determinado11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Determinado11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Determinado11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDeterminadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeterminadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeterminadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDispersionDelRecursoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfDocumentoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEntidadR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfErogacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEtiquetaPersonalizada40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizada40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizada40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizada40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfEtiquetaPersonalizadaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfFirmaOnLine40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLine40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLine40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLine40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfFirmaOnLineR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfFolioRespuestaCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioRespuestaCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioRespuestaCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfHorasExtra12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfIdentificacionDelGastoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfIncapacidadNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfInformacionAduanera40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfInformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfInformacionAduaneraTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraTercerosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraTercerosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfInformacionAduaneraVentaVehiculos");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfInformacionAduaneraVentaVehiculos40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfIngresosHidrocarburosDocumentoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfLeyendaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfOtroPagoNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPago20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoDoctoRelacionado20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoDoctoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoImpuestosP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoImpuestosPRetencionP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPRetencionP20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPRetencionP20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoImpuestosPTrasladoP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoImpuestosRetencionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosRetencionR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosRetencionR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoImpuestosTrasladoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPagosPagoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfParte40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parte40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parte40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParteR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParteR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPercepcion12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPorCuentadeTercerosParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTercerosParteR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTercerosParteR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfPozosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PozosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PozosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRegistroCFDICR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRegistroSolicitudesCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroSolicitudesCancelacionCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroSolicitudesCancelacionCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRegistroTicketCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroTicketCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroTicketCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfrenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRetencionConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConcepto40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConcepto40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRetencionConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRetencionLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocal40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocal40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfRetencionTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionTercerosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionTercerosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionTercerosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfSubActividadesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfSubContratacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubContratacionR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubContratacionR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubContratacionR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTareasR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TareasR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TareasR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTrasladoConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConcepto40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConcepto40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTrasladoConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTrasladoLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocal40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocal40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfTrasladoTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoTercerosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoTercerosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoTercerosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDMotivoCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDMotivoCancelacionCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDMotivoCancelacionCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDProcesarRespuesta");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDProcesarRespuesta");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDProcesarRespuesta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfVehiculoUsadoInformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoInformacionAduaneraR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoInformacionAduaneraR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfVentaVehiculosParte40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParte40R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParte40R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParte40R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfVentaVehiculosParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParteR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParteR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfYacimientosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.YacimientosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "YacimientosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "YacimientosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BeneficiarioR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.BeneficiarioR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CargoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercancias20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercancias20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteIdentificacionVehicular20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteSeguros20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercancia20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaDetalleMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteAereo20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteAereo20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviario20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviario20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarro20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteMaritimo20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteMaritimo20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteMaritimoContenedor20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFigura20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFigura20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFiguraDomicilio20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFiguraDomicilio20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteTiposFiguraPartesTransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFiguraPartesTransporte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteUbicacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteUbicacion20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteUbicacionDomicilio20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteUbicacionDomicilio20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CentroCostosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CentroCostosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionInformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionInformacionAduaneraR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionVehiculoDestruidoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionVehiculoDestruidoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CFDIRegistroFiscalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CFDIRegistroFiscalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionados40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionados40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionadosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionadosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExterior11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExterior11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatarioDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatarioDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisor11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisor11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisorDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorReceptor11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptor11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorReceptorDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptorDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CompensacionSaldosAFavorR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Concepto40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustibles11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustiblesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustiblesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoValesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoValesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConsumoDeCombustibles11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustibles11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConsumoDeCombustiblesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConsumoDeCombustiblesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContabilidadR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredial40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredialR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredialTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteCopSCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosNotarioR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosNotarioR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosOperacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosOperacionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnAdquirienteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnAdquirienteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnEnajenanteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnEnajenanteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatoTransitoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatoTransitoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionesNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescInmuebleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleCancelacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocal40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConcepto40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocal40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Determinado11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Determinado11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeterminadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DivisaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DivisaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DocumentoRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioCliente40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioCliente40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DonatariasR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DonatariasR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Emisor40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Emisor40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings2() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadSNCFR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadSNCFR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustible12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustible12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTrasladoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstatusTicket");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizada40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizada40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLine40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLine40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioRespuestaCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "GastosHidrocarburosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.GastosHidrocarburosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDeRecursoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDeRecursoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConcepto40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "INER");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.INER.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduanera40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionFiscalTerceroR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionFiscalTerceroR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionGlobal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionGlobal40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InmuebleR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InmuebleR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativas40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativas40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativasR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativasR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IntegranteCoordinadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IntegranteCoordinadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "JubilacionPensionRetiroR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaFiscalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaFiscalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.LeyendaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Nomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NotariosPublicosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.NotariosPublicosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObrasArteAntiguedadesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ObrasArteAntiguedadesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OrdenanteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OrdenanteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosCargosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtrosCargosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagare40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagare40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagareR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagoEnEspecieR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagoEnEspecieR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagos10R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos10R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagos20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Pagos20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDR20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDR20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPRetencionP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosRetencionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosTotales20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosTotales20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParcialesConstruccionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParcialesConstruccionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Parte40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Parte40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PercepcionesNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTerceros11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTerceros11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTercerosParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PozosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Receptor40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Receptor40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReceptorNomina12R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReceptorR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroSolicitudesCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroSolicitudesCancelacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroTicketCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroTicketCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RenovacionYSustitucionVehiculosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionYSustitucionVehiculosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaProcesarSolicitudCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesPendientesCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesProcesadasCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaValidacionRFCCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings3() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SeparacionIndemnizacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SPEIR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SPEIR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubContratacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubContratacionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubsidioAlEmpleoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TareasR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConcepto40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocal40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TuristaPasajeroExtranjeroR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TuristaPasajeroExtranjeroR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDMotivoCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDProcesarRespuesta");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValesDeDespensaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ValesDeDespensaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoInformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoInformacionAduaneraR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VehiculoUsadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculos40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculos40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParte40R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParte40R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "YacimientosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.YacimientosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarCFDIs");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R cfdi) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/GenerarCFDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, cfdi});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R cfdi) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/GenerarCFDI40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, cfdi});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R ticket) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/GenerarTicket");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, ticket});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R ticket) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/GenerarTicket40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, ticket});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/EnviarCFDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid, email, titulo, mensaje, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/EnviarCFDI40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid, email, titulo, mensaje, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerPDF");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerPDF40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLPorReferencia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLPorReferencia40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLyAddendaPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLyAddendaPorUUID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLyAddendaPorUUID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR obtenerNumerosCreditos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerNumerosCreditos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerNumerosCreditos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerComprobantes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, filaInicial});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerComprobantes40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, filaInicial});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerAcuseEnvio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerAcuseEnvio40");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio40"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerAcuseCancelacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR validarRFC(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String rfc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ValidarRFC");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ValidarRFC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, rfc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerTickets");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTickets"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, filaInicial});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTicketsPorEstatus(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Short tamanoPagina, java.lang.Integer filaInicial, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket estatus) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerTicketsPorEstatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsPorEstatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, tamanoPagina, filaInicial, estatus});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarTicket");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicket"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] referencias) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarTickets");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTickets"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, referencias});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR activarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ActivarPaquete");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ActivarPaquete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, numCreditos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR traspasarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos, java.lang.String cuentaDestino) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/TraspasarPaquete");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "TraspasarPaquete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, numCreditos, cuentaDestino});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIsConValidacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarCFDIsConValidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsConValidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIsV4(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarCFDIsV4");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsV4"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR obtenerSolicitudesPendientesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerSolicitudesPendientesCancelacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesPendientesCancelacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR procesarSolicitudesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ProcesarSolicitudesCancelacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ProcesarSolicitudesCancelacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR obtenerSolicitudesCancelacionProcesadas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerSolicitudesCancelacionProcesadas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesCancelacionProcesadas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, filaInicial});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/CancelarCFDIs32");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs32"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerComprobantes32");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes32"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, fechaInicial, fechaFinal, filaInicial});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID32");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID32"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IConexionRemota/ObtenerPDF32");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF32"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
