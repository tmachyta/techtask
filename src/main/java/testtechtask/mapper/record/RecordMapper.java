package testtechtask.mapper.record;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import testtechtask.config.MapperConfig;
import testtechtask.dto.record.CreateRecordRequest;
import testtechtask.dto.record.RecordDto;
import testtechtask.model.Record;

@Mapper(config = MapperConfig.class)
public interface RecordMapper {
    RecordDto toDto(Record record);

    @Mapping(target = "id", ignore = true)
    Record toModel(CreateRecordRequest request);
}
