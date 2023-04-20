/**
 * ComercioExteriorMercancia11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ComercioExteriorMercancia11R  implements java.io.Serializable {
    private java.math.BigDecimal cantidadAduana;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R[] descripcionesEspecificas;

    private java.lang.String fraccionArancelaria;

    private java.lang.String noIdentificacion;

    private java.lang.String unidadAduana;

    private java.math.BigDecimal valorDolares;

    private java.math.BigDecimal valorUnitarioAduana;

    public ComercioExteriorMercancia11R() {
    }

    public ComercioExteriorMercancia11R(
           java.math.BigDecimal cantidadAduana,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R[] descripcionesEspecificas,
           java.lang.String fraccionArancelaria,
           java.lang.String noIdentificacion,
           java.lang.String unidadAduana,
           java.math.BigDecimal valorDolares,
           java.math.BigDecimal valorUnitarioAduana) {
           this.cantidadAduana = cantidadAduana;
           this.descripcionesEspecificas = descripcionesEspecificas;
           this.fraccionArancelaria = fraccionArancelaria;
           this.noIdentificacion = noIdentificacion;
           this.unidadAduana = unidadAduana;
           this.valorDolares = valorDolares;
           this.valorUnitarioAduana = valorUnitarioAduana;
    }


    /**
     * Gets the cantidadAduana value for this ComercioExteriorMercancia11R.
     * 
     * @return cantidadAduana
     */
    public java.math.BigDecimal getCantidadAduana() {
        return cantidadAduana;
    }


    /**
     * Sets the cantidadAduana value for this ComercioExteriorMercancia11R.
     * 
     * @param cantidadAduana
     */
    public void setCantidadAduana(java.math.BigDecimal cantidadAduana) {
        this.cantidadAduana = cantidadAduana;
    }


    /**
     * Gets the descripcionesEspecificas value for this ComercioExteriorMercancia11R.
     * 
     * @return descripcionesEspecificas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R[] getDescripcionesEspecificas() {
        return descripcionesEspecificas;
    }


    /**
     * Sets the descripcionesEspecificas value for this ComercioExteriorMercancia11R.
     * 
     * @param descripcionesEspecificas
     */
    public void setDescripcionesEspecificas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercanciaDescripcionesEspecificas11R[] descripcionesEspecificas) {
        this.descripcionesEspecificas = descripcionesEspecificas;
    }


    /**
     * Gets the fraccionArancelaria value for this ComercioExteriorMercancia11R.
     * 
     * @return fraccionArancelaria
     */
    public java.lang.String getFraccionArancelaria() {
        return fraccionArancelaria;
    }


    /**
     * Sets the fraccionArancelaria value for this ComercioExteriorMercancia11R.
     * 
     * @param fraccionArancelaria
     */
    public void setFraccionArancelaria(java.lang.String fraccionArancelaria) {
        this.fraccionArancelaria = fraccionArancelaria;
    }


    /**
     * Gets the noIdentificacion value for this ComercioExteriorMercancia11R.
     * 
     * @return noIdentificacion
     */
    public java.lang.String getNoIdentificacion() {
        return noIdentificacion;
    }


    /**
     * Sets the noIdentificacion value for this ComercioExteriorMercancia11R.
     * 
     * @param noIdentificacion
     */
    public void setNoIdentificacion(java.lang.String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }


    /**
     * Gets the unidadAduana value for this ComercioExteriorMercancia11R.
     * 
     * @return unidadAduana
     */
    public java.lang.String getUnidadAduana() {
        return unidadAduana;
    }


    /**
     * Sets the unidadAduana value for this ComercioExteriorMercancia11R.
     * 
     * @param unidadAduana
     */
    public void setUnidadAduana(java.lang.String unidadAduana) {
        this.unidadAduana = unidadAduana;
    }


    /**
     * Gets the valorDolares value for this ComercioExteriorMercancia11R.
     * 
     * @return valorDolares
     */
    public java.math.BigDecimal getValorDolares() {
        return valorDolares;
    }


    /**
     * Sets the valorDolares value for this ComercioExteriorMercancia11R.
     * 
     * @param valorDolares
     */
    public void setValorDolares(java.math.BigDecimal valorDolares) {
        this.valorDolares = valorDolares;
    }


    /**
     * Gets the valorUnitarioAduana value for this ComercioExteriorMercancia11R.
     * 
     * @return valorUnitarioAduana
     */
    public java.math.BigDecimal getValorUnitarioAduana() {
        return valorUnitarioAduana;
    }


    /**
     * Sets the valorUnitarioAduana value for this ComercioExteriorMercancia11R.
     * 
     * @param valorUnitarioAduana
     */
    public void setValorUnitarioAduana(java.math.BigDecimal valorUnitarioAduana) {
        this.valorUnitarioAduana = valorUnitarioAduana;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExteriorMercancia11R)) return false;
        ComercioExteriorMercancia11R other = (ComercioExteriorMercancia11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cantidadAduana==null && other.getCantidadAduana()==null) || 
             (this.cantidadAduana!=null &&
              this.cantidadAduana.equals(other.getCantidadAduana()))) &&
            ((this.descripcionesEspecificas==null && other.getDescripcionesEspecificas()==null) || 
             (this.descripcionesEspecificas!=null &&
              java.util.Arrays.equals(this.descripcionesEspecificas, other.getDescripcionesEspecificas()))) &&
            ((this.fraccionArancelaria==null && other.getFraccionArancelaria()==null) || 
             (this.fraccionArancelaria!=null &&
              this.fraccionArancelaria.equals(other.getFraccionArancelaria()))) &&
            ((this.noIdentificacion==null && other.getNoIdentificacion()==null) || 
             (this.noIdentificacion!=null &&
              this.noIdentificacion.equals(other.getNoIdentificacion()))) &&
            ((this.unidadAduana==null && other.getUnidadAduana()==null) || 
             (this.unidadAduana!=null &&
              this.unidadAduana.equals(other.getUnidadAduana()))) &&
            ((this.valorDolares==null && other.getValorDolares()==null) || 
             (this.valorDolares!=null &&
              this.valorDolares.equals(other.getValorDolares()))) &&
            ((this.valorUnitarioAduana==null && other.getValorUnitarioAduana()==null) || 
             (this.valorUnitarioAduana!=null &&
              this.valorUnitarioAduana.equals(other.getValorUnitarioAduana())));
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
        if (getCantidadAduana() != null) {
            _hashCode += getCantidadAduana().hashCode();
        }
        if (getDescripcionesEspecificas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDescripcionesEspecificas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDescripcionesEspecificas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFraccionArancelaria() != null) {
            _hashCode += getFraccionArancelaria().hashCode();
        }
        if (getNoIdentificacion() != null) {
            _hashCode += getNoIdentificacion().hashCode();
        }
        if (getUnidadAduana() != null) {
            _hashCode += getUnidadAduana().hashCode();
        }
        if (getValorDolares() != null) {
            _hashCode += getValorDolares().hashCode();
        }
        if (getValorUnitarioAduana() != null) {
            _hashCode += getValorUnitarioAduana().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExteriorMercancia11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadAduana");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CantidadAduana"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionesEspecificas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescripcionesEspecificas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercanciaDescripcionesEspecificas11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercanciaDescripcionesEspecificas11R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraccionArancelaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FraccionArancelaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NoIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadAduana");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UnidadAduana"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorDolares");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorDolares"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorUnitarioAduana");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorUnitarioAduana"));
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
