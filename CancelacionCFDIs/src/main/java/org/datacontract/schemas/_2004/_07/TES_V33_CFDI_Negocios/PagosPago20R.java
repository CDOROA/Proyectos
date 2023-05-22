/**
 * PagosPago20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPago20R  implements java.io.Serializable {
    private java.lang.String cadPago;

    private java.lang.String certPago;

    private java.lang.String ctaBeneficiario;

    private java.lang.String ctaOrdenante;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R[] doctoRelacionado;

    private java.lang.String fechaPago;

    private java.lang.String formaDePagoP;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R[] impuestosP;

    private java.lang.String monedaP;

    private java.math.BigDecimal monto;

    private java.lang.String nomBancoOrdExt;

    private java.lang.String numOperacion;

    private java.lang.String rfcEmisorCtaBen;

    private java.lang.String rfcEmisorCtaOrd;

    private java.lang.String selloPago;

    private java.lang.String tipoCadPago;

    private java.math.BigDecimal tipoCambioP;

    public PagosPago20R() {
    }

    public PagosPago20R(
           java.lang.String cadPago,
           java.lang.String certPago,
           java.lang.String ctaBeneficiario,
           java.lang.String ctaOrdenante,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R[] doctoRelacionado,
           java.lang.String fechaPago,
           java.lang.String formaDePagoP,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R[] impuestosP,
           java.lang.String monedaP,
           java.math.BigDecimal monto,
           java.lang.String nomBancoOrdExt,
           java.lang.String numOperacion,
           java.lang.String rfcEmisorCtaBen,
           java.lang.String rfcEmisorCtaOrd,
           java.lang.String selloPago,
           java.lang.String tipoCadPago,
           java.math.BigDecimal tipoCambioP) {
           this.cadPago = cadPago;
           this.certPago = certPago;
           this.ctaBeneficiario = ctaBeneficiario;
           this.ctaOrdenante = ctaOrdenante;
           this.doctoRelacionado = doctoRelacionado;
           this.fechaPago = fechaPago;
           this.formaDePagoP = formaDePagoP;
           this.impuestosP = impuestosP;
           this.monedaP = monedaP;
           this.monto = monto;
           this.nomBancoOrdExt = nomBancoOrdExt;
           this.numOperacion = numOperacion;
           this.rfcEmisorCtaBen = rfcEmisorCtaBen;
           this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
           this.selloPago = selloPago;
           this.tipoCadPago = tipoCadPago;
           this.tipoCambioP = tipoCambioP;
    }


    /**
     * Gets the cadPago value for this PagosPago20R.
     * 
     * @return cadPago
     */
    public java.lang.String getCadPago() {
        return cadPago;
    }


    /**
     * Sets the cadPago value for this PagosPago20R.
     * 
     * @param cadPago
     */
    public void setCadPago(java.lang.String cadPago) {
        this.cadPago = cadPago;
    }


    /**
     * Gets the certPago value for this PagosPago20R.
     * 
     * @return certPago
     */
    public java.lang.String getCertPago() {
        return certPago;
    }


    /**
     * Sets the certPago value for this PagosPago20R.
     * 
     * @param certPago
     */
    public void setCertPago(java.lang.String certPago) {
        this.certPago = certPago;
    }


    /**
     * Gets the ctaBeneficiario value for this PagosPago20R.
     * 
     * @return ctaBeneficiario
     */
    public java.lang.String getCtaBeneficiario() {
        return ctaBeneficiario;
    }


    /**
     * Sets the ctaBeneficiario value for this PagosPago20R.
     * 
     * @param ctaBeneficiario
     */
    public void setCtaBeneficiario(java.lang.String ctaBeneficiario) {
        this.ctaBeneficiario = ctaBeneficiario;
    }


    /**
     * Gets the ctaOrdenante value for this PagosPago20R.
     * 
     * @return ctaOrdenante
     */
    public java.lang.String getCtaOrdenante() {
        return ctaOrdenante;
    }


    /**
     * Sets the ctaOrdenante value for this PagosPago20R.
     * 
     * @param ctaOrdenante
     */
    public void setCtaOrdenante(java.lang.String ctaOrdenante) {
        this.ctaOrdenante = ctaOrdenante;
    }


    /**
     * Gets the doctoRelacionado value for this PagosPago20R.
     * 
     * @return doctoRelacionado
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R[] getDoctoRelacionado() {
        return doctoRelacionado;
    }


    /**
     * Sets the doctoRelacionado value for this PagosPago20R.
     * 
     * @param doctoRelacionado
     */
    public void setDoctoRelacionado(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionado20R[] doctoRelacionado) {
        this.doctoRelacionado = doctoRelacionado;
    }


    /**
     * Gets the fechaPago value for this PagosPago20R.
     * 
     * @return fechaPago
     */
    public java.lang.String getFechaPago() {
        return fechaPago;
    }


    /**
     * Sets the fechaPago value for this PagosPago20R.
     * 
     * @param fechaPago
     */
    public void setFechaPago(java.lang.String fechaPago) {
        this.fechaPago = fechaPago;
    }


    /**
     * Gets the formaDePagoP value for this PagosPago20R.
     * 
     * @return formaDePagoP
     */
    public java.lang.String getFormaDePagoP() {
        return formaDePagoP;
    }


    /**
     * Sets the formaDePagoP value for this PagosPago20R.
     * 
     * @param formaDePagoP
     */
    public void setFormaDePagoP(java.lang.String formaDePagoP) {
        this.formaDePagoP = formaDePagoP;
    }


    /**
     * Gets the impuestosP value for this PagosPago20R.
     * 
     * @return impuestosP
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R[] getImpuestosP() {
        return impuestosP;
    }


    /**
     * Sets the impuestosP value for this PagosPago20R.
     * 
     * @param impuestosP
     */
    public void setImpuestosP(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosP20R[] impuestosP) {
        this.impuestosP = impuestosP;
    }


    /**
     * Gets the monedaP value for this PagosPago20R.
     * 
     * @return monedaP
     */
    public java.lang.String getMonedaP() {
        return monedaP;
    }


    /**
     * Sets the monedaP value for this PagosPago20R.
     * 
     * @param monedaP
     */
    public void setMonedaP(java.lang.String monedaP) {
        this.monedaP = monedaP;
    }


    /**
     * Gets the monto value for this PagosPago20R.
     * 
     * @return monto
     */
    public java.math.BigDecimal getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this PagosPago20R.
     * 
     * @param monto
     */
    public void setMonto(java.math.BigDecimal monto) {
        this.monto = monto;
    }


    /**
     * Gets the nomBancoOrdExt value for this PagosPago20R.
     * 
     * @return nomBancoOrdExt
     */
    public java.lang.String getNomBancoOrdExt() {
        return nomBancoOrdExt;
    }


    /**
     * Sets the nomBancoOrdExt value for this PagosPago20R.
     * 
     * @param nomBancoOrdExt
     */
    public void setNomBancoOrdExt(java.lang.String nomBancoOrdExt) {
        this.nomBancoOrdExt = nomBancoOrdExt;
    }


    /**
     * Gets the numOperacion value for this PagosPago20R.
     * 
     * @return numOperacion
     */
    public java.lang.String getNumOperacion() {
        return numOperacion;
    }


    /**
     * Sets the numOperacion value for this PagosPago20R.
     * 
     * @param numOperacion
     */
    public void setNumOperacion(java.lang.String numOperacion) {
        this.numOperacion = numOperacion;
    }


    /**
     * Gets the rfcEmisorCtaBen value for this PagosPago20R.
     * 
     * @return rfcEmisorCtaBen
     */
    public java.lang.String getRfcEmisorCtaBen() {
        return rfcEmisorCtaBen;
    }


    /**
     * Sets the rfcEmisorCtaBen value for this PagosPago20R.
     * 
     * @param rfcEmisorCtaBen
     */
    public void setRfcEmisorCtaBen(java.lang.String rfcEmisorCtaBen) {
        this.rfcEmisorCtaBen = rfcEmisorCtaBen;
    }


    /**
     * Gets the rfcEmisorCtaOrd value for this PagosPago20R.
     * 
     * @return rfcEmisorCtaOrd
     */
    public java.lang.String getRfcEmisorCtaOrd() {
        return rfcEmisorCtaOrd;
    }


    /**
     * Sets the rfcEmisorCtaOrd value for this PagosPago20R.
     * 
     * @param rfcEmisorCtaOrd
     */
    public void setRfcEmisorCtaOrd(java.lang.String rfcEmisorCtaOrd) {
        this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
    }


    /**
     * Gets the selloPago value for this PagosPago20R.
     * 
     * @return selloPago
     */
    public java.lang.String getSelloPago() {
        return selloPago;
    }


    /**
     * Sets the selloPago value for this PagosPago20R.
     * 
     * @param selloPago
     */
    public void setSelloPago(java.lang.String selloPago) {
        this.selloPago = selloPago;
    }


    /**
     * Gets the tipoCadPago value for this PagosPago20R.
     * 
     * @return tipoCadPago
     */
    public java.lang.String getTipoCadPago() {
        return tipoCadPago;
    }


    /**
     * Sets the tipoCadPago value for this PagosPago20R.
     * 
     * @param tipoCadPago
     */
    public void setTipoCadPago(java.lang.String tipoCadPago) {
        this.tipoCadPago = tipoCadPago;
    }


    /**
     * Gets the tipoCambioP value for this PagosPago20R.
     * 
     * @return tipoCambioP
     */
    public java.math.BigDecimal getTipoCambioP() {
        return tipoCambioP;
    }


    /**
     * Sets the tipoCambioP value for this PagosPago20R.
     * 
     * @param tipoCambioP
     */
    public void setTipoCambioP(java.math.BigDecimal tipoCambioP) {
        this.tipoCambioP = tipoCambioP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPago20R)) return false;
        PagosPago20R other = (PagosPago20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cadPago==null && other.getCadPago()==null) || 
             (this.cadPago!=null &&
              this.cadPago.equals(other.getCadPago()))) &&
            ((this.certPago==null && other.getCertPago()==null) || 
             (this.certPago!=null &&
              this.certPago.equals(other.getCertPago()))) &&
            ((this.ctaBeneficiario==null && other.getCtaBeneficiario()==null) || 
             (this.ctaBeneficiario!=null &&
              this.ctaBeneficiario.equals(other.getCtaBeneficiario()))) &&
            ((this.ctaOrdenante==null && other.getCtaOrdenante()==null) || 
             (this.ctaOrdenante!=null &&
              this.ctaOrdenante.equals(other.getCtaOrdenante()))) &&
            ((this.doctoRelacionado==null && other.getDoctoRelacionado()==null) || 
             (this.doctoRelacionado!=null &&
              java.util.Arrays.equals(this.doctoRelacionado, other.getDoctoRelacionado()))) &&
            ((this.fechaPago==null && other.getFechaPago()==null) || 
             (this.fechaPago!=null &&
              this.fechaPago.equals(other.getFechaPago()))) &&
            ((this.formaDePagoP==null && other.getFormaDePagoP()==null) || 
             (this.formaDePagoP!=null &&
              this.formaDePagoP.equals(other.getFormaDePagoP()))) &&
            ((this.impuestosP==null && other.getImpuestosP()==null) || 
             (this.impuestosP!=null &&
              java.util.Arrays.equals(this.impuestosP, other.getImpuestosP()))) &&
            ((this.monedaP==null && other.getMonedaP()==null) || 
             (this.monedaP!=null &&
              this.monedaP.equals(other.getMonedaP()))) &&
            ((this.monto==null && other.getMonto()==null) || 
             (this.monto!=null &&
              this.monto.equals(other.getMonto()))) &&
            ((this.nomBancoOrdExt==null && other.getNomBancoOrdExt()==null) || 
             (this.nomBancoOrdExt!=null &&
              this.nomBancoOrdExt.equals(other.getNomBancoOrdExt()))) &&
            ((this.numOperacion==null && other.getNumOperacion()==null) || 
             (this.numOperacion!=null &&
              this.numOperacion.equals(other.getNumOperacion()))) &&
            ((this.rfcEmisorCtaBen==null && other.getRfcEmisorCtaBen()==null) || 
             (this.rfcEmisorCtaBen!=null &&
              this.rfcEmisorCtaBen.equals(other.getRfcEmisorCtaBen()))) &&
            ((this.rfcEmisorCtaOrd==null && other.getRfcEmisorCtaOrd()==null) || 
             (this.rfcEmisorCtaOrd!=null &&
              this.rfcEmisorCtaOrd.equals(other.getRfcEmisorCtaOrd()))) &&
            ((this.selloPago==null && other.getSelloPago()==null) || 
             (this.selloPago!=null &&
              this.selloPago.equals(other.getSelloPago()))) &&
            ((this.tipoCadPago==null && other.getTipoCadPago()==null) || 
             (this.tipoCadPago!=null &&
              this.tipoCadPago.equals(other.getTipoCadPago()))) &&
            ((this.tipoCambioP==null && other.getTipoCambioP()==null) || 
             (this.tipoCambioP!=null &&
              this.tipoCambioP.equals(other.getTipoCambioP())));
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
        if (getCadPago() != null) {
            _hashCode += getCadPago().hashCode();
        }
        if (getCertPago() != null) {
            _hashCode += getCertPago().hashCode();
        }
        if (getCtaBeneficiario() != null) {
            _hashCode += getCtaBeneficiario().hashCode();
        }
        if (getCtaOrdenante() != null) {
            _hashCode += getCtaOrdenante().hashCode();
        }
        if (getDoctoRelacionado() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDoctoRelacionado());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDoctoRelacionado(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaPago() != null) {
            _hashCode += getFechaPago().hashCode();
        }
        if (getFormaDePagoP() != null) {
            _hashCode += getFormaDePagoP().hashCode();
        }
        if (getImpuestosP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImpuestosP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImpuestosP(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMonedaP() != null) {
            _hashCode += getMonedaP().hashCode();
        }
        if (getMonto() != null) {
            _hashCode += getMonto().hashCode();
        }
        if (getNomBancoOrdExt() != null) {
            _hashCode += getNomBancoOrdExt().hashCode();
        }
        if (getNumOperacion() != null) {
            _hashCode += getNumOperacion().hashCode();
        }
        if (getRfcEmisorCtaBen() != null) {
            _hashCode += getRfcEmisorCtaBen().hashCode();
        }
        if (getRfcEmisorCtaOrd() != null) {
            _hashCode += getRfcEmisorCtaOrd().hashCode();
        }
        if (getSelloPago() != null) {
            _hashCode += getSelloPago().hashCode();
        }
        if (getTipoCadPago() != null) {
            _hashCode += getTipoCadPago().hashCode();
        }
        if (getTipoCambioP() != null) {
            _hashCode += getTipoCambioP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPago20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cadPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CadPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CtaBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctaOrdenante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CtaOrdenante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctoRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DoctoRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaDePagoP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FormaDePagoP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestosP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monedaP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MonedaP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomBancoOrdExt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NomBancoOrdExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisorCtaBen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcEmisorCtaBen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisorCtaOrd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcEmisorCtaOrd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selloPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SelloPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCadPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCadPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCambioP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCambioP"));
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
