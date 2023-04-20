/**
 * ActividadesR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ActividadesR  implements java.io.Serializable {
    private java.lang.String actividadRelacionada;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR[] subActividades;

    public ActividadesR() {
    }

    public ActividadesR(
           java.lang.String actividadRelacionada,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR[] subActividades) {
           this.actividadRelacionada = actividadRelacionada;
           this.subActividades = subActividades;
    }


    /**
     * Gets the actividadRelacionada value for this ActividadesR.
     * 
     * @return actividadRelacionada
     */
    public java.lang.String getActividadRelacionada() {
        return actividadRelacionada;
    }


    /**
     * Sets the actividadRelacionada value for this ActividadesR.
     * 
     * @param actividadRelacionada
     */
    public void setActividadRelacionada(java.lang.String actividadRelacionada) {
        this.actividadRelacionada = actividadRelacionada;
    }


    /**
     * Gets the subActividades value for this ActividadesR.
     * 
     * @return subActividades
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR[] getSubActividades() {
        return subActividades;
    }


    /**
     * Sets the subActividades value for this ActividadesR.
     * 
     * @param subActividades
     */
    public void setSubActividades(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SubActividadesR[] subActividades) {
        this.subActividades = subActividades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ActividadesR)) return false;
        ActividadesR other = (ActividadesR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actividadRelacionada==null && other.getActividadRelacionada()==null) || 
             (this.actividadRelacionada!=null &&
              this.actividadRelacionada.equals(other.getActividadRelacionada()))) &&
            ((this.subActividades==null && other.getSubActividades()==null) || 
             (this.subActividades!=null &&
              java.util.Arrays.equals(this.subActividades, other.getSubActividades())));
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
        if (getActividadRelacionada() != null) {
            _hashCode += getActividadRelacionada().hashCode();
        }
        if (getSubActividades() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubActividades());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubActividades(), i);
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
        new org.apache.axis.description.TypeDesc(ActividadesR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadesR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actividadRelacionada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ActividadRelacionada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subActividades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR"));
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
