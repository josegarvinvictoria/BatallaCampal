package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "SoldatRei".
 *
 * @author Jose Garvin Victoria
 *
 */
public class SoldatRei extends SoldatGeneral {

    /**
     * Temps de pausa del soldat cada cop que es mou.
     */
    private static final int TEMPS_PAUSA_REI = 80;

    /**
     * Velocitat del soldat quan es mou cap a l'esquerra.
     */
    private static final int VELOCITATE = -5;

    /**
     * Velocitat del soldat quan es mou cap a la dreta.
     */
    private static final int VELOCITATD = 5;

    /**
     * Variable per controlar si un "SoldatRei" ha de baixar o pujar.
     */
    private boolean haDePujar = false;

    /**
     * Variable per contar les files.
     */
    private int contFila = 0;

    /**
     * Constructor per crear objectes de tipus "SoldatGegant".
     *
     * @param imatgeS
     *            --> Imatge o aspecte del soldat.
     */
    public SoldatRei(final GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatD(VELOCITATD);
        this.setVelocitatE(VELOCITATE);
        this.setVides(1);

        // TODO Auto-generated constructor stub
    }

    @Override
    final void mouSoldat(final int ubicacio, final Main camp,
            final Campbatalla campbatalla) {

        if (!haDePujar) {

            if ((camp.getHeight() - (this.obtenirHeight() * 2)) >= this
                    .obtenirY()) {
                contFila++;
                this.getImatge().move(0, this.obtenirHeight());
            } else {
                haDePujar = true;
            }

        }

        if (haDePujar) {
            if (contFila > 0) {
                contFila--;
                this.getImatge().move(0, this.obtenirHeight() * (-1));
            } else if (contFila == 0) {
                haDePujar = false;
            }

        }

        camp.pause(TEMPS_PAUSA_REI);

    }

}
