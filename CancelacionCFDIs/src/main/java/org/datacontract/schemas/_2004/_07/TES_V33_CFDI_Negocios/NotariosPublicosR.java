/**
 * NotariosPublicosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class NotariosPublicosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteR datosAdquiriente;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteR datosEnajenante;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosNotarioR datosNotario;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosOperacionR datosOperacion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR[] descripcionDeInmuebles;

    public NotariosPublicosR() {
    }

    public NotariosPublicosR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteR datosAdquiriente,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteR datosEnajenante,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosNotarioR datosNotario,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosOperacionR datosOperacion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR[] descripcionDeInmuebles) {
           this.datosAdquiriente = datosAdquiriente;
           this.datosEnajenante = datosEnajenante;
           this.datosNotario = datosNotario;
           this.datosOperacion = datosOperacion;
           this.descripcionDeInmuebles = descripcionDeInmuebles;
    }


    /**
     * Gets the datosAdquiriente value for this NotariosPublicosR.
     * 
     * @return datosAdquiriente
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteR getDatosAdquiriente() {
        return datosAdquiriente;
    }


    /**
     * Sets the datosAdquiriente value for this NotariosPublicosR.
     * 
     * @param datosAdquiriente
     */
    public void setDatosAdquiriente(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteR datosAdquiriente) {
        this.datosAdquiriente = datosAdquiriente;
    }


    /**
     * Gets the datosEnajenante value for this NotariosPublicosR.
     * 
     * @return datosEnajenante
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteR getDatosEnajenante() {
        return datosEnajenante;
    }


    /**
     * Sets the datosEnajenante value for this NotariosPublicosR.
     * 
     * @param datosEnajenante
     */
    public void setDatosEnajenante(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteR datosEnajenante) {
        this.datosEnajenante = datosEnajenante;
    }


    /**
     * Gets the datosNotario value for this NotariosPublicosR.
     * 
     * @return datosNotario
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosNotarioR getDatosNotario() {
        return datosNotario;
    }


    /**
     * Sets the datosNotario value for this NotariosPublicosR.
     * 
     * @param datosNotario
     */
    public void setDatosNotario(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosNotarioR datosNotario) {
        this.datosNotario = datosNotario;
    }


    /**
     * Gets the datosOperacion value for this NotariosPublicosR.
     * 
     * @return datosOperacion
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosOperacionR getDatosOperacion() {
        return datosOperacion;
    }


    /**
     * Sets the datosOperacion value for this NotariosPublicosR.
     * 
     * @param datosOperacion
     */
    public void setDatosOperacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosOperacionR datosOperacion) {
        this.datosOperacion = datosOperacion;
    }


    /**
     * Gets the descripcionDeInmuebles value for this NotariosPublicosR.
     * 
     * @return descripcionDeInmuebles
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR[] getDescripcionDeInmuebles() {
        return descripcionDeInmuebles;
    }


    /**
     * Sets the descripcionDeInmuebles value for this NotariosPublicosR.
     * 
     * @param descripcionDeInmuebles
     */
    public void setDescripcionDeInmuebles(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DescInmuebleR[] descripcionDeInmuebles) {
        this.descripcionDeInmuebles = descripcionDeInmuebles;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NotariosPublicosR)) return false;
        NotariosPublicosR other = (NotariosPublicosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datosAdquiriente==null && other.getDatosAdquiriente()==null) || 
             (this.datosAdquiriente!=null &&
              this.datosAdquiriente.equals(other.getDatosAdquiriente()))) &&
            ((this.datosEnajenante==null && other.getDatosEnajenante()==null) || 
             (this.datosEnajenante!=null &&
              this.datosEnajenante.equals(other.getDatosEnajenante()))) &&
            ((this.datosNotario==null && other.getDatosNotario()==null) || 
             (this.datosNotario!=null &&
              this.datosNotario.equals(other.getDatosNotario()))) &&
            ((this.datosOperacion==null && other.getDatosOperacion()==null) || 
             (this.datosOperacion!=null &&
              this.datosOperacion.equals(other.getDatosOperacion()))) &&
            ((this.descripcionDeInmuebles==null && other.getDescripcionDeInmuebles()==null) || 
             (this.descripcionDeInmuebles!=null &&
              java.util.Arrays.equals(this.descripcionDeInmuebles, other.getDescripcionDeInmuebles())));
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
        if (getDatosAdquiriente() != null) {
            _hashCode += getDatosAdquiriente().hashCode();
        }
        if (getDatosEnajenante() != null) {
            _hashCode += getDatosEnajenante().hashCode();
        }
        if (getDatosNotario() != null) {
            _hashCode += getDatosNotario().hashCode();
        }
        if (getDatosOperacion() != null) {
            _hashCode += getDatosOperacion().hashCode();
        }
        if (getDescripcionDeInmuebles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDescripcionDeInmuebles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDescripcionDeInmuebles(), i);
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
        new org.apache.axis.description.TypeDesc(NotariosPublicosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NotariosPublicosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosAdquiriente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquiriente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosEnajenante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosNotario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosNotario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosNotarioR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosOperacionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionDeInmuebles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescripcionDeInmuebles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescInmuebleR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescInmuebleR"));
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
