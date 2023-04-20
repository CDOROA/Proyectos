/**
 * CartaPorteMercanciasAutotransporteSeguros20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercanciasAutotransporteSeguros20R  implements java.io.Serializable {
    private java.lang.String aseguraCarga;

    private java.lang.String aseguraMedAmbiente;

    private java.lang.String aseguraRespCivil;

    private java.lang.String polizaCarga;

    private java.lang.String polizaMedAmbiente;

    private java.lang.String polizaRespCivil;

    private java.math.BigDecimal primaSeguro;

    public CartaPorteMercanciasAutotransporteSeguros20R() {
    }

    public CartaPorteMercanciasAutotransporteSeguros20R(
           java.lang.String aseguraCarga,
           java.lang.String aseguraMedAmbiente,
           java.lang.String aseguraRespCivil,
           java.lang.String polizaCarga,
           java.lang.String polizaMedAmbiente,
           java.lang.String polizaRespCivil,
           java.math.BigDecimal primaSeguro) {
           this.aseguraCarga = aseguraCarga;
           this.aseguraMedAmbiente = aseguraMedAmbiente;
           this.aseguraRespCivil = aseguraRespCivil;
           this.polizaCarga = polizaCarga;
           this.polizaMedAmbiente = polizaMedAmbiente;
           this.polizaRespCivil = polizaRespCivil;
           this.primaSeguro = primaSeguro;
    }


    /**
     * Gets the aseguraCarga value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return aseguraCarga
     */
    public java.lang.String getAseguraCarga() {
        return aseguraCarga;
    }


    /**
     * Sets the aseguraCarga value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param aseguraCarga
     */
    public void setAseguraCarga(java.lang.String aseguraCarga) {
        this.aseguraCarga = aseguraCarga;
    }


    /**
     * Gets the aseguraMedAmbiente value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return aseguraMedAmbiente
     */
    public java.lang.String getAseguraMedAmbiente() {
        return aseguraMedAmbiente;
    }


    /**
     * Sets the aseguraMedAmbiente value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param aseguraMedAmbiente
     */
    public void setAseguraMedAmbiente(java.lang.String aseguraMedAmbiente) {
        this.aseguraMedAmbiente = aseguraMedAmbiente;
    }


    /**
     * Gets the aseguraRespCivil value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return aseguraRespCivil
     */
    public java.lang.String getAseguraRespCivil() {
        return aseguraRespCivil;
    }


    /**
     * Sets the aseguraRespCivil value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param aseguraRespCivil
     */
    public void setAseguraRespCivil(java.lang.String aseguraRespCivil) {
        this.aseguraRespCivil = aseguraRespCivil;
    }


    /**
     * Gets the polizaCarga value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return polizaCarga
     */
    public java.lang.String getPolizaCarga() {
        return polizaCarga;
    }


    /**
     * Sets the polizaCarga value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param polizaCarga
     */
    public void setPolizaCarga(java.lang.String polizaCarga) {
        this.polizaCarga = polizaCarga;
    }


    /**
     * Gets the polizaMedAmbiente value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return polizaMedAmbiente
     */
    public java.lang.String getPolizaMedAmbiente() {
        return polizaMedAmbiente;
    }


    /**
     * Sets the polizaMedAmbiente value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param polizaMedAmbiente
     */
    public void setPolizaMedAmbiente(java.lang.String polizaMedAmbiente) {
        this.polizaMedAmbiente = polizaMedAmbiente;
    }


    /**
     * Gets the polizaRespCivil value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return polizaRespCivil
     */
    public java.lang.String getPolizaRespCivil() {
        return polizaRespCivil;
    }


    /**
     * Sets the polizaRespCivil value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param polizaRespCivil
     */
    public void setPolizaRespCivil(java.lang.String polizaRespCivil) {
        this.polizaRespCivil = polizaRespCivil;
    }


    /**
     * Gets the primaSeguro value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @return primaSeguro
     */
    public java.math.BigDecimal getPrimaSeguro() {
        return primaSeguro;
    }


    /**
     * Sets the primaSeguro value for this CartaPorteMercanciasAutotransporteSeguros20R.
     * 
     * @param primaSeguro
     */
    public void setPrimaSeguro(java.math.BigDecimal primaSeguro) {
        this.primaSeguro = primaSeguro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasAutotransporteSeguros20R)) return false;
        CartaPorteMercanciasAutotransporteSeguros20R other = (CartaPorteMercanciasAutotransporteSeguros20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aseguraCarga==null && other.getAseguraCarga()==null) || 
             (this.aseguraCarga!=null &&
              this.aseguraCarga.equals(other.getAseguraCarga()))) &&
            ((this.aseguraMedAmbiente==null && other.getAseguraMedAmbiente()==null) || 
             (this.aseguraMedAmbiente!=null &&
              this.aseguraMedAmbiente.equals(other.getAseguraMedAmbiente()))) &&
            ((this.aseguraRespCivil==null && other.getAseguraRespCivil()==null) || 
             (this.aseguraRespCivil!=null &&
              this.aseguraRespCivil.equals(other.getAseguraRespCivil()))) &&
            ((this.polizaCarga==null && other.getPolizaCarga()==null) || 
             (this.polizaCarga!=null &&
              this.polizaCarga.equals(other.getPolizaCarga()))) &&
            ((this.polizaMedAmbiente==null && other.getPolizaMedAmbiente()==null) || 
             (this.polizaMedAmbiente!=null &&
              this.polizaMedAmbiente.equals(other.getPolizaMedAmbiente()))) &&
            ((this.polizaRespCivil==null && other.getPolizaRespCivil()==null) || 
             (this.polizaRespCivil!=null &&
              this.polizaRespCivil.equals(other.getPolizaRespCivil()))) &&
            ((this.primaSeguro==null && other.getPrimaSeguro()==null) || 
             (this.primaSeguro!=null &&
              this.primaSeguro.equals(other.getPrimaSeguro())));
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
        if (getAseguraCarga() != null) {
            _hashCode += getAseguraCarga().hashCode();
        }
        if (getAseguraMedAmbiente() != null) {
            _hashCode += getAseguraMedAmbiente().hashCode();
        }
        if (getAseguraRespCivil() != null) {
            _hashCode += getAseguraRespCivil().hashCode();
        }
        if (getPolizaCarga() != null) {
            _hashCode += getPolizaCarga().hashCode();
        }
        if (getPolizaMedAmbiente() != null) {
            _hashCode += getPolizaMedAmbiente().hashCode();
        }
        if (getPolizaRespCivil() != null) {
            _hashCode += getPolizaRespCivil().hashCode();
        }
        if (getPrimaSeguro() != null) {
            _hashCode += getPrimaSeguro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasAutotransporteSeguros20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteSeguros20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aseguraCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "AseguraCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aseguraMedAmbiente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "AseguraMedAmbiente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aseguraRespCivil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "AseguraRespCivil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polizaCarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PolizaCarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polizaMedAmbiente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PolizaMedAmbiente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polizaRespCivil");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PolizaRespCivil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaSeguro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PrimaSeguro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
