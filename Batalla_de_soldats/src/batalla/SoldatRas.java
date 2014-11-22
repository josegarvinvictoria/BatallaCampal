package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "Soldat".
 *
 * @author Jose Garvin Victoria
 *
 */
public class SoldatRas extends SoldatGeneral {

    /**
     * Constructor per crear objectes de tipus "Soldat".
     *
     * @param imatgeS
     *            --> Imatge o aspecte del soldat.
     */
    public SoldatRas(final GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatE(-7);
        this.setVelocitatD(7);
        this.setVides(1);

    }

    /**
     * Mètode per moure un soldat.
     *
     * @param ubicacio
     *            --> Passem l'ubicacio de l'exercit.
     * @param camp
     *            --> Passem el camp on s'ha de moure el soldat.
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
