/**
 * CertificadoDestruccionInformacionAduaneraR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CertificadoDestruccionInformacionAduaneraR  implements java.io.Serializable {
    private java.lang.String aduana;

    private java.util.Calendar fecha;

    private java.lang.String numPedImp;

    public CertificadoDestruccionInformacionAduaneraR() {
    }

    public CertificadoDestruccionInformacionAduaneraR(
           java.lang.String aduana,
           java.util.Calendar fecha,
           java.lang.String numPedImp) {
           this.aduana = aduana;
           this.fecha = fecha;
           this.numPedImp = numPedImp;
    }


    /**
     * Gets the aduana value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @return aduana
     */
    public java.lang.String getAduana() {
        return aduana;
    }


    /**
     * Sets the aduana value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @param aduana
     */
    public void setAduana(java.lang.String aduana) {
        this.aduana = aduana;
    }


    /**
     * Gets the fecha value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the numPedImp value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @return numPedImp
     */
    public java.lang.String getNumPedImp() {
        return numPedImp;
    }


    /**
     * Sets the numPedImp value for this CertificadoDestruccionInformacionAduaneraR.
     * 
     * @param numPedImp
     */
    public void setNumPedImp(java.lang.String numPedImp) {
        this.numPedImp = numPedImp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CertificadoDestruccionInformacionAduaneraR)) return false;
        CertificadoDestruccionInformacionAduaneraR other = (CertificadoDestruccionInformacionAduaneraR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aduana==null && other.getAduana()==null) || 
             (this.aduana!=null &&
              this.aduana.equals(other.getAduana()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.numPedImp==null && other.getNumPedImp()==null) || 
             (this.numPedImp!=null &&
              this.numPedImp.equals(other.getNumPedImp())));
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
        if (getAduana() != null) {
            _hashCode += getAduana().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getNumPedImp() != null) {
            _hashCode += getNumPedImp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CertificadoDestruccionInformacionAduaneraR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionInformacionAduaneraR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aduana");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Aduana"));
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
        elemField.setFieldName("numPedImp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumPedImp"));
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
