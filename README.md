# MyCar

App Android para explorar un catálogo de vehículos por marca, ver la ficha de cada uno y simular su alquiler, guardando el historial de alquileres en una base local.

![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-003B57?style=flat&logo=sqlite&logoColor=white)
![Status](https://img.shields.io/badge/status-en%20desarrollo-yellow)

## 📖 Sobre el proyecto

MyCar es un proyecto personal de app Android (Java, sin arquitectura MVVM) que simula el flujo de alquiler de un auto: elegir una marca, recorrer su catálogo de vehículos, ver el detalle de cada uno con fotos y ficha técnica, completar un formulario de alquiler con validaciones y guardar la reserva confirmada en una base de datos local (SQLite) para poder consultarla después.

Nació en el marco de un proyecto para una materia universitaria, y se mantiene como pieza de portfolio para practicar desarrollo Android nativo: Activities, Intents, adapters personalizados para `ListView`/`GridView`/`ViewPager`, validación de formularios y persistencia local con `SQLiteOpenHelper`.

## ✨ Funcionalidades

- Menú principal con acceso a Categorías, Alquileres e Información.
- Catálogo de vehículos por marca (Chevrolet, Ford, Toyota, Volkswagen) en una grilla de imágenes.
- Detalle de cada vehículo con carrusel de fotos (`ViewPager`) y ficha técnica (año, modelo, motor, plazas, kilometraje, precio por día).
- Formulario de alquiler con validaciones (campos obligatorios, solo letras en nombre/apellido, formas de pago aceptadas, límite de 1 a 365 días) y cálculo del total en tiempo real.
- Pantalla de resumen antes de confirmar el alquiler.
- Persistencia del alquiler confirmado en SQLite local.
- Historial de alquileres guardados, listado desde la base local.
- Pantalla de información/acerca de la app.

## 🏗️ Arquitectura

Proyecto Android de módulo único, sin capa de arquitectura (sin MVVM ni repositorio): cada `Activity` maneja su propia UI y, cuando corresponde, accede directamente a la base de datos.

```
app/src/main/java/com/proyectoapp/mycar/
├── MainActivity              → Menú principal
├── ListaActivity             → Lista de marcas/categorías
├── VehiculosActivity         → Galería de vehículos de una marca (GridView)
├── DetalleActivity           → Carrusel + ficha técnica de un vehículo (ViewPager)
├── AlquilerActivity          → Formulario de alquiler con validaciones
├── ResumenActivity           → Resumen y confirmación (guarda en SQLite)
├── ListaAlquileresActivity   → Historial de alquileres (lee de SQLite)
├── InformacionActivity       → Pantalla de información
├── ImageAdapter / DetalleAdapter → Adapters para GridView y ViewPager
└── AdminSQLiteOpenHelper     → Creación y acceso a la tabla `alquileres`
```

Los datos de los vehículos (nombres, precios, descripciones e imágenes) están hardcodeados en `DetalleActivity` y `VehiculosActivity`; no provienen de una API ni de una base remota.

## 🛠️ Stack técnico

| Capa | Tecnología |
|---|---|
| App | Android nativo (Java), AppCompat |
| UI | Layouts XML, `ViewPager`, `GridView`, `ListView`, Material Components |
| Persistencia | SQLite (`SQLiteOpenHelper`) para el historial de alquileres |
| Build | Gradle (Kotlin DSL) + Version Catalog (`libs.versions.toml`) |
| Testing | JUnit4, AndroidX Test, Espresso (configurado, sin tests propios todavía) |
| Compatibilidad | minSdk 25 · targetSdk / compileSdk 36 |

## 🚀 Instalación local

Requisitos: Android Studio reciente, JDK 11, SDK de Android 36, y un emulador o dispositivo físico con API 25+.

1. Cloná el repositorio:
   ```
   git clone https://github.com/Ismael-es/MyCarApp.git
   ```
2. Abrí la carpeta en Android Studio y dejá que sincronice Gradle (el proyecto incluye el wrapper, no hace falta instalar Gradle aparte).
3. Ejecutá la app con el botón **Run** ▶ sobre un emulador/dispositivo, o desde la terminal:
   ```
   ./gradlew installDebug
   ```
4. La app arranca en `MainActivity`. No requiere backend ni configuración adicional: los datos de vehículos son estáticos y el historial de alquileres se guarda en SQLite local en el propio dispositivo.

## 📂 Estructura del repositorio

```
├── app/
│   ├── src/main/java/com/proyectoapp/mycar/   # Activities, adapters y acceso a SQLite
│   ├── src/main/res/layout/                   # XMLs de cada pantalla
│   ├── src/main/res/drawable/                 # Íconos de marcas y fotos de vehículos
│   ├── src/main/res/values/                   # Strings, colores y temas
│   └── build.gradle.kts                       # Configuración del módulo app
├── gradle/                                    # Wrapper y version catalog (libs.versions.toml)
├── build.gradle.kts                           # Configuración del proyecto raíz
└── settings.gradle.kts                        # Módulos incluidos
```

## ⚠️ Notas y alcance

Este es un proyecto de aprendizaje/portfolio, no una app de alquiler de autos en producción. Algunas decisiones quedaron deliberadamente simples y son áreas conocidas de mejora:

- Los datos de vehículos (marca, modelo, precio, fotos) están hardcodeados en el código en vez de venir de una API o base de datos remota.
- No hay autenticación de usuarios ni backend: cada instalación tiene su propio historial local, sin sincronización entre dispositivos.
- Sin capa de arquitectura (MVVM/Repository): las `Activity` acceden directamente a `AdminSQLiteOpenHelper`.
- No hay migraciones de base de datos (`onUpgrade` está vacío).
- No hay tests automatizados escritos todavía, solo la configuración por defecto de Android Studio (JUnit/Espresso).

## 👤 Autor

Proyecto desarrollado por [Ismael-es](https://github.com/Ismael-es).
