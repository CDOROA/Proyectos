/**
 * DeduccionesNomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DeduccionesNomina12R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R[] listaDeducciones;

    private java.math.BigDecimal totalImpuestosRetenidos;

    private java.math.BigDecimal totalOtrasDeducciones;

    public DeduccionesNomina12R() {
    }

    public DeduccionesNomina12R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R[] listaDeducciones,
           java.math.BigDecimal totalImpuestosRetenidos,
           java.math.BigDecimal totalOtrasDeducciones) {
           this.listaDeducciones = listaDeducciones;
           this.totalImpuestosRetenidos = totalImpuestosRetenidos;
           this.totalOtrasDeducciones = totalOtrasDeducciones;
    }


    /**
     * Gets the listaDeducciones value for this DeduccionesNomina12R.
     * 
     * @return listaDeducciones
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R[] getListaDeducciones() {
        return listaDeducciones;
    }


    /**
     * Sets the listaDeducciones value for this DeduccionesNomina12R.
     * 
     * @param listaDeducciones
     */
    public void setListaDeducciones(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionNomina12R[] listaDeducciones) {
        this.listaDeducciones = listaDeducciones;
    }


    /**
     * Gets the totalImpuestosRetenidos value for this DeduccionesNomina12R.
     * 
     * @return totalImpuestosRetenidos
     */
    public java.math.BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }


    /**
     * Sets the totalImpuestosRetenidos value for this DeduccionesNomina12R.
     * 
     * @param totalImpuestosRetenidos
     */
    public void setTotalImpuestosRetenidos(java.math.BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }


    /**
     * Gets the totalOtrasDeducciones value for this DeduccionesNomina12R.
     * 
     * @return totalOtrasDeducciones
     */
    public java.math.BigDecimal getTotalOtrasDeducciones() {
        return totalOtrasDeducciones;
    }


    /**
     * Sets the totalOtrasDeducciones value for this DeduccionesNomina12R.
     * 
     * @param totalOtrasDeducciones
     */
    public void setTotalOtrasDeducciones(java.math.BigDecimal totalOtrasDeducciones) {
        this.totalOtrasDeducciones = totalOtrasDeducciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeduccionesNomina12R)) return false;
        DeduccionesNomina12R other = (DeduccionesNomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaDeducciones==null && other.getListaDeducciones()==null) || 
             (this.listaDeducciones!=null &&
              java.util.Arrays.equals(this.listaDeducciones, other.getListaDeducciones()))) &&
            ((this.totalImpuestosRetenidos==null && other.getTotalImpuestosRetenidos()==null) || 
             (this.totalImpuestosRetenidos!=null &&
              this.totalImpuestosRetenidos.equals(other.getTotalImpuestosRetenidos()))) &&
            ((this.totalOtrasDeducciones==null && other.getTotalOtrasDeducciones()==null) || 
             (this.totalOtrasDeducciones!=null &&
              this.totalOtrasDeducciones.equals(other.getTotalOtrasDeducciones())));
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
        if (getListaDeducciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDeducciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDeducciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotalImpuestosRetenidos() != null) {
            _hashCode += getTotalImpuestosRetenidos().hashCode();
        }
        if (getTotalOtrasDeducciones() != null) {
            _hashCode += getTotalOtrasDeducciones().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeduccionesNomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionesNomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDeducciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaDeducciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionNomina12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalImpuestosRetenidos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalImpuestosRetenidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalOtrasDeducciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalOtrasDeducciones"));
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
