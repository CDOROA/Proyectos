/**
 * OtroPagoNomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class OtroPagoNomina12R  implements java.io.Serializable {
    private java.lang.String clave;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR compensacionSaldosAFavorR;

    private java.lang.String concepto;

    private java.math.BigDecimal importe;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR subsidioAlEmpleoR;

    private java.lang.String tipoOtroPago;

    public OtroPagoNomina12R() {
    }

    public OtroPagoNomina12R(
           java.lang.String clave,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR compensacionSaldosAFavorR,
           java.lang.String concepto,
           java.math.BigDecimal importe,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR subsidioAlEmpleoR,
           java.lang.String tipoOtroPago) {
           this.clave = clave;
           this.compensacionSaldosAFavorR = compensacionSaldosAFavorR;
           this.concepto = concepto;
           this.importe = importe;
           this.subsidioAlEmpleoR = subsidioAlEmpleoR;
           this.tipoOtroPago = tipoOtroPago;
    }


    /**
     * Gets the clave value for this OtroPagoNomina12R.
     * 
     * @return clave
     */
    public java.lang.String getClave() {
        return clave;
    }


    /**
     * Sets the clave value for this OtroPagoNomina12R.
     * 
     * @param clave
     */
    public void setClave(java.lang.String clave) {
        this.clave = clave;
    }


    /**
     * Gets the compensacionSaldosAFavorR value for this OtroPagoNomina12R.
     * 
     * @return compensacionSaldosAFavorR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR getCompensacionSaldosAFavorR() {
        return compensacionSaldosAFavorR;
    }


    /**
     * Sets the compensacionSaldosAFavorR value for this OtroPagoNomina12R.
     * 
     * @param compensacionSaldosAFavorR
     */
    public void setCompensacionSaldosAFavorR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CompensacionSaldosAFavorR compensacionSaldosAFavorR) {
        this.compensacionSaldosAFavorR = compensacionSaldosAFavorR;
    }


    /**
     * Gets the concepto value for this OtroPagoNomina12R.
     * 
     * @return concepto
     */
    public java.lang.String getConcepto() {
        return concepto;
    }


    /**
     * Sets the concepto value for this OtroPagoNomina12R.
     * 
     * @param concepto
     */
    public void setConcepto(java.lang.String concepto) {
        this.concepto = concepto;
    }


    /**
     * Gets the importe value for this OtroPagoNomina12R.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this OtroPagoNomina12R.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the subsidioAlEmpleoR value for this OtroPagoNomina12R.
     * 
     * @return subsidioAlEmpleoR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR getSubsidioAlEmpleoR() {
        return subsidioAlEmpleoR;
    }


    /**
     * Sets the subsidioAlEmpleoR value for this OtroPagoNomina12R.
     * 
     * @param subsidioAlEmpleoR
     */
    public void setSubsidioAlEmpleoR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubsidioAlEmpleoR subsidioAlEmpleoR) {
        this.subsidioAlEmpleoR = subsidioAlEmpleoR;
    }


    /**
     * Gets the tipoOtroPago value for this OtroPagoNomina12R.
     * 
     * @return tipoOtroPago
     */
    public java.lang.String getTipoOtroPago() {
        return tipoOtroPago;
    }


    /**
     * Sets the tipoOtroPago value for this OtroPagoNomina12R.
     * 
     * @param tipoOtroPago
     */
    public void setTipoOtroPago(java.lang.String tipoOtroPago) {
        this.tipoOtroPago = tipoOtroPago;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OtroPagoNomina12R)) return false;
        OtroPagoNomina12R other = (OtroPagoNomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clave==null && other.getClave()==null) || 
             (this.clave!=null &&
              this.clave.equals(other.getClave()))) &&
            ((this.compensacionSaldosAFavorR==null && other.getCompensacionSaldosAFavorR()==null) || 
             (this.compensacionSaldosAFavorR!=null &&
              this.compensacionSaldosAFavorR.equals(other.getCompensacionSaldosAFavorR()))) &&
            ((this.concepto==null && other.getConcepto()==null) || 
             (this.concepto!=null &&
              this.concepto.equals(other.getConcepto()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.subsidioAlEmpleoR==null && other.getSubsidioAlEmpleoR()==null) || 
             (this.subsidioAlEmpleoR!=null &&
              this.subsidioAlEmpleoR.equals(other.getSubsidioAlEmpleoR()))) &&
            ((this.tipoOtroPago==null && other.getTipoOtroPago()==null) || 
             (this.tipoOtroPago!=null &&
              this.tipoOtroPago.equals(other.getTipoOtroPago())));
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
        if (getClave() != null) {
            _hashCode += getClave().hashCode();
        }
        if (getCompensacionSaldosAFavorR() != null) {
            _hashCode += getCompensacionSaldosAFavorR().hashCode();
        }
        if (getConcepto() != null) {
            _hashCode += getConcepto().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getSubsidioAlEmpleoR() != null) {
            _hashCode += getSubsidioAlEmpleoR().hashCode();
        }
        if (getTipoOtroPago() != null) {
            _hashCode += getTipoOtroPago().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OtroPagoNomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Clave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compensacionSaldosAFavorR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CompensacionSaldosAFavorR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CompensacionSaldosAFavorR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concepto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsidioAlEmpleoR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubsidioAlEmpleoR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubsidioAlEmpleoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOtroPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoOtroPago"));
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
