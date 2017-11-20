# NASA Robot Challenge
A programming challenge where the goal is control a robot's directions in Mars, using java EE Technologies.

## Problema
Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas `(x, y)` e por uma letra, que pode representar uma das quatro orientações: `NORTH`, `SOUTH`, `EAST` e `WEST`. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria `(0, 0, N)`, que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras `L`, `R` e `M`. As letras `L` e `R` fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra `M` faz o robô deslocar-se uma posição para frente.
Assuma que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição `(x,y)`, é a posição `(x, y+1)`
Exemplo: Se o robô está na posição `(0,0,N)`, o comando `MML` fará ele chegar na posição `(0,2,W)`.

### Requisitos do desafio

* O terreno deverá ser iniciado com `5x5` posições.
* O robô inicia na coordenada `(0,0,N)`.
* Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele.
* O Robô não pode se movimentar para fora da área especificada.
* Não deve guardar estado do robô para consulta posterior.



## **Instruções aos "navegantes" do projeto** ##

A aplicação nasa-robot foi implementada na linguagem Java, então peço sua atenção para o comentário a seguir:

**[ IMPORTANTE ]** É imprescindível que a JVM 1.8 esteja instalada em sua máquina. 

(Obs.: Caso não esteja familiarizado com o termo "JVM 1.8", trata-se da versão do Java e é popularmente conhecida como Java 8, então dê um "pulo" no google para maiores informações de sua instalação)

E aí, a JVM 1.8 está instalada ? SIM. 

Parabéns ! Então vamos prosseguir. :+1:

### Dúvida 01 : Deseja obter os fontes do projeto para executá-lo em seu Eclipse IDE ?

+ Baixe os fontes do repositório. Ex.:
```sh
git clone https://github.com/igmfilho/nasa-robot.git
```
+ Importe o projeto no Eclipse como "Maven Project".

+ Execute o Maven no Eclipse para associar as dependências do projeto. (Obs.: Há 2 launchers savlos no diretório etc, então utilize-os se preferir.)

+ E para dar o start na aplicação nasa-robot, execute a classe java "com.github.igmfilho.challenge.nasarobot.NasaRobotSpringBootApp". 


### Dúvida 02 : Deseja apenas executar a aplicação nasa-robot ?

+ Execute o comando num terminal/prompt:
```sh
java -jar nasa-robot-0.0.1-SNAPSHOT.jar
```

### **Instruções para o uso da API** ###

A execução da aplicação nasa-robot disponibilizará um servidor http onde há a seguinte API REST :
```sh
$ POST http://localhost:8080/rest/nasa-robot/moveto/{command}
#Exemplo 01: http://localhost:8080/rest/nasa-robot/moveto/MMRMMRMM
#Exemplo 02: http://localhost:8080/rest/nasa-robot/moveto/MML
```

###Alguns cenários de teste:
Movimento com rotações para direita:
```sh
curl -s --request POST http://localhost:8080/rest/nasa-robot/moveto/MMRMMRMM
Saída esperada: (2, 0, S)
```

Movimento para esquerda:
```sh
Entrada: curl -s --request POST http://localhost:8080/rest/nasa-robot/moveto/MML
Saída esperada: (0, 2, W)
```

Repetição da requisição com movimento para esquerda:
```sh
Entrada: curl -s --request POST http://localhost:8080/rest/nasa-robot/moveto/MML
Saída esperada: (0, 2, W)
```

Comando inválido:
```sh
curl -s --request POST http://localhost:8080/rest/nasa-robot/moveto/AAA
Saída esperada: 400 Bad Request
```

Posição inválida:
```sh
curl -s --request POST http://localhost:8080/rest/nasa-robot/moveto/MMMMMMMMMMMMMMMMMMMMMMMM
Saída esperada: 400 Bad Request
```
