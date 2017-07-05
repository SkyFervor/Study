package core;

import java.io.Closeable;

import entity.Sheet;

public interface OutputResolver<T> extends Closeable {

	public boolean write(Sheet sheet);

}
