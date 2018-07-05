
	package ar.nadezhda.vortex.qualifier;

	import static java.lang.annotation.RetentionPolicy.RUNTIME;
	import java.lang.annotation.Documented;
	import java.lang.annotation.Retention;
	import javax.inject.Named;

	@Named("CLI")
	@Documented
	@Retention(RUNTIME)
	public @interface CLI {}
