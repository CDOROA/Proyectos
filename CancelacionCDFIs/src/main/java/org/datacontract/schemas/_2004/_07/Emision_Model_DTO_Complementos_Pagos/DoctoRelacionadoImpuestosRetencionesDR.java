/**
 * DoctoRelacionadoImpuestosRetencionesDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class DoctoRelacionadoImpuestosRetencionesDR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR[] retencionDR;

    public DoctoRelacionadoImpuestosRetencionesDR() {
    }

    public DoctoRelacionadoImpuestosRetencionesDR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR[] retencionDR) {
           this.retencionDR = retencionDR;
    }


    /**
     * Gets the retencionDR value for this DoctoRelacionadoImpuestosRetencionesDR.
     * 
     * @return retencionDR
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR[] getRetencionDR() {
        return retencionDR;
    }


    /**
     * Sets the retencionDR value for this DoctoRelacionadoImpuestosRetencionesDR.
     * 
     * @param retencionDR
     */
    public void setRetencionDR(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.ImpuestosRetencionesRetencionDR[] retencionDR) {
        this.retencionDR = retencionDR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DoctoRelacionadoImpuestosRetencionesDR)) return false;
        DoctoRelacionadoImpuestosRetencionesDR other = (DoctoRelacionadoImpuestosRetencionesDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retencionDR==null && other.getRetencionDR()==null) || 
             (this.retencionDR!=null &&
              java.util.Arrays.equals(this.retencionDR, other.getRetencionDR())));
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
        if (getRetencionDR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetencionDR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetencionDR(), i);
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
        new org.apache.axis.description.TypeDesc(DoctoRelacionadoImpuestosRetencionesDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosRetencionesDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "RetencionDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosRetencionesRetencionDR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosRetencionesRetencionDR"));
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
