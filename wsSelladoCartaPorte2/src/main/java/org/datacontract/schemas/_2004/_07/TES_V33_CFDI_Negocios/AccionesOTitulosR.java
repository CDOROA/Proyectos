/**
 * AccionesOTitulosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class AccionesOTitulosR  implements java.io.Serializable {
    private java.math.BigDecimal precioAlOtorgarse;

    private java.math.BigDecimal valorMercado;

    public AccionesOTitulosR() {
    }

    public AccionesOTitulosR(
           java.math.BigDecimal precioAlOtorgarse,
           java.math.BigDecimal valorMercado) {
           this.precioAlOtorgarse = precioAlOtorgarse;
           this.valorMercado = valorMercado;
    }


    /**
     * Gets the precioAlOtorgarse value for this AccionesOTitulosR.
     * 
     * @return precioAlOtorgarse
     */
    public java.math.BigDecimal getPrecioAlOtorgarse() {
        return precioAlOtorgarse;
    }


    /**
     * Sets the precioAlOtorgarse value for this AccionesOTitulosR.
     * 
     * @param precioAlOtorgarse
     */
    public void setPrecioAlOtorgarse(java.math.BigDecimal precioAlOtorgarse) {
        this.precioAlOtorgarse = precioAlOtorgarse;
    }


    /**
     * Gets the valorMercado value for this AccionesOTitulosR.
     * 
     * @return valorMercado
     */
    public java.math.BigDecimal getValorMercado() {
        return valorMercado;
    }


    /**
     * Sets the valorMercado value for this AccionesOTitulosR.
     * 
     * @param valorMercado
     */
    public void setValorMercado(java.math.BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccionesOTitulosR)) return false;
        AccionesOTitulosR other = (AccionesOTitulosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.precioAlOtorgarse==null && other.getPrecioAlOtorgarse()==null) || 
             (this.precioAlOtorgarse!=null &&
              this.precioAlOtorgarse.equals(other.getPrecioAlOtorgarse()))) &&
            ((this.valorMercado==null && other.getValorMercado()==null) || 
             (this.valorMercado!=null &&
              this.valorMercado.equals(other.getValorMercado())));
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
        if (getPrecioAlOtorgarse() != null) {
            _hashCode += getPrecioAlOtorgarse().hashCode();
        }
        if (getValorMercado() != null) {
            _hashCode += getValorMercado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccionesOTitulosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AccionesOTitulosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precioAlOtorgarse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PrecioAlOtorgarse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorMercado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorMercado"));
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
