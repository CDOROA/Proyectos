/**
 * DispersionDelRecursoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DispersionDelRecursoR  implements java.io.Serializable {
    private java.lang.String fechaDeIdent;

    private java.lang.String numIdSolicitud;

    public DispersionDelRecursoR() {
    }

    public DispersionDelRecursoR(
           java.lang.String fechaDeIdent,
           java.lang.String numIdSolicitud) {
           this.fechaDeIdent = fechaDeIdent;
           this.numIdSolicitud = numIdSolicitud;
    }


    /**
     * Gets the fechaDeIdent value for this DispersionDelRecursoR.
     * 
     * @return fechaDeIdent
     */
    public java.lang.String getFechaDeIdent() {
        return fechaDeIdent;
    }


    /**
     * Sets the fechaDeIdent value for this DispersionDelRecursoR.
     * 
     * @param fechaDeIdent
     */
    public void setFechaDeIdent(java.lang.String fechaDeIdent) {
        this.fechaDeIdent = fechaDeIdent;
    }


    /**
     * Gets the numIdSolicitud value for this DispersionDelRecursoR.
     * 
     * @return numIdSolicitud
     */
    public java.lang.String getNumIdSolicitud() {
        return numIdSolicitud;
    }


    /**
     * Sets the numIdSolicitud value for this DispersionDelRecursoR.
     * 
     * @param numIdSolicitud
     */
    public void setNumIdSolicitud(java.lang.String numIdSolicitud) {
        this.numIdSolicitud = numIdSolicitud;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DispersionDelRecursoR)) return false;
        DispersionDelRecursoR other = (DispersionDelRecursoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaDeIdent==null && other.getFechaDeIdent()==null) || 
             (this.fechaDeIdent!=null &&
              this.fechaDeIdent.equals(other.getFechaDeIdent()))) &&
            ((this.numIdSolicitud==null && other.getNumIdSolicitud()==null) || 
             (this.numIdSolicitud!=null &&
              this.numIdSolicitud.equals(other.getNumIdSolicitud())));
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
        if (getFechaDeIdent() != null) {
            _hashCode += getFechaDeIdent().hashCode();
        }
        if (getNumIdSolicitud() != null) {
            _hashCode += getNumIdSolicitud().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DispersionDelRecursoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDeIdent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaDeIdent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numIdSolicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumIdSolicitud"));
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
