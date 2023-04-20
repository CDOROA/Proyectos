/**
 * RequestCancelacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_CancelacionesIndependientes;

public class RequestCancelacion  implements java.io.Serializable {
    private java.lang.String errorRelacionado;

    private java.lang.String motivo;

    private java.lang.String RFCEmisor;

    private java.lang.String UUID;

    private java.lang.String UUIDsustitucion;

    private java.lang.String XML;

    public RequestCancelacion() {
    }

    public RequestCancelacion(
           java.lang.String errorRelacionado,
           java.lang.String motivo,
           java.lang.String RFCEmisor,
           java.lang.String UUID,
           java.lang.String UUIDsustitucion,
           java.lang.String XML) {
           this.errorRelacionado = errorRelacionado;
           this.motivo = motivo;
           this.RFCEmisor = RFCEmisor;
           this.UUID = UUID;
           this.UUIDsustitucion = UUIDsustitucion;
           this.XML = XML;
    }


    /**
     * Gets the errorRelacionado value for this RequestCancelacion.
     * 
     * @return errorRelacionado
     */
    public java.lang.String getErrorRelacionado() {
        return errorRelacionado;
    }


    /**
     * Sets the errorRelacionado value for this RequestCancelacion.
     * 
     * @param errorRelacionado
     */
    public void setErrorRelacionado(java.lang.String errorRelacionado) {
        this.errorRelacionado = errorRelacionado;
    }


    /**
     * Gets the motivo value for this RequestCancelacion.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this RequestCancelacion.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the RFCEmisor value for this RequestCancelacion.
     * 
     * @return RFCEmisor
     */
    public java.lang.String getRFCEmisor() {
        return RFCEmisor;
    }


    /**
     * Sets the RFCEmisor value for this RequestCancelacion.
     * 
     * @param RFCEmisor
     */
    public void setRFCEmisor(java.lang.String RFCEmisor) {
        this.RFCEmisor = RFCEmisor;
    }


    /**
     * Gets the UUID value for this RequestCancelacion.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this RequestCancelacion.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the UUIDsustitucion value for this RequestCancelacion.
     * 
     * @return UUIDsustitucion
     */
    public java.lang.String getUUIDsustitucion() {
        return UUIDsustitucion;
    }


    /**
     * Sets the UUIDsustitucion value for this RequestCancelacion.
     * 
     * @param UUIDsustitucion
     */
    public void setUUIDsustitucion(java.lang.String UUIDsustitucion) {
        this.UUIDsustitucion = UUIDsustitucion;
    }


    /**
     * Gets the XML value for this RequestCancelacion.
     * 
     * @return XML
     */
    public java.lang.String getXML() {
        return XML;
    }


    /**
     * Sets the XML value for this RequestCancelacion.
     * 
     * @param XML
     */
    public void setXML(java.lang.String XML) {
        this.XML = XML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestCancelacion)) return false;
        RequestCancelacion other = (RequestCancelacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorRelacionado==null && other.getErrorRelacionado()==null) || 
             (this.errorRelacionado!=null &&
              this.errorRelacionado.equals(other.getErrorRelacionado()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.RFCEmisor==null && other.getRFCEmisor()==null) || 
             (this.RFCEmisor!=null &&
              this.RFCEmisor.equals(other.getRFCEmisor()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID()))) &&
            ((this.UUIDsustitucion==null && other.getUUIDsustitucion()==null) || 
             (this.UUIDsustitucion!=null &&
              this.UUIDsustitucion.equals(other.getUUIDsustitucion()))) &&
            ((this.XML==null && other.getXML()==null) || 
             (this.XML!=null &&
              this.XML.equals(other.getXML())));
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
        if (getErrorRelacionado() != null) {
            _hashCode += getErrorRelacionado().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getRFCEmisor() != null) {
            _hashCode += getRFCEmisor().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        if (getUUIDsustitucion() != null) {
            _hashCode += getUUIDsustitucion().hashCode();
        }
        if (getXML() != null) {
            _hashCode += getXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestCancelacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "RequestCancelacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "ErrorRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "RFCEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUIDsustitucion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "UUIDsustitucion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.CancelacionesIndependientes", "XML"));
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
