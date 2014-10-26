package batalla;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram{


    /**
     * Creem els exercits.
     */
    Exercit Exercit1 = new Exercit(CrearExercit("soldier1.png"));
    Exercit Exercit2 = new Exercit(CrearExercit("soldier2.png"));


    public void run(){
        this.setSize(800, 400);
        Exercit1.Posiciona(0 , 0);
        Exercit2.Posiciona(800, 0);


    }

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
            add(soldat.getImatge());
        }
        return exercit;
    }
}
