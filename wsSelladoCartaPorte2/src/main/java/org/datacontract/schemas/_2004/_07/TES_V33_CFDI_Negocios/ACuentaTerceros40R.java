/**
 * ACuentaTerceros40R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ACuentaTerceros40R  implements java.io.Serializable {
    private java.lang.String domicilioFiscalACuentaTerceros;

    private java.lang.String nombreACuentaTerceros;

    private java.lang.String regimenFiscalACuentaTerceros;

    private java.lang.String rfcACuentaTerceros;

    public ACuentaTerceros40R() {
    }

    public ACuentaTerceros40R(
           java.lang.String domicilioFiscalACuentaTerceros,
           java.lang.String nombreACuentaTerceros,
           java.lang.String regimenFiscalACuentaTerceros,
           java.lang.String rfcACuentaTerceros) {
           this.domicilioFiscalACuentaTerceros = domicilioFiscalACuentaTerceros;
           this.nombreACuentaTerceros = nombreACuentaTerceros;
           this.regimenFiscalACuentaTerceros = regimenFiscalACuentaTerceros;
           this.rfcACuentaTerceros = rfcACuentaTerceros;
    }


    /**
     * Gets the domicilioFiscalACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @return domicilioFiscalACuentaTerceros
     */
    public java.lang.String getDomicilioFiscalACuentaTerceros() {
        return domicilioFiscalACuentaTerceros;
    }


    /**
     * Sets the domicilioFiscalACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @param domicilioFiscalACuentaTerceros
     */
    public void setDomicilioFiscalACuentaTerceros(java.lang.String domicilioFiscalACuentaTerceros) {
        this.domicilioFiscalACuentaTerceros = domicilioFiscalACuentaTerceros;
    }


    /**
     * Gets the nombreACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @return nombreACuentaTerceros
     */
    public java.lang.String getNombreACuentaTerceros() {
        return nombreACuentaTerceros;
    }


    /**
     * Sets the nombreACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @param nombreACuentaTerceros
     */
    public void setNombreACuentaTerceros(java.lang.String nombreACuentaTerceros) {
        this.nombreACuentaTerceros = nombreACuentaTerceros;
    }


    /**
     * Gets the regimenFiscalACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @return regimenFiscalACuentaTerceros
     */
    public java.lang.String getRegimenFiscalACuentaTerceros() {
        return regimenFiscalACuentaTerceros;
    }


    /**
     * Sets the regimenFiscalACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @param regimenFiscalACuentaTerceros
     */
    public void setRegimenFiscalACuentaTerceros(java.lang.String regimenFiscalACuentaTerceros) {
        this.regimenFiscalACuentaTerceros = regimenFiscalACuentaTerceros;
    }


    /**
     * Gets the rfcACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @return rfcACuentaTerceros
     */
    public java.lang.String getRfcACuentaTerceros() {
        return rfcACuentaTerceros;
    }


    /**
     * Sets the rfcACuentaTerceros value for this ACuentaTerceros40R.
     * 
     * @param rfcACuentaTerceros
     */
    public void setRfcACuentaTerceros(java.lang.String rfcACuentaTerceros) {
        this.rfcACuentaTerceros = rfcACuentaTerceros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ACuentaTerceros40R)) return false;
        ACuentaTerceros40R other = (ACuentaTerceros40R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domicilioFiscalACuentaTerceros==null && other.getDomicilioFiscalACuentaTerceros()==null) || 
             (this.domicilioFiscalACuentaTerceros!=null &&
              this.domicilioFiscalACuentaTerceros.equals(other.getDomicilioFiscalACuentaTerceros()))) &&
            ((this.nombreACuentaTerceros==null && other.getNombreACuentaTerceros()==null) || 
             (this.nombreACuentaTerceros!=null &&
              this.nombreACuentaTerceros.equals(other.getNombreACuentaTerceros()))) &&
            ((this.regimenFiscalACuentaTerceros==null && other.getRegimenFiscalACuentaTerceros()==null) || 
             (this.regimenFiscalACuentaTerceros!=null &&
              this.regimenFiscalACuentaTerceros.equals(other.getRegimenFiscalACuentaTerceros()))) &&
            ((this.rfcACuentaTerceros==null && other.getRfcACuentaTerceros()==null) || 
             (this.rfcACuentaTerceros!=null &&
              this.rfcACuentaTerceros.equals(other.getRfcACuentaTerceros())));
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
        if (getDomicilioFiscalACuentaTerceros() != null) {
            _hashCode += getDomicilioFiscalACuentaTerceros().hashCode();
        }
        if (getNombreACuentaTerceros() != null) {
            _hashCode += getNombreACuentaTerceros().hashCode();
        }
        if (getRegimenFiscalACuentaTerceros() != null) {
            _hashCode += getRegimenFiscalACuentaTerceros().hashCode();
        }
        if (getRfcACuentaTerceros() != null) {
            _hashCode += getRfcACuentaTerceros().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ACuentaTerceros40R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ACuentaTerceros40R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioFiscalACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioFiscalACuentaTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreACuentaTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimenFiscalACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegimenFiscalACuentaTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcACuentaTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcACuentaTerceros"));
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
