package batalla;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "SoldatArmilla". Aquest tipus de soldat té
 * vides i tarda una mica més en morir, a més es mou una mica més ràpid.
 *
 * @author Jose Garvin Victoria
 *
 */
public class SoldatArmilla extends SoldatGeneral {

    /**
     * Velocitat dels soldats que es mouen cap a l'equerra.
     */
    private static final int VELOCITATE_SOLDAT = -10;

    /**
     * Velocitat dels soldats que es mouen cap a la dreta.
     */
    private static final int VELOCITATD_SOLDAT = 10;

    /**
     * Número de vides del soldat.
     */
    private static final int NUMVIDES = 5;

    /**
     * Imatge del soldat.
     */
    private GImage imatgeS = new GImage("soldier3.png");

    /**
     * Constructor per a objectes de tipus "SoldatArmilla".
     * @param imatgeA --> Imatge del soldat.
     */
    public SoldatArmilla(final GImage imatgeA) {
        super(imatgeA);
        this.setVelocitatD(VELOCITATD_SOLDAT);
        this.setVelocitatE(VELOCITATE_SOLDAT);
        this.setVides(NUMVIDES);

    }

    @Override
    final void mouSoldat(final int ubicacio, final Main camp,
            final Campbatalla campBatalla) {
        // TODO Auto-generated method stub

        double xActual = this.getImatge().getX();
        if (ubicacio == -1) {
            this.getImatge().move(getVelocitatD(), 0);


            if (xActual >= (camp.getWidth() - (this.obtenirWidth()))) {
                this.setHaArribat(true);
            }

        } else {
            //imatge.move(velocitatE, 0);
            getImatge().move(getVelocitatE(), 0);
            // this.getImatge().pause(5);

            if (xActual <= 0) {

                setHaArribat(true);
            }
        }

    }

}
