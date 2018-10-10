package controllers.IO.DAOImpl;

import java.util.Map;

public interface MapFileDAO<T,E> {
	boolean importMultipleObject( String path, Map<T,E> toFill );
	boolean exportMultipleObject( String path, Map<T,E> toExport );

}
