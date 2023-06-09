/**
 * Pagos20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class Pagos20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R[] pago;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosTotales20R totales;

    private java.lang.String version;

    public Pagos20R() {
    }

    public Pagos20R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R[] pago,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosTotales20R totales,
           java.lang.String version) {
           this.pago = pago;
           this.totales = totales;
           this.version = version;
    }


    /**
     * Gets the pago value for this Pagos20R.
     * 
     * @return pago
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R[] getPago() {
        return pago;
    }


    /**
     * Sets the pago value for this Pagos20R.
     * 
     * @param pago
     */
    public void setPago(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPago20R[] pago) {
        this.pago = pago;
    }


    /**
     * Gets the totales value for this Pagos20R.
     * 
     * @return totales
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosTotales20R getTotales() {
        return totales;
    }


    /**
     * Sets the totales value for this Pagos20R.
     * 
     * @param totales
     */
    public void setTotales(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosTotales20R totales) {
        this.totales = totales;
    }


    /**
     * Gets the version value for this Pagos20R.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this Pagos20R.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pagos20R)) return false;
        Pagos20R other = (Pagos20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pago==null && other.getPago()==null) || 
             (this.pago!=null &&
              java.util.Arrays.equals(this.pago, other.getPago()))) &&
            ((this.totales==null && other.getTotales()==null) || 
             (this.totales!=null &&
              this.totales.equals(other.getTotales()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion())));
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
        if (getPago() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPago());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPago(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotales() != null) {
            _hashCode += getTotales().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pagos20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pagos20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPago20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Totales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosTotales20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Version"));
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
