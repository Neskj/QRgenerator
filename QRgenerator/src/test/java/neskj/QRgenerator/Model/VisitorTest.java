package neskj.QRgenerator.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VisitorTest {

    @Test
    public void testCreateVisitorSuccess() {

        Visitor testVisitor = new Visitor.Builder()
                .addOrganization("Diksy")
                .addSurname("Petrova")
                .addName("Galina")
                .addPatronymic("Viktorovna")
                .addSerial("4892")
                .addNumber("347284")
                .addDate("20.08.2026")
                .build();

        assertNotNull(testVisitor);
        assertEquals("Diksy", testVisitor.getOrganization());
        assertEquals("Petrova", testVisitor.getSurname());
        assertEquals("Galina", testVisitor.getName());
        assertEquals("Viktorovna", testVisitor.getPatronymic());
        assertEquals("4892", testVisitor.getSerial());
        assertEquals("347284", testVisitor.getNumber());
        assertEquals("20.08.2026", testVisitor.getDate());
    }
}
