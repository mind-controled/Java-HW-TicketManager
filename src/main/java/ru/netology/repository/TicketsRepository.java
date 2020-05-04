package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Tickets;
import ru.netology.exception.NotFoundException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsRepository {
    Tickets[] tickets = new Tickets[0];

    public void save(Tickets tickets) {
        int length = this.tickets.length + 1;
        Tickets[] tmp = new Tickets[length];
        System.arraycopy(this.tickets, 0, tmp, 0, this.tickets.length);
        tmp[tmp.length - 1] = tickets;
        this.tickets = tmp;
    }

    public Tickets findById(int id) {
        for (Tickets tickets : tickets) {
            if (tickets.getId() == id) {
                return tickets;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found!");
        } else {
            int length = tickets.length - 1;
            Tickets[] tmp = new Tickets[length];
            int index = 0;
            for (Tickets item : tickets) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            tickets = tmp;
        }
    }

    public Tickets[] getAll() {
        return tickets;
    }
}