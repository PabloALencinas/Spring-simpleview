# CURSO COMPLETO DE SPRING BOOT - 40.5HS CON PROYECTOS

# 1ra Seccion - Introduccion

# 2da Seccion - Spring MVC
    
### 1) Creando un proyecto con Spring (spring.initialize.io)
    - Tenemos los directorios creados automaticamente
      - IMPORTANTES
          - Resources/static -> Recursos estaticos de la app (css, JS, images..)
          - Plantillas, vistas de controladores de Thymeleaf

### 2) Creando un controlador y vista para el proyecto

    - Creamos el controlador (PACKAGE & CLASS -@Controller)
    
        - UN BUEN EJEMPLO VISTO!
            -> El METODO que controla la vista del index, va a retornar la vista del HTML
            Dicho HTML tiene que ser guardado en RESOURCES/TEMPLATES
        - Colocamos el get mapping con las vistas para el home

    - Creamos el HTML/vista que se va a mostrar en resources/templates (UTF-8 encoding)

### 3) Pasar datos desde el controlador a la vista

    - Ejemplo, pasar como argumento un 'Model' o 'ModelMap' o 'Map<>' o 'ModelAndView' al controlador handler index()
    - Desde thymeleaf, mandamos el atributo titulo generado en el metodo handler al html para el titulo

### 4) Anotacion @RequestMapping sobre el controlador

    - Colocamos el @RequestMapping("/app") -> Base para todos los metodos
    - Se utiliza mucho para los CRUD's! La ruta podria ser.. cliente/crear | cliente/modificar | cliente/eliminar   
    - Tendriamos que crear otro controlador para la pagina de inicio del proyecto sin el @RequestMapping("/app")

### 5) El objeto Model!

    - Creamos un package para el 'Model'
    - Creamos la clase para manejar los Usuarios (el modelo) con sus atributos, getters y setters!
    - Luego creamos el controlador para poder ver en la vista los datos del usuario que queremos
    - SOLO PARA ESTE MOMENTO! 
        - Utilizaremos datos estaticos desde el controlador, mas adelante con Hibernate, JPA y el uso de un repositorio de la
        base de datos, vamos a mostrar los usuarios desde alli!
    - Creamos la vista para 'perfil' y mostramos el usuario con nombre y Apellido

### 6) Directiva If de thymeleaf!

    - Validar mediante flujo de control en las Vistas, variables != null.. etc.
    - Lo hacemos con el ejemplo -> email, agregamos en el Model del user con getter y setter
    - Luego agregaremos el IF dentro del thymeleaf para cuando exista o no el email!
        -> th:if="${usuario.email}" DENTRO DEL SPAN! 
        -> else: th:if="${usuario.email == null}" y en th:text="'No tiene correo'"

    - AHORA CON UN ARREGLO
        -> un nuevo @RequestMapping para listar, devolviendo la VISTA
        y creando un LIST<> array para el almacenamiento de usuarios
        -> Creamos la vista y mostramos con el th:if="${usuarios.size() == 0}"

### 7) Directiva EACH, ForEACH para iterar dentro de thymeleaf

    - Necesitamos agregar elementos a la lista, por eso generemos el metodo constructor
    en el Model de Usuario.
    - Una vez agregado los constructores, agregamos elementos a la Lista
        -> usuarios.add(new Usuario("Pablo", "Lencinas", "pabloagus@gmail.com"));
    - Mostramos en la vista con <table> y el each para listar los usuarios.

    - PARA SIMPLIFICAR!

        -> SE PUEDE UTILIZAR 'ARRAYS' EN VEZ DE ARRAYLIST EN EL CONTROLADOR

### 8) Anotacion @ModelAttribute 

    - ES COMUN A TODOS LOS METODOS DEL CONTROLADOR!
    - Otra forma de pasar datos a la VISTA -> @ModelAttribute
    - Creamos un metodo nuevo en el controlador para enviar el objeto que queremos pasar a la vista
    En este caso, una lista de usuarios -> Retornamos a la vista en el objeto ('usuarios')
    
    - Ejemplo cuando queremos pasar una cantidad de SELECT, pasamos todos esos datos desde el ModelAttribute

