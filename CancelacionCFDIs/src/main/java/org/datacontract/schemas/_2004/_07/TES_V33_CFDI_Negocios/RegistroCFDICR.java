/**
 * RegistroCFDICR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RegistroCFDICR  implements java.io.Serializable {
    private java.lang.String estado;

    private java.util.Calendar fechaTimbrado;

    private java.lang.String RFCReceptor;

    private java.lang.String UUID;

    public RegistroCFDICR() {
    }

    public RegistroCFDICR(
           java.lang.String estado,
           java.util.Calendar fechaTimbrado,
           java.lang.String RFCReceptor,
           java.lang.String UUID) {
           this.estado = estado;
           this.fechaTimbrado = fechaTimbrado;
           this.RFCReceptor = RFCReceptor;
           this.UUID = UUID;
    }


    /**
     * Gets the estado value for this RegistroCFDICR.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this RegistroCFDICR.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaTimbrado value for this RegistroCFDICR.
     * 
     * @return fechaTimbrado
     */
    public java.util.Calendar getFechaTimbrado() {
        return fechaTimbrado;
    }


    /**
     * Sets the fechaTimbrado value for this RegistroCFDICR.
     * 
     * @param fechaTimbrado
     */
    public void setFechaTimbrado(java.util.Calendar fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }


    /**
     * Gets the RFCReceptor value for this RegistroCFDICR.
     * 
     * @return RFCReceptor
     */
    public java.lang.String getRFCReceptor() {
        return RFCReceptor;
    }


    /**
     * Sets the RFCReceptor value for this RegistroCFDICR.
     * 
     * @param RFCReceptor
     */
    public void setRFCReceptor(java.lang.String RFCReceptor) {
        this.RFCReceptor = RFCReceptor;
    }


    /**
     * Gets the UUID value for this RegistroCFDICR.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this RegistroCFDICR.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistroCFDICR)) return false;
        RegistroCFDICR other = (RegistroCFDICR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaTimbrado==null && other.getFechaTimbrado()==null) || 
             (this.fechaTimbrado!=null &&
              this.fechaTimbrado.equals(other.getFechaTimbrado()))) &&
            ((this.RFCReceptor==null && other.getRFCReceptor()==null) || 
             (this.RFCReceptor!=null &&
              this.RFCReceptor.equals(other.getRFCReceptor()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID())));
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaTimbrado() != null) {
            _hashCode += getFechaTimbrado().hashCode();
        }
        if (getRFCReceptor() != null) {
            _hashCode += getRFCReceptor().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistroCFDICR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RegistroCFDICR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTimbrado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaTimbrado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFCReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUID"));
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
