/**
 * HorasExtra12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class HorasExtra12R  implements java.io.Serializable {
    private java.lang.Integer dias;

    private java.lang.Integer horasExtra;

    private java.math.BigDecimal importePagado;

    private java.lang.String tipoHoras;

    public HorasExtra12R() {
    }

    public HorasExtra12R(
           java.lang.Integer dias,
           java.lang.Integer horasExtra,
           java.math.BigDecimal importePagado,
           java.lang.String tipoHoras) {
           this.dias = dias;
           this.horasExtra = horasExtra;
           this.importePagado = importePagado;
           this.tipoHoras = tipoHoras;
    }


    /**
     * Gets the dias value for this HorasExtra12R.
     * 
     * @return dias
     */
    public java.lang.Integer getDias() {
        return dias;
    }


    /**
     * Sets the dias value for this HorasExtra12R.
     * 
     * @param dias
     */
    public void setDias(java.lang.Integer dias) {
        this.dias = dias;
    }


    /**
     * Gets the horasExtra value for this HorasExtra12R.
     * 
     * @return horasExtra
     */
    public java.lang.Integer getHorasExtra() {
        return horasExtra;
    }


    /**
     * Sets the horasExtra value for this HorasExtra12R.
     * 
     * @param horasExtra
     */
    public void setHorasExtra(java.lang.Integer horasExtra) {
        this.horasExtra = horasExtra;
    }


    /**
     * Gets the importePagado value for this HorasExtra12R.
     * 
     * @return importePagado
     */
    public java.math.BigDecimal getImportePagado() {
        return importePagado;
    }


    /**
     * Sets the importePagado value for this HorasExtra12R.
     * 
     * @param importePagado
     */
    public void setImportePagado(java.math.BigDecimal importePagado) {
        this.importePagado = importePagado;
    }


    /**
     * Gets the tipoHoras value for this HorasExtra12R.
     * 
     * @return tipoHoras
     */
    public java.lang.String getTipoHoras() {
        return tipoHoras;
    }


    /**
     * Sets the tipoHoras value for this HorasExtra12R.
     * 
     * @param tipoHoras
     */
    public void setTipoHoras(java.lang.String tipoHoras) {
        this.tipoHoras = tipoHoras;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HorasExtra12R)) return false;
        HorasExtra12R other = (HorasExtra12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dias==null && other.getDias()==null) || 
             (this.dias!=null &&
              this.dias.equals(other.getDias()))) &&
            ((this.horasExtra==null && other.getHorasExtra()==null) || 
             (this.horasExtra!=null &&
              this.horasExtra.equals(other.getHorasExtra()))) &&
            ((this.importePagado==null && other.getImportePagado()==null) || 
             (this.importePagado!=null &&
              this.importePagado.equals(other.getImportePagado()))) &&
            ((this.tipoHoras==null && other.getTipoHoras()==null) || 
             (this.tipoHoras!=null &&
              this.tipoHoras.equals(other.getTipoHoras())));
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
        if (getDias() != null) {
            _hashCode += getDias().hashCode();
        }
        if (getHorasExtra() != null) {
            _hashCode += getHorasExtra().hashCode();
        }
        if (getImportePagado() != null) {
            _hashCode += getImportePagado().hashCode();
        }
        if (getTipoHoras() != null) {
            _hashCode += getTipoHoras().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HorasExtra12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Dias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasExtra");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importePagado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImportePagado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoHoras"));
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
