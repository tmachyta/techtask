package testtechtask.dto.record;

import java.time.LocalDate;
import lombok.Data;
import testtechtask.model.Record;

@Data
public class RecordDto {
    private Long id;
    private LocalDate entryDate;
    private String itemCode;
    private String itemName;
    private int itemQuantity;
    private Record.Status status;
}
