package com.commerce.microcommerce.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;











import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.commerce.microcommerce.dao.ProductDao;
import com.commerce.microcommerce.exceptions.ProduitGratuitException;
import com.commerce.microcommerce.exceptions.ProduitIntrovableException;
import com.commerce.microcommerce.model.Product;
import com.commerce.microcommerce.model.ProductMarge;

@Api(description = "Gestion de produits")
@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@GetMapping(value = "Produits")
	public List<Product> listeProduits(){

		return productDao.findAll();
	}

	//Produits/{id}
	@ApiOperation(value ="Récupére un produit selon son ID")
	@GetMapping(value ="Produits/{id}")
	public Product afficherUnProduit(@PathVariable int id) throws ProduitIntrovableException{

		Product product = productDao.findById(id);
		if(product == null) throw new ProduitIntrovableException("Le produit avec l id "+ id +" n existe pas");
		return product;
	}


	@PostMapping(value="/Produits")
	public ResponseEntity<Void> AjouterUnProduit(@Valid  @RequestBody Product product) throws ProduitGratuitException{
		
		if(product.getPrix()== 0) throw new ProduitGratuitException("Le prix de produit est égale à 0");
		
		Product product1 = productDao.save(product);

		if(product1 == null) return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product1.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping(value ="test/Produits/{prixLimit}")
	public List<Product> afficheeProduitsAvecPrixLimiti(@PathVariable int prixLimit){
		return productDao.findByPrixGreaterThan(prixLimit);
	}


	@RequestMapping(value ="ProduitMerge/{id}", method=RequestMethod.GET)
	public Integer calculerMargeProduit(@PathVariable int id){
		Product product = productDao.findById(id);
		return Math.subtractExact(product.getPrix(),product.getPrixAchat());
	}


	//	@GetMapping(value ="ProduitTri")
	//	public List<Product> trierProduitsParOrdreAlphabetique (){
	//		return productDao.findAllOrderBynom();
	//	}



	@GetMapping(value ="test1/Produits/{prixAchat}")
	public List<Product> afficheeProduitsAvecPrixLimitiReqSQL(@PathVariable int prixAchat){
		return productDao.rechercheUnProduitCher(prixAchat);
	}


	@RequestMapping(value ="TriProduits",method=RequestMethod.GET)
	public List<Product> trierProduitsParOrdreAlphabetique(){
		return productDao.trierProduitsParOrdreAlphabetique();
	}

	
	@GetMapping(value="AdminProduits")
	public List<ProductMarge> calculerMargeProduit(){
		ProductMarge productMarge= new ProductMarge();
		List<ProductMarge> productMarges = new ArrayList<ProductMarge>();
		
		List<Product> products = productDao.findAll();
		for(Product product : products){
			productMarge.setProduct(product);
			productMarge.setMarge(Math.subtractExact(product.getPrix(), product.getPrixAchat()));	
			productMarges.add(productMarge);
		}
		return productMarges;		
	}

}
