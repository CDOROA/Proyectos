/**
 * PagosPagoImpuestosTrasladoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoImpuestosTrasladoR  implements java.io.Serializable {
    private java.lang.String importe;

    private java.lang.String impuesto;

    private java.lang.String tasaOCuota;

    private java.lang.String tipoFactor;

    public PagosPagoImpuestosTrasladoR() {
    }

    public PagosPagoImpuestosTrasladoR(
           java.lang.String importe,
           java.lang.String impuesto,
           java.lang.String tasaOCuota,
           java.lang.String tipoFactor) {
           this.importe = importe;
           this.impuesto = impuesto;
           this.tasaOCuota = tasaOCuota;
           this.tipoFactor = tipoFactor;
    }


    /**
     * Gets the importe value for this PagosPagoImpuestosTrasladoR.
     * 
     * @return importe
     */
    public java.lang.String getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this PagosPagoImpuestosTrasladoR.
     * 
     * @param importe
     */
    public void setImporte(java.lang.String importe) {
        this.importe = importe;
    }


    /**
     * Gets the impuesto value for this PagosPagoImpuestosTrasladoR.
     * 
     * @return impuesto
     */
    public java.lang.String getImpuesto() {
        return impuesto;
    }


    /**
     * Sets the impuesto value for this PagosPagoImpuestosTrasladoR.
     * 
     * @param impuesto
     */
    public void setImpuesto(java.lang.String impuesto) {
        this.impuesto = impuesto;
    }


    /**
     * Gets the tasaOCuota value for this PagosPagoImpuestosTrasladoR.
     * 
     * @return tasaOCuota
     */
    public java.lang.String getTasaOCuota() {
        return tasaOCuota;
    }


    /**
     * Sets the tasaOCuota value for this PagosPagoImpuestosTrasladoR.
     * 
     * @param tasaOCuota
     */
    public void setTasaOCuota(java.lang.String tasaOCuota) {
        this.tasaOCuota = tasaOCuota;
    }


    /**
     * Gets the tipoFactor value for this PagosPagoImpuestosTrasladoR.
     * 
     * @return tipoFactor
     */
    public java.lang.String getTipoFactor() {
        return tipoFactor;
    }


    /**
     * Sets the tipoFactor value for this PagosPagoImpuestosTrasladoR.
     * 
     * @param tipoFactor
     */
    public void setTipoFactor(java.lang.String tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoImpuestosTrasladoR)) return false;
        PagosPagoImpuestosTrasladoR other = (PagosPagoImpuestosTrasladoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.impuesto==null && other.getImpuesto()==null) || 
             (this.impuesto!=null &&
              this.impuesto.equals(other.getImpuesto()))) &&
            ((this.tasaOCuota==null && other.getTasaOCuota()==null) || 
             (this.tasaOCuota!=null &&
              this.tasaOCuota.equals(other.getTasaOCuota()))) &&
            ((this.tipoFactor==null && other.getTipoFactor()==null) || 
             (this.tipoFactor!=null &&
              this.tipoFactor.equals(other.getTipoFactor())));
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
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getImpuesto() != null) {
            _hashCode += getImpuesto().hashCode();
        }
        if (getTasaOCuota() != null) {
            _hashCode += getTasaOCuota().hashCode();
        }
        if (getTipoFactor() != null) {
            _hashCode += getTipoFactor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosTrasladoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Impuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaOCuota");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasaOCuota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFactor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoFactor"));
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
