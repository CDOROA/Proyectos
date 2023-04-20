/**
 * AerolineasR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class AerolineasR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtrosCargosR otrosCargos;

    private java.math.BigDecimal TUA;

    public AerolineasR() {
    }

    public AerolineasR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtrosCargosR otrosCargos,
           java.math.BigDecimal TUA) {
           this.otrosCargos = otrosCargos;
           this.TUA = TUA;
    }


    /**
     * Gets the otrosCargos value for this AerolineasR.
     * 
     * @return otrosCargos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtrosCargosR getOtrosCargos() {
        return otrosCargos;
    }


    /**
     * Sets the otrosCargos value for this AerolineasR.
     * 
     * @param otrosCargos
     */
    public void setOtrosCargos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtrosCargosR otrosCargos) {
        this.otrosCargos = otrosCargos;
    }


    /**
     * Gets the TUA value for this AerolineasR.
     * 
     * @return TUA
     */
    public java.math.BigDecimal getTUA() {
        return TUA;
    }


    /**
     * Sets the TUA value for this AerolineasR.
     * 
     * @param TUA
     */
    public void setTUA(java.math.BigDecimal TUA) {
        this.TUA = TUA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AerolineasR)) return false;
        AerolineasR other = (AerolineasR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.otrosCargos==null && other.getOtrosCargos()==null) || 
             (this.otrosCargos!=null &&
              this.otrosCargos.equals(other.getOtrosCargos()))) &&
            ((this.TUA==null && other.getTUA()==null) || 
             (this.TUA!=null &&
              this.TUA.equals(other.getTUA())));
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
        if (getOtrosCargos() != null) {
            _hashCode += getOtrosCargos().hashCode();
        }
        if (getTUA() != null) {
            _hashCode += getTUA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AerolineasR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AerolineasR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otrosCargos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosCargos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosCargosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TUA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TUA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
