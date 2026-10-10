# Advance Wars: Juego de estrategia por turnos

Juego de escritorio en Java inspirado en *Advance Wars*. De 2 a 4 jugadores compran unidades, las mueven por un mapa con distintos terrenos y se enfrentan en batallas animadas hasta que solo queda un ejército.

Proyecto de tercer corte de **Programación II**, tercer semestre de Ingeniería de Sistemas, Universidad El Bosque.

## Funcionalidades

- Partidas de **2, 3 o 4 jugadores**, cada uno con un ejército de color (rojo, verde, azul o amarillo).
- Compra de unidades con monedas (máximo 50 por jugador):
  - **Soldados**
  - **Tanques**
  - **Aviones**
- Mapa con terrenos y obstáculos: campos, caminos, ríos, puentes, árboles, montañas, casas, edificios y torres.
- Juego por turnos con movimiento de unidades y ataques.
- Animaciones de batalla para cada combinación de unidades y colores.
- Mejoras de vida y daño para las unidades.
- Menú de pausa para continuar, guardar o salir.
- Guardado y carga de partidas.
- Tutorial con imágenes y animaciones.
- Música de fondo y pantalla de fin de juego con el ganador.

## Tecnologías

- Java 22
- Java Swing para la interfaz gráfica
- Java Sound para la música
- Serialización de objetos para guardar las partidas
- Eclipse IDE

## Arquitectura

El proyecto sigue el patrón **Modelo-Vista-Controlador (MVC)**:

- `controller`: lógica del juego y manejo de eventos.
- `model`: clases de dominio (DTO): equipos, unidades, partidas y turnos.
- `model/persistence`: acceso a datos (DAO) y manejo de archivos.
- `view`: ventanas y paneles de la interfaz gráfica.
- `util/structure`: lista enlazada propia (`MyLinkedList`) usada para guardar los datos del juego.

Además usa los patrones **Facade** y **Singleton** (`ModelFacade` y `ViewFacade`).

## Documentación

- Javadoc en la carpeta `doc` (abrir `doc/index.html`).

## Cómo ejecutarlo

1. Tener instalado el JDK 22.
2. En Eclipse: **File > Import > Existing Projects into Workspace** y seleccionar la carpeta del proyecto.
3. Ejecutar la clase `co.edu.unbosque.controller.AplMain`.

Las partidas guardadas se crean en la carpeta `partidas` al jugar.

## Equipo

- Bustamante Castellanos Caren Sofia
- Hospital Herrera Dylan Mathyus
- Ramirez Chacon Alejandra Valenttina
- Ruiz Cruz Gabriel Alejandro
- Triana Mejia Juan Diego
- Vela Cardozo German Octavio
