
	package ar.nadezhda.vortex;

	import ar.nadezhda.vortex.component.DaggerVortexComponent;
	import ar.nadezhda.vortex.support.Message;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public final class Main {

		protected static final Logger logger
			= LoggerFactory.getLogger(Main.class);

		public static void main(final String [] arguments) {
			logger.info(Message.BRAND);
			DaggerVortexComponent.builder()
				.arguments(arguments)
				.build()
				.getMode()
				.run();
		}
	}
