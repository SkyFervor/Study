package core;

import java.io.Closeable;
import java.util.List;

import entity.Sheet;

public interface InputResolver<T> extends Closeable {

	public List<Sheet> read();

	public Sheet read(int sheetNum);

	public Sheet read(int sheetNum, List<Integer> columns);

	public Sheet read(int sheetNum, int rowStart, List<Integer> columns);

	public Sheet read(int sheetNum, int rowStart, int rowEnd);

	public Sheet read(int sheetNum, int rowStart, int rowEnd, List<Integer> columns);

}
