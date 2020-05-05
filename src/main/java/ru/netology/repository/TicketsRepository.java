package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;

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

    public Ticket[] getAll() {
        return tickets;
    }
}