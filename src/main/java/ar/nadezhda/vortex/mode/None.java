
	package ar.nadezhda.vortex.mode;

	import ar.nadezhda.vortex.interfaces.Mode;

	public class None implements Mode {

		@Override
		public Mode run() {
			return this;
		}
	}
