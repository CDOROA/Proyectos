/**
 * CartaPorteMercanciasTransporteFerroviarioCarro20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasTransporteFerroviarioCarro20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[] contenedor;

    private java.lang.String guiaCarro;

    private java.lang.String matriculaCarro;

    private java.lang.String tipoCarro;

    private java.math.BigDecimal toneladasNetasCarro;

    public CartaPorteMercanciasTransporteFerroviarioCarro20R() {
    }

    public CartaPorteMercanciasTransporteFerroviarioCarro20R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[] contenedor,
           java.lang.String guiaCarro,
           java.lang.String matriculaCarro,
           java.lang.String tipoCarro,
           java.math.BigDecimal toneladasNetasCarro) {
           this.contenedor = contenedor;
           this.guiaCarro = guiaCarro;
           this.matriculaCarro = matriculaCarro;
           this.tipoCarro = tipoCarro;
           this.toneladasNetasCarro = toneladasNetasCarro;
    }


    /**
     * Gets the contenedor value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @return contenedor
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[] getContenedor() {
        return contenedor;
    }


    /**
     * Sets the contenedor value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @param contenedor
     */
    public void setContenedor(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R[] contenedor) {
        this.contenedor = contenedor;
    }


    /**
     * Gets the guiaCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @return guiaCarro
     */
    public java.lang.String getGuiaCarro() {
        return guiaCarro;
    }


    /**
     * Sets the guiaCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @param guiaCarro
     */
    public void setGuiaCarro(java.lang.String guiaCarro) {
        this.guiaCarro = guiaCarro;
    }


    /**
     * Gets the matriculaCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @return matriculaCarro
     */
    public java.lang.String getMatriculaCarro() {
        return matriculaCarro;
    }


    /**
     * Sets the matriculaCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @param matriculaCarro
     */
    public void setMatriculaCarro(java.lang.String matriculaCarro) {
        this.matriculaCarro = matriculaCarro;
    }


    /**
     * Gets the tipoCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @return tipoCarro
     */
    public java.lang.String getTipoCarro() {
        return tipoCarro;
    }


    /**
     * Sets the tipoCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @param tipoCarro
     */
    public void setTipoCarro(java.lang.String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }


    /**
     * Gets the toneladasNetasCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @return toneladasNetasCarro
     */
    public java.math.BigDecimal getToneladasNetasCarro() {
        return toneladasNetasCarro;
    }


    /**
     * Sets the toneladasNetasCarro value for this CartaPorteMercanciasTransporteFerroviarioCarro20R.
     * 
     * @param toneladasNetasCarro
     */
    public void setToneladasNetasCarro(java.math.BigDecimal toneladasNetasCarro) {
        this.toneladasNetasCarro = toneladasNetasCarro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasTransporteFerroviarioCarro20R)) return false;
        CartaPorteMercanciasTransporteFerroviarioCarro20R other = (CartaPorteMercanciasTransporteFerroviarioCarro20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contenedor==null && other.getContenedor()==null) || 
             (this.contenedor!=null &&
              java.util.Arrays.equals(this.contenedor, other.getContenedor()))) &&
            ((this.guiaCarro==null && other.getGuiaCarro()==null) || 
             (this.guiaCarro!=null &&
              this.guiaCarro.equals(other.getGuiaCarro()))) &&
            ((this.matriculaCarro==null && other.getMatriculaCarro()==null) || 
             (this.matriculaCarro!=null &&
              this.matriculaCarro.equals(other.getMatriculaCarro()))) &&
            ((this.tipoCarro==null && other.getTipoCarro()==null) || 
             (this.tipoCarro!=null &&
              this.tipoCarro.equals(other.getTipoCarro()))) &&
            ((this.toneladasNetasCarro==null && other.getToneladasNetasCarro()==null) || 
             (this.toneladasNetasCarro!=null &&
              this.toneladasNetasCarro.equals(other.getToneladasNetasCarro())));
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
        if (getContenedor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContenedor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContenedor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGuiaCarro() != null) {
            _hashCode += getGuiaCarro().hashCode();
        }
        if (getMatriculaCarro() != null) {
            _hashCode += getMatriculaCarro().hashCode();
        }
        if (getTipoCarro() != null) {
            _hashCode += getTipoCarro().hashCode();
        }
        if (getToneladasNetasCarro() != null) {
            _hashCode += getToneladasNetasCarro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasTransporteFerroviarioCarro20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarro20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenedor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Contenedor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasTransporteFerroviarioCarroContenedor20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guiaCarro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "GuiaCarro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matriculaCarro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MatriculaCarro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCarro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoCarro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toneladasNetasCarro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ToneladasNetasCarro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
