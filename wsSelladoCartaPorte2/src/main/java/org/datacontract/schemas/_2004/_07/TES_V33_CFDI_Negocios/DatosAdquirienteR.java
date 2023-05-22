/**
 * DatosAdquirienteR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatosAdquirienteR  implements java.io.Serializable {
    private java.lang.String coproSocConyugalE;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR[] datosAdquirienteCopSC;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnAdquirienteR datosUnAdquiriente;

    public DatosAdquirienteR() {
    }

    public DatosAdquirienteR(
           java.lang.String coproSocConyugalE,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR[] datosAdquirienteCopSC,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnAdquirienteR datosUnAdquiriente) {
           this.coproSocConyugalE = coproSocConyugalE;
           this.datosAdquirienteCopSC = datosAdquirienteCopSC;
           this.datosUnAdquiriente = datosUnAdquiriente;
    }


    /**
     * Gets the coproSocConyugalE value for this DatosAdquirienteR.
     * 
     * @return coproSocConyugalE
     */
    public java.lang.String getCoproSocConyugalE() {
        return coproSocConyugalE;
    }


    /**
     * Sets the coproSocConyugalE value for this DatosAdquirienteR.
     * 
     * @param coproSocConyugalE
     */
    public void setCoproSocConyugalE(java.lang.String coproSocConyugalE) {
        this.coproSocConyugalE = coproSocConyugalE;
    }


    /**
     * Gets the datosAdquirienteCopSC value for this DatosAdquirienteR.
     * 
     * @return datosAdquirienteCopSC
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR[] getDatosAdquirienteCopSC() {
        return datosAdquirienteCopSC;
    }


    /**
     * Sets the datosAdquirienteCopSC value for this DatosAdquirienteR.
     * 
     * @param datosAdquirienteCopSC
     */
    public void setDatosAdquirienteCopSC(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosAdquirienteCopSCR[] datosAdquirienteCopSC) {
        this.datosAdquirienteCopSC = datosAdquirienteCopSC;
    }


    /**
     * Gets the datosUnAdquiriente value for this DatosAdquirienteR.
     * 
     * @return datosUnAdquiriente
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnAdquirienteR getDatosUnAdquiriente() {
        return datosUnAdquiriente;
    }


    /**
     * Sets the datosUnAdquiriente value for this DatosAdquirienteR.
     * 
     * @param datosUnAdquiriente
     */
    public void setDatosUnAdquiriente(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnAdquirienteR datosUnAdquiriente) {
        this.datosUnAdquiriente = datosUnAdquiriente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosAdquirienteR)) return false;
        DatosAdquirienteR other = (DatosAdquirienteR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.coproSocConyugalE==null && other.getCoproSocConyugalE()==null) || 
             (this.coproSocConyugalE!=null &&
              this.coproSocConyugalE.equals(other.getCoproSocConyugalE()))) &&
            ((this.datosAdquirienteCopSC==null && other.getDatosAdquirienteCopSC()==null) || 
             (this.datosAdquirienteCopSC!=null &&
              java.util.Arrays.equals(this.datosAdquirienteCopSC, other.getDatosAdquirienteCopSC()))) &&
            ((this.datosUnAdquiriente==null && other.getDatosUnAdquiriente()==null) || 
             (this.datosUnAdquiriente!=null &&
              this.datosUnAdquiriente.equals(other.getDatosUnAdquiriente())));
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
        if (getCoproSocConyugalE() != null) {
            _hashCode += getCoproSocConyugalE().hashCode();
        }
        if (getDatosAdquirienteCopSC() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDatosAdquirienteCopSC());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDatosAdquirienteCopSC(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDatosUnAdquiriente() != null) {
            _hashCode += getDatosUnAdquiriente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosAdquirienteR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coproSocConyugalE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CoproSocConyugalE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosAdquirienteCopSC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosAdquirienteCopSCR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosUnAdquiriente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnAdquiriente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnAdquirienteR"));
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
