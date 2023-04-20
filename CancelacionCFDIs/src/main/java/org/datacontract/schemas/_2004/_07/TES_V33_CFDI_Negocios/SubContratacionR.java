/**
 * SubContratacionR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class SubContratacionR  implements java.io.Serializable {
    private java.math.BigDecimal porcentajeTiempo;

    private java.lang.String rfcLabora;

    public SubContratacionR() {
    }

    public SubContratacionR(
           java.math.BigDecimal porcentajeTiempo,
           java.lang.String rfcLabora) {
           this.porcentajeTiempo = porcentajeTiempo;
           this.rfcLabora = rfcLabora;
    }


    /**
     * Gets the porcentajeTiempo value for this SubContratacionR.
     * 
     * @return porcentajeTiempo
     */
    public java.math.BigDecimal getPorcentajeTiempo() {
        return porcentajeTiempo;
    }


    /**
     * Sets the porcentajeTiempo value for this SubContratacionR.
     * 
     * @param porcentajeTiempo
     */
    public void setPorcentajeTiempo(java.math.BigDecimal porcentajeTiempo) {
        this.porcentajeTiempo = porcentajeTiempo;
    }


    /**
     * Gets the rfcLabora value for this SubContratacionR.
     * 
     * @return rfcLabora
     */
    public java.lang.String getRfcLabora() {
        return rfcLabora;
    }


    /**
     * Sets the rfcLabora value for this SubContratacionR.
     * 
     * @param rfcLabora
     */
    public void setRfcLabora(java.lang.String rfcLabora) {
        this.rfcLabora = rfcLabora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubContratacionR)) return false;
        SubContratacionR other = (SubContratacionR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.porcentajeTiempo==null && other.getPorcentajeTiempo()==null) || 
             (this.porcentajeTiempo!=null &&
              this.porcentajeTiempo.equals(other.getPorcentajeTiempo()))) &&
            ((this.rfcLabora==null && other.getRfcLabora()==null) || 
             (this.rfcLabora!=null &&
              this.rfcLabora.equals(other.getRfcLabora())));
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
        if (getPorcentajeTiempo() != null) {
            _hashCode += getPorcentajeTiempo().hashCode();
        }
        if (getRfcLabora() != null) {
            _hashCode += getRfcLabora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubContratacionR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubContratacionR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentajeTiempo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorcentajeTiempo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcLabora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcLabora"));
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
