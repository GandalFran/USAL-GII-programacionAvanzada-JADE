package IO;

import java.util.Collection;
import java.util.List;

public interface FileDAO <T>{
	Boolean importData( String path, Collection<T> toFill );
	Boolean exportData( String path, Collection<T> toExport );
}
