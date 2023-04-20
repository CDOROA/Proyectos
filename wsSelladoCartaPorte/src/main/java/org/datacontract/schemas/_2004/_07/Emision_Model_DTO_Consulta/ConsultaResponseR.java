/**
 * ConsultaResponseR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta;

public class ConsultaResponseR  implements java.io.Serializable {
    private java.lang.String esCancelable;

    private java.lang.String estado;

    private java.lang.String estatusCancelacion;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle[] respuestas;

    public ConsultaResponseR() {
    }

    public ConsultaResponseR(
           java.lang.String esCancelable,
           java.lang.String estado,
           java.lang.String estatusCancelacion,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle[] respuestas) {
           this.esCancelable = esCancelable;
           this.estado = estado;
           this.estatusCancelacion = estatusCancelacion;
           this.respuestas = respuestas;
    }


    /**
     * Gets the esCancelable value for this ConsultaResponseR.
     * 
     * @return esCancelable
     */
    public java.lang.String getEsCancelable() {
        return esCancelable;
    }


    /**
     * Sets the esCancelable value for this ConsultaResponseR.
     * 
     * @param esCancelable
     */
    public void setEsCancelable(java.lang.String esCancelable) {
        this.esCancelable = esCancelable;
    }


    /**
     * Gets the estado value for this ConsultaResponseR.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ConsultaResponseR.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the estatusCancelacion value for this ConsultaResponseR.
     * 
     * @return estatusCancelacion
     */
    public java.lang.String getEstatusCancelacion() {
        return estatusCancelacion;
    }


    /**
     * Sets the estatusCancelacion value for this ConsultaResponseR.
     * 
     * @param estatusCancelacion
     */
    public void setEstatusCancelacion(java.lang.String estatusCancelacion) {
        this.estatusCancelacion = estatusCancelacion;
    }


    /**
     * Gets the respuestas value for this ConsultaResponseR.
     * 
     * @return respuestas
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle[] getRespuestas() {
        return respuestas;
    }


    /**
     * Sets the respuestas value for this ConsultaResponseR.
     * 
     * @param respuestas
     */
    public void setRespuestas(org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta.RespuestaDetalle[] respuestas) {
        this.respuestas = respuestas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaResponseR)) return false;
        ConsultaResponseR other = (ConsultaResponseR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esCancelable==null && other.getEsCancelable()==null) || 
             (this.esCancelable!=null &&
              this.esCancelable.equals(other.getEsCancelable()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estatusCancelacion==null && other.getEstatusCancelacion()==null) || 
             (this.estatusCancelacion!=null &&
              this.estatusCancelacion.equals(other.getEstatusCancelacion()))) &&
            ((this.respuestas==null && other.getRespuestas()==null) || 
             (this.respuestas!=null &&
              java.util.Arrays.equals(this.respuestas, other.getRespuestas())));
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
        if (getEsCancelable() != null) {
            _hashCode += getEsCancelable().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstatusCancelacion() != null) {
            _hashCode += getEstatusCancelacion().hashCode();
        }
        if (getRespuestas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRespuestas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRespuestas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaResponseR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaResponseR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esCancelable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "EsCancelable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatusCancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "EstatusCancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "Respuestas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RespuestaDetalle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RespuestaDetalle"));
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
