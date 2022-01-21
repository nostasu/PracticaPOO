# PracticaPOO
La practica de Programación Orientada a Objetos es sobre una fábrica de muebles, en la cual los clientes hacen pedidos de mesas y sillas, y hay artesanos que se dedican a preparar los pedidos y dejarlos listos para entregar.

# Ejemplo de uso
Con cualquier IDE, descargamos los archivos y simplemente lo compilamos y ejecutamos.

## PLANTEAMIENTO DEL PROBLEMA.
En la práctica se trata de abordar el diseño y la realización de una fábrica de muebles, a base de las instrucciones proporcionadas por la práctica.
Mi manera de ver la fábrica, y por tanto de interpretar el enunciado, es crear un sistema de control al que pueden acceder los empleados de la fábrica, fácil e intuitivo, a base de la navegación por menús que hacen sencilla la interacción con el programa.
Los actores participantes por tanto:
En primer lugar, mi manera de interpretarlo ha sido que los actores participantes son empleados (y con esto me estoy refiriendo a la clase empleado) y más concretamente:
-	Empleado Jefe. Va a ser el que va a acceder a la opción de asignar pedidos tal y como leemos en el enunciado, y por tanto,  accederá a la sección de pedidos y ahí entonces podrá asignar los pedidos a cada empleado. También, como los otros empleados, puede acceder a muchísimos mas menús e interaccionar con ellos, pero esa va a ser su principal interacción.
-	Empleado comercial. Va a ser el encargado de iniciar nuevos pedidos y comunicar el precio de los muebles a los clientes, así como los incrementos de precio y el precio final, por tanto, va a ser un actor que interaccione mucho con la gestión de pedidos (para dar de alta pedido y modificar los muebles de un pedido), pero también accederá a la gestión de usuarios ya que, si fuera necesario, creará clientes nuevos cuando estos le contacten para hacer un nuevo pedido.
-	Empleado Artesano. Que accederá a la gestión de pedidos para ver los pedidos que tiene en lista para ser iniciados y modificará el estado del pedido cuando o bien, haya completado todo el pedido, o tenga alguna incidencia con el mismo y quiera dejar constancia en el sistema.
## RELACIONES ENTRE ACTORES. 
Como he indicado anteriormente, el jefe estará muy relacionado con los artesanos ya que les tendrá que asignar los pedidos y siendo los artesanos los que se encargarán de trabajar en el pedido y marcar en el sistema cuando el pedido ya este finalizado. 
El comercial se relaciona con los clientes ya que este habla con ellos y recaba toda la información necesaria o bien para poder crear un pedido, o bien para poder modificar datos de un pedido. 

# Clases
## Clase DatosInicialesFabrica. 
Es la encargada de inicializar la fábrica, con unos empleados y unos pedidos, es una clase que principalmente se ha creado para pruebas para no tener que estar creando los objetos cada vez que entras en la aplicación. Es completamente prescindible.
## Clase fábrica.  
Es la encargada de iniciar la fabrica y de la cual tenemos que crear el objeto para acceder a la aplicación principal. Únicamente tiene un campo, el gestor principal, que será el encargado de llamar a la interfaz para imprimir el menú de bienvenida inicialmente.
Quiero explicar estas clases que comienzan con los nombres Interfaz y/o Gestor que sí que me parecen relevantes.
En todo momento, he intentado en la práctica dividir el menú que se muestra al usuario, con lo que serían las gestiones propias de cada gestor, para que así cada clase se dedique únicamente a una cosa. Así pues,  las que se llaman Interfaz son las encargadas de pedir datos al usuario y de imprimir datos por pantalla y las clases gestores son las que, con esos datos, hacen las operaciones realmente importantes en el sistema.
Clase Interfaz y clase GestorPrincipal.   
## Interfaz. 
Únicamente imprime el menú de bienvenida en pantalla, devuelve un dato de tipo void que usa el gestor principal para iniciar el gestor correspondiente (o bien usuarios (personas en nuestra jerarquía de herencia), o bien pedidos (con la correspondiente creación de los muebles). 
## GestorPrincipal. 
Como no se requería crear una base de datos, y menos mal porque sino no me daría tiempo, el GestorPrincipal es el encargado de iniciar todos los ArrayList así como de obtener el entero de la interfaz (que tiene como campo) y se encarga de llamar al método de bienvenida correspondiente de cada menú,
## Clase InterfazUsuarios, GestorUsuarios, InterfazPedido y  GestorPedidos. 
Tienen la misma metodología que las explicadas anteriormente, las interfaces textuales son las encargadas de pedir los datos al usuario y son los gestores las que las tratan adecuadamente.
## Clase Pedido. 
Es la clase encargada de relacionar al cliente con los muebles que ha pedido.
## Enumerados. 
Para definir mejor los estados de los artesanos y de los pedidos (EstadoArtesano y EstadoPedido).
Los métodos están explicados dentro de cada clase (quitando los setters y getters de los muebles y personas).
