package JInterface;

public interface _8_InterfaceA {

	void interface_abstract_method();

	// Default function declaration and definition inside interface
	default void interface_default_method() {
		System.out.println("Interface A Default Method");
	}

	default void show() {
		System.out.println("Inside Interface A Show");
	}

	// Does Not Require Any Object of Interface to be Created
	static void interface_static_method() {
		System.out.println("Interface A Static Method");
	}

}
