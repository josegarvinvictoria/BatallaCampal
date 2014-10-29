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
    Exercit Exercit1 = new Exercit(CrearExercit("soldier1.png"), -1);
    Exercit Exercit2 = new Exercit(CrearExercit("soldier2.png"), 1);


    public void run(){
        /**
         * Creo l'objecte "camp".
         */
        CampBatalla camp = new CampBatalla(campx, campy);

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

        //Exercit1.Posiciona(0, 0);
        //Exercit2.Posiciona(campx, 0);
        //camp.ObtenirFiles(Exercit1.getSoldats());
        //System.out.println(camp.ObtenirFiles(Exercit1.getSoldats()));
        Exercit1.Formar(camp);
        Exercit2.Formar(camp);

        boolean hanArribat = Exercit2.hanArribatAlFinal() && Exercit1.hanArribatAlFinal();

        while(!hanArribat){
        Exercit1.MoureExercit(this);
        Exercit2.MoureExercit(this);
        hanArribat = Exercit2.hanArribatAlFinal() && Exercit1.hanArribatAlFinal();

        }
        Exercit1.Formar(camp);
        Exercit2.Formar(camp);
        //Exercit2.Atacar();

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










}
