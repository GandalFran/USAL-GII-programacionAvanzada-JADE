package controller.IOServices;

import java.util.Collection;
import java.util.List;

public interface FileDAO <T>{
	boolean importMultipleObject( String path, List<T> toFill );
	boolean exportMultipleObject( String path, List<T> toExport );
}
