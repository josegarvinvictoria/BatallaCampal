package batalla;

import java.util.ArrayList;
import java.util.List;




public class CampBatalla {




    int num_files;
    int campx;
    int campy;
    ArrayList<Exercit> exercits = new ArrayList<>();

    /**
     * Constructor d'objectes de tipus "CampBatalla".
     * @param x --> Tamany de la x.
     * @param y --> Tamany de la y.
     */
    public CampBatalla(int x, int y){
        this.campx = x;
        this.campy = y;
    }


    /**
     * Metode per afegir un exercit al camp de batalla.
     * @param exercitAafegir
     */
    public void AfegirExercit(Exercit exercitAafegir){
        exercits.add(exercitAafegir);
    }

    /**
     * Metode per obtenir les files.
     * @param soldats --> Llista amb el soldats a colocar.
     * @return --> Retorna un enter corresponent al nº de files.
     */
    public int ObtenirFiles() {
        List<Soldat> soldats = exercits.get(0).getSoldats();
        double heightSoldat = soldats.get(0).getImatge().getHeight();
        double numFiles = getCampy() / heightSoldat;
        int numFilesInt = (int) numFiles;
        return numFilesInt;
    }

    /**
     * Metode per obtenir el numero de files.
     * @return --> Retorna un enter que correspont al numero de files.
     */
    public int getNum_files() {
        return num_files;
    }

    /**
     * Metode per assignar un nº de files determinat.
     * @param num_files --> Hi passem un enter corresponent al numero de files.
     */
    public void setNum_files(int num_files) {
        this.num_files = num_files;
    }

    /**
     * Obtenir el tamany de x del camp de batalla.
     * @return --> Retorna un enter.
     */
    public int getCampx() {
        return campx;
    }


    /**
     * Assignar el tamany de x del camp de batalla.
     * @param campx --> Tamany de x.
     */
    public void setCampx(int campx) {
        this.campx = campx;
    }


    /**
     * Obtenir el tamany de y del camp de batalla.
     * @return --> Retorna un enter.
     */
    public int getCampy() {
        return campy;
    }

    /**
     * Assignar el tamany de y del camp de batalla.
     * @param campy --> Tamany de y.
     */
    public void setCampy(int campy) {
        this.campy = campy;
    }


    public ArrayList<Exercit> getExercits() {
        return exercits;
    }


    public void setExercits(ArrayList<Exercit> exercits) {
        this.exercits = exercits;
    }


}
