/**
 * GastosHidrocarburosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class GastosHidrocarburosR  implements java.io.Serializable {
    private java.lang.String areaContractual;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR[] erogacion;

    private java.lang.String numeroContrato;

    public GastosHidrocarburosR() {
    }

    public GastosHidrocarburosR(
           java.lang.String areaContractual,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR[] erogacion,
           java.lang.String numeroContrato) {
           this.areaContractual = areaContractual;
           this.erogacion = erogacion;
           this.numeroContrato = numeroContrato;
    }


    /**
     * Gets the areaContractual value for this GastosHidrocarburosR.
     * 
     * @return areaContractual
     */
    public java.lang.String getAreaContractual() {
        return areaContractual;
    }


    /**
     * Sets the areaContractual value for this GastosHidrocarburosR.
     * 
     * @param areaContractual
     */
    public void setAreaContractual(java.lang.String areaContractual) {
        this.areaContractual = areaContractual;
    }


    /**
     * Gets the erogacion value for this GastosHidrocarburosR.
     * 
     * @return erogacion
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR[] getErogacion() {
        return erogacion;
    }


    /**
     * Sets the erogacion value for this GastosHidrocarburosR.
     * 
     * @param erogacion
     */
    public void setErogacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ErogacionR[] erogacion) {
        this.erogacion = erogacion;
    }


    /**
     * Gets the numeroContrato value for this GastosHidrocarburosR.
     * 
     * @return numeroContrato
     */
    public java.lang.String getNumeroContrato() {
        return numeroContrato;
    }


    /**
     * Sets the numeroContrato value for this GastosHidrocarburosR.
     * 
     * @param numeroContrato
     */
    public void setNumeroContrato(java.lang.String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GastosHidrocarburosR)) return false;
        GastosHidrocarburosR other = (GastosHidrocarburosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.areaContractual==null && other.getAreaContractual()==null) || 
             (this.areaContractual!=null &&
              this.areaContractual.equals(other.getAreaContractual()))) &&
            ((this.erogacion==null && other.getErogacion()==null) || 
             (this.erogacion!=null &&
              java.util.Arrays.equals(this.erogacion, other.getErogacion()))) &&
            ((this.numeroContrato==null && other.getNumeroContrato()==null) || 
             (this.numeroContrato!=null &&
              this.numeroContrato.equals(other.getNumeroContrato())));
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
        if (getAreaContractual() != null) {
            _hashCode += getAreaContractual().hashCode();
        }
        if (getErogacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErogacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErogacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumeroContrato() != null) {
            _hashCode += getNumeroContrato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GastosHidrocarburosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "GastosHidrocarburosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("areaContractual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AreaContractual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("erogacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Erogacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ErogacionR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroContrato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroContrato"));
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
