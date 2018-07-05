
	package ar.nadezhda.vortex.mode;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.interfaces.Mode;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public class Animation implements Mode {

		protected static final Logger logger
			= LoggerFactory.getLogger(Animation.class);

		protected final Configuration config;

		public Animation(final Configuration config) {
			this.config = config;
		}

		@Override
		public Mode run() {
			logger.info("Animation...");
			return this;
		}
	}
