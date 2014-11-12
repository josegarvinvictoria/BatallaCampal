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
        this.VELOCITATD = 13;
        this.VELOCITATE = -13;

    }





    /**
     * Mètode per moure un soldat.
     *
     * @param ubicacio
     *            --> Passem l'ubicacio de l'exercit.
     * @param camp
     *            --> Passem el camp on s'ha de moure el soldat.
     */
    final void mouSoldat(final int ubicacio, final Main camp, final Campbatalla campBatalla) {

        double xActual = this.obtenirX();
        if (ubicacio == -1) {
            this.getImatge().move(VELOCITATD, 0);
            // this.getImatge().pause(5);
            // soldats.get(indexRandom).getImatge().pause(100);

            if (xActual >= (camp.getWidth() - (this.obtenirWidth()))) {
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
     * Mètode per determinar si un soldat toca amb un oponent.
     *
     * @param oponent
     *            --> Soldat oponent de l'exercit contrari.
     * @return --> Retorna true/false depenent de si es toquen o no.
     */






    @Override
    boolean soldatToca(SoldatGeneral oponent) {
        boolean toca = this.getImatge().getBounds()
                .intersects(oponent.getImatge().getBounds());
        if(toca && this.obtenirY() == oponent.obtenirY()){
            return true;
        }
        return false;
    }







}
