/**
 * CertificadoDestruccionVehiculoDestruidoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CertificadoDestruccionVehiculoDestruidoR  implements java.io.Serializable {
    private java.lang.String año;

    private java.lang.String marca;

    private java.lang.String modelo;

    private java.lang.String NIV;

    private java.lang.String numFolTarjCir;

    private java.lang.String numMotor;

    private java.lang.String numPlacas;

    private java.lang.String numSerie;

    private java.lang.String tipooClase;

    public CertificadoDestruccionVehiculoDestruidoR() {
    }

    public CertificadoDestruccionVehiculoDestruidoR(
           java.lang.String año,
           java.lang.String marca,
           java.lang.String modelo,
           java.lang.String NIV,
           java.lang.String numFolTarjCir,
           java.lang.String numMotor,
           java.lang.String numPlacas,
           java.lang.String numSerie,
           java.lang.String tipooClase) {
           this.año = año;
           this.marca = marca;
           this.modelo = modelo;
           this.NIV = NIV;
           this.numFolTarjCir = numFolTarjCir;
           this.numMotor = numMotor;
           this.numPlacas = numPlacas;
           this.numSerie = numSerie;
           this.tipooClase = tipooClase;
    }


    /**
     * Gets the año value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return año
     */
    public java.lang.String getAño() {
        return año;
    }


    /**
     * Sets the año value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param año
     */
    public void setAño(java.lang.String año) {
        this.año = año;
    }


    /**
     * Gets the marca value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return marca
     */
    public java.lang.String getMarca() {
        return marca;
    }


    /**
     * Sets the marca value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param marca
     */
    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }


    /**
     * Gets the modelo value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return modelo
     */
    public java.lang.String getModelo() {
        return modelo;
    }


    /**
     * Sets the modelo value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param modelo
     */
    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }


    /**
     * Gets the NIV value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return NIV
     */
    public java.lang.String getNIV() {
        return NIV;
    }


    /**
     * Sets the NIV value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param NIV
     */
    public void setNIV(java.lang.String NIV) {
        this.NIV = NIV;
    }


    /**
     * Gets the numFolTarjCir value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return numFolTarjCir
     */
    public java.lang.String getNumFolTarjCir() {
        return numFolTarjCir;
    }


    /**
     * Sets the numFolTarjCir value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param numFolTarjCir
     */
    public void setNumFolTarjCir(java.lang.String numFolTarjCir) {
        this.numFolTarjCir = numFolTarjCir;
    }


    /**
     * Gets the numMotor value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return numMotor
     */
    public java.lang.String getNumMotor() {
        return numMotor;
    }


    /**
     * Sets the numMotor value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param numMotor
     */
    public void setNumMotor(java.lang.String numMotor) {
        this.numMotor = numMotor;
    }


    /**
     * Gets the numPlacas value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return numPlacas
     */
    public java.lang.String getNumPlacas() {
        return numPlacas;
    }


    /**
     * Sets the numPlacas value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param numPlacas
     */
    public void setNumPlacas(java.lang.String numPlacas) {
        this.numPlacas = numPlacas;
    }


    /**
     * Gets the numSerie value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return numSerie
     */
    public java.lang.String getNumSerie() {
        return numSerie;
    }


    /**
     * Sets the numSerie value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param numSerie
     */
    public void setNumSerie(java.lang.String numSerie) {
        this.numSerie = numSerie;
    }


    /**
     * Gets the tipooClase value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @return tipooClase
     */
    public java.lang.String getTipooClase() {
        return tipooClase;
    }


    /**
     * Sets the tipooClase value for this CertificadoDestruccionVehiculoDestruidoR.
     * 
     * @param tipooClase
     */
    public void setTipooClase(java.lang.String tipooClase) {
        this.tipooClase = tipooClase;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CertificadoDestruccionVehiculoDestruidoR)) return false;
        CertificadoDestruccionVehiculoDestruidoR other = (CertificadoDestruccionVehiculoDestruidoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.año==null && other.getAño()==null) || 
             (this.año!=null &&
              this.año.equals(other.getAño()))) &&
            ((this.marca==null && other.getMarca()==null) || 
             (this.marca!=null &&
              this.marca.equals(other.getMarca()))) &&
            ((this.modelo==null && other.getModelo()==null) || 
             (this.modelo!=null &&
              this.modelo.equals(other.getModelo()))) &&
            ((this.NIV==null && other.getNIV()==null) || 
             (this.NIV!=null &&
              this.NIV.equals(other.getNIV()))) &&
            ((this.numFolTarjCir==null && other.getNumFolTarjCir()==null) || 
             (this.numFolTarjCir!=null &&
              this.numFolTarjCir.equals(other.getNumFolTarjCir()))) &&
            ((this.numMotor==null && other.getNumMotor()==null) || 
             (this.numMotor!=null &&
              this.numMotor.equals(other.getNumMotor()))) &&
            ((this.numPlacas==null && other.getNumPlacas()==null) || 
             (this.numPlacas!=null &&
              this.numPlacas.equals(other.getNumPlacas()))) &&
            ((this.numSerie==null && other.getNumSerie()==null) || 
             (this.numSerie!=null &&
              this.numSerie.equals(other.getNumSerie()))) &&
            ((this.tipooClase==null && other.getTipooClase()==null) || 
             (this.tipooClase!=null &&
              this.tipooClase.equals(other.getTipooClase())));
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
        if (getAño() != null) {
            _hashCode += getAño().hashCode();
        }
        if (getMarca() != null) {
            _hashCode += getMarca().hashCode();
        }
        if (getModelo() != null) {
            _hashCode += getModelo().hashCode();
        }
        if (getNIV() != null) {
            _hashCode += getNIV().hashCode();
        }
        if (getNumFolTarjCir() != null) {
            _hashCode += getNumFolTarjCir().hashCode();
        }
        if (getNumMotor() != null) {
            _hashCode += getNumMotor().hashCode();
        }
        if (getNumPlacas() != null) {
            _hashCode += getNumPlacas().hashCode();
        }
        if (getNumSerie() != null) {
            _hashCode += getNumSerie().hashCode();
        }
        if (getTipooClase() != null) {
            _hashCode += getTipooClase().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CertificadoDestruccionVehiculoDestruidoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CertificadoDestruccionVehiculoDestruidoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("año");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Año"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marca");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Marca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Modelo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NIV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numFolTarjCir");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumFolTarjCir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numMotor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumMotor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPlacas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumPlacas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numSerie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumSerie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipooClase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipooClase"));
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
