/**
 * PagosPagoImpuestosTrasladoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class PagosPagoImpuestosTrasladoR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP[] trasladoP;

    public PagosPagoImpuestosTrasladoR() {
    }

    public PagosPagoImpuestosTrasladoR(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP[] trasladoP) {
           this.trasladoP = trasladoP;
    }


    /**
     * Gets the trasladoP value for this PagosPagoImpuestosTrasladoR.
     * 
     * @return trasladoP
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP[] getTrasladoP() {
        return trasladoP;
    }


    /**
     * Sets the trasladoP value for this PagosPagoImpuestosTrasladoR.
     * 
     * @param trasladoP
     */
    public void setTrasladoP(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos.PagoImpuestosTrasladoP[] trasladoP) {
        this.trasladoP = trasladoP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoImpuestosTrasladoR)) return false;
        PagosPagoImpuestosTrasladoR other = (PagosPagoImpuestosTrasladoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.trasladoP==null && other.getTrasladoP()==null) || 
             (this.trasladoP!=null &&
              java.util.Arrays.equals(this.trasladoP, other.getTrasladoP())));
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
        if (getTrasladoP() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrasladoP());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrasladoP(), i);
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
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosTrasladoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagosPagoImpuestosTrasladoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladoP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TrasladoP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosTrasladoP"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "PagoImpuestosTrasladoP"));
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
