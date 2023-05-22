/**
 * DoctoRelacionadoImpuestosTrasladosDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class DoctoRelacionadoImpuestosTrasladosDR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR[] trasladoDR;

    public DoctoRelacionadoImpuestosTrasladosDR() {
    }

    public DoctoRelacionadoImpuestosTrasladosDR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR[] trasladoDR) {
           this.trasladoDR = trasladoDR;
    }


    /**
     * Gets the trasladoDR value for this DoctoRelacionadoImpuestosTrasladosDR.
     * 
     * @return trasladoDR
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR[] getTrasladoDR() {
        return trasladoDR;
    }


    /**
     * Sets the trasladoDR value for this DoctoRelacionadoImpuestosTrasladosDR.
     * 
     * @param trasladoDR
     */
    public void setTrasladoDR(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosTrasladosTrasladoDR[] trasladoDR) {
        this.trasladoDR = trasladoDR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoctoRelacionadoImpuestosTrasladosDR)) return false;
        DoctoRelacionadoImpuestosTrasladosDR other = (DoctoRelacionadoImpuestosTrasladosDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.trasladoDR==null && other.getTrasladoDR()==null) || 
             (this.trasladoDR!=null &&
              java.util.Arrays.equals(this.trasladoDR, other.getTrasladoDR())));
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
        if (getTrasladoDR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrasladoDR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrasladoDR(), i);
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
        new org.apache.axis.description.TypeDesc(DoctoRelacionadoImpuestosTrasladosDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosTrasladosDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladoDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TrasladoDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR"));
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
