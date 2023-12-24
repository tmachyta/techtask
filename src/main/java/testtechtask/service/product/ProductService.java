package testtechtask.service.product;

import java.util.List;
import testtechtask.dto.product.CreateProductRecordRequest;
import testtechtask.dto.product.ProductDto;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto save(CreateProductRecordRequest request);
}
