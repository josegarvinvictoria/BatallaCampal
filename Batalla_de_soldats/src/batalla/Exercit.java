package batalla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;

/**
 * Classe per crear objectes de tipus "Exercit".
 *
 * @author Jose Garvin Victoria
 *
 */
public class Exercit {

	ArrayList<Double> ySoldats = new ArrayList<>();

	/**
	 * Tamany màxim del camp.
	 */
	private static final int TAMANYMAXIM = 800;

	/**
	 * ArrayList amb els soldats que componen un exercit.
	 */
	private List<SoldatGeneral> soldats;

	/**
	 * Variable que emmagatzema la posicio de l'exercit. -1: L'exercit es
	 * col.loca a la dreta / 1: L'exerci es col.loca a la dreta.
	 */
	private int ubicacio;

	/**
	 * Creació de l'objecte camp.
	 */

	/**
	 * Constructor d'objectes de tipues "Exercit".
	 *
	 * @param exercit
	 *            --> Llista de soldats de l'exercit.
	 * @param ubica
	 *            --> Ubicació de l'exercit. 1:Dreta / -1Esquerra.
	 */
	public Exercit(final List<SoldatGeneral> exercit, final int ubica) {
		this.soldats = exercit;
		this.ubicacio = ubica;

	}

	/**
	 * Mètode per posicionar l'exercit (left,right).
	 *
	 * @param pos1
	 *            --> Posició de la x.
	 * @param pos2
	 *            --> Posició de la y.
	 */
	final void posiciona(final int pos1, final int pos2) {
		if (pos1 == 0 && pos2 == 0) {

			for (int i = 0; i < this.soldats.size(); i++) {
				soldats.get(i).PosatA(pos1, pos2);
			}

		}
		if (pos1 == TAMANYMAXIM && pos2 == 0) {
			for (int i = 0; i < this.soldats.size(); i++) {
				soldats.get(i)
						.PosatA(pos1 - (soldats.get(i).obtenirWidth()), 0);

			}
		}
	}

	/**
	 * Nou mètode per formar els exercits!
	 */
	final void Formar(final Campbatalla campB) {
		// int numFiles = campB.obtenirFiles(soldats);
		ySoldats = calculYsoldats(campB);

		for (double y : ySoldats) {
			System.out.println(y + " / ");
		}

		// Pinto els soldats forman-los com els hi toca.
		for (int i = 0; i < soldats.size(); i++) {
			// Si l'exercit esta a l'esquerra
			if (this.ubicacio == -1) {

				// Si l'exercit esta a l'esquerra i conte SoldatsGegants cal
				// voltejar l'imatge.
				if (soldats.get(i) instanceof SoldatGegant) {
					soldats.get(i).flipHorizontal();
				}

				if (campB.getCampy() < ySoldats.get(i)
						+ soldats.get(i).obtenirHeight()) {
					ySoldats.add(0.0);
					// soldats.get(i).PosatA(0, 0);

					// CONTROLAR LA X DELS SOLDATS DE LA SEGONA FILAAAAAAAAAA!

					// El següent pas consisteix en anar moven els soldats
					// perque no toquin amb els seus companys.

				} else {
					soldats.get(i).PosatA(0, ySoldats.get(i));
					
				}
				if(i != 0){
					SepararseEntreAliats(i);
				}
				

			} else {
				double posX = campB.getCampx() - soldats.get(i).obtenirWidth();
				// Si l'exercit esta a la dreta i conte un SoldatRei cal
				// voltejar l'imatge.
				if (soldats.get(i) instanceof SoldatRei) {
					soldats.get(i).flipHorizontal();
				}
				// soldats.get(i).PosatA((campB.getCampx() -
				// soldats.get(i).obtenirWidth()), ySoldats.get(i));

				if (campB.getCampy() < ySoldats.get(i)
						+ soldats.get(i).obtenirHeight()) {

					ySoldats.add(0.0);
					// soldats.get(i).PosatA(0, 0);

					// CONTROLAR LA X DELS SOLDATS DE LA SEGONA FILAAAAAAAAAA!

				} else {
					soldats.get(i).PosatA(posX, ySoldats.get(i));
					
					if(i != 0){
						SepararseEntreAliats(i);
					}
					
				}

			}
		}
	}

	public void SepararseEntreAliats(int i) {
		for (int j = 0; j < i; j++) {
			// Si el soldat toca, l'anem movent cap endevant.
			while ((soldats.get(i).soldatToca(soldats.get(j)))) {
				if (this.ubicacio == -1) {
					soldats.get(i).getImatge().move(1, 0);
					
				}else{
					soldats.get(i).getImatge().move(-1, 0);
				}

			}
			
		}

	}

	public ArrayList<Double> calculYsoldats(Campbatalla campB) {
		ArrayList<Double> ySoldats = new ArrayList<>();

		// Afegim el primer index de y que sera 0

		// Recorreguem els soldats de l'exercit.
		for (int i = 0; i < soldats.size(); i++) {

			/**
			 * Calculem la col.locacio de la y dels soldats i la dessem a un
			 * array.
			 */

			// if (soldats.get(i).obtenirHeight() == 72) {
			// Si el soldat es dels "petits", afegim a l'array el valor referent
			// a la seva y.
			if (i == 0) {
				// Si l'array no te res afegim el valor.
				ySoldats.add(0.0);

			} else {
				double posY = ySoldats.get(ySoldats.size() - 1);
				// Si l'array ja ha estat tocat, sumem la y del soldat actual
				// a,b la del ultim soldat col.locat.

				// Si l'array supera el tamny de la finestra...
				if (campB.getCampy() < posY + soldats.get(i).obtenirHeight()) {
					ySoldats.add(0.0);

				} else {
					ySoldats.add(posY + soldats.get(i).obtenirHeight());
					
				}
			}
			// }

		}
		return ySoldats;
	}

