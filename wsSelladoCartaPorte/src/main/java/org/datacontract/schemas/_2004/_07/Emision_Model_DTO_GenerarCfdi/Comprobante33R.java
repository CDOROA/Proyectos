/**
 * Comprobante33R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class Comprobante33R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR addenda;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorte20R cartaPorte;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR[] cfdiRelacionados;

    private java.lang.String claveCFDI;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExterior11R comercioExterior;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR[] conceptos;

    private java.lang.String condicionesDePago;

    private java.lang.String confirmacion;

    private java.math.BigDecimal descuento;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR emisor;

    private java.lang.String exportacion;

    private java.util.Calendar fecha;

    private java.lang.String folio;

    private java.lang.String formaPago;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR informacionGlobal;

    private java.lang.String lugarExpedicion;

    private java.lang.String metodoPago;

    private java.lang.String moneda;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.Pagos10R pagos;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR receptor;

    private java.lang.String referencia;

    private java.lang.String serie;

    private java.math.BigDecimal subTotal;

    private java.math.BigDecimal tipoCambio;

    private java.lang.String tipoDeComprobante;

    private java.math.BigDecimal total;

    public Comprobante33R() {
    }

    public Comprobante33R(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR addenda,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorte20R cartaPorte,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR[] cfdiRelacionados,
           java.lang.String claveCFDI,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExterior11R comercioExterior,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR[] conceptos,
           java.lang.String condicionesDePago,
           java.lang.String confirmacion,
           java.math.BigDecimal descuento,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR emisor,
           java.lang.String exportacion,
           java.util.Calendar fecha,
           java.lang.String folio,
           java.lang.String formaPago,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR informacionGlobal,
           java.lang.String lugarExpedicion,
           java.lang.String metodoPago,
           java.lang.String moneda,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.Pagos10R pagos,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR receptor,
           java.lang.String referencia,
           java.lang.String serie,
           java.math.BigDecimal subTotal,
           java.math.BigDecimal tipoCambio,
           java.lang.String tipoDeComprobante,
           java.math.BigDecimal total) {
           this.addenda = addenda;
           this.cartaPorte = cartaPorte;
           this.cfdiRelacionados = cfdiRelacionados;
           this.claveCFDI = claveCFDI;
           this.comercioExterior = comercioExterior;
           this.conceptos = conceptos;
           this.condicionesDePago = condicionesDePago;
           this.confirmacion = confirmacion;
           this.descuento = descuento;
           this.emisor = emisor;
           this.exportacion = exportacion;
           this.fecha = fecha;
           this.folio = folio;
           this.formaPago = formaPago;
           this.informacionGlobal = informacionGlobal;
           this.lugarExpedicion = lugarExpedicion;
           this.metodoPago = metodoPago;
           this.moneda = moneda;
           this.pagos = pagos;
           this.receptor = receptor;
           this.referencia = referencia;
           this.serie = serie;
           this.subTotal = subTotal;
           this.tipoCambio = tipoCambio;
           this.tipoDeComprobante = tipoDeComprobante;
           this.total = total;
    }


    /**
     * Gets the addenda value for this Comprobante33R.
     * 
     * @return addenda
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR getAddenda() {
        return addenda;
    }


    /**
     * Sets the addenda value for this Comprobante33R.
     * 
     * @param addenda
     */
    public void setAddenda(org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR addenda) {
        this.addenda = addenda;
    }


    /**
     * Gets the cartaPorte value for this Comprobante33R.
     * 
     * @return cartaPorte
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorte20R getCartaPorte() {
        return cartaPorte;
    }


    /**
     * Sets the cartaPorte value for this Comprobante33R.
     * 
     * @param cartaPorte
     */
    public void setCartaPorte(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorte20R cartaPorte) {
        this.cartaPorte = cartaPorte;
    }


    /**
     * Gets the cfdiRelacionados value for this Comprobante33R.
     * 
     * @return cfdiRelacionados
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR[] getCfdiRelacionados() {
        return cfdiRelacionados;
    }


    /**
     * Sets the cfdiRelacionados value for this Comprobante33R.
     * 
     * @param cfdiRelacionados
     */
    public void setCfdiRelacionados(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR[] cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }


    /**
     * Gets the claveCFDI value for this Comprobante33R.
     * 
     * @return claveCFDI
     */
    public java.lang.String getClaveCFDI() {
        return claveCFDI;
    }


    /**
     * Sets the claveCFDI value for this Comprobante33R.
     * 
     * @param claveCFDI
     */
    public void setClaveCFDI(java.lang.String claveCFDI) {
        this.claveCFDI = claveCFDI;
    }


    /**
     * Gets the comercioExterior value for this Comprobante33R.
     * 
     * @return comercioExterior
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExterior11R getComercioExterior() {
        return comercioExterior;
    }


    /**
     * Sets the comercioExterior value for this Comprobante33R.
     * 
     * @param comercioExterior
     */
    public void setComercioExterior(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_ComercioExterior.ComercioExterior11R comercioExterior) {
        this.comercioExterior = comercioExterior;
    }


    /**
     * Gets the conceptos value for this Comprobante33R.
     * 
     * @return conceptos
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR[] getConceptos() {
        return conceptos;
    }


    /**
     * Sets the conceptos value for this Comprobante33R.
     * 
     * @param conceptos
     */
    public void setConceptos(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR[] conceptos) {
        this.conceptos = conceptos;
    }


    /**
     * Gets the condicionesDePago value for this Comprobante33R.
     * 
     * @return condicionesDePago
     */
    public java.lang.String getCondicionesDePago() {
        return condicionesDePago;
    }


    /**
     * Sets the condicionesDePago value for this Comprobante33R.
     * 
     * @param condicionesDePago
     */
    public void setCondicionesDePago(java.lang.String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }


    /**
     * Gets the confirmacion value for this Comprobante33R.
     * 
     * @return confirmacion
     */
    public java.lang.String getConfirmacion() {
        return confirmacion;
    }


    /**
     * Sets the confirmacion value for this Comprobante33R.
     * 
     * @param confirmacion
     */
    public void setConfirmacion(java.lang.String confirmacion) {
        this.confirmacion = confirmacion;
    }


    /**
     * Gets the descuento value for this Comprobante33R.
     * 
     * @return descuento
     */
    public java.math.BigDecimal getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this Comprobante33R.
     * 
     * @param descuento
     */
    public void setDescuento(java.math.BigDecimal descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the emisor value for this Comprobante33R.
     * 
     * @return emisor
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR getEmisor() {
        return emisor;
    }


    /**
     * Sets the emisor value for this Comprobante33R.
     * 
     * @param emisor
     */
    public void setEmisor(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR emisor) {
        this.emisor = emisor;
    }


    /**
     * Gets the exportacion value for this Comprobante33R.
     * 
     * @return exportacion
     */
    public java.lang.String getExportacion() {
        return exportacion;
    }


    /**
     * Sets the exportacion value for this Comprobante33R.
     * 
     * @param exportacion
     */
    public void setExportacion(java.lang.String exportacion) {
        this.exportacion = exportacion;
    }


    /**
     * Gets the fecha value for this Comprobante33R.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this Comprobante33R.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the folio value for this Comprobante33R.
     * 
     * @return folio
     */
    public java.lang.String getFolio() {
        return folio;
    }


    /**
     * Sets the folio value for this Comprobante33R.
     * 
     * @param folio
     */
    public void setFolio(java.lang.String folio) {
        this.folio = folio;
    }


    /**
     * Gets the formaPago value for this Comprobante33R.
     * 
     * @return formaPago
     */
    public java.lang.String getFormaPago() {
        return formaPago;
    }


    /**
     * Sets the formaPago value for this Comprobante33R.
     * 
     * @param formaPago
     */
    public void setFormaPago(java.lang.String formaPago) {
        this.formaPago = formaPago;
    }


    /**
     * Gets the informacionGlobal value for this Comprobante33R.
     * 
     * @return informacionGlobal
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR getInformacionGlobal() {
        return informacionGlobal;
    }


    /**
     * Sets the informacionGlobal value for this Comprobante33R.
     * 
     * @param informacionGlobal
     */
    public void setInformacionGlobal(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR informacionGlobal) {
        this.informacionGlobal = informacionGlobal;
    }


    /**
     * Gets the lugarExpedicion value for this Comprobante33R.
     * 
     * @return lugarExpedicion
     */
    public java.lang.String getLugarExpedicion() {
        return lugarExpedicion;
    }


    /**
     * Sets the lugarExpedicion value for this Comprobante33R.
     * 
     * @param lugarExpedicion
     */
    public void setLugarExpedicion(java.lang.String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }


    /**
     * Gets the metodoPago value for this Comprobante33R.
     * 
     * @return metodoPago
     */
    public java.lang.String getMetodoPago() {
        return metodoPago;
    }


    /**
     * Sets the metodoPago value for this Comprobante33R.
     * 
     * @param metodoPago
     */
    public void setMetodoPago(java.lang.String metodoPago) {
        this.metodoPago = metodoPago;
    }


    /**
     * Gets the moneda value for this Comprobante33R.
     * 
     * @return moneda
     */
    public java.lang.String getMoneda() {
        return moneda;
    }


    /**
     * Sets the moneda value for this Comprobante33R.
     * 
     * @param moneda
     */
    public void setMoneda(java.lang.String moneda) {
        this.moneda = moneda;
    }


    /**
     * Gets the pagos value for this Comprobante33R.
     * 
     * @return pagos
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.Pagos10R getPagos() {
        return pagos;
    }


    /**
     * Sets the pagos value for this Comprobante33R.
     * 
     * @param pagos
     */
    public void setPagos(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.Pagos10R pagos) {
        this.pagos = pagos;
    }


    /**
     * Gets the receptor value for this Comprobante33R.
     * 
     * @return receptor
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR getReceptor() {
        return receptor;
    }


    /**
     * Sets the receptor value for this Comprobante33R.
     * 
     * @param receptor
     */
    public void setReceptor(org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR receptor) {
        this.receptor = receptor;
    }


    /**
     * Gets the referencia value for this Comprobante33R.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this Comprobante33R.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the serie value for this Comprobante33R.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this Comprobante33R.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the subTotal value for this Comprobante33R.
     * 
     * @return subTotal
     */
    public java.math.BigDecimal getSubTotal() {
        return subTotal;
    }


    /**
     * Sets the subTotal value for this Comprobante33R.
     * 
     * @param subTotal
     */
    public void setSubTotal(java.math.BigDecimal subTotal) {
        this.subTotal = subTotal;
    }


    /**
     * Gets the tipoCambio value for this Comprobante33R.
     * 
     * @return tipoCambio
     */
    public java.math.BigDecimal getTipoCambio() {
        return tipoCambio;
    }


    /**
     * Sets the tipoCambio value for this Comprobante33R.
     * 
     * @param tipoCambio
     */
    public void setTipoCambio(java.math.BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }


    /**
     * Gets the tipoDeComprobante value for this Comprobante33R.
     * 
     * @return tipoDeComprobante
     */
    public java.lang.String getTipoDeComprobante() {
        return tipoDeComprobante;
    }


    /**
     * Sets the tipoDeComprobante value for this Comprobante33R.
     * 
     * @param tipoDeComprobante
     */
    public void setTipoDeComprobante(java.lang.String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }


    /**
     * Gets the total value for this Comprobante33R.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this Comprobante33R.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Comprobante33R)) return false;
        Comprobante33R other = (Comprobante33R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addenda==null && other.getAddenda()==null) || 
             (this.addenda!=null &&
              this.addenda.equals(other.getAddenda()))) &&
            ((this.cartaPorte==null && other.getCartaPorte()==null) || 
             (this.cartaPorte!=null &&
              this.cartaPorte.equals(other.getCartaPorte()))) &&
            ((this.cfdiRelacionados==null && other.getCfdiRelacionados()==null) || 
             (this.cfdiRelacionados!=null &&
              java.util.Arrays.equals(this.cfdiRelacionados, other.getCfdiRelacionados()))) &&
            ((this.claveCFDI==null && other.getClaveCFDI()==null) || 
             (this.claveCFDI!=null &&
              this.claveCFDI.equals(other.getClaveCFDI()))) &&
            ((this.comercioExterior==null && other.getComercioExterior()==null) || 
             (this.comercioExterior!=null &&
              this.comercioExterior.equals(other.getComercioExterior()))) &&
            ((this.conceptos==null && other.getConceptos()==null) || 
             (this.conceptos!=null &&
              java.util.Arrays.equals(this.conceptos, other.getConceptos()))) &&
            ((this.condicionesDePago==null && other.getCondicionesDePago()==null) || 
             (this.condicionesDePago!=null &&
              this.condicionesDePago.equals(other.getCondicionesDePago()))) &&
            ((this.confirmacion==null && other.getConfirmacion()==null) || 
             (this.confirmacion!=null &&
              this.confirmacion.equals(other.getConfirmacion()))) &&
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.emisor==null && other.getEmisor()==null) || 
             (this.emisor!=null &&
              this.emisor.equals(other.getEmisor()))) &&
            ((this.exportacion==null && other.getExportacion()==null) || 
             (this.exportacion!=null &&
              this.exportacion.equals(other.getExportacion()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.folio==null && other.getFolio()==null) || 
             (this.folio!=null &&
              this.folio.equals(other.getFolio()))) &&
            ((this.formaPago==null && other.getFormaPago()==null) || 
             (this.formaPago!=null &&
              this.formaPago.equals(other.getFormaPago()))) &&
            ((this.informacionGlobal==null && other.getInformacionGlobal()==null) || 
             (this.informacionGlobal!=null &&
              this.informacionGlobal.equals(other.getInformacionGlobal()))) &&
            ((this.lugarExpedicion==null && other.getLugarExpedicion()==null) || 
             (this.lugarExpedicion!=null &&
              this.lugarExpedicion.equals(other.getLugarExpedicion()))) &&
            ((this.metodoPago==null && other.getMetodoPago()==null) || 
             (this.metodoPago!=null &&
              this.metodoPago.equals(other.getMetodoPago()))) &&
            ((this.moneda==null && other.getMoneda()==null) || 
             (this.moneda!=null &&
              this.moneda.equals(other.getMoneda()))) &&
            ((this.pagos==null && other.getPagos()==null) || 
             (this.pagos!=null &&
              this.pagos.equals(other.getPagos()))) &&
            ((this.receptor==null && other.getReceptor()==null) || 
             (this.receptor!=null &&
              this.receptor.equals(other.getReceptor()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.subTotal==null && other.getSubTotal()==null) || 
             (this.subTotal!=null &&
              this.subTotal.equals(other.getSubTotal()))) &&
            ((this.tipoCambio==null && other.getTipoCambio()==null) || 
             (this.tipoCambio!=null &&
              this.tipoCambio.equals(other.getTipoCambio()))) &&
            ((this.tipoDeComprobante==null && other.getTipoDeComprobante()==null) || 
             (this.tipoDeComprobante!=null &&
              this.tipoDeComprobante.equals(other.getTipoDeComprobante()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal())));
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
        if (getAddenda() != null) {
            _hashCode += getAddenda().hashCode();
        }
        if (getCartaPorte() != null) {
            _hashCode += getCartaPorte().hashCode();
        }
        if (getCfdiRelacionados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCfdiRelacionados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCfdiRelacionados(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClaveCFDI() != null) {
            _hashCode += getClaveCFDI().hashCode();
        }
        if (getComercioExterior() != null) {
            _hashCode += getComercioExterior().hashCode();
        }
        if (getConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConceptos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCondicionesDePago() != null) {
            _hashCode += getCondicionesDePago().hashCode();
        }
        if (getConfirmacion() != null) {
            _hashCode += getConfirmacion().hashCode();
        }
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
        }
        if (getEmisor() != null) {
            _hashCode += getEmisor().hashCode();
        }
        if (getExportacion() != null) {
            _hashCode += getExportacion().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getFolio() != null) {
            _hashCode += getFolio().hashCode();
        }
        if (getFormaPago() != null) {
            _hashCode += getFormaPago().hashCode();
        }
        if (getInformacionGlobal() != null) {
            _hashCode += getInformacionGlobal().hashCode();
        }
        if (getLugarExpedicion() != null) {
            _hashCode += getLugarExpedicion().hashCode();
        }
        if (getMetodoPago() != null) {
            _hashCode += getMetodoPago().hashCode();
        }
        if (getMoneda() != null) {
            _hashCode += getMoneda().hashCode();
        }
        if (getPagos() != null) {
            _hashCode += getPagos().hashCode();
        }
        if (getReceptor() != null) {
            _hashCode += getReceptor().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        if (getSubTotal() != null) {
            _hashCode += getSubTotal().hashCode();
        }
        if (getTipoCambio() != null) {
            _hashCode += getTipoCambio().hashCode();
        }
        if (getTipoDeComprobante() != null) {
            _hashCode += getTipoDeComprobante().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comprobante33R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Comprobante33R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addenda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Addenda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Addendas.CFDR", "AddendaCFDR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cartaPorte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CartaPorte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorte20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfdiRelacionados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CfdiRelacionadosR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveCFDI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ClaveCFDI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comercioExterior");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ComercioExterior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.ComercioExterior", "ComercioExterior11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Conceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ConceptoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("condicionesDePago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "CondicionesDePago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Confirmacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Emisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "EmisorR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Exportacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Folio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "FormaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionGlobal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionGlobal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "InformacionGlobalR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lugarExpedicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "LugarExpedicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metodoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "MetodoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moneda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Moneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Pagos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "Pagos10R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Receptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ReceptorR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "SubTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCambio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "TipoCambio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDeComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "TipoDeComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Total"));
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
