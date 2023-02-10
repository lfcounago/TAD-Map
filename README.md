# TAD-Map
Implementation and use of TAD Map

# 1.- Implementación del TAD Map<K,V>. Para ello desarrolla un proyecto en java que contenga la interfaz Map y una clase que implemente dicha interfaz haciendo uso de una Tabla Hash.

La tabla hash se utiliza para almacenar la colección de objetos <clave, valor> y debe utilizar la estrategia de encadenamiento abierto o separado (un array de listas) para resolver el problema de las colisiones. Para trabajar con listas se puede usar el TAD Lista de la librería aed1.jar o la interface List de java.

Durante el proceso de búsqueda, inserción o borrado de un elemento de la tabla hash, el primer paso a realizar es transformar la clave en un índice del array, es decir, aplicar una función hash. Este índice indicará la lista en la que hay que buscar, insertar o eliminar el elemento correspondiente. Esta función debe implementarse mediante un método privado que, para esta actividad, codificará el método de división:
    
    private int funcionHash (K clave)

Un problema de esta función (método de división) es que para poder aplicarla es necesario que el objeto que se pasa como parámetro sea de tipo int. Para resolver este problema existe en java el método hashCode(), que convierte cualquier objeto en un int. Es decir, clave.hashCode() convierte el parámetro de entrada de la función a un valor entero, lo cual permite trabajar con cualquier objeto en la tabla hash.


# 2.- Haciendo uso del TAD Map, implementa los algoritmos que se indican a continuación:

# a) Implementa el TAD Grafo haciendo uso de un MAP.

Una implementación eficiente del TAD Grafo<E,T> es posible mediante mapas de adyacencia. Es una implementación similar a la implementación mediante listas de          adyacencia, es decir, se mantiene una lista de vértices, y para cada vértice se guarda la relación de vértices adyacentes. Pero en esta ocasión, en lugar de guardar    los adyacentes en una lista, se guardan en un TAD Map<K,V>, donde el vértice adyacente actúa como clave y la etiqueta del arco actúa como valor.

Una posible clase que implemente la interfaz Grafo<E,T> haciendo uso de dicha representación sería:

    public class MapAdyacencia<E,T> implements Grafo<E,T>{
    private List<VerticeConMap<E,T>> listVertices;

Donde la clase VerticeConMap<E,T> es una clase con dos atributos, como se puede observar a continuación:

    public class VerticeConMap<E,T> {
      private Vertice<E> origen; // vértice del grafo
      private Map<Vertice<E>, T> mapAdy; // mapa de adyacentes del vértice origen
      VerticeConMap(Vertice<E> v) {
        origen = v;
        mapAdy = new HashMap<>();
      }
      Vertice<E> getVertice(){
        return origen;
      }
      Map<Vertice<E>, T> getAdy(){
        return mapAdy;
      }
    }
    
Es importante aclarar que el mapa guarda pares <clave, valor>, siendo en este caso la clave el vértice adyacente, y el valor, la etiqueta del arco.

Se pide, haciendo uso de dicha representación, implementar los métodos de la interfaz Grafo<E,T> que se indican a continuación:

    public Iterator<Vertice<E>> adyacentes (Vertice<E> v)
    //Produce: devuelve un iterador sobre los vértices adyacentes al vértice v que se pasa como parámetro.
     public boolean estaArco(Arco<E,T> a)
    //Produce: devuelve cierto si el arco a que se pasa como parámetro pertenece al conjunto de arcos del grafo
    
La clase Arco<E,T> se muestra a continuación:

    public class Arco <E,T>{
      private Vertice<E> origen, destino;
      private T etiqueta;
      public Arco(Vertice<E> o, Vertice<E> d, T c)
      public Vertice<E>E getOrigen()
      public Vertice<E> getDestino()
      public T getEtiqueta()
    }
 
 
# b) Usando el TAD Map desarrolla un proyecto que, dado un texto con abreviaturas, devuelva un nuevo texto con esas abreviaturas extendidas.

  - tres ficheros .json que son, respectivamente, tres diccionarios de abreviaturas junto con su extensión, en los idiomas inglés, español y francés. Con ellos se        puede extender las abreviaturas presentes en textos escritos en los tres idiomas.

  - un fichero .java que contiene el código necesario para guardar la información de los diccionarios de abreviaturas en una estructura de datos MAP. Esta estructura     de datos es la que se usará para realizar la extensión en los textos.

  - Dos ficheros .jar, que son dos librerías necesarias para poder trabajar con los ficheros json

# c) Un polinomio es una expresión algebraica constituida por una suma finita de términos: anxn + an-1xn-1 + …+ a1x1 + a0x0. Cada monomio o término del polinomio contiene un coeficiente de tipo real y un exponente de tipo entero positivo. Al valor máximo del exponente se le conoce con el nombre de grado. Las operaciones que debe tener el TAD Polinomio son las siguientes:

    public Polinomio()
    // Produce: Inicializa this al polinomio cero
    
    public int grado()
    // Produce: Devuelve el grado del polinomio, es decir, el mayor exponente de un
    // término con coeficiente distinto de cero. Devuelve 0 si es el polinomio cero.
    
    public double coeficiente(int n)
    // Produce: Devuelve el coeficiente del término de grado n. Si el término no existe,
    // devuelve 0.
    
    public void añadirTermino (int exponente, double coeficiente) throws IllegalArgumentException
    // Modifica: this
    // Produce: si el exponente es negativo o el coeficiente es 0 lanza la excepción
    // IllegalArgumentException; en otro caso, añade el termino (coeficiente x exponente) a
    // this
    
    public void eliminarTermino(int exponente)
    // Modifica: this
    // Produce: elimina el término con exponente que se pasa como parámetro
    
    public Polinomio suma (Polinomio p)
    // Produce: un nuevo polinomio que es la suma de los polinomios p y this
    
    public Polinomio derivada()
    // Produce: Dado el polinomio this de la forma anxn + an-1xn-1 + …+ a1x1 + a0x0
    // devuelve su derivada: (n*an) xn-1 + (n-1 * an-1) xn-2 + …+ a1

Se pide implementar el TAD Polinomio usando el TAD Map, de forma que los exponentes sean las claves y los coeficientes los valores.

# d) Dado un conjunto de palabras del mismo tamaño, se quiere construir un grafo que represente las relaciones entre las palabras. El grafo relaciona dos palabras si se diferencian por una sola letra. La siguiente figura muestra un pequeño grafo de algunas palabras en inglés.

Para ello se propone la siguiente solución. A partir de cada palabra del conjunto vamos a crear varias claves, cada una formada por las letras de la palabra menos una, que se sustituye por un guion. Por ejemplo, para las siguientes palabras {“pool”, “cool”, “fool”, “foul”, “foil”} podríamos tener las siguientes claves {“_ool”, “p_ol”, “po_l”, “poo_”, “c_ol”, “co_l”, “coo_”, “f_ol”, “fo_l” “foo_”, ….. }

A continuación, cada palabra del conjunto inicial se guarda con su clave correspondiente, es decir, con aquella clave con la que coinciden todos los caracteres, considerando el guion un comodín. De esta forma, todas las palabras que están con la misma clave sabemos que solo se diferencian en un carácter y por lo tanto tienen que estar conectadas en el grafo.

Este esquema se puede implementar haciendo uso de un diccionario, asociando a cada clave la lista de palabras que se guardan con ella.
Una vez creado el diccionario se puede construir el grafo fácilmente. Los vértices van a ser las palabras del conjunto inicial y las aristas se crean entre los vértices que están en la misma lista.

Escribe un programa que convierta una colección de palabras en un grafo.
