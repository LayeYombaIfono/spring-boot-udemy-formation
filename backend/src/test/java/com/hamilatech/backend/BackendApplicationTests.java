package com.hamilatech.backend;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;
import com.hamilatech.backend.repository.CategoryRepository;
import com.hamilatech.backend.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	public   ProduitRepository produitRepository;

	@Autowired
	public CategoryRepository categoryRepository;

	/**
	 * Enregistrer un produit
	 */
	@Test
	public void testCreateProduit(){
		Produit produit = new Produit();
		produit.setNomProduit("Projecteur");
		produit.setPrixProduit(10000);
		produit.setDateCreation(new Date());

		produitRepository.save(produit);
	}

	/**
	 * Consulter un produit par son id
	 */
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(9L)
				.orElseThrow(()-> new RuntimeException("Le produit avec l'ID 4 n'a pas été trouvé"));
		System.out.println(p);
	}

	/**
	 * Mise à jour du produit
	 */
	@Test
	public void testUpdateProduit(){
		Produit produit = produitRepository.findById(9L)
						.orElseThrow(()-> new RuntimeException("Le produit avec l'ID 7 n'a pas été trouvé"));
		produit.setNomProduit("Imprimante");
		produit.setPrixProduit(80000.00);
		produitRepository.save(produit);
		System.out.println("Le produit a ete mise a jour "+produit.getNomProduit());
	}

	/**
	 * Supprimer un produit
	 */
	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(8L);
	}

	/**
	 * Afficher tous les produits
	 */
	@Test
	public void testGetAllProduit(){
		List<Produit>produits = produitRepository.findAll();

		for (Produit produit : produits){
			System.out.println("Nom: "+produit.getNomProduit()+"\nPrix: "+produit.getPrixProduit());
		}
	}

	/**
	 * Trouver un produit par son nom
	 */
	@Test
	public void findProduitByName(){
		List<Produit> produit = produitRepository.findByNomProduit("Vidéo projecteur");
		for (Produit p : produit){
			System.out.println("Le produit: "+p);
		}
	}

	/**
	 * Trouver un produit qui containe un nom
	 *
	 */
	@Test
	public void findProduitContains(){
		List<Produit> produits = produitRepository.findByNomProduitContains("Or");
		for (Produit produit : produits){
			System.out.println(produit.getNomProduit());
		}
	}

//	Test requete @Query
	@Test
	public void testFindByNomPrix(){
		List<Produit> produits = produitRepository.findByNomPrix(
				"Ordinateur Dell",
				1500.23
		);
		for (Produit produit : produits){
			System.out.println("Le produit : "+ produit.getNomProduit()+"\nPrix: "+produit.getPrixProduit());

		}
	}

	/**
	 * Opérations CRUD pour la catégorie
	 */

	//	Enregistrer une catégorie
	@Test
	public void testAddCategory(){
		Categorie categorie = new Categorie();
		categorie.setNomCat("Projecteur");
		categorie.setDescriptionCat("Vidéo projecteur Epson");

		categoryRepository.save(categorie);
	}

//	Test pour trouver des produits par categorie
	@Test
	public void findByCategoryProduct(){
		Categorie cat = new Categorie();
		cat.setIdCat(7L);
		List<Produit> categorys = produitRepository.findByCategory(cat);

		for (Produit category : categorys){
			System.out.println("Liste de produit de categorie 1 : " + category.getNomProduit());
		}

	}

//	Test pour trouver une categorie par id
//	@Test
//	public  void testFindByCategoryByIcat(){
//
//		List<Produit> produitCategory = produitRepository.findByCategoryIdCat(1L);
//
//		for (Produit category : produitCategory){
//			System.out.println(category);
//		}
//	}

//	Test pour trier des produits par ordre croissant
	@Test
	public void finByProduitAsc(){
		List<Produit> produits = produitRepository.findByOrderByNomProduitAsc();

		for (Produit produit : produits){
			System.out.println(produit.getNomProduit());
		}
	}


//Trier des produits par odre croissant et les prix par ordre decoissant avec JPA Query
	@Test
	public void trierProduitNomPrix(){
		List<Produit> produits = produitRepository.trierProduitsNomPrix();

		for (Produit produit : produits){
			System.out.println("Nom -> "+produit.getNomProduit() +" \nprix -> " +produit.getPrixProduit() );
		}
	}

}
