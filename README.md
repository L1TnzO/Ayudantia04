Enzo Loren

Analisis Diagrama clase

Cambios Observados

Clase CasinoGUI: Esta clase representa la interfaz gráfica de usuario del Casino, permitiendo al usuario elegir entre diferentes juegos (Blackjack y Bullseye en este caso) e introducir su nombre. Una vez que el usuario elige un juego, se invoca la función correspondiente en la clase Casino.

Clase Casino: Esta clase actúa como el núcleo del programa. Gestiona la lógica principal del casino, incluyendo el inicio de la aplicación y la apertura de los distintos juegos. Los métodos abrirBlackjack() y abrirBullseye() se encargan de iniciar las respectivas interfaces gráficas de los juegos, y utilizan el nombre ingresado por el usuario. La validación de la entrada del nombre se realiza en esta clase.

Clases BlackjackGUI y BullseyeGUI: Estas clases representan las interfaces gráficas de los respectivos juegos. Ambos tienen una estructura similar, incluyendo un botón para jugar, un botón para volver al menú principal y un área de texto para mostrar la salida del juego. Un detalle importante es que BullseyeGUI también permite al usuario seleccionar un caballo y hacer una apuesta mediante cuadros combinados.

Integración de juegos individuales con la GUI: Los juegos de Blackjack y Bullseye están integrados con sus respectivas interfaces gráficas mediante la redirección de la salida estándar a un ByteArrayOutputStream, que luego se muestra en el área de texto de la GUI. Este enfoque permite utilizar la lógica de juego existente sin tener que modificarla para trabajar con una interfaz gráfica.

Navegación entre interfaces: Al presionar el botón "Atrás" en las interfaces de juego, la interfaz actual se oculta y se inicia la interfaz del casino.
