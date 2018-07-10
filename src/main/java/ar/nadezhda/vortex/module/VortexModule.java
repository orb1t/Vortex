
	package ar.nadezhda.vortex.module;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.config.Configurator;
	import ar.nadezhda.vortex.core.CUDACluster;
	import ar.nadezhda.vortex.core.ThreadCluster;
	import ar.nadezhda.vortex.interfaces.Cluster;
	import ar.nadezhda.vortex.interfaces.Mode;
	import ar.nadezhda.vortex.mode.None;
	import ar.nadezhda.vortex.mode.Simulation;
	import ar.nadezhda.vortex.qualifier.CLI;
	import ar.nadezhda.vortex.support.ClassBuilder;
	import ar.nadezhda.vortex.support.Message;
	import dagger.Module;
	import dagger.Provides;
	import java.lang.reflect.InvocationTargetException;
	import java.util.NoSuchElementException;
	import javax.inject.Singleton;
	import org.apache.commons.math3.random.MersenneTwister;
	import org.apache.commons.math3.random.RandomGenerator;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	@Module
	public class VortexModule {

		public static final String CONFIGURATION_FILENAME = "vortex.json";

		protected static final Logger logger
			= LoggerFactory.getLogger(VortexModule.class);

		@Provides @Singleton
		public Cluster provideCluster(final Configuration config) {
			if (config.useCuda()) {
				return new CUDACluster();
			}
			else if (0 < config.getWorkers()) {
				return new ThreadCluster(config.getWorkers());
			}
			else return new ThreadCluster();
		}

		@Provides
		public Configuration provideConfiguration(
				final Configurator configurator) {
			return configurator.getConfig();
		}

		@Provides @Singleton
		public Configurator provideConfigurator() {
			return new Configurator(CONFIGURATION_FILENAME);
		}

		@Provides @Singleton
		public RandomGenerator provide(final Configuration config) {
			return new MersenneTwister(config.getSeed());
		}

		@Provides
		public Mode provideMode(
				@CLI final String [] arguments, final Configuration config,
				final Simulation simulation) {
			if (0 < arguments.length) {
				final String mode = ClassBuilder
						.getFullyQualifiedClassName(
							Simulation.class.getPackageName(), arguments[0]);
				if (mode.equals(Simulation.class.getCanonicalName())) {
					logger.info(Message.CONFIGURATION, config.toString());
					return simulation;
				}
				else try {
					final Mode instance = (Mode) ClassBuilder
						.getConstructor(mode, Configuration.class)
						.orElseThrow()
						.newInstance(config);
					logger.info(Message.CONFIGURATION, config.toString());
					return instance;
				}
				catch (final InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchElementException exception) {
					logger.error(Message.UNKNOWN_MODE, arguments[0]);
				}
			}
			else logger.error(Message.UNSPECIFIED_MODE);
			return new None();
		}

		@Provides
		public Simulation provideSimulation(
				final Configuration config, final Cluster cluster) {
			return new Simulation(config, cluster);
		}
	}
