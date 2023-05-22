/**
 * SPEIR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class SPEIR  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.BeneficiarioR beneficiario;

    private java.lang.String cadenaCDA;

    private java.lang.Integer claveSPEI;

    private java.util.Calendar fechaOperacion;

    private java.lang.String numeroCertificado;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OrdenanteR ordenante;

    private java.lang.String sello;

    public SPEIR() {
    }

    public SPEIR(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.BeneficiarioR beneficiario,
           java.lang.String cadenaCDA,
           java.lang.Integer claveSPEI,
           java.util.Calendar fechaOperacion,
           java.lang.String numeroCertificado,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OrdenanteR ordenante,
           java.lang.String sello) {
           this.beneficiario = beneficiario;
           this.cadenaCDA = cadenaCDA;
           this.claveSPEI = claveSPEI;
           this.fechaOperacion = fechaOperacion;
           this.numeroCertificado = numeroCertificado;
           this.ordenante = ordenante;
           this.sello = sello;
    }


    /**
     * Gets the beneficiario value for this SPEIR.
     * 
     * @return beneficiario
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.BeneficiarioR getBeneficiario() {
        return beneficiario;
    }


    /**
     * Sets the beneficiario value for this SPEIR.
     * 
     * @param beneficiario
     */
    public void setBeneficiario(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.BeneficiarioR beneficiario) {
        this.beneficiario = beneficiario;
    }


    /**
     * Gets the cadenaCDA value for this SPEIR.
     * 
     * @return cadenaCDA
     */
    public java.lang.String getCadenaCDA() {
        return cadenaCDA;
    }


    /**
     * Sets the cadenaCDA value for this SPEIR.
     * 
     * @param cadenaCDA
     */
    public void setCadenaCDA(java.lang.String cadenaCDA) {
        this.cadenaCDA = cadenaCDA;
    }


    /**
     * Gets the claveSPEI value for this SPEIR.
     * 
     * @return claveSPEI
     */
    public java.lang.Integer getClaveSPEI() {
        return claveSPEI;
    }


    /**
     * Sets the claveSPEI value for this SPEIR.
     * 
     * @param claveSPEI
     */
    public void setClaveSPEI(java.lang.Integer claveSPEI) {
        this.claveSPEI = claveSPEI;
    }


    /**
     * Gets the fechaOperacion value for this SPEIR.
     * 
     * @return fechaOperacion
     */
    public java.util.Calendar getFechaOperacion() {
        return fechaOperacion;
    }


    /**
     * Sets the fechaOperacion value for this SPEIR.
     * 
     * @param fechaOperacion
     */
    public void setFechaOperacion(java.util.Calendar fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }


    /**
     * Gets the numeroCertificado value for this SPEIR.
     * 
     * @return numeroCertificado
     */
    public java.lang.String getNumeroCertificado() {
        return numeroCertificado;
    }


    /**
     * Sets the numeroCertificado value for this SPEIR.
     * 
     * @param numeroCertificado
     */
    public void setNumeroCertificado(java.lang.String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }


    /**
     * Gets the ordenante value for this SPEIR.
     * 
     * @return ordenante
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OrdenanteR getOrdenante() {
        return ordenante;
    }


    /**
     * Sets the ordenante value for this SPEIR.
     * 
     * @param ordenante
     */
    public void setOrdenante(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OrdenanteR ordenante) {
        this.ordenante = ordenante;
    }


    /**
     * Gets the sello value for this SPEIR.
     * 
     * @return sello
     */
    public java.lang.String getSello() {
        return sello;
    }


    /**
     * Sets the sello value for this SPEIR.
     * 
     * @param sello
     */
    public void setSello(java.lang.String sello) {
        this.sello = sello;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SPEIR)) return false;
        SPEIR other = (SPEIR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.beneficiario==null && other.getBeneficiario()==null) || 
             (this.beneficiario!=null &&
              this.beneficiario.equals(other.getBeneficiario()))) &&
            ((this.cadenaCDA==null && other.getCadenaCDA()==null) || 
             (this.cadenaCDA!=null &&
              this.cadenaCDA.equals(other.getCadenaCDA()))) &&
            ((this.claveSPEI==null && other.getClaveSPEI()==null) || 
             (this.claveSPEI!=null &&
              this.claveSPEI.equals(other.getClaveSPEI()))) &&
            ((this.fechaOperacion==null && other.getFechaOperacion()==null) || 
             (this.fechaOperacion!=null &&
              this.fechaOperacion.equals(other.getFechaOperacion()))) &&
            ((this.numeroCertificado==null && other.getNumeroCertificado()==null) || 
             (this.numeroCertificado!=null &&
              this.numeroCertificado.equals(other.getNumeroCertificado()))) &&
            ((this.ordenante==null && other.getOrdenante()==null) || 
             (this.ordenante!=null &&
              this.ordenante.equals(other.getOrdenante()))) &&
            ((this.sello==null && other.getSello()==null) || 
             (this.sello!=null &&
              this.sello.equals(other.getSello())));
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
        if (getBeneficiario() != null) {
            _hashCode += getBeneficiario().hashCode();
        }
        if (getCadenaCDA() != null) {
            _hashCode += getCadenaCDA().hashCode();
        }
        if (getClaveSPEI() != null) {
            _hashCode += getClaveSPEI().hashCode();
        }
        if (getFechaOperacion() != null) {
            _hashCode += getFechaOperacion().hashCode();
        }
        if (getNumeroCertificado() != null) {
            _hashCode += getNumeroCertificado().hashCode();
        }
        if (getOrdenante() != null) {
            _hashCode += getOrdenante().hashCode();
        }
        if (getSello() != null) {
            _hashCode += getSello().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SPEIR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SPEIR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Beneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BeneficiarioR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cadenaCDA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CadenaCDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveSPEI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveSPEI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCertificado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumeroCertificado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordenante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Ordenante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OrdenanteR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sello");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Sello"));
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
