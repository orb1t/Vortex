
	package ar.nadezhda.vortex.core;

	import ar.nadezhda.vortex.interfaces.Cluster;
	import ar.nadezhda.vortex.interfaces.Transform;

	public class CUDACluster implements Cluster {

		@Override
		public short [][] spread(final short [][] lattice, final Transform transform) {
			return lattice;
		}

		@Override
		public void release() {
			// Completar...
		}
	}
