package batalla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "Exercit".
 *
 * @author Jose Garvin Victoria
 *
 */
public class Exercit {

    /**
     * Tamany màxim del camp.
     */
    private static final int TAMANYMAXIM = 1200;

    /**
     * ArrayList amb els soldats que componen un exercit.
     */
    private List<SoldatGeneral> soldats;

    /**
     * Variable que emmagatzema la posicio de l'exercit. -1: L'exercit es
     * col.loca a la dreta / 1: L'exerci es col.loca a la dreta.
     */
    private int ubicacio;

    /**
     * Creació de l'objecte camp.
     */

    /**
     * Constructor d'objectes de tipues "Exercit".
     *
     * @param exercit
     *            --> Llista de soldats de l'exercit.
     * @param ubica
     *            --> Ubicació de l'exercit. 1:Dreta / -1Esquerra.
     */
    public Exercit(final List<SoldatGeneral> exercit, final int ubica) {
        this.soldats = exercit;
        this.ubicacio = ubica;

    }

    /**
     * Mètode per posicionar l'exercit (left,right).
     *
     * @param pos1
     *            --> Posició de la x.
     * @param pos2
     *            --> Posició de la y.
     */
    final void posiciona(final int pos1, final int pos2) {
        if (pos1 == 0 && pos2 == 0) {

            for (int i = 0; i < this.soldats.size(); i++) {
                soldats.get(i).posatA(pos1, pos2);
            }

        }
        if (pos1 == TAMANYMAXIM && pos2 == 0) {
            for (int i = 0; i < this.soldats.size(); i++) {
                soldats.get(i)
                        .posatA(pos1 - (soldats.get(i).obtenirWidth()), 0);

            }
        }
    }

    /**
     * Mètode per calcular la posició X d'un soldat depenent de l'exercit al que
     * pertany.
     *
     * @param campB
     *            --> Camp de batalla.
     * @param soldat
     *            --> Objecte de tipus SoldatGeneral.
     * @return --> Retorna un int corresponent a la X del soldat.
     */
    final int calculaX(final Campbatalla campB, final SoldatGeneral soldat) {
        if (this.ubicacio == -1) {
            return 0;
        } else {
            return campB.getCampx() - (int) soldat.obtenirWidth();
        }
    }

    /**
     * Mètode per fer que els exercits es formin correctament.
     * @param campB --> Camp de batalla.
     */
    final void formarExercits(final Campbatalla campB) {
        // int numFiles = campB.obtenirFiles(soldats);
        ArrayList<Double> ySoldats = new ArrayList<>();

        double posY = 0;
        int filaActual = 0;
        // Pinto els soldats forman-los com els hi toca.

        for (int i = 0; i < soldats.size(); i++) {

            if (filaActual == 0) {
                // Si l'array no te res afegim el valor.
                ySoldats.add(0.0);
                soldats.get(i).posatA(calculaX(campB, soldats.get(i)),
                        ySoldats.get(filaActual));
                filaActual++;

            } else {

                if (soldats.get(i) instanceof SoldatGegant) {
                    posY = soldats.get(i - 1).posicioBaix() + 2;
                    if (posY > (campB.getCampy() - soldats.get(i)
                            .obtenirHeight())) {
                        posY = 0.0;
                    }
                    ySoldats.add(posY);
                    soldats.get(i).posatA(calculaX(campB, soldats.get(i)),
                            ySoldats.get(i));
                    filaActual++;

                } else {

                    posY = soldats.get(i - 1).posicioBaix() + 2;
                    if (posY > (campB.getCampy() - soldats.get(i)
                            .obtenirHeight())) {
                        posY = 0.0;
                    }
                    ySoldats.add(posY);
                    soldats.get(i).posatA(calculaX(campB, soldats.get(i)),
                            ySoldats.get(i));
                    filaActual++;
                }

            }

            separarseEntreAliats(i);
        }
        campB.setNumfiles(filaActual);
    }

    /**
     * Mètode per fer que un soldat es separi dels seus companys en el cas de
     * que es toquin.
     *
     * @param ultimSoldatColocat
     *            --> Ultim soldat col.locat el qual mourem, si s'escau.
     */
    final void separarseEntreAliats(final int ultimSoldatColocat) {

        for (int i = 0; i < ultimSoldatColocat; i++) {
            while (soldats.get(ultimSoldatColocat).soldatToca(soldats.get(i))) {
                if (this.ubicacio == -1) {
                    soldats.get(ultimSoldatColocat).getImatge().move(1, 0);

                } else {
                    soldats.get(ultimSoldatColocat).getImatge().move(-1, 0);
                }

            }
        }

    }

