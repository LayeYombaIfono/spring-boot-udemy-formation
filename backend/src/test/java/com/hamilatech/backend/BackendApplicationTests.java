package com.hamilatech.backend;

import com.hamilatech.backend.entities.Produit;
import com.hamilatech.backend.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private  ProduitRepository produitRepository;

	/**
	 * Enregistrer un produit
	 */
    @Test
	public void testCreateProduit(){
		Produit produit2 = new Produit("Souris sans file",2500,new Date() );
		produitRepository.save(produit2);
	}


	/**
	 * Consulter un produit par son id
	 */
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p.toString());
	}

	/**
	 * Mise à jour du produit
	 */
	@Test
	public void testUpdateProduit(){
		Produit produit = produitRepository.findById(2l).get();
		produit.setNomProduit("Ordinateur Hp");
		produitRepository.save(produit);
		System.out.println("Le produit a ete mise a jour "+produit.getNomProduit());
	}

	/**
	 * Supprimer un produit
	 */
	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(3L);
	}

	/**
	 * Afficher tous les produits
	 */
	@Test
	public void testGetAllProduit(){
		List<Produit>produits = produitRepository.findAll();

		for (Produit produit : produits){
			System.out.println(produit.getNomProduit());
		}

	}

	@Test
	void contextLoads() {

	}

}
