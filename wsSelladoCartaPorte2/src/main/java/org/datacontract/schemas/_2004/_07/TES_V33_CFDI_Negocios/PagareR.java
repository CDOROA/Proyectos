/**
 * PagareR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagareR  implements java.io.Serializable {
    private java.util.Calendar fechaPago;

    private java.math.BigDecimal tasaInteres;

    public PagareR() {
    }

    public PagareR(
           java.util.Calendar fechaPago,
           java.math.BigDecimal tasaInteres) {
           this.fechaPago = fechaPago;
           this.tasaInteres = tasaInteres;
    }


    /**
     * Gets the fechaPago value for this PagareR.
     * 
     * @return fechaPago
     */
    public java.util.Calendar getFechaPago() {
        return fechaPago;
    }


    /**
     * Sets the fechaPago value for this PagareR.
     * 
     * @param fechaPago
     */
    public void setFechaPago(java.util.Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }


    /**
     * Gets the tasaInteres value for this PagareR.
     * 
     * @return tasaInteres
     */
    public java.math.BigDecimal getTasaInteres() {
        return tasaInteres;
    }


    /**
     * Sets the tasaInteres value for this PagareR.
     * 
     * @param tasaInteres
     */
    public void setTasaInteres(java.math.BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagareR)) return false;
        PagareR other = (PagareR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaPago==null && other.getFechaPago()==null) || 
             (this.fechaPago!=null &&
              this.fechaPago.equals(other.getFechaPago()))) &&
            ((this.tasaInteres==null && other.getTasaInteres()==null) || 
             (this.tasaInteres!=null &&
              this.tasaInteres.equals(other.getTasaInteres())));
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
        if (getFechaPago() != null) {
            _hashCode += getFechaPago().hashCode();
        }
        if (getTasaInteres() != null) {
            _hashCode += getTasaInteres().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagareR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagareR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaInteres");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasaInteres"));
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
