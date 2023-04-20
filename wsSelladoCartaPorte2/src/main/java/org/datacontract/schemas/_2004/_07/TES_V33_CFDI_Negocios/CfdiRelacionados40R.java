/**
 * CfdiRelacionados40R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CfdiRelacionados40R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R[] cfdiRelacionado;

    private java.lang.String tipoRelacion;

    public CfdiRelacionados40R() {
    }

    public CfdiRelacionados40R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R[] cfdiRelacionado,
           java.lang.String tipoRelacion) {
           this.cfdiRelacionado = cfdiRelacionado;
           this.tipoRelacion = tipoRelacion;
    }


    /**
     * Gets the cfdiRelacionado value for this CfdiRelacionados40R.
     * 
     * @return cfdiRelacionado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R[] getCfdiRelacionado() {
        return cfdiRelacionado;
    }


    /**
     * Sets the cfdiRelacionado value for this CfdiRelacionados40R.
     * 
     * @param cfdiRelacionado
     */
    public void setCfdiRelacionado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CfdiRelacionado40R[] cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }


    /**
     * Gets the tipoRelacion value for this CfdiRelacionados40R.
     * 
     * @return tipoRelacion
     */
    public java.lang.String getTipoRelacion() {
        return tipoRelacion;
    }


    /**
     * Sets the tipoRelacion value for this CfdiRelacionados40R.
     * 
     * @param tipoRelacion
     */
    public void setTipoRelacion(java.lang.String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CfdiRelacionados40R)) return false;
        CfdiRelacionados40R other = (CfdiRelacionados40R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cfdiRelacionado==null && other.getCfdiRelacionado()==null) || 
             (this.cfdiRelacionado!=null &&
              java.util.Arrays.equals(this.cfdiRelacionado, other.getCfdiRelacionado()))) &&
            ((this.tipoRelacion==null && other.getTipoRelacion()==null) || 
             (this.tipoRelacion!=null &&
              this.tipoRelacion.equals(other.getTipoRelacion())));
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
        if (getCfdiRelacionado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCfdiRelacionado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCfdiRelacionado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTipoRelacion() != null) {
            _hashCode += getTipoRelacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CfdiRelacionados40R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionados40R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfdiRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CfdiRelacionado40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoRelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoRelacion"));
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
