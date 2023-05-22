/**
 * IngresosHidrocarburosDocumentoRelacionadoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IngresosHidrocarburosDocumentoRelacionadoR  implements java.io.Serializable {
    private java.lang.String fechaFolioFiscalVinculado;

    private java.lang.String folioFiscalVinculado;

    private java.lang.String mes;

    public IngresosHidrocarburosDocumentoRelacionadoR() {
    }

    public IngresosHidrocarburosDocumentoRelacionadoR(
           java.lang.String fechaFolioFiscalVinculado,
           java.lang.String folioFiscalVinculado,
           java.lang.String mes) {
           this.fechaFolioFiscalVinculado = fechaFolioFiscalVinculado;
           this.folioFiscalVinculado = folioFiscalVinculado;
           this.mes = mes;
    }


    /**
     * Gets the fechaFolioFiscalVinculado value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @return fechaFolioFiscalVinculado
     */
    public java.lang.String getFechaFolioFiscalVinculado() {
        return fechaFolioFiscalVinculado;
    }


    /**
     * Sets the fechaFolioFiscalVinculado value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @param fechaFolioFiscalVinculado
     */
    public void setFechaFolioFiscalVinculado(java.lang.String fechaFolioFiscalVinculado) {
        this.fechaFolioFiscalVinculado = fechaFolioFiscalVinculado;
    }


    /**
     * Gets the folioFiscalVinculado value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @return folioFiscalVinculado
     */
    public java.lang.String getFolioFiscalVinculado() {
        return folioFiscalVinculado;
    }


    /**
     * Sets the folioFiscalVinculado value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @param folioFiscalVinculado
     */
    public void setFolioFiscalVinculado(java.lang.String folioFiscalVinculado) {
        this.folioFiscalVinculado = folioFiscalVinculado;
    }


    /**
     * Gets the mes value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @return mes
     */
    public java.lang.String getMes() {
        return mes;
    }


    /**
     * Sets the mes value for this IngresosHidrocarburosDocumentoRelacionadoR.
     * 
     * @param mes
     */
    public void setMes(java.lang.String mes) {
        this.mes = mes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IngresosHidrocarburosDocumentoRelacionadoR)) return false;
        IngresosHidrocarburosDocumentoRelacionadoR other = (IngresosHidrocarburosDocumentoRelacionadoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaFolioFiscalVinculado==null && other.getFechaFolioFiscalVinculado()==null) || 
             (this.fechaFolioFiscalVinculado!=null &&
              this.fechaFolioFiscalVinculado.equals(other.getFechaFolioFiscalVinculado()))) &&
            ((this.folioFiscalVinculado==null && other.getFolioFiscalVinculado()==null) || 
             (this.folioFiscalVinculado!=null &&
              this.folioFiscalVinculado.equals(other.getFolioFiscalVinculado()))) &&
            ((this.mes==null && other.getMes()==null) || 
             (this.mes!=null &&
              this.mes.equals(other.getMes())));
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
        if (getFechaFolioFiscalVinculado() != null) {
            _hashCode += getFechaFolioFiscalVinculado().hashCode();
        }
        if (getFolioFiscalVinculado() != null) {
            _hashCode += getFolioFiscalVinculado().hashCode();
        }
        if (getMes() != null) {
            _hashCode += getMes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IngresosHidrocarburosDocumentoRelacionadoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresosHidrocarburosDocumentoRelacionadoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFolioFiscalVinculado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaFolioFiscalVinculado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioFiscalVinculado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioFiscalVinculado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Mes"));
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
