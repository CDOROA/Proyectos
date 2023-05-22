/**
 * CertificadoDestruccionR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CertificadoDestruccionR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionInformacionAduaneraR informacionAduanera;

    private java.lang.String numFolDesVeh;

    private java.lang.String serie;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionVehiculoDestruidoR vehiculoDestruido;

    public CertificadoDestruccionR() {
    }

    public CertificadoDestruccionR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionInformacionAduaneraR informacionAduanera,
           java.lang.String numFolDesVeh,
           java.lang.String serie,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionVehiculoDestruidoR vehiculoDestruido) {
           this.informacionAduanera = informacionAduanera;
           this.numFolDesVeh = numFolDesVeh;
           this.serie = serie;
           this.vehiculoDestruido = vehiculoDestruido;
    }


    /**
     * Gets the informacionAduanera value for this CertificadoDestruccionR.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionInformacionAduaneraR getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this CertificadoDestruccionR.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionInformacionAduaneraR informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the numFolDesVeh value for this CertificadoDestruccionR.
     * 
     * @return numFolDesVeh
     */
    public java.lang.String getNumFolDesVeh() {
        return numFolDesVeh;
    }


    /**
     * Sets the numFolDesVeh value for this CertificadoDestruccionR.
     * 
     * @param numFolDesVeh
     */
    public void setNumFolDesVeh(java.lang.String numFolDesVeh) {
        this.numFolDesVeh = numFolDesVeh;
    }


    /**
     * Gets the serie value for this CertificadoDestruccionR.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this CertificadoDestruccionR.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the vehiculoDestruido value for this CertificadoDestruccionR.
     * 
     * @return vehiculoDestruido
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionVehiculoDestruidoR getVehiculoDestruido() {
        return vehiculoDestruido;
    }


    /**
     * Sets the vehiculoDestruido value for this CertificadoDestruccionR.
     * 
     * @param vehiculoDestruido
     */
    public void setVehiculoDestruido(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CertificadoDestruccionVehiculoDestruidoR vehiculoDestruido) {
        this.vehiculoDestruido = vehiculoDestruido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CertificadoDestruccionR)) return false;
        CertificadoDestruccionR other = (CertificadoDestruccionR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              this.informacionAduanera.equals(other.getInformacionAduanera()))) &&
            ((this.numFolDesVeh==null && other.getNumFolDesVeh()==null) || 
             (this.numFolDesVeh!=null &&
              this.numFolDesVeh.equals(other.getNumFolDesVeh()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.vehiculoDestruido==null && other.getVehiculoDestruido()==null) || 
             (this.vehiculoDestruido!=null &&
              this.vehiculoDestruido.equals(other.getVehiculoDestruido())));
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
        if (getInformacionAduanera() != null) {
            _hashCode += getInformacionAduanera().hashCode();
        }
        if (getNumFolDesVeh() != null) {
            _hashCode += getNumFolDesVeh().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getVehiculoDestruido() != null) {
            _hashCode += getVehiculoDestruido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CertificadoDestruccionR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionInformacionAduaneraR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numFolDesVeh");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumFolDesVeh"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoDestruido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoDestruido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionVehiculoDestruidoR"));
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
