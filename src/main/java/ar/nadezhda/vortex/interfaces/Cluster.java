
	package ar.nadezhda.vortex.interfaces;

	public interface Cluster {

		public short [][] spread(final short [][] lattice, final Transform transform);
		public void release();
	}
