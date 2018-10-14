package controller.IOServices;

import java.util.List;

public interface ListFileDAO<T> {
	boolean importMultipleObject( String path, List<T> toFill );
	boolean exportMultipleObject( String path, List<T> toExport );
}
