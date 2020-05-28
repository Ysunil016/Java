package JInterface;

public class B implements _8_InterfaceA, _8_InterfaceB {

	@Override
	public void interface_abstract_method() {
		// TODO Auto-generated method stub

	}

	// Defining which Method to Call from Both the Defined Interfaces

	@Override
	public void show() {
		// TODO Auto-generated method stub
		_8_InterfaceB.super.show();
	}

	@Override
	public void interface_default_method() {
		// TODO Auto-generated method stub
		_8_InterfaceA.super.interface_default_method();
	}

}
