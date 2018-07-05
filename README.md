[![...](res/image/readme-header.png)](https://github.com/agustin-golmar/Vortex/blob/master/doc/(2018)%20Computational%20Fluid%20Dynamics.docx)
[![...](https://img.shields.io/badge/license-WTFPL%20v2.0-red.svg)](https://github.com/agustin-golmar/Vortex/blob/master/LICENSE.md)
[![...](https://img.shields.io/badge/release-v1.0-blue.svg)](https://github.com/agustin-golmar/Vortex/releases)
[![...](https://www.travis-ci.com/agustin-golmar/Vortex.svg?branch=master)](https://www.travis-ci.com/agustin-golmar/Vortex)

# Vortex

An implementation of the FHP model (with 6 velocity degrees of freedom), based
on cellular automatons, for the simulation of a 2D fluid. This model can solve
the Navier-Stokes equation for an incompressible flow.

## Build

To build the project, it is necessary to have _Maven +3.5.0_, and
_Java SE 10 Release_ installed. Then, run:

```
$ mvn clean package
```

This will generate a _\*.jar_ in the root folder. If you find any issues with
the building, remove the _\*.jar_ files from the _Maven_ local repository
with:

```
$ rm -fr ~/.m2/repository/ar/nadezhda/*
```

Or do it manually, if you prefer.

> __NOTE:__ If you wish to import this project in _Eclipse IDE_, you should
> install the [m2e-apt](https://marketplace.eclipse.org/content/m2e-apt)
> plugin. This way, _Dagger_ will compile the modules and components
> automatically.

## Execution

In the root folder, type:

```
$ java -jar vortex.jar <mode>
```

Where _\<mode\>_ can be:

* `simulation`: Runs a complete simulation of the specified system in
configuration.

## Configuration

The configuration must be in a file named `vortex.json`, located in the root
folder. It must contain the follow properties:

```
{
}
```

## Libraries

This application uses these _Java_ libraries to complete its task:

* __[Dagger v2.16](https://google.github.io/dagger/)__: As the fully static DI
framework.
* __[Jackson v2.9.6]((https://github.com/FasterXML/jackson)__: For reading the
JSON configuration.

## Designer

This project has been built, designed and maintained by:

* [Agustín Golmar](https://github.com/agustin-golmar)

## Bibliography

__"Title"__. Authors. _ISBN. Date_.
