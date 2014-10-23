package batalla;

import java.util.ArrayList;

import acm.graphics.GImage;

public class Main {

    //Incialitzem les imatges dels soldats
    GImage imatgeSoldat1 = new GImage("/home/b4tm4n/Imágenes/soldier1.png");
    GImage imatgeSoldat2 = new GImage("/home/b4tm4n/Imágenes/soldier2.png");

    Exercit Exercit1 = new Exercit(CrearExercit(imatgeSoldat1));
    Exercit Exercit2 = new Exercit(CrearExercit(imatgeSoldat2));



    public ArrayList<Soldat> CrearExercit(GImage img){
        ArrayList<Soldat> exercit = new ArrayList<>();
        for(int i = 0; i<15;i++){
            exercit.add(new Soldat(img, 0, 0));
        }
        return exercit;
    }



    public void run(){

    }
}
