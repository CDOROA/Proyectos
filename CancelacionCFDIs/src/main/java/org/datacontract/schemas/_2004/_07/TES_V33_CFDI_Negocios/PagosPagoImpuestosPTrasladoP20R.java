/**
 * PagosPagoImpuestosPTrasladoP20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagosPagoImpuestosPTrasladoP20R  implements java.io.Serializable {
    private java.math.BigDecimal baseP;

    private java.math.BigDecimal importeP;

    private java.lang.String impuestoP;

    private java.math.BigDecimal tasaOCuotaP;

    private java.lang.String tipoFactorP;

    public PagosPagoImpuestosPTrasladoP20R() {
    }

    public PagosPagoImpuestosPTrasladoP20R(
           java.math.BigDecimal baseP,
           java.math.BigDecimal importeP,
           java.lang.String impuestoP,
           java.math.BigDecimal tasaOCuotaP,
           java.lang.String tipoFactorP) {
           this.baseP = baseP;
           this.importeP = importeP;
           this.impuestoP = impuestoP;
           this.tasaOCuotaP = tasaOCuotaP;
           this.tipoFactorP = tipoFactorP;
    }


    /**
     * Gets the baseP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @return baseP
     */
    public java.math.BigDecimal getBaseP() {
        return baseP;
    }


    /**
     * Sets the baseP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @param baseP
     */
    public void setBaseP(java.math.BigDecimal baseP) {
        this.baseP = baseP;
    }


    /**
     * Gets the importeP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @return importeP
     */
    public java.math.BigDecimal getImporteP() {
        return importeP;
    }


    /**
     * Sets the importeP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @param importeP
     */
    public void setImporteP(java.math.BigDecimal importeP) {
        this.importeP = importeP;
    }


    /**
     * Gets the impuestoP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @return impuestoP
     */
    public java.lang.String getImpuestoP() {
        return impuestoP;
    }


    /**
     * Sets the impuestoP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @param impuestoP
     */
    public void setImpuestoP(java.lang.String impuestoP) {
        this.impuestoP = impuestoP;
    }


    /**
     * Gets the tasaOCuotaP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @return tasaOCuotaP
     */
    public java.math.BigDecimal getTasaOCuotaP() {
        return tasaOCuotaP;
    }


    /**
     * Sets the tasaOCuotaP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @param tasaOCuotaP
     */
    public void setTasaOCuotaP(java.math.BigDecimal tasaOCuotaP) {
        this.tasaOCuotaP = tasaOCuotaP;
    }


    /**
     * Gets the tipoFactorP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @return tipoFactorP
     */
    public java.lang.String getTipoFactorP() {
        return tipoFactorP;
    }


    /**
     * Sets the tipoFactorP value for this PagosPagoImpuestosPTrasladoP20R.
     * 
     * @param tipoFactorP
     */
    public void setTipoFactorP(java.lang.String tipoFactorP) {
        this.tipoFactorP = tipoFactorP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagosPagoImpuestosPTrasladoP20R)) return false;
        PagosPagoImpuestosPTrasladoP20R other = (PagosPagoImpuestosPTrasladoP20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baseP==null && other.getBaseP()==null) || 
             (this.baseP!=null &&
              this.baseP.equals(other.getBaseP()))) &&
            ((this.importeP==null && other.getImporteP()==null) || 
             (this.importeP!=null &&
              this.importeP.equals(other.getImporteP()))) &&
            ((this.impuestoP==null && other.getImpuestoP()==null) || 
             (this.impuestoP!=null &&
              this.impuestoP.equals(other.getImpuestoP()))) &&
            ((this.tasaOCuotaP==null && other.getTasaOCuotaP()==null) || 
             (this.tasaOCuotaP!=null &&
              this.tasaOCuotaP.equals(other.getTasaOCuotaP()))) &&
            ((this.tipoFactorP==null && other.getTipoFactorP()==null) || 
             (this.tipoFactorP!=null &&
              this.tipoFactorP.equals(other.getTipoFactorP())));
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
        if (getBaseP() != null) {
            _hashCode += getBaseP().hashCode();
        }
        if (getImporteP() != null) {
            _hashCode += getImporteP().hashCode();
        }
        if (getImpuestoP() != null) {
            _hashCode += getImpuestoP().hashCode();
        }
        if (getTasaOCuotaP() != null) {
            _hashCode += getTasaOCuotaP().hashCode();
        }
        if (getTipoFactorP() != null) {
            _hashCode += getTipoFactorP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagosPagoImpuestosPTrasladoP20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagosPagoImpuestosPTrasladoP20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BaseP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImporteP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestoP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImpuestoP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaOCuotaP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TasaOCuotaP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFactorP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoFactorP"));
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
