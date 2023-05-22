/**
 * IdentificacionDeRecursoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IdentificacionDeRecursoR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR[] dispersionDelRecurso;

    private java.lang.String fechaDep;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR[] identificacionDelGasto;

    private java.math.BigDecimal montoEntregado;

    private java.lang.String reintegroRemanFecha;

    private java.math.BigDecimal reintegroRemanente;

    private java.math.BigDecimal remanente;

    private java.lang.String tipoOperacion;

    public IdentificacionDeRecursoR() {
    }

    public IdentificacionDeRecursoR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR[] dispersionDelRecurso,
           java.lang.String fechaDep,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR[] identificacionDelGasto,
           java.math.BigDecimal montoEntregado,
           java.lang.String reintegroRemanFecha,
           java.math.BigDecimal reintegroRemanente,
           java.math.BigDecimal remanente,
           java.lang.String tipoOperacion) {
           this.dispersionDelRecurso = dispersionDelRecurso;
           this.fechaDep = fechaDep;
           this.identificacionDelGasto = identificacionDelGasto;
           this.montoEntregado = montoEntregado;
           this.reintegroRemanFecha = reintegroRemanFecha;
           this.reintegroRemanente = reintegroRemanente;
           this.remanente = remanente;
           this.tipoOperacion = tipoOperacion;
    }


    /**
     * Gets the dispersionDelRecurso value for this IdentificacionDeRecursoR.
     * 
     * @return dispersionDelRecurso
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR[] getDispersionDelRecurso() {
        return dispersionDelRecurso;
    }


    /**
     * Sets the dispersionDelRecurso value for this IdentificacionDeRecursoR.
     * 
     * @param dispersionDelRecurso
     */
    public void setDispersionDelRecurso(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DispersionDelRecursoR[] dispersionDelRecurso) {
        this.dispersionDelRecurso = dispersionDelRecurso;
    }


    /**
     * Gets the fechaDep value for this IdentificacionDeRecursoR.
     * 
     * @return fechaDep
     */
    public java.lang.String getFechaDep() {
        return fechaDep;
    }


    /**
     * Sets the fechaDep value for this IdentificacionDeRecursoR.
     * 
     * @param fechaDep
     */
    public void setFechaDep(java.lang.String fechaDep) {
        this.fechaDep = fechaDep;
    }


    /**
     * Gets the identificacionDelGasto value for this IdentificacionDeRecursoR.
     * 
     * @return identificacionDelGasto
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR[] getIdentificacionDelGasto() {
        return identificacionDelGasto;
    }


    /**
     * Sets the identificacionDelGasto value for this IdentificacionDeRecursoR.
     * 
     * @param identificacionDelGasto
     */
    public void setIdentificacionDelGasto(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IdentificacionDelGastoR[] identificacionDelGasto) {
        this.identificacionDelGasto = identificacionDelGasto;
    }


    /**
     * Gets the montoEntregado value for this IdentificacionDeRecursoR.
     * 
     * @return montoEntregado
     */
    public java.math.BigDecimal getMontoEntregado() {
        return montoEntregado;
    }


    /**
     * Sets the montoEntregado value for this IdentificacionDeRecursoR.
     * 
     * @param montoEntregado
     */
    public void setMontoEntregado(java.math.BigDecimal montoEntregado) {
        this.montoEntregado = montoEntregado;
    }


    /**
     * Gets the reintegroRemanFecha value for this IdentificacionDeRecursoR.
     * 
     * @return reintegroRemanFecha
     */
    public java.lang.String getReintegroRemanFecha() {
        return reintegroRemanFecha;
    }


    /**
     * Sets the reintegroRemanFecha value for this IdentificacionDeRecursoR.
     * 
     * @param reintegroRemanFecha
     */
    public void setReintegroRemanFecha(java.lang.String reintegroRemanFecha) {
        this.reintegroRemanFecha = reintegroRemanFecha;
    }


    /**
     * Gets the reintegroRemanente value for this IdentificacionDeRecursoR.
     * 
     * @return reintegroRemanente
     */
    public java.math.BigDecimal getReintegroRemanente() {
        return reintegroRemanente;
    }


    /**
     * Sets the reintegroRemanente value for this IdentificacionDeRecursoR.
     * 
     * @param reintegroRemanente
     */
    public void setReintegroRemanente(java.math.BigDecimal reintegroRemanente) {
        this.reintegroRemanente = reintegroRemanente;
    }


    /**
     * Gets the remanente value for this IdentificacionDeRecursoR.
     * 
     * @return remanente
     */
    public java.math.BigDecimal getRemanente() {
        return remanente;
    }


    /**
     * Sets the remanente value for this IdentificacionDeRecursoR.
     * 
     * @param remanente
     */
    public void setRemanente(java.math.BigDecimal remanente) {
        this.remanente = remanente;
    }


    /**
     * Gets the tipoOperacion value for this IdentificacionDeRecursoR.
     * 
     * @return tipoOperacion
     */
    public java.lang.String getTipoOperacion() {
        return tipoOperacion;
    }


    /**
     * Sets the tipoOperacion value for this IdentificacionDeRecursoR.
     * 
     * @param tipoOperacion
     */
    public void setTipoOperacion(java.lang.String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentificacionDeRecursoR)) return false;
        IdentificacionDeRecursoR other = (IdentificacionDeRecursoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dispersionDelRecurso==null && other.getDispersionDelRecurso()==null) || 
             (this.dispersionDelRecurso!=null &&
              java.util.Arrays.equals(this.dispersionDelRecurso, other.getDispersionDelRecurso()))) &&
            ((this.fechaDep==null && other.getFechaDep()==null) || 
             (this.fechaDep!=null &&
              this.fechaDep.equals(other.getFechaDep()))) &&
            ((this.identificacionDelGasto==null && other.getIdentificacionDelGasto()==null) || 
             (this.identificacionDelGasto!=null &&
              java.util.Arrays.equals(this.identificacionDelGasto, other.getIdentificacionDelGasto()))) &&
            ((this.montoEntregado==null && other.getMontoEntregado()==null) || 
             (this.montoEntregado!=null &&
              this.montoEntregado.equals(other.getMontoEntregado()))) &&
            ((this.reintegroRemanFecha==null && other.getReintegroRemanFecha()==null) || 
             (this.reintegroRemanFecha!=null &&
              this.reintegroRemanFecha.equals(other.getReintegroRemanFecha()))) &&
            ((this.reintegroRemanente==null && other.getReintegroRemanente()==null) || 
             (this.reintegroRemanente!=null &&
              this.reintegroRemanente.equals(other.getReintegroRemanente()))) &&
            ((this.remanente==null && other.getRemanente()==null) || 
             (this.remanente!=null &&
              this.remanente.equals(other.getRemanente()))) &&
            ((this.tipoOperacion==null && other.getTipoOperacion()==null) || 
             (this.tipoOperacion!=null &&
              this.tipoOperacion.equals(other.getTipoOperacion())));
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
        if (getDispersionDelRecurso() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDispersionDelRecurso());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDispersionDelRecurso(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaDep() != null) {
            _hashCode += getFechaDep().hashCode();
        }
        if (getIdentificacionDelGasto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdentificacionDelGasto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdentificacionDelGasto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMontoEntregado() != null) {
            _hashCode += getMontoEntregado().hashCode();
        }
        if (getReintegroRemanFecha() != null) {
            _hashCode += getReintegroRemanFecha().hashCode();
        }
        if (getReintegroRemanente() != null) {
            _hashCode += getReintegroRemanente().hashCode();
        }
        if (getRemanente() != null) {
            _hashCode += getRemanente().hashCode();
        }
        if (getTipoOperacion() != null) {
            _hashCode += getTipoOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdentificacionDeRecursoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDeRecursoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispersionDelRecurso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecurso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DispersionDelRecursoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaDep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificacionDelGasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoEntregado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoEntregado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reintegroRemanFecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReintegroRemanFecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reintegroRemanente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReintegroRemanente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remanente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Remanente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoOperacion"));
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
