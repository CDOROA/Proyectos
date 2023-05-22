/**
 * PorCuentadeTerceros11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PorCuentadeTerceros11R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialTercerosR cuentaPredial;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosTercerosR impuestos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR informacionAduanera;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionFiscalTerceroR informacionFiscalTercero;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR[] partes;

    private java.lang.String nombre;

    private java.lang.String rfc;

    public PorCuentadeTerceros11R() {
    }

    public PorCuentadeTerceros11R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialTercerosR cuentaPredial,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosTercerosR impuestos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR informacionAduanera,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionFiscalTerceroR informacionFiscalTercero,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR[] partes,
           java.lang.String nombre,
           java.lang.String rfc) {
           this.cuentaPredial = cuentaPredial;
           this.impuestos = impuestos;
           this.informacionAduanera = informacionAduanera;
           this.informacionFiscalTercero = informacionFiscalTercero;
           this.partes = partes;
           this.nombre = nombre;
           this.rfc = rfc;
    }


    /**
     * Gets the cuentaPredial value for this PorCuentadeTerceros11R.
     * 
     * @return cuentaPredial
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialTercerosR getCuentaPredial() {
        return cuentaPredial;
    }


    /**
     * Sets the cuentaPredial value for this PorCuentadeTerceros11R.
     * 
     * @param cuentaPredial
     */
    public void setCuentaPredial(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CuentaPredialTercerosR cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }


    /**
     * Gets the impuestos value for this PorCuentadeTerceros11R.
     * 
     * @return impuestos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosTercerosR getImpuestos() {
        return impuestos;
    }


    /**
     * Sets the impuestos value for this PorCuentadeTerceros11R.
     * 
     * @param impuestos
     */
    public void setImpuestos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosTercerosR impuestos) {
        this.impuestos = impuestos;
    }


    /**
     * Gets the informacionAduanera value for this PorCuentadeTerceros11R.
     * 
     * @return informacionAduanera
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR getInformacionAduanera() {
        return informacionAduanera;
    }


    /**
     * Sets the informacionAduanera value for this PorCuentadeTerceros11R.
     * 
     * @param informacionAduanera
     */
    public void setInformacionAduanera(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionAduaneraTercerosR informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


    /**
     * Gets the informacionFiscalTercero value for this PorCuentadeTerceros11R.
     * 
     * @return informacionFiscalTercero
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionFiscalTerceroR getInformacionFiscalTercero() {
        return informacionFiscalTercero;
    }


    /**
     * Sets the informacionFiscalTercero value for this PorCuentadeTerceros11R.
     * 
     * @param informacionFiscalTercero
     */
    public void setInformacionFiscalTercero(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.InformacionFiscalTerceroR informacionFiscalTercero) {
        this.informacionFiscalTercero = informacionFiscalTercero;
    }


    /**
     * Gets the partes value for this PorCuentadeTerceros11R.
     * 
     * @return partes
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR[] getPartes() {
        return partes;
    }


    /**
     * Sets the partes value for this PorCuentadeTerceros11R.
     * 
     * @param partes
     */
    public void setPartes(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PorCuentadeTercerosParteR[] partes) {
        this.partes = partes;
    }


    /**
     * Gets the nombre value for this PorCuentadeTerceros11R.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this PorCuentadeTerceros11R.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the rfc value for this PorCuentadeTerceros11R.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this PorCuentadeTerceros11R.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PorCuentadeTerceros11R)) return false;
        PorCuentadeTerceros11R other = (PorCuentadeTerceros11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cuentaPredial==null && other.getCuentaPredial()==null) || 
             (this.cuentaPredial!=null &&
              this.cuentaPredial.equals(other.getCuentaPredial()))) &&
            ((this.impuestos==null && other.getImpuestos()==null) || 
             (this.impuestos!=null &&
              this.impuestos.equals(other.getImpuestos()))) &&
            ((this.informacionAduanera==null && other.getInformacionAduanera()==null) || 
             (this.informacionAduanera!=null &&
              this.informacionAduanera.equals(other.getInformacionAduanera()))) &&
            ((this.informacionFiscalTercero==null && other.getInformacionFiscalTercero()==null) || 
             (this.informacionFiscalTercero!=null &&
              this.informacionFiscalTercero.equals(other.getInformacionFiscalTercero()))) &&
            ((this.partes==null && other.getPartes()==null) || 
             (this.partes!=null &&
              java.util.Arrays.equals(this.partes, other.getPartes()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc())));
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
        if (getCuentaPredial() != null) {
            _hashCode += getCuentaPredial().hashCode();
        }
        if (getImpuestos() != null) {
            _hashCode += getImpuestos().hashCode();
        }
        if (getInformacionAduanera() != null) {
            _hashCode += getInformacionAduanera().hashCode();
        }
        if (getInformacionFiscalTercero() != null) {
            _hashCode += getInformacionFiscalTercero().hashCode();
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PorCuentadeTerceros11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTerceros11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaPredial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CuentaPredialTercerosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Impuestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestosTercerosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionAduanera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduanera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionAduaneraTercerosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionFiscalTercero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionFiscalTercero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InformacionFiscalTerceroR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Partes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTercerosParteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PorCuentadeTercerosParteR"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "rfc"));
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
