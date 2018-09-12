package donnee;

import java.util.ArrayList;
import java.util.List;

import modele.Famille;

public class FamilleDAO {

	
	private List<Famille> simulerListerFamilles()
	{
		List<Famille> listeFamilleTest = new ArrayList<Famille>();
		listeFamilleTest.add(new Famille("dupont","FRancaise","62 boulevard perdu, Paris","Classe moyenne"));
		listeFamilleTest.add(new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne"));
		return listeFamilleTest;
	}
	public List<Famille> listerfamilles()
	{
		return this.simulerListerFamilles();
	}
}

