/**
 * EntidadR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class EntidadR  implements java.io.Serializable {
    private java.lang.String ambito;

    private java.lang.String claveEntidad;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR[] contabilidad;

    public EntidadR() {
    }

    public EntidadR(
           java.lang.String ambito,
           java.lang.String claveEntidad,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR[] contabilidad) {
           this.ambito = ambito;
           this.claveEntidad = claveEntidad;
           this.contabilidad = contabilidad;
    }


    /**
     * Gets the ambito value for this EntidadR.
     * 
     * @return ambito
     */
    public java.lang.String getAmbito() {
        return ambito;
    }


    /**
     * Sets the ambito value for this EntidadR.
     * 
     * @param ambito
     */
    public void setAmbito(java.lang.String ambito) {
        this.ambito = ambito;
    }


    /**
     * Gets the claveEntidad value for this EntidadR.
     * 
     * @return claveEntidad
     */
    public java.lang.String getClaveEntidad() {
        return claveEntidad;
    }


    /**
     * Sets the claveEntidad value for this EntidadR.
     * 
     * @param claveEntidad
     */
    public void setClaveEntidad(java.lang.String claveEntidad) {
        this.claveEntidad = claveEntidad;
    }


    /**
     * Gets the contabilidad value for this EntidadR.
     * 
     * @return contabilidad
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR[] getContabilidad() {
        return contabilidad;
    }


    /**
     * Sets the contabilidad value for this EntidadR.
     * 
     * @param contabilidad
     */
    public void setContabilidad(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ContabilidadR[] contabilidad) {
        this.contabilidad = contabilidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntidadR)) return false;
        EntidadR other = (EntidadR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ambito==null && other.getAmbito()==null) || 
             (this.ambito!=null &&
              this.ambito.equals(other.getAmbito()))) &&
            ((this.claveEntidad==null && other.getClaveEntidad()==null) || 
             (this.claveEntidad!=null &&
              this.claveEntidad.equals(other.getClaveEntidad()))) &&
            ((this.contabilidad==null && other.getContabilidad()==null) || 
             (this.contabilidad!=null &&
              java.util.Arrays.equals(this.contabilidad, other.getContabilidad())));
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
        if (getAmbito() != null) {
            _hashCode += getAmbito().hashCode();
        }
        if (getClaveEntidad() != null) {
            _hashCode += getClaveEntidad().hashCode();
        }
        if (getContabilidad() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContabilidad());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContabilidad(), i);
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
        new org.apache.axis.description.TypeDesc(EntidadR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ambito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Ambito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveEntidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveEntidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contabilidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Contabilidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContabilidadR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ContabilidadR"));
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
