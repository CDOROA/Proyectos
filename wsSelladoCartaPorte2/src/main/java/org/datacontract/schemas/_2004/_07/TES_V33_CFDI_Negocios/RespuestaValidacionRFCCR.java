/**
 * RespuestaValidacionRFCCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaValidacionRFCCR  implements java.io.Serializable {
    private java.lang.Boolean cancelado;

    private java.lang.String mensajeError;

    private java.lang.String RFC;

    private java.lang.Boolean RFCLocalizado;

    private java.lang.Boolean subcontratacion;

    private java.lang.Boolean unidadSNCF;

    public RespuestaValidacionRFCCR() {
    }

    public RespuestaValidacionRFCCR(
           java.lang.Boolean cancelado,
           java.lang.String mensajeError,
           java.lang.String RFC,
           java.lang.Boolean RFCLocalizado,
           java.lang.Boolean subcontratacion,
           java.lang.Boolean unidadSNCF) {
           this.cancelado = cancelado;
           this.mensajeError = mensajeError;
           this.RFC = RFC;
           this.RFCLocalizado = RFCLocalizado;
           this.subcontratacion = subcontratacion;
           this.unidadSNCF = unidadSNCF;
    }


    /**
     * Gets the cancelado value for this RespuestaValidacionRFCCR.
     * 
     * @return cancelado
     */
    public java.lang.Boolean getCancelado() {
        return cancelado;
    }


    /**
     * Sets the cancelado value for this RespuestaValidacionRFCCR.
     * 
     * @param cancelado
     */
    public void setCancelado(java.lang.Boolean cancelado) {
        this.cancelado = cancelado;
    }


    /**
     * Gets the mensajeError value for this RespuestaValidacionRFCCR.
     * 
     * @return mensajeError
     */
    public java.lang.String getMensajeError() {
        return mensajeError;
    }


    /**
     * Sets the mensajeError value for this RespuestaValidacionRFCCR.
     * 
     * @param mensajeError
     */
    public void setMensajeError(java.lang.String mensajeError) {
        this.mensajeError = mensajeError;
    }


    /**
     * Gets the RFC value for this RespuestaValidacionRFCCR.
     * 
     * @return RFC
     */
    public java.lang.String getRFC() {
        return RFC;
    }


    /**
     * Sets the RFC value for this RespuestaValidacionRFCCR.
     * 
     * @param RFC
     */
    public void setRFC(java.lang.String RFC) {
        this.RFC = RFC;
    }


    /**
     * Gets the RFCLocalizado value for this RespuestaValidacionRFCCR.
     * 
     * @return RFCLocalizado
     */
    public java.lang.Boolean getRFCLocalizado() {
        return RFCLocalizado;
    }


    /**
     * Sets the RFCLocalizado value for this RespuestaValidacionRFCCR.
     * 
     * @param RFCLocalizado
     */
    public void setRFCLocalizado(java.lang.Boolean RFCLocalizado) {
        this.RFCLocalizado = RFCLocalizado;
    }


    /**
     * Gets the subcontratacion value for this RespuestaValidacionRFCCR.
     * 
     * @return subcontratacion
     */
    public java.lang.Boolean getSubcontratacion() {
        return subcontratacion;
    }


    /**
     * Sets the subcontratacion value for this RespuestaValidacionRFCCR.
     * 
     * @param subcontratacion
     */
    public void setSubcontratacion(java.lang.Boolean subcontratacion) {
        this.subcontratacion = subcontratacion;
    }


    /**
     * Gets the unidadSNCF value for this RespuestaValidacionRFCCR.
     * 
     * @return unidadSNCF
     */
    public java.lang.Boolean getUnidadSNCF() {
        return unidadSNCF;
    }


    /**
     * Sets the unidadSNCF value for this RespuestaValidacionRFCCR.
     * 
     * @param unidadSNCF
     */
    public void setUnidadSNCF(java.lang.Boolean unidadSNCF) {
        this.unidadSNCF = unidadSNCF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaValidacionRFCCR)) return false;
        RespuestaValidacionRFCCR other = (RespuestaValidacionRFCCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancelado==null && other.getCancelado()==null) || 
             (this.cancelado!=null &&
              this.cancelado.equals(other.getCancelado()))) &&
            ((this.mensajeError==null && other.getMensajeError()==null) || 
             (this.mensajeError!=null &&
              this.mensajeError.equals(other.getMensajeError()))) &&
            ((this.RFC==null && other.getRFC()==null) || 
             (this.RFC!=null &&
              this.RFC.equals(other.getRFC()))) &&
            ((this.RFCLocalizado==null && other.getRFCLocalizado()==null) || 
             (this.RFCLocalizado!=null &&
              this.RFCLocalizado.equals(other.getRFCLocalizado()))) &&
            ((this.subcontratacion==null && other.getSubcontratacion()==null) || 
             (this.subcontratacion!=null &&
              this.subcontratacion.equals(other.getSubcontratacion()))) &&
            ((this.unidadSNCF==null && other.getUnidadSNCF()==null) || 
             (this.unidadSNCF!=null &&
              this.unidadSNCF.equals(other.getUnidadSNCF())));
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
        if (getCancelado() != null) {
            _hashCode += getCancelado().hashCode();
        }
        if (getMensajeError() != null) {
            _hashCode += getMensajeError().hashCode();
        }
        if (getRFC() != null) {
            _hashCode += getRFC().hashCode();
        }
        if (getRFCLocalizado() != null) {
            _hashCode += getRFCLocalizado().hashCode();
        }
        if (getSubcontratacion() != null) {
            _hashCode += getSubcontratacion().hashCode();
        }
        if (getUnidadSNCF() != null) {
            _hashCode += getUnidadSNCF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaValidacionRFCCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaValidacionRFCCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cancelado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajeError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MensajeError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCLocalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFCLocalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subcontratacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Subcontratacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadSNCF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UnidadSNCF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
