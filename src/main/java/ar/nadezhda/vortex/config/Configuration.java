
	package ar.nadezhda.vortex.config;

	import com.fasterxml.jackson.annotation.JsonProperty;

	public class Configuration {

		public static final Configuration DEFAULT
			= new Configuration();

		protected String shape = "";
		protected String output = "";

		protected int [] lattice = {10, 10};
		protected double [] dimension = {1.0, 1.0};
		protected int steps = 0;
		protected int window = 1;
		protected int average = 1;

		protected String contour = "non-periodic";
		protected String momentum = "left-to-right";
		protected double ratio = 0.1;

		protected long seed = System.nanoTime();
		@JsonProperty("cuda")
		protected boolean cuda = true;
		@JsonProperty("saveAutomaton")
		protected boolean saveAutomaton = false;

		public String getShape() {
			return shape;
		}

		public String getOutput() {
			return output;
		}

		public int [] getLattice() {
			return lattice;
		}

		public double [] getDimension() {
			return dimension;
		}

		public int getSteps() {
			return steps;
		}

		public int getWindow() {
			return window;
		}

		public int getAverage() {
			return average;
		}

		public String getContour() {
			return contour;
		}

		public String getMomentum() {
			return momentum;
		}

		public double getRatio() {
			return ratio;
		}

		public long getSeed() {
			return seed;
		}

		public boolean useCuda() {
			return cuda;
		}

		public boolean saveAutomaton() {
			return saveAutomaton;
		}

		@Override
		public String toString() {
			return new StringBuilder(1024)
					.append("\tshape           : '").append(shape)
					.append("'\n\toutput          : '").append(output)
					.append("'\n\tlattice         : ").append(lattice[0]).append("x").append(lattice[1])
					.append(" nodes\n\tdimension       : (").append(dimension[0]).append(", ").append(dimension[1])
					.append(")\n\tsteps           : ").append(steps)
					.append("\n\twindow          : ").append(window)
					.append(" steps\n\taverage         : ").append(average)
					.append(" nodes\n\tcontour         : ").append(contour)
					.append("\n\tmomentum        : ").append(momentum)
					.append("\n\tratio           : ").append(100.0 * ratio)
					.append(" %\n\tseed            : ").append(seed)
					.append("\n\tUse CUDA        : ").append(cuda)
					.append("\n\tSave automaton? : ").append(saveAutomaton)
					.append("\n")
					.toString();
		}
	}
