/**
 * PagosPagoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class PagosPagoR  implements java.io.Serializable {
    private java.lang.String cadPago;

    private java.lang.String certPago;

    private java.lang.String ctaBeneficiario;

    private java.lang.String ctaOrdenante;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR[] doctoRelacionado;

    private java.util.Calendar fechaPago;

    private java.lang.String formaDePagoP;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosR impuestosP;

    private java.lang.String monedaP;

    private java.math.BigDecimal monto;

    private java.lang.String nomBancoOrdExt;

    private java.lang.String numOperacion;

    private java.lang.String rfcEmisorCtaBen;

    private java.lang.String rfcEmisorCtaOrd;

    private java.lang.String selloPago;

    private java.lang.String tipoCadPago;

    private java.math.BigDecimal tipoCambioP;

    public PagosPagoR() {
    }

    public PagosPagoR(
           java.lang.String cadPago,
           java.lang.String certPago,
           java.lang.String ctaBeneficiario,
           java.lang.String ctaOrdenante,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR[] doctoRelacionado,
           java.util.Calendar fechaPago,
           java.lang.String formaDePagoP,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosR impuestosP,
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
     * Gets the cadPago value for this PagosPagoR.
     * 
     * @return cadPago
     */
    public java.lang.String getCadPago() {
        return cadPago;
    }


    /**
     * Sets the cadPago value for this PagosPagoR.
     * 
     * @param cadPago
     */
    public void setCadPago(java.lang.String cadPago) {
        this.cadPago = cadPago;
    }


    /**
     * Gets the certPago value for this PagosPagoR.
     * 
     * @return certPago
     */
    public java.lang.String getCertPago() {
        return certPago;
    }


    /**
     * Sets the certPago value for this PagosPagoR.
     * 
     * @param certPago
     */
    public void setCertPago(java.lang.String certPago) {
        this.certPago = certPago;
    }


    /**
     * Gets the ctaBeneficiario value for this PagosPagoR.
     * 
     * @return ctaBeneficiario
     */
    public java.lang.String getCtaBeneficiario() {
        return ctaBeneficiario;
    }


    /**
     * Sets the ctaBeneficiario value for this PagosPagoR.
     * 
     * @param ctaBeneficiario
     */
    public void setCtaBeneficiario(java.lang.String ctaBeneficiario) {
        this.ctaBeneficiario = ctaBeneficiario;
    }


    /**
     * Gets the ctaOrdenante value for this PagosPagoR.
     * 
     * @return ctaOrdenante
     */
    public java.lang.String getCtaOrdenante() {
        return ctaOrdenante;
    }


    /**
     * Sets the ctaOrdenante value for this PagosPagoR.
     * 
     * @param ctaOrdenante
     */
    public void setCtaOrdenante(java.lang.String ctaOrdenante) {
        this.ctaOrdenante = ctaOrdenante;
    }


    /**
     * Gets the doctoRelacionado value for this PagosPagoR.
     * 
     * @return doctoRelacionado
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR[] getDoctoRelacionado() {
        return doctoRelacionado;
    }


    /**
     * Sets the doctoRelacionado value for this PagosPagoR.
     * 
     * @param doctoRelacionado
     */
    public void setDoctoRelacionado(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoDoctoRelacionadoR[] doctoRelacionado) {
        this.doctoRelacionado = doctoRelacionado;
    }


    /**
     * Gets the fechaPago value for this PagosPagoR.
     * 
     * @return fechaPago
     */
    public java.util.Calendar getFechaPago() {
        return fechaPago;
    }


    /**
     * Sets the fechaPago value for this PagosPagoR.
     * 
     * @param fechaPago
     */
    public void setFechaPago(java.util.Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }


    /**
     * Gets the formaDePagoP value for this PagosPagoR.
     * 
     * @return formaDePagoP
     */
    public java.lang.String getFormaDePagoP() {
        return formaDePagoP;
    }


    /**
     * Sets the formaDePagoP value for this PagosPagoR.
     * 
     * @param formaDePagoP
     */
    public void setFormaDePagoP(java.lang.String formaDePagoP) {
        this.formaDePagoP = formaDePagoP;
    }


    /**
     * Gets the impuestosP value for this PagosPagoR.
     * 
     * @return impuestosP
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosR getImpuestosP() {
        return impuestosP;
    }


    /**
     * Sets the impuestosP value for this PagosPagoR.
     * 
     * @param impuestosP
     */
    public void setImpuestosP(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagosPagoImpuestosR impuestosP) {
        this.impuestosP = impuestosP;
    }


    /**
     * Gets the monedaP value for this PagosPagoR.
     * 
     * @return monedaP
     */
    public java.lang.String getMonedaP() {
        return monedaP;
    }


    /**
     * Sets the monedaP value for this PagosPagoR.
     * 
     * @param monedaP
     */
    public void setMonedaP(java.lang.String monedaP) {
        this.monedaP = monedaP;
    }


    /**
     * Gets the monto value for this PagosPagoR.
     * 
     * @return monto
     */
    public java.math.BigDecimal getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this PagosPagoR.
     * 
     * @param monto
     */
    public void setMonto(java.math.BigDecimal monto) {
        this.monto = monto;
    }


    /**
     * Gets the nomBancoOrdExt value for this PagosPagoR.
     * 
     * @return nomBancoOrdExt
     */
    public java.lang.String getNomBancoOrdExt() {
        return nomBancoOrdExt;
    }


    /**
     * Sets the nomBancoOrdExt value for this PagosPagoR.
     * 
     * @param nomBancoOrdExt
     */
    public void setNomBancoOrdExt(java.lang.String nomBancoOrdExt) {
        this.nomBancoOrdExt = nomBancoOrdExt;
    }


    /**
     * Gets the numOperacion value for this PagosPagoR.
     * 
     * @return numOperacion
     */
    public java.lang.String getNumOperacion() {
        return numOperacion;
    }


    /**
     * Sets the numOperacion value for this PagosPagoR.
     * 
     * @param numOperacion
     */
    public void setNumOperacion(java.lang.String numOperacion) {
        this.numOperacion = numOperacion;
    }


    /**
     * Gets the rfcEmisorCtaBen value for this PagosPagoR.
     * 
     * @return rfcEmisorCtaBen
     */
    public java.lang.String getRfcEmisorCtaBen() {
        return rfcEmisorCtaBen;
    }


    /**
     * Sets the rfcEmisorCtaBen value for this PagosPagoR.
     * 
     * @param rfcEmisorCtaBen
     */
    public void setRfcEmisorCtaBen(java.lang.String rfcEmisorCtaBen) {
        this.rfcEmisorCtaBen = rfcEmisorCtaBen;
    }


    /**
     * Gets the rfcEmisorCtaOrd value for this PagosPagoR.
     * 
     * @return rfcEmisorCtaOrd
     */
    public java.lang.String getRfcEmisorCtaOrd() {
        return rfcEmisorCtaOrd;
    }


    /**
     * Sets the rfcEmisorCtaOrd value for this PagosPagoR.
     * 
     * @param rfcEmisorCtaOrd
     */
    public void setRfcEmisorCtaOrd(java.lang.String rfcEmisorCtaOrd) {
        this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
    }


    /**
     * Gets the selloPago value for this PagosPagoR.
     * 
     * @return selloPago
     */
    public java.lang.String getSelloPago() {
        return selloPago;
    }


    /**
     * Sets the selloPago value for this PagosPagoR.
     * 
     * @param selloPago
     */
    public void setSelloPago(java.lang.String selloPago) {
        this.selloPago = selloPago;
    }


    /**
     * Gets the tipoCadPago value for this PagosPagoR.
     * 
     * @return tipoCadPago
     */
    public java.lang.String getTipoCadPago() {
        return tipoCadPago;
    }


    /**
     * Sets the tipoCadPago value for this PagosPagoR.
     * 
     * @param tipoCadPago
     */
    public void setTipoCadPago(java.lang.String tipoCadPago) {
        this.tipoCadPago = tipoCadPago;
    }


    /**
     * Gets the tipoCambioP value for this PagosPagoR.
     * 
     * @return tipoCambioP
     */
    public java.math.BigDecimal getTipoCambioP() {
        return tipoCambioP;
    }


    /**
     * Sets the tipoCambioP value for this PagosPagoR.
     * 
     * @param tipoCambioP
     */
    public void setTipoCambioP(java.math.BigDecimal tipoCambioP) {
        this.tipoCambioP = tipoCambioP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoR)) return false;
        PagosPagoR other = (PagosPagoR) obj;
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
              this.impuestosP.equals(other.getImpuestosP()))) &&
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
            _hashCode += getImpuestosP().hashCode();
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
        new org.apache.axis.description.TypeDesc(PagosPagoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cadPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "CadPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "CertPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctaBeneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "CtaBeneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctaOrdenante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "CtaOrdenante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctoRelacionado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "DoctoRelacionado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoDoctoRelacionadoR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoDoctoRelacionadoR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "FechaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formaDePagoP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "FormaDePagoP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestosP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monedaP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "MonedaP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "Monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomBancoOrdExt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "NomBancoOrdExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "NumOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisorCtaBen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "RfcEmisorCtaBen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisorCtaOrd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "RfcEmisorCtaOrd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selloPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "SelloPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCadPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TipoCadPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCambioP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TipoCambioP"));
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
