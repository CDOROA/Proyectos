/**
 * ConexionRemotaLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ConexionRemotaLocator extends org.apache.axis.client.Service implements org.tempuri.ConexionRemota {

    public ConexionRemotaLocator() {
    }


    public ConexionRemotaLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConexionRemotaLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for soapHttpEndpointHttps
    private java.lang.String soapHttpEndpointHttps_address = "https://www.appfacturainteligente.com/CR33/ConexionRemota.svc";

    public java.lang.String getsoapHttpEndpointHttpsAddress() {
        return soapHttpEndpointHttps_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String soapHttpEndpointHttpsWSDDServiceName = "soapHttpEndpointHttps";

    public java.lang.String getsoapHttpEndpointHttpsWSDDServiceName() {
        return soapHttpEndpointHttpsWSDDServiceName;
    }

    public void setsoapHttpEndpointHttpsWSDDServiceName(java.lang.String name) {
        soapHttpEndpointHttpsWSDDServiceName = name;
    }

    public org.tempuri.IConexionRemota getsoapHttpEndpointHttps() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(soapHttpEndpointHttps_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsoapHttpEndpointHttps(endpoint);
    }

    public org.tempuri.IConexionRemota getsoapHttpEndpointHttps(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.SoapHttpEndpointHttpsStub _stub = new org.tempuri.SoapHttpEndpointHttpsStub(portAddress, this);
            _stub.setPortName(getsoapHttpEndpointHttpsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsoapHttpEndpointHttpsEndpointAddress(java.lang.String address) {
        soapHttpEndpointHttps_address = address;
    }


    // Use to get a proxy class for soapHttpEndpoint
    private java.lang.String soapHttpEndpoint_address = "http://www.appfacturainteligente.com/CR33/ConexionRemota.svc";

    public java.lang.String getsoapHttpEndpointAddress() {
        return soapHttpEndpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String soapHttpEndpointWSDDServiceName = "soapHttpEndpoint";

    public java.lang.String getsoapHttpEndpointWSDDServiceName() {
        return soapHttpEndpointWSDDServiceName;
    }

    public void setsoapHttpEndpointWSDDServiceName(java.lang.String name) {
        soapHttpEndpointWSDDServiceName = name;
    }

    public org.tempuri.IConexionRemota getsoapHttpEndpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(soapHttpEndpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsoapHttpEndpoint(endpoint);
    }

    public org.tempuri.IConexionRemota getsoapHttpEndpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.SoapHttpEndpointStub _stub = new org.tempuri.SoapHttpEndpointStub(portAddress, this);
            _stub.setPortName(getsoapHttpEndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsoapHttpEndpointEndpointAddress(java.lang.String address) {
        soapHttpEndpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.IConexionRemota.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.SoapHttpEndpointHttpsStub _stub = new org.tempuri.SoapHttpEndpointHttpsStub(new java.net.URL(soapHttpEndpointHttps_address), this);
                _stub.setPortName(getsoapHttpEndpointHttpsWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.IConexionRemota.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.SoapHttpEndpointStub _stub = new org.tempuri.SoapHttpEndpointStub(new java.net.URL(soapHttpEndpoint_address), this);
                _stub.setPortName(getsoapHttpEndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("soapHttpEndpointHttps".equals(inputPortName)) {
            return getsoapHttpEndpointHttps();
        }
        else if ("soapHttpEndpoint".equals(inputPortName)) {
            return getsoapHttpEndpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ConexionRemota");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "soapHttpEndpointHttps"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "soapHttpEndpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("soapHttpEndpointHttps".equals(portName)) {
            setsoapHttpEndpointHttpsEndpointAddress(address);
        }
        else 
if ("soapHttpEndpoint".equals(portName)) {
            setsoapHttpEndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
