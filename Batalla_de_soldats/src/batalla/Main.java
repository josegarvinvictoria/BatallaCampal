package batalla;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * Classe principal del programa "Batalla Campal".
 *
 * @author Jose Garvin Victoria.
 *
 */
public class Main extends GraphicsProgram {

    /**
     * Número de soldats de tipus "SoldatArmilla" per exercit.
     */
    private static final int NUM_SOLDATS_ARMILLA = 4;

    /**
     * Número de soldats de tipus "SoldatGegant" per exercit.
     */
    private static final int NUM_SOLDATS_GEGANTS = 3;

    /**
     * Tamany de la font que s'utilitza en el metode del controlInici().
     */
    private static final int T_FONT = 15;

    /**
     * Número de soldats de tipus "SoldatRas" per exercit.
     */
    private static final int SOLDATS_RAS_PER_EXERCIT = 14;

    /**
     * Enter que indica els milisegons de pause entre el moviment dels exercits.
     */
    private static final int VALOR_PAUSE = 5;

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Tamany X de la finestra.
     */
    private static final int TAMANY_X = 1200;

    /**
     * Tamany Y de la finestra.
     */
    private static final int TAMANY_Y = 600;

    /**
     * Creacio de l'objecte CampBatalla.
     */
    private Campbatalla camp = new Campbatalla(TAMANY_X, TAMANY_Y);

    /**
     * Mètode principal del programa.
     */
    public final void run() {

        /**
         * Assignem un tamany a la finestra.
         */
        this.setSize(camp.getCampx(), camp.getCampy());
        // add(new GImage("body-background.png"));
        /**
         * Afegim els exercits al camp.
         */
        camp.afegirExercit(new Exercit(crearExercit("soldier1.png"), -1));
        camp.afegirExercit(new Exercit(crearExercit("soldier2.png"), 1));

        /**
         * Posicionem els exercits que hi ha al camp de batalla.
         */
        for (int i = 0; i < camp.getExercits().size(); i++) {
            if (camp.getExercits().get(i).getUbicacio() == -1) {
                camp.getExercits().get(i).posiciona(0, 0);
            } else {
                camp.getExercits().get(i).posiciona(camp.getCampx(), 0);
            }
        }

        /**
         * Obtenim el numero de files i l'assignem a "CampBatalla".
         */
        camp.setNumfiles(camp.obtenirFiles());

        /**
         * Fem que els exercits es formin.
         */
        formarExercits(camp);
        orientarImatges();
        /**
         * Iniciem la batalla!
         */

        /**
         * Crida del mètode per controlar l'inici de la guerra.
         */
        controlInici();

        while (!camp.guanyadorTrobat()) {
            iniciarBatalla();
        }

    }

    /**
     * Mètode per iniciar la batalla de soldats.
     */
    final void iniciarBatalla() {

        boolean hanArribat = camp.getExercits().get(0).hanArribatAlFinal()
                && camp.getExercits().get(1).hanArribatAlFinal();

        while (!hanArribat) {

            for (int i = 0; i < camp.getExercits().size(); i++) {
                Exercit exercit = camp.getExercits().get(i);
                if (exercit.getSoldats().size() != 0) {

                    exercit.moureExercit(this, camp);

                }
                this.pause(VALOR_PAUSE);
                exercit.comprovaMorts(camp.getExercits()
                        .get(cercaExercitOponent(i)).getSoldats());
            }

            hanArribat = camp.getExercits().get(0).hanArribatAlFinal()
                    && camp.getExercits().get(1).hanArribatAlFinal();

        }

        if (!camp.guanyadorTrobat()) {
            reinicialitzarExercits();
            formarExercits(camp);

        }

    }

    /**
     * Mètode per voltejar imatges.
     */
    final void orientarImatges() {
        List<Exercit> exercits = camp.getExercits();
        for (int i = 0; i < exercits.size(); i++) {

            List<SoldatGeneral> soldats = exercits.get(i).getSoldats();
            for (int s = 0; s < soldats.size(); s++) {
                if (exercits.get(i).getUbicacio() == -1) {
                    if (soldats.get(s) instanceof SoldatGegant) {
                        soldats.get(s).flipHorizontal();
                    }

                } else {
                    if (soldats.get(s) instanceof SoldatRei) {
                        soldats.get(s).flipHorizontal();
                    }
                }
            }
        }
    }

    /**
     * Mètode per determinar quin es l'exercit oponent d'un altre a partir de la
     * posicio en l'array d'exercits.
     *
     * @param exercitActual
     *            --> Exercit del qual volem saber el seu oponent.
     * @return --> Retorna un enter que correpont a la pos de l'exercit oponent
     *         a l'array.
     */
    final int cercaExercitOponent(final int exercitActual) {
        if (exercitActual == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Mètode per formar els exercits al camp de batalla.
     *
     * @param campBatlla
     *            --> Passem per paràmetre l'objecte "CampBatalla".
     */
    final void formarExercits(final Campbatalla campBatlla) {
        for (int i = 0; i < campBatlla.getExercits().size(); i++) {
            Exercit exercit = campBatlla.getExercits().get(i);
            exercit.formarExercits(campBatlla);
        }
    }

    /**
     * Mètode per crear exercits.
     *
     * @param imatgeSoldatRas
     *            --> Ruta a la imatge del soldat ras.
     * @return --> Retorna un arrayList de Soldats.
     */
    final List<SoldatGeneral> crearExercit(final String imatgeSoldatRas) {
        List<SoldatGeneral> exercit = new ArrayList<>();

        // Creem el rei i l'afegim a l'array i a la pissara.
        SoldatRei soldatA = new SoldatRei(new GImage("king.png"));
        exercit.add(soldatA);
        add(soldatA.getImatge());

        for (int i = 0; i < SOLDATS_RAS_PER_EXERCIT; i++) {
            SoldatRas soldat = new SoldatRas(new GImage(imatgeSoldatRas));
            exercit.add(soldat);

            // Afegir soldats a la pisarra!
            add(soldat.getImatge());

            if (i < NUM_SOLDATS_ARMILLA) {
                SoldatArmilla soldatB = new SoldatArmilla(new GImage(
                        "soldier3.png"));
                exercit.add(soldatB);
                add(soldatB.getImatge());
            }

            if (i < NUM_SOLDATS_GEGANTS) {
                SoldatGegant soldatG = new SoldatGegant(new GImage(
                        "giant.png"));
                exercit.add(soldatG);
                add(soldatG.getImatge());
            }
        }

        return exercit;
    }

    /**
     * Mètode per reinicialiar els exercits.
     */
    final void reinicialitzarExercits() {
        for (int i = 0; i < camp.getExercits().size(); i++) {
            // Canvi d'ubicació
            camp.getExercits().get(i)
                    .canviaUbicacio(camp.getExercits().get(i).getUbicacio());
            // Canvi de haArribat a false.
            camp.getExercits().get(i).reinicialitzaExercit();
            orientarImatges();

        }
    }

    /**
     * Mètode que s'encarrega del control de l'inici del programa.
     */
    final void controlInici() {
        GLabel glabel = new GLabel("Click per començar la batalla!");
        glabel.setLocation(TAMANY_X / 2 - (glabel.getWidth() / 2),
                TAMANY_Y / 2);
        glabel.setFont(new Font("Liberation Serif", Font.ITALIC, T_FONT));
        add(glabel);
        waitForClick();
        remove(glabel);

    }

}
