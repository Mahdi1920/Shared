package tn.starter.shared.entities;

import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MongoBaseEntity implements Serializable {
	@Id
	@Setter(AccessLevel.NONE)
	String id;

	@CreatedDate
	Instant createdAt;

	@LastModifiedDate
	Instant updatedAt;
}
