package cl.duoc.ms_products_db.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_products_db.model.dto.ProductDTO;
import cl.duoc.ms_products_db.model.entities.Product;
import cl.duoc.ms_products_db.model.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


     public ProductDTO findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);       
        //Validamos si existe o no
        ProductDTO productDto = null;

        if(product.isPresent()){
            productDto = translateEntityToDto(product.get());          
        } 

        return productDto;

    }

     public ProductDTO translateEntityToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        //salesDto.setSalesDate(sale.getSalesDate());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

}
