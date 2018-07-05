
	package ar.nadezhda.vortex.mode;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.interfaces.CFPModel;
	import ar.nadezhda.vortex.interfaces.Mode;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public class Simulation implements Mode {

		protected static final Logger logger
			= LoggerFactory.getLogger(Simulation.class);

		protected Configuration config;
		protected CFPModel model;

		public Simulation(final Configuration config, final CFPModel model) {
			this.config = config;
			this.model = model;
		}

		@Override
		public Mode run() {
			logger.info("Simulation...");
			return this;
		}
	}
