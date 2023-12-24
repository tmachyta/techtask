package testtechtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE records SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@Table(name = "records")
public class Record {
    public enum Status {
        PAID,
        NOT_PAID,
        IN_PROGRESS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate entryDate;
    private String itemCode;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private int itemQuantity;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
    private boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record = (Record) o;
        return itemQuantity == record.itemQuantity
                && isDeleted == record.isDeleted
                && Objects.equals(id, record.id)
                && Objects.equals(entryDate, record.entryDate)
                && Objects.equals(itemCode, record.itemCode)
                && Objects.equals(itemName, record.itemName)
                && status == record.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entryDate, itemCode, itemName, itemQuantity, status, isDeleted);
    }
}
