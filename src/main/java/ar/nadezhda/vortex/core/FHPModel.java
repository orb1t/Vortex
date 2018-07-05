
	package ar.nadezhda.vortex.core;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.interfaces.CFPModel;
	import javax.inject.Inject;

	public class FHPModel implements CFPModel {

		protected final Configuration config;

		@Inject
		public FHPModel(final Configuration config) {
			this.config = config;
		}

		@Override
		public CFPModel run() {
			// Completar...
			return this;
		}
	}
