/**
 * RespuestaReporteCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaReporteCR  implements java.io.Serializable {
    private java.lang.String errorGeneral;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR[] listaComprobantes;

    private java.lang.Boolean operacionExitosa;

    private java.lang.Integer totalComprobantesPeriodo;

    public RespuestaReporteCR() {
    }

    public RespuestaReporteCR(
           java.lang.String errorGeneral,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR[] listaComprobantes,
           java.lang.Boolean operacionExitosa,
           java.lang.Integer totalComprobantesPeriodo) {
           this.errorGeneral = errorGeneral;
           this.listaComprobantes = listaComprobantes;
           this.operacionExitosa = operacionExitosa;
           this.totalComprobantesPeriodo = totalComprobantesPeriodo;
    }


    /**
     * Gets the errorGeneral value for this RespuestaReporteCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaReporteCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the listaComprobantes value for this RespuestaReporteCR.
     * 
     * @return listaComprobantes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR[] getListaComprobantes() {
        return listaComprobantes;
    }


    /**
     * Sets the listaComprobantes value for this RespuestaReporteCR.
     * 
     * @param listaComprobantes
     */
    public void setListaComprobantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RegistroCFDICR[] listaComprobantes) {
        this.listaComprobantes = listaComprobantes;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaReporteCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaReporteCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the totalComprobantesPeriodo value for this RespuestaReporteCR.
     * 
     * @return totalComprobantesPeriodo
     */
    public java.lang.Integer getTotalComprobantesPeriodo() {
        return totalComprobantesPeriodo;
    }


    /**
     * Sets the totalComprobantesPeriodo value for this RespuestaReporteCR.
     * 
     * @param totalComprobantesPeriodo
     */
    public void setTotalComprobantesPeriodo(java.lang.Integer totalComprobantesPeriodo) {
        this.totalComprobantesPeriodo = totalComprobantesPeriodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaReporteCR)) return false;
        RespuestaReporteCR other = (RespuestaReporteCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral()))) &&
            ((this.listaComprobantes==null && other.getListaComprobantes()==null) || 
             (this.listaComprobantes!=null &&
              java.util.Arrays.equals(this.listaComprobantes, other.getListaComprobantes()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa()))) &&
            ((this.totalComprobantesPeriodo==null && other.getTotalComprobantesPeriodo()==null) || 
             (this.totalComprobantesPeriodo!=null &&
              this.totalComprobantesPeriodo.equals(other.getTotalComprobantesPeriodo())));
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
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        if (getListaComprobantes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaComprobantes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaComprobantes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        if (getTotalComprobantesPeriodo() != null) {
            _hashCode += getTotalComprobantesPeriodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaReporteCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaReporteCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorGeneral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaComprobantes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaComprobantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalComprobantesPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalComprobantesPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
