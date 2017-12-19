package lambda;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Entity {

	private int key;
	private int value;
	private int name;
}
