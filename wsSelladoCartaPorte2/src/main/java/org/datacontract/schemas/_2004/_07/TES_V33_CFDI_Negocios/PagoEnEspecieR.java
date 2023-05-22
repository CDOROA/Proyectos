/**
 * PagoEnEspecieR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class PagoEnEspecieR  implements java.io.Serializable {
    private java.lang.String cvePIC;

    private java.lang.String folioSolDon;

    private java.lang.String pzaArtAProd;

    private java.lang.String pzaArtDim;

    private java.lang.String pzaArtNombre;

    private java.lang.String pzaArtTecn;

    public PagoEnEspecieR() {
    }

    public PagoEnEspecieR(
           java.lang.String cvePIC,
           java.lang.String folioSolDon,
           java.lang.String pzaArtAProd,
           java.lang.String pzaArtDim,
           java.lang.String pzaArtNombre,
           java.lang.String pzaArtTecn) {
           this.cvePIC = cvePIC;
           this.folioSolDon = folioSolDon;
           this.pzaArtAProd = pzaArtAProd;
           this.pzaArtDim = pzaArtDim;
           this.pzaArtNombre = pzaArtNombre;
           this.pzaArtTecn = pzaArtTecn;
    }


    /**
     * Gets the cvePIC value for this PagoEnEspecieR.
     * 
     * @return cvePIC
     */
    public java.lang.String getCvePIC() {
        return cvePIC;
    }


    /**
     * Sets the cvePIC value for this PagoEnEspecieR.
     * 
     * @param cvePIC
     */
    public void setCvePIC(java.lang.String cvePIC) {
        this.cvePIC = cvePIC;
    }


    /**
     * Gets the folioSolDon value for this PagoEnEspecieR.
     * 
     * @return folioSolDon
     */
    public java.lang.String getFolioSolDon() {
        return folioSolDon;
    }


    /**
     * Sets the folioSolDon value for this PagoEnEspecieR.
     * 
     * @param folioSolDon
     */
    public void setFolioSolDon(java.lang.String folioSolDon) {
        this.folioSolDon = folioSolDon;
    }


    /**
     * Gets the pzaArtAProd value for this PagoEnEspecieR.
     * 
     * @return pzaArtAProd
     */
    public java.lang.String getPzaArtAProd() {
        return pzaArtAProd;
    }


    /**
     * Sets the pzaArtAProd value for this PagoEnEspecieR.
     * 
     * @param pzaArtAProd
     */
    public void setPzaArtAProd(java.lang.String pzaArtAProd) {
        this.pzaArtAProd = pzaArtAProd;
    }


    /**
     * Gets the pzaArtDim value for this PagoEnEspecieR.
     * 
     * @return pzaArtDim
     */
    public java.lang.String getPzaArtDim() {
        return pzaArtDim;
    }


    /**
     * Sets the pzaArtDim value for this PagoEnEspecieR.
     * 
     * @param pzaArtDim
     */
    public void setPzaArtDim(java.lang.String pzaArtDim) {
        this.pzaArtDim = pzaArtDim;
    }


    /**
     * Gets the pzaArtNombre value for this PagoEnEspecieR.
     * 
     * @return pzaArtNombre
     */
    public java.lang.String getPzaArtNombre() {
        return pzaArtNombre;
    }


    /**
     * Sets the pzaArtNombre value for this PagoEnEspecieR.
     * 
     * @param pzaArtNombre
     */
    public void setPzaArtNombre(java.lang.String pzaArtNombre) {
        this.pzaArtNombre = pzaArtNombre;
    }


    /**
     * Gets the pzaArtTecn value for this PagoEnEspecieR.
     * 
     * @return pzaArtTecn
     */
    public java.lang.String getPzaArtTecn() {
        return pzaArtTecn;
    }


    /**
     * Sets the pzaArtTecn value for this PagoEnEspecieR.
     * 
     * @param pzaArtTecn
     */
    public void setPzaArtTecn(java.lang.String pzaArtTecn) {
        this.pzaArtTecn = pzaArtTecn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagoEnEspecieR)) return false;
        PagoEnEspecieR other = (PagoEnEspecieR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cvePIC==null && other.getCvePIC()==null) || 
             (this.cvePIC!=null &&
              this.cvePIC.equals(other.getCvePIC()))) &&
            ((this.folioSolDon==null && other.getFolioSolDon()==null) || 
             (this.folioSolDon!=null &&
              this.folioSolDon.equals(other.getFolioSolDon()))) &&
            ((this.pzaArtAProd==null && other.getPzaArtAProd()==null) || 
             (this.pzaArtAProd!=null &&
              this.pzaArtAProd.equals(other.getPzaArtAProd()))) &&
            ((this.pzaArtDim==null && other.getPzaArtDim()==null) || 
             (this.pzaArtDim!=null &&
              this.pzaArtDim.equals(other.getPzaArtDim()))) &&
            ((this.pzaArtNombre==null && other.getPzaArtNombre()==null) || 
             (this.pzaArtNombre!=null &&
              this.pzaArtNombre.equals(other.getPzaArtNombre()))) &&
            ((this.pzaArtTecn==null && other.getPzaArtTecn()==null) || 
             (this.pzaArtTecn!=null &&
              this.pzaArtTecn.equals(other.getPzaArtTecn())));
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
        if (getCvePIC() != null) {
            _hashCode += getCvePIC().hashCode();
        }
        if (getFolioSolDon() != null) {
            _hashCode += getFolioSolDon().hashCode();
        }
        if (getPzaArtAProd() != null) {
            _hashCode += getPzaArtAProd().hashCode();
        }
        if (getPzaArtDim() != null) {
            _hashCode += getPzaArtDim().hashCode();
        }
        if (getPzaArtNombre() != null) {
            _hashCode += getPzaArtNombre().hashCode();
        }
        if (getPzaArtTecn() != null) {
            _hashCode += getPzaArtTecn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagoEnEspecieR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PagoEnEspecieR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cvePIC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CvePIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioSolDon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FolioSolDon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pzaArtAProd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PzaArtAProd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pzaArtDim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PzaArtDim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pzaArtNombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PzaArtNombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pzaArtTecn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PzaArtTecn"));
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
