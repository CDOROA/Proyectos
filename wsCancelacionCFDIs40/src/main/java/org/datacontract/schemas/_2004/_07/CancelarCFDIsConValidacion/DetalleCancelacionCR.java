/**
 * DetalleCancelacionCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion;

public class DetalleCancelacionCR  implements java.io.Serializable {
    private java.lang.String esCancelable;

    private java.lang.String mensajeError;

    private java.lang.String respuestaServicio;

    private java.lang.String UUID;

    public DetalleCancelacionCR() {
    }

    public DetalleCancelacionCR(
           java.lang.String esCancelable,
           java.lang.String mensajeError,
           java.lang.String respuestaServicio,
           java.lang.String UUID) {
           this.esCancelable = esCancelable;
           this.mensajeError = mensajeError;
           this.respuestaServicio = respuestaServicio;
           this.UUID = UUID;
    }


    /**
     * Gets the esCancelable value for this DetalleCancelacionCR.
     * 
     * @return esCancelable
     */
    public java.lang.String getEsCancelable() {
        return esCancelable;
    }


    /**
     * Sets the esCancelable value for this DetalleCancelacionCR.
     * 
     * @param esCancelable
     */
    public void setEsCancelable(java.lang.String esCancelable) {
        this.esCancelable = esCancelable;
    }


    /**
     * Gets the mensajeError value for this DetalleCancelacionCR.
     * 
     * @return mensajeError
     */
    public java.lang.String getMensajeError() {
        return mensajeError;
    }


    /**
     * Sets the mensajeError value for this DetalleCancelacionCR.
     * 
     * @param mensajeError
     */
    public void setMensajeError(java.lang.String mensajeError) {
        this.mensajeError = mensajeError;
    }


    /**
     * Gets the respuestaServicio value for this DetalleCancelacionCR.
     * 
     * @return respuestaServicio
     */
    public java.lang.String getRespuestaServicio() {
        return respuestaServicio;
    }


    /**
     * Sets the respuestaServicio value for this DetalleCancelacionCR.
     * 
     * @param respuestaServicio
     */
    public void setRespuestaServicio(java.lang.String respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }


    /**
     * Gets the UUID value for this DetalleCancelacionCR.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this DetalleCancelacionCR.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalleCancelacionCR)) return false;
        DetalleCancelacionCR other = (DetalleCancelacionCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esCancelable==null && other.getEsCancelable()==null) || 
             (this.esCancelable!=null &&
              this.esCancelable.equals(other.getEsCancelable()))) &&
            ((this.mensajeError==null && other.getMensajeError()==null) || 
             (this.mensajeError!=null &&
              this.mensajeError.equals(other.getMensajeError()))) &&
            ((this.respuestaServicio==null && other.getRespuestaServicio()==null) || 
             (this.respuestaServicio!=null &&
              this.respuestaServicio.equals(other.getRespuestaServicio()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID())));
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
        if (getEsCancelable() != null) {
            _hashCode += getEsCancelable().hashCode();
        }
        if (getMensajeError() != null) {
            _hashCode += getMensajeError().hashCode();
        }
        if (getRespuestaServicio() != null) {
            _hashCode += getRespuestaServicio().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalleCancelacionCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esCancelable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "EsCancelable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajeError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "MensajeError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "RespuestaServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "UUID"));
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
