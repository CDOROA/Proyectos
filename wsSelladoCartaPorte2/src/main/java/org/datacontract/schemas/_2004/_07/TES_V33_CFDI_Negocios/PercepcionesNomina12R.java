/**
 * PercepcionesNomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PercepcionesNomina12R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR jubilacionPensionRetiroR;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R[] listaPercepciones;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR separacionIndemnizacionR;

    private java.math.BigDecimal totalExento;

    private java.math.BigDecimal totalGravado;

    private java.math.BigDecimal totalJubilacionPensionRetiro;

    private java.math.BigDecimal totalSeparacionIndemnizacion;

    private java.math.BigDecimal totalSueldos;

    public PercepcionesNomina12R() {
    }

    public PercepcionesNomina12R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR jubilacionPensionRetiroR,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R[] listaPercepciones,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR separacionIndemnizacionR,
           java.math.BigDecimal totalExento,
           java.math.BigDecimal totalGravado,
           java.math.BigDecimal totalJubilacionPensionRetiro,
           java.math.BigDecimal totalSeparacionIndemnizacion,
           java.math.BigDecimal totalSueldos) {
           this.jubilacionPensionRetiroR = jubilacionPensionRetiroR;
           this.listaPercepciones = listaPercepciones;
           this.separacionIndemnizacionR = separacionIndemnizacionR;
           this.totalExento = totalExento;
           this.totalGravado = totalGravado;
           this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
           this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
           this.totalSueldos = totalSueldos;
    }


    /**
     * Gets the jubilacionPensionRetiroR value for this PercepcionesNomina12R.
     * 
     * @return jubilacionPensionRetiroR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR getJubilacionPensionRetiroR() {
        return jubilacionPensionRetiroR;
    }


    /**
     * Sets the jubilacionPensionRetiroR value for this PercepcionesNomina12R.
     * 
     * @param jubilacionPensionRetiroR
     */
    public void setJubilacionPensionRetiroR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.JubilacionPensionRetiroR jubilacionPensionRetiroR) {
        this.jubilacionPensionRetiroR = jubilacionPensionRetiroR;
    }


    /**
     * Gets the listaPercepciones value for this PercepcionesNomina12R.
     * 
     * @return listaPercepciones
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R[] getListaPercepciones() {
        return listaPercepciones;
    }


    /**
     * Sets the listaPercepciones value for this PercepcionesNomina12R.
     * 
     * @param listaPercepciones
     */
    public void setListaPercepciones(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Percepcion12R[] listaPercepciones) {
        this.listaPercepciones = listaPercepciones;
    }


    /**
     * Gets the separacionIndemnizacionR value for this PercepcionesNomina12R.
     * 
     * @return separacionIndemnizacionR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR getSeparacionIndemnizacionR() {
        return separacionIndemnizacionR;
    }


    /**
     * Sets the separacionIndemnizacionR value for this PercepcionesNomina12R.
     * 
     * @param separacionIndemnizacionR
     */
    public void setSeparacionIndemnizacionR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.SeparacionIndemnizacionR separacionIndemnizacionR) {
        this.separacionIndemnizacionR = separacionIndemnizacionR;
    }


    /**
     * Gets the totalExento value for this PercepcionesNomina12R.
     * 
     * @return totalExento
     */
    public java.math.BigDecimal getTotalExento() {
        return totalExento;
    }


    /**
     * Sets the totalExento value for this PercepcionesNomina12R.
     * 
     * @param totalExento
     */
    public void setTotalExento(java.math.BigDecimal totalExento) {
        this.totalExento = totalExento;
    }


    /**
     * Gets the totalGravado value for this PercepcionesNomina12R.
     * 
     * @return totalGravado
     */
    public java.math.BigDecimal getTotalGravado() {
        return totalGravado;
    }


    /**
     * Sets the totalGravado value for this PercepcionesNomina12R.
     * 
     * @param totalGravado
     */
    public void setTotalGravado(java.math.BigDecimal totalGravado) {
        this.totalGravado = totalGravado;
    }


    /**
     * Gets the totalJubilacionPensionRetiro value for this PercepcionesNomina12R.
     * 
     * @return totalJubilacionPensionRetiro
     */
    public java.math.BigDecimal getTotalJubilacionPensionRetiro() {
        return totalJubilacionPensionRetiro;
    }


    /**
     * Sets the totalJubilacionPensionRetiro value for this PercepcionesNomina12R.
     * 
     * @param totalJubilacionPensionRetiro
     */
    public void setTotalJubilacionPensionRetiro(java.math.BigDecimal totalJubilacionPensionRetiro) {
        this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
    }


    /**
     * Gets the totalSeparacionIndemnizacion value for this PercepcionesNomina12R.
     * 
     * @return totalSeparacionIndemnizacion
     */
    public java.math.BigDecimal getTotalSeparacionIndemnizacion() {
        return totalSeparacionIndemnizacion;
    }


    /**
     * Sets the totalSeparacionIndemnizacion value for this PercepcionesNomina12R.
     * 
     * @param totalSeparacionIndemnizacion
     */
    public void setTotalSeparacionIndemnizacion(java.math.BigDecimal totalSeparacionIndemnizacion) {
        this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
    }


    /**
     * Gets the totalSueldos value for this PercepcionesNomina12R.
     * 
     * @return totalSueldos
     */
    public java.math.BigDecimal getTotalSueldos() {
        return totalSueldos;
    }


    /**
     * Sets the totalSueldos value for this PercepcionesNomina12R.
     * 
     * @param totalSueldos
     */
    public void setTotalSueldos(java.math.BigDecimal totalSueldos) {
        this.totalSueldos = totalSueldos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PercepcionesNomina12R)) return false;
        PercepcionesNomina12R other = (PercepcionesNomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jubilacionPensionRetiroR==null && other.getJubilacionPensionRetiroR()==null) || 
             (this.jubilacionPensionRetiroR!=null &&
              this.jubilacionPensionRetiroR.equals(other.getJubilacionPensionRetiroR()))) &&
            ((this.listaPercepciones==null && other.getListaPercepciones()==null) || 
             (this.listaPercepciones!=null &&
              java.util.Arrays.equals(this.listaPercepciones, other.getListaPercepciones()))) &&
            ((this.separacionIndemnizacionR==null && other.getSeparacionIndemnizacionR()==null) || 
             (this.separacionIndemnizacionR!=null &&
              this.separacionIndemnizacionR.equals(other.getSeparacionIndemnizacionR()))) &&
            ((this.totalExento==null && other.getTotalExento()==null) || 
             (this.totalExento!=null &&
              this.totalExento.equals(other.getTotalExento()))) &&
            ((this.totalGravado==null && other.getTotalGravado()==null) || 
             (this.totalGravado!=null &&
              this.totalGravado.equals(other.getTotalGravado()))) &&
            ((this.totalJubilacionPensionRetiro==null && other.getTotalJubilacionPensionRetiro()==null) || 
             (this.totalJubilacionPensionRetiro!=null &&
              this.totalJubilacionPensionRetiro.equals(other.getTotalJubilacionPensionRetiro()))) &&
            ((this.totalSeparacionIndemnizacion==null && other.getTotalSeparacionIndemnizacion()==null) || 
             (this.totalSeparacionIndemnizacion!=null &&
              this.totalSeparacionIndemnizacion.equals(other.getTotalSeparacionIndemnizacion()))) &&
            ((this.totalSueldos==null && other.getTotalSueldos()==null) || 
             (this.totalSueldos!=null &&
              this.totalSueldos.equals(other.getTotalSueldos())));
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
        if (getJubilacionPensionRetiroR() != null) {
            _hashCode += getJubilacionPensionRetiroR().hashCode();
        }
        if (getListaPercepciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPercepciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPercepciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeparacionIndemnizacionR() != null) {
            _hashCode += getSeparacionIndemnizacionR().hashCode();
        }
        if (getTotalExento() != null) {
            _hashCode += getTotalExento().hashCode();
        }
        if (getTotalGravado() != null) {
            _hashCode += getTotalGravado().hashCode();
        }
        if (getTotalJubilacionPensionRetiro() != null) {
            _hashCode += getTotalJubilacionPensionRetiro().hashCode();
        }
        if (getTotalSeparacionIndemnizacion() != null) {
            _hashCode += getTotalSeparacionIndemnizacion().hashCode();
        }
        if (getTotalSueldos() != null) {
            _hashCode += getTotalSueldos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PercepcionesNomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PercepcionesNomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jubilacionPensionRetiroR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "JubilacionPensionRetiroR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "JubilacionPensionRetiroR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPercepciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaPercepciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("separacionIndemnizacionR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SeparacionIndemnizacionR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SeparacionIndemnizacionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalExento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalExento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalGravado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalGravado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalJubilacionPensionRetiro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalJubilacionPensionRetiro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSeparacionIndemnizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalSeparacionIndemnizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSueldos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalSueldos"));
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
