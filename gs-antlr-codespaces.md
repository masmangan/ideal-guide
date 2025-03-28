# Getting Started with ANTLR v4 using GitHub CodeSpaces and Java

If you are using Java as your programming language of choice to develop lexers and parsers, this guide is for you.

Cloud based computing is a platform that lets you setup and configure a virtual computer in the cloud.
In this guide, we will use GitHub Codespaces.
You will need a GitHub account ito proceed (link here). Also, check if you are eligible for GitHub for Education (link here).

ANTLR and GitHub CodeSpaces support some programming languages out of the box, including C, C++, Python, and Java.
In this guide, we have chosen Java, primarily because many students are familiar with it. 

## Getting started with a GitHub CodeSpace

We will start creating a new GitHub repository. When doing so, make sure to include a README.md file and .gitignore file configured to Java.

(Image here)

Next, we will create a CodeSpace- a cloud-based development environment that runs on Linux machine with java, javac, and Maven pre-installed.

(Image here)

This Codespace is setup once and remains available as long as you don't delete it.

This setup is especially useful if you do not have administrator privileges on your machine, or if you switch between multiple computers along the week (e.g. at home, at school, at work, or in computer labs). You can simply use a web browser to access your Codespace from any device.

Note: the maind drawback of cloud-computing is that you need a reliable Internet connection.

## ANTLR Installation

ANTLR consists of two main components:
1. The ANTLR Tool: written in Java, that translates your grammar files into lexer and parser code (written in Java or another target language).
2. The ANTLR Runtime Library: Required to run the generated parsers and lexers code.

Note: Even if you are using the VS Code extension, your generated code will still need the runtime library. 

### Install ANTLR VSCode extension

Start by installing the ANTLR VS Code extension. It provides a grammar-aware text editor with syntax highlighting and diagram previews, making it easier to write and understand your grammar.

Even if you only use the extension for editing, it’s a valuable tool for visualizing and validating your grammar files.


(Image here)

### Download ANTLR

Check the current ANTLR version.
At this moment, it is 4.13.2.

Download ANTLR with the commands bellow on your terminal:

```
$ cd /usr/local/lib
$ curl -O https://www.antlr.org/download/antlr-4.13.2-complete.jar
```
and put it somewhere rational like `/usr/local/lib` with the command bellow.

```
$ sudo mv antlr-4.13.2-complete.jar /usr/local/lib
```

### Configure CLASSPATH and create aliases for the ANTLR Tool, and `TestRig`.

Add the lines bellow to your `~/.bashrc`, using you favorite text editor:
```
export CLASSPATH=".:/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH"
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'
```

Just this time, refresh your bash configuration. 

```
source ~/.bashrc
```

### Testing the installation

Check if the aliases for antlr4 and grun are working:

```
$ antlr4
```

and

```
$ grun
```

You should see some messages explainning the tools usage. Confirm if the ANTLR version is the same as the downloaded file.

## A First Example

Remark: You can use the VS Code to handle folders and edit files.

Go back to your terminal and type:

```
mkdir hello
cd hello
```

In the `example` folder, put the following grammar inside file `Hello.g4`:

``` Hello.g4
// Define a grammar called Hello
grammar Hello;
r  : 'hello' ID ;         // match keyword hello followed by an identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
```

Remember: grammar and file names must be the same, including upper and lower case usage.

Then run ANTLR the tool on it:

```
$ antlr4 Hello.g4
```
You will have some files generated, including some .java files.

Next, compile all the .java files:
```
$ javac Hello*.java
```

Now test it:

```
$ grun Hello r -tree
```

Now enter something like the string below:

`hello parrt`

To end the input, press CTRL +D.

The -tree option prints the parse tree in LISP notation.
You will get some output as:

`(r hello parrt)`

It's nicer to look at parse trees visually.
We are running on the cloud, in a terminal. 

If you wnat to see a image, you could configure a X11 server.
See next guide for X11 support and PostScript support on GitHub CodeSpaces.

(Link here)

## Book source code

The book has lots and lots of examples that should be useful too. You can download them here for free:

[ANTLR reference book examples in Java](https://media.pragprog.com/titles/tpantlr2/code/tpantlr2-code.zip)<br>
[ANTLR reference book examples in C#](https://github.com/Philippe-Laval/tpantlr2)


[Language implementation patterns book examples in Java](https://media.pragprog.com/titles/tpdsl/code/tpdsl-code.zip)<br>
[Language implementation patterns book examples in C#](https://github.com/Philippe-Laval/tpdsl)

Also, there is a large collection of grammars for v4 at github:

[https://github.com/antlr/grammars-v4](https://github.com/antlr/grammars-v4)
