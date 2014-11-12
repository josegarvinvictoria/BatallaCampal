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

    abstract void mouSoldat(int ubicacio, Main pissarra, Campbatalla campbatalla);

    abstract boolean soldatToca(final SoldatGeneral oponent);

    void PosatA(double x, double y){
        this.getImatge().setLocation(x, y);
    }
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
     * Mètode per obtenir l'alçada d'un soldat.
     */
    public double obtenirHeight(){
        return this.getImatge().getHeight();
    }

    /**
     * Mètode per obtenir l'amplada d'un soldat.
     */
    public double obtenirWidth(){
        return this.getImatge().getWidth();
    }

    /**
     * Mètode per obtenir la x actual del soldat.
     */
    public double obtenirX(){
        return this.getImatge().getX();
    }

    /**
     * Mètode per obtenir la y actual del soldat.
     */
    public double obtenirY(){
        return this.getImatge().getY();
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
