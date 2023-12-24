package testtechtask.mapper.product;

import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import testtechtask.config.MapperConfig;
import testtechtask.dto.product.CreateProductRecordRequest;
import testtechtask.dto.product.ProductDto;
import testtechtask.dto.record.RecordDto;
import testtechtask.model.Product;
import testtechtask.model.Record;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {
    ProductDto toDto(Product product);

    @Mapping(target = "records", ignore = true)
    Product toNewModel(CreateProductRecordRequest request);

    RecordDto toRecordDto(Record record);

    Set<RecordDto> toRecordDtoSet(Set<Record> records);
}
