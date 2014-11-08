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
        this.VELOCITATD = 7;
        this.VELOCITATE = -7;

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
        if(toca && this.getImatge().getY() == oponent.getImatge().getY()){
            return true;
        }
        return false;
    }







}