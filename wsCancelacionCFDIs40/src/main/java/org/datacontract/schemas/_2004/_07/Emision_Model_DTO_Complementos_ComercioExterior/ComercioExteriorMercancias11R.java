/**
 * ComercioExteriorMercancias11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior;

public class ComercioExteriorMercancias11R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R[] mercancia;

    public ComercioExteriorMercancias11R() {
    }

    public ComercioExteriorMercancias11R(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R[] mercancia) {
           this.mercancia = mercancia;
    }


    /**
     * Gets the mercancia value for this ComercioExteriorMercancias11R.
     * 
     * @return mercancia
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R[] getMercancia() {
        return mercancia;
    }


    /**
     * Sets the mercancia value for this ComercioExteriorMercancias11R.
     * 
     * @param mercancia
     */
    public void setMercancia(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExteriorMercancia11R[] mercancia) {
        this.mercancia = mercancia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExteriorMercancias11R)) return false;
        ComercioExteriorMercancias11R other = (ComercioExteriorMercancias11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mercancia==null && other.getMercancia()==null) || 
             (this.mercancia!=null &&
              java.util.Arrays.equals(this.mercancia, other.getMercancia())));
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
        if (getMercancia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMercancia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMercancia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExteriorMercancias11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancias11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mercancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "Mercancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancia11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExteriorMercancia11R"));
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
