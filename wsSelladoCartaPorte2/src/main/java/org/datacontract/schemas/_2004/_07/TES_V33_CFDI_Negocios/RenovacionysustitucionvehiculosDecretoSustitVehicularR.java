/**
 * RenovacionysustitucionvehiculosDecretoSustitVehicularR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class RenovacionysustitucionvehiculosDecretoSustitVehicularR  implements java.io.Serializable {
    private java.lang.String vehEnaj;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR vehiculoNuvoSemEnajenadoFabAlPerm;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR vehiculoUsadoEnajenadoPermAlFab;

    public RenovacionysustitucionvehiculosDecretoSustitVehicularR() {
    }

    public RenovacionysustitucionvehiculosDecretoSustitVehicularR(
           java.lang.String vehEnaj,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR vehiculoNuvoSemEnajenadoFabAlPerm,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR vehiculoUsadoEnajenadoPermAlFab) {
           this.vehEnaj = vehEnaj;
           this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
           this.vehiculoUsadoEnajenadoPermAlFab = vehiculoUsadoEnajenadoPermAlFab;
    }


    /**
     * Gets the vehEnaj value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @return vehEnaj
     */
    public java.lang.String getVehEnaj() {
        return vehEnaj;
    }


    /**
     * Sets the vehEnaj value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @param vehEnaj
     */
    public void setVehEnaj(java.lang.String vehEnaj) {
        this.vehEnaj = vehEnaj;
    }


    /**
     * Gets the vehiculoNuvoSemEnajenadoFabAlPerm value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @return vehiculoNuvoSemEnajenadoFabAlPerm
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR getVehiculoNuvoSemEnajenadoFabAlPerm() {
        return vehiculoNuvoSemEnajenadoFabAlPerm;
    }


    /**
     * Sets the vehiculoNuvoSemEnajenadoFabAlPerm value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @param vehiculoNuvoSemEnajenadoFabAlPerm
     */
    public void setVehiculoNuvoSemEnajenadoFabAlPerm(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR vehiculoNuvoSemEnajenadoFabAlPerm) {
        this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
    }


    /**
     * Gets the vehiculoUsadoEnajenadoPermAlFab value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @return vehiculoUsadoEnajenadoPermAlFab
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR getVehiculoUsadoEnajenadoPermAlFab() {
        return vehiculoUsadoEnajenadoPermAlFab;
    }


    /**
     * Sets the vehiculoUsadoEnajenadoPermAlFab value for this RenovacionysustitucionvehiculosDecretoSustitVehicularR.
     * 
     * @param vehiculoUsadoEnajenadoPermAlFab
     */
    public void setVehiculoUsadoEnajenadoPermAlFab(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RenovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR vehiculoUsadoEnajenadoPermAlFab) {
        this.vehiculoUsadoEnajenadoPermAlFab = vehiculoUsadoEnajenadoPermAlFab;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RenovacionysustitucionvehiculosDecretoSustitVehicularR)) return false;
        RenovacionysustitucionvehiculosDecretoSustitVehicularR other = (RenovacionysustitucionvehiculosDecretoSustitVehicularR) obj;
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
            ((this.vehiculoUsadoEnajenadoPermAlFab==null && other.getVehiculoUsadoEnajenadoPermAlFab()==null) || 
             (this.vehiculoUsadoEnajenadoPermAlFab!=null &&
              this.vehiculoUsadoEnajenadoPermAlFab.equals(other.getVehiculoUsadoEnajenadoPermAlFab())));
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
        if (getVehiculoUsadoEnajenadoPermAlFab() != null) {
            _hashCode += getVehiculoUsadoEnajenadoPermAlFab().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RenovacionysustitucionvehiculosDecretoSustitVehicularR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularR"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularVehiculoNuvoSemEnajenadoFabAlPermR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vehiculoUsadoEnajenadoPermAlFab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "VehiculoUsadoEnajenadoPermAlFab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "renovacionysustitucionvehiculosDecretoSustitVehicularVehiculoUsadoEnajenadoPermAlFabR"));
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
