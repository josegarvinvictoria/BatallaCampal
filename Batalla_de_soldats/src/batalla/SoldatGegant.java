package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "SoldatGegant".
 *
 * @author Jose Garvin Victoria
 *
 */
public class SoldatGegant extends SoldatGeneral {

    /**
     * Número de vides del soldat.
     */
    private static final int VIDES = 15;

    /**
     * Velocitat del soldat quan es mou cap a l'esquerra.
     */
    private static final int VELOCITATE = -15;

    /**
     * Velocitat del soldat quan es mou cap a la dreta.
     */
    private static final int VELOCITATD = 15;

    /**
     * Constructor per crear objectes de tipus "SoldatGegant".
     *
     * @param imatgeS
     *            --> Imatge o aspecte del soldat.
     */
    public SoldatGegant(final GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatD(VELOCITATD);
        this.setVelocitatE(VELOCITATE);
        this.setVides(VIDES);

        // TODO Auto-generated constructor stub
    }

    @Override
    final void mouSoldat(final int ubicacio, final Main pissarra,
            final Campbatalla campbatalla) {
        // TODO Auto-generated method stub

        double xActual = this.obtenirX();
        if (ubicacio == -1) {
            this.getImatge().move(getVelocitatD(), 0);
            // this.getImatge().pause(5);
            // soldats.get(indexRandom).getImatge().pause(100);

            if (xActual >= (pissarra.getWidth() - (this.obtenirWidth()))) {
                this.setHaArribat(true);
            }

        } else {
            this.getImatge().move(getVelocitatE(), 0);
            // this.getImatge().pause(5);

            if (xActual <= 0) {

                this.setHaArribat(true);
            }
        }
    }

}
