package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketsRepositoryTest {
    private TicketsRepository ticketsRepository = new TicketsRepository();

    private Ticket testTicket1 = new Ticket(1, 1000, "MOW", "LED", 100);
    private Ticket testTicket2 = new Ticket(2, 1200, "LED", "MOW", 120);
    private Ticket testTicket3 = new Ticket(3, 1300, "MOW", "GOJ", 130);
    private Ticket testTicket4 = new Ticket(4, 1400, "GOJ", "MOW", 140);
    private Ticket testTicket5 = new Ticket(5, 1500, "MOW", "UFA", 150);
    private Ticket testTicket6 = new Ticket(6, 1600, "UFA", "MOW", 160);
    private Ticket testTicket7 = new Ticket(7, 1700, "MOW", "БЦН", 170);
    private Ticket testTicket8 = new Ticket(8, 1800, "БЦН", "MOW", 180);
    private Ticket testTicket9 = new Ticket(9, 1900, "MOW", "LED", 190);
    private Ticket testTicket10 = new Ticket(10, 2000, "LED", "MOW", 200);
    private Ticket ticketToAdd = new Ticket(999, 999, "XXX", "ZZZ", 999);

    @BeforeEach
    void SetUp() {
        ticketsRepository.save(testTicket1);
        ticketsRepository.save(testTicket2);
        ticketsRepository.save(testTicket3);
        ticketsRepository.save(testTicket4);
        ticketsRepository.save(testTicket5);
        ticketsRepository.save(testTicket6);
        ticketsRepository.save(testTicket7);
        ticketsRepository.save(testTicket8);
        ticketsRepository.save(testTicket9);
        ticketsRepository.save(testTicket10);
    }

    @Test
    void shouldSaveAndGetAll() {
        ticketsRepository.save(ticketToAdd);
        Ticket[] expected = {
                testTicket1,
                testTicket2,
                testTicket3,
                testTicket4,
                testTicket5,
                testTicket6,
                testTicket7,
                testTicket8,
                testTicket9,
                testTicket10,
                ticketToAdd
        };
        Ticket[] actual = ticketsRepository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        ticketsRepository.removeById(1);
        Ticket[] actual = ticketsRepository.getAll();
        Ticket[] expected = {
                testTicket2,
                testTicket3,
                testTicket4,
                testTicket5,
                testTicket6,
                testTicket7,
                testTicket8,
                testTicket9,
                testTicket10
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNegative() {
        assertThrows(NotFoundException.class, () -> ticketsRepository.removeById(10000));
    }
}