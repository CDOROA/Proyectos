/**
 * PagoImpuestosRetencionP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class PagoImpuestosRetencionP  implements java.io.Serializable {
    private java.math.BigDecimal importeP;

    private java.lang.String impuestoP;

    public PagoImpuestosRetencionP() {
    }

    public PagoImpuestosRetencionP(
           java.math.BigDecimal importeP,
           java.lang.String impuestoP) {
           this.importeP = importeP;
           this.impuestoP = impuestoP;
    }


    /**
     * Gets the importeP value for this PagoImpuestosRetencionP.
     * 
     * @return importeP
     */
    public java.math.BigDecimal getImporteP() {
        return importeP;
    }


    /**
     * Sets the importeP value for this PagoImpuestosRetencionP.
     * 
     * @param importeP
     */
    public void setImporteP(java.math.BigDecimal importeP) {
        this.importeP = importeP;
    }


    /**
     * Gets the impuestoP value for this PagoImpuestosRetencionP.
     * 
     * @return impuestoP
     */
    public java.lang.String getImpuestoP() {
        return impuestoP;
    }


    /**
     * Sets the impuestoP value for this PagoImpuestosRetencionP.
     * 
     * @param impuestoP
     */
    public void setImpuestoP(java.lang.String impuestoP) {
        this.impuestoP = impuestoP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagoImpuestosRetencionP)) return false;
        PagoImpuestosRetencionP other = (PagoImpuestosRetencionP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.importeP==null && other.getImporteP()==null) || 
             (this.importeP!=null &&
              this.importeP.equals(other.getImporteP()))) &&
            ((this.impuestoP==null && other.getImpuestoP()==null) || 
             (this.impuestoP!=null &&
              this.impuestoP.equals(other.getImpuestoP())));
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
        if (getImporteP() != null) {
            _hashCode += getImporteP().hashCode();
        }
        if (getImpuestoP() != null) {
            _hashCode += getImpuestoP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagoImpuestosRetencionP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosRetencionP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImporteP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestoP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestoP"));
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
