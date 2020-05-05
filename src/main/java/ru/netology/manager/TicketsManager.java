package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class TicketsManager {
    private TicketsRepository ticketsRepository;

    public void add(Ticket offer) {
        ticketsRepository.save(offer);
    }

    public Ticket[] findFromTo(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket offer : ticketsRepository.getAll()) {
            int length = result.length;
            if (offer.getDeparture().equals(from) && offer.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        if (result.length != 1) {
            Arrays.sort(result);
        }
        return result;
    }

    public Ticket[] findFrom(String from) {
        Ticket[] result = new Ticket[0];

        for (Ticket offer : ticketsRepository.getAll()) {
            int length = result.length;
            if (offer.getDeparture().equals(from)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        if (result.length != 1) {
            Arrays.sort(result);
        }
        return result;
    }
}