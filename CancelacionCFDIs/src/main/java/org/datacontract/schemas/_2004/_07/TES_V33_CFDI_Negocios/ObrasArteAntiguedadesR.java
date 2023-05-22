/**
 * ObrasArteAntiguedadesR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ObrasArteAntiguedadesR  implements java.io.Serializable {
    private java.lang.String característicasDeObraoPieza;

    private java.util.Calendar fechaAdquisicion;

    private java.math.BigDecimal IVA;

    private java.lang.String otrosTipoBien;

    private java.lang.String otrosTituloAdquirido;

    private java.math.BigDecimal subtotal;

    private java.lang.String tipoBien;

    private java.lang.String titutloAdquirido;

    public ObrasArteAntiguedadesR() {
    }

    public ObrasArteAntiguedadesR(
           java.lang.String característicasDeObraoPieza,
           java.util.Calendar fechaAdquisicion,
           java.math.BigDecimal IVA,
           java.lang.String otrosTipoBien,
           java.lang.String otrosTituloAdquirido,
           java.math.BigDecimal subtotal,
           java.lang.String tipoBien,
           java.lang.String titutloAdquirido) {
           this.característicasDeObraoPieza = característicasDeObraoPieza;
           this.fechaAdquisicion = fechaAdquisicion;
           this.IVA = IVA;
           this.otrosTipoBien = otrosTipoBien;
           this.otrosTituloAdquirido = otrosTituloAdquirido;
           this.subtotal = subtotal;
           this.tipoBien = tipoBien;
           this.titutloAdquirido = titutloAdquirido;
    }


    /**
     * Gets the característicasDeObraoPieza value for this ObrasArteAntiguedadesR.
     * 
     * @return característicasDeObraoPieza
     */
    public java.lang.String getCaracterísticasDeObraoPieza() {
        return característicasDeObraoPieza;
    }


    /**
     * Sets the característicasDeObraoPieza value for this ObrasArteAntiguedadesR.
     * 
     * @param característicasDeObraoPieza
     */
    public void setCaracterísticasDeObraoPieza(java.lang.String característicasDeObraoPieza) {
        this.característicasDeObraoPieza = característicasDeObraoPieza;
    }


    /**
     * Gets the fechaAdquisicion value for this ObrasArteAntiguedadesR.
     * 
     * @return fechaAdquisicion
     */
    public java.util.Calendar getFechaAdquisicion() {
        return fechaAdquisicion;
    }


    /**
     * Sets the fechaAdquisicion value for this ObrasArteAntiguedadesR.
     * 
     * @param fechaAdquisicion
     */
    public void setFechaAdquisicion(java.util.Calendar fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }


    /**
     * Gets the IVA value for this ObrasArteAntiguedadesR.
     * 
     * @return IVA
     */
    public java.math.BigDecimal getIVA() {
        return IVA;
    }


    /**
     * Sets the IVA value for this ObrasArteAntiguedadesR.
     * 
     * @param IVA
     */
    public void setIVA(java.math.BigDecimal IVA) {
        this.IVA = IVA;
    }


    /**
     * Gets the otrosTipoBien value for this ObrasArteAntiguedadesR.
     * 
     * @return otrosTipoBien
     */
    public java.lang.String getOtrosTipoBien() {
        return otrosTipoBien;
    }


    /**
     * Sets the otrosTipoBien value for this ObrasArteAntiguedadesR.
     * 
     * @param otrosTipoBien
     */
    public void setOtrosTipoBien(java.lang.String otrosTipoBien) {
        this.otrosTipoBien = otrosTipoBien;
    }


    /**
     * Gets the otrosTituloAdquirido value for this ObrasArteAntiguedadesR.
     * 
     * @return otrosTituloAdquirido
     */
    public java.lang.String getOtrosTituloAdquirido() {
        return otrosTituloAdquirido;
    }


    /**
     * Sets the otrosTituloAdquirido value for this ObrasArteAntiguedadesR.
     * 
     * @param otrosTituloAdquirido
     */
    public void setOtrosTituloAdquirido(java.lang.String otrosTituloAdquirido) {
        this.otrosTituloAdquirido = otrosTituloAdquirido;
    }


    /**
     * Gets the subtotal value for this ObrasArteAntiguedadesR.
     * 
     * @return subtotal
     */
    public java.math.BigDecimal getSubtotal() {
        return subtotal;
    }


    /**
     * Sets the subtotal value for this ObrasArteAntiguedadesR.
     * 
     * @param subtotal
     */
    public void setSubtotal(java.math.BigDecimal subtotal) {
        this.subtotal = subtotal;
    }


    /**
     * Gets the tipoBien value for this ObrasArteAntiguedadesR.
     * 
     * @return tipoBien
     */
    public java.lang.String getTipoBien() {
        return tipoBien;
    }


    /**
     * Sets the tipoBien value for this ObrasArteAntiguedadesR.
     * 
     * @param tipoBien
     */
    public void setTipoBien(java.lang.String tipoBien) {
        this.tipoBien = tipoBien;
    }


    /**
     * Gets the titutloAdquirido value for this ObrasArteAntiguedadesR.
     * 
     * @return titutloAdquirido
     */
    public java.lang.String getTitutloAdquirido() {
        return titutloAdquirido;
    }


    /**
     * Sets the titutloAdquirido value for this ObrasArteAntiguedadesR.
     * 
     * @param titutloAdquirido
     */
    public void setTitutloAdquirido(java.lang.String titutloAdquirido) {
        this.titutloAdquirido = titutloAdquirido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObrasArteAntiguedadesR)) return false;
        ObrasArteAntiguedadesR other = (ObrasArteAntiguedadesR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.característicasDeObraoPieza==null && other.getCaracterísticasDeObraoPieza()==null) || 
             (this.característicasDeObraoPieza!=null &&
              this.característicasDeObraoPieza.equals(other.getCaracterísticasDeObraoPieza()))) &&
            ((this.fechaAdquisicion==null && other.getFechaAdquisicion()==null) || 
             (this.fechaAdquisicion!=null &&
              this.fechaAdquisicion.equals(other.getFechaAdquisicion()))) &&
            ((this.IVA==null && other.getIVA()==null) || 
             (this.IVA!=null &&
              this.IVA.equals(other.getIVA()))) &&
            ((this.otrosTipoBien==null && other.getOtrosTipoBien()==null) || 
             (this.otrosTipoBien!=null &&
              this.otrosTipoBien.equals(other.getOtrosTipoBien()))) &&
            ((this.otrosTituloAdquirido==null && other.getOtrosTituloAdquirido()==null) || 
             (this.otrosTituloAdquirido!=null &&
              this.otrosTituloAdquirido.equals(other.getOtrosTituloAdquirido()))) &&
            ((this.subtotal==null && other.getSubtotal()==null) || 
             (this.subtotal!=null &&
              this.subtotal.equals(other.getSubtotal()))) &&
            ((this.tipoBien==null && other.getTipoBien()==null) || 
             (this.tipoBien!=null &&
              this.tipoBien.equals(other.getTipoBien()))) &&
            ((this.titutloAdquirido==null && other.getTitutloAdquirido()==null) || 
             (this.titutloAdquirido!=null &&
              this.titutloAdquirido.equals(other.getTitutloAdquirido())));
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
        if (getCaracterísticasDeObraoPieza() != null) {
            _hashCode += getCaracterísticasDeObraoPieza().hashCode();
        }
        if (getFechaAdquisicion() != null) {
            _hashCode += getFechaAdquisicion().hashCode();
        }
        if (getIVA() != null) {
            _hashCode += getIVA().hashCode();
        }
        if (getOtrosTipoBien() != null) {
            _hashCode += getOtrosTipoBien().hashCode();
        }
        if (getOtrosTituloAdquirido() != null) {
            _hashCode += getOtrosTituloAdquirido().hashCode();
        }
        if (getSubtotal() != null) {
            _hashCode += getSubtotal().hashCode();
        }
        if (getTipoBien() != null) {
            _hashCode += getTipoBien().hashCode();
        }
        if (getTitutloAdquirido() != null) {
            _hashCode += getTitutloAdquirido().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObrasArteAntiguedadesR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ObrasArteAntiguedadesR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("característicasDeObraoPieza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CaracterísticasDeObraoPieza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAdquisicion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaAdquisicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otrosTipoBien");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosTipoBien"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otrosTituloAdquirido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosTituloAdquirido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Subtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoBien");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoBien"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titutloAdquirido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TitutloAdquirido"));
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
