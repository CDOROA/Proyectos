/**
 * ConsumoDeCombustibles11R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class ConsumoDeCombustibles11R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R[] conceptos;

    private java.math.BigDecimal subTotal;

    private java.math.BigDecimal total;

    private java.lang.String numeroDeCuenta;

    private java.lang.String tipoOperacion;

    public ConsumoDeCombustibles11R() {
    }

    public ConsumoDeCombustibles11R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R[] conceptos,
           java.math.BigDecimal subTotal,
           java.math.BigDecimal total,
           java.lang.String numeroDeCuenta,
           java.lang.String tipoOperacion) {
           this.conceptos = conceptos;
           this.subTotal = subTotal;
           this.total = total;
           this.numeroDeCuenta = numeroDeCuenta;
           this.tipoOperacion = tipoOperacion;
    }


    /**
     * Gets the conceptos value for this ConsumoDeCombustibles11R.
     * 
     * @return conceptos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R[] getConceptos() {
        return conceptos;
    }


    /**
     * Sets the conceptos value for this ConsumoDeCombustibles11R.
     * 
     * @param conceptos
     */
    public void setConceptos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoConsumoDeCombustibles11R[] conceptos) {
        this.conceptos = conceptos;
    }


    /**
     * Gets the subTotal value for this ConsumoDeCombustibles11R.
     * 
     * @return subTotal
     */
    public java.math.BigDecimal getSubTotal() {
        return subTotal;
    }


    /**
     * Sets the subTotal value for this ConsumoDeCombustibles11R.
     * 
     * @param subTotal
     */
    public void setSubTotal(java.math.BigDecimal subTotal) {
        this.subTotal = subTotal;
    }


    /**
     * Gets the total value for this ConsumoDeCombustibles11R.
     * 
     * @return total
     */
    public java.math.BigDecimal getTotal() {
        return total;
    }


    /**
     * Sets the total value for this ConsumoDeCombustibles11R.
     * 
     * @param total
     */
    public void setTotal(java.math.BigDecimal total) {
        this.total = total;
    }


    /**
     * Gets the numeroDeCuenta value for this ConsumoDeCombustibles11R.
     * 
     * @return numeroDeCuenta
     */
    public java.lang.String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }


    /**
     * Sets the numeroDeCuenta value for this ConsumoDeCombustibles11R.
     * 
     * @param numeroDeCuenta
     */
    public void setNumeroDeCuenta(java.lang.String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }


    /**
     * Gets the tipoOperacion value for this ConsumoDeCombustibles11R.
     * 
     * @return tipoOperacion
     */
    public java.lang.String getTipoOperacion() {
        return tipoOperacion;
    }


    /**
     * Sets the tipoOperacion value for this ConsumoDeCombustibles11R.
     * 
     * @param tipoOperacion
     */
    public void setTipoOperacion(java.lang.String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsumoDeCombustibles11R)) return false;
        ConsumoDeCombustibles11R other = (ConsumoDeCombustibles11R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.conceptos==null && other.getConceptos()==null) || 
             (this.conceptos!=null &&
              java.util.Arrays.equals(this.conceptos, other.getConceptos()))) &&
            ((this.subTotal==null && other.getSubTotal()==null) || 
             (this.subTotal!=null &&
              this.subTotal.equals(other.getSubTotal()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.numeroDeCuenta==null && other.getNumeroDeCuenta()==null) || 
             (this.numeroDeCuenta!=null &&
              this.numeroDeCuenta.equals(other.getNumeroDeCuenta()))) &&
            ((this.tipoOperacion==null && other.getTipoOperacion()==null) || 
             (this.tipoOperacion!=null &&
              this.tipoOperacion.equals(other.getTipoOperacion())));
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
        if (getConceptos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConceptos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConceptos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubTotal() != null) {
            _hashCode += getSubTotal().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getNumeroDeCuenta() != null) {
            _hashCode += getNumeroDeCuenta().hashCode();
        }
        if (getTipoOperacion() != null) {
            _hashCode += getTipoOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsumoDeCombustibles11R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConsumoDeCombustibles11R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conceptos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Conceptos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustibles11R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ConceptoConsumoDeCombustibles11R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "SubTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDeCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "numeroDeCuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "tipoOperacion"));
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
