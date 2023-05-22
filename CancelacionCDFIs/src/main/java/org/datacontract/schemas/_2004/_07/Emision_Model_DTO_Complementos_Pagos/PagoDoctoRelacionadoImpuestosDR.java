/**
 * PagoDoctoRelacionadoImpuestosDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class PagoDoctoRelacionadoImpuestosDR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosRetencionesDR retencionesDR;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosTrasladosDR trasladosDR;

    public PagoDoctoRelacionadoImpuestosDR() {
    }

    public PagoDoctoRelacionadoImpuestosDR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosRetencionesDR retencionesDR,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosTrasladosDR trasladosDR) {
           this.retencionesDR = retencionesDR;
           this.trasladosDR = trasladosDR;
    }


    /**
     * Gets the retencionesDR value for this PagoDoctoRelacionadoImpuestosDR.
     * 
     * @return retencionesDR
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosRetencionesDR getRetencionesDR() {
        return retencionesDR;
    }


    /**
     * Sets the retencionesDR value for this PagoDoctoRelacionadoImpuestosDR.
     * 
     * @param retencionesDR
     */
    public void setRetencionesDR(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosRetencionesDR retencionesDR) {
        this.retencionesDR = retencionesDR;
    }


    /**
     * Gets the trasladosDR value for this PagoDoctoRelacionadoImpuestosDR.
     * 
     * @return trasladosDR
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosTrasladosDR getTrasladosDR() {
        return trasladosDR;
    }


    /**
     * Sets the trasladosDR value for this PagoDoctoRelacionadoImpuestosDR.
     * 
     * @param trasladosDR
     */
    public void setTrasladosDR(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.DoctoRelacionadoImpuestosTrasladosDR trasladosDR) {
        this.trasladosDR = trasladosDR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagoDoctoRelacionadoImpuestosDR)) return false;
        PagoDoctoRelacionadoImpuestosDR other = (PagoDoctoRelacionadoImpuestosDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retencionesDR==null && other.getRetencionesDR()==null) || 
             (this.retencionesDR!=null &&
              this.retencionesDR.equals(other.getRetencionesDR()))) &&
            ((this.trasladosDR==null && other.getTrasladosDR()==null) || 
             (this.trasladosDR!=null &&
              this.trasladosDR.equals(other.getTrasladosDR())));
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
        if (getRetencionesDR() != null) {
            _hashCode += getRetencionesDR().hashCode();
        }
        if (getTrasladosDR() != null) {
            _hashCode += getTrasladosDR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagoDoctoRelacionadoImpuestosDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoDoctoRelacionadoImpuestosDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "RetencionesDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosRetencionesDR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TrasladosDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionadoImpuestosTrasladosDR"));
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
