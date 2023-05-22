/**
 * EmisorNomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class EmisorNomina12R  implements java.io.Serializable {
    private java.lang.String CURP;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadSNCFR entidadSNCFR;

    private java.lang.String registroPatronal;

    private java.lang.String rfcPatronOrigen;

    public EmisorNomina12R() {
    }

    public EmisorNomina12R(
           java.lang.String CURP,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadSNCFR entidadSNCFR,
           java.lang.String registroPatronal,
           java.lang.String rfcPatronOrigen) {
           this.CURP = CURP;
           this.entidadSNCFR = entidadSNCFR;
           this.registroPatronal = registroPatronal;
           this.rfcPatronOrigen = rfcPatronOrigen;
    }


    /**
     * Gets the CURP value for this EmisorNomina12R.
     * 
     * @return CURP
     */
    public java.lang.String getCURP() {
        return CURP;
    }


    /**
     * Sets the CURP value for this EmisorNomina12R.
     * 
     * @param CURP
     */
    public void setCURP(java.lang.String CURP) {
        this.CURP = CURP;
    }


    /**
     * Gets the entidadSNCFR value for this EmisorNomina12R.
     * 
     * @return entidadSNCFR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadSNCFR getEntidadSNCFR() {
        return entidadSNCFR;
    }


    /**
     * Sets the entidadSNCFR value for this EmisorNomina12R.
     * 
     * @param entidadSNCFR
     */
    public void setEntidadSNCFR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadSNCFR entidadSNCFR) {
        this.entidadSNCFR = entidadSNCFR;
    }


    /**
     * Gets the registroPatronal value for this EmisorNomina12R.
     * 
     * @return registroPatronal
     */
    public java.lang.String getRegistroPatronal() {
        return registroPatronal;
    }


    /**
     * Sets the registroPatronal value for this EmisorNomina12R.
     * 
     * @param registroPatronal
     */
    public void setRegistroPatronal(java.lang.String registroPatronal) {
        this.registroPatronal = registroPatronal;
    }


    /**
     * Gets the rfcPatronOrigen value for this EmisorNomina12R.
     * 
     * @return rfcPatronOrigen
     */
    public java.lang.String getRfcPatronOrigen() {
        return rfcPatronOrigen;
    }


    /**
     * Sets the rfcPatronOrigen value for this EmisorNomina12R.
     * 
     * @param rfcPatronOrigen
     */
    public void setRfcPatronOrigen(java.lang.String rfcPatronOrigen) {
        this.rfcPatronOrigen = rfcPatronOrigen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmisorNomina12R)) return false;
        EmisorNomina12R other = (EmisorNomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CURP==null && other.getCURP()==null) || 
             (this.CURP!=null &&
              this.CURP.equals(other.getCURP()))) &&
            ((this.entidadSNCFR==null && other.getEntidadSNCFR()==null) || 
             (this.entidadSNCFR!=null &&
              this.entidadSNCFR.equals(other.getEntidadSNCFR()))) &&
            ((this.registroPatronal==null && other.getRegistroPatronal()==null) || 
             (this.registroPatronal!=null &&
              this.registroPatronal.equals(other.getRegistroPatronal()))) &&
            ((this.rfcPatronOrigen==null && other.getRfcPatronOrigen()==null) || 
             (this.rfcPatronOrigen!=null &&
              this.rfcPatronOrigen.equals(other.getRfcPatronOrigen())));
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
        if (getCURP() != null) {
            _hashCode += getCURP().hashCode();
        }
        if (getEntidadSNCFR() != null) {
            _hashCode += getEntidadSNCFR().hashCode();
        }
        if (getRegistroPatronal() != null) {
            _hashCode += getRegistroPatronal().hashCode();
        }
        if (getRfcPatronOrigen() != null) {
            _hashCode += getRfcPatronOrigen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmisorNomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorNomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CURP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidadSNCFR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadSNCFR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadSNCFR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registroPatronal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroPatronal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcPatronOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcPatronOrigen"));
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
