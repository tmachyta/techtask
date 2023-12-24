package testtechtask.dto.product;

import java.util.Set;
import lombok.Data;
import testtechtask.dto.record.RecordDto;

@Data
public class ProductDto {
    private Long id;
    private String tableName;
    private Set<RecordDto> records;
}
