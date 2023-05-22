/**
 * CartaPorteMercanciasTransporteFerroviario20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteMercanciasTransporteFerroviario20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R[] carro;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[] derechosDePaso;

    private java.lang.String nombreAseg;

    private java.lang.String numPolizaSeguro;

    private java.lang.String tipoDeServicio;

    private java.lang.String tipoDeTrafico;

    public CartaPorteMercanciasTransporteFerroviario20R() {
    }

    public CartaPorteMercanciasTransporteFerroviario20R(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R[] carro,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[] derechosDePaso,
           java.lang.String nombreAseg,
           java.lang.String numPolizaSeguro,
           java.lang.String tipoDeServicio,
           java.lang.String tipoDeTrafico) {
           this.carro = carro;
           this.derechosDePaso = derechosDePaso;
           this.nombreAseg = nombreAseg;
           this.numPolizaSeguro = numPolizaSeguro;
           this.tipoDeServicio = tipoDeServicio;
           this.tipoDeTrafico = tipoDeTrafico;
    }


    /**
     * Gets the carro value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return carro
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R[] getCarro() {
        return carro;
    }


    /**
     * Sets the carro value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param carro
     */
    public void setCarro(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioCarro20R[] carro) {
        this.carro = carro;
    }


    /**
     * Gets the derechosDePaso value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return derechosDePaso
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[] getDerechosDePaso() {
        return derechosDePaso;
    }


    /**
     * Sets the derechosDePaso value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param derechosDePaso
     */
    public void setDerechosDePaso(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R[] derechosDePaso) {
        this.derechosDePaso = derechosDePaso;
    }


    /**
     * Gets the nombreAseg value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return nombreAseg
     */
    public java.lang.String getNombreAseg() {
        return nombreAseg;
    }


    /**
     * Sets the nombreAseg value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param nombreAseg
     */
    public void setNombreAseg(java.lang.String nombreAseg) {
        this.nombreAseg = nombreAseg;
    }


    /**
     * Gets the numPolizaSeguro value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return numPolizaSeguro
     */
    public java.lang.String getNumPolizaSeguro() {
        return numPolizaSeguro;
    }


    /**
     * Sets the numPolizaSeguro value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param numPolizaSeguro
     */
    public void setNumPolizaSeguro(java.lang.String numPolizaSeguro) {
        this.numPolizaSeguro = numPolizaSeguro;
    }


    /**
     * Gets the tipoDeServicio value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return tipoDeServicio
     */
    public java.lang.String getTipoDeServicio() {
        return tipoDeServicio;
    }


    /**
     * Sets the tipoDeServicio value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param tipoDeServicio
     */
    public void setTipoDeServicio(java.lang.String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }


    /**
     * Gets the tipoDeTrafico value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @return tipoDeTrafico
     */
    public java.lang.String getTipoDeTrafico() {
        return tipoDeTrafico;
    }


    /**
     * Sets the tipoDeTrafico value for this CartaPorteMercanciasTransporteFerroviario20R.
     * 
     * @param tipoDeTrafico
     */
    public void setTipoDeTrafico(java.lang.String tipoDeTrafico) {
        this.tipoDeTrafico = tipoDeTrafico;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasTransporteFerroviario20R)) return false;
        CartaPorteMercanciasTransporteFerroviario20R other = (CartaPorteMercanciasTransporteFerroviario20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.carro==null && other.getCarro()==null) || 
             (this.carro!=null &&
              java.util.Arrays.equals(this.carro, other.getCarro()))) &&
            ((this.derechosDePaso==null && other.getDerechosDePaso()==null) || 
             (this.derechosDePaso!=null &&
              java.util.Arrays.equals(this.derechosDePaso, other.getDerechosDePaso()))) &&
            ((this.nombreAseg==null && other.getNombreAseg()==null) || 
             (this.nombreAseg!=null &&
              this.nombreAseg.equals(other.getNombreAseg()))) &&
            ((this.numPolizaSeguro==null && other.getNumPolizaSeguro()==null) || 
             (this.numPolizaSeguro!=null &&
              this.numPolizaSeguro.equals(other.getNumPolizaSeguro()))) &&
            ((this.tipoDeServicio==null && other.getTipoDeServicio()==null) || 
             (this.tipoDeServicio!=null &&
              this.tipoDeServicio.equals(other.getTipoDeServicio()))) &&
            ((this.tipoDeTrafico==null && other.getTipoDeTrafico()==null) || 
             (this.tipoDeTrafico!=null &&
              this.tipoDeTrafico.equals(other.getTipoDeTrafico())));
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
        if (getCarro() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCarro());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCarro(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDerechosDePaso() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDerechosDePaso());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDerechosDePaso(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombreAseg() != null) {
            _hashCode += getNombreAseg().hashCode();
        }
        if (getNumPolizaSeguro() != null) {
            _hashCode += getNumPolizaSeguro().hashCode();
        }
        if (getTipoDeServicio() != null) {
            _hashCode += getTipoDeServicio().hashCode();
        }
        if (getTipoDeTrafico() != null) {
            _hashCode += getTipoDeTrafico().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasTransporteFerroviario20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviario20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Carro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarro20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioCarro20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("derechosDePaso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "DerechosDePaso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteMercanciasTransporteFerroviarioDerechosDePaso20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreAseg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NombreAseg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPolizaSeguro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NumPolizaSeguro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDeServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TipoDeServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDeTrafico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TipoDeTrafico"));
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
