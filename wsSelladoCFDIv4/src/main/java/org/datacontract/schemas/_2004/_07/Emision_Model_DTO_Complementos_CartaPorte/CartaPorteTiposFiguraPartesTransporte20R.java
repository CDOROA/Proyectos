/**
 * CartaPorteTiposFiguraPartesTransporte20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteTiposFiguraPartesTransporte20R  implements java.io.Serializable {
    private java.lang.String parteTransporte;

    public CartaPorteTiposFiguraPartesTransporte20R() {
    }

    public CartaPorteTiposFiguraPartesTransporte20R(
           java.lang.String parteTransporte) {
           this.parteTransporte = parteTransporte;
    }


    /**
     * Gets the parteTransporte value for this CartaPorteTiposFiguraPartesTransporte20R.
     * 
     * @return parteTransporte
     */
    public java.lang.String getParteTransporte() {
        return parteTransporte;
    }


    /**
     * Sets the parteTransporte value for this CartaPorteTiposFiguraPartesTransporte20R.
     * 
     * @param parteTransporte
     */
    public void setParteTransporte(java.lang.String parteTransporte) {
        this.parteTransporte = parteTransporte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteTiposFiguraPartesTransporte20R)) return false;
        CartaPorteTiposFiguraPartesTransporte20R other = (CartaPorteTiposFiguraPartesTransporte20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parteTransporte==null && other.getParteTransporte()==null) || 
             (this.parteTransporte!=null &&
              this.parteTransporte.equals(other.getParteTransporte())));
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
        if (getParteTransporte() != null) {
            _hashCode += getParteTransporte().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteTiposFiguraPartesTransporte20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parteTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ParteTransporte"));
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
