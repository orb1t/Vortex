[![...](res/image/readme-header.png)]()
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

## Execution

In the root folder, type:

```
$ java -jar vortex.jar <arguments>
```

Where the arguments can be:

* `-option`: Description.

## Libraries

This application uses these _Java_ libraries to complete its task:

* __[Library v3.7](...)__: Description.

## Designer

This project has been built, designed and maintained by:

* [Agustín Golmar](https://github.com/agustin-golmar)

## Bibliography

__"Title"__. Authors. _ISBN. Date_.
