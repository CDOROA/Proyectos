/**
 * SubsidioAlEmpleoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class SubsidioAlEmpleoR  implements java.io.Serializable {
    private java.math.BigDecimal subsidioCausado;

    public SubsidioAlEmpleoR() {
    }

    public SubsidioAlEmpleoR(
           java.math.BigDecimal subsidioCausado) {
           this.subsidioCausado = subsidioCausado;
    }


    /**
     * Gets the subsidioCausado value for this SubsidioAlEmpleoR.
     * 
     * @return subsidioCausado
     */
    public java.math.BigDecimal getSubsidioCausado() {
        return subsidioCausado;
    }


    /**
     * Sets the subsidioCausado value for this SubsidioAlEmpleoR.
     * 
     * @param subsidioCausado
     */
    public void setSubsidioCausado(java.math.BigDecimal subsidioCausado) {
        this.subsidioCausado = subsidioCausado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubsidioAlEmpleoR)) return false;
        SubsidioAlEmpleoR other = (SubsidioAlEmpleoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subsidioCausado==null && other.getSubsidioCausado()==null) || 
             (this.subsidioCausado!=null &&
              this.subsidioCausado.equals(other.getSubsidioCausado())));
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
        if (getSubsidioCausado() != null) {
            _hashCode += getSubsidioCausado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubsidioAlEmpleoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubsidioAlEmpleoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsidioCausado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubsidioCausado"));
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
