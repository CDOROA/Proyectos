/**
 * CartaPorteMercanciasTransporteMaritimoContenedor20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercanciasTransporteMaritimoContenedor20R  implements java.io.Serializable {
    private java.lang.String matriculaContenedor;

    private java.lang.String numPrecinto;

    private java.lang.String tipoContenedor;

    public CartaPorteMercanciasTransporteMaritimoContenedor20R() {
    }

    public CartaPorteMercanciasTransporteMaritimoContenedor20R(
           java.lang.String matriculaContenedor,
           java.lang.String numPrecinto,
           java.lang.String tipoContenedor) {
           this.matriculaContenedor = matriculaContenedor;
           this.numPrecinto = numPrecinto;
           this.tipoContenedor = tipoContenedor;
    }


    /**
     * Gets the matriculaContenedor value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @return matriculaContenedor
     */
    public java.lang.String getMatriculaContenedor() {
        return matriculaContenedor;
    }


    /**
     * Sets the matriculaContenedor value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @param matriculaContenedor
     */
    public void setMatriculaContenedor(java.lang.String matriculaContenedor) {
        this.matriculaContenedor = matriculaContenedor;
    }


    /**
     * Gets the numPrecinto value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @return numPrecinto
     */
    public java.lang.String getNumPrecinto() {
        return numPrecinto;
    }


    /**
     * Sets the numPrecinto value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @param numPrecinto
     */
    public void setNumPrecinto(java.lang.String numPrecinto) {
        this.numPrecinto = numPrecinto;
    }


    /**
     * Gets the tipoContenedor value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @return tipoContenedor
     */
    public java.lang.String getTipoContenedor() {
        return tipoContenedor;
    }


    /**
     * Sets the tipoContenedor value for this CartaPorteMercanciasTransporteMaritimoContenedor20R.
     * 
     * @param tipoContenedor
     */
    public void setTipoContenedor(java.lang.String tipoContenedor) {
        this.tipoContenedor = tipoContenedor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasTransporteMaritimoContenedor20R)) return false;
        CartaPorteMercanciasTransporteMaritimoContenedor20R other = (CartaPorteMercanciasTransporteMaritimoContenedor20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.matriculaContenedor==null && other.getMatriculaContenedor()==null) || 
             (this.matriculaContenedor!=null &&
              this.matriculaContenedor.equals(other.getMatriculaContenedor()))) &&
            ((this.numPrecinto==null && other.getNumPrecinto()==null) || 
             (this.numPrecinto!=null &&
              this.numPrecinto.equals(other.getNumPrecinto()))) &&
            ((this.tipoContenedor==null && other.getTipoContenedor()==null) || 
             (this.tipoContenedor!=null &&
              this.tipoContenedor.equals(other.getTipoContenedor())));
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
        if (getMatriculaContenedor() != null) {
            _hashCode += getMatriculaContenedor().hashCode();
        }
        if (getNumPrecinto() != null) {
            _hashCode += getNumPrecinto().hashCode();
        }
        if (getTipoContenedor() != null) {
            _hashCode += getTipoContenedor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasTransporteMaritimoContenedor20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteMaritimoContenedor20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matriculaContenedor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "MatriculaContenedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPrecinto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NumPrecinto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoContenedor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TipoContenedor"));
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
