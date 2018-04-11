package ua.springboot.web.mapper;

import java.io.IOException;

import ua.springboot.web.domain.product.CreateProductRequest;
import ua.springboot.web.domain.product.EditProductRequest;
import ua.springboot.web.entity.ParametersProductEntity;
import ua.springboot.web.entity.ProductEntity;

public interface ProductMapper {
    
    public static ProductEntity createProductRequestToProductEntity(CreateProductRequest request){
	ParametersProductEntity parameters = new ParametersProductEntity();
	
	parameters.setStyle(request.getStyle());
	parameters.setMaterialStrap(request.getMaterialStrap());
	parameters.setMaterialBody(request.getMaterialBody());
	parameters.setFaseType(request.getFaseType());
	parameters.setFaseColor(request.getFaseColor());
	parameters.setWeight(request.getWeight());
	parameters.setWaterproof(request.getWaterproof());
	parameters.setGlass(request.getGlass());
	parameters.setWidthStrap(request.getWidthStrap());
	parameters.setDiametrBody(request.getDiametrBody());
	parameters.setThicknessBody(request.getThicknessBody());
	
	ProductEntity entity = new ProductEntity();
	entity.setName(request.getName());
	entity.setPrice(request.getPrice());
	entity.setDescription(request.getDescription());
	entity.setImagePath(request.getProductImage().getOriginalFilename());
	entity.setInStock(request.getInStock());
	entity.setParameters(parameters);
	
	return entity;
    }
    
    public static EditProductRequest productEntityToEditProductRequest(ProductEntity entity, ParametersProductEntity parameters){
	EditProductRequest request = new EditProductRequest();
	
	request.setParameterId(parameters.getId());
	request.setStyle(parameters.getStyle());
	request.setMaterialStrap(parameters.getMaterialStrap());
	request.setMaterialBody(parameters.getMaterialBody());
	request.setFaseType(parameters.getFaseType());
	request.setFaseColor(parameters.getFaseColor());
	request.setWeight(parameters.getWeight());
	request.setWaterproof(parameters.getWaterproof());
	request.setGlass(parameters.getGlass());
	request.setWidthStrap(parameters.getWidthStrap());
	request.setDiametrBody(parameters.getDiametrBody());
	request.setThicknessBody(parameters.getThicknessBody());
	
	request.setProductId(entity.getId());
	request.setName(entity.getName());
	request.setPrice(entity.getPrice());
	request.setDescription(entity.getDescription());
	request.setInStock(entity.getInStock());
	request.setOldImage(entity.getImagePath());
	
	return request;
    }
    
    public static ProductEntity editProductRequestToProductEntity(EditProductRequest request) throws IOException{
	ParametersProductEntity parameters = new ParametersProductEntity();
	
	parameters.setId(request.getParameterId());
	parameters.setStyle(request.getStyle());
	parameters.setMaterialStrap(request.getMaterialStrap());
	parameters.setMaterialBody(request.getMaterialBody());
	parameters.setFaseType(request.getFaseType());
	parameters.setFaseColor(request.getFaseColor());
	parameters.setWeight(request.getWeight());
	parameters.setWaterproof(request.getWaterproof());
	parameters.setGlass(request.getGlass());
	parameters.setWidthStrap(request.getWidthStrap());
	parameters.setDiametrBody(request.getDiametrBody());
	parameters.setThicknessBody(request.getThicknessBody());
	
	ProductEntity entity = new ProductEntity();
	
	entity.setParameters(parameters);
	entity.setId(request.getProductId());
	entity.setName(request.getName());
	entity.setPrice(request.getPrice());
	entity.setDescription(request.getDescription());
	entity.setInStock(request.getInStock());

	if(!request.getFile().isEmpty()) { 
	    entity.setImagePath(request.getFile().getOriginalFilename());
	} else {
	    entity.setImagePath(request.getOldImage());
	}
	
	return entity;
    }
}