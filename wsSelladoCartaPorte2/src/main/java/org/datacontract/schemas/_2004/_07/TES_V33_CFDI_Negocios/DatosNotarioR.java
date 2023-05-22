/**
 * DatosNotarioR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatosNotarioR  implements java.io.Serializable {
    private java.lang.String adscripcion;

    private java.lang.String CURP;

    private java.lang.String entidadFederativa;

    private java.lang.Integer numNotaria;

    public DatosNotarioR() {
    }

    public DatosNotarioR(
           java.lang.String adscripcion,
           java.lang.String CURP,
           java.lang.String entidadFederativa,
           java.lang.Integer numNotaria) {
           this.adscripcion = adscripcion;
           this.CURP = CURP;
           this.entidadFederativa = entidadFederativa;
           this.numNotaria = numNotaria;
    }


    /**
     * Gets the adscripcion value for this DatosNotarioR.
     * 
     * @return adscripcion
     */
    public java.lang.String getAdscripcion() {
        return adscripcion;
    }


    /**
     * Sets the adscripcion value for this DatosNotarioR.
     * 
     * @param adscripcion
     */
    public void setAdscripcion(java.lang.String adscripcion) {
        this.adscripcion = adscripcion;
    }


    /**
     * Gets the CURP value for this DatosNotarioR.
     * 
     * @return CURP
     */
    public java.lang.String getCURP() {
        return CURP;
    }


    /**
     * Sets the CURP value for this DatosNotarioR.
     * 
     * @param CURP
     */
    public void setCURP(java.lang.String CURP) {
        this.CURP = CURP;
    }


    /**
     * Gets the entidadFederativa value for this DatosNotarioR.
     * 
     * @return entidadFederativa
     */
    public java.lang.String getEntidadFederativa() {
        return entidadFederativa;
    }


    /**
     * Sets the entidadFederativa value for this DatosNotarioR.
     * 
     * @param entidadFederativa
     */
    public void setEntidadFederativa(java.lang.String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }


    /**
     * Gets the numNotaria value for this DatosNotarioR.
     * 
     * @return numNotaria
     */
    public java.lang.Integer getNumNotaria() {
        return numNotaria;
    }


    /**
     * Sets the numNotaria value for this DatosNotarioR.
     * 
     * @param numNotaria
     */
    public void setNumNotaria(java.lang.Integer numNotaria) {
        this.numNotaria = numNotaria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosNotarioR)) return false;
        DatosNotarioR other = (DatosNotarioR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adscripcion==null && other.getAdscripcion()==null) || 
             (this.adscripcion!=null &&
              this.adscripcion.equals(other.getAdscripcion()))) &&
            ((this.CURP==null && other.getCURP()==null) || 
             (this.CURP!=null &&
              this.CURP.equals(other.getCURP()))) &&
            ((this.entidadFederativa==null && other.getEntidadFederativa()==null) || 
             (this.entidadFederativa!=null &&
              this.entidadFederativa.equals(other.getEntidadFederativa()))) &&
            ((this.numNotaria==null && other.getNumNotaria()==null) || 
             (this.numNotaria!=null &&
              this.numNotaria.equals(other.getNumNotaria())));
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
        if (getAdscripcion() != null) {
            _hashCode += getAdscripcion().hashCode();
        }
        if (getCURP() != null) {
            _hashCode += getCURP().hashCode();
        }
        if (getEntidadFederativa() != null) {
            _hashCode += getEntidadFederativa().hashCode();
        }
        if (getNumNotaria() != null) {
            _hashCode += getNumNotaria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosNotarioR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosNotarioR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adscripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Adscripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CURP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidadFederativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadFederativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numNotaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumNotaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
