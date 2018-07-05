
	package ar.nadezhda.vortex.component;

	import ar.nadezhda.vortex.interfaces.CFPModel;
	import ar.nadezhda.vortex.module.VortexModule;
	import ar.nadezhda.vortex.qualifier.FHP;
	import dagger.Component;

	@Component(modules = VortexModule.class)
	public interface VortexComponent {

		@FHP
		public CFPModel getCFPModel();
	}
