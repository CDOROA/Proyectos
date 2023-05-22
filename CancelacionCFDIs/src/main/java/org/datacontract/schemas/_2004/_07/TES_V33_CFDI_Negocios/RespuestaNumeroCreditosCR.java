/**
 * RespuestaNumeroCreditosCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RespuestaNumeroCreditosCR  implements java.io.Serializable {
    private java.lang.Integer creditosRestantes;

    private java.lang.Integer creditosUsados;

    private java.lang.String errorDetallado;

    private java.lang.String errorGeneral;

    private java.lang.Boolean operacionExitosa;

    public RespuestaNumeroCreditosCR() {
    }

    public RespuestaNumeroCreditosCR(
           java.lang.Integer creditosRestantes,
           java.lang.Integer creditosUsados,
           java.lang.String errorDetallado,
           java.lang.String errorGeneral,
           java.lang.Boolean operacionExitosa) {
           this.creditosRestantes = creditosRestantes;
           this.creditosUsados = creditosUsados;
           this.errorDetallado = errorDetallado;
           this.errorGeneral = errorGeneral;
           this.operacionExitosa = operacionExitosa;
    }


    /**
     * Gets the creditosRestantes value for this RespuestaNumeroCreditosCR.
     * 
     * @return creditosRestantes
     */
    public java.lang.Integer getCreditosRestantes() {
        return creditosRestantes;
    }


    /**
     * Sets the creditosRestantes value for this RespuestaNumeroCreditosCR.
     * 
     * @param creditosRestantes
     */
    public void setCreditosRestantes(java.lang.Integer creditosRestantes) {
        this.creditosRestantes = creditosRestantes;
    }


    /**
     * Gets the creditosUsados value for this RespuestaNumeroCreditosCR.
     * 
     * @return creditosUsados
     */
    public java.lang.Integer getCreditosUsados() {
        return creditosUsados;
    }


    /**
     * Sets the creditosUsados value for this RespuestaNumeroCreditosCR.
     * 
     * @param creditosUsados
     */
    public void setCreditosUsados(java.lang.Integer creditosUsados) {
        this.creditosUsados = creditosUsados;
    }


    /**
     * Gets the errorDetallado value for this RespuestaNumeroCreditosCR.
     * 
     * @return errorDetallado
     */
    public java.lang.String getErrorDetallado() {
        return errorDetallado;
    }


    /**
     * Sets the errorDetallado value for this RespuestaNumeroCreditosCR.
     * 
     * @param errorDetallado
     */
    public void setErrorDetallado(java.lang.String errorDetallado) {
        this.errorDetallado = errorDetallado;
    }


    /**
     * Gets the errorGeneral value for this RespuestaNumeroCreditosCR.
     * 
     * @return errorGeneral
     */
    public java.lang.String getErrorGeneral() {
        return errorGeneral;
    }


    /**
     * Sets the errorGeneral value for this RespuestaNumeroCreditosCR.
     * 
     * @param errorGeneral
     */
    public void setErrorGeneral(java.lang.String errorGeneral) {
        this.errorGeneral = errorGeneral;
    }


    /**
     * Gets the operacionExitosa value for this RespuestaNumeroCreditosCR.
     * 
     * @return operacionExitosa
     */
    public java.lang.Boolean getOperacionExitosa() {
        return operacionExitosa;
    }


    /**
     * Sets the operacionExitosa value for this RespuestaNumeroCreditosCR.
     * 
     * @param operacionExitosa
     */
    public void setOperacionExitosa(java.lang.Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaNumeroCreditosCR)) return false;
        RespuestaNumeroCreditosCR other = (RespuestaNumeroCreditosCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.creditosRestantes==null && other.getCreditosRestantes()==null) || 
             (this.creditosRestantes!=null &&
              this.creditosRestantes.equals(other.getCreditosRestantes()))) &&
            ((this.creditosUsados==null && other.getCreditosUsados()==null) || 
             (this.creditosUsados!=null &&
              this.creditosUsados.equals(other.getCreditosUsados()))) &&
            ((this.errorDetallado==null && other.getErrorDetallado()==null) || 
             (this.errorDetallado!=null &&
              this.errorDetallado.equals(other.getErrorDetallado()))) &&
            ((this.errorGeneral==null && other.getErrorGeneral()==null) || 
             (this.errorGeneral!=null &&
              this.errorGeneral.equals(other.getErrorGeneral()))) &&
            ((this.operacionExitosa==null && other.getOperacionExitosa()==null) || 
             (this.operacionExitosa!=null &&
              this.operacionExitosa.equals(other.getOperacionExitosa())));
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
        if (getCreditosRestantes() != null) {
            _hashCode += getCreditosRestantes().hashCode();
        }
        if (getCreditosUsados() != null) {
            _hashCode += getCreditosUsados().hashCode();
        }
        if (getErrorDetallado() != null) {
            _hashCode += getErrorDetallado().hashCode();
        }
        if (getErrorGeneral() != null) {
            _hashCode += getErrorGeneral().hashCode();
        }
        if (getOperacionExitosa() != null) {
            _hashCode += getOperacionExitosa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaNumeroCreditosCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RespuestaNumeroCreditosCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditosRestantes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CreditosRestantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditosUsados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CreditosUsados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDetallado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorDetallado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorGeneral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErrorGeneral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacionExitosa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OperacionExitosa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
