/**
 * DetallesConceptoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DetallesConceptoR  implements java.io.Serializable {
    private java.math.BigDecimal descuento;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR[] retencionesLocales;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR[] trasladosLocales;

    public DetallesConceptoR() {
    }

    public DetallesConceptoR(
           java.math.BigDecimal descuento,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR[] retencionesLocales,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR[] trasladosLocales) {
           this.descuento = descuento;
           this.retencionesLocales = retencionesLocales;
           this.trasladosLocales = trasladosLocales;
    }


    /**
     * Gets the descuento value for this DetallesConceptoR.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this DetallesConceptoR.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the retencionesLocales value for this DetallesConceptoR.
     * 
     * @return retencionesLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR[] getRetencionesLocales() {
        return retencionesLocales;
    }


    /**
     * Sets the retencionesLocales value for this DetallesConceptoR.
     * 
     * @param retencionesLocales
     */
    public void setRetencionesLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleRetencionLocalR[] retencionesLocales) {
        this.retencionesLocales = retencionesLocales;
    }


    /**
     * Gets the trasladosLocales value for this DetallesConceptoR.
     * 
     * @return trasladosLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR[] getTrasladosLocales() {
        return trasladosLocales;
    }


    /**
     * Sets the trasladosLocales value for this DetallesConceptoR.
     * 
     * @param trasladosLocales
     */
    public void setTrasladosLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleTrasladoLocalR[] trasladosLocales) {
        this.trasladosLocales = trasladosLocales;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetallesConceptoR)) return false;
        DetallesConceptoR other = (DetallesConceptoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.retencionesLocales==null && other.getRetencionesLocales()==null) || 
             (this.retencionesLocales!=null &&
              java.util.Arrays.equals(this.retencionesLocales, other.getRetencionesLocales()))) &&
            ((this.trasladosLocales==null && other.getTrasladosLocales()==null) || 
             (this.trasladosLocales!=null &&
              java.util.Arrays.equals(this.trasladosLocales, other.getTrasladosLocales())));
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
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
        }
        if (getRetencionesLocales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetencionesLocales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetencionesLocales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTrasladosLocales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrasladosLocales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrasladosLocales(), i);
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
        new org.apache.axis.description.TypeDesc(DetallesConceptoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionesLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocalR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleRetencionLocalR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladosLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocalR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleTrasladoLocalR"));
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