    /**
     * Metode per formar (Amb setLocation!).
     *
     * @param campB
     *            --> Camp de batalla on s'ha de formar l'exercit.
     */
    final void formar(final Campbatalla campB) {

        int numFiles = campB.obtenirFiles();
        double alcadaSoldat = soldats.get(0).obtenirHeight();
        double ampladaSoldat = soldats.get(0).obtenirWidth();
        int indexFila = 0;

        double xActual = soldats.get(0).obtenirX();
        double yActual = 0;

        for (int s = 0; s < soldats.size(); s++) {
            if (indexFila <= numFiles) {

                soldats.get(s).posatA(xActual, yActual);
                yActual += alcadaSoldat;
                indexFila++;
                if (indexFila == numFiles) {
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
     *
     * @param pissarra
     *            --> Camp on s'han de moure el soldats.
     * @param campB
     *            --> Classe camp per esbrinar les seves mides.
     */
    final void moureExercit(final Main pissarra, final Campbatalla campB) {

        Random r = new Random();

        int indexRandom = r.nextInt(soldats.size());

        if (!soldats.get(indexRandom).isHaArribat()) {
            soldats.get(indexRandom).mouSoldat(ubicacio, pissarra, campB);

        }

    }

    /**
     * Metode per comprovar si tots els soldats han arribat al final.
     *
     * @return --> True: Si tots el soldats han arribat / False: Si els soldats
     *         no han arribat.
     */
    final boolean hanArribatAlFinal() {
        int cont = 0;
        for (int i = 0; i < soldats.size(); i++) {
            if (soldats.get(i).isHaArribat()) {
                cont++;
            }
        }

        if (cont == soldats.size()) {
//            for(int i = 0; i<soldats.size();i++){
//                if(soldats.get(i) instanceof SoldatRei){
//                    soldats.get(i).setHaArribat(true);
//                }
//            }

            return true;
        }

        return false;

    }




    /**
     * Mètode per canviar l'ubicacio de un exercit quan arriba al seu desti.
     *
     * @param ubicacioActual
     *            --> Nova ubicació de l'exercit.
     */
    final void canviaUbicacio(final int ubicacioActual) {
        if (ubicacioActual == 1) {
            this.ubicacio = -1;
        } else {
            this.ubicacio = 1;
        }
    }

    /**
     * Mètode per comprovar els morts d'un exercit despres de rebre un atac.
     *
     * @param atacats
     *            --> Exercit amb el soldats que són atacs.
     */
    final void comprovaMorts(final List<SoldatGeneral> atacats) {
        int tamanyExercit = this.soldats.size();

        // Es recorren els exercits per cercar els morts.
        for (int i = atacats.size() - 1; i >= 0; i--) {

            for (int j = tamanyExercit - 1; j >= 0; j--) {

                // Si dos soldats d'exercits diferents toquen, i son de dal
                // mateixa fila ha de morir.
                if (atacats.get(i).soldatToca(this.soldats.get(j))) {

                    if (!atacats.get(i).teVides()) {
                        GImage imatge = atacats.get(i).getImatge();
                        imatge.getParent().remove(imatge);
                        atacats.remove(i);

                    }

                    break;
                }
            }
        }

    }


    /**
     * Mètode per reinicialitzar cadascun dels soldats d'un exercit.
     */
    final void reinicialitzaExercit() {

        for (int i = 0; i < soldats.size(); i++) {
            soldats.get(i).reinicialitzaSoldat();
        }
    }

    /**
     * Mètode per obtenir una llista de soldats.
     *
     * @return --> Retorna una llista de soldats.
     */
    final List<SoldatGeneral> getSoldats() {
        return soldats;
    }

    /**
     * Mètode per assignar una llista de soldats.
     *
     * @param soldatsE
     *            --> Li passem una llista de soldats.
     */
    final void setSoldats(final List<SoldatGeneral> soldatsE) {
        this.soldats = soldatsE;
    }

    /**
     * Mètode per obtenir l'ubicació d'un exercit.
     *
     * @return --> 1: Dreta / -1: Esquerra.
     */
    final int getUbicacio() {
        return ubicacio;
    }

    /**
     * Mètode per especificar l'ubicació d'un exercit.
     *
     * @param ubicacioE
     *            --> 1: Dreta / -1: Esquerra.
     */
    final void setUbicacio(final int ubicacioE) {
        this.ubicacio = ubicacioE;
    }

}
