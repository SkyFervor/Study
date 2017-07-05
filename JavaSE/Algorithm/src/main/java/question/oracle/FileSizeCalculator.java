package question.oracle;

import java.util.List;

public class FileSizeCalculator {
	public FileSizeCalculator() {
	}

	public long sumSizeOf(VirtualFile file) {
		if (!file.isDir())
			return file.size();

		long size = 0;
		List<VirtualFile> children = file.children();
		for (VirtualFile child : children) {
			size += sumSizeOf(child);
		}

		return size;
	}
}

/**
 * 虚拟文件系统的文件/目录。
 */
interface VirtualFile {
	/**
	 * @return 该文件是否是目录。
	 */
	boolean isDir();

	/**
	 * @return 文件的尺寸。但如果当前文件是目录，返回0。
	 */
	long size();

	/**
	 * @return 文件的名称
	 */
	String name();

	/**
	 * @return 目录下的所有文件/子目录。如果当前文件不是目录，返回空的List。
	 */
	List<VirtualFile> children();
}