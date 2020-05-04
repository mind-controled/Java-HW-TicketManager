package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets implements Comparable<ru.netology.domain.Tickets> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    @Override
    public int compareTo(ru.netology.domain.Tickets o) {
        return price - o.price;
    }
}