/**
 * OtrosCargosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class OtrosCargosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR[] listaCargos;

    private java.math.BigDecimal totalCargos;

    public OtrosCargosR() {
    }

    public OtrosCargosR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR[] listaCargos,
           java.math.BigDecimal totalCargos) {
           this.listaCargos = listaCargos;
           this.totalCargos = totalCargos;
    }


    /**
     * Gets the listaCargos value for this OtrosCargosR.
     * 
     * @return listaCargos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR[] getListaCargos() {
        return listaCargos;
    }


    /**
     * Sets the listaCargos value for this OtrosCargosR.
     * 
     * @param listaCargos
     */
    public void setListaCargos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CargoR[] listaCargos) {
        this.listaCargos = listaCargos;
    }


    /**
     * Gets the totalCargos value for this OtrosCargosR.
     * 
     * @return totalCargos
     */
    public java.math.BigDecimal getTotalCargos() {
        return totalCargos;
    }


    /**
     * Sets the totalCargos value for this OtrosCargosR.
     * 
     * @param totalCargos
     */
    public void setTotalCargos(java.math.BigDecimal totalCargos) {
        this.totalCargos = totalCargos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OtrosCargosR)) return false;
        OtrosCargosR other = (OtrosCargosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaCargos==null && other.getListaCargos()==null) || 
             (this.listaCargos!=null &&
              java.util.Arrays.equals(this.listaCargos, other.getListaCargos()))) &&
            ((this.totalCargos==null && other.getTotalCargos()==null) || 
             (this.totalCargos!=null &&
              this.totalCargos.equals(other.getTotalCargos())));
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
        if (getListaCargos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaCargos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaCargos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotalCargos() != null) {
            _hashCode += getTotalCargos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OtrosCargosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosCargosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaCargos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaCargos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CargoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CargoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCargos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalCargos"));
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
