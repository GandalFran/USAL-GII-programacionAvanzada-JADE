package controllers.IO;

import java.util.Collection;
import java.util.List;

public interface FileDAO <T>{
	bool importMultipleObject( String path, List<T> toFill );
	bool exportMultipleObject( String path, List<T> toExport );
}
