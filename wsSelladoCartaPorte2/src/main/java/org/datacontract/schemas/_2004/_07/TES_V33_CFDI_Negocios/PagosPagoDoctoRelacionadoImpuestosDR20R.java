/**
 * PagosPagoDoctoRelacionadoImpuestosDR20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoDoctoRelacionadoImpuestosDR20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R[] retencionesDR;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R[] trasladosDR;

    public PagosPagoDoctoRelacionadoImpuestosDR20R() {
    }

    public PagosPagoDoctoRelacionadoImpuestosDR20R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R[] retencionesDR,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R[] trasladosDR) {
           this.retencionesDR = retencionesDR;
           this.trasladosDR = trasladosDR;
    }


    /**
     * Gets the retencionesDR value for this PagosPagoDoctoRelacionadoImpuestosDR20R.
     * 
     * @return retencionesDR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R[] getRetencionesDR() {
        return retencionesDR;
    }


    /**
     * Sets the retencionesDR value for this PagosPagoDoctoRelacionadoImpuestosDR20R.
     * 
     * @param retencionesDR
     */
    public void setRetencionesDR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R[] retencionesDR) {
        this.retencionesDR = retencionesDR;
    }


    /**
     * Gets the trasladosDR value for this PagosPagoDoctoRelacionadoImpuestosDR20R.
     * 
     * @return trasladosDR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R[] getTrasladosDR() {
        return trasladosDR;
    }


    /**
     * Sets the trasladosDR value for this PagosPagoDoctoRelacionadoImpuestosDR20R.
     * 
     * @param trasladosDR
     */
    public void setTrasladosDR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R[] trasladosDR) {
        this.trasladosDR = trasladosDR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoDoctoRelacionadoImpuestosDR20R)) return false;
        PagosPagoDoctoRelacionadoImpuestosDR20R other = (PagosPagoDoctoRelacionadoImpuestosDR20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retencionesDR==null && other.getRetencionesDR()==null) || 
             (this.retencionesDR!=null &&
              java.util.Arrays.equals(this.retencionesDR, other.getRetencionesDR()))) &&
            ((this.trasladosDR==null && other.getTrasladosDR()==null) || 
             (this.trasladosDR!=null &&
              java.util.Arrays.equals(this.trasladosDR, other.getTrasladosDR())));
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
        if (getRetencionesDR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetencionesDR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetencionesDR(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTrasladosDR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrasladosDR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrasladosDR(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPagoDoctoRelacionadoImpuestosDR20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDR20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionesDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRRetencionDR20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladosDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoDoctoRelacionadoImpuestosDRTrasladoDR20R"));
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
