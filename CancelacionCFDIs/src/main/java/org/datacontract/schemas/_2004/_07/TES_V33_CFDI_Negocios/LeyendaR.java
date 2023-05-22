/**
 * LeyendaR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class LeyendaR  implements java.io.Serializable {
    private java.lang.String disposicionFiscal;

    private java.lang.String norma;

    private java.lang.String textoLeyenda;

    public LeyendaR() {
    }

    public LeyendaR(
           java.lang.String disposicionFiscal,
           java.lang.String norma,
           java.lang.String textoLeyenda) {
           this.disposicionFiscal = disposicionFiscal;
           this.norma = norma;
           this.textoLeyenda = textoLeyenda;
    }


    /**
     * Gets the disposicionFiscal value for this LeyendaR.
     * 
     * @return disposicionFiscal
     */
    public java.lang.String getDisposicionFiscal() {
        return disposicionFiscal;
    }


    /**
     * Sets the disposicionFiscal value for this LeyendaR.
     * 
     * @param disposicionFiscal
     */
    public void setDisposicionFiscal(java.lang.String disposicionFiscal) {
        this.disposicionFiscal = disposicionFiscal;
    }


    /**
     * Gets the norma value for this LeyendaR.
     * 
     * @return norma
     */
    public java.lang.String getNorma() {
        return norma;
    }


    /**
     * Sets the norma value for this LeyendaR.
     * 
     * @param norma
     */
    public void setNorma(java.lang.String norma) {
        this.norma = norma;
    }


    /**
     * Gets the textoLeyenda value for this LeyendaR.
     * 
     * @return textoLeyenda
     */
    public java.lang.String getTextoLeyenda() {
        return textoLeyenda;
    }


    /**
     * Sets the textoLeyenda value for this LeyendaR.
     * 
     * @param textoLeyenda
     */
    public void setTextoLeyenda(java.lang.String textoLeyenda) {
        this.textoLeyenda = textoLeyenda;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LeyendaR)) return false;
        LeyendaR other = (LeyendaR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.disposicionFiscal==null && other.getDisposicionFiscal()==null) || 
             (this.disposicionFiscal!=null &&
              this.disposicionFiscal.equals(other.getDisposicionFiscal()))) &&
            ((this.norma==null && other.getNorma()==null) || 
             (this.norma!=null &&
              this.norma.equals(other.getNorma()))) &&
            ((this.textoLeyenda==null && other.getTextoLeyenda()==null) || 
             (this.textoLeyenda!=null &&
              this.textoLeyenda.equals(other.getTextoLeyenda())));
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
        if (getDisposicionFiscal() != null) {
            _hashCode += getDisposicionFiscal().hashCode();
        }
        if (getNorma() != null) {
            _hashCode += getNorma().hashCode();
        }
        if (getTextoLeyenda() != null) {
            _hashCode += getTextoLeyenda().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LeyendaR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "LeyendaR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disposicionFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DisposicionFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("norma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Norma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textoLeyenda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TextoLeyenda"));
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
