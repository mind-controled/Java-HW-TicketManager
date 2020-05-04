package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Tickets;

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

    public Tickets[] getAll() {
        return tickets;
    }
}