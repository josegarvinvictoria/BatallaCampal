package batalla;

import acm.graphics.GImage;


public class SoldatGegant extends SoldatGeneral{


    public SoldatGegant(GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatD(15);;
        this.setVelocitatE(-15);
        this.setVides(5);


        // TODO Auto-generated constructor stub
    }

    @Override
    void mouSoldat(int ubicacio, Main pissarra, Campbatalla campbatalla) {
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
