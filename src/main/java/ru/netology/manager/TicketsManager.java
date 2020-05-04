package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Tickets;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class TicketsManager {
    private TicketsRepository ticketsRepository;

    public void add(Tickets offer) {
        ticketsRepository.save(offer);
    }

    public Tickets[] findFromTo(String from, String to) {
        Tickets[] result = new Tickets[0];

        for (Tickets offer : ticketsRepository.getAll()) {
            int length = result.length;
            if (offer.getDeparture().equals(from) && offer.getArrival().equals(to)) {
                Tickets[] tmp = new Tickets[length + 1];
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