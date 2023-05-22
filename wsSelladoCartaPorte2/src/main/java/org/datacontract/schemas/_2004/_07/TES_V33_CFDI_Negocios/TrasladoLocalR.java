/**
 * TrasladoLocalR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class TrasladoLocalR  implements java.io.Serializable {
    private java.lang.String impLocTrasladado;

    private java.math.BigDecimal importe;

    private java.lang.String nombreImpuesto;

    private java.math.BigDecimal tasadeTraslado;

    public TrasladoLocalR() {
    }

    public TrasladoLocalR(
           java.lang.String impLocTrasladado,
           java.math.BigDecimal importe,
           java.lang.String nombreImpuesto,
           java.math.BigDecimal tasadeTraslado) {
           this.impLocTrasladado = impLocTrasladado;
           this.importe = importe;
           this.nombreImpuesto = nombreImpuesto;
           this.tasadeTraslado = tasadeTraslado;
    }


    /**
     * Gets the impLocTrasladado value for this TrasladoLocalR.
     * 
     * @return impLocTrasladado
     */
    public java.lang.String getImpLocTrasladado() {
        return impLocTrasladado;
    }


    /**
     * Sets the impLocTrasladado value for this TrasladoLocalR.
     * 
     * @param impLocTrasladado
     */
    public void setImpLocTrasladado(java.lang.String impLocTrasladado) {
        this.impLocTrasladado = impLocTrasladado;
    }


    /**
     * Gets the importe value for this TrasladoLocalR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this TrasladoLocalR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the nombreImpuesto value for this TrasladoLocalR.
     * 
     * @return nombreImpuesto
     */
    public java.lang.String getNombreImpuesto() {
        return nombreImpuesto;
    }


    /**
     * Sets the nombreImpuesto value for this TrasladoLocalR.
     * 
     * @param nombreImpuesto
     */
    public void setNombreImpuesto(java.lang.String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }


    /**
     * Gets the tasadeTraslado value for this TrasladoLocalR.
     * 
     * @return tasadeTraslado
     */
    public java.math.BigDecimal getTasadeTraslado() {
        return tasadeTraslado;
    }


    /**
     * Sets the tasadeTraslado value for this TrasladoLocalR.
     * 
     * @param tasadeTraslado
     */
    public void setTasadeTraslado(java.math.BigDecimal tasadeTraslado) {
        this.tasadeTraslado = tasadeTraslado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrasladoLocalR)) return false;
        TrasladoLocalR other = (TrasladoLocalR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.impLocTrasladado==null && other.getImpLocTrasladado()==null) || 
             (this.impLocTrasladado!=null &&
              this.impLocTrasladado.equals(other.getImpLocTrasladado()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.nombreImpuesto==null && other.getNombreImpuesto()==null) || 
             (this.nombreImpuesto!=null &&
              this.nombreImpuesto.equals(other.getNombreImpuesto()))) &&
            ((this.tasadeTraslado==null && other.getTasadeTraslado()==null) || 
             (this.tasadeTraslado!=null &&
              this.tasadeTraslado.equals(other.getTasadeTraslado())));
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
        if (getImpLocTrasladado() != null) {
            _hashCode += getImpLocTrasladado().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getNombreImpuesto() != null) {
            _hashCode += getNombreImpuesto().hashCode();
        }
        if (getTasadeTraslado() != null) {
            _hashCode += getTasadeTraslado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TrasladoLocalR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocalR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impLocTrasladado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpLocTrasladado"));
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
        elemField.setFieldName("nombreImpuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreImpuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasadeTraslado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasadeTraslado"));
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
