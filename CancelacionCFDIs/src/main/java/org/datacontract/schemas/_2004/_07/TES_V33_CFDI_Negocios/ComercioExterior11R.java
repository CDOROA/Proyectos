/**
 * ComercioExterior11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ComercioExterior11R  implements java.io.Serializable {
    private java.lang.Integer certificadoOrigen;

    private java.lang.String claveDePedimento;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R[] destinatario;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisor11R emisor;

    private java.lang.String incoterm;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R[] mercancias;

    private java.lang.String motivoTraslado;

    private java.lang.String numCertificadoOrigen;

    private java.lang.String numeroExportadorConfiable;

    private java.lang.String observaciones;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R[] propietario;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptor11R receptor;

    private java.lang.Integer subdivision;

    private java.math.BigDecimal tipoCambioUSD;

    private java.lang.String tipoOperacion;

    private java.math.BigDecimal totalUSD;

    public ComercioExterior11R() {
    }

    public ComercioExterior11R(
           java.lang.Integer certificadoOrigen,
           java.lang.String claveDePedimento,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R[] destinatario,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisor11R emisor,
           java.lang.String incoterm,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R[] mercancias,
           java.lang.String motivoTraslado,
           java.lang.String numCertificadoOrigen,
           java.lang.String numeroExportadorConfiable,
           java.lang.String observaciones,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R[] propietario,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptor11R receptor,
           java.lang.Integer subdivision,
           java.math.BigDecimal tipoCambioUSD,
           java.lang.String tipoOperacion,
           java.math.BigDecimal totalUSD) {
           this.certificadoOrigen = certificadoOrigen;
           this.claveDePedimento = claveDePedimento;
           this.destinatario = destinatario;
           this.emisor = emisor;
           this.incoterm = incoterm;
           this.mercancias = mercancias;
           this.motivoTraslado = motivoTraslado;
           this.numCertificadoOrigen = numCertificadoOrigen;
           this.numeroExportadorConfiable = numeroExportadorConfiable;
           this.observaciones = observaciones;
           this.propietario = propietario;
           this.receptor = receptor;
           this.subdivision = subdivision;
           this.tipoCambioUSD = tipoCambioUSD;
           this.tipoOperacion = tipoOperacion;
           this.totalUSD = totalUSD;
    }


    /**
     * Gets the certificadoOrigen value for this ComercioExterior11R.
     * 
     * @return certificadoOrigen
     */
    public java.lang.Integer getCertificadoOrigen() {
        return certificadoOrigen;
    }


    /**
     * Sets the certificadoOrigen value for this ComercioExterior11R.
     * 
     * @param certificadoOrigen
     */
    public void setCertificadoOrigen(java.lang.Integer certificadoOrigen) {
        this.certificadoOrigen = certificadoOrigen;
    }


    /**
     * Gets the claveDePedimento value for this ComercioExterior11R.
     * 
     * @return claveDePedimento
     */
    public java.lang.String getClaveDePedimento() {
        return claveDePedimento;
    }


    /**
     * Sets the claveDePedimento value for this ComercioExterior11R.
     * 
     * @param claveDePedimento
     */
    public void setClaveDePedimento(java.lang.String claveDePedimento) {
        this.claveDePedimento = claveDePedimento;
    }


    /**
     * Gets the destinatario value for this ComercioExterior11R.
     * 
     * @return destinatario
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R[] getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this ComercioExterior11R.
     * 
     * @param destinatario
     */
    public void setDestinatario(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorDestinatario11R[] destinatario) {
        this.destinatario = destinatario;
    }


    /**
     * Gets the emisor value for this ComercioExterior11R.
     * 
     * @return emisor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisor11R getEmisor() {
        return emisor;
    }


    /**
     * Sets the emisor value for this ComercioExterior11R.
     * 
     * @param emisor
     */
    public void setEmisor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisor11R emisor) {
        this.emisor = emisor;
    }


    /**
     * Gets the incoterm value for this ComercioExterior11R.
     * 
     * @return incoterm
     */
    public java.lang.String getIncoterm() {
        return incoterm;
    }


    /**
     * Sets the incoterm value for this ComercioExterior11R.
     * 
     * @param incoterm
     */
    public void setIncoterm(java.lang.String incoterm) {
        this.incoterm = incoterm;
    }


    /**
     * Gets the mercancias value for this ComercioExterior11R.
     * 
     * @return mercancias
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R[] getMercancias() {
        return mercancias;
    }


    /**
     * Sets the mercancias value for this ComercioExterior11R.
     * 
     * @param mercancias
     */
    public void setMercancias(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorMercancia11R[] mercancias) {
        this.mercancias = mercancias;
    }


    /**
     * Gets the motivoTraslado value for this ComercioExterior11R.
     * 
     * @return motivoTraslado
     */
    public java.lang.String getMotivoTraslado() {
        return motivoTraslado;
    }


    /**
     * Sets the motivoTraslado value for this ComercioExterior11R.
     * 
     * @param motivoTraslado
     */
    public void setMotivoTraslado(java.lang.String motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
    }


    /**
     * Gets the numCertificadoOrigen value for this ComercioExterior11R.
     * 
     * @return numCertificadoOrigen
     */
    public java.lang.String getNumCertificadoOrigen() {
        return numCertificadoOrigen;
    }


    /**
     * Sets the numCertificadoOrigen value for this ComercioExterior11R.
     * 
     * @param numCertificadoOrigen
     */
    public void setNumCertificadoOrigen(java.lang.String numCertificadoOrigen) {
        this.numCertificadoOrigen = numCertificadoOrigen;
    }


    /**
     * Gets the numeroExportadorConfiable value for this ComercioExterior11R.
     * 
     * @return numeroExportadorConfiable
     */
    public java.lang.String getNumeroExportadorConfiable() {
        return numeroExportadorConfiable;
    }


    /**
     * Sets the numeroExportadorConfiable value for this ComercioExterior11R.
     * 
     * @param numeroExportadorConfiable
     */
    public void setNumeroExportadorConfiable(java.lang.String numeroExportadorConfiable) {
        this.numeroExportadorConfiable = numeroExportadorConfiable;
    }


    /**
     * Gets the observaciones value for this ComercioExterior11R.
     * 
     * @return observaciones
     */
    public java.lang.String getObservaciones() {
        return observaciones;
    }


    /**
     * Sets the observaciones value for this ComercioExterior11R.
     * 
     * @param observaciones
     */
    public void setObservaciones(java.lang.String observaciones) {
        this.observaciones = observaciones;
    }


    /**
     * Gets the propietario value for this ComercioExterior11R.
     * 
     * @return propietario
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R[] getPropietario() {
        return propietario;
    }


    /**
     * Sets the propietario value for this ComercioExterior11R.
     * 
     * @param propietario
     */
    public void setPropietario(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorPropietario11R[] propietario) {
        this.propietario = propietario;
    }


    /**
     * Gets the receptor value for this ComercioExterior11R.
     * 
     * @return receptor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptor11R getReceptor() {
        return receptor;
    }


    /**
     * Sets the receptor value for this ComercioExterior11R.
     * 
     * @param receptor
     */
    public void setReceptor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorReceptor11R receptor) {
        this.receptor = receptor;
    }


    /**
     * Gets the subdivision value for this ComercioExterior11R.
     * 
     * @return subdivision
     */
    public java.lang.Integer getSubdivision() {
        return subdivision;
    }


    /**
     * Sets the subdivision value for this ComercioExterior11R.
     * 
     * @param subdivision
     */
    public void setSubdivision(java.lang.Integer subdivision) {
        this.subdivision = subdivision;
    }


    /**
     * Gets the tipoCambioUSD value for this ComercioExterior11R.
     * 
     * @return tipoCambioUSD
     */
    public java.math.BigDecimal getTipoCambioUSD() {
        return tipoCambioUSD;
    }


    /**
     * Sets the tipoCambioUSD value for this ComercioExterior11R.
     * 
     * @param tipoCambioUSD
     */
    public void setTipoCambioUSD(java.math.BigDecimal tipoCambioUSD) {
        this.tipoCambioUSD = tipoCambioUSD;
    }


    /**
     * Gets the tipoOperacion value for this ComercioExterior11R.
     * 
     * @return tipoOperacion
     */
    public java.lang.String getTipoOperacion() {
        return tipoOperacion;
    }


    /**
     * Sets the tipoOperacion value for this ComercioExterior11R.
     * 
     * @param tipoOperacion
     */
    public void setTipoOperacion(java.lang.String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }


    /**
     * Gets the totalUSD value for this ComercioExterior11R.
     * 
     * @return totalUSD
     */
    public java.math.BigDecimal getTotalUSD() {
        return totalUSD;
    }


    /**
     * Sets the totalUSD value for this ComercioExterior11R.
     * 
     * @param totalUSD
     */
    public void setTotalUSD(java.math.BigDecimal totalUSD) {
        this.totalUSD = totalUSD;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExterior11R)) return false;
        ComercioExterior11R other = (ComercioExterior11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.certificadoOrigen==null && other.getCertificadoOrigen()==null) || 
             (this.certificadoOrigen!=null &&
              this.certificadoOrigen.equals(other.getCertificadoOrigen()))) &&
            ((this.claveDePedimento==null && other.getClaveDePedimento()==null) || 
             (this.claveDePedimento!=null &&
              this.claveDePedimento.equals(other.getClaveDePedimento()))) &&
            ((this.destinatario==null && other.getDestinatario()==null) || 
             (this.destinatario!=null &&
              java.util.Arrays.equals(this.destinatario, other.getDestinatario()))) &&
            ((this.emisor==null && other.getEmisor()==null) || 
             (this.emisor!=null &&
              this.emisor.equals(other.getEmisor()))) &&
            ((this.incoterm==null && other.getIncoterm()==null) || 
             (this.incoterm!=null &&
              this.incoterm.equals(other.getIncoterm()))) &&
            ((this.mercancias==null && other.getMercancias()==null) || 
             (this.mercancias!=null &&
              java.util.Arrays.equals(this.mercancias, other.getMercancias()))) &&
            ((this.motivoTraslado==null && other.getMotivoTraslado()==null) || 
             (this.motivoTraslado!=null &&
              this.motivoTraslado.equals(other.getMotivoTraslado()))) &&
            ((this.numCertificadoOrigen==null && other.getNumCertificadoOrigen()==null) || 
             (this.numCertificadoOrigen!=null &&
              this.numCertificadoOrigen.equals(other.getNumCertificadoOrigen()))) &&
            ((this.numeroExportadorConfiable==null && other.getNumeroExportadorConfiable()==null) || 
             (this.numeroExportadorConfiable!=null &&
              this.numeroExportadorConfiable.equals(other.getNumeroExportadorConfiable()))) &&
            ((this.observaciones==null && other.getObservaciones()==null) || 
             (this.observaciones!=null &&
              this.observaciones.equals(other.getObservaciones()))) &&
            ((this.propietario==null && other.getPropietario()==null) || 
             (this.propietario!=null &&
              java.util.Arrays.equals(this.propietario, other.getPropietario()))) &&
            ((this.receptor==null && other.getReceptor()==null) || 
             (this.receptor!=null &&
              this.receptor.equals(other.getReceptor()))) &&
            ((this.subdivision==null && other.getSubdivision()==null) || 
             (this.subdivision!=null &&
              this.subdivision.equals(other.getSubdivision()))) &&
            ((this.tipoCambioUSD==null && other.getTipoCambioUSD()==null) || 
             (this.tipoCambioUSD!=null &&
              this.tipoCambioUSD.equals(other.getTipoCambioUSD()))) &&
            ((this.tipoOperacion==null && other.getTipoOperacion()==null) || 
             (this.tipoOperacion!=null &&
              this.tipoOperacion.equals(other.getTipoOperacion()))) &&
            ((this.totalUSD==null && other.getTotalUSD()==null) || 
             (this.totalUSD!=null &&
              this.totalUSD.equals(other.getTotalUSD())));
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
        if (getCertificadoOrigen() != null) {
            _hashCode += getCertificadoOrigen().hashCode();
        }
        if (getClaveDePedimento() != null) {
            _hashCode += getClaveDePedimento().hashCode();
        }
        if (getDestinatario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDestinatario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDestinatario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEmisor() != null) {
            _hashCode += getEmisor().hashCode();
        }
        if (getIncoterm() != null) {
            _hashCode += getIncoterm().hashCode();
        }
        if (getMercancias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMercancias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMercancias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMotivoTraslado() != null) {
            _hashCode += getMotivoTraslado().hashCode();
        }
        if (getNumCertificadoOrigen() != null) {
            _hashCode += getNumCertificadoOrigen().hashCode();
        }
        if (getNumeroExportadorConfiable() != null) {
            _hashCode += getNumeroExportadorConfiable().hashCode();
        }
        if (getObservaciones() != null) {
            _hashCode += getObservaciones().hashCode();
        }
        if (getPropietario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPropietario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPropietario(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReceptor() != null) {
            _hashCode += getReceptor().hashCode();
        }
        if (getSubdivision() != null) {
            _hashCode += getSubdivision().hashCode();
        }
        if (getTipoCambioUSD() != null) {
            _hashCode += getTipoCambioUSD().hashCode();
        }
        if (getTipoOperacion() != null) {
            _hashCode += getTipoOperacion().hashCode();
        }
        if (getTotalUSD() != null) {
            _hashCode += getTotalUSD().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExterior11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExterior11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certificadoOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoOrigen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveDePedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveDePedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Destinatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatario11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorDestinatario11R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Emisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisor11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incoterm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Incoterm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mercancias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Mercancias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorMercancia11R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motivoTraslado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MotivoTraslado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numCertificadoOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumCertificadoOrigen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroExportadorConfiable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroExportadorConfiable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Observaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propietario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Propietario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorPropietario11R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Receptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorReceptor11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subdivision");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Subdivision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCambioUSD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCambioUSD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalUSD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalUSD"));
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
