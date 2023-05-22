/**
 * ConsultaR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Consulta;

public class ConsultaR  implements java.io.Serializable {
    private java.lang.String rfcEmisor;

    private java.lang.String rfcPac;

    private java.lang.String rfcReceptor;

    private java.math.BigDecimal total;

    private java.lang.String UUID;

    public ConsultaR() {
    }

    public ConsultaR(
           java.lang.String rfcEmisor,
           java.lang.String rfcPac,
           java.lang.String rfcReceptor,
           java.math.BigDecimal total,
           java.lang.String UUID) {
           this.rfcEmisor = rfcEmisor;
           this.rfcPac = rfcPac;
           this.rfcReceptor = rfcReceptor;
           this.total = total;
           this.UUID = UUID;
    }


    /**
     * Gets the rfcEmisor value for this ConsultaR.
     * 
     * @return rfcEmisor
     */
    public java.lang.String getRfcEmisor() {
        return rfcEmisor;
    }


    /**
     * Sets the rfcEmisor value for this ConsultaR.
     * 
     * @param rfcEmisor
     */
    public void setRfcEmisor(java.lang.String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }


    /**
     * Gets the rfcPac value for this ConsultaR.
     * 
     * @return rfcPac
     */
    public java.lang.String getRfcPac() {
        return rfcPac;
    }


    /**
     * Sets the rfcPac value for this ConsultaR.
     * 
     * @param rfcPac
     */
    public void setRfcPac(java.lang.String rfcPac) {
        this.rfcPac = rfcPac;
    }


    /**
     * Gets the rfcReceptor value for this ConsultaR.
     * 
     * @return rfcReceptor
     */
    public java.lang.String getRfcReceptor() {
        return rfcReceptor;
    }


    /**
     * Sets the rfcReceptor value for this ConsultaR.
     * 
     * @param rfcReceptor
     */
    public void setRfcReceptor(java.lang.String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }


    /**
     * Gets the total value for this ConsultaR.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this ConsultaR.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }


    /**
     * Gets the UUID value for this ConsultaR.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this ConsultaR.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaR)) return false;
        ConsultaR other = (ConsultaR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rfcEmisor==null && other.getRfcEmisor()==null) || 
             (this.rfcEmisor!=null &&
              this.rfcEmisor.equals(other.getRfcEmisor()))) &&
            ((this.rfcPac==null && other.getRfcPac()==null) || 
             (this.rfcPac!=null &&
              this.rfcPac.equals(other.getRfcPac()))) &&
            ((this.rfcReceptor==null && other.getRfcReceptor()==null) || 
             (this.rfcReceptor!=null &&
              this.rfcReceptor.equals(other.getRfcReceptor()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID())));
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
        if (getRfcEmisor() != null) {
            _hashCode += getRfcEmisor().hashCode();
        }
        if (getRfcPac() != null) {
            _hashCode += getRfcPac().hashCode();
        }
        if (getRfcReceptor() != null) {
            _hashCode += getRfcReceptor().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "ConsultaR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RfcEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcPac");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RfcPac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "RfcReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "Total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Consulta", "UUID"));
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
