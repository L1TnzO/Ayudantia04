Enzo Loren

Analisis Diagrama clase

Jugador: Esta es una clase abstracta que representa a un jugador genérico en el casino. Tiene un atributo nombre que es común a todos los jugadores, independientemente del juego que estén jugando.

JugadorBlackjack y JugadorBullseye: Estas son subclases de Jugador y representan a los jugadores de los juegos de Blackjack y Bullseye, respectivamente. Heredan el atributo nombre de la clase Jugador. JugadorBullseye tiene atributos adicionales dinero y caballo que son específicos para el juego de Bullseye.

Blackjack y Bullseye: Estas clases representan los juegos de Blackjack y Bullseye, respectivamente. Cada una de estas clases tiene una relación de composición con su respectiva clase de Jugador (JugadorBlackjack y JugadorBullseye), lo que significa que cada instancia de un juego tiene un jugador asociado.

Carta y Caballo: Estas clases representan las cartas utilizadas en el juego de Blackjack y los caballos utilizados en el juego de Bullseye, respectivamente. La clase Blackjack tiene una relación de composición con Carta, y las clases Bullseye y JugadorBullseye tienen una relación de composición con Caballo.

Casino: Esta clase representa el casino en sí. No tiene una relación directa con las otras clases en el diagrama de clases, pero crea y utiliza instancias de las clases JugadorBlackjack, JugadorBullseye, Blackjack, y Bullseye en su método iniciar(), por lo que consideramos una dependecia con cada clase nombrada.

Main: Esta clase contiene el método main(), que es el punto de entrada al programa. Crea una instancia de la clase Casino y llama a su método iniciar(), por lo que tiene una relación de dependencia con Casino.

Validaciones: Esta clase contiene métodos estáticos que se utilizan para validar las entradas del usuario en el juego de Bullseye. No tiene una relación directa con las otras clases, pero sus métodos son utilizados por la clase Bullseye y Casino por medio de una dependencia.

BlackjackGUI: Esta clase es una interfaz gráfica de usuario (GUI) que facilita la interacción del jugador con el juego de Blackjack. Tiene una relación de composición con la clase Blackjack, ya que contiene una instancia de Blackjack y la utiliza para jugar el juego. También contiene una instancia de JugadorBlackjack que se utiliza para representar al jugador. Adicionalmente, tiene una relación de dependencia con la clase Casino, ya que llama al método iniciar() del Casino cuando el jugador elige regresar.

BullseyeGUI: Similar a BlackjackGUI, esta clase es una GUI para el juego de Bullseye. Tiene una relación de composición con la clase Bullseye y JugadorBullseye. También tiene una relación de dependencia con la clase Casino, ya que llama al método iniciar() del Casino cuando el jugador elige regresar. Además, BullseyeGUI tiene una relación de composición con la clase Caballo, ya que contiene una lista de caballos que se usa para llenar el cuadro combinado de la interfaz gráfica de usuario.

CasinoGUI: Esta clase es la GUI para el casino en general. Tiene una relación de composición con la clase Casino, ya que contiene una instancia de Casino y llama a los métodos abrirBlackjack() y abrirBullseye() del Casino. CasinoGUI también actualiza el nombre del jugador en la instancia del Casino, por lo que tiene una relación bidireccional con él.





Cambios Observados

Clase CasinoGUI: Esta clase representa la interfaz gráfica de usuario del Casino, permitiendo al usuario elegir entre diferentes juegos (Blackjack y Bullseye en este caso) e introducir su nombre. Una vez que el usuario elige un juego, se invoca la función correspondiente en la clase Casino.

Clase Casino: Esta clase actúa como el núcleo del programa. Gestiona la lógica principal del casino, incluyendo el inicio de la aplicación y la apertura de los distintos juegos. Los métodos abrirBlackjack() y abrirBullseye() se encargan de iniciar las respectivas interfaces gráficas de los juegos, y utilizan el nombre ingresado por el usuario. La validación de la entrada del nombre se realiza en esta clase.

Clases BlackjackGUI y BullseyeGUI: Estas clases representan las interfaces gráficas de los respectivos juegos. Ambos tienen una estructura similar, incluyendo un botón para jugar, un botón para volver al menú principal y un área de texto para mostrar la salida del juego. Un detalle importante es que BullseyeGUI también permite al usuario seleccionar un caballo y hacer una apuesta mediante cuadros combinados.

Integración de juegos individuales con la GUI: Los juegos de Blackjack y Bullseye están integrados con sus respectivas interfaces gráficas mediante la redirección de la salida estándar a un ByteArrayOutputStream, que luego se muestra en el área de texto de la GUI. Este enfoque permite utilizar la lógica de juego existente sin tener que modificarla para trabajar con una interfaz gráfica.

Navegación entre interfaces: Al presionar el botón "Atrás" en las interfaces de juego, la interfaz actual se oculta y se inicia la interfaz del casino.
