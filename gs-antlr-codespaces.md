# Getting Started with ANTLR v4, using GitHub CodeSpaces, and Java

If you are using Java as your programming language of choice to develop lexers and parsers, this guide may help you.

Cloud based computing is a platform that let you setup and configure a computer somewhere on the cloud.
In this guide, we chose GitHub Codespaces.
You will need a GitHub account in order to continue (link here). Check if you are eligible to GitHub for Education (link here).

ANTLR and GitHub CodeSpaces support some programming languages out of the box, like C, C++, or Python.
In this guide, we chose Java, mostly because it is a language that many students are familiar with. 

## Getting started with a GitHub CodeSpaces area

We will start creating a new repository. Make sure you select a README, and .gitignore file related to Java.

(Image here)

Next, we will create a code space, that will have a Linux box with java, javac, and Maven ready.

(Image here)

This code space will be setup once and will be available as long as the code space is not removed.

This setup is particularly helpful if you do not have administrator privileges on your machine or if you need to use different computers along the day (e.g. at home, at school, at work, computer labs along the week). Just use your web browser to access your code space from wherever computer you have at the moment.

The downside of cloud computing is that you need a reliable Internet connection.

## ANTLR Installation

ANTLR is really two things: a tool written in Java that translates your grammar to a parser/lexer in Java (or other target language) and the runtime library needed by the generated parsers/lexers. Even if you are using the VS Code extension, the generated code will still need the runtime library. 

The first thing you should do is download and install a VS Code extension to get a nice text editor and diagrams for you to check your grammar. Even if you only use such tools for editing, they are great. 

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
