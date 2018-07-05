
	package ar.nadezhda.vortex.config;

	public class Configuration {

		public static final Configuration DEFAULT
			= new Configuration();

		protected String output = "";
		protected String shape = "";

		public String getOutput() {
			return output;
		}

		public String getShape() {
			return shape;
		}
	}
