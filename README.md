Enzo Loren

Analisis Diagrama clase

Jugador: Esta es una clase abstracta que representa a un jugador genérico en el casino. Tiene un atributo nombre que es común a todos los jugadores, independientemente del juego que estén jugando.

JugadorBlackjack y JugadorBullseye: Estas son subclases de Jugador y representan a los jugadores de los juegos de Blackjack y Bullseye, respectivamente. Heredan el atributo nombre de la clase Jugador. JugadorBullseye tiene atributos adicionales dinero y caballo que son específicos para el juego de Bullseye.

Blackjack y Bullseye: Estas clases representan los juegos de Blackjack y Bullseye, respectivamente. Cada una de estas clases tiene una relación de composición con su respectiva clase de Jugador (JugadorBlackjack y JugadorBullseye), lo que significa que cada instancia de un juego tiene un jugador asociado.

Carta y Caballo: Estas clases representan las cartas utilizadas en el juego de Blackjack y los caballos utilizados en el juego de Bullseye, respectivamente. La clase Blackjack tiene una relación de composición con Carta, y las clases Bullseye y JugadorBullseye tienen una relación de composición con Caballo.

Casino: Esta clase representa el casino en sí. No tiene una relación directa con las otras clases en el diagrama de clases, pero crea y utiliza instancias de las clases JugadorBlackjack, JugadorBullseye, Blackjack, y Bullseye en su método iniciar(), por lo que consideramos una dependecia con cada clase nombrada.

Main: Esta clase contiene el método main(), que es el punto de entrada al programa. Crea una instancia de la clase Casino y llama a su método iniciar(), por lo que tiene una relación de dependencia con Casino.

Validaciones: Esta clase contiene métodos estáticos que se utilizan para validar las entradas del usuario en el juego de Bullseye. No tiene una relación directa con las otras clases, pero sus métodos son utilizados por la clase Bullseye y Casino por medio de una dependencia.

Cambios Observados

Juegos separados: En el código anterior, solo se implementaba el juego de Blackjack. En el nuevo código, se han implementado dos juegos separados: Blackjack y Bullseye, cada uno con su propia lógica y reglas.

Clases de Jugador: En el código anterior, solo había una clase de jugador. En el nuevo código, hay dos clases de jugador: JugadorBlackjack y JugadorBullseye, cada una para un juego diferente.

Clase Casino: En el código anterior, no había una clase Casino. En el nuevo código, se ha introducido una clase Casino que maneja la interacción con el usuario y permite al usuario elegir entre los diferentes juegos disponibles.

Clase Validaciones: En el nuevo código, se ha introducido una clase Validaciones que contiene métodos estáticos para validar las entradas del usuario y las condiciones del juego.

Clase Caballo: En el nuevo código, se ha introducido una clase Caballo que se utiliza en el juego Bullseye.

Clase Carta: En el código anterior, la clase Carta tenía tres atributos: valor, pinta y figura. En el nuevo código, la clase Carta solo tiene dos atributos: pinta y valor.

Método Main: En el código anterior, el método main iniciaba un juego de Blackjack. En el nuevo código, el método main inicia un objeto Casino que permite al usuario elegir entre los diferentes juegos disponibles.
