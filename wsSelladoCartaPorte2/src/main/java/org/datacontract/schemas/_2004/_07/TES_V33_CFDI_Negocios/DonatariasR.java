/**
 * DonatariasR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DonatariasR  implements java.io.Serializable {
    private java.util.Calendar fechaAutorizacion;

    private java.lang.String leyenda;

    private java.lang.String noAutorizacion;

    public DonatariasR() {
    }

    public DonatariasR(
           java.util.Calendar fechaAutorizacion,
           java.lang.String leyenda,
           java.lang.String noAutorizacion) {
           this.fechaAutorizacion = fechaAutorizacion;
           this.leyenda = leyenda;
           this.noAutorizacion = noAutorizacion;
    }


    /**
     * Gets the fechaAutorizacion value for this DonatariasR.
     * 
     * @return fechaAutorizacion
     */
    public java.util.Calendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }


    /**
     * Sets the fechaAutorizacion value for this DonatariasR.
     * 
     * @param fechaAutorizacion
     */
    public void setFechaAutorizacion(java.util.Calendar fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }


    /**
     * Gets the leyenda value for this DonatariasR.
     * 
     * @return leyenda
     */
    public java.lang.String getLeyenda() {
        return leyenda;
    }


    /**
     * Sets the leyenda value for this DonatariasR.
     * 
     * @param leyenda
     */
    public void setLeyenda(java.lang.String leyenda) {
        this.leyenda = leyenda;
    }


    /**
     * Gets the noAutorizacion value for this DonatariasR.
     * 
     * @return noAutorizacion
     */
    public java.lang.String getNoAutorizacion() {
        return noAutorizacion;
    }


    /**
     * Sets the noAutorizacion value for this DonatariasR.
     * 
     * @param noAutorizacion
     */
    public void setNoAutorizacion(java.lang.String noAutorizacion) {
        this.noAutorizacion = noAutorizacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DonatariasR)) return false;
        DonatariasR other = (DonatariasR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaAutorizacion==null && other.getFechaAutorizacion()==null) || 
             (this.fechaAutorizacion!=null &&
              this.fechaAutorizacion.equals(other.getFechaAutorizacion()))) &&
            ((this.leyenda==null && other.getLeyenda()==null) || 
             (this.leyenda!=null &&
              this.leyenda.equals(other.getLeyenda()))) &&
            ((this.noAutorizacion==null && other.getNoAutorizacion()==null) || 
             (this.noAutorizacion!=null &&
              this.noAutorizacion.equals(other.getNoAutorizacion())));
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
        if (getFechaAutorizacion() != null) {
            _hashCode += getFechaAutorizacion().hashCode();
        }
        if (getLeyenda() != null) {
            _hashCode += getLeyenda().hashCode();
        }
        if (getNoAutorizacion() != null) {
            _hashCode += getNoAutorizacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DonatariasR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DonatariasR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leyenda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Leyenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NoAutorizacion"));
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
