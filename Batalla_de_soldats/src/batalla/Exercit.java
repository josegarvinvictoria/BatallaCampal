package batalla;


import java.util.List;
import java.util.Random;

import acm.graphics.GImage;


public class Exercit {

    List<Soldat> soldats;
    int ubicacio;
    double velocitat;

    /**
     * Constructor exercit.
     */
    public Exercit(List<Soldat> exercit, int ubica) {
        this.soldats = exercit;
        this.ubicacio = ubica;
        this.velocitat = 5;
    }

    /**
     * Mètode per posicionar l'exercit (left,right).
     *
     * @param pos1
     *            --> Posició de la x.
     * @param pos2
     *            --> Posició de la y.
     */
    public void Posiciona(int pos1, int pos2) {
        if (pos1 == 0 && pos2 == 0) {

            for (int i = 0; i < this.soldats.size(); i++) {
                soldats.get(i).getImatge().setLocation(pos1, pos2);
            }

        }
        if (pos1 == 800 && pos2 == 0) {
            for (int i = 0; i < this.soldats.size(); i++) {
                soldats.get(i)
                        .getImatge()
                        .setLocation(
                                pos1 - (soldats.get(i).getImatge().getWidth()),
                                0);

            }
        }
    }

    /**
     * Metode per formar (Amb setLocation!).
     * @param camp --> Camp de batalla on s'ha de formar l'exercit.
     */
    public void Formar(CampBatalla camp) {

        int num_Files = camp.ObtenirFiles();
        double alcadaSoldat = soldats.get(0).getImatge().getHeight();
        double ampladaSoldat = soldats.get(0).getImatge().getHeight();
        int indexFila = 0;

        double xActual = soldats.get(0).getImatge().getX();
        double yActual = 0;

        for (int s = 0; s < soldats.size(); s++) {
            if (indexFila <= num_Files) {



                soldats.get(s).getImatge().setLocation(xActual, yActual);
                yActual += alcadaSoldat;
                indexFila++;
                if (indexFila == num_Files) {
                    indexFila = 0;
                    yActual = 0;

                    // Si l'ubicació es igual -1 posicionem els soldats a
                    // l'esquerra.
                    if (ubicacio == -1) {
                        xActual += ampladaSoldat;

                        // Si l'ubicació es igual a 1 els posicionem a la
                        // dreta.
                    } else if (ubicacio == 1) {
                        xActual -= ampladaSoldat;
                    }

                }
            }

        }

    }


    /**
     * Metode per moure els soldats de un exercit.
     * @param camp --> Camp on s'han de moure el soldats.
     */
    public void MoureExercit(Main camp) {


        Random r = new Random();

            int indexRandom = r.nextInt(soldats.size());




        if(!soldats.get(indexRandom).isHaArribat()){
            soldats.get(indexRandom).Mou(ubicacio, camp);
                }


    }

    /**
     * Metode per comprovar si tots els soldats han arribat al final.
     * @return --> True: Si tots el soldats han arribat / False: Si els
     * soldats no han arribat.
     */
    public boolean hanArribatAlFinal(){
        int cont = 0;
        for(int i = 0; i<soldats.size();i++){
            if(soldats.get(i).isHaArribat()){
                cont++;
            }
        }

        if(cont == soldats.size()){

            return true;
        }

        return false;

    }


    /**
     * Metode per obtenir una llista de soldats.
     * @return --> Retorna una llista de soldats.
     */
    public List<Soldat> getSoldats() {
        return soldats;
    }

    /**
     * Metode per assignar una llista de soldats.
     * @param soldats --> Li passem una llista de soldats.
     */
    public void setSoldats(List<Soldat> soldats) {
        this.soldats = soldats;
    }


    public int getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(int ubicacio) {
        this.ubicacio = ubicacio;
    }

    /**
     * Metode per canviar l'ubicacio de un exercit quan arriba al seu desti.
     */
    public void canviaUbicacio(int ubicacioActual){
        if(ubicacioActual == 1){
            this.ubicacio = -1;
        }else{
            this.ubicacio = 1;
        }
    }

    /**
     * Comprova morts.
     */
    public void comprovaMorts(List<Soldat> atacats){
        int tamanyExercit = this.soldats.size();

        //Es recorren els exercits per cercar els morts.
        for(int i = atacats.size()-1; i>=0;i--){

            for(int j = tamanyExercit-1; j>=0; j--){

                //Si dos soldats d'exercits diferents toquen, i son de dal mateixa mila ha de morir.
                if(atacats.get(i).SoldatsToquen(this.soldats.get(j)) ){

                    if(atacats.get(i).getImatge().getY() == this.soldats.get(j).getImatge().getY()){
                    GImage imatge = atacats.get(i).getImatge();
                    imatge.getParent().remove(imatge);
                    atacats.remove(i);
                    //tamanyExercit--;
                    }
                    break;
                    //this.soldats.remove(j);


                }
            }

        }
    }

    public void ReinicialitzaExercit(){
        for(int i = 0; i<soldats.size();i++){
            soldats.get(i).ReinicialitzaSoldat();
        }
    }

}
