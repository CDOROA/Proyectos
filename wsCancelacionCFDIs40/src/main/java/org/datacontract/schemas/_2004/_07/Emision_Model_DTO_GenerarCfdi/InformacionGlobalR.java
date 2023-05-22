/**
 * InformacionGlobalR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class InformacionGlobalR  implements java.io.Serializable {
    private java.lang.Integer año;

    private java.lang.String meses;

    private java.lang.String periodicidad;

    public InformacionGlobalR() {
    }

    public InformacionGlobalR(
           java.lang.Integer año,
           java.lang.String meses,
           java.lang.String periodicidad) {
           this.año = año;
           this.meses = meses;
           this.periodicidad = periodicidad;
    }


    /**
     * Gets the año value for this InformacionGlobalR.
     * 
     * @return año
     */
    public java.lang.Integer getAño() {
        return año;
    }


    /**
     * Sets the año value for this InformacionGlobalR.
     * 
     * @param año
     */
    public void setAño(java.lang.Integer año) {
        this.año = año;
    }


    /**
     * Gets the meses value for this InformacionGlobalR.
     * 
     * @return meses
     */
    public java.lang.String getMeses() {
        return meses;
    }


    /**
     * Sets the meses value for this InformacionGlobalR.
     * 
     * @param meses
     */
    public void setMeses(java.lang.String meses) {
        this.meses = meses;
    }


    /**
     * Gets the periodicidad value for this InformacionGlobalR.
     * 
     * @return periodicidad
     */
    public java.lang.String getPeriodicidad() {
        return periodicidad;
    }


    /**
     * Sets the periodicidad value for this InformacionGlobalR.
     * 
     * @param periodicidad
     */
    public void setPeriodicidad(java.lang.String periodicidad) {
        this.periodicidad = periodicidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformacionGlobalR)) return false;
        InformacionGlobalR other = (InformacionGlobalR) obj;
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
            ((this.meses==null && other.getMeses()==null) || 
             (this.meses!=null &&
              this.meses.equals(other.getMeses()))) &&
            ((this.periodicidad==null && other.getPeriodicidad()==null) || 
             (this.periodicidad!=null &&
              this.periodicidad.equals(other.getPeriodicidad())));
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
        if (getMeses() != null) {
            _hashCode += getMeses().hashCode();
        }
        if (getPeriodicidad() != null) {
            _hashCode += getPeriodicidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformacionGlobalR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionGlobalR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("año");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Año"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("meses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Meses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodicidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Periodicidad"));
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
