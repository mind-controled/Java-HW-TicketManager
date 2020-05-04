package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets implements Comparable<Tickets> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    @Override
    public int compareTo(Tickets o) {
        return price - o.price;
    }
}