/**
 * PagosPagoDoctoRelacionado20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoDoctoRelacionado20R  implements java.io.Serializable {
    private java.math.BigDecimal equivalenciaDR;

    private java.lang.String folio;

    private java.lang.String idDocumento;

    private java.math.BigDecimal impPagado;

    private java.math.BigDecimal impSaldoAnt;

    private java.math.BigDecimal impSaldoInsoluto;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDR20R impuestosDR;

    private java.lang.String monedaDR;

    private java.lang.String numParcialidad;

    private java.lang.String objetoImpDR;

    private java.lang.String serie;

    public PagosPagoDoctoRelacionado20R() {
    }

    public PagosPagoDoctoRelacionado20R(
           java.math.BigDecimal equivalenciaDR,
           java.lang.String folio,
           java.lang.String idDocumento,
           java.math.BigDecimal impPagado,
           java.math.BigDecimal impSaldoAnt,
           java.math.BigDecimal impSaldoInsoluto,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDR20R impuestosDR,
           java.lang.String monedaDR,
           java.lang.String numParcialidad,
           java.lang.String objetoImpDR,
           java.lang.String serie) {
           this.equivalenciaDR = equivalenciaDR;
           this.folio = folio;
           this.idDocumento = idDocumento;
           this.impPagado = impPagado;
           this.impSaldoAnt = impSaldoAnt;
           this.impSaldoInsoluto = impSaldoInsoluto;
           this.impuestosDR = impuestosDR;
           this.monedaDR = monedaDR;
           this.numParcialidad = numParcialidad;
           this.objetoImpDR = objetoImpDR;
           this.serie = serie;
    }


    /**
     * Gets the equivalenciaDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return equivalenciaDR
     */
    public java.math.BigDecimal getEquivalenciaDR() {
        return equivalenciaDR;
    }


    /**
     * Sets the equivalenciaDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param equivalenciaDR
     */
    public void setEquivalenciaDR(java.math.BigDecimal equivalenciaDR) {
        this.equivalenciaDR = equivalenciaDR;
    }


    /**
     * Gets the folio value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return folio
     */
    public java.lang.String getFolio() {
        return folio;
    }


    /**
     * Sets the folio value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param folio
     */
    public void setFolio(java.lang.String folio) {
        this.folio = folio;
    }


    /**
     * Gets the idDocumento value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return idDocumento
     */
    public java.lang.String getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(java.lang.String idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the impPagado value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return impPagado
     */
    public java.math.BigDecimal getImpPagado() {
        return impPagado;
    }


    /**
     * Sets the impPagado value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param impPagado
     */
    public void setImpPagado(java.math.BigDecimal impPagado) {
        this.impPagado = impPagado;
    }


    /**
     * Gets the impSaldoAnt value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return impSaldoAnt
     */
    public java.math.BigDecimal getImpSaldoAnt() {
        return impSaldoAnt;
    }


    /**
     * Sets the impSaldoAnt value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param impSaldoAnt
     */
    public void setImpSaldoAnt(java.math.BigDecimal impSaldoAnt) {
        this.impSaldoAnt = impSaldoAnt;
    }


    /**
     * Gets the impSaldoInsoluto value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return impSaldoInsoluto
     */
    public java.math.BigDecimal getImpSaldoInsoluto() {
        return impSaldoInsoluto;
    }


    /**
     * Sets the impSaldoInsoluto value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param impSaldoInsoluto
     */
    public void setImpSaldoInsoluto(java.math.BigDecimal impSaldoInsoluto) {
        this.impSaldoInsoluto = impSaldoInsoluto;
    }


    /**
     * Gets the impuestosDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return impuestosDR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDR20R getImpuestosDR() {
        return impuestosDR;
    }


    /**
     * Sets the impuestosDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param impuestosDR
     */
    public void setImpuestosDR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDR20R impuestosDR) {
        this.impuestosDR = impuestosDR;
    }


    /**
     * Gets the monedaDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return monedaDR
     */
    public java.lang.String getMonedaDR() {
        return monedaDR;
    }


    /**
     * Sets the monedaDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param monedaDR
     */
    public void setMonedaDR(java.lang.String monedaDR) {
        this.monedaDR = monedaDR;
    }


    /**
     * Gets the numParcialidad value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return numParcialidad
     */
    public java.lang.String getNumParcialidad() {
        return numParcialidad;
    }


    /**
     * Sets the numParcialidad value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param numParcialidad
     */
    public void setNumParcialidad(java.lang.String numParcialidad) {
        this.numParcialidad = numParcialidad;
    }


    /**
     * Gets the objetoImpDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return objetoImpDR
     */
    public java.lang.String getObjetoImpDR() {
        return objetoImpDR;
    }


    /**
     * Sets the objetoImpDR value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param objetoImpDR
     */
    public void setObjetoImpDR(java.lang.String objetoImpDR) {
        this.objetoImpDR = objetoImpDR;
    }


    /**
     * Gets the serie value for this PagosPagoDoctoRelacionado20R.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this PagosPagoDoctoRelacionado20R.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoDoctoRelacionado20R)) return false;
        PagosPagoDoctoRelacionado20R other = (PagosPagoDoctoRelacionado20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.equivalenciaDR==null && other.getEquivalenciaDR()==null) || 
             (this.equivalenciaDR!=null &&
              this.equivalenciaDR.equals(other.getEquivalenciaDR()))) &&
            ((this.folio==null && other.getFolio()==null) || 
             (this.folio!=null &&
              this.folio.equals(other.getFolio()))) &&
            ((this.idDocumento==null && other.getIdDocumento()==null) || 
             (this.idDocumento!=null &&
              this.idDocumento.equals(other.getIdDocumento()))) &&
            ((this.impPagado==null && other.getImpPagado()==null) || 
             (this.impPagado!=null &&
              this.impPagado.equals(other.getImpPagado()))) &&
            ((this.impSaldoAnt==null && other.getImpSaldoAnt()==null) || 
             (this.impSaldoAnt!=null &&
              this.impSaldoAnt.equals(other.getImpSaldoAnt()))) &&
            ((this.impSaldoInsoluto==null && other.getImpSaldoInsoluto()==null) || 
             (this.impSaldoInsoluto!=null &&
              this.impSaldoInsoluto.equals(other.getImpSaldoInsoluto()))) &&
            ((this.impuestosDR==null && other.getImpuestosDR()==null) || 
             (this.impuestosDR!=null &&
              this.impuestosDR.equals(other.getImpuestosDR()))) &&
            ((this.monedaDR==null && other.getMonedaDR()==null) || 
             (this.monedaDR!=null &&
              this.monedaDR.equals(other.getMonedaDR()))) &&
            ((this.numParcialidad==null && other.getNumParcialidad()==null) || 
             (this.numParcialidad!=null &&
              this.numParcialidad.equals(other.getNumParcialidad()))) &&
            ((this.objetoImpDR==null && other.getObjetoImpDR()==null) || 
             (this.objetoImpDR!=null &&
              this.objetoImpDR.equals(other.getObjetoImpDR()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie())));
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
        if (getEquivalenciaDR() != null) {
            _hashCode += getEquivalenciaDR().hashCode();
        }
        if (getFolio() != null) {
            _hashCode += getFolio().hashCode();
        }
        if (getIdDocumento() != null) {
            _hashCode += getIdDocumento().hashCode();
        }
        if (getImpPagado() != null) {
            _hashCode += getImpPagado().hashCode();
        }
        if (getImpSaldoAnt() != null) {
            _hashCode += getImpSaldoAnt().hashCode();
        }
        if (getImpSaldoInsoluto() != null) {
            _hashCode += getImpSaldoInsoluto().hashCode();
        }
        if (getImpuestosDR() != null) {
            _hashCode += getImpuestosDR().hashCode();
        }
        if (getMonedaDR() != null) {
            _hashCode += getMonedaDR().hashCode();
        }
        if (getNumParcialidad() != null) {
            _hashCode += getNumParcialidad().hashCode();
        }
        if (getObjetoImpDR() != null) {
            _hashCode += getObjetoImpDR().hashCode();
        }
        if (getSerie() != null) {
            _hashCode += getSerie().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPagoDoctoRelacionado20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionado20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equivalenciaDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EquivalenciaDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Folio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impPagado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpPagado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impSaldoAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpSaldoAnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impSaldoInsoluto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpSaldoInsoluto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestosDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDR20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monedaDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MonedaDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numParcialidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumParcialidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objetoImpDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObjetoImpDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Serie"));
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
