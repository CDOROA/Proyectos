/**
 * CartaPorteMercanciasAutotransporteRemolque20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasAutotransporteRemolque20R  implements java.io.Serializable {
    private java.lang.String placa;

    private java.lang.String subTipoRem;

    public CartaPorteMercanciasAutotransporteRemolque20R() {
    }

    public CartaPorteMercanciasAutotransporteRemolque20R(
           java.lang.String placa,
           java.lang.String subTipoRem) {
           this.placa = placa;
           this.subTipoRem = subTipoRem;
    }


    /**
     * Gets the placa value for this CartaPorteMercanciasAutotransporteRemolque20R.
     * 
     * @return placa
     */
    public java.lang.String getPlaca() {
        return placa;
    }


    /**
     * Sets the placa value for this CartaPorteMercanciasAutotransporteRemolque20R.
     * 
     * @param placa
     */
    public void setPlaca(java.lang.String placa) {
        this.placa = placa;
    }


    /**
     * Gets the subTipoRem value for this CartaPorteMercanciasAutotransporteRemolque20R.
     * 
     * @return subTipoRem
     */
    public java.lang.String getSubTipoRem() {
        return subTipoRem;
    }


    /**
     * Sets the subTipoRem value for this CartaPorteMercanciasAutotransporteRemolque20R.
     * 
     * @param subTipoRem
     */
    public void setSubTipoRem(java.lang.String subTipoRem) {
        this.subTipoRem = subTipoRem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasAutotransporteRemolque20R)) return false;
        CartaPorteMercanciasAutotransporteRemolque20R other = (CartaPorteMercanciasAutotransporteRemolque20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.placa==null && other.getPlaca()==null) || 
             (this.placa!=null &&
              this.placa.equals(other.getPlaca()))) &&
            ((this.subTipoRem==null && other.getSubTipoRem()==null) || 
             (this.subTipoRem!=null &&
              this.subTipoRem.equals(other.getSubTipoRem())));
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
        if (getPlaca() != null) {
            _hashCode += getPlaca().hashCode();
        }
        if (getSubTipoRem() != null) {
            _hashCode += getSubTipoRem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasAutotransporteRemolque20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Placa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subTipoRem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubTipoRem"));
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
