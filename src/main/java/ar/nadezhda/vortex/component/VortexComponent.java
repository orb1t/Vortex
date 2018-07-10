
	package ar.nadezhda.vortex.component;

	import ar.nadezhda.vortex.interfaces.Mode;
	import ar.nadezhda.vortex.module.VortexModule;
	import ar.nadezhda.vortex.qualifier.CLI;
	import dagger.BindsInstance;
	import dagger.Component;
	import javax.inject.Singleton;

	@Singleton
	@Component(modules = VortexModule.class)
	public interface VortexComponent {

		public Mode getMode();

		@Component.Builder
		interface Builder {

			@BindsInstance
			public Builder arguments(@CLI final String [] arguments);

			public VortexComponent build();
		}
	}
