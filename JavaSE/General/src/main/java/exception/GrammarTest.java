package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by shuhaoz
 * 2017/07/05 12:04
 */
public class GrammarTest implements GrammarInterface {
	/*
	// Correct
	@Override
	public void test() throws IOException {
		throw new IOException();
	}
	*/

	/*
	// Correct
	@Override
	public void test() {
		System.out.println(1);
	}
	*/

	@Override
	public void test() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

	/*
	// Error
	@Override
	public void test() throws Exception {
		throw new Exception();
	}
	*/

	public static void main(String[] args) {
		try {
			GrammarTest test = new GrammarTest();
			test.test();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}

interface GrammarInterface {
	void test() throws IOException;
}