package com.commerce.microcommerce.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.commerce.microcommerce.model.Product;
import com.commerce.microcommerce.model.ProductMarge;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	//	public List<Product> findAll();
	//	
	//	
	Product findById(int id);

	List <Product> findByPrixGreaterThan(int prixLimit);
	
	@Query(value ="SELECT p.id, p.nom, p.prix, p.prix_achat FROM Product p WHERE p.prix > :prixLimit", nativeQuery = true)
	List<Product> rechercheUnProduitCher(@Param("prixLimit") int prix);
	
	
	@Query(value="SELECT p FROM Product p  ORDER BY p.nom")
	List<Product> trierProduitsParOrdreAlphabetique();
	


}
