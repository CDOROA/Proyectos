/**
 * VentaVehiculosR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class VentaVehiculosR  implements java.io.Serializable {
    private java.lang.String claveVehicular;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos[] informacionAduanera;

    private java.lang.String niv;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR[] partes;

    public VentaVehiculosR() {
    }

    public VentaVehiculosR(
           java.lang.String claveVehicular,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos[] informacionAduanera,
           java.lang.String niv,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR[] partes) {
           this.claveVehicular = claveVehicular;
           this.informacionAduanera = informacionAduanera;
           this.niv = niv;
           this.partes = partes;
    }


    /**
     * Gets the claveVehicular value for this VentaVehiculosR.
     * 
     * @return claveVehicular
     */
    public java.lang.String getClaveVehicular() {
        return claveVehicular;
    }


    /**
     * Sets the claveVehicular value for this VentaVehiculosR.
     * 
     * @param claveVehicular
     */
    public void setClaveVehicular(java.lang.String claveVehicular) {
        this.claveVehicular = claveVehicular;
    }


    /**
     * Gets the informacionAduanera value for this VentaVehiculosR.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos[] getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this VentaVehiculosR.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraVentaVehiculos[] informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the niv value for this VentaVehiculosR.
     * 
     * @return niv
     */
    public java.lang.String getNiv() {
        return niv;
    }


    /**
     * Sets the niv value for this VentaVehiculosR.
     * 
     * @param niv
     */
    public void setNiv(java.lang.String niv) {
        this.niv = niv;
    }


    /**
     * Gets the partes value for this VentaVehiculosR.
     * 
     * @return partes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR[] getPartes() {
        return partes;
    }


    /**
     * Sets the partes value for this VentaVehiculosR.
     * 
     * @param partes
     */
    public void setPartes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.VentaVehiculosParteR[] partes) {
        this.partes = partes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VentaVehiculosR)) return false;
        VentaVehiculosR other = (VentaVehiculosR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claveVehicular==null && other.getClaveVehicular()==null) || 
             (this.claveVehicular!=null &&
              this.claveVehicular.equals(other.getClaveVehicular()))) &&
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              java.util.Arrays.equals(this.informacionAduanera, other.getInformacionAduanera()))) &&
            ((this.niv==null && other.getNiv()==null) || 
             (this.niv!=null &&
              this.niv.equals(other.getNiv()))) &&
            ((this.partes==null && other.getPartes()==null) || 
             (this.partes!=null &&
              java.util.Arrays.equals(this.partes, other.getPartes())));
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
        if (getClaveVehicular() != null) {
            _hashCode += getClaveVehicular().hashCode();
        }
        if (getInformacionAduanera() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInformacionAduanera());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInformacionAduanera(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNiv() != null) {
            _hashCode += getNiv().hashCode();
        }
        if (getPartes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPartes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPartes(), i);
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
        new org.apache.axis.description.TypeDesc(VentaVehiculosR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraVentaVehiculos"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("niv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Niv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Partes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VentaVehiculosParteR"));
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
