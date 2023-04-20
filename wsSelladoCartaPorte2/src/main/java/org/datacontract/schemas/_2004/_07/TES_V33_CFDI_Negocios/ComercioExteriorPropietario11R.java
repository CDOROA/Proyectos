/**
 * ComercioExteriorPropietario11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ComercioExteriorPropietario11R  implements java.io.Serializable {
    private java.lang.String numRegIdTrib;

    private java.lang.String residenciaFiscal;

    public ComercioExteriorPropietario11R() {
    }

    public ComercioExteriorPropietario11R(
           java.lang.String numRegIdTrib,
           java.lang.String residenciaFiscal) {
           this.numRegIdTrib = numRegIdTrib;
           this.residenciaFiscal = residenciaFiscal;
    }


    /**
     * Gets the numRegIdTrib value for this ComercioExteriorPropietario11R.
     * 
     * @return numRegIdTrib
     */
    public java.lang.String getNumRegIdTrib() {
        return numRegIdTrib;
    }


    /**
     * Sets the numRegIdTrib value for this ComercioExteriorPropietario11R.
     * 
     * @param numRegIdTrib
     */
    public void setNumRegIdTrib(java.lang.String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }


    /**
     * Gets the residenciaFiscal value for this ComercioExteriorPropietario11R.
     * 
     * @return residenciaFiscal
     */
    public java.lang.String getResidenciaFiscal() {
        return residenciaFiscal;
    }


    /**
     * Sets the residenciaFiscal value for this ComercioExteriorPropietario11R.
     * 
     * @param residenciaFiscal
     */
    public void setResidenciaFiscal(java.lang.String residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExteriorPropietario11R)) return false;
        ComercioExteriorPropietario11R other = (ComercioExteriorPropietario11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numRegIdTrib==null && other.getNumRegIdTrib()==null) || 
             (this.numRegIdTrib!=null &&
              this.numRegIdTrib.equals(other.getNumRegIdTrib()))) &&
            ((this.residenciaFiscal==null && other.getResidenciaFiscal()==null) || 
             (this.residenciaFiscal!=null &&
              this.residenciaFiscal.equals(other.getResidenciaFiscal())));
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
        if (getNumRegIdTrib() != null) {
            _hashCode += getNumRegIdTrib().hashCode();
        }
        if (getResidenciaFiscal() != null) {
            _hashCode += getResidenciaFiscal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExteriorPropietario11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numRegIdTrib");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumRegIdTrib"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("residenciaFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ResidenciaFiscal"));
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
