/**
 * Nomina12R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class Nomina12R  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R deduccionesNomina12R;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R emisorNomina12R;

    private java.util.Calendar fechaFinalPago;

    private java.util.Calendar fechaInicialPago;

    private java.util.Calendar fechaPago;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R[] incapacidadesNomina;

    private java.math.BigDecimal numDiasPagados;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R[] otrosPagos;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R percepcionesNomina12R;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R receptorNomina12R;

    private java.lang.String tipoNomina;

    private java.math.BigDecimal totalDeducciones;

    private java.math.BigDecimal totalOtrosPagos;

    private java.math.BigDecimal totalPercepciones;

    public Nomina12R() {
    }

    public Nomina12R(
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R deduccionesNomina12R,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R emisorNomina12R,
           java.util.Calendar fechaFinalPago,
           java.util.Calendar fechaInicialPago,
           java.util.Calendar fechaPago,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R[] incapacidadesNomina,
           java.math.BigDecimal numDiasPagados,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R[] otrosPagos,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R percepcionesNomina12R,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R receptorNomina12R,
           java.lang.String tipoNomina,
           java.math.BigDecimal totalDeducciones,
           java.math.BigDecimal totalOtrosPagos,
           java.math.BigDecimal totalPercepciones) {
           this.deduccionesNomina12R = deduccionesNomina12R;
           this.emisorNomina12R = emisorNomina12R;
           this.fechaFinalPago = fechaFinalPago;
           this.fechaInicialPago = fechaInicialPago;
           this.fechaPago = fechaPago;
           this.incapacidadesNomina = incapacidadesNomina;
           this.numDiasPagados = numDiasPagados;
           this.otrosPagos = otrosPagos;
           this.percepcionesNomina12R = percepcionesNomina12R;
           this.receptorNomina12R = receptorNomina12R;
           this.tipoNomina = tipoNomina;
           this.totalDeducciones = totalDeducciones;
           this.totalOtrosPagos = totalOtrosPagos;
           this.totalPercepciones = totalPercepciones;
    }


    /**
     * Gets the deduccionesNomina12R value for this Nomina12R.
     * 
     * @return deduccionesNomina12R
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R getDeduccionesNomina12R() {
        return deduccionesNomina12R;
    }


    /**
     * Sets the deduccionesNomina12R value for this Nomina12R.
     * 
     * @param deduccionesNomina12R
     */
    public void setDeduccionesNomina12R(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DeduccionesNomina12R deduccionesNomina12R) {
        this.deduccionesNomina12R = deduccionesNomina12R;
    }


    /**
     * Gets the emisorNomina12R value for this Nomina12R.
     * 
     * @return emisorNomina12R
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R getEmisorNomina12R() {
        return emisorNomina12R;
    }


    /**
     * Sets the emisorNomina12R value for this Nomina12R.
     * 
     * @param emisorNomina12R
     */
    public void setEmisorNomina12R(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorNomina12R emisorNomina12R) {
        this.emisorNomina12R = emisorNomina12R;
    }


    /**
     * Gets the fechaFinalPago value for this Nomina12R.
     * 
     * @return fechaFinalPago
     */
    public java.util.Calendar getFechaFinalPago() {
        return fechaFinalPago;
    }


    /**
     * Sets the fechaFinalPago value for this Nomina12R.
     * 
     * @param fechaFinalPago
     */
    public void setFechaFinalPago(java.util.Calendar fechaFinalPago) {
        this.fechaFinalPago = fechaFinalPago;
    }


    /**
     * Gets the fechaInicialPago value for this Nomina12R.
     * 
     * @return fechaInicialPago
     */
    public java.util.Calendar getFechaInicialPago() {
        return fechaInicialPago;
    }


    /**
     * Sets the fechaInicialPago value for this Nomina12R.
     * 
     * @param fechaInicialPago
     */
    public void setFechaInicialPago(java.util.Calendar fechaInicialPago) {
        this.fechaInicialPago = fechaInicialPago;
    }


    /**
     * Gets the fechaPago value for this Nomina12R.
     * 
     * @return fechaPago
     */
    public java.util.Calendar getFechaPago() {
        return fechaPago;
    }


    /**
     * Sets the fechaPago value for this Nomina12R.
     * 
     * @param fechaPago
     */
    public void setFechaPago(java.util.Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }


    /**
     * Gets the incapacidadesNomina value for this Nomina12R.
     * 
     * @return incapacidadesNomina
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R[] getIncapacidadesNomina() {
        return incapacidadesNomina;
    }


    /**
     * Sets the incapacidadesNomina value for this Nomina12R.
     * 
     * @param incapacidadesNomina
     */
    public void setIncapacidadesNomina(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.IncapacidadNomina12R[] incapacidadesNomina) {
        this.incapacidadesNomina = incapacidadesNomina;
    }


    /**
     * Gets the numDiasPagados value for this Nomina12R.
     * 
     * @return numDiasPagados
     */
    public java.math.BigDecimal getNumDiasPagados() {
        return numDiasPagados;
    }


    /**
     * Sets the numDiasPagados value for this Nomina12R.
     * 
     * @param numDiasPagados
     */
    public void setNumDiasPagados(java.math.BigDecimal numDiasPagados) {
        this.numDiasPagados = numDiasPagados;
    }


    /**
     * Gets the otrosPagos value for this Nomina12R.
     * 
     * @return otrosPagos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R[] getOtrosPagos() {
        return otrosPagos;
    }


    /**
     * Sets the otrosPagos value for this Nomina12R.
     * 
     * @param otrosPagos
     */
    public void setOtrosPagos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.OtroPagoNomina12R[] otrosPagos) {
        this.otrosPagos = otrosPagos;
    }


    /**
     * Gets the percepcionesNomina12R value for this Nomina12R.
     * 
     * @return percepcionesNomina12R
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R getPercepcionesNomina12R() {
        return percepcionesNomina12R;
    }


    /**
     * Sets the percepcionesNomina12R value for this Nomina12R.
     * 
     * @param percepcionesNomina12R
     */
    public void setPercepcionesNomina12R(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.PercepcionesNomina12R percepcionesNomina12R) {
        this.percepcionesNomina12R = percepcionesNomina12R;
    }


    /**
     * Gets the receptorNomina12R value for this Nomina12R.
     * 
     * @return receptorNomina12R
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R getReceptorNomina12R() {
        return receptorNomina12R;
    }


    /**
     * Sets the receptorNomina12R value for this Nomina12R.
     * 
     * @param receptorNomina12R
     */
    public void setReceptorNomina12R(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorNomina12R receptorNomina12R) {
        this.receptorNomina12R = receptorNomina12R;
    }


    /**
     * Gets the tipoNomina value for this Nomina12R.
     * 
     * @return tipoNomina
     */
    public java.lang.String getTipoNomina() {
        return tipoNomina;
    }


    /**
     * Sets the tipoNomina value for this Nomina12R.
     * 
     * @param tipoNomina
     */
    public void setTipoNomina(java.lang.String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }


    /**
     * Gets the totalDeducciones value for this Nomina12R.
     * 
     * @return totalDeducciones
     */
    public java.math.BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }


    /**
     * Sets the totalDeducciones value for this Nomina12R.
     * 
     * @param totalDeducciones
     */
    public void setTotalDeducciones(java.math.BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }


    /**
     * Gets the totalOtrosPagos value for this Nomina12R.
     * 
     * @return totalOtrosPagos
     */
    public java.math.BigDecimal getTotalOtrosPagos() {
        return totalOtrosPagos;
    }


    /**
     * Sets the totalOtrosPagos value for this Nomina12R.
     * 
     * @param totalOtrosPagos
     */
    public void setTotalOtrosPagos(java.math.BigDecimal totalOtrosPagos) {
        this.totalOtrosPagos = totalOtrosPagos;
    }


    /**
     * Gets the totalPercepciones value for this Nomina12R.
     * 
     * @return totalPercepciones
     */
    public java.math.BigDecimal getTotalPercepciones() {
        return totalPercepciones;
    }


    /**
     * Sets the totalPercepciones value for this Nomina12R.
     * 
     * @param totalPercepciones
     */
    public void setTotalPercepciones(java.math.BigDecimal totalPercepciones) {
        this.totalPercepciones = totalPercepciones;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Nomina12R)) return false;
        Nomina12R other = (Nomina12R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deduccionesNomina12R==null && other.getDeduccionesNomina12R()==null) || 
             (this.deduccionesNomina12R!=null &&
              this.deduccionesNomina12R.equals(other.getDeduccionesNomina12R()))) &&
            ((this.emisorNomina12R==null && other.getEmisorNomina12R()==null) || 
             (this.emisorNomina12R!=null &&
              this.emisorNomina12R.equals(other.getEmisorNomina12R()))) &&
            ((this.fechaFinalPago==null && other.getFechaFinalPago()==null) || 
             (this.fechaFinalPago!=null &&
              this.fechaFinalPago.equals(other.getFechaFinalPago()))) &&
            ((this.fechaInicialPago==null && other.getFechaInicialPago()==null) || 
             (this.fechaInicialPago!=null &&
              this.fechaInicialPago.equals(other.getFechaInicialPago()))) &&
            ((this.fechaPago==null && other.getFechaPago()==null) || 
             (this.fechaPago!=null &&
              this.fechaPago.equals(other.getFechaPago()))) &&
            ((this.incapacidadesNomina==null && other.getIncapacidadesNomina()==null) || 
             (this.incapacidadesNomina!=null &&
              java.util.Arrays.equals(this.incapacidadesNomina, other.getIncapacidadesNomina()))) &&
            ((this.numDiasPagados==null && other.getNumDiasPagados()==null) || 
             (this.numDiasPagados!=null &&
              this.numDiasPagados.equals(other.getNumDiasPagados()))) &&
            ((this.otrosPagos==null && other.getOtrosPagos()==null) || 
             (this.otrosPagos!=null &&
              java.util.Arrays.equals(this.otrosPagos, other.getOtrosPagos()))) &&
            ((this.percepcionesNomina12R==null && other.getPercepcionesNomina12R()==null) || 
             (this.percepcionesNomina12R!=null &&
              this.percepcionesNomina12R.equals(other.getPercepcionesNomina12R()))) &&
            ((this.receptorNomina12R==null && other.getReceptorNomina12R()==null) || 
             (this.receptorNomina12R!=null &&
              this.receptorNomina12R.equals(other.getReceptorNomina12R()))) &&
            ((this.tipoNomina==null && other.getTipoNomina()==null) || 
             (this.tipoNomina!=null &&
              this.tipoNomina.equals(other.getTipoNomina()))) &&
            ((this.totalDeducciones==null && other.getTotalDeducciones()==null) || 
             (this.totalDeducciones!=null &&
              this.totalDeducciones.equals(other.getTotalDeducciones()))) &&
            ((this.totalOtrosPagos==null && other.getTotalOtrosPagos()==null) || 
             (this.totalOtrosPagos!=null &&
              this.totalOtrosPagos.equals(other.getTotalOtrosPagos()))) &&
            ((this.totalPercepciones==null && other.getTotalPercepciones()==null) || 
             (this.totalPercepciones!=null &&
              this.totalPercepciones.equals(other.getTotalPercepciones())));
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
        if (getDeduccionesNomina12R() != null) {
            _hashCode += getDeduccionesNomina12R().hashCode();
        }
        if (getEmisorNomina12R() != null) {
            _hashCode += getEmisorNomina12R().hashCode();
        }
        if (getFechaFinalPago() != null) {
            _hashCode += getFechaFinalPago().hashCode();
        }
        if (getFechaInicialPago() != null) {
            _hashCode += getFechaInicialPago().hashCode();
        }
        if (getFechaPago() != null) {
            _hashCode += getFechaPago().hashCode();
        }
        if (getIncapacidadesNomina() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIncapacidadesNomina());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIncapacidadesNomina(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumDiasPagados() != null) {
            _hashCode += getNumDiasPagados().hashCode();
        }
        if (getOtrosPagos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOtrosPagos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOtrosPagos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPercepcionesNomina12R() != null) {
            _hashCode += getPercepcionesNomina12R().hashCode();
        }
        if (getReceptorNomina12R() != null) {
            _hashCode += getReceptorNomina12R().hashCode();
        }
        if (getTipoNomina() != null) {
            _hashCode += getTipoNomina().hashCode();
        }
        if (getTotalDeducciones() != null) {
            _hashCode += getTotalDeducciones().hashCode();
        }
        if (getTotalOtrosPagos() != null) {
            _hashCode += getTotalOtrosPagos().hashCode();
        }
        if (getTotalPercepciones() != null) {
            _hashCode += getTotalPercepciones().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Nomina12R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Nomina12R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deduccionesNomina12R");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionesNomina12R"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DeduccionesNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisorNomina12R");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorNomina12R"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "EmisorNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFinalPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaFinalPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicialPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaInicialPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FechaPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incapacidadesNomina");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadesNomina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "IncapacidadNomina12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numDiasPagados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "NumDiasPagados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otrosPagos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtrosPagos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "OtroPagoNomina12R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percepcionesNomina12R");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PercepcionesNomina12R"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PercepcionesNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptorNomina12R");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReceptorNomina12R"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ReceptorNomina12R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoNomina");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TipoNomina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalDeducciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalDeducciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalOtrosPagos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalOtrosPagos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPercepciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "TotalPercepciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
