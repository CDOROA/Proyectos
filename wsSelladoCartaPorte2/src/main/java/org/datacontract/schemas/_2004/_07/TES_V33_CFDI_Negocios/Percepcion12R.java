/**
 * Percepcion12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class Percepcion12R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AccionesOTitulosR accionesOTitulosR;

    private java.lang.String clave;

    private java.lang.String concepto;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R[] horasExtra;

    private java.math.BigDecimal importeExento;

    private java.math.BigDecimal importeGravado;

    private java.lang.String tipoPercepcion;

    public Percepcion12R() {
    }

    public Percepcion12R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AccionesOTitulosR accionesOTitulosR,
           java.lang.String clave,
           java.lang.String concepto,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R[] horasExtra,
           java.math.BigDecimal importeExento,
           java.math.BigDecimal importeGravado,
           java.lang.String tipoPercepcion) {
           this.accionesOTitulosR = accionesOTitulosR;
           this.clave = clave;
           this.concepto = concepto;
           this.horasExtra = horasExtra;
           this.importeExento = importeExento;
           this.importeGravado = importeGravado;
           this.tipoPercepcion = tipoPercepcion;
    }


    /**
     * Gets the accionesOTitulosR value for this Percepcion12R.
     * 
     * @return accionesOTitulosR
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AccionesOTitulosR getAccionesOTitulosR() {
        return accionesOTitulosR;
    }


    /**
     * Sets the accionesOTitulosR value for this Percepcion12R.
     * 
     * @param accionesOTitulosR
     */
    public void setAccionesOTitulosR(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.AccionesOTitulosR accionesOTitulosR) {
        this.accionesOTitulosR = accionesOTitulosR;
    }


    /**
     * Gets the clave value for this Percepcion12R.
     * 
     * @return clave
     */
    public java.lang.String getClave() {
        return clave;
    }


    /**
     * Sets the clave value for this Percepcion12R.
     * 
     * @param clave
     */
    public void setClave(java.lang.String clave) {
        this.clave = clave;
    }


    /**
     * Gets the concepto value for this Percepcion12R.
     * 
     * @return concepto
     */
    public java.lang.String getConcepto() {
        return concepto;
    }


    /**
     * Sets the concepto value for this Percepcion12R.
     * 
     * @param concepto
     */
    public void setConcepto(java.lang.String concepto) {
        this.concepto = concepto;
    }


    /**
     * Gets the horasExtra value for this Percepcion12R.
     * 
     * @return horasExtra
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R[] getHorasExtra() {
        return horasExtra;
    }


    /**
     * Sets the horasExtra value for this Percepcion12R.
     * 
     * @param horasExtra
     */
    public void setHorasExtra(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.HorasExtra12R[] horasExtra) {
        this.horasExtra = horasExtra;
    }


    /**
     * Gets the importeExento value for this Percepcion12R.
     * 
     * @return importeExento
     */
    public java.math.BigDecimal getImporteExento() {
        return importeExento;
    }


    /**
     * Sets the importeExento value for this Percepcion12R.
     * 
     * @param importeExento
     */
    public void setImporteExento(java.math.BigDecimal importeExento) {
        this.importeExento = importeExento;
    }


    /**
     * Gets the importeGravado value for this Percepcion12R.
     * 
     * @return importeGravado
     */
    public java.math.BigDecimal getImporteGravado() {
        return importeGravado;
    }


    /**
     * Sets the importeGravado value for this Percepcion12R.
     * 
     * @param importeGravado
     */
    public void setImporteGravado(java.math.BigDecimal importeGravado) {
        this.importeGravado = importeGravado;
    }


    /**
     * Gets the tipoPercepcion value for this Percepcion12R.
     * 
     * @return tipoPercepcion
     */
    public java.lang.String getTipoPercepcion() {
        return tipoPercepcion;
    }


    /**
     * Sets the tipoPercepcion value for this Percepcion12R.
     * 
     * @param tipoPercepcion
     */
    public void setTipoPercepcion(java.lang.String tipoPercepcion) {
        this.tipoPercepcion = tipoPercepcion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Percepcion12R)) return false;
        Percepcion12R other = (Percepcion12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accionesOTitulosR==null && other.getAccionesOTitulosR()==null) || 
             (this.accionesOTitulosR!=null &&
              this.accionesOTitulosR.equals(other.getAccionesOTitulosR()))) &&
            ((this.clave==null && other.getClave()==null) || 
             (this.clave!=null &&
              this.clave.equals(other.getClave()))) &&
            ((this.concepto==null && other.getConcepto()==null) || 
             (this.concepto!=null &&
              this.concepto.equals(other.getConcepto()))) &&
            ((this.horasExtra==null && other.getHorasExtra()==null) || 
             (this.horasExtra!=null &&
              java.util.Arrays.equals(this.horasExtra, other.getHorasExtra()))) &&
            ((this.importeExento==null && other.getImporteExento()==null) || 
             (this.importeExento!=null &&
              this.importeExento.equals(other.getImporteExento()))) &&
            ((this.importeGravado==null && other.getImporteGravado()==null) || 
             (this.importeGravado!=null &&
              this.importeGravado.equals(other.getImporteGravado()))) &&
            ((this.tipoPercepcion==null && other.getTipoPercepcion()==null) || 
             (this.tipoPercepcion!=null &&
              this.tipoPercepcion.equals(other.getTipoPercepcion())));
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
        if (getAccionesOTitulosR() != null) {
            _hashCode += getAccionesOTitulosR().hashCode();
        }
        if (getClave() != null) {
            _hashCode += getClave().hashCode();
        }
        if (getConcepto() != null) {
            _hashCode += getConcepto().hashCode();
        }
        if (getHorasExtra() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHorasExtra());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHorasExtra(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImporteExento() != null) {
            _hashCode += getImporteExento().hashCode();
        }
        if (getImporteGravado() != null) {
            _hashCode += getImporteGravado().hashCode();
        }
        if (getTipoPercepcion() != null) {
            _hashCode += getTipoPercepcion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Percepcion12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Percepcion12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accionesOTitulosR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AccionesOTitulosR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "AccionesOTitulosR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Clave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concepto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Concepto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasExtra");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "HorasExtra12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeExento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImporteExento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importeGravado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ImporteGravado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPercepcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoPercepcion"));
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
