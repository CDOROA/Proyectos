/**
 * CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R  implements java.io.Serializable {
    private java.math.BigDecimal pesoContenedorVacio;

    private java.math.BigDecimal pesoNetoMercancia;

    private java.lang.String tipoContenedor;

    public CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R() {
    }

    public CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R(
           java.math.BigDecimal pesoContenedorVacio,
           java.math.BigDecimal pesoNetoMercancia,
           java.lang.String tipoContenedor) {
           this.pesoContenedorVacio = pesoContenedorVacio;
           this.pesoNetoMercancia = pesoNetoMercancia;
           this.tipoContenedor = tipoContenedor;
    }


    /**
     * Gets the pesoContenedorVacio value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @return pesoContenedorVacio
     */
    public java.math.BigDecimal getPesoContenedorVacio() {
        return pesoContenedorVacio;
    }


    /**
     * Sets the pesoContenedorVacio value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @param pesoContenedorVacio
     */
    public void setPesoContenedorVacio(java.math.BigDecimal pesoContenedorVacio) {
        this.pesoContenedorVacio = pesoContenedorVacio;
    }


    /**
     * Gets the pesoNetoMercancia value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @return pesoNetoMercancia
     */
    public java.math.BigDecimal getPesoNetoMercancia() {
        return pesoNetoMercancia;
    }


    /**
     * Sets the pesoNetoMercancia value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @param pesoNetoMercancia
     */
    public void setPesoNetoMercancia(java.math.BigDecimal pesoNetoMercancia) {
        this.pesoNetoMercancia = pesoNetoMercancia;
    }


    /**
     * Gets the tipoContenedor value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @return tipoContenedor
     */
    public java.lang.String getTipoContenedor() {
        return tipoContenedor;
    }


    /**
     * Sets the tipoContenedor value for this CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.
     * 
     * @param tipoContenedor
     */
    public void setTipoContenedor(java.lang.String tipoContenedor) {
        this.tipoContenedor = tipoContenedor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R)) return false;
        CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R other = (CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pesoContenedorVacio==null && other.getPesoContenedorVacio()==null) || 
             (this.pesoContenedorVacio!=null &&
              this.pesoContenedorVacio.equals(other.getPesoContenedorVacio()))) &&
            ((this.pesoNetoMercancia==null && other.getPesoNetoMercancia()==null) || 
             (this.pesoNetoMercancia!=null &&
              this.pesoNetoMercancia.equals(other.getPesoNetoMercancia()))) &&
            ((this.tipoContenedor==null && other.getTipoContenedor()==null) || 
             (this.tipoContenedor!=null &&
              this.tipoContenedor.equals(other.getTipoContenedor())));
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
        if (getPesoContenedorVacio() != null) {
            _hashCode += getPesoContenedorVacio().hashCode();
        }
        if (getPesoNetoMercancia() != null) {
            _hashCode += getPesoNetoMercancia().hashCode();
        }
        if (getTipoContenedor() != null) {
            _hashCode += getTipoContenedor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoContenedorVacio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoContenedorVacio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoNetoMercancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoNetoMercancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoContenedor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoContenedor"));
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
