# ✈ Aerolínea LATAM - Sistema de Administración de Vuelos

Este es un programa en **Java** desarrollado para administrar los vuelos de la aerolínea **LATAM**, permitiendo gestionar **pasajeros, tripulantes, pilotos** y **datos personalizables** de cada vuelo. Incluye funcionalidades avanzadas para optimizar las operaciones aéreas, como:

- ✅ Servicios requeridos por los pasajeros.
- ✅ Registro de fallos en aviones.
- ✅ Necesidades especiales de cada vuelo (alimentos, personal especializado, etc.).

---

## 📸 Vista Previa
Descubre cómo luce el sistema con estas capturas de pantalla:

### Dashboard Principal
![Dashboard Principal](screenshots/DASHBOARDLATAM.png)

### Pantalla de Login
![Pantalla de Login](screenshots/LOGIN-LATAM.png)

### Gestión de Pasajeros
![Gestión de Pasajeros](screenshots/DASH-ADMIN_PASAJERO.png)

### Panel de control de vuelos
![Inicio Panel de control](screenshots/INIT-PAX.png)

### Reportes
![Dashboard Reportes](screenshots/DASH-REPORTES.png)

## 📷 Más Capturas
Explora más funcionalidades del sistema a continuación:

<details>
<summary>Gestión de Pasajeros y Servicios</summary>

- ![Asignación de Tripulación](screenshots/ASIGNAR_T-PAX.png)
- ![Asignación de Asientos](screenshots/ASIGNAR_PASAJERO-PAX.png)
- ![Gestión de Alimentos](screenshots/ALIMENTOS-PAX.png)
- ![Servicios Especiales](screenshots/SERVICIOS-ESPECIALES-GESTIONV.png)
- ![Maleta 1](screenshots/MALETA_1-ADMIN_PASAJERO.png)
- ![Editar Pasajero](screenshots/EP-ADMIN_PASAJERO.png)

</details>

<details>
<summary>Gestión de Vuelos y Tripulación</summary>

- ![Asignar Azafata](screenshots/CREAR_AZ-PAX.png)
- ![Asignar Piloto](screenshots/CREAR_PI-PAX.png)
- ![Ver Tripulación](screenshots/VER_TRIPULACION-PAX.png)
- ![Verificar Tripulante](screenshots/VERI_TRIPULANTE-GESTIONV.png)
- ![Crear Vuelo](screenshots/CREAR-PASAJE.png)

</details>

<details>
<summary>Reportes y Dashboards</summary>

- ![Reporte de Aviones](screenshots/AVIONES-REPORTES.png)
- ![Reporte de Pasajeros](screenshots/PASAJEROS-REPORTES.png)
- ![Reportes de Vuelos](screenshots/VUELOS-REPORTES.png)
- ![Dashboard Gestión de Vuelos](screenshots/DASH-GESTIONV.png)
- ![Dashboard Gestión de Vuelos](screenshots/SERVICIOS-ESPECIALES-GESTIONV.png)
- ![Elección de Vuelo](screenshots/EV-GESTIONV.png)

</details>

<details>
<summary>Verificación y Otros</summary>

- ![Verificar Vuelo 1](screenshots/VERIFICAR-VUELO1-PAX.png)
- ![Verificar Vuelo 2](screenshots/VERIFICAR-VUELO2-PAX.png)
- ![Verificar Pasajero](screenshots/VERIFICAR_PA-ADMINI_PASAJERO.png)
- ![Asignar Avión](screenshots/ASIGNAR_PASAJERO-PAX.png)

</details>

Explora todas las capturas en la [carpeta de capturas](screenshots/).

---

## 📌 Características Principales
- 📂 **Administración de Vuelos:** Creación, edición y eliminación de vuelos con detalles personalizados.
- 👨‍✈️ **Gestor de Tripulación:** Registro de pilotos, azafatas y personal de apoyo.
- 🎫 **Control de Pasajeros:** Check-in, asignación de asientos, y gestión de servicios adicionales.
- ⚠ **Registro de Fallos en Aviones:** Historial de mantenimiento y reporte de incidentes.
- 🍽 **Servicios Personalizados:** Gestión de alimentos, requerimientos especiales y asistencia a pasajeros.

---

## 🛠 Tecnologías Utilizadas
- 🔹 **Lenguaje:** Java 20
- 🔹 **IDE recomendado:** NetBeans / IntelliJ IDEA
- 🔹 **Gestor de Dependencias:** Maven
- 🔹 **Base de Datos:** SQL Server (scripts en `sql-scripts/`)
- 🔹 **Interfaz Gráfica:** Generada con NetBeans (archivos `.form`)

---

## 📥 Instalación y Configuración

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/jonathanjesus03/Proyecto-Aerolinea-Latam.git
cd Proyecto-Aerolinea-Latam
```

### 2️⃣ Importar en tu IDE
- Abre **NetBeans** o **IntelliJ IDEA**.
- Importa el proyecto como un proyecto **Maven**.
- Asegúrate de tener **JDK 20** instalado.

### 3️⃣ Configurar la Base de Datos
- Crea la base de datos en **SQL Server** usando los scripts en la carpeta `sql-scripts/`:
  - `BdProyectoPooAeropuerto.sql` para la estructura.
  - `Inserts.sql` para los datos iniciales.
  - `BdCredenciales.sql` para la tabla de autenticación.
- Ajusta la conexión en:
  ```
  src/main/java/Connectionbd/Connectiondb.java
  ```
  con tus credenciales de SQL Server.

### 4️⃣ Compilar y Ejecutar
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.mycompany.poo_recovery.POO_RECOVERY"
```

---

## 📋 Base de Datos

El proyecto utiliza **SQL Server** para almacenar los datos. Los scripts SQL están en la carpeta `sql-scripts/`:

- **Estructura**: `BdProyectoPooAeropuerto.sql`
- **Inserts**: `Inserts.sql` (incluye credenciales iniciales como `admin/admin`, `Jonathan/Jesus`, etc.)
- **Credenciales**: `BdCredenciales.sql`

⚙️ Configura la conexión en `Connectiondb.java` con tu servidor SQL.

---

## 🤝 Contribuciones

Siéntete libre de sugerir mejoras o reportar errores abriendo un **issue** en este repositorio.

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**.
