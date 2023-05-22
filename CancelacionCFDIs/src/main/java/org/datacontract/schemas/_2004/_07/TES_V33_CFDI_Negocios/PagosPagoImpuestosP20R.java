/**
 * PagosPagoImpuestosP20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoImpuestosP20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R[] retencionesP;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R[] trasladosP;

    public PagosPagoImpuestosP20R() {
    }

    public PagosPagoImpuestosP20R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R[] retencionesP,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R[] trasladosP) {
           this.retencionesP = retencionesP;
           this.trasladosP = trasladosP;
    }


    /**
     * Gets the retencionesP value for this PagosPagoImpuestosP20R.
     * 
     * @return retencionesP
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R[] getRetencionesP() {
        return retencionesP;
    }


    /**
     * Sets the retencionesP value for this PagosPagoImpuestosP20R.
     * 
     * @param retencionesP
     */
    public void setRetencionesP(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPRetencionP20R[] retencionesP) {
        this.retencionesP = retencionesP;
    }


    /**
     * Gets the trasladosP value for this PagosPagoImpuestosP20R.
     * 
     * @return trasladosP
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R[] getTrasladosP() {
        return trasladosP;
    }


    /**
     * Sets the trasladosP value for this PagosPagoImpuestosP20R.
     * 
     * @param trasladosP
     */
    public void setTrasladosP(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PagosPagoImpuestosPTrasladoP20R[] trasladosP) {
        this.trasladosP = trasladosP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoImpuestosP20R)) return false;
        PagosPagoImpuestosP20R other = (PagosPagoImpuestosP20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retencionesP==null && other.getRetencionesP()==null) || 
             (this.retencionesP!=null &&
              java.util.Arrays.equals(this.retencionesP, other.getRetencionesP()))) &&
            ((this.trasladosP==null && other.getTrasladosP()==null) || 
             (this.trasladosP!=null &&
              java.util.Arrays.equals(this.trasladosP, other.getTrasladosP())));
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
        if (getRetencionesP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetencionesP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetencionesP(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTrasladosP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrasladosP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrasladosP(), i);
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
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosP20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosP20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retencionesP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RetencionesP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPRetencionP20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPRetencionP20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladosP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TrasladosP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R"));
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
