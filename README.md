# ideal-guide

# Instruções para instalação do ANTLR 4

A versão atual do ANTLR 4 é a 4.13.2.

## Instalação manual

Obtenha a versão atual:

```
curl -O https://www.antlr.org/download/antlr-4.13.2-complete.jar
```

Mova o arquivo para a pasta de bibliotecas locais:
```
sudo mv antlr-4.13.2-complete.jar /usr/local/lib/
```

Inclua ao final do arquivo em ~/.bashrc:
```
export CLASSPATH=".:/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH"
alias antlr4='java -jar /usr/local/lib/antlr-4.13.2-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'
```

Atualize a configuração do terminal:
```
source ~/.bashrc
```

Após completar esta instalação, a biblioteca antlr estará incluída em todos os usos do java e do javac.

Os comandos antlr4 e grun servem de atalho para utilizar as ferramentas da biblioteca.


Nota: no momento, o Debian instala uma verão antiga do ANTLR. Caso utilize apt, instale a biblioteca compatível com a versão instalada.

Obtenha a versão instalada executando antr4.

# Exemplo

Entre na pasta example, gere o Lexer e o Parser descritos no Example.g4:

```
antlr4 Example.g4
```
Vários arquivos serão gerados, incluindo arquivos .java.
Compile os arquivos .java com:

```
javac *.java
```

Observe que o TestExample.java utiliza o Lexer e o Parser para analisar o conteúdo do arquivo input.txt, ativando a regra prog().

```
java TestExample
```


