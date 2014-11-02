package batalla;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRectangle;
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
    Exercit Exercit1 = new Exercit(CrearExercit("soldier1.png"), -1);
    Exercit Exercit2 = new Exercit(CrearExercit("soldier2.png"), 1);

    CampBatalla camp = new CampBatalla(campx, campy);

    public void run(){

        /**
         * Creo l'objecte "camp".
         */
        //CampBatalla camp = new CampBatalla(campx, campy);

        /**
         * Assignem un tamany a la finestra.
         */
        this.setSize(camp.getCampx(), camp.getCampy());

        /**
         * Afegim els exercits al camp.
         */
        camp.AfegirExercit(Exercit1);
        camp.AfegirExercit(Exercit2);

        /**
         * Posicionem els exercits que hi ha al camp de batalla.
         */
        for(int i = 0; i<camp.getExercits().size();i++){
            if(camp.getExercits().get(i).ubicacio == -1){
                camp.getExercits().get(i).Posiciona(0, 0);
            }else{
                camp.getExercits().get(i).Posiciona(camp.getCampx(), 0);
            }
        }

        /**
         * Obtenim el numero de files i l'assignem a "CampBatalla".
         */
        camp.setNum_files(camp.ObtenirFiles());

        /**
         * Fem que els exercits formin.
         */
        FormarExercits(camp);


        /**
         * Iniciem la batalla!
         */

        /**
         * Control inici
         */
        ControlInici();

        while(!camp.GuanyadorTrobat()){
            IniciarBatalla();
        }

    }


    public void IniciarBatalla(){

        boolean hanArribat = camp.getExercits().get(0).hanArribatAlFinal() && camp.getExercits().get(1).hanArribatAlFinal();

        while(!hanArribat){

             for(int i = 0; i<camp.getExercits().size();i++){
                 Exercit exercit = camp.getExercits().get(i);
                 if(exercit.getSoldats().size() != 0){
                     exercit.MoureExercit(this);
                 }

                 exercit.comprovaMorts(camp.getExercits().get(CercaExercitOponent(i)).getSoldats());
             }

        hanArribat = camp.getExercits().get(0).hanArribatAlFinal() && camp.getExercits().get(1).hanArribatAlFinal();


        }

        if(!camp.GuanyadorTrobat()){
        ReinicialitzarExercits();
        FormarExercits(camp);
        }
    }





    public int CercaExercitOponent(int exercitActual){
        if(exercitActual == 0){
            return 1;
        }else{
            return 0;
        }
    }


    public void FormarExercits(CampBatalla camp){
         for(int i = 0; i<camp.getExercits().size();i++){
             Exercit exercit = camp.getExercits().get(i);
             exercit.Formar(camp);
         }
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

            //Afegir soldats a la pisarra!
            add(soldat.getImatge());
        }
        return exercit;
    }

    public void ReinicialitzarExercits(){
        for(int i = 0; i<camp.getExercits().size();i++){
            //Canvi d'ubicació
            camp.getExercits().get(i).canviaUbicacio(camp.getExercits().get(i).getUbicacio());
            //Canvi de haArribat a false.
            camp.getExercits().get(i).ReinicialitzaExercit();

        }
    }


    public void ControlInici(){
        GLabel glabel = new GLabel("Click per començar la batalla!");
        glabel.setLocation(campx/2 - (glabel.getWidth() /2), campy/2);
        glabel.setFont(new Font("Liberation Serif", Font.ITALIC, 15));
        add(glabel);
        waitForClick();
        remove(glabel);

    }

















}
