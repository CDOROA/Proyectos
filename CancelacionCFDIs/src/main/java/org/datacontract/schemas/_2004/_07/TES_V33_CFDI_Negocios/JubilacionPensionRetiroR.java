/**
 * JubilacionPensionRetiroR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class JubilacionPensionRetiroR  implements java.io.Serializable {
    private java.math.BigDecimal ingresoAcumulable;

    private java.math.BigDecimal ingresoNoAcumulable;

    private java.math.BigDecimal montoDiario;

    private java.math.BigDecimal totalParcialidad;

    private java.math.BigDecimal totalUnaExhibicion;

    public JubilacionPensionRetiroR() {
    }

    public JubilacionPensionRetiroR(
           java.math.BigDecimal ingresoAcumulable,
           java.math.BigDecimal ingresoNoAcumulable,
           java.math.BigDecimal montoDiario,
           java.math.BigDecimal totalParcialidad,
           java.math.BigDecimal totalUnaExhibicion) {
           this.ingresoAcumulable = ingresoAcumulable;
           this.ingresoNoAcumulable = ingresoNoAcumulable;
           this.montoDiario = montoDiario;
           this.totalParcialidad = totalParcialidad;
           this.totalUnaExhibicion = totalUnaExhibicion;
    }


    /**
     * Gets the ingresoAcumulable value for this JubilacionPensionRetiroR.
     * 
     * @return ingresoAcumulable
     */
    public java.math.BigDecimal getIngresoAcumulable() {
        return ingresoAcumulable;
    }


    /**
     * Sets the ingresoAcumulable value for this JubilacionPensionRetiroR.
     * 
     * @param ingresoAcumulable
     */
    public void setIngresoAcumulable(java.math.BigDecimal ingresoAcumulable) {
        this.ingresoAcumulable = ingresoAcumulable;
    }


    /**
     * Gets the ingresoNoAcumulable value for this JubilacionPensionRetiroR.
     * 
     * @return ingresoNoAcumulable
     */
    public java.math.BigDecimal getIngresoNoAcumulable() {
        return ingresoNoAcumulable;
    }


    /**
     * Sets the ingresoNoAcumulable value for this JubilacionPensionRetiroR.
     * 
     * @param ingresoNoAcumulable
     */
    public void setIngresoNoAcumulable(java.math.BigDecimal ingresoNoAcumulable) {
        this.ingresoNoAcumulable = ingresoNoAcumulable;
    }


    /**
     * Gets the montoDiario value for this JubilacionPensionRetiroR.
     * 
     * @return montoDiario
     */
    public java.math.BigDecimal getMontoDiario() {
        return montoDiario;
    }


    /**
     * Sets the montoDiario value for this JubilacionPensionRetiroR.
     * 
     * @param montoDiario
     */
    public void setMontoDiario(java.math.BigDecimal montoDiario) {
        this.montoDiario = montoDiario;
    }


    /**
     * Gets the totalParcialidad value for this JubilacionPensionRetiroR.
     * 
     * @return totalParcialidad
     */
    public java.math.BigDecimal getTotalParcialidad() {
        return totalParcialidad;
    }


    /**
     * Sets the totalParcialidad value for this JubilacionPensionRetiroR.
     * 
     * @param totalParcialidad
     */
    public void setTotalParcialidad(java.math.BigDecimal totalParcialidad) {
        this.totalParcialidad = totalParcialidad;
    }


    /**
     * Gets the totalUnaExhibicion value for this JubilacionPensionRetiroR.
     * 
     * @return totalUnaExhibicion
     */
    public java.math.BigDecimal getTotalUnaExhibicion() {
        return totalUnaExhibicion;
    }


    /**
     * Sets the totalUnaExhibicion value for this JubilacionPensionRetiroR.
     * 
     * @param totalUnaExhibicion
     */
    public void setTotalUnaExhibicion(java.math.BigDecimal totalUnaExhibicion) {
        this.totalUnaExhibicion = totalUnaExhibicion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JubilacionPensionRetiroR)) return false;
        JubilacionPensionRetiroR other = (JubilacionPensionRetiroR) obj;
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
            ((this.montoDiario==null && other.getMontoDiario()==null) || 
             (this.montoDiario!=null &&
              this.montoDiario.equals(other.getMontoDiario()))) &&
            ((this.totalParcialidad==null && other.getTotalParcialidad()==null) || 
             (this.totalParcialidad!=null &&
              this.totalParcialidad.equals(other.getTotalParcialidad()))) &&
            ((this.totalUnaExhibicion==null && other.getTotalUnaExhibicion()==null) || 
             (this.totalUnaExhibicion!=null &&
              this.totalUnaExhibicion.equals(other.getTotalUnaExhibicion())));
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
        if (getMontoDiario() != null) {
            _hashCode += getMontoDiario().hashCode();
        }
        if (getTotalParcialidad() != null) {
            _hashCode += getTotalParcialidad().hashCode();
        }
        if (getTotalUnaExhibicion() != null) {
            _hashCode += getTotalUnaExhibicion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JubilacionPensionRetiroR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "JubilacionPensionRetiroR"));
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
        elemField.setFieldName("montoDiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoDiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalParcialidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalParcialidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalUnaExhibicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalUnaExhibicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
