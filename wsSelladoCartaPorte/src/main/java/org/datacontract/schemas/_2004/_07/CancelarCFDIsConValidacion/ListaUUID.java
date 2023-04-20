/**
 * ListaUUID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion;

public class ListaUUID  implements java.io.Serializable {
    private java.lang.String errorRelacionado;

    private java.lang.String folioSustitucion;

    private java.lang.String motivo;

    private java.lang.String rfcEmisor;

    private java.lang.String UUID;

    private java.lang.String xmlACancelar;

    public ListaUUID() {
    }

    public ListaUUID(
           java.lang.String errorRelacionado,
           java.lang.String folioSustitucion,
           java.lang.String motivo,
           java.lang.String rfcEmisor,
           java.lang.String UUID,
           java.lang.String xmlACancelar) {
           this.errorRelacionado = errorRelacionado;
           this.folioSustitucion = folioSustitucion;
           this.motivo = motivo;
           this.rfcEmisor = rfcEmisor;
           this.UUID = UUID;
           this.xmlACancelar = xmlACancelar;
    }


    /**
     * Gets the errorRelacionado value for this ListaUUID.
     * 
     * @return errorRelacionado
     */
    public java.lang.String getErrorRelacionado() {
        return errorRelacionado;
    }


    /**
     * Sets the errorRelacionado value for this ListaUUID.
     * 
     * @param errorRelacionado
     */
    public void setErrorRelacionado(java.lang.String errorRelacionado) {
        this.errorRelacionado = errorRelacionado;
    }


    /**
     * Gets the folioSustitucion value for this ListaUUID.
     * 
     * @return folioSustitucion
     */
    public java.lang.String getFolioSustitucion() {
        return folioSustitucion;
    }


    /**
     * Sets the folioSustitucion value for this ListaUUID.
     * 
     * @param folioSustitucion
     */
    public void setFolioSustitucion(java.lang.String folioSustitucion) {
        this.folioSustitucion = folioSustitucion;
    }


    /**
     * Gets the motivo value for this ListaUUID.
     * 
     * @return motivo
     */
    public java.lang.String getMotivo() {
        return motivo;
    }


    /**
     * Sets the motivo value for this ListaUUID.
     * 
     * @param motivo
     */
    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }


    /**
     * Gets the rfcEmisor value for this ListaUUID.
     * 
     * @return rfcEmisor
     */
    public java.lang.String getRfcEmisor() {
        return rfcEmisor;
    }


    /**
     * Sets the rfcEmisor value for this ListaUUID.
     * 
     * @param rfcEmisor
     */
    public void setRfcEmisor(java.lang.String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }


    /**
     * Gets the UUID value for this ListaUUID.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this ListaUUID.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the xmlACancelar value for this ListaUUID.
     * 
     * @return xmlACancelar
     */
    public java.lang.String getXmlACancelar() {
        return xmlACancelar;
    }


    /**
     * Sets the xmlACancelar value for this ListaUUID.
     * 
     * @param xmlACancelar
     */
    public void setXmlACancelar(java.lang.String xmlACancelar) {
        this.xmlACancelar = xmlACancelar;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaUUID)) return false;
        ListaUUID other = (ListaUUID) obj;
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
            ((this.folioSustitucion==null && other.getFolioSustitucion()==null) || 
             (this.folioSustitucion!=null &&
              this.folioSustitucion.equals(other.getFolioSustitucion()))) &&
            ((this.motivo==null && other.getMotivo()==null) || 
             (this.motivo!=null &&
              this.motivo.equals(other.getMotivo()))) &&
            ((this.rfcEmisor==null && other.getRfcEmisor()==null) || 
             (this.rfcEmisor!=null &&
              this.rfcEmisor.equals(other.getRfcEmisor()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID()))) &&
            ((this.xmlACancelar==null && other.getXmlACancelar()==null) || 
             (this.xmlACancelar!=null &&
              this.xmlACancelar.equals(other.getXmlACancelar())));
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
        if (getFolioSustitucion() != null) {
            _hashCode += getFolioSustitucion().hashCode();
        }
        if (getMotivo() != null) {
            _hashCode += getMotivo().hashCode();
        }
        if (getRfcEmisor() != null) {
            _hashCode += getRfcEmisor().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        if (getXmlACancelar() != null) {
            _hashCode += getXmlACancelar().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaUUID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ListaUUID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ErrorRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioSustitucion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "FolioSustitucion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "Motivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "RfcEmisor"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlACancelar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "XmlACancelar"));
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
