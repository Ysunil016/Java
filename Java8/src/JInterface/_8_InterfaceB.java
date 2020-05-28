package JInterface;

public interface _8_InterfaceB {

	void interface_abstract_method();

	// Default function declaration and definition inside interface
	default void interface_default_method() {
		System.out.println("Interface B Default Method");
	}

	default void show() {
		System.out.println("Inside Interface B Show");
	}

	// Does Not Require Any Object of Interface to be Created
	static void interface_static_method() {
		System.out.println("Interface B Static Method");
	}

}
