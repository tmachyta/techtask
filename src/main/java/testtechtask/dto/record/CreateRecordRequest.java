package testtechtask.dto.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;
import testtechtask.model.Record;

@Data
public class CreateRecordRequest {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate entryDate;
    private String itemCode;
    private String itemName;
    private int itemQuantity;
    private Record.Status status;
}
