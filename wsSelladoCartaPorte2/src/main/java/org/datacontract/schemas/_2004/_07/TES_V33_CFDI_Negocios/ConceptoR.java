/**
 * ConceptoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ConceptoR  implements java.io.Serializable {
    private java.math.BigDecimal cantidad;

    private java.lang.String claveProdServ;

    private java.lang.String claveUnidad;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialR cuentaPredial;

    private java.lang.String descripcion;

    private java.math.BigDecimal descuento;

    private java.math.BigDecimal importe;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR impuestos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR[] informacionAduanera;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativasR instEducativas;

    private java.lang.String noIdentificacion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR[] partes;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTerceros11R porCuentadeTerceros;

    private java.lang.String unidad;

    private java.math.BigDecimal valorUnitario;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosR ventaVehiculos;

    public ConceptoR() {
    }

    public ConceptoR(
           java.math.BigDecimal cantidad,
           java.lang.String claveProdServ,
           java.lang.String claveUnidad,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialR cuentaPredial,
           java.lang.String descripcion,
           java.math.BigDecimal descuento,
           java.math.BigDecimal importe,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR impuestos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR[] informacionAduanera,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativasR instEducativas,
           java.lang.String noIdentificacion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR[] partes,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTerceros11R porCuentadeTerceros,
           java.lang.String unidad,
           java.math.BigDecimal valorUnitario,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosR ventaVehiculos) {
           this.cantidad = cantidad;
           this.claveProdServ = claveProdServ;
           this.claveUnidad = claveUnidad;
           this.cuentaPredial = cuentaPredial;
           this.descripcion = descripcion;
           this.descuento = descuento;
           this.importe = importe;
           this.impuestos = impuestos;
           this.informacionAduanera = informacionAduanera;
           this.instEducativas = instEducativas;
           this.noIdentificacion = noIdentificacion;
           this.partes = partes;
           this.porCuentadeTerceros = porCuentadeTerceros;
           this.unidad = unidad;
           this.valorUnitario = valorUnitario;
           this.ventaVehiculos = ventaVehiculos;
    }


    /**
     * Gets the cantidad value for this ConceptoR.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this ConceptoR.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the claveProdServ value for this ConceptoR.
     * 
     * @return claveProdServ
     */
    public java.lang.String getClaveProdServ() {
        return claveProdServ;
    }


    /**
     * Sets the claveProdServ value for this ConceptoR.
     * 
     * @param claveProdServ
     */
    public void setClaveProdServ(java.lang.String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }


    /**
     * Gets the claveUnidad value for this ConceptoR.
     * 
     * @return claveUnidad
     */
    public java.lang.String getClaveUnidad() {
        return claveUnidad;
    }


    /**
     * Sets the claveUnidad value for this ConceptoR.
     * 
     * @param claveUnidad
     */
    public void setClaveUnidad(java.lang.String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }


    /**
     * Gets the cuentaPredial value for this ConceptoR.
     * 
     * @return cuentaPredial
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialR getCuentaPredial() {
        return cuentaPredial;
    }


    /**
     * Sets the cuentaPredial value for this ConceptoR.
     * 
     * @param cuentaPredial
     */
    public void setCuentaPredial(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialR cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }


    /**
     * Gets the descripcion value for this ConceptoR.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ConceptoR.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the descuento value for this ConceptoR.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this ConceptoR.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the importe value for this ConceptoR.
     * 
     * @return importe
     */
    public java.math.BigDecimal getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this ConceptoR.
     * 
     * @param importe
     */
    public void setImporte(java.math.BigDecimal importe) {
        this.importe = importe;
    }


    /**
     * Gets the impuestos value for this ConceptoR.
     * 
     * @return impuestos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR getImpuestos() {
        return impuestos;
    }


    /**
     * Sets the impuestos value for this ConceptoR.
     * 
     * @param impuestos
     */
    public void setImpuestos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR impuestos) {
        this.impuestos = impuestos;
    }


    /**
     * Gets the informacionAduanera value for this ConceptoR.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR[] getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this ConceptoR.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraR[] informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the instEducativas value for this ConceptoR.
     * 
     * @return instEducativas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativasR getInstEducativas() {
        return instEducativas;
    }


    /**
     * Sets the instEducativas value for this ConceptoR.
     * 
     * @param instEducativas
     */
    public void setInstEducativas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InstEducativasR instEducativas) {
        this.instEducativas = instEducativas;
    }


    /**
     * Gets the noIdentificacion value for this ConceptoR.
     * 
     * @return noIdentificacion
     */
    public java.lang.String getNoIdentificacion() {
        return noIdentificacion;
    }


    /**
     * Sets the noIdentificacion value for this ConceptoR.
     * 
     * @param noIdentificacion
     */
    public void setNoIdentificacion(java.lang.String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }


    /**
     * Gets the partes value for this ConceptoR.
     * 
     * @return partes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR[] getPartes() {
        return partes;
    }


    /**
     * Sets the partes value for this ConceptoR.
     * 
     * @param partes
     */
    public void setPartes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ParteR[] partes) {
        this.partes = partes;
    }


    /**
     * Gets the porCuentadeTerceros value for this ConceptoR.
     * 
     * @return porCuentadeTerceros
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTerceros11R getPorCuentadeTerceros() {
        return porCuentadeTerceros;
    }


    /**
     * Sets the porCuentadeTerceros value for this ConceptoR.
     * 
     * @param porCuentadeTerceros
     */
    public void setPorCuentadeTerceros(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTerceros11R porCuentadeTerceros) {
        this.porCuentadeTerceros = porCuentadeTerceros;
    }


    /**
     * Gets the unidad value for this ConceptoR.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this ConceptoR.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valorUnitario value for this ConceptoR.
     * 
     * @return valorUnitario
     */
    public java.math.BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    /**
     * Sets the valorUnitario value for this ConceptoR.
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(java.math.BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    /**
     * Gets the ventaVehiculos value for this ConceptoR.
     * 
     * @return ventaVehiculos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosR getVentaVehiculos() {
        return ventaVehiculos;
    }


    /**
     * Sets the ventaVehiculos value for this ConceptoR.
     * 
     * @param ventaVehiculos
     */
    public void setVentaVehiculos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosR ventaVehiculos) {
        this.ventaVehiculos = ventaVehiculos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConceptoR)) return false;
        ConceptoR other = (ConceptoR) obj;
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
            ((this.claveProdServ==null && other.getClaveProdServ()==null) || 
             (this.claveProdServ!=null &&
              this.claveProdServ.equals(other.getClaveProdServ()))) &&
            ((this.claveUnidad==null && other.getClaveUnidad()==null) || 
             (this.claveUnidad!=null &&
              this.claveUnidad.equals(other.getClaveUnidad()))) &&
            ((this.cuentaPredial==null && other.getCuentaPredial()==null) || 
             (this.cuentaPredial!=null &&
              this.cuentaPredial.equals(other.getCuentaPredial()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.impuestos==null && other.getImpuestos()==null) || 
             (this.impuestos!=null &&
              this.impuestos.equals(other.getImpuestos()))) &&
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              java.util.Arrays.equals(this.informacionAduanera, other.getInformacionAduanera()))) &&
            ((this.instEducativas==null && other.getInstEducativas()==null) || 
             (this.instEducativas!=null &&
              this.instEducativas.equals(other.getInstEducativas()))) &&
            ((this.noIdentificacion==null && other.getNoIdentificacion()==null) || 
             (this.noIdentificacion!=null &&
              this.noIdentificacion.equals(other.getNoIdentificacion()))) &&
            ((this.partes==null && other.getPartes()==null) || 
             (this.partes!=null &&
              java.util.Arrays.equals(this.partes, other.getPartes()))) &&
            ((this.porCuentadeTerceros==null && other.getPorCuentadeTerceros()==null) || 
             (this.porCuentadeTerceros!=null &&
              this.porCuentadeTerceros.equals(other.getPorCuentadeTerceros()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valorUnitario==null && other.getValorUnitario()==null) || 
             (this.valorUnitario!=null &&
              this.valorUnitario.equals(other.getValorUnitario()))) &&
            ((this.ventaVehiculos==null && other.getVentaVehiculos()==null) || 
             (this.ventaVehiculos!=null &&
              this.ventaVehiculos.equals(other.getVentaVehiculos())));
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
        if (getClaveProdServ() != null) {
            _hashCode += getClaveProdServ().hashCode();
        }
        if (getClaveUnidad() != null) {
            _hashCode += getClaveUnidad().hashCode();
        }
        if (getCuentaPredial() != null) {
            _hashCode += getCuentaPredial().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
        }
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getImpuestos() != null) {
            _hashCode += getImpuestos().hashCode();
        }
        if (getInformacionAduanera() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInformacionAduanera());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInformacionAduanera(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInstEducativas() != null) {
            _hashCode += getInstEducativas().hashCode();
        }
        if (getNoIdentificacion() != null) {
            _hashCode += getNoIdentificacion().hashCode();
        }
        if (getPartes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPartes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPartes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPorCuentadeTerceros() != null) {
            _hashCode += getPorCuentadeTerceros().hashCode();
        }
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        if (getValorUnitario() != null) {
            _hashCode += getValorUnitario().hashCode();
        }
        if (getVentaVehiculos() != null) {
            _hashCode += getVentaVehiculos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConceptoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveProdServ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveProdServ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveUnidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveUnidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaPredial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredialR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("impuestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Impuestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instEducativas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativasR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NoIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Partes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ParteR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porCuentadeTerceros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTerceros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTerceros11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ventaVehiculos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosR"));
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
