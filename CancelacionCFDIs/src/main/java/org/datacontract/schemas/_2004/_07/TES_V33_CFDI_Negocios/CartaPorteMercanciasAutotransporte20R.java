/**
 * CartaPorteMercanciasAutotransporte20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasAutotransporte20R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R identificacionVehicular;

    private java.lang.String numPermisoSCT;

    private java.lang.String permSCT;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R[] remolques;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R seguros;

    public CartaPorteMercanciasAutotransporte20R() {
    }

    public CartaPorteMercanciasAutotransporte20R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R identificacionVehicular,
           java.lang.String numPermisoSCT,
           java.lang.String permSCT,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R[] remolques,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R seguros) {
           this.identificacionVehicular = identificacionVehicular;
           this.numPermisoSCT = numPermisoSCT;
           this.permSCT = permSCT;
           this.remolques = remolques;
           this.seguros = seguros;
    }


    /**
     * Gets the identificacionVehicular value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @return identificacionVehicular
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R getIdentificacionVehicular() {
        return identificacionVehicular;
    }


    /**
     * Sets the identificacionVehicular value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @param identificacionVehicular
     */
    public void setIdentificacionVehicular(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R identificacionVehicular) {
        this.identificacionVehicular = identificacionVehicular;
    }


    /**
     * Gets the numPermisoSCT value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @return numPermisoSCT
     */
    public java.lang.String getNumPermisoSCT() {
        return numPermisoSCT;
    }


    /**
     * Sets the numPermisoSCT value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @param numPermisoSCT
     */
    public void setNumPermisoSCT(java.lang.String numPermisoSCT) {
        this.numPermisoSCT = numPermisoSCT;
    }


    /**
     * Gets the permSCT value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @return permSCT
     */
    public java.lang.String getPermSCT() {
        return permSCT;
    }


    /**
     * Sets the permSCT value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @param permSCT
     */
    public void setPermSCT(java.lang.String permSCT) {
        this.permSCT = permSCT;
    }


    /**
     * Gets the remolques value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @return remolques
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R[] getRemolques() {
        return remolques;
    }


    /**
     * Sets the remolques value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @param remolques
     */
    public void setRemolques(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteRemolque20R[] remolques) {
        this.remolques = remolques;
    }


    /**
     * Gets the seguros value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @return seguros
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R getSeguros() {
        return seguros;
    }


    /**
     * Sets the seguros value for this CartaPorteMercanciasAutotransporte20R.
     * 
     * @param seguros
     */
    public void setSeguros(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R seguros) {
        this.seguros = seguros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasAutotransporte20R)) return false;
        CartaPorteMercanciasAutotransporte20R other = (CartaPorteMercanciasAutotransporte20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.identificacionVehicular==null && other.getIdentificacionVehicular()==null) || 
             (this.identificacionVehicular!=null &&
              this.identificacionVehicular.equals(other.getIdentificacionVehicular()))) &&
            ((this.numPermisoSCT==null && other.getNumPermisoSCT()==null) || 
             (this.numPermisoSCT!=null &&
              this.numPermisoSCT.equals(other.getNumPermisoSCT()))) &&
            ((this.permSCT==null && other.getPermSCT()==null) || 
             (this.permSCT!=null &&
              this.permSCT.equals(other.getPermSCT()))) &&
            ((this.remolques==null && other.getRemolques()==null) || 
             (this.remolques!=null &&
              java.util.Arrays.equals(this.remolques, other.getRemolques()))) &&
            ((this.seguros==null && other.getSeguros()==null) || 
             (this.seguros!=null &&
              this.seguros.equals(other.getSeguros())));
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
        if (getIdentificacionVehicular() != null) {
            _hashCode += getIdentificacionVehicular().hashCode();
        }
        if (getNumPermisoSCT() != null) {
            _hashCode += getNumPermisoSCT().hashCode();
        }
        if (getPermSCT() != null) {
            _hashCode += getPermSCT().hashCode();
        }
        if (getRemolques() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRemolques());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRemolques(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeguros() != null) {
            _hashCode += getSeguros().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasAutotransporte20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporte20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificacionVehicular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IdentificacionVehicular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteIdentificacionVehicular20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPermisoSCT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumPermisoSCT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permSCT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PermSCT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remolques");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Remolques"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteRemolque20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seguros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Seguros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasAutotransporteSeguros20R"));
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
