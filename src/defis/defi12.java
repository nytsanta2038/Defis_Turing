package defis;

import java.util.ArrayList;
import java.util.List;

public class defi12 {
	
	
	/**
	 * 
	 * @param entier n
	 * @return n-ième nombre triangulaire
	 */
	private static int n_triangulaire(int n) 
	{
		return (n/2)*(n+1);
	}
	
	
	/**
	 * 
	 * @param entier n
	 * @return Liste de la décomposition en facteurs premiers de n
	 */
	private static List<Integer> decomp_nbre_prem(int n) {
		List<Integer> liste = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++)
		{
			while(n%i == 0)
			{
				liste.add(i);
				n/= i;
			}
		}
		return liste;
	}
	
	/**
	 * 
	 * @param Liste des diviseurs non factorisés
	 * @return Liste du nombre de diviseurs similaires +1
	 */
	private static List<Integer> pow_fact(List<Integer> l)
	{
		int cpt = 1;
		List<Integer> liste = new ArrayList<Integer>();
		for(int i = 0; i < l.size()-1; i++)
		{
			if(l.get(i) == l.get(i+1))
			{
				cpt++;
			}
			else
			{
				liste.add(cpt+1);
				cpt = 1;
			}
		}
		liste.add(cpt+1);
		return liste;
	}
	
	/**
	 * 
	 * @param Liste
	 * @return le nombre de diviseur d'un entier en fonction de la liste des puissance de ses diviseurs premiers
	 */
	private static int nbre_diviseur(List<Integer> l)
	{
		int cpt = 1;
		for(int i = 0; i < l.size(); i++)
		{
			cpt *= l.get(i);
		}
		return cpt;
	}
	
	/**
	 * 
	 * @param Entier
	 * @return Nombre de diviseur de n
	 */
	private static int nombre_diviseur(int n) {
		return nbre_diviseur(pow_fact(decomp_nbre_prem(n)));
	}
	
	/**
	 * 
	 * @param Entier n-ième nombre triangulaire
	 * @return nombre de diviseurs du n-ième nombre triangulaire
	 */
	private static int nbre_diviseur_tri(int n)
	{
		return nombre_diviseur(n_triangulaire(n));
	}
	
	
	public static int resolution_pb12()
	{
		int cpt = 10000;
		while(nbre_diviseur_tri(cpt) < 1000)
		{
			cpt ++;
		}
		return n_triangulaire(cpt);
	}
}
