/**
 * BeneficiarioR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class BeneficiarioR  implements java.io.Serializable {
    private java.lang.String bancoReceptor;

    private java.lang.String concepto;

    private java.math.BigDecimal cuenta;

    private java.math.BigDecimal IVA;

    private java.math.BigDecimal montoPago;

    private java.lang.String nombre;

    private java.lang.String RFC;

    private java.math.BigDecimal tipoCuenta;

    public BeneficiarioR() {
    }

    public BeneficiarioR(
           java.lang.String bancoReceptor,
           java.lang.String concepto,
           java.math.BigDecimal cuenta,
           java.math.BigDecimal IVA,
           java.math.BigDecimal montoPago,
           java.lang.String nombre,
           java.lang.String RFC,
           java.math.BigDecimal tipoCuenta) {
           this.bancoReceptor = bancoReceptor;
           this.concepto = concepto;
           this.cuenta = cuenta;
           this.IVA = IVA;
           this.montoPago = montoPago;
           this.nombre = nombre;
           this.RFC = RFC;
           this.tipoCuenta = tipoCuenta;
    }


    /**
     * Gets the bancoReceptor value for this BeneficiarioR.
     * 
     * @return bancoReceptor
     */
    public java.lang.String getBancoReceptor() {
        return bancoReceptor;
    }


    /**
     * Sets the bancoReceptor value for this BeneficiarioR.
     * 
     * @param bancoReceptor
     */
    public void setBancoReceptor(java.lang.String bancoReceptor) {
        this.bancoReceptor = bancoReceptor;
    }


    /**
     * Gets the concepto value for this BeneficiarioR.
     * 
     * @return concepto
     */
    public java.lang.String getConcepto() {
        return concepto;
    }


    /**
     * Sets the concepto value for this BeneficiarioR.
     * 
     * @param concepto
     */
    public void setConcepto(java.lang.String concepto) {
        this.concepto = concepto;
    }


    /**
     * Gets the cuenta value for this BeneficiarioR.
     * 
     * @return cuenta
     */
    public java.math.BigDecimal getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this BeneficiarioR.
     * 
     * @param cuenta
     */
    public void setCuenta(java.math.BigDecimal cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the IVA value for this BeneficiarioR.
     * 
     * @return IVA
     */
    public java.math.BigDecimal getIVA() {
        return IVA;
    }


    /**
     * Sets the IVA value for this BeneficiarioR.
     * 
     * @param IVA
     */
    public void setIVA(java.math.BigDecimal IVA) {
        this.IVA = IVA;
    }


    /**
     * Gets the montoPago value for this BeneficiarioR.
     * 
     * @return montoPago
     */
    public java.math.BigDecimal getMontoPago() {
        return montoPago;
    }


    /**
     * Sets the montoPago value for this BeneficiarioR.
     * 
     * @param montoPago
     */
    public void setMontoPago(java.math.BigDecimal montoPago) {
        this.montoPago = montoPago;
    }


    /**
     * Gets the nombre value for this BeneficiarioR.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this BeneficiarioR.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the RFC value for this BeneficiarioR.
     * 
     * @return RFC
     */
    public java.lang.String getRFC() {
        return RFC;
    }


    /**
     * Sets the RFC value for this BeneficiarioR.
     * 
     * @param RFC
     */
    public void setRFC(java.lang.String RFC) {
        this.RFC = RFC;
    }


    /**
     * Gets the tipoCuenta value for this BeneficiarioR.
     * 
     * @return tipoCuenta
     */
    public java.math.BigDecimal getTipoCuenta() {
        return tipoCuenta;
    }


    /**
     * Sets the tipoCuenta value for this BeneficiarioR.
     * 
     * @param tipoCuenta
     */
    public void setTipoCuenta(java.math.BigDecimal tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeneficiarioR)) return false;
        BeneficiarioR other = (BeneficiarioR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bancoReceptor==null && other.getBancoReceptor()==null) || 
             (this.bancoReceptor!=null &&
              this.bancoReceptor.equals(other.getBancoReceptor()))) &&
            ((this.concepto==null && other.getConcepto()==null) || 
             (this.concepto!=null &&
              this.concepto.equals(other.getConcepto()))) &&
            ((this.cuenta==null && other.getCuenta()==null) || 
             (this.cuenta!=null &&
              this.cuenta.equals(other.getCuenta()))) &&
            ((this.IVA==null && other.getIVA()==null) || 
             (this.IVA!=null &&
              this.IVA.equals(other.getIVA()))) &&
            ((this.montoPago==null && other.getMontoPago()==null) || 
             (this.montoPago!=null &&
              this.montoPago.equals(other.getMontoPago()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.RFC==null && other.getRFC()==null) || 
             (this.RFC!=null &&
              this.RFC.equals(other.getRFC()))) &&
            ((this.tipoCuenta==null && other.getTipoCuenta()==null) || 
             (this.tipoCuenta!=null &&
              this.tipoCuenta.equals(other.getTipoCuenta())));
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
        if (getBancoReceptor() != null) {
            _hashCode += getBancoReceptor().hashCode();
        }
        if (getConcepto() != null) {
            _hashCode += getConcepto().hashCode();
        }
        if (getCuenta() != null) {
            _hashCode += getCuenta().hashCode();
        }
        if (getIVA() != null) {
            _hashCode += getIVA().hashCode();
        }
        if (getMontoPago() != null) {
            _hashCode += getMontoPago().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getRFC() != null) {
            _hashCode += getRFC().hashCode();
        }
        if (getTipoCuenta() != null) {
            _hashCode += getTipoCuenta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BeneficiarioR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BeneficiarioR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bancoReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BancoReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concepto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("montoPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MontoPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RFC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCuenta"));
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
