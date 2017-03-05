package com.sudhakar.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhakar.store.domain.Productratings;
import com.sudhakar.store.services.ProductRatingService;

@Controller
@RequestMapping("/item/ratings/v1")
public class ProductRatingsController {

    @Autowired
    private ProductRatingService service;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<List<Productratings>> getProducts(){
        return new ResponseEntity<List<Productratings>>(service.getProductRatings(), HttpStatus.OK);
    }
    
    @RequestMapping( path = "/{id}", method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Productratings> getProductRatingById(@PathVariable(required = true) String id){
        if(!service.exitsProductRatings(id)){
            return new ResponseEntity<Productratings>(HttpStatus.NOT_FOUND);
        }
        Productratings productRating = service.findProductById(id);
        return new ResponseEntity<Productratings>(productRating,HttpStatus.ACCEPTED);
    }

    @RequestMapping(  method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Productratings> editProductRating(@RequestBody Productratings productRating){
        if(productRating.getProduct_id() == null || !service.exitsProductRatings(productRating.getProduct_id())){
            return new ResponseEntity<Productratings>(HttpStatus.NOT_FOUND);
        }
        Productratings ratingEdited = service.editProductratings(productRating);
        return new ResponseEntity<Productratings>(ratingEdited, HttpStatus.ACCEPTED);
}    

}

