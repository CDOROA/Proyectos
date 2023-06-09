/**
 * ReceptorR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi;

public class ReceptorR  implements java.io.Serializable {
    private java.lang.String domicilioFiscalReceptor;

    private java.lang.String nombre;

    private java.lang.String numRegIdTrib;

    private java.lang.String regimenFiscalReceptor;

    private java.lang.String residenciaFiscal;

    private java.lang.String rfc;

    private java.lang.String usoCFDI;

    public ReceptorR() {
    }

    public ReceptorR(
           java.lang.String domicilioFiscalReceptor,
           java.lang.String nombre,
           java.lang.String numRegIdTrib,
           java.lang.String regimenFiscalReceptor,
           java.lang.String residenciaFiscal,
           java.lang.String rfc,
           java.lang.String usoCFDI) {
           this.domicilioFiscalReceptor = domicilioFiscalReceptor;
           this.nombre = nombre;
           this.numRegIdTrib = numRegIdTrib;
           this.regimenFiscalReceptor = regimenFiscalReceptor;
           this.residenciaFiscal = residenciaFiscal;
           this.rfc = rfc;
           this.usoCFDI = usoCFDI;
    }


    /**
     * Gets the domicilioFiscalReceptor value for this ReceptorR.
     * 
     * @return domicilioFiscalReceptor
     */
    public java.lang.String getDomicilioFiscalReceptor() {
        return domicilioFiscalReceptor;
    }


    /**
     * Sets the domicilioFiscalReceptor value for this ReceptorR.
     * 
     * @param domicilioFiscalReceptor
     */
    public void setDomicilioFiscalReceptor(java.lang.String domicilioFiscalReceptor) {
        this.domicilioFiscalReceptor = domicilioFiscalReceptor;
    }


    /**
     * Gets the nombre value for this ReceptorR.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ReceptorR.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the numRegIdTrib value for this ReceptorR.
     * 
     * @return numRegIdTrib
     */
    public java.lang.String getNumRegIdTrib() {
        return numRegIdTrib;
    }


    /**
     * Sets the numRegIdTrib value for this ReceptorR.
     * 
     * @param numRegIdTrib
     */
    public void setNumRegIdTrib(java.lang.String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }


    /**
     * Gets the regimenFiscalReceptor value for this ReceptorR.
     * 
     * @return regimenFiscalReceptor
     */
    public java.lang.String getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }


    /**
     * Sets the regimenFiscalReceptor value for this ReceptorR.
     * 
     * @param regimenFiscalReceptor
     */
    public void setRegimenFiscalReceptor(java.lang.String regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }


    /**
     * Gets the residenciaFiscal value for this ReceptorR.
     * 
     * @return residenciaFiscal
     */
    public java.lang.String getResidenciaFiscal() {
        return residenciaFiscal;
    }


    /**
     * Sets the residenciaFiscal value for this ReceptorR.
     * 
     * @param residenciaFiscal
     */
    public void setResidenciaFiscal(java.lang.String residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }


    /**
     * Gets the rfc value for this ReceptorR.
     * 
     * @return rfc
     */
    public java.lang.String getRfc() {
        return rfc;
    }


    /**
     * Sets the rfc value for this ReceptorR.
     * 
     * @param rfc
     */
    public void setRfc(java.lang.String rfc) {
        this.rfc = rfc;
    }


    /**
     * Gets the usoCFDI value for this ReceptorR.
     * 
     * @return usoCFDI
     */
    public java.lang.String getUsoCFDI() {
        return usoCFDI;
    }


    /**
     * Sets the usoCFDI value for this ReceptorR.
     * 
     * @param usoCFDI
     */
    public void setUsoCFDI(java.lang.String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceptorR)) return false;
        ReceptorR other = (ReceptorR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domicilioFiscalReceptor==null && other.getDomicilioFiscalReceptor()==null) || 
             (this.domicilioFiscalReceptor!=null &&
              this.domicilioFiscalReceptor.equals(other.getDomicilioFiscalReceptor()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.numRegIdTrib==null && other.getNumRegIdTrib()==null) || 
             (this.numRegIdTrib!=null &&
              this.numRegIdTrib.equals(other.getNumRegIdTrib()))) &&
            ((this.regimenFiscalReceptor==null && other.getRegimenFiscalReceptor()==null) || 
             (this.regimenFiscalReceptor!=null &&
              this.regimenFiscalReceptor.equals(other.getRegimenFiscalReceptor()))) &&
            ((this.residenciaFiscal==null && other.getResidenciaFiscal()==null) || 
             (this.residenciaFiscal!=null &&
              this.residenciaFiscal.equals(other.getResidenciaFiscal()))) &&
            ((this.rfc==null && other.getRfc()==null) || 
             (this.rfc!=null &&
              this.rfc.equals(other.getRfc()))) &&
            ((this.usoCFDI==null && other.getUsoCFDI()==null) || 
             (this.usoCFDI!=null &&
              this.usoCFDI.equals(other.getUsoCFDI())));
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
        if (getDomicilioFiscalReceptor() != null) {
            _hashCode += getDomicilioFiscalReceptor().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNumRegIdTrib() != null) {
            _hashCode += getNumRegIdTrib().hashCode();
        }
        if (getRegimenFiscalReceptor() != null) {
            _hashCode += getRegimenFiscalReceptor().hashCode();
        }
        if (getResidenciaFiscal() != null) {
            _hashCode += getResidenciaFiscal().hashCode();
        }
        if (getRfc() != null) {
            _hashCode += getRfc().hashCode();
        }
        if (getUsoCFDI() != null) {
            _hashCode += getUsoCFDI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReceptorR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ReceptorR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilioFiscalReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "DomicilioFiscalReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numRegIdTrib");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "NumRegIdTrib"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regimenFiscalReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "RegimenFiscalReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("residenciaFiscal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "ResidenciaFiscal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "Rfc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usoCFDI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.GenerarCfdi", "UsoCFDI"));
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
