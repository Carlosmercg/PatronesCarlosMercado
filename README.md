# Parcial Final – Patrones de Diseño  
### Estudiante: **Carlos David Mercado Gallego**  
### Asignatura: *Patrones de Diseño de Software*

Este repositorio corresponde a la entrega del **parcial final** de la asignatura Patrones de Diseño de Software.  
Aquí se incluyen **tres aplicativos independientes**, cada uno ubicado en su propia carpeta dentro del repositorio.  
Los patrones trabajados son:

- **Flyweight**
- **Proxy**
- **Bridge + Factory**

A continuación se describe brevemente cada proyecto y se indican los requisitos necesarios para su ejecución.

---

## 📁 Estructura del Repositorio
/Flyweight_Supabase

/Proxy_Supabase

/Bridge_Factory

README.md


Cada carpeta contiene su propio código fuente, archivos de configuración y recursos.

---

## Flyweight – Gestión de Listas de Reproducción con Supabase

Este aplicativo implementa el patrón **Flyweight**, simulando la gestión de canciones y listas de reproducción con optimización de memoria mediante la reutilización de objetos.

### ✔ Requisitos en Supabase  
Debe existir una tabla llamada **`lista`** con los siguientes campos:

| Campo   | Tipo    | Descripción                          |
|---------|---------|--------------------------------------|
| `id`    | integer | Identificador único                  |
| `nombre`| text    | Nombre de la lista                   |
| `usos`  | integer | Cantidad de veces utilizada          |

### ✔ Archivo `config.properties`  
Debe existir en la carpeta `resources` el archivo:
config.properties

Con el siguiente contenido básico:
supabase.url=TU_URL

supabase.key=TU_ANON_KEY


---

## 🛡 Proxy – Proxy Auditado / No Auditado con Supabase

Este aplicativo implementa el patrón **Proxy**, usando además una **Factory** para decidir si el programa ejecuta un **proxy auditado** o **no auditado**, según la configuración definida por el usuario.

El programa solicita por consola:

- Usuario  
- Contraseña  
- Identificador del proceso a ejecutar  

El sistema valida que el usuario exista en Supabase antes de ejecutar cualquier proceso.

### ✔ Requisitos en Supabase  
Debe existir una tabla llamada **`usuarios`** con la siguiente estructura:

| Campo       | Tipo |
|-------------|------|
| `username`  | text |
| `password`  | text |

### ✔ Archivo `config.properties`  
Dentro de `resources`, el archivo debe seguir la estructura de:
config.example.properties
Incluyendo:
supabase.url=TU_URL
supabase.key=TU_ANON_KEY


---

## 🔐 Bridge + Factory – Encriptación Configurable

Este aplicativo implementa los patrones **Bridge** y **Factory**, permitiendo seleccionar dinámicamente el tipo de encriptación a utilizar mediante un archivo de configuración.

Este proyecto **no utiliza Supabase**.

Las clases disponibles dependen de la implementación (AES, RSA, SHA, etc.). Modificando este valor en el config.properties en src se cambia el tipo de encriptación utilizado.

---

## ✔ Conclusión

Este repositorio reúne los tres desarrollos correspondientes a los patrones:

- **Flyweight**
- **Proxy**
- **Bridge + Factory**

Cada proyecto está organizado en carpetas separadas y contiene sus respectivos archivos de configuración.  
Este repositorio representa la entrega completa del parcial final de Patrones de Diseño de Software.

---

