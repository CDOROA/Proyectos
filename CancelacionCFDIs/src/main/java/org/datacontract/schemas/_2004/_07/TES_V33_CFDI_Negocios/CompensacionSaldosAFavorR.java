/**
 * CompensacionSaldosAFavorR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CompensacionSaldosAFavorR  implements java.io.Serializable {
    private java.lang.Short año;

    private java.math.BigDecimal remanenteSalFav;

    private java.math.BigDecimal saldoAFavor;

    public CompensacionSaldosAFavorR() {
    }

    public CompensacionSaldosAFavorR(
           java.lang.Short año,
           java.math.BigDecimal remanenteSalFav,
           java.math.BigDecimal saldoAFavor) {
           this.año = año;
           this.remanenteSalFav = remanenteSalFav;
           this.saldoAFavor = saldoAFavor;
    }


    /**
     * Gets the año value for this CompensacionSaldosAFavorR.
     * 
     * @return año
     */
    public java.lang.Short getAño() {
        return año;
    }


    /**
     * Sets the año value for this CompensacionSaldosAFavorR.
     * 
     * @param año
     */
    public void setAño(java.lang.Short año) {
        this.año = año;
    }


    /**
     * Gets the remanenteSalFav value for this CompensacionSaldosAFavorR.
     * 
     * @return remanenteSalFav
     */
    public java.math.BigDecimal getRemanenteSalFav() {
        return remanenteSalFav;
    }


    /**
     * Sets the remanenteSalFav value for this CompensacionSaldosAFavorR.
     * 
     * @param remanenteSalFav
     */
    public void setRemanenteSalFav(java.math.BigDecimal remanenteSalFav) {
        this.remanenteSalFav = remanenteSalFav;
    }


    /**
     * Gets the saldoAFavor value for this CompensacionSaldosAFavorR.
     * 
     * @return saldoAFavor
     */
    public java.math.BigDecimal getSaldoAFavor() {
        return saldoAFavor;
    }


    /**
     * Sets the saldoAFavor value for this CompensacionSaldosAFavorR.
     * 
     * @param saldoAFavor
     */
    public void setSaldoAFavor(java.math.BigDecimal saldoAFavor) {
        this.saldoAFavor = saldoAFavor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompensacionSaldosAFavorR)) return false;
        CompensacionSaldosAFavorR other = (CompensacionSaldosAFavorR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.año==null && other.getAño()==null) || 
             (this.año!=null &&
              this.año.equals(other.getAño()))) &&
            ((this.remanenteSalFav==null && other.getRemanenteSalFav()==null) || 
             (this.remanenteSalFav!=null &&
              this.remanenteSalFav.equals(other.getRemanenteSalFav()))) &&
            ((this.saldoAFavor==null && other.getSaldoAFavor()==null) || 
             (this.saldoAFavor!=null &&
              this.saldoAFavor.equals(other.getSaldoAFavor())));
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
        if (getAño() != null) {
            _hashCode += getAño().hashCode();
        }
        if (getRemanenteSalFav() != null) {
            _hashCode += getRemanenteSalFav().hashCode();
        }
        if (getSaldoAFavor() != null) {
            _hashCode += getSaldoAFavor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompensacionSaldosAFavorR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CompensacionSaldosAFavorR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("año");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Año"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remanenteSalFav");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RemanenteSalFav"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldoAFavor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SaldoAFavor"));
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
