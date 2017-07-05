package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuhaoz
 * 2017/07/04 18:05
 */
public class LambdaTest1 {
	public static void main(String[] args) {
		List<Integer[]> list = new ArrayList<>();
		list.add(new Integer[]{0});
		System.out.println(Arrays.toString(list.get(0)));
	}
}
