/**
 * ConceptoValesR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ConceptoValesR  implements java.io.Serializable {
    private java.lang.String curp;

    private java.util.Calendar fecha;

    private java.lang.String identificador;

    private java.math.BigDecimal importe;

    private java.lang.String nombre;

    private java.lang.String numSeguridadSocial;

    private java.lang.String rfc;

    public ConceptoValesR() {
    }

    public ConceptoValesR(
           java.lang.String curp,
           java.util.Calendar fecha,
           java.lang.String identificador,
           java.math.BigDecimal importe,
           java.lang.String nombre,
           java.lang.String numSeguridadSocial,
           java.lang.String rfc) {
           this.curp = curp;
           this.fecha = fecha;
           this.identificador = identificador;
           this.importe = importe;
           this.nombre = nombre;
           this.numSeguridadSocial = numSeguridadSocial;
           this.rfc = rfc;
    }


    /**
     * Gets the curp value for this ConceptoValesR.
     * 
     * @return curp
     */
    public java.lang.String getCurp() {
        return curp;
    }


    /**
     * Sets the curp value for this ConceptoValesR.
     * 
     * @param curp
     */
    public void setCurp(java.lang.String curp) {
        this.curp = curp;
    }


    /**
     * Gets the fecha value for this ConceptoValesR.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConceptoValesR.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the identificador value for this ConceptoValesR.
     * 
     * @return identificador
     */
    public java.lang.String getIdentificador() {
        return identificador;
    }


    /**
     * Sets the identificador value for this ConceptoValesR.
     * 
     * @param identificador
     */
    public void setIdentificador(java.lang.String identificador) {
        this.identificador = identificador;
    }


    /**
     * Gets the importe value for this ConceptoValesR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this ConceptoValesR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the nombre value for this ConceptoValesR.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ConceptoValesR.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the numSeguridadSocial value for this ConceptoValesR.
     * 
     * @return numSeguridadSocial
     */
    public java.lang.String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }


    /**
     * Sets the numSeguridadSocial value for this ConceptoValesR.
     * 
     * @param numSeguridadSocial
     */
    public void setNumSeguridadSocial(java.lang.String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }


    /**
     * Gets the rfc value for this ConceptoValesR.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this ConceptoValesR.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConceptoValesR)) return false;
        ConceptoValesR other = (ConceptoValesR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.curp==null && other.getCurp()==null) || 
             (this.curp!=null &&
              this.curp.equals(other.getCurp()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.identificador==null && other.getIdentificador()==null) || 
             (this.identificador!=null &&
              this.identificador.equals(other.getIdentificador()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.numSeguridadSocial==null && other.getNumSeguridadSocial()==null) || 
             (this.numSeguridadSocial!=null &&
              this.numSeguridadSocial.equals(other.getNumSeguridadSocial()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc())));
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
        if (getCurp() != null) {
            _hashCode += getCurp().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getIdentificador() != null) {
            _hashCode += getIdentificador().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNumSeguridadSocial() != null) {
            _hashCode += getNumSeguridadSocial().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConceptoValesR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoValesR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Curp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Identificador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numSeguridadSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumSeguridadSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Rfc"));
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
