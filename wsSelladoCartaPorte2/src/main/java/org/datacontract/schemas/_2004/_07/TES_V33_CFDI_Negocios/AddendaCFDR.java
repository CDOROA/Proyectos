/**
 * AddendaCFDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class AddendaCFDR  implements java.io.Serializable {
    private java.lang.String correoAlternoCliente;

    private java.lang.String correoCliente;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal;

    private java.lang.String etiquetaDescuento;

    private java.lang.String etiquetaSubtotal;

    private java.lang.String etiquetaTotal;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas;

    private java.lang.Boolean factorajeFinanciero;

    private java.lang.String fechaTipoDeCambio;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas;

    private java.lang.String idiomaPDF;

    private java.lang.String nombreComercialCliente;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare;

    private java.lang.String telefonoCliente;

    private java.lang.String telefonoMovilCliente;

    private java.lang.String tituloPersonalizado;

    public AddendaCFDR() {
    }

    public AddendaCFDR(
           java.lang.String correoAlternoCliente,
           java.lang.String correoCliente,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal,
           java.lang.String etiquetaDescuento,
           java.lang.String etiquetaSubtotal,
           java.lang.String etiquetaTotal,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas,
           java.lang.Boolean factorajeFinanciero,
           java.lang.String fechaTipoDeCambio,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas,
           java.lang.String idiomaPDF,
           java.lang.String nombreComercialCliente,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare,
           java.lang.String telefonoCliente,
           java.lang.String telefonoMovilCliente,
           java.lang.String tituloPersonalizado) {
           this.correoAlternoCliente = correoAlternoCliente;
           this.correoCliente = correoCliente;
           this.detallesConceptos = detallesConceptos;
           this.domicilioEmisor = domicilioEmisor;
           this.domicilioReceptor = domicilioReceptor;
           this.domicilioSucursal = domicilioSucursal;
           this.etiquetaDescuento = etiquetaDescuento;
           this.etiquetaSubtotal = etiquetaSubtotal;
           this.etiquetaTotal = etiquetaTotal;
           this.etiquetasPersonalizadas = etiquetasPersonalizadas;
           this.factorajeFinanciero = factorajeFinanciero;
           this.fechaTipoDeCambio = fechaTipoDeCambio;
           this.firmas = firmas;
           this.idiomaPDF = idiomaPDF;
           this.nombreComercialCliente = nombreComercialCliente;
           this.pagare = pagare;
           this.telefonoCliente = telefonoCliente;
           this.telefonoMovilCliente = telefonoMovilCliente;
           this.tituloPersonalizado = tituloPersonalizado;
    }


    /**
     * Gets the correoAlternoCliente value for this AddendaCFDR.
     * 
     * @return correoAlternoCliente
     */
    public java.lang.String getCorreoAlternoCliente() {
        return correoAlternoCliente;
    }


    /**
     * Sets the correoAlternoCliente value for this AddendaCFDR.
     * 
     * @param correoAlternoCliente
     */
    public void setCorreoAlternoCliente(java.lang.String correoAlternoCliente) {
        this.correoAlternoCliente = correoAlternoCliente;
    }


    /**
     * Gets the correoCliente value for this AddendaCFDR.
     * 
     * @return correoCliente
     */
    public java.lang.String getCorreoCliente() {
        return correoCliente;
    }


    /**
     * Sets the correoCliente value for this AddendaCFDR.
     * 
     * @param correoCliente
     */
    public void setCorreoCliente(java.lang.String correoCliente) {
        this.correoCliente = correoCliente;
    }


    /**
     * Gets the detallesConceptos value for this AddendaCFDR.
     * 
     * @return detallesConceptos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] getDetallesConceptos() {
        return detallesConceptos;
    }


    /**
     * Sets the detallesConceptos value for this AddendaCFDR.
     * 
     * @param detallesConceptos
     */
    public void setDetallesConceptos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetallesConceptoR[] detallesConceptos) {
        this.detallesConceptos = detallesConceptos;
    }


    /**
     * Gets the domicilioEmisor value for this AddendaCFDR.
     * 
     * @return domicilioEmisor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioEmisor() {
        return domicilioEmisor;
    }


    /**
     * Sets the domicilioEmisor value for this AddendaCFDR.
     * 
     * @param domicilioEmisor
     */
    public void setDomicilioEmisor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioEmisor) {
        this.domicilioEmisor = domicilioEmisor;
    }


    /**
     * Gets the domicilioReceptor value for this AddendaCFDR.
     * 
     * @return domicilioReceptor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioReceptor() {
        return domicilioReceptor;
    }


    /**
     * Sets the domicilioReceptor value for this AddendaCFDR.
     * 
     * @param domicilioReceptor
     */
    public void setDomicilioReceptor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioReceptor) {
        this.domicilioReceptor = domicilioReceptor;
    }


    /**
     * Gets the domicilioSucursal value for this AddendaCFDR.
     * 
     * @return domicilioSucursal
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR getDomicilioSucursal() {
        return domicilioSucursal;
    }


    /**
     * Sets the domicilioSucursal value for this AddendaCFDR.
     * 
     * @param domicilioSucursal
     */
    public void setDomicilioSucursal(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DomicilioClienteR domicilioSucursal) {
        this.domicilioSucursal = domicilioSucursal;
    }


    /**
     * Gets the etiquetaDescuento value for this AddendaCFDR.
     * 
     * @return etiquetaDescuento
     */
    public java.lang.String getEtiquetaDescuento() {
        return etiquetaDescuento;
    }


    /**
     * Sets the etiquetaDescuento value for this AddendaCFDR.
     * 
     * @param etiquetaDescuento
     */
    public void setEtiquetaDescuento(java.lang.String etiquetaDescuento) {
        this.etiquetaDescuento = etiquetaDescuento;
    }


    /**
     * Gets the etiquetaSubtotal value for this AddendaCFDR.
     * 
     * @return etiquetaSubtotal
     */
    public java.lang.String getEtiquetaSubtotal() {
        return etiquetaSubtotal;
    }


    /**
     * Sets the etiquetaSubtotal value for this AddendaCFDR.
     * 
     * @param etiquetaSubtotal
     */
    public void setEtiquetaSubtotal(java.lang.String etiquetaSubtotal) {
        this.etiquetaSubtotal = etiquetaSubtotal;
    }


    /**
     * Gets the etiquetaTotal value for this AddendaCFDR.
     * 
     * @return etiquetaTotal
     */
    public java.lang.String getEtiquetaTotal() {
        return etiquetaTotal;
    }


    /**
     * Sets the etiquetaTotal value for this AddendaCFDR.
     * 
     * @param etiquetaTotal
     */
    public void setEtiquetaTotal(java.lang.String etiquetaTotal) {
        this.etiquetaTotal = etiquetaTotal;
    }


    /**
     * Gets the etiquetasPersonalizadas value for this AddendaCFDR.
     * 
     * @return etiquetasPersonalizadas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] getEtiquetasPersonalizadas() {
        return etiquetasPersonalizadas;
    }


    /**
     * Sets the etiquetasPersonalizadas value for this AddendaCFDR.
     * 
     * @param etiquetasPersonalizadas
     */
    public void setEtiquetasPersonalizadas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EtiquetaPersonalizadaR[] etiquetasPersonalizadas) {
        this.etiquetasPersonalizadas = etiquetasPersonalizadas;
    }


    /**
     * Gets the factorajeFinanciero value for this AddendaCFDR.
     * 
     * @return factorajeFinanciero
     */
    public java.lang.Boolean getFactorajeFinanciero() {
        return factorajeFinanciero;
    }


    /**
     * Sets the factorajeFinanciero value for this AddendaCFDR.
     * 
     * @param factorajeFinanciero
     */
    public void setFactorajeFinanciero(java.lang.Boolean factorajeFinanciero) {
        this.factorajeFinanciero = factorajeFinanciero;
    }


    /**
     * Gets the fechaTipoDeCambio value for this AddendaCFDR.
     * 
     * @return fechaTipoDeCambio
     */
    public java.lang.String getFechaTipoDeCambio() {
        return fechaTipoDeCambio;
    }


    /**
     * Sets the fechaTipoDeCambio value for this AddendaCFDR.
     * 
     * @param fechaTipoDeCambio
     */
    public void setFechaTipoDeCambio(java.lang.String fechaTipoDeCambio) {
        this.fechaTipoDeCambio = fechaTipoDeCambio;
    }


    /**
     * Gets the firmas value for this AddendaCFDR.
     * 
     * @return firmas
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] getFirmas() {
        return firmas;
    }


    /**
     * Sets the firmas value for this AddendaCFDR.
     * 
     * @param firmas
     */
    public void setFirmas(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.FirmaOnLineR[] firmas) {
        this.firmas = firmas;
    }


    /**
     * Gets the idiomaPDF value for this AddendaCFDR.
     * 
     * @return idiomaPDF
     */
    public java.lang.String getIdiomaPDF() {
        return idiomaPDF;
    }


    /**
     * Sets the idiomaPDF value for this AddendaCFDR.
     * 
     * @param idiomaPDF
     */
    public void setIdiomaPDF(java.lang.String idiomaPDF) {
        this.idiomaPDF = idiomaPDF;
    }


    /**
     * Gets the nombreComercialCliente value for this AddendaCFDR.
     * 
     * @return nombreComercialCliente
     */
    public java.lang.String getNombreComercialCliente() {
        return nombreComercialCliente;
    }


    /**
     * Sets the nombreComercialCliente value for this AddendaCFDR.
     * 
     * @param nombreComercialCliente
     */
    public void setNombreComercialCliente(java.lang.String nombreComercialCliente) {
        this.nombreComercialCliente = nombreComercialCliente;
    }


    /**
     * Gets the pagare value for this AddendaCFDR.
     * 
     * @return pagare
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR getPagare() {
        return pagare;
    }


    /**
     * Sets the pagare value for this AddendaCFDR.
     * 
     * @param pagare
     */
    public void setPagare(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagareR pagare) {
        this.pagare = pagare;
    }


    /**
     * Gets the telefonoCliente value for this AddendaCFDR.
     * 
     * @return telefonoCliente
     */
    public java.lang.String getTelefonoCliente() {
        return telefonoCliente;
    }


    /**
     * Sets the telefonoCliente value for this AddendaCFDR.
     * 
     * @param telefonoCliente
     */
    public void setTelefonoCliente(java.lang.String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }


    /**
     * Gets the telefonoMovilCliente value for this AddendaCFDR.
     * 
     * @return telefonoMovilCliente
     */
    public java.lang.String getTelefonoMovilCliente() {
        return telefonoMovilCliente;
    }


    /**
     * Sets the telefonoMovilCliente value for this AddendaCFDR.
     * 
     * @param telefonoMovilCliente
     */
    public void setTelefonoMovilCliente(java.lang.String telefonoMovilCliente) {
        this.telefonoMovilCliente = telefonoMovilCliente;
    }


    /**
     * Gets the tituloPersonalizado value for this AddendaCFDR.
     * 
     * @return tituloPersonalizado
     */
    public java.lang.String getTituloPersonalizado() {
        return tituloPersonalizado;
    }


    /**
     * Sets the tituloPersonalizado value for this AddendaCFDR.
     * 
     * @param tituloPersonalizado
     */
    public void setTituloPersonalizado(java.lang.String tituloPersonalizado) {
        this.tituloPersonalizado = tituloPersonalizado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddendaCFDR)) return false;
        AddendaCFDR other = (AddendaCFDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.correoAlternoCliente==null && other.getCorreoAlternoCliente()==null) || 
             (this.correoAlternoCliente!=null &&
              this.correoAlternoCliente.equals(other.getCorreoAlternoCliente()))) &&
            ((this.correoCliente==null && other.getCorreoCliente()==null) || 
             (this.correoCliente!=null &&
              this.correoCliente.equals(other.getCorreoCliente()))) &&
            ((this.detallesConceptos==null && other.getDetallesConceptos()==null) || 
             (this.detallesConceptos!=null &&
              java.util.Arrays.equals(this.detallesConceptos, other.getDetallesConceptos()))) &&
            ((this.domicilioEmisor==null && other.getDomicilioEmisor()==null) || 
             (this.domicilioEmisor!=null &&
              this.domicilioEmisor.equals(other.getDomicilioEmisor()))) &&
            ((this.domicilioReceptor==null && other.getDomicilioReceptor()==null) || 
             (this.domicilioReceptor!=null &&
              this.domicilioReceptor.equals(other.getDomicilioReceptor()))) &&
            ((this.domicilioSucursal==null && other.getDomicilioSucursal()==null) || 
             (this.domicilioSucursal!=null &&
              this.domicilioSucursal.equals(other.getDomicilioSucursal()))) &&
            ((this.etiquetaDescuento==null && other.getEtiquetaDescuento()==null) || 
             (this.etiquetaDescuento!=null &&
              this.etiquetaDescuento.equals(other.getEtiquetaDescuento()))) &&
            ((this.etiquetaSubtotal==null && other.getEtiquetaSubtotal()==null) || 
             (this.etiquetaSubtotal!=null &&
              this.etiquetaSubtotal.equals(other.getEtiquetaSubtotal()))) &&
            ((this.etiquetaTotal==null && other.getEtiquetaTotal()==null) || 
             (this.etiquetaTotal!=null &&
              this.etiquetaTotal.equals(other.getEtiquetaTotal()))) &&
            ((this.etiquetasPersonalizadas==null && other.getEtiquetasPersonalizadas()==null) || 
             (this.etiquetasPersonalizadas!=null &&
              java.util.Arrays.equals(this.etiquetasPersonalizadas, other.getEtiquetasPersonalizadas()))) &&
            ((this.factorajeFinanciero==null && other.getFactorajeFinanciero()==null) || 
             (this.factorajeFinanciero!=null &&
              this.factorajeFinanciero.equals(other.getFactorajeFinanciero()))) &&
            ((this.fechaTipoDeCambio==null && other.getFechaTipoDeCambio()==null) || 
             (this.fechaTipoDeCambio!=null &&
              this.fechaTipoDeCambio.equals(other.getFechaTipoDeCambio()))) &&
            ((this.firmas==null && other.getFirmas()==null) || 
             (this.firmas!=null &&
              java.util.Arrays.equals(this.firmas, other.getFirmas()))) &&
            ((this.idiomaPDF==null && other.getIdiomaPDF()==null) || 
             (this.idiomaPDF!=null &&
              this.idiomaPDF.equals(other.getIdiomaPDF()))) &&
            ((this.nombreComercialCliente==null && other.getNombreComercialCliente()==null) || 
             (this.nombreComercialCliente!=null &&
              this.nombreComercialCliente.equals(other.getNombreComercialCliente()))) &&
            ((this.pagare==null && other.getPagare()==null) || 
             (this.pagare!=null &&
              this.pagare.equals(other.getPagare()))) &&
            ((this.telefonoCliente==null && other.getTelefonoCliente()==null) || 
             (this.telefonoCliente!=null &&
              this.telefonoCliente.equals(other.getTelefonoCliente()))) &&
            ((this.telefonoMovilCliente==null && other.getTelefonoMovilCliente()==null) || 
             (this.telefonoMovilCliente!=null &&
              this.telefonoMovilCliente.equals(other.getTelefonoMovilCliente()))) &&
            ((this.tituloPersonalizado==null && other.getTituloPersonalizado()==null) || 
             (this.tituloPersonalizado!=null &&
              this.tituloPersonalizado.equals(other.getTituloPersonalizado())));
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
        if (getCorreoAlternoCliente() != null) {
            _hashCode += getCorreoAlternoCliente().hashCode();
        }
        if (getCorreoCliente() != null) {
            _hashCode += getCorreoCliente().hashCode();
        }
        if (getDetallesConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetallesConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDetallesConceptos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDomicilioEmisor() != null) {
            _hashCode += getDomicilioEmisor().hashCode();
        }
        if (getDomicilioReceptor() != null) {
            _hashCode += getDomicilioReceptor().hashCode();
        }
        if (getDomicilioSucursal() != null) {
            _hashCode += getDomicilioSucursal().hashCode();
        }
        if (getEtiquetaDescuento() != null) {
            _hashCode += getEtiquetaDescuento().hashCode();
        }
        if (getEtiquetaSubtotal() != null) {
            _hashCode += getEtiquetaSubtotal().hashCode();
        }
        if (getEtiquetaTotal() != null) {
            _hashCode += getEtiquetaTotal().hashCode();
        }
        if (getEtiquetasPersonalizadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEtiquetasPersonalizadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEtiquetasPersonalizadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFactorajeFinanciero() != null) {
            _hashCode += getFactorajeFinanciero().hashCode();
        }
        if (getFechaTipoDeCambio() != null) {
            _hashCode += getFechaTipoDeCambio().hashCode();
        }
        if (getFirmas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFirmas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFirmas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdiomaPDF() != null) {
            _hashCode += getIdiomaPDF().hashCode();
        }
        if (getNombreComercialCliente() != null) {
            _hashCode += getNombreComercialCliente().hashCode();
        }
        if (getPagare() != null) {
            _hashCode += getPagare().hashCode();
        }
        if (getTelefonoCliente() != null) {
            _hashCode += getTelefonoCliente().hashCode();
        }
        if (getTelefonoMovilCliente() != null) {
            _hashCode += getTelefonoMovilCliente().hashCode();
        }
        if (getTituloPersonalizado() != null) {
            _hashCode += getTituloPersonalizado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddendaCFDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AddendaCFDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoAlternoCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CorreoAlternoCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CorreoCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detallesConceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetallesConceptoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioSucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioSucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DomicilioClienteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaDescuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaDescuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaSubtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaSubtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetaTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etiquetasPersonalizadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetasPersonalizadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EtiquetaPersonalizadaR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("factorajeFinanciero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FactorajeFinanciero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTipoDeCambio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaTipoDeCambio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firmas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Firmas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FirmaOnLineR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idiomaPDF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdiomaPDF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreComercialCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreComercialCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagareR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TelefonoCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoMovilCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TelefonoMovilCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tituloPersonalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TituloPersonalizado"));
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
