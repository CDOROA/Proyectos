/**
 * ComercioExteriorReceptor11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ComercioExteriorReceptor11R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptorDomicilio11R domicilio;

    private java.lang.String numRegIdTrib;

    public ComercioExteriorReceptor11R() {
    }

    public ComercioExteriorReceptor11R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptorDomicilio11R domicilio,
           java.lang.String numRegIdTrib) {
           this.domicilio = domicilio;
           this.numRegIdTrib = numRegIdTrib;
    }


    /**
     * Gets the domicilio value for this ComercioExteriorReceptor11R.
     * 
     * @return domicilio
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptorDomicilio11R getDomicilio() {
        return domicilio;
    }


    /**
     * Sets the domicilio value for this ComercioExteriorReceptor11R.
     * 
     * @param domicilio
     */
    public void setDomicilio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptorDomicilio11R domicilio) {
        this.domicilio = domicilio;
    }


    /**
     * Gets the numRegIdTrib value for this ComercioExteriorReceptor11R.
     * 
     * @return numRegIdTrib
     */
    public java.lang.String getNumRegIdTrib() {
        return numRegIdTrib;
    }


    /**
     * Sets the numRegIdTrib value for this ComercioExteriorReceptor11R.
     * 
     * @param numRegIdTrib
     */
    public void setNumRegIdTrib(java.lang.String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExteriorReceptor11R)) return false;
        ComercioExteriorReceptor11R other = (ComercioExteriorReceptor11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domicilio==null && other.getDomicilio()==null) || 
             (this.domicilio!=null &&
              this.domicilio.equals(other.getDomicilio()))) &&
            ((this.numRegIdTrib==null && other.getNumRegIdTrib()==null) || 
             (this.numRegIdTrib!=null &&
              this.numRegIdTrib.equals(other.getNumRegIdTrib())));
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
        if (getDomicilio() != null) {
            _hashCode += getDomicilio().hashCode();
        }
        if (getNumRegIdTrib() != null) {
            _hashCode += getNumRegIdTrib().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExteriorReceptor11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorReceptor11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Domicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorReceptorDomicilio11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numRegIdTrib");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumRegIdTrib"));
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
