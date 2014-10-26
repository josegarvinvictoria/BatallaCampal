package batalla;

import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Exercit{

   List<Soldat> soldats;


   /**
    * Constructor exercit.
    */
   public Exercit(List<Soldat> exercit){
       this.soldats = exercit;
   }

   /**
    * Mètode per posicionar l'exercit (left,right).
    * @param pos1 --> Posició de la x.
    * @param pos2 --> Posició de la y.
    */
   public void Posiciona(int pos1, int pos2){
       if(pos1 == 0 && pos2 == 0 ){

       for(int i = 0; i<this.soldats.size();i++){
           soldats.get(i).getImatge().setLocation(pos1 , pos2);
       }

       }if (pos1 == 800 && pos2 == 0){
           for(int i = 0; i<this.soldats.size();i++){
               soldats.get(i).getImatge().setLocation(pos1 - (soldats.get(i).getImatge().getWidth()), 0);

           }
       }
   }

   /**
    * Mètode per formar.
    */
   public void Formar(){
       int num_Files = ObtenirFiles(soldats);
       double alcadaSoldat = soldats.get(0).getImatge().getHeight();
       double ampladaSoldat = soldats.get(0).getImatge().getHeight();
       int indexFila = 0;

       double xActual = soldats.get(0).getImatge().getX();
       double yActual = soldats.get(0).getImatge().getY();

       for(int s = 0; s<soldats.size(); s++){



           if(indexFila <=num_Files ){
               soldats.get(s).getImatge().setLocation(xActual, yActual);
               yActual += alcadaSoldat;
               indexFila++;
               if(indexFila == num_Files){
                   indexFila = 0;
                   yActual = 0;
                   xActual += ampladaSoldat;

               }




       }

       }

   }



   /**
    * Mètode per obtenir el numero de files inicials.
    */
   public int ObtenirFiles(List<Soldat> soldats){
       Main camp = new Main ();
       double heightSoldat = soldats.get(0).getImatge().getHeight();
       double numFiles = camp.getCampy() / heightSoldat;
       int numFilesInt = (int) numFiles;
       return numFilesInt;
   }


public List<Soldat> getSoldats() {
    return soldats;
}


public void setSoldats(List<Soldat> soldats) {
    this.soldats = soldats;
}



}
