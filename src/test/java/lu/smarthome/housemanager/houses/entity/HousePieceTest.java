package lu.smarthome.housemanager.houses.entity;

import lu.smarthome.housemanager.houses.exception.RoomValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HousePieceTest {

    @Test
    void validate() {
        HousePiece housePiece = new HousePiece();
        housePiece.setHouseId(Long.MAX_VALUE);
        housePiece.setName("name");

        assertDoesNotThrow(housePiece::validBeforeCreation);
    }

    @Test
    void validateExceptions() {
        HousePiece housePiece = new HousePiece();

        assertThrows(RoomValidationException.class, housePiece::validBeforeCreation);

        housePiece.setName("name");
        assertThrows(RoomValidationException.class, housePiece::validBeforeCreation);

        housePiece.setHouseId(Long.MIN_VALUE);
        assertThrows(RoomValidationException.class, housePiece::validBeforeCreation);

    }

}