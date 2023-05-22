/**
 * ConceptoConsumoDeCombustiblesR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ConceptoConsumoDeCombustiblesR  implements java.io.Serializable {
    private java.math.BigDecimal cantidad;

    private java.lang.String claveEstacion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR[] determinados;

    private java.util.Calendar fecha;

    private java.lang.String folioOperacion;

    private java.lang.String identificador;

    private java.math.BigDecimal importe;

    private java.lang.String nombreCombustible;

    private java.lang.String rfc;

    private java.math.BigDecimal valorUnitario;

    public ConceptoConsumoDeCombustiblesR() {
    }

    public ConceptoConsumoDeCombustiblesR(
           java.math.BigDecimal cantidad,
           java.lang.String claveEstacion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR[] determinados,
           java.util.Calendar fecha,
           java.lang.String folioOperacion,
           java.lang.String identificador,
           java.math.BigDecimal importe,
           java.lang.String nombreCombustible,
           java.lang.String rfc,
           java.math.BigDecimal valorUnitario) {
           this.cantidad = cantidad;
           this.claveEstacion = claveEstacion;
           this.determinados = determinados;
           this.fecha = fecha;
           this.folioOperacion = folioOperacion;
           this.identificador = identificador;
           this.importe = importe;
           this.nombreCombustible = nombreCombustible;
           this.rfc = rfc;
           this.valorUnitario = valorUnitario;
    }


    /**
     * Gets the cantidad value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the claveEstacion value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return claveEstacion
     */
    public java.lang.String getClaveEstacion() {
        return claveEstacion;
    }


    /**
     * Sets the claveEstacion value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param claveEstacion
     */
    public void setClaveEstacion(java.lang.String claveEstacion) {
        this.claveEstacion = claveEstacion;
    }


    /**
     * Gets the determinados value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return determinados
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR[] getDeterminados() {
        return determinados;
    }


    /**
     * Sets the determinados value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param determinados
     */
    public void setDeterminados(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeterminadoR[] determinados) {
        this.determinados = determinados;
    }


    /**
     * Gets the fecha value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folioOperacion value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return folioOperacion
     */
    public java.lang.String getFolioOperacion() {
        return folioOperacion;
    }


    /**
     * Sets the folioOperacion value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param folioOperacion
     */
    public void setFolioOperacion(java.lang.String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }


    /**
     * Gets the identificador value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return identificador
     */
    public java.lang.String getIdentificador() {
        return identificador;
    }


    /**
     * Sets the identificador value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param identificador
     */
    public void setIdentificador(java.lang.String identificador) {
        this.identificador = identificador;
    }


    /**
     * Gets the importe value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the nombreCombustible value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return nombreCombustible
     */
    public java.lang.String getNombreCombustible() {
        return nombreCombustible;
    }


    /**
     * Sets the nombreCombustible value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param nombreCombustible
     */
    public void setNombreCombustible(java.lang.String nombreCombustible) {
        this.nombreCombustible = nombreCombustible;
    }


    /**
     * Gets the rfc value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }


    /**
     * Gets the valorUnitario value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @return valorUnitario
     */
    public java.math.BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    /**
     * Sets the valorUnitario value for this ConceptoConsumoDeCombustiblesR.
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(java.math.BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConceptoConsumoDeCombustiblesR)) return false;
        ConceptoConsumoDeCombustiblesR other = (ConceptoConsumoDeCombustiblesR) obj;
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
            ((this.determinados==null && other.getDeterminados()==null) || 
             (this.determinados!=null &&
              java.util.Arrays.equals(this.determinados, other.getDeterminados()))) &&
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
        if (getDeterminados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeterminados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeterminados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getValorUnitario() != null) {
            _hashCode += getValorUnitario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConceptoConsumoDeCombustiblesR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustiblesR"));
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
        elemField.setFieldName("determinados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Determinados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeterminadoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeterminadoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
