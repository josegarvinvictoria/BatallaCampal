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


   public void Posiciona(int pos1, int pos2){
       if(pos1 == 0 || pos == ){

       for(int i = 0; i<this.soldats.size();i++){
           soldats.get(i).getImatge().setLocation(pos1 - (soldats.get(i).getImatge().getWidth()), 0);

       }}else if (pos2 == 800){
           for(int i = 0; i<this.soldats.size();i++){
               soldats.get(i).getImatge().setLocation(pos2, 0);

           }

       }
   }



}
