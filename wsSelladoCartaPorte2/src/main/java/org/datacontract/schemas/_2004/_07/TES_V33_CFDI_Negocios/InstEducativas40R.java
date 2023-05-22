/**
 * InstEducativas40R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class InstEducativas40R  implements java.io.Serializable {
    private java.lang.String autRVOE;

    private java.lang.String CURP;

    private java.lang.String nivelEducativo;

    private java.lang.String nombreAlumno;

    private java.lang.String rfcPago;

    public InstEducativas40R() {
    }

    public InstEducativas40R(
           java.lang.String autRVOE,
           java.lang.String CURP,
           java.lang.String nivelEducativo,
           java.lang.String nombreAlumno,
           java.lang.String rfcPago) {
           this.autRVOE = autRVOE;
           this.CURP = CURP;
           this.nivelEducativo = nivelEducativo;
           this.nombreAlumno = nombreAlumno;
           this.rfcPago = rfcPago;
    }


    /**
     * Gets the autRVOE value for this InstEducativas40R.
     * 
     * @return autRVOE
     */
    public java.lang.String getAutRVOE() {
        return autRVOE;
    }


    /**
     * Sets the autRVOE value for this InstEducativas40R.
     * 
     * @param autRVOE
     */
    public void setAutRVOE(java.lang.String autRVOE) {
        this.autRVOE = autRVOE;
    }


    /**
     * Gets the CURP value for this InstEducativas40R.
     * 
     * @return CURP
     */
    public java.lang.String getCURP() {
        return CURP;
    }


    /**
     * Sets the CURP value for this InstEducativas40R.
     * 
     * @param CURP
     */
    public void setCURP(java.lang.String CURP) {
        this.CURP = CURP;
    }


    /**
     * Gets the nivelEducativo value for this InstEducativas40R.
     * 
     * @return nivelEducativo
     */
    public java.lang.String getNivelEducativo() {
        return nivelEducativo;
    }


    /**
     * Sets the nivelEducativo value for this InstEducativas40R.
     * 
     * @param nivelEducativo
     */
    public void setNivelEducativo(java.lang.String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }


    /**
     * Gets the nombreAlumno value for this InstEducativas40R.
     * 
     * @return nombreAlumno
     */
    public java.lang.String getNombreAlumno() {
        return nombreAlumno;
    }


    /**
     * Sets the nombreAlumno value for this InstEducativas40R.
     * 
     * @param nombreAlumno
     */
    public void setNombreAlumno(java.lang.String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }


    /**
     * Gets the rfcPago value for this InstEducativas40R.
     * 
     * @return rfcPago
     */
    public java.lang.String getRfcPago() {
        return rfcPago;
    }


    /**
     * Sets the rfcPago value for this InstEducativas40R.
     * 
     * @param rfcPago
     */
    public void setRfcPago(java.lang.String rfcPago) {
        this.rfcPago = rfcPago;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InstEducativas40R)) return false;
        InstEducativas40R other = (InstEducativas40R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autRVOE==null && other.getAutRVOE()==null) || 
             (this.autRVOE!=null &&
              this.autRVOE.equals(other.getAutRVOE()))) &&
            ((this.CURP==null && other.getCURP()==null) || 
             (this.CURP!=null &&
              this.CURP.equals(other.getCURP()))) &&
            ((this.nivelEducativo==null && other.getNivelEducativo()==null) || 
             (this.nivelEducativo!=null &&
              this.nivelEducativo.equals(other.getNivelEducativo()))) &&
            ((this.nombreAlumno==null && other.getNombreAlumno()==null) || 
             (this.nombreAlumno!=null &&
              this.nombreAlumno.equals(other.getNombreAlumno()))) &&
            ((this.rfcPago==null && other.getRfcPago()==null) || 
             (this.rfcPago!=null &&
              this.rfcPago.equals(other.getRfcPago())));
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
        if (getAutRVOE() != null) {
            _hashCode += getAutRVOE().hashCode();
        }
        if (getCURP() != null) {
            _hashCode += getCURP().hashCode();
        }
        if (getNivelEducativo() != null) {
            _hashCode += getNivelEducativo().hashCode();
        }
        if (getNombreAlumno() != null) {
            _hashCode += getNombreAlumno().hashCode();
        }
        if (getRfcPago() != null) {
            _hashCode += getRfcPago().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InstEducativas40R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "InstEducativas40R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autRVOE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AutRVOE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CURP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivelEducativo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NivelEducativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreAlumno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NombreAlumno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "RfcPago"));
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
