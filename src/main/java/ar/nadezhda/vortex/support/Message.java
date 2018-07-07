
	package ar.nadezhda.vortex.support;

	public class Message {

		public static final String BRAND
			= "(2018) Vortex v1.0";

		public static final String CONFIG_FILE_NOT_FOUND
			= "Configuration file not found ('{}').";
		public static final String CONFIG_INVALID_FORMAT
			= "The configuration file is not a valid JSON (see line {}, column {}).";
		public static final String CONFIG_UNRECOGNIZED_PROPERTY
			= "The configuration has an unknown property ('{}'), at line {}, column {}.";
		public static final String CONFIG_UNKNOWN_ERROR
			= "Unknown error while reading the configuration.";
		public static final String USING_DEFAULT_CONFIG
			= "Using default configuration.";

		public static final String UNKNOWN_MODE
			= "Unknown mode ('{}'). See usage.";
		public static final String UNSPECIFIED_MODE
			= "The mode wasn't specified.";

		public static final String CONFIGURATION
			= "Configuration:\n{}";
	}
