/**
 * CartaPorteMercanciasMercancia20R.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios;

public class CartaPorteMercanciasMercancia20R  implements java.io.Serializable {
    private java.lang.String bienesTransp;

    private java.math.BigDecimal cantidad;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R[] cantidadTransporta;

    private java.lang.String claveSTCC;

    private java.lang.String claveUnidad;

    private java.lang.String cveMaterialPeligroso;

    private java.lang.String descripEmbalaje;

    private java.lang.String descripcion;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R detalleMercancia;

    private java.lang.String dimensiones;

    private java.lang.String embalaje;

    private java.lang.String fraccionArancelaria;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[] guiasIdentificacion;

    private java.lang.String materialPeligroso;

    private java.lang.String moneda;

    private org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R[] pedimentos;

    private java.math.BigDecimal pesoEnKg;

    private java.lang.String UUIDComercioExt;

    private java.lang.String unidad;

    private java.math.BigDecimal valorMercancia;

    public CartaPorteMercanciasMercancia20R() {
    }

    public CartaPorteMercanciasMercancia20R(
           java.lang.String bienesTransp,
           java.math.BigDecimal cantidad,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R[] cantidadTransporta,
           java.lang.String claveSTCC,
           java.lang.String claveUnidad,
           java.lang.String cveMaterialPeligroso,
           java.lang.String descripEmbalaje,
           java.lang.String descripcion,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R detalleMercancia,
           java.lang.String dimensiones,
           java.lang.String embalaje,
           java.lang.String fraccionArancelaria,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[] guiasIdentificacion,
           java.lang.String materialPeligroso,
           java.lang.String moneda,
           org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R[] pedimentos,
           java.math.BigDecimal pesoEnKg,
           java.lang.String UUIDComercioExt,
           java.lang.String unidad,
           java.math.BigDecimal valorMercancia) {
           this.bienesTransp = bienesTransp;
           this.cantidad = cantidad;
           this.cantidadTransporta = cantidadTransporta;
           this.claveSTCC = claveSTCC;
           this.claveUnidad = claveUnidad;
           this.cveMaterialPeligroso = cveMaterialPeligroso;
           this.descripEmbalaje = descripEmbalaje;
           this.descripcion = descripcion;
           this.detalleMercancia = detalleMercancia;
           this.dimensiones = dimensiones;
           this.embalaje = embalaje;
           this.fraccionArancelaria = fraccionArancelaria;
           this.guiasIdentificacion = guiasIdentificacion;
           this.materialPeligroso = materialPeligroso;
           this.moneda = moneda;
           this.pedimentos = pedimentos;
           this.pesoEnKg = pesoEnKg;
           this.UUIDComercioExt = UUIDComercioExt;
           this.unidad = unidad;
           this.valorMercancia = valorMercancia;
    }


    /**
     * Gets the bienesTransp value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return bienesTransp
     */
    public java.lang.String getBienesTransp() {
        return bienesTransp;
    }


    /**
     * Sets the bienesTransp value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param bienesTransp
     */
    public void setBienesTransp(java.lang.String bienesTransp) {
        this.bienesTransp = bienesTransp;
    }


    /**
     * Gets the cantidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return cantidad
     */
    public java.math.BigDecimal getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param cantidad
     */
    public void setCantidad(java.math.BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the cantidadTransporta value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return cantidadTransporta
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R[] getCantidadTransporta() {
        return cantidadTransporta;
    }


    /**
     * Sets the cantidadTransporta value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param cantidadTransporta
     */
    public void setCantidadTransporta(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R[] cantidadTransporta) {
        this.cantidadTransporta = cantidadTransporta;
    }


    /**
     * Gets the claveSTCC value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return claveSTCC
     */
    public java.lang.String getClaveSTCC() {
        return claveSTCC;
    }


    /**
     * Sets the claveSTCC value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param claveSTCC
     */
    public void setClaveSTCC(java.lang.String claveSTCC) {
        this.claveSTCC = claveSTCC;
    }


    /**
     * Gets the claveUnidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return claveUnidad
     */
    public java.lang.String getClaveUnidad() {
        return claveUnidad;
    }


    /**
     * Sets the claveUnidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param claveUnidad
     */
    public void setClaveUnidad(java.lang.String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }


    /**
     * Gets the cveMaterialPeligroso value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return cveMaterialPeligroso
     */
    public java.lang.String getCveMaterialPeligroso() {
        return cveMaterialPeligroso;
    }


    /**
     * Sets the cveMaterialPeligroso value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param cveMaterialPeligroso
     */
    public void setCveMaterialPeligroso(java.lang.String cveMaterialPeligroso) {
        this.cveMaterialPeligroso = cveMaterialPeligroso;
    }


    /**
     * Gets the descripEmbalaje value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return descripEmbalaje
     */
    public java.lang.String getDescripEmbalaje() {
        return descripEmbalaje;
    }


    /**
     * Sets the descripEmbalaje value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param descripEmbalaje
     */
    public void setDescripEmbalaje(java.lang.String descripEmbalaje) {
        this.descripEmbalaje = descripEmbalaje;
    }


    /**
     * Gets the descripcion value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the detalleMercancia value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return detalleMercancia
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R getDetalleMercancia() {
        return detalleMercancia;
    }


    /**
     * Sets the detalleMercancia value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param detalleMercancia
     */
    public void setDetalleMercancia(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R detalleMercancia) {
        this.detalleMercancia = detalleMercancia;
    }


    /**
     * Gets the dimensiones value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return dimensiones
     */
    public java.lang.String getDimensiones() {
        return dimensiones;
    }


    /**
     * Sets the dimensiones value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param dimensiones
     */
    public void setDimensiones(java.lang.String dimensiones) {
        this.dimensiones = dimensiones;
    }


    /**
     * Gets the embalaje value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return embalaje
     */
    public java.lang.String getEmbalaje() {
        return embalaje;
    }


    /**
     * Sets the embalaje value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param embalaje
     */
    public void setEmbalaje(java.lang.String embalaje) {
        this.embalaje = embalaje;
    }


    /**
     * Gets the fraccionArancelaria value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return fraccionArancelaria
     */
    public java.lang.String getFraccionArancelaria() {
        return fraccionArancelaria;
    }


    /**
     * Sets the fraccionArancelaria value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param fraccionArancelaria
     */
    public void setFraccionArancelaria(java.lang.String fraccionArancelaria) {
        this.fraccionArancelaria = fraccionArancelaria;
    }


    /**
     * Gets the guiasIdentificacion value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return guiasIdentificacion
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[] getGuiasIdentificacion() {
        return guiasIdentificacion;
    }


    /**
     * Sets the guiasIdentificacion value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param guiasIdentificacion
     */
    public void setGuiasIdentificacion(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaGuiasIdentificacion20R[] guiasIdentificacion) {
        this.guiasIdentificacion = guiasIdentificacion;
    }


    /**
     * Gets the materialPeligroso value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return materialPeligroso
     */
    public java.lang.String getMaterialPeligroso() {
        return materialPeligroso;
    }


    /**
     * Sets the materialPeligroso value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param materialPeligroso
     */
    public void setMaterialPeligroso(java.lang.String materialPeligroso) {
        this.materialPeligroso = materialPeligroso;
    }


    /**
     * Gets the moneda value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return moneda
     */
    public java.lang.String getMoneda() {
        return moneda;
    }


    /**
     * Sets the moneda value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param moneda
     */
    public void setMoneda(java.lang.String moneda) {
        this.moneda = moneda;
    }


    /**
     * Gets the pedimentos value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return pedimentos
     */
    public org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R[] getPedimentos() {
        return pedimentos;
    }


    /**
     * Sets the pedimentos value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param pedimentos
     */
    public void setPedimentos(org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaPedimentos20R[] pedimentos) {
        this.pedimentos = pedimentos;
    }


    /**
     * Gets the pesoEnKg value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return pesoEnKg
     */
    public java.math.BigDecimal getPesoEnKg() {
        return pesoEnKg;
    }


    /**
     * Sets the pesoEnKg value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param pesoEnKg
     */
    public void setPesoEnKg(java.math.BigDecimal pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }


    /**
     * Gets the UUIDComercioExt value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return UUIDComercioExt
     */
    public java.lang.String getUUIDComercioExt() {
        return UUIDComercioExt;
    }


    /**
     * Sets the UUIDComercioExt value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param UUIDComercioExt
     */
    public void setUUIDComercioExt(java.lang.String UUIDComercioExt) {
        this.UUIDComercioExt = UUIDComercioExt;
    }


    /**
     * Gets the unidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return unidad
     */
    public java.lang.String getUnidad() {
        return unidad;
    }


    /**
     * Sets the unidad value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param unidad
     */
    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }


    /**
     * Gets the valorMercancia value for this CartaPorteMercanciasMercancia20R.
     * 
     * @return valorMercancia
     */
    public java.math.BigDecimal getValorMercancia() {
        return valorMercancia;
    }


    /**
     * Sets the valorMercancia value for this CartaPorteMercanciasMercancia20R.
     * 
     * @param valorMercancia
     */
    public void setValorMercancia(java.math.BigDecimal valorMercancia) {
        this.valorMercancia = valorMercancia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CartaPorteMercanciasMercancia20R)) return false;
        CartaPorteMercanciasMercancia20R other = (CartaPorteMercanciasMercancia20R) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bienesTransp==null && other.getBienesTransp()==null) || 
             (this.bienesTransp!=null &&
              this.bienesTransp.equals(other.getBienesTransp()))) &&
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.cantidadTransporta==null && other.getCantidadTransporta()==null) || 
             (this.cantidadTransporta!=null &&
              java.util.Arrays.equals(this.cantidadTransporta, other.getCantidadTransporta()))) &&
            ((this.claveSTCC==null && other.getClaveSTCC()==null) || 
             (this.claveSTCC!=null &&
              this.claveSTCC.equals(other.getClaveSTCC()))) &&
            ((this.claveUnidad==null && other.getClaveUnidad()==null) || 
             (this.claveUnidad!=null &&
              this.claveUnidad.equals(other.getClaveUnidad()))) &&
            ((this.cveMaterialPeligroso==null && other.getCveMaterialPeligroso()==null) || 
             (this.cveMaterialPeligroso!=null &&
              this.cveMaterialPeligroso.equals(other.getCveMaterialPeligroso()))) &&
            ((this.descripEmbalaje==null && other.getDescripEmbalaje()==null) || 
             (this.descripEmbalaje!=null &&
              this.descripEmbalaje.equals(other.getDescripEmbalaje()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.detalleMercancia==null && other.getDetalleMercancia()==null) || 
             (this.detalleMercancia!=null &&
              this.detalleMercancia.equals(other.getDetalleMercancia()))) &&
            ((this.dimensiones==null && other.getDimensiones()==null) || 
             (this.dimensiones!=null &&
              this.dimensiones.equals(other.getDimensiones()))) &&
            ((this.embalaje==null && other.getEmbalaje()==null) || 
             (this.embalaje!=null &&
              this.embalaje.equals(other.getEmbalaje()))) &&
            ((this.fraccionArancelaria==null && other.getFraccionArancelaria()==null) || 
             (this.fraccionArancelaria!=null &&
              this.fraccionArancelaria.equals(other.getFraccionArancelaria()))) &&
            ((this.guiasIdentificacion==null && other.getGuiasIdentificacion()==null) || 
             (this.guiasIdentificacion!=null &&
              java.util.Arrays.equals(this.guiasIdentificacion, other.getGuiasIdentificacion()))) &&
            ((this.materialPeligroso==null && other.getMaterialPeligroso()==null) || 
             (this.materialPeligroso!=null &&
              this.materialPeligroso.equals(other.getMaterialPeligroso()))) &&
            ((this.moneda==null && other.getMoneda()==null) || 
             (this.moneda!=null &&
              this.moneda.equals(other.getMoneda()))) &&
            ((this.pedimentos==null && other.getPedimentos()==null) || 
             (this.pedimentos!=null &&
              java.util.Arrays.equals(this.pedimentos, other.getPedimentos()))) &&
            ((this.pesoEnKg==null && other.getPesoEnKg()==null) || 
             (this.pesoEnKg!=null &&
              this.pesoEnKg.equals(other.getPesoEnKg()))) &&
            ((this.UUIDComercioExt==null && other.getUUIDComercioExt()==null) || 
             (this.UUIDComercioExt!=null &&
              this.UUIDComercioExt.equals(other.getUUIDComercioExt()))) &&
            ((this.unidad==null && other.getUnidad()==null) || 
             (this.unidad!=null &&
              this.unidad.equals(other.getUnidad()))) &&
            ((this.valorMercancia==null && other.getValorMercancia()==null) || 
             (this.valorMercancia!=null &&
              this.valorMercancia.equals(other.getValorMercancia())));
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
        if (getBienesTransp() != null) {
            _hashCode += getBienesTransp().hashCode();
        }
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getCantidadTransporta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCantidadTransporta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCantidadTransporta(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClaveSTCC() != null) {
            _hashCode += getClaveSTCC().hashCode();
        }
        if (getClaveUnidad() != null) {
            _hashCode += getClaveUnidad().hashCode();
        }
        if (getCveMaterialPeligroso() != null) {
            _hashCode += getCveMaterialPeligroso().hashCode();
        }
        if (getDescripEmbalaje() != null) {
            _hashCode += getDescripEmbalaje().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDetalleMercancia() != null) {
            _hashCode += getDetalleMercancia().hashCode();
        }
        if (getDimensiones() != null) {
            _hashCode += getDimensiones().hashCode();
        }
        if (getEmbalaje() != null) {
            _hashCode += getEmbalaje().hashCode();
        }
        if (getFraccionArancelaria() != null) {
            _hashCode += getFraccionArancelaria().hashCode();
        }
        if (getGuiasIdentificacion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuiasIdentificacion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuiasIdentificacion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMaterialPeligroso() != null) {
            _hashCode += getMaterialPeligroso().hashCode();
        }
        if (getMoneda() != null) {
            _hashCode += getMoneda().hashCode();
        }
        if (getPedimentos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPedimentos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPedimentos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPesoEnKg() != null) {
            _hashCode += getPesoEnKg().hashCode();
        }
        if (getUUIDComercioExt() != null) {
            _hashCode += getUUIDComercioExt().hashCode();
        }
        if (getUnidad() != null) {
            _hashCode += getUnidad().hashCode();
        }
        if (getValorMercancia() != null) {
            _hashCode += getValorMercancia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CartaPorteMercanciasMercancia20R.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercancia20R"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bienesTransp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "BienesTransp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadTransporta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CantidadTransporta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaCantidadTransporta20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveSTCC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveSTCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveUnidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ClaveUnidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cveMaterialPeligroso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CveMaterialPeligroso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripEmbalaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DescripEmbalaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detalleMercancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "DetalleMercancia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaDetalleMercancia20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dimensiones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Dimensiones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("embalaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Embalaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraccionArancelaria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "FraccionArancelaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guiasIdentificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "GuiasIdentificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaGuiasIdentificacion20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("materialPeligroso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "MaterialPeligroso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moneda");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Moneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pedimentos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Pedimentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaPedimentos20R"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "CartaPorteMercanciasMercanciaPedimentos20R"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoEnKg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "PesoEnKg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUIDComercioExt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "UUIDComercioExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidad");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "Unidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorMercancia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/TES.V33.CFDI.Negocios", "ValorMercancia"));
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
