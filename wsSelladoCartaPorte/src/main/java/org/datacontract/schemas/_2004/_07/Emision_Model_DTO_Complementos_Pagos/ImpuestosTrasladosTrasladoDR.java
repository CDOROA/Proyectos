/**
 * ImpuestosTrasladosTrasladoDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_Pagos;

public class ImpuestosTrasladosTrasladoDR  implements java.io.Serializable {
    private java.math.BigDecimal baseDR;

    private java.math.BigDecimal importeDR;

    private java.lang.String impuestoDR;

    private java.math.BigDecimal tasaOCuotaDR;

    private java.lang.String tipoFactorDR;

    public ImpuestosTrasladosTrasladoDR() {
    }

    public ImpuestosTrasladosTrasladoDR(
           java.math.BigDecimal baseDR,
           java.math.BigDecimal importeDR,
           java.lang.String impuestoDR,
           java.math.BigDecimal tasaOCuotaDR,
           java.lang.String tipoFactorDR) {
           this.baseDR = baseDR;
           this.importeDR = importeDR;
           this.impuestoDR = impuestoDR;
           this.tasaOCuotaDR = tasaOCuotaDR;
           this.tipoFactorDR = tipoFactorDR;
    }


    /**
     * Gets the baseDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @return baseDR
     */
    public java.math.BigDecimal getBaseDR() {
        return baseDR;
    }


    /**
     * Sets the baseDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @param baseDR
     */
    public void setBaseDR(java.math.BigDecimal baseDR) {
        this.baseDR = baseDR;
    }


    /**
     * Gets the importeDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @return importeDR
     */
    public java.math.BigDecimal getImporteDR() {
        return importeDR;
    }


    /**
     * Sets the importeDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @param importeDR
     */
    public void setImporteDR(java.math.BigDecimal importeDR) {
        this.importeDR = importeDR;
    }


    /**
     * Gets the impuestoDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @return impuestoDR
     */
    public java.lang.String getImpuestoDR() {
        return impuestoDR;
    }


    /**
     * Sets the impuestoDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @param impuestoDR
     */
    public void setImpuestoDR(java.lang.String impuestoDR) {
        this.impuestoDR = impuestoDR;
    }


    /**
     * Gets the tasaOCuotaDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @return tasaOCuotaDR
     */
    public java.math.BigDecimal getTasaOCuotaDR() {
        return tasaOCuotaDR;
    }


    /**
     * Sets the tasaOCuotaDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @param tasaOCuotaDR
     */
    public void setTasaOCuotaDR(java.math.BigDecimal tasaOCuotaDR) {
        this.tasaOCuotaDR = tasaOCuotaDR;
    }


    /**
     * Gets the tipoFactorDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @return tipoFactorDR
     */
    public java.lang.String getTipoFactorDR() {
        return tipoFactorDR;
    }


    /**
     * Sets the tipoFactorDR value for this ImpuestosTrasladosTrasladoDR.
     * 
     * @param tipoFactorDR
     */
    public void setTipoFactorDR(java.lang.String tipoFactorDR) {
        this.tipoFactorDR = tipoFactorDR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ImpuestosTrasladosTrasladoDR)) return false;
        ImpuestosTrasladosTrasladoDR other = (ImpuestosTrasladosTrasladoDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baseDR==null && other.getBaseDR()==null) || 
             (this.baseDR!=null &&
              this.baseDR.equals(other.getBaseDR()))) &&
            ((this.importeDR==null && other.getImporteDR()==null) || 
             (this.importeDR!=null &&
              this.importeDR.equals(other.getImporteDR()))) &&
            ((this.impuestoDR==null && other.getImpuestoDR()==null) || 
             (this.impuestoDR!=null &&
              this.impuestoDR.equals(other.getImpuestoDR()))) &&
            ((this.tasaOCuotaDR==null && other.getTasaOCuotaDR()==null) || 
             (this.tasaOCuotaDR!=null &&
              this.tasaOCuotaDR.equals(other.getTasaOCuotaDR()))) &&
            ((this.tipoFactorDR==null && other.getTipoFactorDR()==null) || 
             (this.tipoFactorDR!=null &&
              this.tipoFactorDR.equals(other.getTipoFactorDR())));
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
        if (getBaseDR() != null) {
            _hashCode += getBaseDR().hashCode();
        }
        if (getImporteDR() != null) {
            _hashCode += getImporteDR().hashCode();
        }
        if (getImpuestoDR() != null) {
            _hashCode += getImpuestoDR().hashCode();
        }
        if (getTasaOCuotaDR() != null) {
            _hashCode += getTasaOCuotaDR().hashCode();
        }
        if (getTipoFactorDR() != null) {
            _hashCode += getTipoFactorDR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ImpuestosTrasladosTrasladoDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestosTrasladosTrasladoDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "BaseDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImporteDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impuestoDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "ImpuestoDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaOCuotaDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TasaOCuotaDR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFactorDR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.Pagos", "TipoFactorDR"));
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
