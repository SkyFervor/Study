package lambda;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entity {

	private int key;
	private int value;
	private int name;
}
