/**
 * SeparacionIndemnizacionR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class SeparacionIndemnizacionR  implements java.io.Serializable {
    private java.math.BigDecimal ingresoAcumulable;

    private java.math.BigDecimal ingresoNoAcumulable;

    private java.lang.Integer numAñosServicio;

    private java.math.BigDecimal totalPagado;

    private java.math.BigDecimal ultimoSueldoMensOrd;

    public SeparacionIndemnizacionR() {
    }

    public SeparacionIndemnizacionR(
           java.math.BigDecimal ingresoAcumulable,
           java.math.BigDecimal ingresoNoAcumulable,
           java.lang.Integer numAñosServicio,
           java.math.BigDecimal totalPagado,
           java.math.BigDecimal ultimoSueldoMensOrd) {
           this.ingresoAcumulable = ingresoAcumulable;
           this.ingresoNoAcumulable = ingresoNoAcumulable;
           this.numAñosServicio = numAñosServicio;
           this.totalPagado = totalPagado;
           this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
    }


    /**
     * Gets the ingresoAcumulable value for this SeparacionIndemnizacionR.
     * 
     * @return ingresoAcumulable
     */
    public java.math.BigDecimal getIngresoAcumulable() {
        return ingresoAcumulable;
    }


    /**
     * Sets the ingresoAcumulable value for this SeparacionIndemnizacionR.
     * 
     * @param ingresoAcumulable
     */
    public void setIngresoAcumulable(java.math.BigDecimal ingresoAcumulable) {
        this.ingresoAcumulable = ingresoAcumulable;
    }


    /**
     * Gets the ingresoNoAcumulable value for this SeparacionIndemnizacionR.
     * 
     * @return ingresoNoAcumulable
     */
    public java.math.BigDecimal getIngresoNoAcumulable() {
        return ingresoNoAcumulable;
    }


    /**
     * Sets the ingresoNoAcumulable value for this SeparacionIndemnizacionR.
     * 
     * @param ingresoNoAcumulable
     */
    public void setIngresoNoAcumulable(java.math.BigDecimal ingresoNoAcumulable) {
        this.ingresoNoAcumulable = ingresoNoAcumulable;
    }


    /**
     * Gets the numAñosServicio value for this SeparacionIndemnizacionR.
     * 
     * @return numAñosServicio
     */
    public java.lang.Integer getNumAñosServicio() {
        return numAñosServicio;
    }


    /**
     * Sets the numAñosServicio value for this SeparacionIndemnizacionR.
     * 
     * @param numAñosServicio
     */
    public void setNumAñosServicio(java.lang.Integer numAñosServicio) {
        this.numAñosServicio = numAñosServicio;
    }


    /**
     * Gets the totalPagado value for this SeparacionIndemnizacionR.
     * 
     * @return totalPagado
     */
    public java.math.BigDecimal getTotalPagado() {
        return totalPagado;
    }


    /**
     * Sets the totalPagado value for this SeparacionIndemnizacionR.
     * 
     * @param totalPagado
     */
    public void setTotalPagado(java.math.BigDecimal totalPagado) {
        this.totalPagado = totalPagado;
    }


    /**
     * Gets the ultimoSueldoMensOrd value for this SeparacionIndemnizacionR.
     * 
     * @return ultimoSueldoMensOrd
     */
    public java.math.BigDecimal getUltimoSueldoMensOrd() {
        return ultimoSueldoMensOrd;
    }


    /**
     * Sets the ultimoSueldoMensOrd value for this SeparacionIndemnizacionR.
     * 
     * @param ultimoSueldoMensOrd
     */
    public void setUltimoSueldoMensOrd(java.math.BigDecimal ultimoSueldoMensOrd) {
        this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SeparacionIndemnizacionR)) return false;
        SeparacionIndemnizacionR other = (SeparacionIndemnizacionR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ingresoAcumulable==null && other.getIngresoAcumulable()==null) || 
             (this.ingresoAcumulable!=null &&
              this.ingresoAcumulable.equals(other.getIngresoAcumulable()))) &&
            ((this.ingresoNoAcumulable==null && other.getIngresoNoAcumulable()==null) || 
             (this.ingresoNoAcumulable!=null &&
              this.ingresoNoAcumulable.equals(other.getIngresoNoAcumulable()))) &&
            ((this.numAñosServicio==null && other.getNumAñosServicio()==null) || 
             (this.numAñosServicio!=null &&
              this.numAñosServicio.equals(other.getNumAñosServicio()))) &&
            ((this.totalPagado==null && other.getTotalPagado()==null) || 
             (this.totalPagado!=null &&
              this.totalPagado.equals(other.getTotalPagado()))) &&
            ((this.ultimoSueldoMensOrd==null && other.getUltimoSueldoMensOrd()==null) || 
             (this.ultimoSueldoMensOrd!=null &&
              this.ultimoSueldoMensOrd.equals(other.getUltimoSueldoMensOrd())));
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
        if (getIngresoAcumulable() != null) {
            _hashCode += getIngresoAcumulable().hashCode();
        }
        if (getIngresoNoAcumulable() != null) {
            _hashCode += getIngresoNoAcumulable().hashCode();
        }
        if (getNumAñosServicio() != null) {
            _hashCode += getNumAñosServicio().hashCode();
        }
        if (getTotalPagado() != null) {
            _hashCode += getTotalPagado().hashCode();
        }
        if (getUltimoSueldoMensOrd() != null) {
            _hashCode += getUltimoSueldoMensOrd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SeparacionIndemnizacionR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SeparacionIndemnizacionR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ingresoAcumulable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresoAcumulable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ingresoNoAcumulable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IngresoNoAcumulable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numAñosServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumAñosServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPagado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalPagado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoSueldoMensOrd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UltimoSueldoMensOrd"));
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
