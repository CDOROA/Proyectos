/**
 * ComercioExteriorEmisor11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ComercioExteriorEmisor11R  implements java.io.Serializable {
    private java.lang.String curp;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R domicilio;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R expedidoEn;

    public ComercioExteriorEmisor11R() {
    }

    public ComercioExteriorEmisor11R(
           java.lang.String curp,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R domicilio,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R expedidoEn) {
           this.curp = curp;
           this.domicilio = domicilio;
           this.expedidoEn = expedidoEn;
    }


    /**
     * Gets the curp value for this ComercioExteriorEmisor11R.
     * 
     * @return curp
     */
    public java.lang.String getCurp() {
        return curp;
    }


    /**
     * Sets the curp value for this ComercioExteriorEmisor11R.
     * 
     * @param curp
     */
    public void setCurp(java.lang.String curp) {
        this.curp = curp;
    }


    /**
     * Gets the domicilio value for this ComercioExteriorEmisor11R.
     * 
     * @return domicilio
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R getDomicilio() {
        return domicilio;
    }


    /**
     * Sets the domicilio value for this ComercioExteriorEmisor11R.
     * 
     * @param domicilio
     */
    public void setDomicilio(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R domicilio) {
        this.domicilio = domicilio;
    }


    /**
     * Gets the expedidoEn value for this ComercioExteriorEmisor11R.
     * 
     * @return expedidoEn
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R getExpedidoEn() {
        return expedidoEn;
    }


    /**
     * Sets the expedidoEn value for this ComercioExteriorEmisor11R.
     * 
     * @param expedidoEn
     */
    public void setExpedidoEn(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ComercioExteriorEmisorDomicilio11R expedidoEn) {
        this.expedidoEn = expedidoEn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComercioExteriorEmisor11R)) return false;
        ComercioExteriorEmisor11R other = (ComercioExteriorEmisor11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.curp==null && other.getCurp()==null) || 
             (this.curp!=null &&
              this.curp.equals(other.getCurp()))) &&
            ((this.domicilio==null && other.getDomicilio()==null) || 
             (this.domicilio!=null &&
              this.domicilio.equals(other.getDomicilio()))) &&
            ((this.expedidoEn==null && other.getExpedidoEn()==null) || 
             (this.expedidoEn!=null &&
              this.expedidoEn.equals(other.getExpedidoEn())));
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
        if (getCurp() != null) {
            _hashCode += getCurp().hashCode();
        }
        if (getDomicilio() != null) {
            _hashCode += getDomicilio().hashCode();
        }
        if (getExpedidoEn() != null) {
            _hashCode += getExpedidoEn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComercioExteriorEmisor11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisor11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Curp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Domicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisorDomicilio11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expedidoEn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ExpedidoEn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ComercioExteriorEmisorDomicilio11R"));
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
