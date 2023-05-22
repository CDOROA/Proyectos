/**
 * ImpuestosConcepto40R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ImpuestosConcepto40R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R[] retenciones;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R[] retencionesLocales;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R[] traslados;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R[] trasladosLocales;

    public ImpuestosConcepto40R() {
    }

    public ImpuestosConcepto40R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R[] retenciones,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R[] retencionesLocales,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R[] traslados,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R[] trasladosLocales) {
           this.retenciones = retenciones;
           this.retencionesLocales = retencionesLocales;
           this.traslados = traslados;
           this.trasladosLocales = trasladosLocales;
    }


    /**
     * Gets the retenciones value for this ImpuestosConcepto40R.
     * 
     * @return retenciones
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R[] getRetenciones() {
        return retenciones;
    }


    /**
     * Sets the retenciones value for this ImpuestosConcepto40R.
     * 
     * @param retenciones
     */
    public void setRetenciones(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConcepto40R[] retenciones) {
        this.retenciones = retenciones;
    }


    /**
     * Gets the retencionesLocales value for this ImpuestosConcepto40R.
     * 
     * @return retencionesLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R[] getRetencionesLocales() {
        return retencionesLocales;
    }


    /**
     * Sets the retencionesLocales value for this ImpuestosConcepto40R.
     * 
     * @param retencionesLocales
     */
    public void setRetencionesLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocal40R[] retencionesLocales) {
        this.retencionesLocales = retencionesLocales;
    }


    /**
     * Gets the traslados value for this ImpuestosConcepto40R.
     * 
     * @return traslados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R[] getTraslados() {
        return traslados;
    }


    /**
     * Sets the traslados value for this ImpuestosConcepto40R.
     * 
     * @param traslados
     */
    public void setTraslados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConcepto40R[] traslados) {
        this.traslados = traslados;
    }


    /**
     * Gets the trasladosLocales value for this ImpuestosConcepto40R.
     * 
     * @return trasladosLocales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R[] getTrasladosLocales() {
        return trasladosLocales;
    }


    /**
     * Sets the trasladosLocales value for this ImpuestosConcepto40R.
     * 
     * @param trasladosLocales
     */
    public void setTrasladosLocales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocal40R[] trasladosLocales) {
        this.trasladosLocales = trasladosLocales;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ImpuestosConcepto40R)) return false;
        ImpuestosConcepto40R other = (ImpuestosConcepto40R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retenciones==null && other.getRetenciones()==null) || 
             (this.retenciones!=null &&
              java.util.Arrays.equals(this.retenciones, other.getRetenciones()))) &&
            ((this.retencionesLocales==null && other.getRetencionesLocales()==null) || 
             (this.retencionesLocales!=null &&
              java.util.Arrays.equals(this.retencionesLocales, other.getRetencionesLocales()))) &&
            ((this.traslados==null && other.getTraslados()==null) || 
             (this.traslados!=null &&
              java.util.Arrays.equals(this.traslados, other.getTraslados()))) &&
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
        if (getRetenciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetenciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetenciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getTraslados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTraslados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTraslados(), i);
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
        new org.apache.axis.description.TypeDesc(ImpuestosConcepto40R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosConcepto40R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retenciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Retenciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConcepto40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionConcepto40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionesLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocal40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionLocal40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("traslados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Traslados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConcepto40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoConcepto40R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosLocales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladosLocales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocal40R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladoLocal40R"));
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
