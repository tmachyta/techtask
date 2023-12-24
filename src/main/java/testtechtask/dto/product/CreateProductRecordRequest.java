package testtechtask.dto.product;

import java.util.Set;
import lombok.Data;
import testtechtask.dto.record.CreateRecordRequest;

@Data
public class CreateProductRecordRequest {
    private String tableName;
    private Set<CreateRecordRequest> records;
}
