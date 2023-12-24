package testtechtask.service.product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testtechtask.dto.product.CreateProductRecordRequest;
import testtechtask.dto.product.ProductDto;
import testtechtask.dto.record.CreateRecordRequest;
import testtechtask.mapper.product.ProductMapper;
import testtechtask.mapper.record.RecordMapper;
import testtechtask.model.Product;
import testtechtask.model.Record;
import testtechtask.repository.product.ProductRepository;
import testtechtask.repository.record.RecordRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto save(CreateProductRecordRequest request) {
        Product newProduct = productMapper.toNewModel(request);

        Product savedProduct = productRepository.save(newProduct);

        Set<CreateRecordRequest> createRecordRequests = request.getRecords();

        Set<Record> savedRecords = createRecordRequests.stream()
                .map(createRecordRequest -> {
                    Record record = recordMapper.toModel(createRecordRequest);
                    record.setProduct(savedProduct);
                    return recordRepository.save(record);
                })
                .collect(Collectors.toSet());

        ProductDto result = productMapper.toDto(savedProduct);
        result.setRecords(productMapper.toRecordDtoSet(savedRecords));

        return result;
    }
}
