
	package ar.nadezhda.vortex.mode;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.core.Automaton;
	import ar.nadezhda.vortex.interfaces.Cluster;
	import ar.nadezhda.vortex.interfaces.Mode;
	import ar.nadezhda.vortex.support.Message;
	import ar.nadezhda.vortex.support.Timer;
	import java.util.stream.IntStream;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public class Simulation implements Mode {

		protected static final Logger logger
			= LoggerFactory.getLogger(Simulation.class);

		protected final Configuration config;
		protected final Cluster cluster;

		public Simulation(final Configuration config, final Cluster cluster) {
			this.config = config;
			this.cluster = cluster;
		}

		@Override
		public Mode run() {
			logger.info(Message.SIMULATION);
			final Automaton automaton = new Automaton.Builder()
					.width(config.getLattice()[0])
					.height(config.getLattice()[1])
					.seed(config.getSeed())
					.contour(config.getContour())
					.cluster(cluster)
					.build();
			final Timer timer = new Timer();
			IntStream.range(0, config.getSteps())
				.forEachOrdered(k -> automaton
						.propagate()
						.collide()
						.see(l -> {
							// Almacenar...
						}));
			cluster.release();
			logger.info(Message.FINISH_TIME, timer.getTimeInSeconds());
			return this;
		}
	}
