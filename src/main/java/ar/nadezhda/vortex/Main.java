
	package ar.nadezhda.vortex;

	import ar.nadezhda.vortex.component.DaggerVortexComponent;
	import ar.nadezhda.vortex.support.Message;

	public final class Main {

		public static void main(final String [] arguments) {
			System.out.println(Message.BRAND);
			DaggerVortexComponent.builder()
				.build()
				.getCFPModel()
				.run();
		}
	}