	/**
	 * Metode per formar (Amb setLocation!).
	 *
	 * @param campB
	 *            --> Camp de batalla on s'ha de formar l'exercit.
	 */
	final void formar(final Campbatalla campB) {

		int numFiles = campB.obtenirFiles();
		double alcadaSoldat = soldats.get(0).obtenirHeight();
		double ampladaSoldat = soldats.get(0).obtenirWidth();
		int indexFila = 0;

		double xActual = soldats.get(0).obtenirX();
		double yActual = 0;

		for (int s = 0; s < soldats.size(); s++) {
			if (indexFila <= numFiles) {

				soldats.get(s).PosatA(xActual, yActual);
				yActual += alcadaSoldat;
				indexFila++;
				if (indexFila == numFiles) {
					indexFila = 0;
					yActual = 0;

					// Si l'ubicació es igual -1 posicionem els soldats a
					// l'esquerra.
					if (ubicacio == -1) {

						xActual += ampladaSoldat;
						if (soldats.get(s) instanceof SoldatGegant) {
							soldats.get(s).flipHorizontal();
						}

						// Si l'ubicació es igual a 1 els posicionem a la
						// dreta.
					} else if (ubicacio == 1) {

						// Si es un rei, voltejem la imatge.
						if (soldats.get(s) instanceof SoldatRei) {
							soldats.get(s).flipHorizontal();

						}
						xActual -= ampladaSoldat;
					}

				}
			}

		}

	}

	/**
	 * Metode per moure els soldats de un exercit.
	 *
	 * @param pissarra
	 *            --> Camp on s'han de moure el soldats.
	 */
	final void moureExercit(final Main pissarra, final Campbatalla campbatalla) {

		Random r = new Random();

		int indexRandom = r.nextInt(soldats.size());

		if (!soldats.get(indexRandom).isHaArribat()) {
			soldats.get(indexRandom).mouSoldat(ubicacio, pissarra, campbatalla);

		}

	}

	/**
	 * Metode per comprovar si tots els soldats han arribat al final.
	 *
	 * @return --> True: Si tots el soldats han arribat / False: Si els soldats
	 *         no han arribat.
	 */
	final boolean hanArribatAlFinal() {
		int cont = 0;
		for (int i = 0; i < soldats.size(); i++) {
			if (soldats.get(i).isHaArribat()) {
				cont++;
			}
		}

		if (cont == soldats.size()) {

			return true;
		}

		return false;

	}

	/**
	 * Mètode per canviar l'ubicacio de un exercit quan arriba al seu desti.
	 *
	 * @param ubicacioActual
	 *            --> Nova ubicació de l'exercit.
	 */
	final void canviaUbicacio(final int ubicacioActual) {
		if (ubicacioActual == 1) {
			this.ubicacio = -1;
		} else {
			this.ubicacio = 1;
		}
	}

	/**
	 * Mètode per comprovar els morts d'un exercit despres de rebre un atac.
	 *
	 * @param atacats
	 *            --> Exercit amb el soldats que són atacs.
	 */
	final void comprovaMorts(final List<SoldatGeneral> atacats) {
		int tamanyExercit = this.soldats.size();

		// Es recorren els exercits per cercar els morts.
		for (int i = atacats.size() - 1; i >= 0; i--) {

			for (int j = tamanyExercit - 1; j >= 0; j--) {

				// Si dos soldats d'exercits diferents toquen, i son de dal
				// mateixa fila ha de morir.
				if (atacats.get(i).soldatToca(this.soldats.get(j))) {

					GImage imatge = atacats.get(i).getImatge();
					imatge.getParent().remove(imatge);
					atacats.remove(i);
					// tamanyExercit--;

					break;
					// this.soldats.remove(j);

				}
			}

		}
	}

	/**
	 * Mètode per reinicialitzar cadascun dels soldats d'un exercit.
	 */
	final void reinicialitzaExercit() {
		for (int i = 0; i < soldats.size(); i++) {
			soldats.get(i).reinicialitzaSoldat();
		}
	}

	/**
	 * Mètode per obtenir una llista de soldats.
	 *
	 * @return --> Retorna una llista de soldats.
	 */
	final List<SoldatGeneral> getSoldats() {
		return soldats;
	}

	/**
	 * Mètode per assignar una llista de soldats.
	 *
	 * @param soldatsE
	 *            --> Li passem una llista de soldats.
	 */
	final void setSoldats(final List<SoldatGeneral> soldatsE) {
		this.soldats = soldatsE;
	}

	/**
	 * Mètode per obtenir l'ubicació d'un exercit.
	 *
	 * @return --> 1: Dreta / -1: Esquerra.
	 */
	final int getUbicacio() {
		return ubicacio;
	}

	/**
	 * Mètode per especificar l'ubicació d'un exercit.
	 *
	 * @param ubicacioE
	 *            --> 1: Dreta / -1: Esquerra.
	 */
	final void setUbicacio(final int ubicacioE) {
		this.ubicacio = ubicacioE;
	}

}
