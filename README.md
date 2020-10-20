# Jhonatan-Mallqui-19-10-20


### _Proyecto de Jugadas de Poker_


## Pre-Requisitos


* Java 8 (Instalado y Configurado)

* IDE para compilar proyectos Java (Instalado y Configurado en este caso use STS)

* Maven para repositorio de dependencias (Instalado y Configurado)

## Instalación

_Copiar lo siguiente y en una terminar git ejecutar el siguiente comando_

```
git clone https://github.com/jhonatanMD/Jhonatan-Mallqui-19-10-20.git
```

_Dirigirse al IDE y importar el archivo_

_Luego ejecutar el siguiente comando en una consola cmd o git en la ruta del proyecto ejemplo C:\Jhonatan-Mallqui-19-10-20/..._

```
mvn clean install
```
_Dirigirse al IDE darle click Izquierdo -> Maven -> Update Project -> Seleccionar Proyecto -> Force Update os Snapshots... -> darle click en OK 
o si estas en cualquier otro IDE actualizar las dependecias del maven para que pueda importarse al proyecto._

## Ejecución

* Dentro del IDE buscar el main que se encuentra en la clase GameControl.java darle click derecho y hacer correr programa (Run as Java Application) 

* Si se desea configurar la ruta de lectura del archivo modificar la clase Constant.java de la variable fileRead

* En la ruta  resource/files se encuentra el archivo pokerdata.txt donde se recorrera todas las jugadas

* Al ejecutar el proyecto se creara el archivo en la en la ruta  resource/OutputFilePoker.txt

* Si se desea configurar la ruta de creación del archivo modificar la clase Constant.java de la variable fileWrite

* Al ejecutar el proyecto dar F5 al proyecto para poder visualizar el archivo creado en la ruta resource/OutputFilePoker.txt


## Respuesta de Creacción de Archivo : 


### PUNTAJES SEGUN LAS MANOS DE CARTAS:

#### Player 1 : 376 -> _Jugadas Ganadas Generales_


#### Player 2 : 624 -> _Jugadas Ganadas Generales_


#### Empates por cada jugada :367 ->  _Empate de cada jugada_

#### Player 1 Gana empate por carta mayor : 141 -> _En el flujo el jugador1 tiene las mismas cartas que el jugador2 y en todo el proceso gana la carta mayor de player1_


#### Player 2 Gana empate por carta mayor : 226 -> _En el flujo el jugador2 tiene las mismas cartas que el jugador1 y en todo el proceso gana la carta mayor de player2_


---------PLAYER 1 --------- | ------ PLAYER 2 --------------

         14.1%                |       22.6 %

Total de Partidas son : 1000

376 + 624 = 1000


## Instrucciones de Juego

### Escalera Real de Color

> La mejor jugada del poker. Comprende las cartas 10, J, Q, K y A del mismo palo. Todo jugador tiene derecho a una de éstas a lo largo de su vida.

### Escalera de Color

> Cinco cartas de orden consecutivo del mismo palo. Cuanto más alta sea la carta más alta de la escalera, mejor es el ranking de la mano.
En este ejemplo la carta más alta es el 10; vencería a una escalera de color con un 9 de carta más alta.

### Poker

> Cuatro cartas del mismo valor. Cuanto más alto es el valor de estas cuatro cartas, más alto es el ranking de la mano. 
En caso de empate, posible en las variantes de póquer que usan cartas comunitarias, gana la mano cuya quinta carta sea más alta.

### Full

> Esta jugada reúne 3 cartas de un valor y 2 de otro. Cuando se comparan dos fulls, gana el que tiene el valor de las tres cartas más alto. 
Así pues, un full 7-7-7-2-2 supera a un full 5-5-5-A-A. En caso de que los tríos sean del mismo valor en dos manos, 
gana la mano que tenga la pareja de cartas restante más alta, con lo que por ejemplo 7-7-7-A-A superaría a 7-7-7-K-K.

### Color

>El color lo forman cinco cartas no consecutivas del mismo palo. Gana el desempate entre dos colores aquel que tenga la carta más alta.

### Escalera

> Para la escalera se precisan cinco cartas de orden consecutivo. Entre dos escaleras gana la que sea más alta. Por otra parte, 
el As puede usarse para formar la escalera A-K-Q-J-10, que sería una Escalera Real, y también la escalera 5-4-3-2-A.

### Trío

> Lo componen tres cartas del mismo valor. Entre dos tríos gana el que está formado por cartas más altas. 
Si ambos tríos están formados por cartas del mismo valor, decide el desempate la carta más alta de las dos restantes de que consta la mano,
y si esas dos cartas fueran iguales, se compararían las quintas cartas de cada mano.

### Doble Pareja

> Una doble pareja está formada por dos cartas del mismo valor en combinación con otras dos cartas también de un mismo valor, 
pero diferente al valor de las dos primeras. Cuando dos manos muestran doble pareja, gana la mano cuya pareja es más alta. 
Como siempre, en caso de empate decide la carta más alta.

### Pareja

> Dos cartas del mismo valor. Cuanto más alto es el valor de la pareja, más alto es su ranking. En caso de igualdad, se recurre a la carta más alta.

### Carta más Alta

> Cuando ningún jugador consigue formar una de las jugadas arriba expuestas, gana la mano aquel que tiene la carta más alta. 
Y en caso de empate, se usa la siguiente carta más alta.



#### fuentes : https://www.poquer.com.es/ranking.html


























