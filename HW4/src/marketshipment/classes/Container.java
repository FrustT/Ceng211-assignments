package marketshipment.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Container<T extends Collection<?>> extends Box<T> {
	private List<T> contents;
	
	public Container() {
		this.contents = new ArrayList<>();
	}

	public List<T> getContents() {
		return contents;
	}
}
