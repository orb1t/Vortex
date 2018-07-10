
	package ar.nadezhda.vortex.core;

	import ar.nadezhda.vortex.interfaces.Cluster;
	import java.util.function.Consumer;

	public class Automaton {

		protected final int width;
		protected final int height;
		protected final long seed;
		protected final String contour;
		protected final Cluster cluster;
		protected short [][] lattice;

		protected Automaton(final Builder builder) {
			this.width = builder.width;
			this.height = builder.height;
			this.seed = builder.seed;
			this.contour = builder.contour;
			this.cluster = builder.cluster;
			this.lattice = new short [width][height];
		}

		public Automaton propagate() {
			lattice = cluster.spread(lattice, (l, i, j) -> {
				return l[i][j];
			});
			return this;
		}

		public Automaton collide() {
			lattice = cluster.spread(lattice, (l, i, j) -> {
				return l[i][j];
			});
			return this;
		}

		public Object see(final Consumer<short [][]> consumer) {
			consumer.accept(lattice);
			return this;
		}

		public static class Builder {

			protected int width;
			protected int height;
			protected long seed;
			protected String contour;
			protected Cluster cluster;

			public Builder width(final int width) {
				this.width = width;
				return this;
			}

			public Builder height(final int height) {
				this.height = height;
				return this;
			}

			public Builder seed(final long seed) {
				this.seed = seed;
				return this;
			}

			public Builder contour(final String contour) {
				this.contour = contour;
				return this;
			}

			public Builder cluster(final Cluster cluster) {
				this.cluster = cluster;
				return this;
			}

			public Automaton build() {
				return new Automaton(this);
			}
		}
	}
