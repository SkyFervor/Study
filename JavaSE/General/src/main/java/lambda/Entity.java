package lambda;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Entity {

	private int key;
	private Integer value;
	private int name;
	private List<ChildEntity> childEntities;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
class ChildEntity {
	private int key;
	private int name;
}