package com.sudhakar.store.services;
import static org.springframework.data.cassandra.repository.support.BasicMapId.id;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import com.sudhakar.store.domain.Productratings;
import com.sudhakar.store.repository.ProductRatingRepository;


@Service
public class ProductRatingService {
	
	    @Autowired
	    private ProductRatingRepository productRatingRepository;

/*	    public Product_basic createProductBasic(Product_basic productbasic){
	        return productRatingRepository.save(productbasic);
	    }*/

	    public Productratings findProductById(String product_id){
	        MapId id = id("product_id", product_id);
	        return productRatingRepository.findOne(id);
	    }

	    public List<Productratings> getProductRatings(){
	        return (List<Productratings>) productRatingRepository.findAll();
	    }

	    public Productratings editProductratings(Productratings productrating){
	        return productRatingRepository.save(productrating);
	    }

	    /*	    public void deleteProduct_basic(String product_id){
	        MapId id = id("product_id", product_id);
	        productBasicRepository.delete(id);
	    }*/

	    public boolean exitsProductRatings(String product_id){
	        MapId id = id("product_id", product_id);
	        return productRatingRepository.exists(id);
	    }


}
