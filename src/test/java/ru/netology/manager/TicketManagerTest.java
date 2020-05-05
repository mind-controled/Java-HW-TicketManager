package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketsRepository ticketsRepository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(ticketsRepository);

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
    void shouldAddTicket() {
        manager.add(ticketToAdd);
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
        assertArrayEquals(expected, ticketsRepository.getAll());
    }

    @Test
    void shouldFindFromTo() {
        Ticket[] actual = manager.findFromTo("MOW", "БЦН");
        Ticket[] expected = {
                testTicket7
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindFromTo() {
        Ticket[] actual = manager.findFromTo("MOW", "ZZZ");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFrom() {
        Ticket[] actual = manager.findFrom("MOW");
        Ticket[] expected = {
                testTicket1,
                testTicket3,
                testTicket5,
                testTicket7,
                testTicket9
        };
        assertArrayEquals(expected, actual);
    }
}