### 9) Anotacion @RequestParam, enviar parametros mediante URL a los controladores o tambien llamado, parametro Query

    - Nuevo controlador -> EjemploParamsController
    - Creamos el @Controller & @RequestMapping("/params")
    - Creamos el dir para el params/ver en templates y la plantilla ver
    - Para obtener el parametro @RequestParam
    - Enviamos el parametro a la vista con el /params/string?=texto:Hola que haces!
    

    -> Como crear nuestras rutas URL, LINKS CON PARAMETROS, con thymeleaf

        - Otro controlador, @GetMapping public String index(){...
        - Creamos la vista y colocamos los metodos the thymeleaf correspondiente

### 10) Obtener varios parametros de la URL con @RequestParam

    - Ya enviamos solo texto, ahora un texto y un tipo numerico (integer)
    - Con @RequestParam y con HttpSrvletRequest creamos dos metodos mas para enviar
        -> @GetMapping(/mix-params) & @GetMapping(/mix-params-request)

### 11) Anotacion @PathVariable

    - Otra forma de mandar parametros mediante la ruta URL al controlador
    - Creamos un nuevo controller -> EjemploVariablesRutaController
    - Diferencia entre un @PathVariable y un @RequestParam?

        -> Las dos sirven para lo mismo, enviar parametros para la URL!!!!!!
        -> Uno mediante request http mediante get o parametro de query
        -> con @Path son parametros en la ruta de spring que mapeamos que justamente son variables
    
### 12) Obtener varios parámetros de la ruta con @PathVariable

    - Como enviar dos variables, dos parametros de la ruta!
    - Lo vemos todos en 'EjemploVariablesRutaController' y la vista asociada!

### 13) Agregando recursos estáticos y estilos CSS personalizados

    - Agregar CSS, JS y demas para nuestra aplicacion web
    - Va todo a resources/static

### 14) Inyectar valores usando la anotacion @Value

    - Obtener estos titulos, textos, usuarios de algun recurso o archivo de la app? Ejemplo un app.properties?
    - Simple!
        -> Llevar todo al application.properties 
        -> Usamos @Value
    - Esto seria INYECCION DE DEPENDECIA aplicado a texto, a strings que podemos guardar en application.properties


### 15) Agregando otros archivos properties personalizados para los textos

    - Otra forma de guardar estos textos en otro properties
    - Que pasa si tenemos muchos textos de varios controladores? No queremos tener un app.pro muy largo..
        DEJEMOS EL APLICATION.PROPERTIES SOLO PARA CONFIGURACIONES, NO PARA PASAR PARAMETROS A NINGUN LADO NI DEMAS
        SOLO CONFIGURACIONES!!!!!!!!!!!
        -> Creamos un nuevo properties (texto.properties) 
        -> Una vez creado tenemos que agregar una nueva clase en la raiz, para las configuraciones de este nuevo properties!
        -> @Configuration & @PropertySources({
		            @PropertySource("classpath:texto.properties")
            })

### 16) Retornando redirect y forward como respuesta en métodos del controlador

    - Otra forma de Respuesta -> Que pasa si quiero redirigir a otra ruta del proyecto o a otra url de internet?
        -> Diferencia entre redirigir o redirect & Cargar una vista?
            => Cuando se redirige se reinicia la peticion, una peticion desde 0 y todos los parametros del request se reinician
            => Cuando se carga una vista justamente pasamos parametros y renderizar ese HTML.

    - El FORWARD : En vez de redirigir a otra ruta y reiniciar el request, lo que hace es que dentro del mismo request va a ir
    al metodo handler que esta mapeado a esa tura sin reiniciar o recargar la pagina.

    - Creamos un nuevo controlador -> HomeController
        -> Si queremos redirigir a nuestro home : return  "redirect:/app/index" ; (NO PORQUE REDIRIGE A OTRO REQUEST! NONONO!)
        -> Si queremos redirigir a una pagina externa? return "redirect:/http://google.com";
    - Ahora si queremos sin reiniciar el reqquest, sin hacer un dispatcher -> forward
        -> return "forward:/app/index"; (LA MEJOR OPCION!)
        -> Vemos que el localhost:8090 SE MANTIENE! porque no redirige como el otro, nice!


### 17) Despliegue y ejecución desde terminal (deploy)

    - Generar nuestro proyecto con Maven para construir el .JAR para realizar el deploy!
    - archivo ejecutable 'mvnw' maven wrapper para generar un proyecto con maven package pero mas simple!
    - Necesitamos la VARIABLE DE ENTORNO JAVA.HOME DE NUESTRO SO!
        -> HACEMOS TODO EL PASO PARA EL export DEL PATH y demas!

    - Ejecutamos el .jar con java -jar 'direccion del .jar' Y VOILA! READY EL DEPLOY!
    - PODEMOS DEPLOYAR EN CUALQUIER LADO NUESTRA APP AHORA! VER MAS!
    - SUBIMOS EL JAR DONDE QUERAMOS Y LEVANTAR CON EL COMANDO!!! (java -jar 'dir') amazing! 

## LO PODEMOS LEVANTAR EN CUALQUIER LADO, ES LLEGAR CON EL .JAR Y LEVANTARLO EN CUALQUIER MAQUINA QUE TENGA JDK INSTALADO!

# ESO ES TODO PARA LA PRIMERA PARTE, SIGUE ABAJO

# PARA LA SECCION 3 VAMOS AL PROYECTO SPRING-BOOT-DI (INYECCION DE DEPENDENCIA)!
