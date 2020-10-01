package lu.smarthome.housemanager.houses.entity;

import lu.smarthome.housemanager.houses.exception.HousePieceValidationException;
import lu.smarthome.housemanager.housespieces.HousePiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HousePieceTest {

    @Test
    void validate() {
        lu.smarthome.housemanager.housespieces.HousePiece housePiece = new lu.smarthome.housemanager.housespieces.HousePiece();
        housePiece.setHouseId(Long.MAX_VALUE);
        housePiece.setName("name");

        assertDoesNotThrow(housePiece::validBeforeCreation);
    }

    @Test
    void validateExceptions() {
        lu.smarthome.housemanager.housespieces.HousePiece housePiece = new HousePiece();

        assertThrows(HousePieceValidationException.class, housePiece::validBeforeCreation);

        housePiece.setName("name");
        assertThrows(HousePieceValidationException.class, housePiece::validBeforeCreation);

        housePiece.setHouseId(Long.MIN_VALUE);
        assertThrows(HousePieceValidationException.class, housePiece::validBeforeCreation);

    }

}