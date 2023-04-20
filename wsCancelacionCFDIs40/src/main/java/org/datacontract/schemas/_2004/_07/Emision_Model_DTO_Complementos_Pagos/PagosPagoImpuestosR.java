/**
 * PagosPagoImpuestosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class PagosPagoImpuestosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosRetencionR retencionesP;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosTrasladoR trasladosP;

    public PagosPagoImpuestosR() {
    }

    public PagosPagoImpuestosR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosRetencionR retencionesP,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosTrasladoR trasladosP) {
           this.retencionesP = retencionesP;
           this.trasladosP = trasladosP;
    }


    /**
     * Gets the retencionesP value for this PagosPagoImpuestosR.
     * 
     * @return retencionesP
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosRetencionR getRetencionesP() {
        return retencionesP;
    }


    /**
     * Sets the retencionesP value for this PagosPagoImpuestosR.
     * 
     * @param retencionesP
     */
    public void setRetencionesP(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosRetencionR retencionesP) {
        this.retencionesP = retencionesP;
    }


    /**
     * Gets the trasladosP value for this PagosPagoImpuestosR.
     * 
     * @return trasladosP
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosTrasladoR getTrasladosP() {
        return trasladosP;
    }


    /**
     * Sets the trasladosP value for this PagosPagoImpuestosR.
     * 
     * @param trasladosP
     */
    public void setTrasladosP(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosTrasladoR trasladosP) {
        this.trasladosP = trasladosP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoImpuestosR)) return false;
        PagosPagoImpuestosR other = (PagosPagoImpuestosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retencionesP==null && other.getRetencionesP()==null) || 
             (this.retencionesP!=null &&
              this.retencionesP.equals(other.getRetencionesP()))) &&
            ((this.trasladosP==null && other.getTrasladosP()==null) || 
             (this.trasladosP!=null &&
              this.trasladosP.equals(other.getTrasladosP())));
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
        if (getRetencionesP() != null) {
            _hashCode += getRetencionesP().hashCode();
        }
        if (getTrasladosP() != null) {
            _hashCode += getTrasladosP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "RetencionesP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosRetencionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TrasladosP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosTrasladoR"));
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
