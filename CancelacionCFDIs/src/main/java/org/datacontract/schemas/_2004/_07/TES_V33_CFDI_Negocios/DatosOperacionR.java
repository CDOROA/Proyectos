/**
 * DatosOperacionR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatosOperacionR  implements java.io.Serializable {
    private java.util.Calendar fechaInstNotarial;

    private java.math.BigDecimal IVA;

    private java.math.BigDecimal montoOperacion;

    private java.lang.Integer numInstrumentoNotarial;

    private java.math.BigDecimal subtotal;

    public DatosOperacionR() {
    }

    public DatosOperacionR(
           java.util.Calendar fechaInstNotarial,
           java.math.BigDecimal IVA,
           java.math.BigDecimal montoOperacion,
           java.lang.Integer numInstrumentoNotarial,
           java.math.BigDecimal subtotal) {
           this.fechaInstNotarial = fechaInstNotarial;
           this.IVA = IVA;
           this.montoOperacion = montoOperacion;
           this.numInstrumentoNotarial = numInstrumentoNotarial;
           this.subtotal = subtotal;
    }


    /**
     * Gets the fechaInstNotarial value for this DatosOperacionR.
     * 
     * @return fechaInstNotarial
     */
    public java.util.Calendar getFechaInstNotarial() {
        return fechaInstNotarial;
    }


    /**
     * Sets the fechaInstNotarial value for this DatosOperacionR.
     * 
     * @param fechaInstNotarial
     */
    public void setFechaInstNotarial(java.util.Calendar fechaInstNotarial) {
        this.fechaInstNotarial = fechaInstNotarial;
    }


    /**
     * Gets the IVA value for this DatosOperacionR.
     * 
     * @return IVA
     */
    public java.math.BigDecimal getIVA() {
        return IVA;
    }


    /**
     * Sets the IVA value for this DatosOperacionR.
     * 
     * @param IVA
     */
    public void setIVA(java.math.BigDecimal IVA) {
        this.IVA = IVA;
    }


    /**
     * Gets the montoOperacion value for this DatosOperacionR.
     * 
     * @return montoOperacion
     */
    public java.math.BigDecimal getMontoOperacion() {
        return montoOperacion;
    }


    /**
     * Sets the montoOperacion value for this DatosOperacionR.
     * 
     * @param montoOperacion
     */
    public void setMontoOperacion(java.math.BigDecimal montoOperacion) {
        this.montoOperacion = montoOperacion;
    }


    /**
     * Gets the numInstrumentoNotarial value for this DatosOperacionR.
     * 
     * @return numInstrumentoNotarial
     */
    public java.lang.Integer getNumInstrumentoNotarial() {
        return numInstrumentoNotarial;
    }


    /**
     * Sets the numInstrumentoNotarial value for this DatosOperacionR.
     * 
     * @param numInstrumentoNotarial
     */
    public void setNumInstrumentoNotarial(java.lang.Integer numInstrumentoNotarial) {
        this.numInstrumentoNotarial = numInstrumentoNotarial;
    }


    /**
     * Gets the subtotal value for this DatosOperacionR.
     * 
     * @return subtotal
     */
    public java.math.BigDecimal getSubtotal() {
        return subtotal;
    }


    /**
     * Sets the subtotal value for this DatosOperacionR.
     * 
     * @param subtotal
     */
    public void setSubtotal(java.math.BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosOperacionR)) return false;
        DatosOperacionR other = (DatosOperacionR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaInstNotarial==null && other.getFechaInstNotarial()==null) || 
             (this.fechaInstNotarial!=null &&
              this.fechaInstNotarial.equals(other.getFechaInstNotarial()))) &&
            ((this.IVA==null && other.getIVA()==null) || 
             (this.IVA!=null &&
              this.IVA.equals(other.getIVA()))) &&
            ((this.montoOperacion==null && other.getMontoOperacion()==null) || 
             (this.montoOperacion!=null &&
              this.montoOperacion.equals(other.getMontoOperacion()))) &&
            ((this.numInstrumentoNotarial==null && other.getNumInstrumentoNotarial()==null) || 
             (this.numInstrumentoNotarial!=null &&
              this.numInstrumentoNotarial.equals(other.getNumInstrumentoNotarial()))) &&
            ((this.subtotal==null && other.getSubtotal()==null) || 
             (this.subtotal!=null &&
              this.subtotal.equals(other.getSubtotal())));
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
        if (getFechaInstNotarial() != null) {
            _hashCode += getFechaInstNotarial().hashCode();
        }
        if (getIVA() != null) {
            _hashCode += getIVA().hashCode();
        }
        if (getMontoOperacion() != null) {
            _hashCode += getMontoOperacion().hashCode();
        }
        if (getNumInstrumentoNotarial() != null) {
            _hashCode += getNumInstrumentoNotarial().hashCode();
        }
        if (getSubtotal() != null) {
            _hashCode += getSubtotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosOperacionR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosOperacionR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInstNotarial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaInstNotarial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numInstrumentoNotarial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumInstrumentoNotarial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Subtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
