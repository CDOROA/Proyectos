/**
 * RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR  implements java.io.Serializable {
    private java.lang.Integer año;

    private java.lang.String modelo;

    private java.lang.String numPlacas;

    private java.lang.String RFC;

    public RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR() {
    }

    public RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR(
           java.lang.Integer año,
           java.lang.String modelo,
           java.lang.String numPlacas,
           java.lang.String RFC) {
           this.año = año;
           this.modelo = modelo;
           this.numPlacas = numPlacas;
           this.RFC = RFC;
    }


    /**
     * Gets the año value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @return año
     */
    public java.lang.Integer getAño() {
        return año;
    }


    /**
     * Sets the año value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @param año
     */
    public void setAño(java.lang.Integer año) {
        this.año = año;
    }


    /**
     * Gets the modelo value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @return modelo
     */
    public java.lang.String getModelo() {
        return modelo;
    }


    /**
     * Sets the modelo value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @param modelo
     */
    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }


    /**
     * Gets the numPlacas value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @return numPlacas
     */
    public java.lang.String getNumPlacas() {
        return numPlacas;
    }


    /**
     * Sets the numPlacas value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @param numPlacas
     */
    public void setNumPlacas(java.lang.String numPlacas) {
        this.numPlacas = numPlacas;
    }


    /**
     * Gets the RFC value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @return RFC
     */
    public java.lang.String getRFC() {
        return RFC;
    }


    /**
     * Sets the RFC value for this RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.
     * 
     * @param RFC
     */
    public void setRFC(java.lang.String RFC) {
        this.RFC = RFC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR)) return false;
        RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR other = (RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.año==null && other.getAño()==null) || 
             (this.año!=null &&
              this.año.equals(other.getAño()))) &&
            ((this.modelo==null && other.getModelo()==null) || 
             (this.modelo!=null &&
              this.modelo.equals(other.getModelo()))) &&
            ((this.numPlacas==null && other.getNumPlacas()==null) || 
             (this.numPlacas!=null &&
              this.numPlacas.equals(other.getNumPlacas()))) &&
            ((this.RFC==null && other.getRFC()==null) || 
             (this.RFC!=null &&
              this.RFC.equals(other.getRFC())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAño() != null) {
            _hashCode += getAño().hashCode();
        }
        if (getModelo() != null) {
            _hashCode += getModelo().hashCode();
        }
        if (getNumPlacas() != null) {
            _hashCode += getNumPlacas().hashCode();
        }
        if (getRFC() != null) {
            _hashCode += getRFC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("año");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Año"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Modelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPlacas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumPlacas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
