
	package ar.nadezhda.vortex.module;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.config.Configurator;
	import ar.nadezhda.vortex.core.FHPModel;
	import ar.nadezhda.vortex.interfaces.CFPModel;
	import ar.nadezhda.vortex.interfaces.Mode;
	import ar.nadezhda.vortex.mode.None;
	import ar.nadezhda.vortex.mode.Simulation;
	import ar.nadezhda.vortex.qualifier.CLI;
	import ar.nadezhda.vortex.qualifier.FHP;
	import ar.nadezhda.vortex.support.ClassBuilder;
	import ar.nadezhda.vortex.support.Message;
	import dagger.Module;
	import dagger.Provides;
	import java.lang.reflect.InvocationTargetException;
	import java.util.NoSuchElementException;
	import javax.inject.Singleton;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	@Module
	public class VortexModule {

		public static final String CONFIGURATION_FILENAME = "vortex.json";

		protected static final Logger logger
			= LoggerFactory.getLogger(VortexModule.class);

		@Provides @FHP
		public CFPModel provideCFPModel(final FHPModel model) {
			return model;
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

		@Provides
		public Mode provideMode(
				@CLI final String [] arguments, final Configuration config,
				@FHP final Simulation simulation) {
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

		@Provides @FHP
		public Simulation provideSimulation(
				final Configuration config, final FHPModel model) {
			return new Simulation(config, model);
		}
	}
