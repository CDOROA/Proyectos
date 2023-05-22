/**
 * RespuestaTicketCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaTicketCR  implements java.io.Serializable {
    private java.lang.String CBBUrl;

    private java.lang.String errorDetallado;

    private java.lang.String errorGeneral;

    private java.lang.Boolean operacionExitosa;

    private java.lang.String referencia;

    public RespuestaTicketCR() {
    }

    public RespuestaTicketCR(
           java.lang.String CBBUrl,
           java.lang.String errorDetallado,
           java.lang.String errorGeneral,
           java.lang.Boolean operacionExitosa,
           java.lang.String referencia) {
           this.CBBUrl = CBBUrl;
           this.errorDetallado = errorDetallado;
           this.errorGeneral = errorGeneral;
           this.operacionExitosa = operacionExitosa;
           this.referencia = referencia;
    }


    /**
     * Gets the CBBUrl value for this RespuestaTicketCR.
     * 
     * @return CBBUrl
     */
    public java.lang.String getCBBUrl() {
        return CBBUrl;
    }


    /**
     * Sets the CBBUrl value for this RespuestaTicketCR.
     * 
     * @param CBBUrl
     */
    public void setCBBUrl(java.lang.String CBBUrl) {
        this.CBBUrl = CBBUrl;
    }


    /**
     * Gets the errorDetallado value for this RespuestaTicketCR.
     * 
     * @return errorDetallado
     */
    public java.lang.String getErrorDetallado() {
        return errorDetallado;
    }


    /**
     * Sets the errorDetallado value for this RespuestaTicketCR.
     * 
     * @param errorDetallado
     */
    public void setErrorDetallado(java.lang.String errorDetallado) {
        this.errorDetallado = errorDetallado;
    }


    /**
     * Gets the errorGeneral value for this RespuestaTicketCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaTicketCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaTicketCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaTicketCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the referencia value for this RespuestaTicketCR.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this RespuestaTicketCR.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaTicketCR)) return false;
        RespuestaTicketCR other = (RespuestaTicketCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CBBUrl==null && other.getCBBUrl()==null) || 
             (this.CBBUrl!=null &&
              this.CBBUrl.equals(other.getCBBUrl()))) &&
            ((this.errorDetallado==null && other.getErrorDetallado()==null) || 
             (this.errorDetallado!=null &&
              this.errorDetallado.equals(other.getErrorDetallado()))) &&
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia())));
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
        if (getCBBUrl() != null) {
            _hashCode += getCBBUrl().hashCode();
        }
        if (getErrorDetallado() != null) {
            _hashCode += getErrorDetallado().hashCode();
        }
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaTicketCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaTicketCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBBUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CBBUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDetallado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorDetallado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorGeneral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Referencia"));
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
