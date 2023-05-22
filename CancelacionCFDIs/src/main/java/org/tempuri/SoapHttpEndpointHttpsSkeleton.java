/**
 * SoapHttpEndpointHttpsSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SoapHttpEndpointHttpsSkeleton implements org.tempuri.IConexionRemota, org.apache.axis.wsdl.Skeleton {
    private org.tempuri.IConexionRemota impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarCFDIs", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarCFDIs");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarCFDIs") == null) {
            _myOperations.put("cancelarCFDIs", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarCFDIs")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cfdi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("generarCFDI", _params, new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDIResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/GenerarCFDI");
        _myOperationsList.add(_oper);
        if (_myOperations.get("generarCFDI") == null) {
            _myOperations.put("generarCFDI", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("generarCFDI")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cfdi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante40R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("generarCFDI40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarCFDI40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/GenerarCFDI40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("generarCFDI40") == null) {
            _myOperations.put("generarCFDI40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("generarCFDI40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante33R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("generarTicket", _params, new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicketResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/GenerarTicket");
        _myOperationsList.add(_oper);
        if (_myOperations.get("generarTicket") == null) {
            _myOperations.put("generarTicket", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("generarTicket")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ticket"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Comprobante40R"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("generarTicket40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "GenerarTicket40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/GenerarTicket40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("generarTicket40") == null) {
            _myOperations.put("generarTicket40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("generarTicket40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "titulo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "mensaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("enviarCFDI", _params, new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDIResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/EnviarCFDI");
        _myOperationsList.add(_oper);
        if (_myOperations.get("enviarCFDI") == null) {
            _myOperations.put("enviarCFDI", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("enviarCFDI")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "titulo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "mensaje"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("enviarCFDI40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "EnviarCFDI40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/EnviarCFDI40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("enviarCFDI40") == null) {
            _myOperations.put("enviarCFDI40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("enviarCFDI40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerPDF", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDFResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerPDF");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerPDF") == null) {
            _myOperations.put("obtenerPDF", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerPDF")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nombrePlantilla"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerPDF40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerPDF40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerPDF40") == null) {
            _myOperations.put("obtenerPDF40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerPDF40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLPorReferencia", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferenciaResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLPorReferencia");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLPorReferencia") == null) {
            _myOperations.put("obtenerXMLPorReferencia", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLPorReferencia")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLPorReferencia40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorReferencia40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLPorReferencia40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLPorReferencia40") == null) {
            _myOperations.put("obtenerXMLPorReferencia40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLPorReferencia40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLPorUUID", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUIDResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLPorUUID") == null) {
            _myOperations.put("obtenerXMLPorUUID", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLPorUUID")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLPorUUID40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLPorUUID40") == null) {
            _myOperations.put("obtenerXMLPorUUID40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLPorUUID40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLyAddendaPorUUID", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLyAddendaPorUUIDResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLyAddendaPorUUID"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLyAddendaPorUUID");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLyAddendaPorUUID") == null) {
            _myOperations.put("obtenerXMLyAddendaPorUUID", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLyAddendaPorUUID")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerNumerosCreditos", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerNumerosCreditosResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerNumerosCreditos"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerNumerosCreditos");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerNumerosCreditos") == null) {
            _myOperations.put("obtenerNumerosCreditos", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerNumerosCreditos")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerComprobantes", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantesResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerComprobantes");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerComprobantes") == null) {
            _myOperations.put("obtenerComprobantes", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerComprobantes")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerComprobantes40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerComprobantes40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerComprobantes40") == null) {
            _myOperations.put("obtenerComprobantes40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerComprobantes40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerAcuseEnvio", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvioResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerAcuseEnvio");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerAcuseEnvio") == null) {
            _myOperations.put("obtenerAcuseEnvio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerAcuseEnvio")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerAcuseEnvio40", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio40Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseEnvio40"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerAcuseEnvio40");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerAcuseEnvio40") == null) {
            _myOperations.put("obtenerAcuseEnvio40", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerAcuseEnvio40")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerAcuseCancelacion", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerAcuseCancelacion"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerAcuseCancelacion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerAcuseCancelacion") == null) {
            _myOperations.put("obtenerAcuseCancelacion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerAcuseCancelacion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "rfc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("validarRFC", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ValidarRFCResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaValidacionRFCCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ValidarRFC"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ValidarRFC");
        _myOperationsList.add(_oper);
        if (_myOperations.get("validarRFC") == null) {
            _myOperations.put("validarRFC", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("validarRFC")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerTickets", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTickets"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerTickets");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerTickets") == null) {
            _myOperations.put("obtenerTickets", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerTickets")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "tamanoPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), java.lang.Short.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Estatus"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstatusTicket"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerTicketsPorEstatus", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsPorEstatusResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteTicketsCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerTicketsPorEstatus"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerTicketsPorEstatus");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerTicketsPorEstatus") == null) {
            _myOperations.put("obtenerTicketsPorEstatus", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerTicketsPorEstatus")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarTicket", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicketResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicket"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarTicket");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarTicket") == null) {
            _myOperations.put("cancelarTicket", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarTicket")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "referencias"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarTickets", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTicketsResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarTickets"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarTickets");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarTickets") == null) {
            _myOperations.put("cancelarTickets", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarTickets")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NumCreditos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("activarPaquete", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ActivarPaqueteResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ActivarPaquete"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ActivarPaquete");
        _myOperationsList.add(_oper);
        if (_myOperations.get("activarPaquete") == null) {
            _myOperations.put("activarPaquete", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("activarPaquete")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NumCreditos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "cuentaDestino"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("traspasarPaquete", _params, new javax.xml.namespace.QName("http://tempuri.org/", "TraspasarPaqueteResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "TraspasarPaquete"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/TraspasarPaquete");
        _myOperationsList.add(_oper);
        if (_myOperations.get("traspasarPaquete") == null) {
            _myOperations.put("traspasarPaquete", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("traspasarPaquete")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDMotivoCancelacionCR"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarCFDIsConValidacion", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsConValidacionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsConValidacion"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarCFDIsConValidacion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarCFDIsConValidacion") == null) {
            _myOperations.put("cancelarCFDIsConValidacion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarCFDIsConValidacion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDMotivoCancelacionCR"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarCFDIsV4", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsV4Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIsV4"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarCFDIsV4");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarCFDIsV4") == null) {
            _myOperations.put("cancelarCFDIsV4", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarCFDIsV4")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerSolicitudesPendientesCancelacion", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesPendientesCancelacionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesPendientesCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesPendientesCancelacion"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerSolicitudesPendientesCancelacion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerSolicitudesPendientesCancelacion") == null) {
            _myOperations.put("obtenerSolicitudesPendientesCancelacion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerSolicitudesPendientesCancelacion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ArrayOfUUIDProcesarRespuesta"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("procesarSolicitudesCancelacion", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ProcesarSolicitudesCancelacionResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaProcesarSolicitudCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ProcesarSolicitudesCancelacion"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ProcesarSolicitudesCancelacion");
        _myOperationsList.add(_oper);
        if (_myOperations.get("procesarSolicitudesCancelacion") == null) {
            _myOperations.put("procesarSolicitudesCancelacion", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("procesarSolicitudesCancelacion")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerSolicitudesCancelacionProcesadas", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesCancelacionProcesadasResult"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaSolicitudesProcesadasCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerSolicitudesCancelacionProcesadas"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerSolicitudesCancelacionProcesadas");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerSolicitudesCancelacionProcesadas") == null) {
            _myOperations.put("obtenerSolicitudesCancelacionProcesadas", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerSolicitudesCancelacionProcesadas")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring"), java.lang.String[].class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("cancelarCFDIs32", _params, new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs32Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaCancelacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "CancelarCFDIs32"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/CancelarCFDIs32");
        _myOperationsList.add(_oper);
        if (_myOperations.get("cancelarCFDIs32") == null) {
            _myOperations.put("cancelarCFDIs32", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("cancelarCFDIs32")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fechaFinal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "filaInicial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerComprobantes32", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes32Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerComprobantes32"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerComprobantes32");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerComprobantes32") == null) {
            _myOperations.put("obtenerComprobantes32", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerComprobantes32")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerXMLPorUUID32", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID32Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerXMLPorUUID32"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerXMLPorUUID32");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerXMLPorUUID32") == null) {
            _myOperations.put("obtenerXMLPorUUID32", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerXMLPorUUID32")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "credenciales"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Credenciales"), org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "uuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("obtenerPDF32", _params, new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF32Result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaOperacionCR"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tempuri.org/", "ObtenerPDF32"));
        _oper.setSoapAction("http://tempuri.org/IConexionRemota/ObtenerPDF32");
        _myOperationsList.add(_oper);
        if (_myOperations.get("obtenerPDF32") == null) {
            _myOperations.put("obtenerPDF32", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("obtenerPDF32")).add(_oper);
    }

    public SoapHttpEndpointHttpsSkeleton() {
        this.impl = new org.tempuri.SoapHttpEndpointHttpsImpl();
    }

    public SoapHttpEndpointHttpsSkeleton(org.tempuri.IConexionRemota impl) {
        this.impl = impl;
    }
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR ret = impl.cancelarCFDIs(credenciales, uuids);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R cfdi) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.generarCFDI(credenciales, cfdi);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR generarCFDI40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R cfdi) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.generarCFDI40(credenciales, cfdi);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R ticket) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR ret = impl.generarTicket(credenciales, ticket);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR generarTicket40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante40R ticket) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR ret = impl.generarTicket40(credenciales, ticket);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.enviarCFDI(credenciales, uuid, email, titulo, mensaje, nombrePlantilla);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR enviarCFDI40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String email, java.lang.String titulo, java.lang.String mensaje, java.lang.String nombrePlantilla) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.enviarCFDI40(credenciales, uuid, email, titulo, mensaje, nombrePlantilla);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerPDF(credenciales, uuid, nombrePlantilla);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid, java.lang.String nombrePlantilla) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerPDF40(credenciales, uuid, nombrePlantilla);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLPorReferencia(credenciales, referencia);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorReferencia40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLPorReferencia40(credenciales, referencia);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLPorUUID(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLPorUUID40(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLyAddendaPorUUID(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLyAddendaPorUUID(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR obtenerNumerosCreditos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR ret = impl.obtenerNumerosCreditos(credenciales);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR ret = impl.obtenerComprobantes(credenciales, fechaInicial, fechaFinal, filaInicial);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR ret = impl.obtenerComprobantes40(credenciales, fechaInicial, fechaFinal, filaInicial);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerAcuseEnvio(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseEnvio40(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerAcuseEnvio40(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerAcuseCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerAcuseCancelacion(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR validarRFC(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String rfc) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaValidacionRFCCR ret = impl.validarRFC(credenciales, rfc);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR ret = impl.obtenerTickets(credenciales, fechaInicial, fechaFinal, filaInicial);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR obtenerTicketsPorEstatus(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Short tamanoPagina, java.lang.Integer filaInicial, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstatusTicket estatus) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteTicketsCR ret = impl.obtenerTicketsPorEstatus(credenciales, fechaInicial, fechaFinal, tamanoPagina, filaInicial, estatus);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTicket(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String referencia) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR ret = impl.cancelarTicket(credenciales, referencia);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR cancelarTickets(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] referencias) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaTicketCR ret = impl.cancelarTickets(credenciales, referencias);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR activarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR ret = impl.activarPaquete(credenciales, numCreditos);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR traspasarPaquete(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.Integer numCreditos, java.lang.String cuentaDestino) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaNumeroCreditosCR ret = impl.traspasarPaquete(credenciales, numCreditos, cuentaDestino);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIsConValidacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[] uuids) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR ret = impl.cancelarCFDIsConValidacion(credenciales, uuids);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIsV4(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR[] uuids) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR ret = impl.cancelarCFDIsV4(credenciales, uuids);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR obtenerSolicitudesPendientesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesPendientesCR ret = impl.obtenerSolicitudesPendientesCancelacion(credenciales);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR procesarSolicitudesCancelacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDProcesarRespuesta[] uuids) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaProcesarSolicitudCR ret = impl.procesarSolicitudesCancelacion(credenciales, uuids);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR obtenerSolicitudesCancelacionProcesadas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaSolicitudesProcesadasCR ret = impl.obtenerSolicitudesCancelacionProcesadas(credenciales, fechaInicial, fechaFinal, filaInicial);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR cancelarCFDIs32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String[] uuids) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR ret = impl.cancelarCFDIs32(credenciales, uuids);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR obtenerComprobantes32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.util.Calendar fechaInicial, java.util.Calendar fechaFinal, java.lang.Integer filaInicial) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaReporteCR ret = impl.obtenerComprobantes32(credenciales, fechaInicial, fechaFinal, filaInicial);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerXMLPorUUID32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerXMLPorUUID32(credenciales, uuid);
        return ret;
    }

    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR obtenerPDF32(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales credenciales, java.lang.String uuid) throws java.rmi.RemoteException
    {
        org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR ret = impl.obtenerPDF32(credenciales, uuid);
        return ret;
    }

}
