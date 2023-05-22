/**
 * RespuestaProcesarSolicitudCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaProcesarSolicitudCR  implements java.io.Serializable {
    private java.lang.String acuse;

    private java.lang.String errorDetallado;

    private java.lang.String errorGeneral;

    private java.util.Calendar fecha;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR[] folios;

    private java.lang.Boolean operacionExitosa;

    private java.lang.String RFCReceptor;

    public RespuestaProcesarSolicitudCR() {
    }

    public RespuestaProcesarSolicitudCR(
           java.lang.String acuse,
           java.lang.String errorDetallado,
           java.lang.String errorGeneral,
           java.util.Calendar fecha,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR[] folios,
           java.lang.Boolean operacionExitosa,
           java.lang.String RFCReceptor) {
           this.acuse = acuse;
           this.errorDetallado = errorDetallado;
           this.errorGeneral = errorGeneral;
           this.fecha = fecha;
           this.folios = folios;
           this.operacionExitosa = operacionExitosa;
           this.RFCReceptor = RFCReceptor;
    }


    /**
     * Gets the acuse value for this RespuestaProcesarSolicitudCR.
     * 
     * @return acuse
     */
    public java.lang.String getAcuse() {
        return acuse;
    }


    /**
     * Sets the acuse value for this RespuestaProcesarSolicitudCR.
     * 
     * @param acuse
     */
    public void setAcuse(java.lang.String acuse) {
        this.acuse = acuse;
    }


    /**
     * Gets the errorDetallado value for this RespuestaProcesarSolicitudCR.
     * 
     * @return errorDetallado
     */
    public java.lang.String getErrorDetallado() {
        return errorDetallado;
    }


    /**
     * Sets the errorDetallado value for this RespuestaProcesarSolicitudCR.
     * 
     * @param errorDetallado
     */
    public void setErrorDetallado(java.lang.String errorDetallado) {
        this.errorDetallado = errorDetallado;
    }


    /**
     * Gets the errorGeneral value for this RespuestaProcesarSolicitudCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaProcesarSolicitudCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the fecha value for this RespuestaProcesarSolicitudCR.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this RespuestaProcesarSolicitudCR.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folios value for this RespuestaProcesarSolicitudCR.
     * 
     * @return folios
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR[] getFolios() {
        return folios;
    }


    /**
     * Sets the folios value for this RespuestaProcesarSolicitudCR.
     * 
     * @param folios
     */
    public void setFolios(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FolioRespuestaCR[] folios) {
        this.folios = folios;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaProcesarSolicitudCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaProcesarSolicitudCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the RFCReceptor value for this RespuestaProcesarSolicitudCR.
     * 
     * @return RFCReceptor
     */
    public java.lang.String getRFCReceptor() {
        return RFCReceptor;
    }


    /**
     * Sets the RFCReceptor value for this RespuestaProcesarSolicitudCR.
     * 
     * @param RFCReceptor
     */
    public void setRFCReceptor(java.lang.String RFCReceptor) {
        this.RFCReceptor = RFCReceptor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaProcesarSolicitudCR)) return false;
        RespuestaProcesarSolicitudCR other = (RespuestaProcesarSolicitudCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acuse==null && other.getAcuse()==null) || 
             (this.acuse!=null &&
              this.acuse.equals(other.getAcuse()))) &&
            ((this.errorDetallado==null && other.getErrorDetallado()==null) || 
             (this.errorDetallado!=null &&
              this.errorDetallado.equals(other.getErrorDetallado()))) &&
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.folios==null && other.getFolios()==null) || 
             (this.folios!=null &&
              java.util.Arrays.equals(this.folios, other.getFolios()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.RFCReceptor==null && other.getRFCReceptor()==null) || 
             (this.RFCReceptor!=null &&
              this.RFCReceptor.equals(other.getRFCReceptor())));
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
        if (getAcuse() != null) {
            _hashCode += getAcuse().hashCode();
        }
        if (getErrorDetallado() != null) {
            _hashCode += getErrorDetallado().hashCode();
        }
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFolios() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFolios());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFolios(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getRFCReceptor() != null) {
            _hashCode += getRFCReceptor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaProcesarSolicitudCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaProcesarSolicitudCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acuse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Acuse"));
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
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folios");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Folios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioRespuestaCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioRespuestaCR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFCReceptor"));
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
