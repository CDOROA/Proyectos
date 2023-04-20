/**
 * DatosEnajenanteR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class DatosEnajenanteR  implements java.io.Serializable {
    private java.lang.String coproSocConyugalE;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnEnajenanteR datosUnEnajenante;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR[] listaEnajenantes;

    public DatosEnajenanteR() {
    }

    public DatosEnajenanteR(
           java.lang.String coproSocConyugalE,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnEnajenanteR datosUnEnajenante,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR[] listaEnajenantes) {
           this.coproSocConyugalE = coproSocConyugalE;
           this.datosUnEnajenante = datosUnEnajenante;
           this.listaEnajenantes = listaEnajenantes;
    }


    /**
     * Gets the coproSocConyugalE value for this DatosEnajenanteR.
     * 
     * @return coproSocConyugalE
     */
    public java.lang.String getCoproSocConyugalE() {
        return coproSocConyugalE;
    }


    /**
     * Sets the coproSocConyugalE value for this DatosEnajenanteR.
     * 
     * @param coproSocConyugalE
     */
    public void setCoproSocConyugalE(java.lang.String coproSocConyugalE) {
        this.coproSocConyugalE = coproSocConyugalE;
    }


    /**
     * Gets the datosUnEnajenante value for this DatosEnajenanteR.
     * 
     * @return datosUnEnajenante
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnEnajenanteR getDatosUnEnajenante() {
        return datosUnEnajenante;
    }


    /**
     * Sets the datosUnEnajenante value for this DatosEnajenanteR.
     * 
     * @param datosUnEnajenante
     */
    public void setDatosUnEnajenante(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosUnEnajenanteR datosUnEnajenante) {
        this.datosUnEnajenante = datosUnEnajenante;
    }


    /**
     * Gets the listaEnajenantes value for this DatosEnajenanteR.
     * 
     * @return listaEnajenantes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR[] getListaEnajenantes() {
        return listaEnajenantes;
    }


    /**
     * Sets the listaEnajenantes value for this DatosEnajenanteR.
     * 
     * @param listaEnajenantes
     */
    public void setListaEnajenantes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DatosEnajenanteCopSCR[] listaEnajenantes) {
        this.listaEnajenantes = listaEnajenantes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosEnajenanteR)) return false;
        DatosEnajenanteR other = (DatosEnajenanteR) obj;
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
            ((this.datosUnEnajenante==null && other.getDatosUnEnajenante()==null) || 
             (this.datosUnEnajenante!=null &&
              this.datosUnEnajenante.equals(other.getDatosUnEnajenante()))) &&
            ((this.listaEnajenantes==null && other.getListaEnajenantes()==null) || 
             (this.listaEnajenantes!=null &&
              java.util.Arrays.equals(this.listaEnajenantes, other.getListaEnajenantes())));
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
        if (getDatosUnEnajenante() != null) {
            _hashCode += getDatosUnEnajenante().hashCode();
        }
        if (getListaEnajenantes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaEnajenantes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaEnajenantes(), i);
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
        new org.apache.axis.description.TypeDesc(DatosEnajenanteR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coproSocConyugalE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CoproSocConyugalE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datosUnEnajenante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnEnajenante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosUnEnajenanteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaEnajenantes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ListaEnajenantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteCopSCR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DatosEnajenanteCopSCR"));
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
