# Sistema de Gestión de Capacitaciones (SGC)

## Módulo de organizaciones beneficiarias

### Descripción
Este proyecto corresponde al desarrollo del módulo de organizaciones beneficiarias del Sistema de Gestión de Capacitaciones (SGC). Su propósito es gestionar la información de las organizaciones registradas en el sistema.

### Tecnologías utilizadas
- Java 17.
- Maven.
- MariaDB.
- JDBC.
- Visual Studio Code.
- Git y GitHub.

### Estructura del proyecto

```text
sgc-organizaciones/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/sgc/
│   │           ├── conexion/
│   │           ├── dao/
│   │           ├── modelo/
│   │           └── principal/
│   └── test/
├── pom.xml
├── .gitignore
└── README.md
```

### Funcionalidades implementadas
El módulo contempla las operaciones CRUD para la gestión de organizaciones beneficiarias:

- Registrar organizaciones.
- Consultar el listado de organizaciones.
- Buscar organizaciones por su identificador.
- Actualizar la información de las organizaciones.
- Eliminar organizaciones.

### Base de datos
Se utiliza MariaDB con la base de datos `sgc_organizaciones` y la tabla `organizacion`.

La conexión se realiza mediante JDBC. La contraseña de la base de datos se obtiene mediante una variable de entorno denominada `SGC_DB_PASSWORD`.

### Control de versiones
El proyecto utiliza Git para el control de versiones y GitHub como repositorio remoto.

**Repositorio:** https://github.com/industrialdikeyla-cmyk/sgc-organizaciones