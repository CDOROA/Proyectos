/**
 * BasicHttpBinding_IServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class BasicHttpBinding_IServiceStub extends org.apache.axis.client.Stub implements org.tempuri.IService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerarCFDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO", "Credenciales"), org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cfdi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Comprobante33R"), org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "GenerarCFDIResponse"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDIResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelarCFDIConValidacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO", "Credenciales"), org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ArrayOfListaUUID"), org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ListaUUID"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "CancelarCFDIConValidacionResponse"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIConValidacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnviarCFDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "RFC"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "clave"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
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
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDIResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerAcuseCancelacion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "acuse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerPDF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
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
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDFResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorUUID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerXMLPorReferencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferenciaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerComprobantes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ArrayOfComprobantesListDTO"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ComprobantesListDTO"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaRFC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "contrasena"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "RFC"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(java.lang.Boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaRFCResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaEstatusCFDI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "consultaR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaR"), org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaR.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaResponseR"));
        oper.setReturnClass(org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaEstatusCFDIResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    public BasicHttpBinding_IServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ArrayOfDetalleCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ArrayOfListaUUID");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ListaUUID");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ListaUUID");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ArrayOfResponseCancelacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ResponseCancelacionR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ResponseCancelacionR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "CancelarCFDIConValidacionResponse");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ListaUUID");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ResponseCancelacionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "AddendaCFDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "ArrayOfDetalleRetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetalleRetencionLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleRetencionLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleRetencionLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "ArrayOfDetallesConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetallesConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetallesConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetallesConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "ArrayOfDetalleTrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetalleTrasladoLocalR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleTrasladoLocalR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleTrasladoLocalR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "ArrayOfEtiquetaPersonalizadaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.EtiquetaPersonalizadaR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "EtiquetaPersonalizadaR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "EtiquetaPersonalizadaR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "ArrayOfFirmaOnLineR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.FirmaOnLineR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "FirmaOnLineR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "FirmaOnLineR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleRetencionLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetalleRetencionLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetallesConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetallesConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DetalleTrasladoLocalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DetalleTrasladoLocalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "DomicilioClienteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DomicilioClienteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "EtiquetaPersonalizadaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.EtiquetaPersonalizadaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "FirmaOnLineR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.FirmaOnLineR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "PagareR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.PagareR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporteRemolque20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteRemolque20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercancia20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercancia20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaCantidadTransporta20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaPedimentos20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaPedimentos20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimoContenedor20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteTiposFigura20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteTiposFiguraPartesTransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ArrayOfCartaPorteUbicacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacion20R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacion20R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercancias20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercancias20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteIdentificacionVehicular20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteRemolque20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporteRemolque20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteSeguros20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasAutotransporteSeguros20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercancia20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaCantidadTransporta20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaCantidadTransporta20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaDetalleMercancia20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaDetalleMercancia20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaGuiasIdentificacion20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasMercanciaPedimentos20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasMercanciaPedimentos20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteAereo20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteAereo20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviario20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviario20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarro20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimo20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimo20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimoContenedor20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteMaritimoContenedor20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFigura20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraDomicilio20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraDomicilio20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacion20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacion20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteUbicacionDomicilio20R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteUbicacionDomicilio20R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ArrayOfComercioExteriorDestinatario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorDestinatario11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatario11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatario11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ArrayOfComercioExteriorDestinatarioDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorDestinatarioDomicilio11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatarioDomicilio11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatarioDomicilio11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ArrayOfComercioExteriorMercancia11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancia11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancia11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ArrayOfComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercanciaDescripcionesEspecificas11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ArrayOfComercioExteriorPropietario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorPropietario11R[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorPropietario11R");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorPropietario11R");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExterior11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExterior11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorDestinatario11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorDestinatarioDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorDestinatarioDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorEmisor11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorEmisor11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorEmisorDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorEmisorDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancia11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercanciaDescripcionesEspecificas11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercanciaDescripcionesEspecificas11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancias11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancias11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorPropietario11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorPropietario11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorReceptor11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorReceptor11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorReceptorDomicilio11R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorReceptorDomicilio11R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfImpuestosRetencionesRetencionDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosRetencionesRetencionDR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosRetencionesRetencionDR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfImpuestosTrasladosTrasladoDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfPagoImpuestosRetencionP");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosRetencionP[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosRetencionP");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosRetencionP");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfPagoImpuestosTrasladoP");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosTrasladoP");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosTrasladoP");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfPagosPagoDoctoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoDoctoRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoDoctoRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ArrayOfPagosPagoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosRetencionesDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosRetencionesDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosTrasladosDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosTrasladosDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosRetencionesRetencionDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoDoctoRelacionadoImpuestosDR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoDoctoRelacionadoImpuestosDR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosRetencionP");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosRetencionP.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosTrasladoP");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "Pagos10R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.Pagos10R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoDoctoRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosRetencionR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosRetencionR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosTrasladoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosTrasladoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ArrayOfComprobantesListDTO");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ComprobantesListDTO");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ComprobantesListDTO");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ComprobantesListDTO");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ArrayOfRespuestaDetalle");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RespuestaDetalle");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RespuestaDetalle");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaResponseR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RespuestaDetalle");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ACuentaTercerosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ACuentaTercerosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfCfdiRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfCfdiRelacionadosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadosR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadosR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR");
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
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfCuentaPredialR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredialR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredialR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfErroresCFDI");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfInformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduaneraR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduaneraR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ParteR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ParteR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfRetencionConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.RetencionConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "RetencionConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "RetencionConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ArrayOfTrasladoConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.TrasladoConceptoR[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "TrasladoConceptoR");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "TrasladoConceptoR");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadosR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Comprobante33R");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CuentaPredialR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CuentaPredialR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "EmisorR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "GenerarCFDIResponse");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ImpuestosConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionAduaneraR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionAduaneraR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionGlobalR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ParteR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ParteR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ReceptorR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "RetencionConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.RetencionConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "TrasladoConceptoR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.TrasladoConceptoR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Nomina.Mailer", "RespuestaOperacionCR");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO", "Credenciales");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse generarCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R cfdi) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/GenerarCFDI");
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
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse cancelarCFDIConValidacion(org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales credenciales, org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID[] uuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/CancelarCFDIConValidacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIConValidacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credenciales, uuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR enviarCFDI(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC, java.lang.String clave, java.lang.String email, java.lang.String uuid, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/EnviarCFDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, RFC, clave, email, uuid, titulo, mensaje, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerAcuseCancelacion(java.lang.String usuario, java.lang.String contrasena, java.lang.String acuse) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ObtenerAcuseCancelacion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, acuse});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerPDF(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ObtenerPDF");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, uuid, nombrePlantilla});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorUUID(java.lang.String usuario, java.lang.String contrasena, java.lang.String uuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ObtenerXMLPorUUID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, uuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR obtenerXMLPorReferencia(java.lang.String usuario, java.lang.String contrasena, java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ObtenerXMLPorReferencia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[] obtenerComprobantes(java.util.Calendar fechaInicial, java.util.Calendar fechaFinal) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ObtenerComprobantes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {fechaInicial, fechaFinal});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[]) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes.ComprobantesListDTO[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.Boolean consultaRFC(java.lang.String usuario, java.lang.String contrasena, java.lang.String RFC) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ConsultaRFC");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaRFC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuario, contrasena, RFC});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.Boolean) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Boolean.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR consultaEstatusCFDI(org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaR consultaR) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/IService/ConsultaEstatusCFDI");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ConsultaEstatusCFDI"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {consultaR});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR) org.apache.axis.utils.JavaUtils.convert(_resp, org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.ConsultaResponseR.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
