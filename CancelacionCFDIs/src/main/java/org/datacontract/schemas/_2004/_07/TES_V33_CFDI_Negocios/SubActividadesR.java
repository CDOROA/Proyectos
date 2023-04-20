/**
 * SubActividadesR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class SubActividadesR  implements java.io.Serializable {
    private java.lang.String subActividadRelacionada;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR[] tareas;

    public SubActividadesR() {
    }

    public SubActividadesR(
           java.lang.String subActividadRelacionada,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR[] tareas) {
           this.subActividadRelacionada = subActividadRelacionada;
           this.tareas = tareas;
    }


    /**
     * Gets the subActividadRelacionada value for this SubActividadesR.
     * 
     * @return subActividadRelacionada
     */
    public java.lang.String getSubActividadRelacionada() {
        return subActividadRelacionada;
    }


    /**
     * Sets the subActividadRelacionada value for this SubActividadesR.
     * 
     * @param subActividadRelacionada
     */
    public void setSubActividadRelacionada(java.lang.String subActividadRelacionada) {
        this.subActividadRelacionada = subActividadRelacionada;
    }


    /**
     * Gets the tareas value for this SubActividadesR.
     * 
     * @return tareas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR[] getTareas() {
        return tareas;
    }


    /**
     * Sets the tareas value for this SubActividadesR.
     * 
     * @param tareas
     */
    public void setTareas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TareasR[] tareas) {
        this.tareas = tareas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubActividadesR)) return false;
        SubActividadesR other = (SubActividadesR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subActividadRelacionada==null && other.getSubActividadRelacionada()==null) || 
             (this.subActividadRelacionada!=null &&
              this.subActividadRelacionada.equals(other.getSubActividadRelacionada()))) &&
            ((this.tareas==null && other.getTareas()==null) || 
             (this.tareas!=null &&
              java.util.Arrays.equals(this.tareas, other.getTareas())));
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
        if (getSubActividadRelacionada() != null) {
            _hashCode += getSubActividadRelacionada().hashCode();
        }
        if (getTareas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTareas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTareas(), i);
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
        new org.apache.axis.description.TypeDesc(SubActividadesR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadesR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subActividadRelacionada");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubActividadRelacionada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tareas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Tareas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TareasR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TareasR"));
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
