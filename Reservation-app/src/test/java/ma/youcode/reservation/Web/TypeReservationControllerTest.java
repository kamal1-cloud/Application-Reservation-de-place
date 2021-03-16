package ma.youcode.reservation.Web;

import ma.youcode.reservation.Models.TypereservationEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.text.AttributedString;

import static org.junit.jupiter.api.Assertions.*;

class TypeReservationControllerTest {

    @Autowired
    TypeReservationController typeReservationController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listType() {
    }

//    @Test
//    void showNewTypeForm() {
//        typeReservationController = new TypeReservationController();
//
//        AttributedString model;
//        String result = typeReservationController.showNewTypeForm(model);
//        assertEquals(result, "new_type");
//    }

    @Test
    void saveEmployee() {
    }

    @Test
    void showEditTypeForm() {
    }

    @Test
    void deleteType() {
    }
}