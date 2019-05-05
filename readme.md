# GAICurricula

## Índice

## 1. Introducción
GAICurricula es un proyecto que nació en una asignatura llamada Gestión Avanzada de la Información, en la cual la mayor parte de su tiempo se dedica a estudiar tecnologías para XML.

Entre ellas, una de las claves fue XQuery, tecnología que debía ser parte de un entregable del mismo proyecto. Este era un entregable básico que unicamente consistía en a través de un solo fichero java, generar ficheros HTML con información de XML sobre curriculums. A partir de aquí y ya con lo básico, se tuvo la idea de extenderlo y adaptar todo esto a MAVEN.

Su extensión fue a raíz de creer que había potencial para hacer algo más complejo con estas herramientas, dando así como fruto PomHTML, una aplicación de escritorio que permite crear un HTML básico con toda la información de un pom de un proyecto Java. En pasos posteriores explicaremos como es su instalación y su uso.

## 2. Requisitos para la aplicación
Para esta aplicación se necesita unicámente tener **JDK 1.8** y **MAVEN** instalados.

## 3. Instalación y uso de la aplicación

### Instalación y otras utilidades a comentar
La instalación del proyecto es sencilla, tan solo hace falta una vez importado el proyecto realizar la siguiente instrucción en una ventana de comandos.
```
mvn clean package assembly:single
```
Esta instrucción nos limpiará lo que pudimos hacer anteriormente en el proyecto con instrucciones MAVEN y nos realizará lo que antes hacía en la fase package, pero con la diferencia de que también nos creará el jar ejecutable para utilizar la aplicación.
El ejecutable y lo generado estará en la carpeta *target*, en el caso de que se quiera desinstalar la aplicación será tan fácil como escribir lo siguiente.
```
mvn clean
```

### Uso de la aplicación
Después de comentar lo referente a la instalación de la aplicación, toca su ejecución. El uso de la aplicación es muy sencillo y lo explicaremos a continuación en unos cuantos pasos.

1. Después de instalar la aplicación, el siguiente paso es ejecutarla, para ello clicamos dos veces en el jar generado y se nos mostrará la pantalla siguiente, dándonos la bienvenida a la aplicación.

![demo0](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo0.PNG)

Este primer punto que nos muestra es importante, ya que debido a un problema por resolver de esta fase temprana del proyecto se pide al usuario que de su fichero pom.xml le borre de la etiqueta pom todos sus atributos. Una vez se haga esto y aceptemos la notificación, pasamos al segundo paso.

![demo1](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo1.PNG)

2. Teniendo ya la aplicación lista para usarse, el siguiente paso será examinar y referenciar donde se encuentra nuestro pom, examinar y referenciar donde guardar el fichero HTML y por último dar nombre al fichero HTML que se va a generar.

![demo2](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo2.PNG)

![demo3](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo3.PNG)

Aquí hemos dejado un campo sin rellenar para comprobar la notificación que nos saldría si por algún casual nos hemos dejado información, en el caso de rellenar mal estos campos y darle al botón "Procesar POM" también nos elevará una advertencia para qhe rellenemos correctamente los campos, la aplicación ejecuta todo tipo de comprobaciones para ejecutarse correctamente.

3. Una vez rellenemos correctamente los campos de la aplicación sin dejarnos ningún campo en blanco, ejecutaremos de nuevo.

![demo4](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo4.PNG)

Después de ejecutar nos abrirá la siguiente ventana en caso de que queramos ver el HTML generado.

![demo5](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo5.PNG)

Para este caso nos interesa, así que le daremos que sí y a través de la aplicación que nosotros hayamos definido para abrir los ficheros HTML, se ejecutará mostrándonos el fichero, en nuestro caso pusimos el navegador para verlo de una manera gráfica. El fichero HTML generado por la aplicación siempre será de este estilo.

![demo6](https://raw.githubusercontent.com/cs-ehu/GAICurricula/master/imgs/demo6.PNG)

Y con todo esto dicho, así es el uso de está aplicación.

## 4. Estructura del proyecto

El árbol de estructura general de este proyecto es la siguiente:

```
Listado de rutas de carpetas
C:\Users\Michel\workspace\GAICurricula
|-- doxygen
|   |-- Doxyfile
|   `-- html
|-- imgs
|   |-- app.png
|   |-- fransua.jpg
|   |-- george.jpg
|   |-- hector.jpg
|   `-- john.jpg
|-- input
|   |-- curriculum.xml
|   |-- curriculumEnHTML.xquery
|   |-- curriculumEngland.xml
|   |-- curriculumEnglandSimp.xml
|   |-- curriculumFrHTML.xquery
|   |-- curriculumFrance.xml
|   |-- curriculumFranceSimp.xml
|   |-- erasmus.sch
|   |-- erasmus.xsd
|   |-- francia.sch
|   |-- francia.xsd
|   |-- inglaterra.xsd
|   |-- pom.xml
|   `-- pomHTML.xquery
|-- libraries
|   `-- saxon9-xqj.jar
|-- output
|   |-- curriculumEngland.html
|   |-- curriculumFrance.html
|   `-- pomGAICurricula.html
|-- pom.xml
|-- readme.md
|-- src
|   |-- main
|   |   `-- java
|   |       `-- edu
|   |           `-- ehu
|   |               `-- CS19
|   |                   `-- GAICurricula
|   |                       |-- Data2html.java
|   |                       |-- Pomexec.java
|   |                       `-- XQueryMethods.java
|   `-- test
|       `-- java
|           `-- edu
|               `-- ehu
|                   `-- CS19
|                       `-- GAICurricula
|                           `-- XQueryMethodsTest.java
`-- target
    |-- classes
    |   `-- edu
    |       `-- ehu
    |           `-- CS19
    |               `-- GAICurricula
    |                   |-- Data2html.class
    |                   |-- Pomexec$1.class
    |                   |-- Pomexec$2.class
    |                   |-- Pomexec$3.class
    |                   |-- Pomexec$4.class
    |                   |-- Pomexec$5.class
    |                   |-- Pomexec$6.class
    |                   |-- Pomexec.class
    |                   `-- XQueryMethods.class
    |-- generated-sources
    |   `-- annotations
    `-- test-classes
        `-- edu
            `-- ehu
                `-- CS19
                    `-- GAICurricula
                        `-- XQueryMethodsTest.class

31 directories, 41 files
```

## 5. Licencia
La licencia utilizada para este proyecto es la **GNU General Public License v3.0**.
Esta licencia permite en la aplicación su uso comercial, su modificación, su distribución, su uso privado y el poder ser patentada.
Para más información sobre la licencia de este proyecto, haga click en [LICENSE](LICENSE).

## 6. Autoría
Toda la autoría de este proyecto corre a manos de [FosterGun](https://github.com/FerMod).
Si se desea contactar con él puede hacerlo a través de GitHub o a través de su [correo eléctronico](mailto:mblanco040@ikasle.ehu.es)