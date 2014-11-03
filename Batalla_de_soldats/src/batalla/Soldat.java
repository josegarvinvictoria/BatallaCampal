package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "Soldat".
 *
 * @author Jose Garvin Victoria
 *
 */
public class Soldat {

    /**
     * "Velocitat" soldat ESQUERRA. Aquesta variable s'utilitza quan movem el
     * soldat amb la funcio ".move" cap a l'esquerra.
     */
    private static final int VELOCITATE = -6;

    /**
     * "Velocitat" soldat DRETA. Aquesta variable s'utilitza quan movem el
     * soldat amb la funcio ".move" cap a la dreta.
     */
    private static final int VELOCITATD = 6;

    /**
     * Imatge o aspecte del soldat.
     */
    private GImage imatge;

    /**
     * Variable per controlar si el soldat ha arribat al final del seu trajecte.
     */
    private boolean haArribat;




    /**
     * Constructor per defecte per crear objectes de tipus "Soldat" (no
     * l'utilitzo).
     */
    public Soldat() {

    }

    /**
     * Constructor per crear objectes de tipus "Soldat".
     *
     * @param imatgeS
     *            --> Imatge o aspecte del soldat.
     */
    public Soldat(final GImage imatgeS) {
        this.imatge = imatgeS;
    }





    /**
     * Mètode per moure un soldat.
     *
     * @param ubicacio
     *            --> Passem l'ubicacio de l'exercit.
     * @param camp
     *            --> Passem el camp on s'ha de moure el soldat.
     */
    final void mouSoldat(final int ubicacio, final Main camp) {

        double xActual = this.getImatge().getX();
        if (ubicacio == -1) {
            this.getImatge().move(VELOCITATD, 0);
            // this.getImatge().pause(5);
            // soldats.get(indexRandom).getImatge().pause(100);

            if (xActual >= (camp.getWidth() - (this.getImatge().getWidth()))) {
                this.setHaArribat(true);
            }

        } else {
            this.getImatge().move(VELOCITATE, 0);
            // this.getImatge().pause(5);

            if (xActual <= 0) {

                this.setHaArribat(true);
            }
        }

    }

    /**
     * Mètode per tornar a posar a "false" la propietat haArribat. D'aquesta
     * manera en assegurem que els soldats tornen a estar disponibles per
     * moure's.
     */
    final void reinicialitzaSoldat() {
        if (this.haArribat) {
            this.haArribat = false;
        } else {
            this.haArribat = true;
        }
    }

    /**
     * Mètode per determinar si un soldat toca amb un oponent.
     *
     * @param oponent
     *            --> Soldat oponent de l'exercit contrari.
     * @return --> Retorna true/false depenent de si es toquen o no.
     */
    final boolean soldatsToquen(final Soldat oponent) {
        return this.getImatge().getBounds()
                .intersects(oponent.getImatge().getBounds());
    }




    /**
     * Mètode per obtenir la imatge de un soldat.
     *
     * @return --> Retorna una imatge de tipus "GImage".
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

}
