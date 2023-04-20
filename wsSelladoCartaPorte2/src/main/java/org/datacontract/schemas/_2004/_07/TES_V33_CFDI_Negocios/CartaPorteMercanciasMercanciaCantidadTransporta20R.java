/**
 * CartaPorteMercanciasMercanciaCantidadTransporta20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasMercanciaCantidadTransporta20R  implements java.io.Serializable {
    private java.math.BigDecimal cantidad;

    private java.lang.String cvesTransporte;

    private java.lang.String IDDestino;

    private java.lang.String IDOrigen;

    public CartaPorteMercanciasMercanciaCantidadTransporta20R() {
    }

    public CartaPorteMercanciasMercanciaCantidadTransporta20R(
           java.math.BigDecimal cantidad,
           java.lang.String cvesTransporte,
           java.lang.String IDDestino,
           java.lang.String IDOrigen) {
           this.cantidad = cantidad;
           this.cvesTransporte = cvesTransporte;
           this.IDDestino = IDDestino;
           this.IDOrigen = IDOrigen;
    }


    /**
     * Gets the cantidad value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the cvesTransporte value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @return cvesTransporte
     */
    public java.lang.String getCvesTransporte() {
        return cvesTransporte;
    }


    /**
     * Sets the cvesTransporte value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @param cvesTransporte
     */
    public void setCvesTransporte(java.lang.String cvesTransporte) {
        this.cvesTransporte = cvesTransporte;
    }


    /**
     * Gets the IDDestino value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @return IDDestino
     */
    public java.lang.String getIDDestino() {
        return IDDestino;
    }


    /**
     * Sets the IDDestino value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @param IDDestino
     */
    public void setIDDestino(java.lang.String IDDestino) {
        this.IDDestino = IDDestino;
    }


    /**
     * Gets the IDOrigen value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @return IDOrigen
     */
    public java.lang.String getIDOrigen() {
        return IDOrigen;
    }


    /**
     * Sets the IDOrigen value for this CartaPorteMercanciasMercanciaCantidadTransporta20R.
     * 
     * @param IDOrigen
     */
    public void setIDOrigen(java.lang.String IDOrigen) {
        this.IDOrigen = IDOrigen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasMercanciaCantidadTransporta20R)) return false;
        CartaPorteMercanciasMercanciaCantidadTransporta20R other = (CartaPorteMercanciasMercanciaCantidadTransporta20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.cvesTransporte==null && other.getCvesTransporte()==null) || 
             (this.cvesTransporte!=null &&
              this.cvesTransporte.equals(other.getCvesTransporte()))) &&
            ((this.IDDestino==null && other.getIDDestino()==null) || 
             (this.IDDestino!=null &&
              this.IDDestino.equals(other.getIDDestino()))) &&
            ((this.IDOrigen==null && other.getIDOrigen()==null) || 
             (this.IDOrigen!=null &&
              this.IDOrigen.equals(other.getIDOrigen())));
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
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getCvesTransporte() != null) {
            _hashCode += getCvesTransporte().hashCode();
        }
        if (getIDDestino() != null) {
            _hashCode += getIDDestino().hashCode();
        }
        if (getIDOrigen() != null) {
            _hashCode += getIDOrigen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasMercanciaCantidadTransporta20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cvesTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CvesTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IDDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IDOrigen"));
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
