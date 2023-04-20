/**
 * EntidadSNCFR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class EntidadSNCFR  implements java.io.Serializable {
    private java.math.BigDecimal montoRecursoPropio;

    private java.lang.String origenRecurso;

    public EntidadSNCFR() {
    }

    public EntidadSNCFR(
           java.math.BigDecimal montoRecursoPropio,
           java.lang.String origenRecurso) {
           this.montoRecursoPropio = montoRecursoPropio;
           this.origenRecurso = origenRecurso;
    }


    /**
     * Gets the montoRecursoPropio value for this EntidadSNCFR.
     * 
     * @return montoRecursoPropio
     */
    public java.math.BigDecimal getMontoRecursoPropio() {
        return montoRecursoPropio;
    }


    /**
     * Sets the montoRecursoPropio value for this EntidadSNCFR.
     * 
     * @param montoRecursoPropio
     */
    public void setMontoRecursoPropio(java.math.BigDecimal montoRecursoPropio) {
        this.montoRecursoPropio = montoRecursoPropio;
    }


    /**
     * Gets the origenRecurso value for this EntidadSNCFR.
     * 
     * @return origenRecurso
     */
    public java.lang.String getOrigenRecurso() {
        return origenRecurso;
    }


    /**
     * Sets the origenRecurso value for this EntidadSNCFR.
     * 
     * @param origenRecurso
     */
    public void setOrigenRecurso(java.lang.String origenRecurso) {
        this.origenRecurso = origenRecurso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntidadSNCFR)) return false;
        EntidadSNCFR other = (EntidadSNCFR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.montoRecursoPropio==null && other.getMontoRecursoPropio()==null) || 
             (this.montoRecursoPropio!=null &&
              this.montoRecursoPropio.equals(other.getMontoRecursoPropio()))) &&
            ((this.origenRecurso==null && other.getOrigenRecurso()==null) || 
             (this.origenRecurso!=null &&
              this.origenRecurso.equals(other.getOrigenRecurso())));
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
        if (getMontoRecursoPropio() != null) {
            _hashCode += getMontoRecursoPropio().hashCode();
        }
        if (getOrigenRecurso() != null) {
            _hashCode += getOrigenRecurso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntidadSNCFR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadSNCFR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoRecursoPropio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoRecursoPropio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origenRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OrigenRecurso"));
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
