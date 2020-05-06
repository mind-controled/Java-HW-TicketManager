package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@Data
public class TicketsManager {
    private TicketsRepository ticketsRepository;

    public void add(Ticket ticket) {
        ticketsRepository.save(ticket);
    }

    public Ticket[] findFromTo(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : ticketsRepository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findFromToSorted(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : ticketsRepository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public Ticket[] findFrom(String from) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : ticketsRepository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}