/**
 * YacimientosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class YacimientosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR[] pozos;

    private java.lang.String yacimiento;

    public YacimientosR() {
    }

    public YacimientosR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR[] pozos,
           java.lang.String yacimiento) {
           this.pozos = pozos;
           this.yacimiento = yacimiento;
    }


    /**
     * Gets the pozos value for this YacimientosR.
     * 
     * @return pozos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR[] getPozos() {
        return pozos;
    }


    /**
     * Sets the pozos value for this YacimientosR.
     * 
     * @param pozos
     */
    public void setPozos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PozosR[] pozos) {
        this.pozos = pozos;
    }


    /**
     * Gets the yacimiento value for this YacimientosR.
     * 
     * @return yacimiento
     */
    public java.lang.String getYacimiento() {
        return yacimiento;
    }


    /**
     * Sets the yacimiento value for this YacimientosR.
     * 
     * @param yacimiento
     */
    public void setYacimiento(java.lang.String yacimiento) {
        this.yacimiento = yacimiento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof YacimientosR)) return false;
        YacimientosR other = (YacimientosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pozos==null && other.getPozos()==null) || 
             (this.pozos!=null &&
              java.util.Arrays.equals(this.pozos, other.getPozos()))) &&
            ((this.yacimiento==null && other.getYacimiento()==null) || 
             (this.yacimiento!=null &&
              this.yacimiento.equals(other.getYacimiento())));
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
        if (getPozos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPozos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPozos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getYacimiento() != null) {
            _hashCode += getYacimiento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(YacimientosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "YacimientosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pozos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pozos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PozosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PozosR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yacimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Yacimiento"));
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
