/**
 * CartaPorteTiposFigura20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte;

public class CartaPorteTiposFigura20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraDomicilio20R domicilio;

    private java.lang.String nombreFigura;

    private java.lang.String numLicencia;

    private java.lang.String numRegIdTribFigura;

    private org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R[] partesTransporte;

    private java.lang.String RFCFigura;

    private java.lang.String residenciaFiscalFigura;

    private java.lang.String tipoFigura;

    public CartaPorteTiposFigura20R() {
    }

    public CartaPorteTiposFigura20R(
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraDomicilio20R domicilio,
           java.lang.String nombreFigura,
           java.lang.String numLicencia,
           java.lang.String numRegIdTribFigura,
           org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R[] partesTransporte,
           java.lang.String RFCFigura,
           java.lang.String residenciaFiscalFigura,
           java.lang.String tipoFigura) {
           this.domicilio = domicilio;
           this.nombreFigura = nombreFigura;
           this.numLicencia = numLicencia;
           this.numRegIdTribFigura = numRegIdTribFigura;
           this.partesTransporte = partesTransporte;
           this.RFCFigura = RFCFigura;
           this.residenciaFiscalFigura = residenciaFiscalFigura;
           this.tipoFigura = tipoFigura;
    }


    /**
     * Gets the domicilio value for this CartaPorteTiposFigura20R.
     * 
     * @return domicilio
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraDomicilio20R getDomicilio() {
        return domicilio;
    }


    /**
     * Sets the domicilio value for this CartaPorteTiposFigura20R.
     * 
     * @param domicilio
     */
    public void setDomicilio(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraDomicilio20R domicilio) {
        this.domicilio = domicilio;
    }


    /**
     * Gets the nombreFigura value for this CartaPorteTiposFigura20R.
     * 
     * @return nombreFigura
     */
    public java.lang.String getNombreFigura() {
        return nombreFigura;
    }


    /**
     * Sets the nombreFigura value for this CartaPorteTiposFigura20R.
     * 
     * @param nombreFigura
     */
    public void setNombreFigura(java.lang.String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }


    /**
     * Gets the numLicencia value for this CartaPorteTiposFigura20R.
     * 
     * @return numLicencia
     */
    public java.lang.String getNumLicencia() {
        return numLicencia;
    }


    /**
     * Sets the numLicencia value for this CartaPorteTiposFigura20R.
     * 
     * @param numLicencia
     */
    public void setNumLicencia(java.lang.String numLicencia) {
        this.numLicencia = numLicencia;
    }


    /**
     * Gets the numRegIdTribFigura value for this CartaPorteTiposFigura20R.
     * 
     * @return numRegIdTribFigura
     */
    public java.lang.String getNumRegIdTribFigura() {
        return numRegIdTribFigura;
    }


    /**
     * Sets the numRegIdTribFigura value for this CartaPorteTiposFigura20R.
     * 
     * @param numRegIdTribFigura
     */
    public void setNumRegIdTribFigura(java.lang.String numRegIdTribFigura) {
        this.numRegIdTribFigura = numRegIdTribFigura;
    }


    /**
     * Gets the partesTransporte value for this CartaPorteTiposFigura20R.
     * 
     * @return partesTransporte
     */
    public org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R[] getPartesTransporte() {
        return partesTransporte;
    }


    /**
     * Sets the partesTransporte value for this CartaPorteTiposFigura20R.
     * 
     * @param partesTransporte
     */
    public void setPartesTransporte(org.datacontract.schemas._2004._07.Emision_Model_DTO_Complementos_CartaPorte.CartaPorteTiposFiguraPartesTransporte20R[] partesTransporte) {
        this.partesTransporte = partesTransporte;
    }


    /**
     * Gets the RFCFigura value for this CartaPorteTiposFigura20R.
     * 
     * @return RFCFigura
     */
    public java.lang.String getRFCFigura() {
        return RFCFigura;
    }


    /**
     * Sets the RFCFigura value for this CartaPorteTiposFigura20R.
     * 
     * @param RFCFigura
     */
    public void setRFCFigura(java.lang.String RFCFigura) {
        this.RFCFigura = RFCFigura;
    }


    /**
     * Gets the residenciaFiscalFigura value for this CartaPorteTiposFigura20R.
     * 
     * @return residenciaFiscalFigura
     */
    public java.lang.String getResidenciaFiscalFigura() {
        return residenciaFiscalFigura;
    }


    /**
     * Sets the residenciaFiscalFigura value for this CartaPorteTiposFigura20R.
     * 
     * @param residenciaFiscalFigura
     */
    public void setResidenciaFiscalFigura(java.lang.String residenciaFiscalFigura) {
        this.residenciaFiscalFigura = residenciaFiscalFigura;
    }


    /**
     * Gets the tipoFigura value for this CartaPorteTiposFigura20R.
     * 
     * @return tipoFigura
     */
    public java.lang.String getTipoFigura() {
        return tipoFigura;
    }


    /**
     * Sets the tipoFigura value for this CartaPorteTiposFigura20R.
     * 
     * @param tipoFigura
     */
    public void setTipoFigura(java.lang.String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteTiposFigura20R)) return false;
        CartaPorteTiposFigura20R other = (CartaPorteTiposFigura20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.domicilio==null && other.getDomicilio()==null) || 
             (this.domicilio!=null &&
              this.domicilio.equals(other.getDomicilio()))) &&
            ((this.nombreFigura==null && other.getNombreFigura()==null) || 
             (this.nombreFigura!=null &&
              this.nombreFigura.equals(other.getNombreFigura()))) &&
            ((this.numLicencia==null && other.getNumLicencia()==null) || 
             (this.numLicencia!=null &&
              this.numLicencia.equals(other.getNumLicencia()))) &&
            ((this.numRegIdTribFigura==null && other.getNumRegIdTribFigura()==null) || 
             (this.numRegIdTribFigura!=null &&
              this.numRegIdTribFigura.equals(other.getNumRegIdTribFigura()))) &&
            ((this.partesTransporte==null && other.getPartesTransporte()==null) || 
             (this.partesTransporte!=null &&
              java.util.Arrays.equals(this.partesTransporte, other.getPartesTransporte()))) &&
            ((this.RFCFigura==null && other.getRFCFigura()==null) || 
             (this.RFCFigura!=null &&
              this.RFCFigura.equals(other.getRFCFigura()))) &&
            ((this.residenciaFiscalFigura==null && other.getResidenciaFiscalFigura()==null) || 
             (this.residenciaFiscalFigura!=null &&
              this.residenciaFiscalFigura.equals(other.getResidenciaFiscalFigura()))) &&
            ((this.tipoFigura==null && other.getTipoFigura()==null) || 
             (this.tipoFigura!=null &&
              this.tipoFigura.equals(other.getTipoFigura())));
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
        if (getDomicilio() != null) {
            _hashCode += getDomicilio().hashCode();
        }
        if (getNombreFigura() != null) {
            _hashCode += getNombreFigura().hashCode();
        }
        if (getNumLicencia() != null) {
            _hashCode += getNumLicencia().hashCode();
        }
        if (getNumRegIdTribFigura() != null) {
            _hashCode += getNumRegIdTribFigura().hashCode();
        }
        if (getPartesTransporte() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPartesTransporte());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPartesTransporte(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRFCFigura() != null) {
            _hashCode += getRFCFigura().hashCode();
        }
        if (getResidenciaFiscalFigura() != null) {
            _hashCode += getResidenciaFiscalFigura().hashCode();
        }
        if (getTipoFigura() != null) {
            _hashCode += getTipoFigura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteTiposFigura20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFigura20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "Domicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraDomicilio20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFigura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NombreFigura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numLicencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NumLicencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numRegIdTribFigura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "NumRegIdTribFigura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partesTransporte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "PartesTransporte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "CartaPorteTiposFiguraPartesTransporte20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RFCFigura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "RFCFigura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("residenciaFiscalFigura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "ResidenciaFiscalFigura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoFigura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Emision.Model.DTO.Complementos.CartaPorte", "TipoFigura"));
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
