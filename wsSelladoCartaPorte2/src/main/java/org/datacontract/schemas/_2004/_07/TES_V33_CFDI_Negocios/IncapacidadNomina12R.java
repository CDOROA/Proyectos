/**
 * IncapacidadNomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IncapacidadNomina12R  implements java.io.Serializable {
    private java.lang.Integer diasIncapacidad;

    private java.math.BigDecimal importeMonetario;

    private java.lang.String tipoIncapacidad;

    public IncapacidadNomina12R() {
    }

    public IncapacidadNomina12R(
           java.lang.Integer diasIncapacidad,
           java.math.BigDecimal importeMonetario,
           java.lang.String tipoIncapacidad) {
           this.diasIncapacidad = diasIncapacidad;
           this.importeMonetario = importeMonetario;
           this.tipoIncapacidad = tipoIncapacidad;
    }


    /**
     * Gets the diasIncapacidad value for this IncapacidadNomina12R.
     * 
     * @return diasIncapacidad
     */
    public java.lang.Integer getDiasIncapacidad() {
        return diasIncapacidad;
    }


    /**
     * Sets the diasIncapacidad value for this IncapacidadNomina12R.
     * 
     * @param diasIncapacidad
     */
    public void setDiasIncapacidad(java.lang.Integer diasIncapacidad) {
        this.diasIncapacidad = diasIncapacidad;
    }


    /**
     * Gets the importeMonetario value for this IncapacidadNomina12R.
     * 
     * @return importeMonetario
     */
    public java.math.BigDecimal getImporteMonetario() {
        return importeMonetario;
    }


    /**
     * Sets the importeMonetario value for this IncapacidadNomina12R.
     * 
     * @param importeMonetario
     */
    public void setImporteMonetario(java.math.BigDecimal importeMonetario) {
        this.importeMonetario = importeMonetario;
    }


    /**
     * Gets the tipoIncapacidad value for this IncapacidadNomina12R.
     * 
     * @return tipoIncapacidad
     */
    public java.lang.String getTipoIncapacidad() {
        return tipoIncapacidad;
    }


    /**
     * Sets the tipoIncapacidad value for this IncapacidadNomina12R.
     * 
     * @param tipoIncapacidad
     */
    public void setTipoIncapacidad(java.lang.String tipoIncapacidad) {
        this.tipoIncapacidad = tipoIncapacidad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IncapacidadNomina12R)) return false;
        IncapacidadNomina12R other = (IncapacidadNomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diasIncapacidad==null && other.getDiasIncapacidad()==null) || 
             (this.diasIncapacidad!=null &&
              this.diasIncapacidad.equals(other.getDiasIncapacidad()))) &&
            ((this.importeMonetario==null && other.getImporteMonetario()==null) || 
             (this.importeMonetario!=null &&
              this.importeMonetario.equals(other.getImporteMonetario()))) &&
            ((this.tipoIncapacidad==null && other.getTipoIncapacidad()==null) || 
             (this.tipoIncapacidad!=null &&
              this.tipoIncapacidad.equals(other.getTipoIncapacidad())));
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
        if (getDiasIncapacidad() != null) {
            _hashCode += getDiasIncapacidad().hashCode();
        }
        if (getImporteMonetario() != null) {
            _hashCode += getImporteMonetario().hashCode();
        }
        if (getTipoIncapacidad() != null) {
            _hashCode += getTipoIncapacidad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IncapacidadNomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasIncapacidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DiasIncapacidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeMonetario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImporteMonetario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoIncapacidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoIncapacidad"));
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
