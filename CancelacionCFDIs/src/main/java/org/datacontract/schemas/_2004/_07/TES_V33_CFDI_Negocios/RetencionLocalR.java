/**
 * RetencionLocalR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RetencionLocalR  implements java.io.Serializable {
    private java.lang.String impLocRetenido;

    private java.math.BigDecimal importe;

    private java.lang.String nombreImpuesto;

    private java.math.BigDecimal tasadeRetencion;

    public RetencionLocalR() {
    }

    public RetencionLocalR(
           java.lang.String impLocRetenido,
           java.math.BigDecimal importe,
           java.lang.String nombreImpuesto,
           java.math.BigDecimal tasadeRetencion) {
           this.impLocRetenido = impLocRetenido;
           this.importe = importe;
           this.nombreImpuesto = nombreImpuesto;
           this.tasadeRetencion = tasadeRetencion;
    }


    /**
     * Gets the impLocRetenido value for this RetencionLocalR.
     * 
     * @return impLocRetenido
     */
    public java.lang.String getImpLocRetenido() {
        return impLocRetenido;
    }


    /**
     * Sets the impLocRetenido value for this RetencionLocalR.
     * 
     * @param impLocRetenido
     */
    public void setImpLocRetenido(java.lang.String impLocRetenido) {
        this.impLocRetenido = impLocRetenido;
    }


    /**
     * Gets the importe value for this RetencionLocalR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this RetencionLocalR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the nombreImpuesto value for this RetencionLocalR.
     * 
     * @return nombreImpuesto
     */
    public java.lang.String getNombreImpuesto() {
        return nombreImpuesto;
    }


    /**
     * Sets the nombreImpuesto value for this RetencionLocalR.
     * 
     * @param nombreImpuesto
     */
    public void setNombreImpuesto(java.lang.String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }


    /**
     * Gets the tasadeRetencion value for this RetencionLocalR.
     * 
     * @return tasadeRetencion
     */
    public java.math.BigDecimal getTasadeRetencion() {
        return tasadeRetencion;
    }


    /**
     * Sets the tasadeRetencion value for this RetencionLocalR.
     * 
     * @param tasadeRetencion
     */
    public void setTasadeRetencion(java.math.BigDecimal tasadeRetencion) {
        this.tasadeRetencion = tasadeRetencion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetencionLocalR)) return false;
        RetencionLocalR other = (RetencionLocalR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.impLocRetenido==null && other.getImpLocRetenido()==null) || 
             (this.impLocRetenido!=null &&
              this.impLocRetenido.equals(other.getImpLocRetenido()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.nombreImpuesto==null && other.getNombreImpuesto()==null) || 
             (this.nombreImpuesto!=null &&
              this.nombreImpuesto.equals(other.getNombreImpuesto()))) &&
            ((this.tasadeRetencion==null && other.getTasadeRetencion()==null) || 
             (this.tasadeRetencion!=null &&
              this.tasadeRetencion.equals(other.getTasadeRetencion())));
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
        if (getImpLocRetenido() != null) {
            _hashCode += getImpLocRetenido().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getNombreImpuesto() != null) {
            _hashCode += getNombreImpuesto().hashCode();
        }
        if (getTasadeRetencion() != null) {
            _hashCode += getTasadeRetencion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetencionLocalR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocalR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impLocRetenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpLocRetenido"));
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
        elemField.setFieldName("tasadeRetencion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasadeRetencion"));
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
