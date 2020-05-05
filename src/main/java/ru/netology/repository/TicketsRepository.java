package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

@AllArgsConstructor
@NoArgsConstructor
public class TicketsRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = this.tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(this.tickets, 0, tmp, 0, this.tickets.length);
        tmp[tmp.length - 1] = ticket;
        this.tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found!");
        } else {
            int length = tickets.length - 1;
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (Ticket item : tickets) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            tickets = tmp;
        }
    }

    public Ticket[] getAll() {
        return tickets;
    }
}