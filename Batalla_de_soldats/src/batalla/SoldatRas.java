package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "SoldatRas".
 *
 * @author Jose Garvin Victoria
 *
 */
public class SoldatRas extends SoldatGeneral {

    /**
     * Número de vides del soldat.
     */
    private static final int VIDES = 5;

    /**
     * Velocitat del soldat quan es mou cap a la dreta.
     */
    private static final int VELOCITATD = 7;

    /**
     * Velocitat del soldat quan es mou cap a l'esquerra.
     */
    private static final int VELOCITATE = -7;

    /**
     * Constructor per crear objectes de tipus "SoldatRas".
     *
     * @param imatgeS
     *            --> Imatge o aspecte del soldat.
     */
    public SoldatRas(final GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatE(VELOCITATE);
        this.setVelocitatD(VELOCITATD);
        this.setVides(VIDES);

    }

    /**
     * Mètode per moure un soldat.
     *
     * @param ubicacio
     *            --> Passem l'ubicacio de l'exercit.
     * @param camp
     *            --> Passem el camp on s'ha de moure el soldat.
     * @param campBatalla
     *            --> Passem el camp de batalla per obtenir les mides.
     */
    final void mouSoldat(final int ubicacio, final Main camp,
            final Campbatalla campBatalla) {

        double xActual = this.obtenirX();
        if (ubicacio == -1) {
            this.getImatge().move(getVelocitatD(), 0);

            if (xActual >= (camp.getWidth() - (this.obtenirWidth()))) {
                this.setHaArribat(true);
            }

        } else {
            this.getImatge().move(getVelocitatE(), 0);

            if (xActual <= 0) {

                this.setHaArribat(true);
            }
        }

    }

}
