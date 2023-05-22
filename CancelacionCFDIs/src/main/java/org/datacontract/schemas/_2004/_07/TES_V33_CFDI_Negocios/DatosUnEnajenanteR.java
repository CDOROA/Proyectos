/**
 * DatosUnEnajenanteR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatosUnEnajenanteR  implements java.io.Serializable {
    private java.lang.String apellidoMaterno;

    private java.lang.String apellidoPaterno;

    private java.lang.String CURP;

    private java.lang.String nombre;

    private java.lang.String RFC;

    public DatosUnEnajenanteR() {
    }

    public DatosUnEnajenanteR(
           java.lang.String apellidoMaterno,
           java.lang.String apellidoPaterno,
           java.lang.String CURP,
           java.lang.String nombre,
           java.lang.String RFC) {
           this.apellidoMaterno = apellidoMaterno;
           this.apellidoPaterno = apellidoPaterno;
           this.CURP = CURP;
           this.nombre = nombre;
           this.RFC = RFC;
    }


    /**
     * Gets the apellidoMaterno value for this DatosUnEnajenanteR.
     * 
     * @return apellidoMaterno
     */
    public java.lang.String getApellidoMaterno() {
        return apellidoMaterno;
    }


    /**
     * Sets the apellidoMaterno value for this DatosUnEnajenanteR.
     * 
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(java.lang.String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }


    /**
     * Gets the apellidoPaterno value for this DatosUnEnajenanteR.
     * 
     * @return apellidoPaterno
     */
    public java.lang.String getApellidoPaterno() {
        return apellidoPaterno;
    }


    /**
     * Sets the apellidoPaterno value for this DatosUnEnajenanteR.
     * 
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(java.lang.String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }


    /**
     * Gets the CURP value for this DatosUnEnajenanteR.
     * 
     * @return CURP
     */
    public java.lang.String getCURP() {
        return CURP;
    }


    /**
     * Sets the CURP value for this DatosUnEnajenanteR.
     * 
     * @param CURP
     */
    public void setCURP(java.lang.String CURP) {
        this.CURP = CURP;
    }


    /**
     * Gets the nombre value for this DatosUnEnajenanteR.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DatosUnEnajenanteR.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the RFC value for this DatosUnEnajenanteR.
     * 
     * @return RFC
     */
    public java.lang.String getRFC() {
        return RFC;
    }


    /**
     * Sets the RFC value for this DatosUnEnajenanteR.
     * 
     * @param RFC
     */
    public void setRFC(java.lang.String RFC) {
        this.RFC = RFC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosUnEnajenanteR)) return false;
        DatosUnEnajenanteR other = (DatosUnEnajenanteR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apellidoMaterno==null && other.getApellidoMaterno()==null) || 
             (this.apellidoMaterno!=null &&
              this.apellidoMaterno.equals(other.getApellidoMaterno()))) &&
            ((this.apellidoPaterno==null && other.getApellidoPaterno()==null) || 
             (this.apellidoPaterno!=null &&
              this.apellidoPaterno.equals(other.getApellidoPaterno()))) &&
            ((this.CURP==null && other.getCURP()==null) || 
             (this.CURP!=null &&
              this.CURP.equals(other.getCURP()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.RFC==null && other.getRFC()==null) || 
             (this.RFC!=null &&
              this.RFC.equals(other.getRFC())));
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
        if (getApellidoMaterno() != null) {
            _hashCode += getApellidoMaterno().hashCode();
        }
        if (getApellidoPaterno() != null) {
            _hashCode += getApellidoPaterno().hashCode();
        }
        if (getCURP() != null) {
            _hashCode += getCURP().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getRFC() != null) {
            _hashCode += getRFC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosUnEnajenanteR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnEnajenanteR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidoMaterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ApellidoMaterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidoPaterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ApellidoPaterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CURP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFC"));
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
