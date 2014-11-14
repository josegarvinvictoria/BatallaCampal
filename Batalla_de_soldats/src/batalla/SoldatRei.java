package batalla;

import acm.graphics.GImage;

public class SoldatRei extends SoldatGeneral {

    int indexFila = 1;
    boolean haDePujar = false;

    public SoldatRei(GImage imatgeS) {
        super(imatgeS);
        super.VELOCITATD = 5;
        super.VELOCITATE = -5;

        // TODO Auto-generated constructor stub
    }

    @Override
    void mouSoldat(int ubicacio, Main camp, Campbatalla campbatalla) {

        int numFiles = campbatalla.obtenirFiles();






        if(this.indexFila <= numFiles){
            if(this.indexFila == numFiles || haDePujar){
                haDePujar = true;
            }else{

            this.getImatge().move(0, 72);
            this.indexFila++;
            }

        }


        if(haDePujar){
            this.getImatge().move(0, -72);
            this.indexFila--;

            if(this.indexFila == 1){
                haDePujar = false;
            }
        }

        this.getImatge().pause(50);
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
