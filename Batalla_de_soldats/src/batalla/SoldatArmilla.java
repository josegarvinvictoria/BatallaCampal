package batalla;

import acm.graphics.GImage;

public class SoldatArmilla extends SoldatGeneral{

GImage imatgeS = new GImage("soldier3.png");
int vides = 5;
    public SoldatArmilla(GImage imatgeA) {
        super(imatgeA);
        super.setImatge(imatgeS);
        super.setVELOCITATD(10);
        super.setVELOCITATE(-10);





    }

    @Override
    void mouSoldat(int ubicacio, Main camp, Campbatalla campBatalla) {
        // TODO Auto-generated method stub
        System.out.println("Numero de vides: " + this.vides);
        double xActual = this.getImatge().getX();
        if (ubicacio == -1) {
            this.getImatge().move(VELOCITATD, 0);
            // this.getImatge().pause(5);
            // soldats.get(indexRandom).getImatge().pause(100);

            if (xActual >= (camp.getWidth() - (this.obtenirWidth()))) {
                this.setHaArribat(true);
            }

        } else {
            imatge.move(VELOCITATE, 0);
            getImatge().move(VELOCITATE, 0);
            // this.getImatge().pause(5);

            if (xActual <= 0) {

                setHaArribat(true);
            }
        }

    }

    @Override
    boolean soldatToca(SoldatGeneral oponent) {

        boolean toca = this.getImatge().getBounds()
                .intersects(oponent.getImatge().getBounds());




        if(toca && (this.obtenirY() == oponent.obtenirY()) && calculVides()){
            System.out.println("true");
            return true;
        }
        return false;
    }


    boolean calculVides(){
        this.vides--;

        if(this.vides < 0){

            return true;
        }
        return false;
    }



}
