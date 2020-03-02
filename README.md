[![Solid Security](https://www.solidsecurity.co/wp-content/uploads/2020/03/logo-18-7.png "Solid Security")](https://solidsecurity.co "Solid Security")
# Solid Spintax Spinner
![](https://img.shields.io/github/tag/SolidSecurity/Solid-Spintax-Spinner.svg) ![](https://img.shields.io/github/release/SolidSecurity/Solid-Spintax-Spinner.svg) ![](https://img.shields.io/github/issues/SolidSecurity/Solid-Spintax-Spinner.svg)

The Solid Spintax Spintaxer is a command-line utility to generate uniquely identifiable documents using a provided spintax. Spintaxes are built according to the [Solid Spintax standard](https://github.com/SolidSecurity/Solid-Spintax-Specification), which is backwards-compatible with standard spintax.

Unlike traditional pseudorandom implementations, this spintaxer is completely deterministic &mdash; every possible permutation of a document is given a unique identifier, which can later be recovered using the [Solid Spintax Investigator](https://github.com/SolidSecurity/Solid-Spintax-Investigator).

## Installation
### Bash Script
If you are just looking to get up and running with the spintaxer as quickly as possible, you can run these two commands to download the latest Solid Spintaxer and create an alias for you automatically:

```
git clone https://github.com/SolidSecurity/Solid-Spintax-Spinner.git
echo "alias spinner='java -jar $PWD/Solid-Spintax-Spinner/dist/Solid-Spintax-Spinner.jar'" >> ~/.bashrc
```

### Download
#### (Recommended) Download Release
Download the latest release as a .zip containing required dependencies along with an executable .jar file from our [release page](https://github.com/SolidSecurity/Solid-Spintax-Specification/releases).

#### (Alternative) Build from Source
The repository also contains NetBeans project files for those who wish to make modifications and then build the repository themselves.

### Running
#### Command Line
You can run dist/SolidSpintaxSpinner.jar directly from the command line with the following comand (after cloning the repository into the current directory):

`java -jar Solid-Spintax-Spinner/dist/Solid-Spintax-Spinner.jar <input.sstx> [-arguments]`

#### (Optional) Create Alias
Optionally, create an alias for the installed command like so:

`echo "alias spinner='java -jar $PWD/Solid-Spintax-Spinner/dist/Solid-Spintax-Spinner.jar'" >> ~/.bashrc`

The spinner can then be run directly using:

`spinner <input.sstx> [-arguments]`

## Help
Use the `-h` or `--help` to get the same help information on the command line that is included below:

### Usage
The spinner accepts an input file and a set of arguments:

`spinner [-r] [-s] [-a] [-u] [-p <#>] [-t <TAG>] [-n <#>] [-y] [-o <FILE>] [-l <FILE>] [-i] [-v] [-h] [<FILE>]`

### Options
#### Modes
 Specify how the spinner should choose which permutations to generate:

`-r, --random`: generate random permutations of the provided spintax

`-s, --sequential`: generates sequential permutations of the provided spintax, starting at  the provided  tag or permutation number, or 0 if neither is provided

`-a, --all`: generate all  possible  permutations  of  the  provided spintax

#### Restrictions
Add restrictions that the spinner must follow

`-u, --unique`: require all output documents to be unique

#### Identifiers
Identifies a particular permutation to be generated

`-p <#>, --permutation <#>`: generate  the  output   document   corresponding  to  a specific permutation number

`-t <TAG>, --tag <TAG>`:  generate  the  output   document   corresponding  to  a specific tag

#### Output
Specify where output files should be stored

`-n <#>, --count <#>` : specifies the number of files to be generated

`-y, --yes`: automatically acknowledge  generating  large  number of output files

`-o <FILE>, --out <FILE>`: specifies  the  suffix  to  be  appended  to  generated output files

`-l <FILE>, --log <FILE>`: creates a  separate  file  with  tags  corresponding to  generated documents

#### Information
Request information about this program or provided spintax

`-i, --info`: print information about the provided spintax

`-v, --version`: prints the current spintax and spinner version

`-h, --help`: shows this help message