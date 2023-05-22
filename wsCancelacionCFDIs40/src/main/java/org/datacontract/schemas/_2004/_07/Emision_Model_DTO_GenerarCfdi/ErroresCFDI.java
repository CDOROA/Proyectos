/**
 * ErroresCFDI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class ErroresCFDI  implements java.io.Serializable {
    private java.lang.String errorDetallado;

    private java.lang.String errorEsp;

    private java.lang.String errorGeneral;

    public ErroresCFDI() {
    }

    public ErroresCFDI(
           java.lang.String errorDetallado,
           java.lang.String errorEsp,
           java.lang.String errorGeneral) {
           this.errorDetallado = errorDetallado;
           this.errorEsp = errorEsp;
           this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the errorDetallado value for this ErroresCFDI.
     * 
     * @return errorDetallado
     */
    public java.lang.String getErrorDetallado() {
        return errorDetallado;
    }


    /**
     * Sets the errorDetallado value for this ErroresCFDI.
     * 
     * @param errorDetallado
     */
    public void setErrorDetallado(java.lang.String errorDetallado) {
        this.errorDetallado = errorDetallado;
    }


    /**
     * Gets the errorEsp value for this ErroresCFDI.
     * 
     * @return errorEsp
     */
    public java.lang.String getErrorEsp() {
        return errorEsp;
    }


    /**
     * Sets the errorEsp value for this ErroresCFDI.
     * 
     * @param errorEsp
     */
    public void setErrorEsp(java.lang.String errorEsp) {
        this.errorEsp = errorEsp;
    }


    /**
     * Gets the errorGeneral value for this ErroresCFDI.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this ErroresCFDI.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ErroresCFDI)) return false;
        ErroresCFDI other = (ErroresCFDI) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorDetallado==null && other.getErrorDetallado()==null) || 
             (this.errorDetallado!=null &&
              this.errorDetallado.equals(other.getErrorDetallado()))) &&
            ((this.errorEsp==null && other.getErrorEsp()==null) || 
             (this.errorEsp!=null &&
              this.errorEsp.equals(other.getErrorEsp()))) &&
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral())));
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
        if (getErrorDetallado() != null) {
            _hashCode += getErrorDetallado().hashCode();
        }
        if (getErrorEsp() != null) {
            _hashCode += getErrorEsp().hashCode();
        }
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ErroresCFDI.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErroresCFDI"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDetallado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErrorDetallado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorEsp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErrorEsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ErrorGeneral"));
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
