package batalla;

import acm.graphics.GImage;

public class Soldat {

    GImage imatge;
    boolean haArribat;



    /**
     * Constructor soldat.
     */
    public Soldat(GImage imatgej){
        this.imatge = imatgej;
    }


    public Soldat(){

    }

    public GImage getImatge() {
        return imatge;
    }

    public void setImatge(GImage imatge) {
        this.imatge = imatge;
    }

    public boolean isHaArribat() {
        return haArribat;
    }

    public void setHaArribat(boolean haArribat) {
        this.haArribat = haArribat;
    }

    /**
     * Metode per moure un soldat.
     * @param ubicacio --> Passem la ubicacio del exercit.
     * @param camp --> Passem el camp on s'ha de moure el soldat.
     */
    public void Mou( int ubicacio, Main camp){

        double xActual = this.getImatge().getX();
        if(ubicacio == -1){
            this.getImatge().move(5, 0);
            this.getImatge().pause(5);
            //soldats.get(indexRandom).getImatge().pause(100);

            if(xActual >= (camp.getWidth() - (this.getImatge().getWidth() ))){
                this.setHaArribat(true);
            }


        }else{
            this.getImatge().move(-5, 0);
            this.getImatge().pause(5);

            if(xActual <= 0){

                this.setHaArribat(true);
            }
    }



    }

    public void ReinicialitzaSoldat(){
        if(this.haArribat == true){
            this.haArribat = false;
        }else{
            this.haArribat = true;
        }
    }

    public boolean SoldatsToquen(Soldat oponent){
        return this.getImatge().getBounds().intersects(oponent.getImatge().getBounds());
    }


    public void MatarSoldat(){
        this.imatge = null;
    }


}
