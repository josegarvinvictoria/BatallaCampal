package batalla;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe per crear objectes de tipus "CampBatalla".
 *
 * @author Jose Garvin Victoria
 *
 */
public class Campbatalla {

    /**
     * Variable on s'emmagatzema en mil.lisegons el temps d'espera abans de
     * tancar el programa, un cop s'hagi trobat un exercit guanyador.
     */
    private static final int TEMPSESPERA = 3000;

    /**
     * Número de files del camp de batalla.
     */
    private int numfiles;

    /**
     * Mida x del camp de batalla.
     */
    private int campx;

    /**
     * Mida y del camp de batalla.
     */
    private int campy;

    /**
     * ArraList amb els exercits que estaran al camp de batalla.
     */
    private ArrayList<Exercit> exercits = new ArrayList<>();




    /**
     * Constructor d'objectes de tipus "Campbatalla".
     *
     * @param x
     *            --> Tamany de la x.
     * @param y
     *            --> Tamany de la y.
     */
    public Campbatalla(final int x, final int y) {
        this.campx = x;
        this.campy = y;
    }


    /**
     * Constructor per defecte per objectes de tipus "Campbatalla".
     */
    public Campbatalla(){

    }




    /**
     * Mètode per afegir un exercit a la llista d'exercits.
     *
     * @param exercitAafegir
     *            --> Exercit a afegir.
     */
    final void afegirExercit(final Exercit exercitAafegir) {
        exercits.add(exercitAafegir);
    }

    /**
     * Mètode per calcular quantes files ha de tenir el camp de batalla.
     *
     * @return --> Retorna el numero de files a partir de l'alçada d'un soldat.
     */
    final int obtenirFiles() {
        List<Soldat> soldats = exercits.get(0).getSoldats();
        double heightSoldat = soldats.get(0).getImatge().getHeight();
        double numFiles = getCampy() / heightSoldat;
        int numFilesInt = (int) numFiles;
        return numFilesInt;
    }

    /**
     * Mètode per esbrinar si s'ha trobat un guanyador de la batalla.
     *
     * @return --> True: S'ha trobat un exercit campio / False: Encara no s'ha
     *         trobat campio.
     */
    final boolean guanyadorTrobat() {
        if (exercits.get(0).getSoldats().size() == 0
                || exercits.get(1).getSoldats().size() == 0) {
            try {
                Thread.sleep(TEMPSESPERA);
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            return true;
        } else {
            return false;
        }

    }



    /**
     * Metode per obtenir el numero de files del camp de batalla.
     *
     * @return --> Retorna un enter que correspont al numero de files.
     */
    final int getNumfiles() {
        return numfiles;
    }

    /**
     * Metode per assignar un nº de files determinat.
     *
     * @param numFiles
     *            --> Hi passem un enter corresponent al numero de files.
     */
    final void setNumfiles(final int numFiles) {
        this.numfiles = numFiles;
    }

    /**
     * Mètode per obtenir el tamany de x del camp de batalla.
     *
     * @return --> Retorna un enter.
     */
    final int getCampx() {
        return campx;
    }

    /**
     * Mètode per assignar el tamany de x del camp de batalla.
     *
     * @param campX
     *            --> Tamany de x.
     */
    final void setCampx(final int campX) {
        this.campx = campX;
    }

    /**
     * Obtenir el tamany de y del camp de batalla.
     *
     * @return --> Retorna un enter.
     */
    final int getCampy() {
        return campy;
    }

    /**
     * Assignar el tamany de y del camp de batalla.
     *
     * @param campY
     *            --> Tamany de y.
     */
    final void setCampy(final int campY) {
        this.campy = campY;
    }

    /**
     * Mètode per obtenir una llista amb els exercits del camp de batalla.
     *
     * @return --> Retorna una llista d'exercits.
     */
    final ArrayList<Exercit> getExercits() {
        return exercits;
    }

}
