/**
 * CancelarCFDIConValidacionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion;

public class CancelarCFDIConValidacionResponse  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR[] acuses;

    private org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR[] UUIDS;

    public CancelarCFDIConValidacionResponse() {
    }

    public CancelarCFDIConValidacionResponse(
           org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR[] acuses,
           org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR[] UUIDS) {
           this.acuses = acuses;
           this.UUIDS = UUIDS;
    }


    /**
     * Gets the acuses value for this CancelarCFDIConValidacionResponse.
     * 
     * @return acuses
     */
    public org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR[] getAcuses() {
        return acuses;
    }


    /**
     * Sets the acuses value for this CancelarCFDIConValidacionResponse.
     * 
     * @param acuses
     */
    public void setAcuses(org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR[] acuses) {
        this.acuses = acuses;
    }


    /**
     * Gets the UUIDS value for this CancelarCFDIConValidacionResponse.
     * 
     * @return UUIDS
     */
    public org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR[] getUUIDS() {
        return UUIDS;
    }


    /**
     * Sets the UUIDS value for this CancelarCFDIConValidacionResponse.
     * 
     * @param UUIDS
     */
    public void setUUIDS(org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR[] UUIDS) {
        this.UUIDS = UUIDS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelarCFDIConValidacionResponse)) return false;
        CancelarCFDIConValidacionResponse other = (CancelarCFDIConValidacionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acuses==null && other.getAcuses()==null) || 
             (this.acuses!=null &&
              java.util.Arrays.equals(this.acuses, other.getAcuses()))) &&
            ((this.UUIDS==null && other.getUUIDS()==null) || 
             (this.UUIDS!=null &&
              java.util.Arrays.equals(this.UUIDS, other.getUUIDS())));
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
        if (getAcuses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAcuses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAcuses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUUIDS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUUIDS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUUIDS(), i);
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
        new org.apache.axis.description.TypeDesc(CancelarCFDIConValidacionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "CancelarCFDIConValidacionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acuses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "Acuses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ResponseCancelacionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "ResponseCancelacionR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUIDS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "UUIDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/CancelarCFDIsConValidacion", "DetalleCancelacionCR"));
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
