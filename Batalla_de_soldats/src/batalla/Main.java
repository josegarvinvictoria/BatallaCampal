package batalla;

import java.util.ArrayList;

import acm.graphics.GImage;

public class Main {

    //Incialitzem les imatges dels soldats
    GImage imatgeSoldat1 = new GImage("/home/b4tm4n/Imágenes/soldier1.png");
    GImage imatgeSoldat2 = new GImage("/home/b4tm4n/Imágenes/soldier2.png");

    Exercit Exercit1 = new Exercit(CrearExercit("/home/b4tm4n/Imágenes/soldier1.png"));
    Exercit Exercit2 = new Exercit(CrearExercit("/home/b4tm4n/Imágenes/soldier2.png"));



    public ArrayList<Soldat> CrearExercit(String rutaImatge){
        ArrayList<Soldat> exercit = new ArrayList<>();
        for(int i = 0; i<15;i++){
            exercit.add(new Soldat(new GImage(rutaImatge), 0, 0));
        }
        return exercit;
    }



    public void run(){

    }
}
