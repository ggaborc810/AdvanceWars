/**
 * This package contains the classes in charge of to handle the persistence of
 * game data, such as teams, units and games. In addition, it provides an
 * interface for CRUD operations and specific classes for file handling and
 * object serialization . file handling and object serialization.
 *
 * Classes included:
 *
 * - {@link EquipoDAO}: This class handles CRUD operations for the teams in the
 * game. It allows to create, update, delete and search for teams by their
 * color. In addition, it manages the creation and deletion of units within each
 * team.
 *
 * - {@link PartidaDAO}: Handles CRUD operations for games in the game. It
 * allows the addition.
 * 
 * - {@link UnidadDAO}: Provides CRUD operations for objects of type
 * {@link UnidadDTO}. Allows adding, updating and deleting units in the unit
 * list.
 * 
 * - {@link FileHandler}: Auxiliary class for file handling in the system.
 * Provides methods to read and write both serializable files and text files.
 *
 * - {@link CRUDOperation}: Interface that defines the basic operations for
 * creating, updating, - {@link}: Interface that defines the basic operations
 * for creating, updating, * * deleting and searching generic objects in the
 * system.
 * 
 * {@link EquipoCRUDOperation}: Interface that defines the specific CRUD
 * operations for the teams according to the color as an identifier. equipment
 * based on the color as key identifier.
 *
 * This architecture allows for a clear separation of responsibilities for as to
 * the persistence of the game data, which facilitates the maintainability and
 * scalability of the system.
 * 
 * @see co.edu.unbosque.model.persistence.EquipoDAO
 * @see co.edu.unbosque.model.persistence.PartidaDAO
 * @see co.edu.unbosque.model.persistence.UnidadDAO
 * @see co.edu.unbosque.model.persistence.FileHandler
 * @see co.edu.unbosque.model.persistence.CRUDOperation
 * @see co.edu.unbosque.model.persistence.EquipoCRUDOperation
 */
package co.edu.unbosque.model.persistence;
