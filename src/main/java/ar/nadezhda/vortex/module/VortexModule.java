
	package ar.nadezhda.vortex.module;

	import ar.nadezhda.vortex.config.Configuration;
	import ar.nadezhda.vortex.config.Configurator;
	import ar.nadezhda.vortex.core.FHPModel;
	import ar.nadezhda.vortex.interfaces.CFPModel;
	import ar.nadezhda.vortex.qualifier.FHP;
	import ar.nadezhda.vortex.support.Message;
	import com.fasterxml.jackson.core.JsonParseException;
	import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
	import dagger.Module;
	import dagger.Provides;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	@Module
	public class VortexModule {

		public static final String CONFIGURATION_FILENAME = "vortex.json";

		@Provides @FHP
		public CFPModel provideCFPModel(final FHPModel model) {
			return model;
		}

		@Provides
		public Configuration provideConfiguration() {
			try {
				return Configurator.load(CONFIGURATION_FILENAME);
			}
			catch (final FileNotFoundException exception) {
				System.err.println(Message.CONFIG_FILE_NOT_FOUND);
			}
			catch (final JsonParseException exception) {
				System.err.println(Message.CONFIG_INVALID_FORMAT);
			}
			catch (final UnrecognizedPropertyException exception) {
				System.err.println(Message.CONFIG_UNRECOGNIZED_PROPERTY);
			}
			catch (final IOException exception) {
				System.err.println(Message.CONFIG_UNKNOWN_ERROR);
			}
			System.err.println(Message.USING_DEFAULT_CONFIG);
			return Configurator.getDefault();
		}
	}
