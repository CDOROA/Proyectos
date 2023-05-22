/**
 * IngresosHidrocarburosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IngresosHidrocarburosR  implements java.io.Serializable {
    private java.math.BigDecimal contraprestacionPagadaOperador;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR[] documentoRelacionado;

    private java.lang.String numeroContrato;

    private java.math.BigDecimal porcentaje;

    public IngresosHidrocarburosR() {
    }

    public IngresosHidrocarburosR(
           java.math.BigDecimal contraprestacionPagadaOperador,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR[] documentoRelacionado,
           java.lang.String numeroContrato,
           java.math.BigDecimal porcentaje) {
           this.contraprestacionPagadaOperador = contraprestacionPagadaOperador;
           this.documentoRelacionado = documentoRelacionado;
           this.numeroContrato = numeroContrato;
           this.porcentaje = porcentaje;
    }


    /**
     * Gets the contraprestacionPagadaOperador value for this IngresosHidrocarburosR.
     * 
     * @return contraprestacionPagadaOperador
     */
    public java.math.BigDecimal getContraprestacionPagadaOperador() {
        return contraprestacionPagadaOperador;
    }


    /**
     * Sets the contraprestacionPagadaOperador value for this IngresosHidrocarburosR.
     * 
     * @param contraprestacionPagadaOperador
     */
    public void setContraprestacionPagadaOperador(java.math.BigDecimal contraprestacionPagadaOperador) {
        this.contraprestacionPagadaOperador = contraprestacionPagadaOperador;
    }


    /**
     * Gets the documentoRelacionado value for this IngresosHidrocarburosR.
     * 
     * @return documentoRelacionado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR[] getDocumentoRelacionado() {
        return documentoRelacionado;
    }


    /**
     * Sets the documentoRelacionado value for this IngresosHidrocarburosR.
     * 
     * @param documentoRelacionado
     */
    public void setDocumentoRelacionado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IngresosHidrocarburosDocumentoRelacionadoR[] documentoRelacionado) {
        this.documentoRelacionado = documentoRelacionado;
    }


    /**
     * Gets the numeroContrato value for this IngresosHidrocarburosR.
     * 
     * @return numeroContrato
     */
    public java.lang.String getNumeroContrato() {
        return numeroContrato;
    }


    /**
     * Sets the numeroContrato value for this IngresosHidrocarburosR.
     * 
     * @param numeroContrato
     */
    public void setNumeroContrato(java.lang.String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }


    /**
     * Gets the porcentaje value for this IngresosHidrocarburosR.
     * 
     * @return porcentaje
     */
    public java.math.BigDecimal getPorcentaje() {
        return porcentaje;
    }


    /**
     * Sets the porcentaje value for this IngresosHidrocarburosR.
     * 
     * @param porcentaje
     */
    public void setPorcentaje(java.math.BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IngresosHidrocarburosR)) return false;
        IngresosHidrocarburosR other = (IngresosHidrocarburosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contraprestacionPagadaOperador==null && other.getContraprestacionPagadaOperador()==null) || 
             (this.contraprestacionPagadaOperador!=null &&
              this.contraprestacionPagadaOperador.equals(other.getContraprestacionPagadaOperador()))) &&
            ((this.documentoRelacionado==null && other.getDocumentoRelacionado()==null) || 
             (this.documentoRelacionado!=null &&
              java.util.Arrays.equals(this.documentoRelacionado, other.getDocumentoRelacionado()))) &&
            ((this.numeroContrato==null && other.getNumeroContrato()==null) || 
             (this.numeroContrato!=null &&
              this.numeroContrato.equals(other.getNumeroContrato()))) &&
            ((this.porcentaje==null && other.getPorcentaje()==null) || 
             (this.porcentaje!=null &&
              this.porcentaje.equals(other.getPorcentaje())));
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
        if (getContraprestacionPagadaOperador() != null) {
            _hashCode += getContraprestacionPagadaOperador().hashCode();
        }
        if (getDocumentoRelacionado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentoRelacionado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentoRelacionado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumeroContrato() != null) {
            _hashCode += getNumeroContrato().hashCode();
        }
        if (getPorcentaje() != null) {
            _hashCode += getPorcentaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IngresosHidrocarburosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contraprestacionPagadaOperador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContraprestacionPagadaOperador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DocumentoRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroContrato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroContrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Porcentaje"));
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
