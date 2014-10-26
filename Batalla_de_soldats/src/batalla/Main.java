package batalla;

import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram{

    /**
     * Dimensions del camp de batalla.
     */
    int campx = 800;
    int campy = 400;


    /**
     * Creem els exercits.
     */
    Exercit Exercit1 = new Exercit(CrearExercit("soldier1.png"));
    Exercit Exercit2 = new Exercit(CrearExercit("soldier2.png"));


    public void run(){
        this.setSize(campx, campy);
        Exercit1.Posiciona(0, 0);
        Exercit2.Posiciona(800, 0);
        Exercit1.ObtenirFiles(Exercit1.getSoldats());
        System.out.println(Exercit1.ObtenirFiles(Exercit1.getSoldats()));
        Exercit1.Formar();
        Exercit2.Formar();

    }
    /**
     * Posicionament Exercit2.
     */







    /**
     * Mètode per crear exercits.
     * @param rutaImatge --> Ruta imatge
     * @return --> Retorna un arrayList de Soldats.
     */
    public ArrayList<Soldat> CrearExercit(String rutaImatge){
        ArrayList<Soldat> exercit = new ArrayList<>();
        for(int i = 0; i<15;i++){
            Soldat soldat = new Soldat(new GImage(rutaImatge));
            exercit.add(soldat);

            //Afegir soldats a la pisarra!
            add(soldat.getImatge());
        }
        return exercit;
    }







    public int getCampx() {
        return campx;
    }


    public void setCampx(int campx) {
        this.campx = campx;
    }


    public int getCampy() {
        return campy;
    }


    public void setCampy(int campy) {
        this.campy = campy;
    }


}
