/**
 * INER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class INER  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR[] entidades;

    private java.lang.Integer idContabilidad;

    private java.lang.String tipoProceso;

    private java.lang.String tipocomite;

    public INER() {
    }

    public INER(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR[] entidades,
           java.lang.Integer idContabilidad,
           java.lang.String tipoProceso,
           java.lang.String tipocomite) {
           this.entidades = entidades;
           this.idContabilidad = idContabilidad;
           this.tipoProceso = tipoProceso;
           this.tipocomite = tipocomite;
    }


    /**
     * Gets the entidades value for this INER.
     * 
     * @return entidades
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR[] getEntidades() {
        return entidades;
    }


    /**
     * Sets the entidades value for this INER.
     * 
     * @param entidades
     */
    public void setEntidades(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EntidadR[] entidades) {
        this.entidades = entidades;
    }


    /**
     * Gets the idContabilidad value for this INER.
     * 
     * @return idContabilidad
     */
    public java.lang.Integer getIdContabilidad() {
        return idContabilidad;
    }


    /**
     * Sets the idContabilidad value for this INER.
     * 
     * @param idContabilidad
     */
    public void setIdContabilidad(java.lang.Integer idContabilidad) {
        this.idContabilidad = idContabilidad;
    }


    /**
     * Gets the tipoProceso value for this INER.
     * 
     * @return tipoProceso
     */
    public java.lang.String getTipoProceso() {
        return tipoProceso;
    }


    /**
     * Sets the tipoProceso value for this INER.
     * 
     * @param tipoProceso
     */
    public void setTipoProceso(java.lang.String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }


    /**
     * Gets the tipocomite value for this INER.
     * 
     * @return tipocomite
     */
    public java.lang.String getTipocomite() {
        return tipocomite;
    }


    /**
     * Sets the tipocomite value for this INER.
     * 
     * @param tipocomite
     */
    public void setTipocomite(java.lang.String tipocomite) {
        this.tipocomite = tipocomite;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof INER)) return false;
        INER other = (INER) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entidades==null && other.getEntidades()==null) || 
             (this.entidades!=null &&
              java.util.Arrays.equals(this.entidades, other.getEntidades()))) &&
            ((this.idContabilidad==null && other.getIdContabilidad()==null) || 
             (this.idContabilidad!=null &&
              this.idContabilidad.equals(other.getIdContabilidad()))) &&
            ((this.tipoProceso==null && other.getTipoProceso()==null) || 
             (this.tipoProceso!=null &&
              this.tipoProceso.equals(other.getTipoProceso()))) &&
            ((this.tipocomite==null && other.getTipocomite()==null) || 
             (this.tipocomite!=null &&
              this.tipocomite.equals(other.getTipocomite())));
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
        if (getEntidades() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEntidades());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEntidades(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdContabilidad() != null) {
            _hashCode += getIdContabilidad().hashCode();
        }
        if (getTipoProceso() != null) {
            _hashCode += getTipoProceso().hashCode();
        }
        if (getTipocomite() != null) {
            _hashCode += getTipocomite().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(INER.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "INER"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entidades");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Entidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EntidadR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idContabilidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdContabilidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProceso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoProceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipocomite");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Tipocomite"));
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
