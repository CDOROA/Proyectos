/**
 * CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R  implements java.io.Serializable {
    private java.math.BigDecimal kilometrajePagado;

    private java.lang.String tipoDerechoDePaso;

    public CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R() {
    }

    public CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R(
           java.math.BigDecimal kilometrajePagado,
           java.lang.String tipoDerechoDePaso) {
           this.kilometrajePagado = kilometrajePagado;
           this.tipoDerechoDePaso = tipoDerechoDePaso;
    }


    /**
     * Gets the kilometrajePagado value for this CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.
     * 
     * @return kilometrajePagado
     */
    public java.math.BigDecimal getKilometrajePagado() {
        return kilometrajePagado;
    }


    /**
     * Sets the kilometrajePagado value for this CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.
     * 
     * @param kilometrajePagado
     */
    public void setKilometrajePagado(java.math.BigDecimal kilometrajePagado) {
        this.kilometrajePagado = kilometrajePagado;
    }


    /**
     * Gets the tipoDerechoDePaso value for this CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.
     * 
     * @return tipoDerechoDePaso
     */
    public java.lang.String getTipoDerechoDePaso() {
        return tipoDerechoDePaso;
    }


    /**
     * Sets the tipoDerechoDePaso value for this CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.
     * 
     * @param tipoDerechoDePaso
     */
    public void setTipoDerechoDePaso(java.lang.String tipoDerechoDePaso) {
        this.tipoDerechoDePaso = tipoDerechoDePaso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R)) return false;
        CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R other = (CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.kilometrajePagado==null && other.getKilometrajePagado()==null) || 
             (this.kilometrajePagado!=null &&
              this.kilometrajePagado.equals(other.getKilometrajePagado()))) &&
            ((this.tipoDerechoDePaso==null && other.getTipoDerechoDePaso()==null) || 
             (this.tipoDerechoDePaso!=null &&
              this.tipoDerechoDePaso.equals(other.getTipoDerechoDePaso())));
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
        if (getKilometrajePagado() != null) {
            _hashCode += getKilometrajePagado().hashCode();
        }
        if (getTipoDerechoDePaso() != null) {
            _hashCode += getTipoDerechoDePaso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kilometrajePagado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "KilometrajePagado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDerechoDePaso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TipoDerechoDePaso"));
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
