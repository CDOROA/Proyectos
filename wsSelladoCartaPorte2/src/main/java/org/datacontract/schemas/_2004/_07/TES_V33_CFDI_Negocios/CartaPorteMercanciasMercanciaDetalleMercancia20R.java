/**
 * CartaPorteMercanciasMercanciaDetalleMercancia20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasMercanciaDetalleMercancia20R  implements java.io.Serializable {
    private java.lang.Integer numPiezas;

    private java.math.BigDecimal pesoBruto;

    private java.math.BigDecimal pesoNeto;

    private java.math.BigDecimal pesoTara;

    private java.lang.String unidadPesoMerc;

    public CartaPorteMercanciasMercanciaDetalleMercancia20R() {
    }

    public CartaPorteMercanciasMercanciaDetalleMercancia20R(
           java.lang.Integer numPiezas,
           java.math.BigDecimal pesoBruto,
           java.math.BigDecimal pesoNeto,
           java.math.BigDecimal pesoTara,
           java.lang.String unidadPesoMerc) {
           this.numPiezas = numPiezas;
           this.pesoBruto = pesoBruto;
           this.pesoNeto = pesoNeto;
           this.pesoTara = pesoTara;
           this.unidadPesoMerc = unidadPesoMerc;
    }


    /**
     * Gets the numPiezas value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @return numPiezas
     */
    public java.lang.Integer getNumPiezas() {
        return numPiezas;
    }


    /**
     * Sets the numPiezas value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @param numPiezas
     */
    public void setNumPiezas(java.lang.Integer numPiezas) {
        this.numPiezas = numPiezas;
    }


    /**
     * Gets the pesoBruto value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @return pesoBruto
     */
    public java.math.BigDecimal getPesoBruto() {
        return pesoBruto;
    }


    /**
     * Sets the pesoBruto value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @param pesoBruto
     */
    public void setPesoBruto(java.math.BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }


    /**
     * Gets the pesoNeto value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @return pesoNeto
     */
    public java.math.BigDecimal getPesoNeto() {
        return pesoNeto;
    }


    /**
     * Sets the pesoNeto value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @param pesoNeto
     */
    public void setPesoNeto(java.math.BigDecimal pesoNeto) {
        this.pesoNeto = pesoNeto;
    }


    /**
     * Gets the pesoTara value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @return pesoTara
     */
    public java.math.BigDecimal getPesoTara() {
        return pesoTara;
    }


    /**
     * Sets the pesoTara value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @param pesoTara
     */
    public void setPesoTara(java.math.BigDecimal pesoTara) {
        this.pesoTara = pesoTara;
    }


    /**
     * Gets the unidadPesoMerc value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @return unidadPesoMerc
     */
    public java.lang.String getUnidadPesoMerc() {
        return unidadPesoMerc;
    }


    /**
     * Sets the unidadPesoMerc value for this CartaPorteMercanciasMercanciaDetalleMercancia20R.
     * 
     * @param unidadPesoMerc
     */
    public void setUnidadPesoMerc(java.lang.String unidadPesoMerc) {
        this.unidadPesoMerc = unidadPesoMerc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasMercanciaDetalleMercancia20R)) return false;
        CartaPorteMercanciasMercanciaDetalleMercancia20R other = (CartaPorteMercanciasMercanciaDetalleMercancia20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numPiezas==null && other.getNumPiezas()==null) || 
             (this.numPiezas!=null &&
              this.numPiezas.equals(other.getNumPiezas()))) &&
            ((this.pesoBruto==null && other.getPesoBruto()==null) || 
             (this.pesoBruto!=null &&
              this.pesoBruto.equals(other.getPesoBruto()))) &&
            ((this.pesoNeto==null && other.getPesoNeto()==null) || 
             (this.pesoNeto!=null &&
              this.pesoNeto.equals(other.getPesoNeto()))) &&
            ((this.pesoTara==null && other.getPesoTara()==null) || 
             (this.pesoTara!=null &&
              this.pesoTara.equals(other.getPesoTara()))) &&
            ((this.unidadPesoMerc==null && other.getUnidadPesoMerc()==null) || 
             (this.unidadPesoMerc!=null &&
              this.unidadPesoMerc.equals(other.getUnidadPesoMerc())));
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
        if (getNumPiezas() != null) {
            _hashCode += getNumPiezas().hashCode();
        }
        if (getPesoBruto() != null) {
            _hashCode += getPesoBruto().hashCode();
        }
        if (getPesoNeto() != null) {
            _hashCode += getPesoNeto().hashCode();
        }
        if (getPesoTara() != null) {
            _hashCode += getPesoTara().hashCode();
        }
        if (getUnidadPesoMerc() != null) {
            _hashCode += getUnidadPesoMerc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasMercanciaDetalleMercancia20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaDetalleMercancia20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPiezas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumPiezas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoNeto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoNeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoTara");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoTara"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadPesoMerc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UnidadPesoMerc"));
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
