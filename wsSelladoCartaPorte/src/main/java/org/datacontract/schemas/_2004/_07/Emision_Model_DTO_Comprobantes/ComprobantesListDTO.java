/**
 * ComprobantesListDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Comprobantes;

public class ComprobantesListDTO  implements java.io.Serializable {
    private java.lang.String emisor;

    private java.lang.String estatus;

    private java.util.Calendar fechaTimbrado;

    private java.lang.String folio;

    private java.lang.String formapago;

    private java.lang.String metodoPago;

    private java.lang.String receptor;

    private java.lang.String referencia;

    private java.lang.String serie;

    private java.lang.String tipoComprobante;

    private java.math.BigDecimal total;

    private java.lang.String UUID;

    public ComprobantesListDTO() {
    }

    public ComprobantesListDTO(
           java.lang.String emisor,
           java.lang.String estatus,
           java.util.Calendar fechaTimbrado,
           java.lang.String folio,
           java.lang.String formapago,
           java.lang.String metodoPago,
           java.lang.String receptor,
           java.lang.String referencia,
           java.lang.String serie,
           java.lang.String tipoComprobante,
           java.math.BigDecimal total,
           java.lang.String UUID) {
           this.emisor = emisor;
           this.estatus = estatus;
           this.fechaTimbrado = fechaTimbrado;
           this.folio = folio;
           this.formapago = formapago;
           this.metodoPago = metodoPago;
           this.receptor = receptor;
           this.referencia = referencia;
           this.serie = serie;
           this.tipoComprobante = tipoComprobante;
           this.total = total;
           this.UUID = UUID;
    }


    /**
     * Gets the emisor value for this ComprobantesListDTO.
     * 
     * @return emisor
     */
    public java.lang.String getEmisor() {
        return emisor;
    }


    /**
     * Sets the emisor value for this ComprobantesListDTO.
     * 
     * @param emisor
     */
    public void setEmisor(java.lang.String emisor) {
        this.emisor = emisor;
    }


    /**
     * Gets the estatus value for this ComprobantesListDTO.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this ComprobantesListDTO.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the fechaTimbrado value for this ComprobantesListDTO.
     * 
     * @return fechaTimbrado
     */
    public java.util.Calendar getFechaTimbrado() {
        return fechaTimbrado;
    }


    /**
     * Sets the fechaTimbrado value for this ComprobantesListDTO.
     * 
     * @param fechaTimbrado
     */
    public void setFechaTimbrado(java.util.Calendar fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }


    /**
     * Gets the folio value for this ComprobantesListDTO.
     * 
     * @return folio
     */
    public java.lang.String getFolio() {
        return folio;
    }


    /**
     * Sets the folio value for this ComprobantesListDTO.
     * 
     * @param folio
     */
    public void setFolio(java.lang.String folio) {
        this.folio = folio;
    }


    /**
     * Gets the formapago value for this ComprobantesListDTO.
     * 
     * @return formapago
     */
    public java.lang.String getFormapago() {
        return formapago;
    }


    /**
     * Sets the formapago value for this ComprobantesListDTO.
     * 
     * @param formapago
     */
    public void setFormapago(java.lang.String formapago) {
        this.formapago = formapago;
    }


    /**
     * Gets the metodoPago value for this ComprobantesListDTO.
     * 
     * @return metodoPago
     */
    public java.lang.String getMetodoPago() {
        return metodoPago;
    }


    /**
     * Sets the metodoPago value for this ComprobantesListDTO.
     * 
     * @param metodoPago
     */
    public void setMetodoPago(java.lang.String metodoPago) {
        this.metodoPago = metodoPago;
    }


    /**
     * Gets the receptor value for this ComprobantesListDTO.
     * 
     * @return receptor
     */
    public java.lang.String getReceptor() {
        return receptor;
    }


    /**
     * Sets the receptor value for this ComprobantesListDTO.
     * 
     * @param receptor
     */
    public void setReceptor(java.lang.String receptor) {
        this.receptor = receptor;
    }


    /**
     * Gets the referencia value for this ComprobantesListDTO.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this ComprobantesListDTO.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the serie value for this ComprobantesListDTO.
     * 
     * @return serie
     */
    public java.lang.String getSerie() {
        return serie;
    }


    /**
     * Sets the serie value for this ComprobantesListDTO.
     * 
     * @param serie
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }


    /**
     * Gets the tipoComprobante value for this ComprobantesListDTO.
     * 
     * @return tipoComprobante
     */
    public java.lang.String getTipoComprobante() {
        return tipoComprobante;
    }


    /**
     * Sets the tipoComprobante value for this ComprobantesListDTO.
     * 
     * @param tipoComprobante
     */
    public void setTipoComprobante(java.lang.String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }


    /**
     * Gets the total value for this ComprobantesListDTO.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this ComprobantesListDTO.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }


    /**
     * Gets the UUID value for this ComprobantesListDTO.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this ComprobantesListDTO.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComprobantesListDTO)) return false;
        ComprobantesListDTO other = (ComprobantesListDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.emisor==null && other.getEmisor()==null) || 
             (this.emisor!=null &&
              this.emisor.equals(other.getEmisor()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.fechaTimbrado==null && other.getFechaTimbrado()==null) || 
             (this.fechaTimbrado!=null &&
              this.fechaTimbrado.equals(other.getFechaTimbrado()))) &&
            ((this.folio==null && other.getFolio()==null) || 
             (this.folio!=null &&
              this.folio.equals(other.getFolio()))) &&
            ((this.formapago==null && other.getFormapago()==null) || 
             (this.formapago!=null &&
              this.formapago.equals(other.getFormapago()))) &&
            ((this.metodoPago==null && other.getMetodoPago()==null) || 
             (this.metodoPago!=null &&
              this.metodoPago.equals(other.getMetodoPago()))) &&
            ((this.receptor==null && other.getReceptor()==null) || 
             (this.receptor!=null &&
              this.receptor.equals(other.getReceptor()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.serie==null && other.getSerie()==null) || 
             (this.serie!=null &&
              this.serie.equals(other.getSerie()))) &&
            ((this.tipoComprobante==null && other.getTipoComprobante()==null) || 
             (this.tipoComprobante!=null &&
              this.tipoComprobante.equals(other.getTipoComprobante()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID())));
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
        if (getEmisor() != null) {
            _hashCode += getEmisor().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getFechaTimbrado() != null) {
            _hashCode += getFechaTimbrado().hashCode();
        }
        if (getFolio() != null) {
            _hashCode += getFolio().hashCode();
        }
        if (getFormapago() != null) {
            _hashCode += getFormapago().hashCode();
        }
        if (getMetodoPago() != null) {
            _hashCode += getMetodoPago().hashCode();
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
        if (getTipoComprobante() != null) {
            _hashCode += getTipoComprobante().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComprobantesListDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "ComprobantesListDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Emisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaTimbrado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "FechaTimbrado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Folio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formapago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Formapago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metodoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "MetodoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Receptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Serie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoComprobante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "TipoComprobante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "Total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Comprobantes", "UUID"));
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
