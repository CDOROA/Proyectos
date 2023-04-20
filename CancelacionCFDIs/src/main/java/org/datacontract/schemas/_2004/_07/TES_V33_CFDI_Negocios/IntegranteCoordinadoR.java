/**
 * IntegranteCoordinadoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IntegranteCoordinadoR  implements java.io.Serializable {
    private java.lang.String claveVehicular;

    private java.lang.String placa;

    private java.lang.String RFCPF;

    public IntegranteCoordinadoR() {
    }

    public IntegranteCoordinadoR(
           java.lang.String claveVehicular,
           java.lang.String placa,
           java.lang.String RFCPF) {
           this.claveVehicular = claveVehicular;
           this.placa = placa;
           this.RFCPF = RFCPF;
    }


    /**
     * Gets the claveVehicular value for this IntegranteCoordinadoR.
     * 
     * @return claveVehicular
     */
    public java.lang.String getClaveVehicular() {
        return claveVehicular;
    }


    /**
     * Sets the claveVehicular value for this IntegranteCoordinadoR.
     * 
     * @param claveVehicular
     */
    public void setClaveVehicular(java.lang.String claveVehicular) {
        this.claveVehicular = claveVehicular;
    }


    /**
     * Gets the placa value for this IntegranteCoordinadoR.
     * 
     * @return placa
     */
    public java.lang.String getPlaca() {
        return placa;
    }


    /**
     * Sets the placa value for this IntegranteCoordinadoR.
     * 
     * @param placa
     */
    public void setPlaca(java.lang.String placa) {
        this.placa = placa;
    }


    /**
     * Gets the RFCPF value for this IntegranteCoordinadoR.
     * 
     * @return RFCPF
     */
    public java.lang.String getRFCPF() {
        return RFCPF;
    }


    /**
     * Sets the RFCPF value for this IntegranteCoordinadoR.
     * 
     * @param RFCPF
     */
    public void setRFCPF(java.lang.String RFCPF) {
        this.RFCPF = RFCPF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IntegranteCoordinadoR)) return false;
        IntegranteCoordinadoR other = (IntegranteCoordinadoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveVehicular==null && other.getClaveVehicular()==null) || 
             (this.claveVehicular!=null &&
              this.claveVehicular.equals(other.getClaveVehicular()))) &&
            ((this.placa==null && other.getPlaca()==null) || 
             (this.placa!=null &&
              this.placa.equals(other.getPlaca()))) &&
            ((this.RFCPF==null && other.getRFCPF()==null) || 
             (this.RFCPF!=null &&
              this.RFCPF.equals(other.getRFCPF())));
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
        if (getClaveVehicular() != null) {
            _hashCode += getClaveVehicular().hashCode();
        }
        if (getPlaca() != null) {
            _hashCode += getPlaca().hashCode();
        }
        if (getRFCPF() != null) {
            _hashCode += getRFCPF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IntegranteCoordinadoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IntegranteCoordinadoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Placa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCPF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFCPF"));
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
