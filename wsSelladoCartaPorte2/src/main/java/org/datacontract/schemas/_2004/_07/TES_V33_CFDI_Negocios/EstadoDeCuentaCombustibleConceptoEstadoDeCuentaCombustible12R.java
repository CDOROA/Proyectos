/**
 * EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R  implements java.io.Serializable {
    private java.math.BigDecimal cantidad;

    private java.lang.String claveEstacion;

    private java.lang.String fecha;

    private java.lang.String folioOperacion;

    private java.lang.String identificador;

    private java.math.BigDecimal importe;

    private java.lang.String nombreCombustible;

    private java.lang.String rfc;

    private java.lang.String tipoCombustible;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R[] traslados;

    private java.lang.String unidad;

    private java.math.BigDecimal valorUnitario;

    public EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R() {
    }

    public EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R(
           java.math.BigDecimal cantidad,
           java.lang.String claveEstacion,
           java.lang.String fecha,
           java.lang.String folioOperacion,
           java.lang.String identificador,
           java.math.BigDecimal importe,
           java.lang.String nombreCombustible,
           java.lang.String rfc,
           java.lang.String tipoCombustible,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R[] traslados,
           java.lang.String unidad,
           java.math.BigDecimal valorUnitario) {
           this.cantidad = cantidad;
           this.claveEstacion = claveEstacion;
           this.fecha = fecha;
           this.folioOperacion = folioOperacion;
           this.identificador = identificador;
           this.importe = importe;
           this.nombreCombustible = nombreCombustible;
           this.rfc = rfc;
           this.tipoCombustible = tipoCombustible;
           this.traslados = traslados;
           this.unidad = unidad;
           this.valorUnitario = valorUnitario;
    }


    /**
     * Gets the cantidad value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the claveEstacion value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return claveEstacion
     */
    public java.lang.String getClaveEstacion() {
        return claveEstacion;
    }


    /**
     * Sets the claveEstacion value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param claveEstacion
     */
    public void setClaveEstacion(java.lang.String claveEstacion) {
        this.claveEstacion = claveEstacion;
    }


    /**
     * Gets the fecha value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folioOperacion value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return folioOperacion
     */
    public java.lang.String getFolioOperacion() {
        return folioOperacion;
    }


    /**
     * Sets the folioOperacion value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param folioOperacion
     */
    public void setFolioOperacion(java.lang.String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }


    /**
     * Gets the identificador value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return identificador
     */
    public java.lang.String getIdentificador() {
        return identificador;
    }


    /**
     * Sets the identificador value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param identificador
     */
    public void setIdentificador(java.lang.String identificador) {
        this.identificador = identificador;
    }


    /**
     * Gets the importe value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the nombreCombustible value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return nombreCombustible
     */
    public java.lang.String getNombreCombustible() {
        return nombreCombustible;
    }


    /**
     * Sets the nombreCombustible value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param nombreCombustible
     */
    public void setNombreCombustible(java.lang.String nombreCombustible) {
        this.nombreCombustible = nombreCombustible;
    }


    /**
     * Gets the rfc value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }


    /**
     * Gets the tipoCombustible value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return tipoCombustible
     */
    public java.lang.String getTipoCombustible() {
        return tipoCombustible;
    }


    /**
     * Sets the tipoCombustible value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param tipoCombustible
     */
    public void setTipoCombustible(java.lang.String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


    /**
     * Gets the traslados value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return traslados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R[] getTraslados() {
        return traslados;
    }


    /**
     * Sets the traslados value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param traslados
     */
    public void setTraslados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R[] traslados) {
        this.traslados = traslados;
    }


    /**
     * Gets the unidad value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valorUnitario value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @return valorUnitario
     */
    public java.math.BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    /**
     * Sets the valorUnitario value for this EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(java.math.BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R)) return false;
        EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R other = (EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.claveEstacion==null && other.getClaveEstacion()==null) || 
             (this.claveEstacion!=null &&
              this.claveEstacion.equals(other.getClaveEstacion()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.folioOperacion==null && other.getFolioOperacion()==null) || 
             (this.folioOperacion!=null &&
              this.folioOperacion.equals(other.getFolioOperacion()))) &&
            ((this.identificador==null && other.getIdentificador()==null) || 
             (this.identificador!=null &&
              this.identificador.equals(other.getIdentificador()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.nombreCombustible==null && other.getNombreCombustible()==null) || 
             (this.nombreCombustible!=null &&
              this.nombreCombustible.equals(other.getNombreCombustible()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc()))) &&
            ((this.tipoCombustible==null && other.getTipoCombustible()==null) || 
             (this.tipoCombustible!=null &&
              this.tipoCombustible.equals(other.getTipoCombustible()))) &&
            ((this.traslados==null && other.getTraslados()==null) || 
             (this.traslados!=null &&
              java.util.Arrays.equals(this.traslados, other.getTraslados()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valorUnitario==null && other.getValorUnitario()==null) || 
             (this.valorUnitario!=null &&
              this.valorUnitario.equals(other.getValorUnitario())));
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
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getClaveEstacion() != null) {
            _hashCode += getClaveEstacion().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFolioOperacion() != null) {
            _hashCode += getFolioOperacion().hashCode();
        }
        if (getIdentificador() != null) {
            _hashCode += getIdentificador().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getNombreCombustible() != null) {
            _hashCode += getNombreCombustible().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        if (getTipoCombustible() != null) {
            _hashCode += getTipoCombustible().hashCode();
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
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        if (getValorUnitario() != null) {
            _hashCode += getValorUnitario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustible12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveEstacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveEstacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Identificador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreCombustible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreCombustible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Rfc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCombustible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCombustible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("traslados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Traslados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EstadoDeCuentaCombustibleConceptoEstadoDeCuentaCombustibleTraslado12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorUnitario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorUnitario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
