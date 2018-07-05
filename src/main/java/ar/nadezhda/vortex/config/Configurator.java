
	package ar.nadezhda.vortex.config;

	import com.fasterxml.jackson.core.JsonParseException;
	import com.fasterxml.jackson.databind.JsonMappingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import java.io.File;
	import java.io.IOException;
	import javax.inject.Singleton;

	@Singleton
	public class Configurator {

		protected static final ObjectMapper mapper = new ObjectMapper();

		public static Configuration getDefault() {
			return Configuration.DEFAULT;
		}

		public static Configuration load(final String filename)
				throws JsonParseException, JsonMappingException,
					IOException {
			final File file = new File(filename);
			return mapper.readValue(file, Configuration.class);
		}
	}
