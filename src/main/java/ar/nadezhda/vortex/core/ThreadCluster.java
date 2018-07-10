
	package ar.nadezhda.vortex.core;

	import ar.nadezhda.vortex.interfaces.Cluster;
	import ar.nadezhda.vortex.interfaces.Transform;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.Semaphore;

	public class ThreadCluster implements Cluster {

		protected final int workers;
		protected final ExecutorService pool;
		protected final Semaphore lock;

		public ThreadCluster() {
			this(Runtime.getRuntime().availableProcessors());
		}

		public ThreadCluster(final int workers) {
			this.workers = workers;
			this.pool = Executors.newFixedThreadPool(workers);
			this.lock = new Semaphore(workers);
		}

		@Override
		public short [][] spread(final short [][] lattice, final Transform transform) {
			final int width = lattice[0].length;
			final int fragmentSize = lattice.length / workers;
			final short [][] result = new short [lattice.length][width];
			for (int k = 0; k < workers; ++k) {
				final int lower = k * fragmentSize;
				final int upper = k == workers - 1?
						lattice.length :
						lower + fragmentSize;
				try {
					lock.acquire();
					pool.execute(() -> {
						for (int i = lower; i < upper; ++i)
							for (int j = 0; j < width; ++j)
								result[i][j] = transform.apply(lattice, i, j);
						lock.release();
					});
				}
				catch (final InterruptedException exception) {
					exception.printStackTrace();
					lock.release();
				}
			}
			try {
				lock.acquire(workers);
			}
			catch (final InterruptedException exception) {
				exception.printStackTrace();
			}
			finally {
				lock.release(workers);
			}
			return lattice;
		}

		@Override
		public void release() {
			pool.shutdownNow();
		}
	}
