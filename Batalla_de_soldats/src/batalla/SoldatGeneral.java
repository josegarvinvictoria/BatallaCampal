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
     * Velocitat del soldat quan mou cap a l'esquerra.
     */
    private int velocitatE;

    /**
     * Velocitat del soldat quan es mou cap a la dreta.
     */
    private int velocitatD;

    /**
     * Imatge del soldat.
     */
    private GImage imatge;

    /**
     * Boolean que ens indica true o false depenent de si el soldat ha arribat o
     * no al final de la finestra.
     */
    private boolean haArribat;

    /**
     * Vides dels soldat.
     */
    private int vides;

    /**
     * Constructor d'objectes "SoldatGeneral".
     *
     * @param imatgeS
     *            --> Imatge del soldat.
     */
    public SoldatGeneral(final GImage imatgeS) {
        this.imatge = imatgeS;
    }

    /**
     * Mètode abstracte per moure objectes de tipus "SoldatGeneral".
     *
     * @param ubicacio
     *            --> Ubicació de l'exercit, -1 Esquerra/ 1 Dreta.
     * @param main
     *            --> Finestra on s'haura de moure l'objecte.
     * @param camp
     *            --> L'utilitzo per recollir les mesures del camp de batalla.
     */
    abstract void mouSoldat(final int ubicacio, final Main main,
            final Campbatalla camp);

    /**
     * Mètode per determinar si un soldat té vides o no. Aquest mètode resta una
     * vida al soldat cada cop que s'utiltiza.
     *
     * @return --> Retorna true quan el soldat té vides, o false, en el cas de
     *         que el soldat s'hagi quedat sense vides.
     */
    final boolean teVides() {
        vides--;
        if (vides == 0) {
            return false;
        }
        return true;
    }

    /**
     * Mètode per determinar si un soldat es toca amb una oponent.
     *
     * @param oponent
     *            --> Soldat de l'exercit enemic.
     * @return --> Retorna true si els soldats toquen
     */
    final boolean soldatToca(final SoldatGeneral oponent) {
        boolean toca = this.getImatge().getBounds()
                .intersects(oponent.getImatge().getBounds());
        if (toca) {
            return true;
        }
        return false;
    }

    /**
     * Mètode per posicionar la imatge d'un soldat al camp de batalla.
     *
     * @param x
     *            --> Posicio X.
     * @param y
     *            --> Posicio Y.
     */
    final void posatA(final double x, final double y) {
        this.getImatge().setLocation(x, y);
    }

    /**
     * Mètode per canviar la propietat haArribat dels soldats en el moment que
     * arriben al seu destí.
     */
    final void reinicialitzaSoldat() {
        if (this.haArribat) {
            this.haArribat = false;
        } else {
            this.haArribat = true;
        }

    }

    /**
     * Mètode per invertir l'imatge d'un soldat.
     */
    final void flipHorizontal() {
        int[][] array = imatge.getPixelArray();
        int height = array.length;
        int width = array[0].length;

        for (int y = 0; y < height; y++) {
            for (int x1 = 0; x1 < width / 2; x1++) {
                int x2 = width - x1 - 1;
                int temp = array[y][x1];
                array[y][x1] = array[y][x2];
                array[y][x2] = temp;
            }
        }
        imatge.setImage(new GImage(array).getImage());
    }

    /**
     * Mètode per obtenir l'alçada d'un soldat.
     *
     * @return --> Retorna un double corresponent a l'alçada de l'imatge del
     *         soldat.
     */
    final double obtenirHeight() {
        return this.getImatge().getHeight();
    }

    /**
     * Mètode per obtenir l'amplada d'un soldat.
     *
     * @return --> Retorna un double corresponent a l'alçada de l'imatge del
     *         soldat.
     */
    final double obtenirWidth() {
        return this.getImatge().getWidth();
    }

    /**
     * Mètode per obtenir el valor de la coordenada X d'un soldat.
     *
     * @return --> Retorna un double corresponent a la coordenada X de l'imatge
     *         d'un soldat.
     */
    final double obtenirX() {
        return this.getImatge().getX();
    }

    /**
     * Mètode per obtenir el valor de la coordenada Y d'un soldat.
     *
     * @return --> Retorna un double corresponent a la coordenada Y de l'imatge
     *         d'un soldat.
     */
    final double obtenirY() {
        return this.getImatge().getY();
    }

    /**
     * Mètode per obtenir l'imatge d'un soldat.
     *
     * @return --> Retorna la imatge del soldat en tipus "GImage".
     */
    final GImage getImatge() {
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
     * Mètode per accedit a la propietat haArribat del soldat.
     *
     * @return --> Retorna True si ha arribat / False si no ha arribat.
     */
    final boolean isHaArribat() {
        return haArribat;
    }

    /**
     * Mètode per obtenir la posició Y de la imatge de un soldat, però per la
     * part d'abaix.
     *
     * @return --> Retorna un double corresponent al valor Y de la part inferior
     *         de l'imatge.
     */
    final double posicioBaix() {
        return this.obtenirY() + this.obtenirHeight();
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

    /**
     * Mètode per obtenir el valor de la propietat VelocitatE.
     * @return --> Retorna un int corresponent a la velocitat.
     */
    final int getVelocitatE() {
        return velocitatE;
    }

    /**
     * Mètode per assignar el valor de la propietat VelocitatE.
     * @param veloE --> Velocitat a assignar.
     */
    final void setVelocitatE(final int veloE) {
        this.velocitatE = veloE;
    }

    /**
     * Mètode per obtenir el valor de la propietat VelocitatD.
     * @return --> Retorna un int corresponent a la velocitat.
     */
    final int getVelocitatD() {
        return velocitatD;
    }

    /**
     * Mètode per assignar el valor de la propietat VelocitatD.
     * @param veloD --> Velocitat a assignar.
     */
    final void setVelocitatD(final int veloD) {
        this.velocitatD = veloD;
    }

    /**
     * Mètode per accedir al valor de la propietat vides.
     * @return --> Retorna el numero de vides d'un soldat.
     */
    final int getVides() {
        return vides;
    }

    /**
     * Mètode per assignar el valor de la propietat vides.
     * @param videsS --> Numero de vides a assignar.
     */
    final void setVides(final int videsS) {
        this.vides = videsS;
    }

}
