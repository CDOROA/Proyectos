/**
 * DatoTransitoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatoTransitoR  implements java.io.Serializable {
    private java.lang.String empresaTransporte;

    private java.lang.String idTransporte;

    private java.lang.String nacionalidad;

    private java.lang.String numeroId;

    private java.lang.String tipoId;

    private java.lang.String via;

    public DatoTransitoR() {
    }

    public DatoTransitoR(
           java.lang.String empresaTransporte,
           java.lang.String idTransporte,
           java.lang.String nacionalidad,
           java.lang.String numeroId,
           java.lang.String tipoId,
           java.lang.String via) {
           this.empresaTransporte = empresaTransporte;
           this.idTransporte = idTransporte;
           this.nacionalidad = nacionalidad;
           this.numeroId = numeroId;
           this.tipoId = tipoId;
           this.via = via;
    }


    /**
     * Gets the empresaTransporte value for this DatoTransitoR.
     * 
     * @return empresaTransporte
     */
    public java.lang.String getEmpresaTransporte() {
        return empresaTransporte;
    }


    /**
     * Sets the empresaTransporte value for this DatoTransitoR.
     * 
     * @param empresaTransporte
     */
    public void setEmpresaTransporte(java.lang.String empresaTransporte) {
        this.empresaTransporte = empresaTransporte;
    }


    /**
     * Gets the idTransporte value for this DatoTransitoR.
     * 
     * @return idTransporte
     */
    public java.lang.String getIdTransporte() {
        return idTransporte;
    }


    /**
     * Sets the idTransporte value for this DatoTransitoR.
     * 
     * @param idTransporte
     */
    public void setIdTransporte(java.lang.String idTransporte) {
        this.idTransporte = idTransporte;
    }


    /**
     * Gets the nacionalidad value for this DatoTransitoR.
     * 
     * @return nacionalidad
     */
    public java.lang.String getNacionalidad() {
        return nacionalidad;
    }


    /**
     * Sets the nacionalidad value for this DatoTransitoR.
     * 
     * @param nacionalidad
     */
    public void setNacionalidad(java.lang.String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    /**
     * Gets the numeroId value for this DatoTransitoR.
     * 
     * @return numeroId
     */
    public java.lang.String getNumeroId() {
        return numeroId;
    }


    /**
     * Sets the numeroId value for this DatoTransitoR.
     * 
     * @param numeroId
     */
    public void setNumeroId(java.lang.String numeroId) {
        this.numeroId = numeroId;
    }


    /**
     * Gets the tipoId value for this DatoTransitoR.
     * 
     * @return tipoId
     */
    public java.lang.String getTipoId() {
        return tipoId;
    }


    /**
     * Sets the tipoId value for this DatoTransitoR.
     * 
     * @param tipoId
     */
    public void setTipoId(java.lang.String tipoId) {
        this.tipoId = tipoId;
    }


    /**
     * Gets the via value for this DatoTransitoR.
     * 
     * @return via
     */
    public java.lang.String getVia() {
        return via;
    }


    /**
     * Sets the via value for this DatoTransitoR.
     * 
     * @param via
     */
    public void setVia(java.lang.String via) {
        this.via = via;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatoTransitoR)) return false;
        DatoTransitoR other = (DatoTransitoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empresaTransporte==null && other.getEmpresaTransporte()==null) || 
             (this.empresaTransporte!=null &&
              this.empresaTransporte.equals(other.getEmpresaTransporte()))) &&
            ((this.idTransporte==null && other.getIdTransporte()==null) || 
             (this.idTransporte!=null &&
              this.idTransporte.equals(other.getIdTransporte()))) &&
            ((this.nacionalidad==null && other.getNacionalidad()==null) || 
             (this.nacionalidad!=null &&
              this.nacionalidad.equals(other.getNacionalidad()))) &&
            ((this.numeroId==null && other.getNumeroId()==null) || 
             (this.numeroId!=null &&
              this.numeroId.equals(other.getNumeroId()))) &&
            ((this.tipoId==null && other.getTipoId()==null) || 
             (this.tipoId!=null &&
              this.tipoId.equals(other.getTipoId()))) &&
            ((this.via==null && other.getVia()==null) || 
             (this.via!=null &&
              this.via.equals(other.getVia())));
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
        if (getEmpresaTransporte() != null) {
            _hashCode += getEmpresaTransporte().hashCode();
        }
        if (getIdTransporte() != null) {
            _hashCode += getIdTransporte().hashCode();
        }
        if (getNacionalidad() != null) {
            _hashCode += getNacionalidad().hashCode();
        }
        if (getNumeroId() != null) {
            _hashCode += getNumeroId().hashCode();
        }
        if (getTipoId() != null) {
            _hashCode += getTipoId().hashCode();
        }
        if (getVia() != null) {
            _hashCode += getVia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatoTransitoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatoTransitoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresaTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmpresaTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacionalidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nacionalidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("via");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Via"));
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
