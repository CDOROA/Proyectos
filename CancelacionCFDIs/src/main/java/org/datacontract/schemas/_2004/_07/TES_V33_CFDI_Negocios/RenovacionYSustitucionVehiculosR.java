/**
 * RenovacionYSustitucionVehiculosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RenovacionYSustitucionVehiculosR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularR decretoRenovVehicular;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularR decretoSustitVehicular;

    private java.lang.String tipoDeDecreto;

    private java.lang.String version;

    public RenovacionYSustitucionVehiculosR() {
    }

    public RenovacionYSustitucionVehiculosR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularR decretoRenovVehicular,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularR decretoSustitVehicular,
           java.lang.String tipoDeDecreto,
           java.lang.String version) {
           this.decretoRenovVehicular = decretoRenovVehicular;
           this.decretoSustitVehicular = decretoSustitVehicular;
           this.tipoDeDecreto = tipoDeDecreto;
           this.version = version;
    }


    /**
     * Gets the decretoRenovVehicular value for this RenovacionYSustitucionVehiculosR.
     * 
     * @return decretoRenovVehicular
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularR getDecretoRenovVehicular() {
        return decretoRenovVehicular;
    }


    /**
     * Sets the decretoRenovVehicular value for this RenovacionYSustitucionVehiculosR.
     * 
     * @param decretoRenovVehicular
     */
    public void setDecretoRenovVehicular(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularR decretoRenovVehicular) {
        this.decretoRenovVehicular = decretoRenovVehicular;
    }


    /**
     * Gets the decretoSustitVehicular value for this RenovacionYSustitucionVehiculosR.
     * 
     * @return decretoSustitVehicular
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularR getDecretoSustitVehicular() {
        return decretoSustitVehicular;
    }


    /**
     * Sets the decretoSustitVehicular value for this RenovacionYSustitucionVehiculosR.
     * 
     * @param decretoSustitVehicular
     */
    public void setDecretoSustitVehicular(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularR decretoSustitVehicular) {
        this.decretoSustitVehicular = decretoSustitVehicular;
    }


    /**
     * Gets the tipoDeDecreto value for this RenovacionYSustitucionVehiculosR.
     * 
     * @return tipoDeDecreto
     */
    public java.lang.String getTipoDeDecreto() {
        return tipoDeDecreto;
    }


    /**
     * Sets the tipoDeDecreto value for this RenovacionYSustitucionVehiculosR.
     * 
     * @param tipoDeDecreto
     */
    public void setTipoDeDecreto(java.lang.String tipoDeDecreto) {
        this.tipoDeDecreto = tipoDeDecreto;
    }


    /**
     * Gets the version value for this RenovacionYSustitucionVehiculosR.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this RenovacionYSustitucionVehiculosR.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenovacionYSustitucionVehiculosR)) return false;
        RenovacionYSustitucionVehiculosR other = (RenovacionYSustitucionVehiculosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.decretoRenovVehicular==null && other.getDecretoRenovVehicular()==null) || 
             (this.decretoRenovVehicular!=null &&
              this.decretoRenovVehicular.equals(other.getDecretoRenovVehicular()))) &&
            ((this.decretoSustitVehicular==null && other.getDecretoSustitVehicular()==null) || 
             (this.decretoSustitVehicular!=null &&
              this.decretoSustitVehicular.equals(other.getDecretoSustitVehicular()))) &&
            ((this.tipoDeDecreto==null && other.getTipoDeDecreto()==null) || 
             (this.tipoDeDecreto!=null &&
              this.tipoDeDecreto.equals(other.getTipoDeDecreto()))) &&
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
        if (getDecretoRenovVehicular() != null) {
            _hashCode += getDecretoRenovVehicular().hashCode();
        }
        if (getDecretoSustitVehicular() != null) {
            _hashCode += getDecretoSustitVehicular().hashCode();
        }
        if (getTipoDeDecreto() != null) {
            _hashCode += getTipoDeDecreto().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RenovacionYSustitucionVehiculosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RenovacionYSustitucionVehiculosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decretoRenovVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DecretoRenovVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decretoSustitVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DecretoSustitVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDeDecreto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoDeDecreto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
