/**
 * IdentificacionDelGastoR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class IdentificacionDelGastoR  implements java.io.Serializable {
    private java.lang.String acuerdoGasto;

    private java.lang.String descripcionGasto;

    private java.lang.String fechaDeGasto;

    private java.math.BigDecimal importeGasto;

    private java.lang.String numFolioDoc;

    private java.lang.String UUID;

    public IdentificacionDelGastoR() {
    }

    public IdentificacionDelGastoR(
           java.lang.String acuerdoGasto,
           java.lang.String descripcionGasto,
           java.lang.String fechaDeGasto,
           java.math.BigDecimal importeGasto,
           java.lang.String numFolioDoc,
           java.lang.String UUID) {
           this.acuerdoGasto = acuerdoGasto;
           this.descripcionGasto = descripcionGasto;
           this.fechaDeGasto = fechaDeGasto;
           this.importeGasto = importeGasto;
           this.numFolioDoc = numFolioDoc;
           this.UUID = UUID;
    }


    /**
     * Gets the acuerdoGasto value for this IdentificacionDelGastoR.
     * 
     * @return acuerdoGasto
     */
    public java.lang.String getAcuerdoGasto() {
        return acuerdoGasto;
    }


    /**
     * Sets the acuerdoGasto value for this IdentificacionDelGastoR.
     * 
     * @param acuerdoGasto
     */
    public void setAcuerdoGasto(java.lang.String acuerdoGasto) {
        this.acuerdoGasto = acuerdoGasto;
    }


    /**
     * Gets the descripcionGasto value for this IdentificacionDelGastoR.
     * 
     * @return descripcionGasto
     */
    public java.lang.String getDescripcionGasto() {
        return descripcionGasto;
    }


    /**
     * Sets the descripcionGasto value for this IdentificacionDelGastoR.
     * 
     * @param descripcionGasto
     */
    public void setDescripcionGasto(java.lang.String descripcionGasto) {
        this.descripcionGasto = descripcionGasto;
    }


    /**
     * Gets the fechaDeGasto value for this IdentificacionDelGastoR.
     * 
     * @return fechaDeGasto
     */
    public java.lang.String getFechaDeGasto() {
        return fechaDeGasto;
    }


    /**
     * Sets the fechaDeGasto value for this IdentificacionDelGastoR.
     * 
     * @param fechaDeGasto
     */
    public void setFechaDeGasto(java.lang.String fechaDeGasto) {
        this.fechaDeGasto = fechaDeGasto;
    }


    /**
     * Gets the importeGasto value for this IdentificacionDelGastoR.
     * 
     * @return importeGasto
     */
    public java.math.BigDecimal getImporteGasto() {
        return importeGasto;
    }


    /**
     * Sets the importeGasto value for this IdentificacionDelGastoR.
     * 
     * @param importeGasto
     */
    public void setImporteGasto(java.math.BigDecimal importeGasto) {
        this.importeGasto = importeGasto;
    }


    /**
     * Gets the numFolioDoc value for this IdentificacionDelGastoR.
     * 
     * @return numFolioDoc
     */
    public java.lang.String getNumFolioDoc() {
        return numFolioDoc;
    }


    /**
     * Sets the numFolioDoc value for this IdentificacionDelGastoR.
     * 
     * @param numFolioDoc
     */
    public void setNumFolioDoc(java.lang.String numFolioDoc) {
        this.numFolioDoc = numFolioDoc;
    }


    /**
     * Gets the UUID value for this IdentificacionDelGastoR.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this IdentificacionDelGastoR.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentificacionDelGastoR)) return false;
        IdentificacionDelGastoR other = (IdentificacionDelGastoR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acuerdoGasto==null && other.getAcuerdoGasto()==null) || 
             (this.acuerdoGasto!=null &&
              this.acuerdoGasto.equals(other.getAcuerdoGasto()))) &&
            ((this.descripcionGasto==null && other.getDescripcionGasto()==null) || 
             (this.descripcionGasto!=null &&
              this.descripcionGasto.equals(other.getDescripcionGasto()))) &&
            ((this.fechaDeGasto==null && other.getFechaDeGasto()==null) || 
             (this.fechaDeGasto!=null &&
              this.fechaDeGasto.equals(other.getFechaDeGasto()))) &&
            ((this.importeGasto==null && other.getImporteGasto()==null) || 
             (this.importeGasto!=null &&
              this.importeGasto.equals(other.getImporteGasto()))) &&
            ((this.numFolioDoc==null && other.getNumFolioDoc()==null) || 
             (this.numFolioDoc!=null &&
              this.numFolioDoc.equals(other.getNumFolioDoc()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID())));
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
        if (getAcuerdoGasto() != null) {
            _hashCode += getAcuerdoGasto().hashCode();
        }
        if (getDescripcionGasto() != null) {
            _hashCode += getDescripcionGasto().hashCode();
        }
        if (getFechaDeGasto() != null) {
            _hashCode += getFechaDeGasto().hashCode();
        }
        if (getImporteGasto() != null) {
            _hashCode += getImporteGasto().hashCode();
        }
        if (getNumFolioDoc() != null) {
            _hashCode += getNumFolioDoc().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdentificacionDelGastoR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionDelGastoR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acuerdoGasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AcuerdoGasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionGasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescripcionGasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaDeGasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaDeGasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeGasto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImporteGasto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numFolioDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumFolioDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUID"));
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
