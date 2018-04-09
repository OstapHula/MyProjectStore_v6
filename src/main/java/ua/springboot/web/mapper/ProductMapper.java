package ua.springboot.web.mapper;

import ua.springboot.web.domain.CreateProductRequest;
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
    
    /*public static ShowProductRequest productEntityToShowProductRequest(ProductEntity entity){
	ShowProductRequest request = new ShowProductRequest();
	QuantityOfProductEntity quantity = new QuantityOfProductEntity();
	quantity.setQuantity(0);
	
	request.setQuantity(quantity);
	request.setId(entity.getId());
	request.setName(entity.getName());
	request.setPrice(entity.getPrice());
	request.setDescription(entity.getDescription());
	request.setImagePath(entity.getImagePath());
	request.setInStock(entity.getInStock());
	request.setParameters(entity.getParameters());
	
	return request;
    }
    
    public static ProductEntity showProductRequestToProductEntity(ShowProductRequest request){
	ProductEntity entity = new ProductEntity();
	
	entity.setId(request.getId());
	entity.setName(request.getName());
	entity.setPrice(request.getPrice());
	entity.setDescription(request.getDescription());
	entity.setImagePath(request.getImagePath());
	entity.setInStock(request.getInStock());
	entity.setParameters(request.getParameters());
	entity.setQuantity(request.getQuantity());
	
	return entity;
    }*/
}
