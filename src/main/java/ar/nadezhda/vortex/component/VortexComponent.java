
	package ar.nadezhda.vortex.component;

	import ar.nadezhda.vortex.interfaces.Mode;
	import ar.nadezhda.vortex.module.VortexModule;
	import ar.nadezhda.vortex.qualifier.CLI;
	import ar.nadezhda.vortex.qualifier.FHP;
	import dagger.BindsInstance;
	import dagger.Component;
	import javax.inject.Singleton;

	@Singleton
	@Component(modules = VortexModule.class)
	public interface VortexComponent {

		@FHP
		public Mode getMode();

		@Component.Builder
		interface Builder {

			@BindsInstance
			public Builder arguments(@CLI final String [] arguments);

			public VortexComponent build();
		}
	}
