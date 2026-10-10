/**
 * This package contains the main classes that represent the data model of the system.
 * data model of the system. These classes encapsulate the logic related to equipment management, 
 * units and items, as well as the access facade to the data model.
 * 
 * Main classes:
 * 
 * - {@link ModelFacade}: Implements the Singleton pattern and acts as a facade to manage the access to 
 * operations on DAOs and application data.
 * - {@link EquipoDTO}: Represents an in-game team, which contains a list of assigned * units. 
 * assigned.
 * - {@link UnidadDTO}: Represents an in-game unit, with attributes such as life, attack, defense, * experience and type, 
 * experience and type.
 * - {@link PartidaDTO}: Represents a game game in the game, including the name, number of players, 
 * and the arrays containing both panels and units in the game.
 * - {@link TurnosDTO}: This class is about game turns, including the history of positions, the count of turns, the current turn, 
 * the number of moves in a turn, and the number of players.
 * This package is fundamental to the structure of the game, as it defines the core entities * and provides the structure for managing the game. 
 * and provides the structure to manage operations on them.
 * 
 * @see co.edu.unbosque.model.EquipoDTO
 * @see co.edu.unbosque.model.UnidadDTO
 * @see co.edu.unbosque.model.PartidaDTO
 * @see co.edu.unbosque.model.ModelFacade
 * @see co.edu.unbosque.model.TurnosDTO
 */
package co.edu.unbosque.model;