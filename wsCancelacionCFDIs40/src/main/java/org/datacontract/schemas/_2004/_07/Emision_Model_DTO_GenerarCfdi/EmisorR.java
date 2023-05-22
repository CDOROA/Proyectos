/**
 * EmisorR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class EmisorR  implements java.io.Serializable {
    private java.lang.String facAtrAdquirente;

    private java.lang.String nombre;

    private java.lang.String regimenFiscal;

    private java.lang.String rfc;

    public EmisorR() {
    }

    public EmisorR(
           java.lang.String facAtrAdquirente,
           java.lang.String nombre,
           java.lang.String regimenFiscal,
           java.lang.String rfc) {
           this.facAtrAdquirente = facAtrAdquirente;
           this.nombre = nombre;
           this.regimenFiscal = regimenFiscal;
           this.rfc = rfc;
    }


    /**
     * Gets the facAtrAdquirente value for this EmisorR.
     * 
     * @return facAtrAdquirente
     */
    public java.lang.String getFacAtrAdquirente() {
        return facAtrAdquirente;
    }


    /**
     * Sets the facAtrAdquirente value for this EmisorR.
     * 
     * @param facAtrAdquirente
     */
    public void setFacAtrAdquirente(java.lang.String facAtrAdquirente) {
        this.facAtrAdquirente = facAtrAdquirente;
    }


    /**
     * Gets the nombre value for this EmisorR.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this EmisorR.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the regimenFiscal value for this EmisorR.
     * 
     * @return regimenFiscal
     */
    public java.lang.String getRegimenFiscal() {
        return regimenFiscal;
    }


    /**
     * Sets the regimenFiscal value for this EmisorR.
     * 
     * @param regimenFiscal
     */
    public void setRegimenFiscal(java.lang.String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }


    /**
     * Gets the rfc value for this EmisorR.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this EmisorR.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmisorR)) return false;
        EmisorR other = (EmisorR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.facAtrAdquirente==null && other.getFacAtrAdquirente()==null) || 
             (this.facAtrAdquirente!=null &&
              this.facAtrAdquirente.equals(other.getFacAtrAdquirente()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.regimenFiscal==null && other.getRegimenFiscal()==null) || 
             (this.regimenFiscal!=null &&
              this.regimenFiscal.equals(other.getRegimenFiscal()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc())));
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
        if (getFacAtrAdquirente() != null) {
            _hashCode += getFacAtrAdquirente().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getRegimenFiscal() != null) {
            _hashCode += getRegimenFiscal().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmisorR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "EmisorR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("facAtrAdquirente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "FacAtrAdquirente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimenFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "RegimenFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Rfc"));
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
