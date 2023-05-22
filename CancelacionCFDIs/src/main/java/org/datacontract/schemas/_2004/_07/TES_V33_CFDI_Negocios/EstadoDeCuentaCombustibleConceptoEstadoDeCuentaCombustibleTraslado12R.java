/**
 * EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R  implements java.io.Serializable {
    private java.math.BigDecimal importe;

    private java.lang.String impuesto;

    private java.math.BigDecimal tasaoCuota;

    public EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R() {
    }

    public EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R(
           java.math.BigDecimal importe,
           java.lang.String impuesto,
           java.math.BigDecimal tasaoCuota) {
           this.importe = importe;
           this.impuesto = impuesto;
           this.tasaoCuota = tasaoCuota;
    }


    /**
     * Gets the importe value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the impuesto value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @return impuesto
     */
    public java.lang.String getImpuesto() {
        return impuesto;
    }


    /**
     * Sets the impuesto value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @param impuesto
     */
    public void setImpuesto(java.lang.String impuesto) {
        this.impuesto = impuesto;
    }


    /**
     * Gets the tasaoCuota value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @return tasaoCuota
     */
    public java.math.BigDecimal getTasaoCuota() {
        return tasaoCuota;
    }


    /**
     * Sets the tasaoCuota value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.
     * 
     * @param tasaoCuota
     */
    public void setTasaoCuota(java.math.BigDecimal tasaoCuota) {
        this.tasaoCuota = tasaoCuota;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R)) return false;
        EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R other = (EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R) obj;
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
            ((this.tasaoCuota==null && other.getTasaoCuota()==null) || 
             (this.tasaoCuota!=null &&
              this.tasaoCuota.equals(other.getTasaoCuota())));
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
        if (getTasaoCuota() != null) {
            _hashCode += getTasaoCuota().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Impuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaoCuota");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasaoCuota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
