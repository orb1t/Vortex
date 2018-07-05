
	package ar.nadezhda.vortex.support;

	import java.lang.reflect.Constructor;
	import java.util.Optional;

	public class ClassBuilder {

		public static Optional<Constructor<?>> getConstructor(
				final String name, final Class<?> ... classes) {
			try {
				return Optional.of(Class.forName(name)
						.getDeclaredConstructor(classes));
			}
			catch (final IllegalArgumentException | NoSuchMethodException
					| SecurityException | ClassNotFoundException
					| NoClassDefFoundError exception) {
				return Optional.empty();
			}
		}

		public static String getFullyQualifiedClassName(
				final String packageName, final String className) {
			return packageName + "." + className.substring(0, 1).toUpperCase()
					+ className.substring(1);
		}
	}
