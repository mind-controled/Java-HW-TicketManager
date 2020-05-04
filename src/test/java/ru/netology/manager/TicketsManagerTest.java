package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.domain.TicketsComparator;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketsManagerTest {
    private TicketsRepository ticketsRepository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(ticketsRepository);

    private Tickets testTicket1 = new Tickets(1, 1000, "MOW", "LED", 100);
    private Tickets testTicket2 = new Tickets(2, 1200, "LED", "MOW", 120);
    private Tickets testTicket3 = new Tickets(3, 1300, "MOW", "GOJ", 130);
    private Tickets testTicket4 = new Tickets(4, 1400, "GOJ", "MOW", 140);
    private Tickets testTicket5 = new Tickets(5, 1500, "MOW", "UFA", 150);
    private Tickets testTicket6 = new Tickets(6, 1600, "UFA", "MOW", 160);
    private Tickets testTicket7 = new Tickets(7, 1700, "MOW", "БЦН", 170);
    private Tickets testTicket8 = new Tickets(8, 1800, "БЦН", "MOW", 180);
    private Tickets testTicket9 = new Tickets(9, 1900, "MOW", "LED", 190);
    private Tickets testTicket10 = new Tickets(10, 2000, "LED", "MOW", 200);

    private Tickets ticketToAdd = new Tickets(999, 999, "XXX", "ZZZ", 999);

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
        Tickets[] expected = {
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
        Tickets[] actual = manager.findFromTo("MOW","LED");
        Tickets[] expected = {
                testTicket1,
                testTicket9
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindFromTo() {
        Tickets[] actual = manager.findFromTo("NY","MOW");
        Tickets[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSorted() {
        Tickets[] actual = manager.findFromToSorted("LED","MOW", new TicketsComparator());
        Tickets[] expected = {
                testTicket2,
                testTicket10
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNothing() {
        Tickets[] actual = manager.findFromToSorted("MOW","MOW", new TicketsComparator());
        Tickets[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
