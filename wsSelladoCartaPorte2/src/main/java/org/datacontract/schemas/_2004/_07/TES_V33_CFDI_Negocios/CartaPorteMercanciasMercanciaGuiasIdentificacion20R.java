/**
 * CartaPorteMercanciasMercanciaGuiasIdentificacion20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasMercanciaGuiasIdentificacion20R  implements java.io.Serializable {
    private java.lang.String descripGuiaIdentificacion;

    private java.lang.String numeroGuiaIdentificacion;

    private java.math.BigDecimal pesoGuiaIdentificacion;

    public CartaPorteMercanciasMercanciaGuiasIdentificacion20R() {
    }

    public CartaPorteMercanciasMercanciaGuiasIdentificacion20R(
           java.lang.String descripGuiaIdentificacion,
           java.lang.String numeroGuiaIdentificacion,
           java.math.BigDecimal pesoGuiaIdentificacion) {
           this.descripGuiaIdentificacion = descripGuiaIdentificacion;
           this.numeroGuiaIdentificacion = numeroGuiaIdentificacion;
           this.pesoGuiaIdentificacion = pesoGuiaIdentificacion;
    }


    /**
     * Gets the descripGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @return descripGuiaIdentificacion
     */
    public java.lang.String getDescripGuiaIdentificacion() {
        return descripGuiaIdentificacion;
    }


    /**
     * Sets the descripGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @param descripGuiaIdentificacion
     */
    public void setDescripGuiaIdentificacion(java.lang.String descripGuiaIdentificacion) {
        this.descripGuiaIdentificacion = descripGuiaIdentificacion;
    }


    /**
     * Gets the numeroGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @return numeroGuiaIdentificacion
     */
    public java.lang.String getNumeroGuiaIdentificacion() {
        return numeroGuiaIdentificacion;
    }


    /**
     * Sets the numeroGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @param numeroGuiaIdentificacion
     */
    public void setNumeroGuiaIdentificacion(java.lang.String numeroGuiaIdentificacion) {
        this.numeroGuiaIdentificacion = numeroGuiaIdentificacion;
    }


    /**
     * Gets the pesoGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @return pesoGuiaIdentificacion
     */
    public java.math.BigDecimal getPesoGuiaIdentificacion() {
        return pesoGuiaIdentificacion;
    }


    /**
     * Sets the pesoGuiaIdentificacion value for this CartaPorteMercanciasMercanciaGuiasIdentificacion20R.
     * 
     * @param pesoGuiaIdentificacion
     */
    public void setPesoGuiaIdentificacion(java.math.BigDecimal pesoGuiaIdentificacion) {
        this.pesoGuiaIdentificacion = pesoGuiaIdentificacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasMercanciaGuiasIdentificacion20R)) return false;
        CartaPorteMercanciasMercanciaGuiasIdentificacion20R other = (CartaPorteMercanciasMercanciaGuiasIdentificacion20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripGuiaIdentificacion==null && other.getDescripGuiaIdentificacion()==null) || 
             (this.descripGuiaIdentificacion!=null &&
              this.descripGuiaIdentificacion.equals(other.getDescripGuiaIdentificacion()))) &&
            ((this.numeroGuiaIdentificacion==null && other.getNumeroGuiaIdentificacion()==null) || 
             (this.numeroGuiaIdentificacion!=null &&
              this.numeroGuiaIdentificacion.equals(other.getNumeroGuiaIdentificacion()))) &&
            ((this.pesoGuiaIdentificacion==null && other.getPesoGuiaIdentificacion()==null) || 
             (this.pesoGuiaIdentificacion!=null &&
              this.pesoGuiaIdentificacion.equals(other.getPesoGuiaIdentificacion())));
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
        if (getDescripGuiaIdentificacion() != null) {
            _hashCode += getDescripGuiaIdentificacion().hashCode();
        }
        if (getNumeroGuiaIdentificacion() != null) {
            _hashCode += getNumeroGuiaIdentificacion().hashCode();
        }
        if (getPesoGuiaIdentificacion() != null) {
            _hashCode += getPesoGuiaIdentificacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasMercanciaGuiasIdentificacion20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripGuiaIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescripGuiaIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroGuiaIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroGuiaIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoGuiaIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoGuiaIdentificacion"));
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
