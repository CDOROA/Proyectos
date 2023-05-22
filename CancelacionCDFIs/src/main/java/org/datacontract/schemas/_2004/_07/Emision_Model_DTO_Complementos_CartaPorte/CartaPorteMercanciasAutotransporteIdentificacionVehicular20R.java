/**
 * CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercanciasAutotransporteIdentificacionVehicular20R  implements java.io.Serializable {
    private java.lang.Integer anioModeloVM;

    private java.lang.String configVehicular;

    private java.lang.String placaVM;

    public CartaPorteMercanciasAutotransporteIdentificacionVehicular20R() {
    }

    public CartaPorteMercanciasAutotransporteIdentificacionVehicular20R(
           java.lang.Integer anioModeloVM,
           java.lang.String configVehicular,
           java.lang.String placaVM) {
           this.anioModeloVM = anioModeloVM;
           this.configVehicular = configVehicular;
           this.placaVM = placaVM;
    }


    /**
     * Gets the anioModeloVM value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @return anioModeloVM
     */
    public java.lang.Integer getAnioModeloVM() {
        return anioModeloVM;
    }


    /**
     * Sets the anioModeloVM value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @param anioModeloVM
     */
    public void setAnioModeloVM(java.lang.Integer anioModeloVM) {
        this.anioModeloVM = anioModeloVM;
    }


    /**
     * Gets the configVehicular value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @return configVehicular
     */
    public java.lang.String getConfigVehicular() {
        return configVehicular;
    }


    /**
     * Sets the configVehicular value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @param configVehicular
     */
    public void setConfigVehicular(java.lang.String configVehicular) {
        this.configVehicular = configVehicular;
    }


    /**
     * Gets the placaVM value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @return placaVM
     */
    public java.lang.String getPlacaVM() {
        return placaVM;
    }


    /**
     * Sets the placaVM value for this CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.
     * 
     * @param placaVM
     */
    public void setPlacaVM(java.lang.String placaVM) {
        this.placaVM = placaVM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasAutotransporteIdentificacionVehicular20R)) return false;
        CartaPorteMercanciasAutotransporteIdentificacionVehicular20R other = (CartaPorteMercanciasAutotransporteIdentificacionVehicular20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anioModeloVM==null && other.getAnioModeloVM()==null) || 
             (this.anioModeloVM!=null &&
              this.anioModeloVM.equals(other.getAnioModeloVM()))) &&
            ((this.configVehicular==null && other.getConfigVehicular()==null) || 
             (this.configVehicular!=null &&
              this.configVehicular.equals(other.getConfigVehicular()))) &&
            ((this.placaVM==null && other.getPlacaVM()==null) || 
             (this.placaVM!=null &&
              this.placaVM.equals(other.getPlacaVM())));
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
        if (getAnioModeloVM() != null) {
            _hashCode += getAnioModeloVM().hashCode();
        }
        if (getConfigVehicular() != null) {
            _hashCode += getConfigVehicular().hashCode();
        }
        if (getPlacaVM() != null) {
            _hashCode += getPlacaVM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasAutotransporteIdentificacionVehicular20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasAutotransporteIdentificacionVehicular20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anioModeloVM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "AnioModeloVM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ConfigVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placaVM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PlacaVM"));
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
