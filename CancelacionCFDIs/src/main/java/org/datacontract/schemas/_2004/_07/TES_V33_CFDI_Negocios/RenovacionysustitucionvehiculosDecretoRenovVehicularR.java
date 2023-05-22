/**
 * RenovacionysustitucionvehiculosDecretoRenovVehicularR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RenovacionysustitucionvehiculosDecretoRenovVehicularR  implements java.io.Serializable {
    private java.lang.String vehEnaj;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR[] vehiculosUsadosEnajenadoPermAlFab;

    public RenovacionysustitucionvehiculosDecretoRenovVehicularR() {
    }

    public RenovacionysustitucionvehiculosDecretoRenovVehicularR(
           java.lang.String vehEnaj,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR[] vehiculosUsadosEnajenadoPermAlFab) {
           this.vehEnaj = vehEnaj;
           this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
           this.vehiculosUsadosEnajenadoPermAlFab = vehiculosUsadosEnajenadoPermAlFab;
    }


    /**
     * Gets the vehEnaj value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @return vehEnaj
     */
    public java.lang.String getVehEnaj() {
        return vehEnaj;
    }


    /**
     * Sets the vehEnaj value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @param vehEnaj
     */
    public void setVehEnaj(java.lang.String vehEnaj) {
        this.vehEnaj = vehEnaj;
    }


    /**
     * Gets the vehiculoNuvoSemEnajenadoFabAlPerm value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @return vehiculoNuvoSemEnajenadoFabAlPerm
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm getVehiculoNuvoSemEnajenadoFabAlPerm() {
        return vehiculoNuvoSemEnajenadoFabAlPerm;
    }


    /**
     * Sets the vehiculoNuvoSemEnajenadoFabAlPerm value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @param vehiculoNuvoSemEnajenadoFabAlPerm
     */
    public void setVehiculoNuvoSemEnajenadoFabAlPerm(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm) {
        this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
    }


    /**
     * Gets the vehiculosUsadosEnajenadoPermAlFab value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @return vehiculosUsadosEnajenadoPermAlFab
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR[] getVehiculosUsadosEnajenadoPermAlFab() {
        return vehiculosUsadosEnajenadoPermAlFab;
    }


    /**
     * Sets the vehiculosUsadosEnajenadoPermAlFab value for this RenovacionysustitucionvehiculosDecretoRenovVehicularR.
     * 
     * @param vehiculosUsadosEnajenadoPermAlFab
     */
    public void setVehiculosUsadosEnajenadoPermAlFab(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR[] vehiculosUsadosEnajenadoPermAlFab) {
        this.vehiculosUsadosEnajenadoPermAlFab = vehiculosUsadosEnajenadoPermAlFab;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenovacionysustitucionvehiculosDecretoRenovVehicularR)) return false;
        RenovacionysustitucionvehiculosDecretoRenovVehicularR other = (RenovacionysustitucionvehiculosDecretoRenovVehicularR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vehEnaj==null && other.getVehEnaj()==null) || 
             (this.vehEnaj!=null &&
              this.vehEnaj.equals(other.getVehEnaj()))) &&
            ((this.vehiculoNuvoSemEnajenadoFabAlPerm==null && other.getVehiculoNuvoSemEnajenadoFabAlPerm()==null) || 
             (this.vehiculoNuvoSemEnajenadoFabAlPerm!=null &&
              this.vehiculoNuvoSemEnajenadoFabAlPerm.equals(other.getVehiculoNuvoSemEnajenadoFabAlPerm()))) &&
            ((this.vehiculosUsadosEnajenadoPermAlFab==null && other.getVehiculosUsadosEnajenadoPermAlFab()==null) || 
             (this.vehiculosUsadosEnajenadoPermAlFab!=null &&
              java.util.Arrays.equals(this.vehiculosUsadosEnajenadoPermAlFab, other.getVehiculosUsadosEnajenadoPermAlFab())));
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
        if (getVehEnaj() != null) {
            _hashCode += getVehEnaj().hashCode();
        }
        if (getVehiculoNuvoSemEnajenadoFabAlPerm() != null) {
            _hashCode += getVehiculoNuvoSemEnajenadoFabAlPerm().hashCode();
        }
        if (getVehiculosUsadosEnajenadoPermAlFab() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVehiculosUsadosEnajenadoPermAlFab());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVehiculosUsadosEnajenadoPermAlFab(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RenovacionysustitucionvehiculosDecretoRenovVehicularR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehEnaj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehEnaj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoNuvoSemEnajenadoFabAlPerm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoNuvoSemEnajenadoFabAlPerm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculoNuvoSemEnajenadoFabAlPerm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculosUsadosEnajenadoPermAlFab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculosUsadosEnajenadoPermAlFab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoRenovVehicularVehiculosUsadosEnajenadoPermAlFabR"));
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
