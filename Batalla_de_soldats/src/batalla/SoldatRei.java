package batalla;

import acm.graphics.GImage;

public class SoldatRei extends SoldatGeneral {

    int indexFila = 1;
    boolean haDePujar = false;

    public SoldatRei(GImage imatgeS) {
        super(imatgeS);
        this.setVelocitatD(5);
        this.setVelocitatE(-5);
        this.setVides(2);

        // TODO Auto-generated constructor stub
    }

    @Override
    void mouSoldat(int ubicacio, Main camp, Campbatalla campbatalla) {


        if(ubicacio == -1){
            if(this.obtenirX() != 0.0){
            this.posatA(0, 0);}
        }else{
            if(this.obtenirX() != camp.getWidth() - this.obtenirWidth()){
                this.posatA(camp.getWidth() - this.obtenirWidth(), 0);
            }


        }

        if(this.obtenirY()< (campbatalla.getCampy() - this.obtenirY())){
            this.getImatge().move(0, 72);

        }else{
            this.getImatge().move(0, -72);
        }

    }





}
