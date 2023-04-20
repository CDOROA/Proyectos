/**
 * PagosPagoImpuestosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoImpuestosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR[] retenciones;

    private java.math.BigDecimal totalImpuestosRetenidos;

    private java.math.BigDecimal totalImpuestosTrasladados;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR[] traslados;

    public PagosPagoImpuestosR() {
    }

    public PagosPagoImpuestosR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR[] retenciones,
           java.math.BigDecimal totalImpuestosRetenidos,
           java.math.BigDecimal totalImpuestosTrasladados,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR[] traslados) {
           this.retenciones = retenciones;
           this.totalImpuestosRetenidos = totalImpuestosRetenidos;
           this.totalImpuestosTrasladados = totalImpuestosTrasladados;
           this.traslados = traslados;
    }


    /**
     * Gets the retenciones value for this PagosPagoImpuestosR.
     * 
     * @return retenciones
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR[] getRetenciones() {
        return retenciones;
    }


    /**
     * Sets the retenciones value for this PagosPagoImpuestosR.
     * 
     * @param retenciones
     */
    public void setRetenciones(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosRetencionR[] retenciones) {
        this.retenciones = retenciones;
    }


    /**
     * Gets the totalImpuestosRetenidos value for this PagosPagoImpuestosR.
     * 
     * @return totalImpuestosRetenidos
     */
    public java.math.BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }


    /**
     * Sets the totalImpuestosRetenidos value for this PagosPagoImpuestosR.
     * 
     * @param totalImpuestosRetenidos
     */
    public void setTotalImpuestosRetenidos(java.math.BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }


    /**
     * Gets the totalImpuestosTrasladados value for this PagosPagoImpuestosR.
     * 
     * @return totalImpuestosTrasladados
     */
    public java.math.BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }


    /**
     * Sets the totalImpuestosTrasladados value for this PagosPagoImpuestosR.
     * 
     * @param totalImpuestosTrasladados
     */
    public void setTotalImpuestosTrasladados(java.math.BigDecimal totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }


    /**
     * Gets the traslados value for this PagosPagoImpuestosR.
     * 
     * @return traslados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR[] getTraslados() {
        return traslados;
    }


    /**
     * Sets the traslados value for this PagosPagoImpuestosR.
     * 
     * @param traslados
     */
    public void setTraslados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosTrasladoR[] traslados) {
        this.traslados = traslados;
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
            ((this.retenciones==null && other.getRetenciones()==null) || 
             (this.retenciones!=null &&
              java.util.Arrays.equals(this.retenciones, other.getRetenciones()))) &&
            ((this.totalImpuestosRetenidos==null && other.getTotalImpuestosRetenidos()==null) || 
             (this.totalImpuestosRetenidos!=null &&
              this.totalImpuestosRetenidos.equals(other.getTotalImpuestosRetenidos()))) &&
            ((this.totalImpuestosTrasladados==null && other.getTotalImpuestosTrasladados()==null) || 
             (this.totalImpuestosTrasladados!=null &&
              this.totalImpuestosTrasladados.equals(other.getTotalImpuestosTrasladados()))) &&
            ((this.traslados==null && other.getTraslados()==null) || 
             (this.traslados!=null &&
              java.util.Arrays.equals(this.traslados, other.getTraslados())));
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
        if (getRetenciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetenciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetenciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotalImpuestosRetenidos() != null) {
            _hashCode += getTotalImpuestosRetenidos().hashCode();
        }
        if (getTotalImpuestosTrasladados() != null) {
            _hashCode += getTotalImpuestosTrasladados().hashCode();
        }
        if (getTraslados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTraslados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTraslados(), i);
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
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retenciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Retenciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosRetencionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosRetencionR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalImpuestosRetenidos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalImpuestosRetenidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalImpuestosTrasladados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalImpuestosTrasladados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("traslados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Traslados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosTrasladoR"));
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
