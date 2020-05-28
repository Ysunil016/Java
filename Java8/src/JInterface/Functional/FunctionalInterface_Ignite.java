package JInterface.Functional;

public class FunctionalInterface_Ignite {

	public static void main(String[] args) {

		// This is Given Interface With Anonymous Definition of Function
//		SoloInterface sI = new SoloInterface() {
//
//			@Override
//			public void calculateValue(int v) {
//				// TODO Auto-generated method stub
//			}
//		};

		// We can Use Functional As Well
		SoloInterface fI = (i) -> System.out.println("This is Lamda Definition " + i);

		fI.calculateValue(10);
	}

}
