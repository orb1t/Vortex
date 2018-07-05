
	package ar.nadezhda.vortex.config;

	import ar.nadezhda.vortex.support.Message;
	import com.fasterxml.jackson.core.JsonLocation;
	import com.fasterxml.jackson.core.JsonParseException;
	import com.fasterxml.jackson.databind.JsonMappingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	public class Configurator {

		protected static final Logger logger
			= LoggerFactory.getLogger(Configurator.class);
		protected static final ObjectMapper mapper
			= new ObjectMapper();

		protected final Configuration config;
		protected final String source;

		public Configurator(final String filename) {
			this.config = load(filename);
			this.source = filename;
		}

		public Configuration getConfig() {
			return config;
		}

		public String getSource() {
			return source;
		}

		public static Configuration getDefault() {
			return Configuration.DEFAULT;
		}

		public static Configuration tryToLoad(final String filename)
				throws JsonParseException, JsonMappingException,
					IOException {
			final File file = new File(filename);
			return mapper.readValue(file, Configuration.class);
		}

		public static Configuration load(final String filename) {
			try {
				return Configurator.tryToLoad(filename);
			}
			catch (final FileNotFoundException exception) {
				logger.error(Message.CONFIG_FILE_NOT_FOUND, filename);
			}
			catch (final JsonParseException exception) {
				final JsonLocation location = exception.getLocation();
				logger.error(
						Message.CONFIG_INVALID_FORMAT,
						location.getLineNr(), location.getColumnNr());
				logger.error(exception.getOriginalMessage());
			}
			catch (final UnrecognizedPropertyException exception) {
				final JsonLocation location = exception.getLocation();
				logger.error(
						Message.CONFIG_UNRECOGNIZED_PROPERTY,
						exception.getPropertyName(),
						location.getLineNr(), location.getColumnNr());
			}
			catch (final IOException exception) {
				logger.error(Message.CONFIG_UNKNOWN_ERROR);
				logger.error(exception.getMessage());
			}
			logger.warn(Message.USING_DEFAULT_CONFIG);
			return Configurator.getDefault();
		}
	}
