package batalla;

import acm.graphics.GImage;

public class SoldatGegant extends SoldatGeneral{


    public SoldatGegant(GImage imatgeS) {
        super(imatgeS);
        super.setVELOCITATD(5);
        super.setVELOCITATE(-5);
        // TODO Auto-generated constructor stub
    }

    @Override
    void mouSoldat(int ubicacio, Main pissarra, Campbatalla campbatalla) {
        // TODO Auto-generated method stub

         double xActual = this.obtenirX();
         if (ubicacio == -1) {
             this.getImatge().move(VELOCITATD, 0);
             // this.getImatge().pause(5);
             // soldats.get(indexRandom).getImatge().pause(100);

             if (xActual >= (pissarra.getWidth() - (this.obtenirWidth()))) {
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
