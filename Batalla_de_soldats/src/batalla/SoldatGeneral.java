package batalla;

import acm.graphics.GImage;

/**
 * Classe abstracta d'objectes "Soldat".
 *
 * @author Jose Garvin Victoria
 *
 */
public abstract class SoldatGeneral {

    /**
     * Declaració de variables.
     */
    int VELOCITATE;
    int VELOCITATD;
    GImage imatge;
    boolean haArribat;

    /**
     * Constructor Soldats.
     *
     * @param imatgeS
     */
    public SoldatGeneral(GImage imatgeS) {
        this.imatge = imatgeS;
    }

    /**
     * Declaració dels mètodes.
     */

    abstract void mouSoldat(int ubicacio, Main camp);

    abstract boolean soldatToca(final SoldatGeneral oponent);
    /**
     * Metode per reinicialitzar un soldat.
     */
    void reinicialitzaSoldat() {
        if (this.haArribat) {
            this.haArribat = false;
        } else {
            this.haArribat = true;
        }

    }

    /**
     * Mètode per obtenir la imatge de un soldat.
     *
     * @return --> Retorna una imatge de tipus "GImage".
     */
    GImage getImatge() {
        return imatge;
    }

    /**
     * Mètode per assignar una imatge a un soldat.
     *
     * @param imatgeS
     *            --> Imatge o aspecte a assignar.
     */
    final void setImatge(final GImage imatgeS) {
        this.imatge = imatgeS;
    }

    /**
     * Mètode per controlar si un soldat ha arribat al final del trajecte.
     *
     * @return --> Retorna True si ha arribat / False si no ha arribat.
     */
    final boolean isHaArribat() {
        return haArribat;
    }

    /**
     * Mètode per canviar canviar la propietat "haArribat" d'un soldat.
     *
     * @param haArribatAlDesti
     *            --> true: soldat ha arribat false: soldat no ha arribat.
     */
    final void setHaArribat(final boolean haArribatAlDesti) {
        this.haArribat = haArribatAlDesti;
    }

    public int getVELOCITATE() {
        return VELOCITATE;
    }

    public void setVELOCITATE(int vELOCITATE) {
        VELOCITATE = vELOCITATE;
    }

    public int getVELOCITATD() {
        return VELOCITATD;
    }

    public void setVELOCITATD(int vELOCITATD) {
        VELOCITATD = vELOCITATD;
    }


}
