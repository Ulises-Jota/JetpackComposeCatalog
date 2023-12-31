# Catálogo de componentes de ***Jetpack Compose***

#### *Notas tomadas del curso de Aris Guimerá, disponible en Udemy

### Índice

- [1. Estados en *Compose*: *State property*](#1-estados-en-compose-state-property)
- [2. Componentes de texto](#2-componentes-de-texto)
- [3. ***State hoisting***](#3-state-hoisting)
- [4. Componente ***Button***](#4-componente-button)
- [5. Componente de imagen](#5-componente-de-imagen)
- [6. Componente ***ProgressBar***](#6-componente-progressbar)
- [7. Componentes de selección](#7-componentes-de-selección)
- [8. Otros componentes](#8-otros-componentes)
- [9. ***RecyclerView*** en *Compose*](#9-recyclerview-en-compose)
- [10. ***Scaffold***](#10-scaffold)
- [11. Navegación en *Compose*](#11-navegación-en-compose)

### 1. Estados en *Compose*: *State property*

Se puede evitar tener que poner el ``.value`` de un estado cada vez que se lo necesita.

Para eso, en vez de igualar la variable con ``rememberSaveable{}``, se utiliza un delegado que se
encarga de importar el ``getter`` y ``setter`` correspondientes:

````kotlin
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = state,
        // DO SOMETHING
    )
}
````

### 2. Componentes de texto

El componente ***TextField*** sería el equivalente al ***EditText*** en el sistema de vistas
clásico.  
Dicho componente debe gestionar estado y recibe dos parámetros: el valor que se le va a asignar y
una lambda que va a retornar el valor luego de ser modificado por el usuario.

````kotlin
var someText by rememberSaveable { mutableStateOf("") }
TextField(value = someText, onValueChange = { someText = it })
````

El ***OutlinedTextField*** es una variante del ***TextField*** que muestra un borde alrededor del
campo. Es
posible modificar el color del borde dependiendo si está en foco o no:

````kotlin
var myText by remember { mutableStateOf("") }
OutlinedTextField(
    value = myText,
    onValueChange = { myText = it },
    modifier = Modifier.padding(24.dp),
    label = { Text(text = "Example") },
    colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Magenta,
        unfocusedBorderColor = Color.Blue
    )
)
````

### 3. ***State hoisting***

Los estados no deberían estar en los ``Composables`` (deberían ser ***stateless*** en la medida de
lo posible).  
Para eso, se usa un patrón llamado ***State Hoisting***, que consiste en sacar los estados de
los ``Composables`` a un miembro superior, lo cual permite **reutilizarlo en otros componentes**.

### 4. Componente ***Button***

***Button*** es el ``Composable`` que renderiza un botón. Tiene la particularidad de que debe
implementar el ``onClick`` obligatoriamente.  
Este componente tiene otras variantes, como el ***OutlineButton*** o el ***TextButton***.

### 5. Componente de imagen

Se pueden visualizar todos los íconos disponibles [aquí](https://fonts.google.com/icons).  
Pero para utilizar todos esos íconos en un proyecto, es necesario agregar la siguiente dependencia
al ``build.gradle(:app)``:

````kotlin
implementation "androidx.compose.material:material-icons-extended:$compose_version"
````

### 6. Componente ***ProgressBar***

El ***ProgressBar*** se usa para dar feedback al usuario cuando la aplicación está realizando
operaciones por detrás.  
Hay dos tipos de indicadores: ***LinearProgressIndicator*** y ***CircularProgressIndicator***.

### 7. Componentes de selección

***Switch***, ***CheckBox*** y ***RadioButton***  
Los tres componentes son similares en cuanto a que se les debe ***indicar un estado*** y la ***
acción a realizar*** cuando el estado del componente cambia.  
El ***CheckBox*** tiene la particularidad de que ***puede tener un tercer estado***, además
de ``on`` y ``off``, llamado ``indeterminate``.

### 8. Otros componentes

***Card*** vs ***Surface***  
Una ***Card*** es simplemente una ***Surface*** con valores por defecto (``elevation``, ``shape``,
etc).

***BadgedBox***  
Se utiliza para mostrar información dinámica, como puede ser el número de mensajes sin leer de una *
app* de *mail* o mensajería.

***DropDownMenu***  
Se utiliza para desplegar un menú de opciones.

***Slider***  
Se utiliza para permitir a los usuarios hacer selecciones entre un rango de valores.  
También está disponible un tipo especial llamado ***RangeSlider***, que amplía la funcionalidad
del ***Slider*** utilizando los mismos conceptos, pero permite al usuario seleccionar dos valores.

***Dialogs*** y ***AlertDialogs***
Permite mostrar un diálogo en base al diseño que se especifique.  
El ***AlertDialog*** ya implementa por defecto un título, una descripción y dos botones.

### 9. ***RecyclerView*** en *Compose*

Para crear listas dinámicas se usan las funciones ``Composables`` ``LazyColumn`` (vertical) o ``LazyRow`` (horizontal).  
Para añadir elementos a estas listas, se utilizan las funciones ``item`` o ``items`` (para más de un elemento).

``LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {...}``: La función ``spacedBy`` permite agregar un espacio entre las vistas hijas del componente a través del eje principal (en este caso, vertical). Si el espacio es negativo, los hijos van a superponerse.

La función ``rememberLazyListState`` crea y recuerda el estado de la lista a través de las diferentes composiciones.

***Sticky headers*** **(cabeceras)**: La función ``stickyHeader`` permite agregar una cabecera que permanece fija hasta que la próxima cabecera ocupe su lugar.

### 10. ***Scaffold***

Es un _layout_ ``Composable`` creado para montar vistas de una forma más sencilla, ya que funciona como un "esqueleto" de una pantalla que sigue la estructura propuesta por _Material Design_.

### 11. Navegación en *Compose*

Para la navegación, se requiere de varios componentes.  
El primero de ellos es un ``NavHostController``, que será el encargado de gestionar la navegación entre los ``Composables``. Se obtiene con la función ``rememberNavController()``.  
Luego, hace falta un ``NavHost``, que provee el lugar en el cual se realizará la navegación. Como argumentos puede recibir, entre otros, un ``NavHostController``, un ``String`` con el ``startDestination``, un ``modifier`` y un ``builder``, usado para construir el grafo de navegación, a través de un ``NavGraphBuilder``. Todos los ``composables`` dentro de dicho grafo, se podrán navegar a través del ``NavHostController`` provisto.  
Tanto el parámetro ``startDestination`` del ``NavHost`` como el parámetro ``route`` de cada uno de lo ``composables`` que van dentro del grafo de navegación, hacen referencia a una pantalla única dentro de la aplicación, por lo que deben ser **identificadores únicos**.  
Cada ``composable`` contiene ese **ID único** (o **ruta**) y la pantalla correspondiente, entre otros parámetros que acepta. Si a esa pantalla se le pasa el objeto ``NavHostController`` creado previamente, luego se puede hacer uso de su función ``navigate``, la cual espera la ruta de la pantalla a la cual debe navegar dentro del grafo de navegación.  
**_Navigation Compose_** también soporta el paso de argumentos entre destinos ``composables``. Estos argumentos pueden ser mandatorios u opcionales. Y dependiendo de eso, varía levemente la forma en que se declaran como parte de la ruta, haciendo uso de _placeholders_ (más info en la [documentación oficial](https://developer.android.com/jetpack/compose/navigation#nav-with-args)).  
A modo de resumen: cuando se declara el ``composable`` dentro del grafo de navegación, se agrega la ruta correspondiente a la pantalla, una lista de los argumentos que espera (se arman con la función ``navArgument``) y en el ``content`` (donde se llama a la pantalla propiamente dicha), además del objeto ``NavHostController`` también se le pasa el/los argumento/s que se capturarán cuando se invoque dicha pantalla. Por otro lado, al momento de llamar a la función ``navigate`` para navegar a cierta pantalla, se le pasa por parámetro el/los argumento/s como parte de la ruta.
