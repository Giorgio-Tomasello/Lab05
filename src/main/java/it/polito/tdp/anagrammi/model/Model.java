package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	LinkedList <String> parole; 
	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		
		this.anagrammaDAO=new AnagrammaDAO();
		
		
	}
	
	public boolean isCorrect(String s) {
		
		return this.anagrammaDAO.isCorrect(s);
	}
	
	public void anagramma(String s) {
		this.parole= new LinkedList <String>();
		anagramma_ricorsiva("", 0, s);
		
	}

	
	
	
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if (rimanenti.length() == 0) { /* caso terminale */
			//System.out.println(parziale);
			parole.add(parziale);
			
		} else {
			/* caso normale */
			// es: parziale="AC", livello=2, rimanenti="BD"
			for (int pos = 0; pos < rimanenti.length(); pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1);
				anagramma_ricorsiva(nuova_parziale, livello + 1, nuova_rimanenti);
			}
		}
	}

	public LinkedList<String> getParole() {
		return parole;
	}

	public void setParole() {
		this.parole = null;
	}
	

	
	
}
